package com.ibis.ibisecp2.ui.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.ibis.ibisecp2.R;
import com.ibis.ibisecp2.adapter.RecipeAdapter;
import com.ibis.ibisecp2.dagger.component.FragmentComponent;
import com.ibis.ibisecp2.listeners.RecipeAdapterListener;
import com.ibis.ibisecp2.model.Recipe;
import com.ibis.ibisecp2.presenters.RecipePresenter;
import com.ibis.ibisecp2.ui.view.RecipeView;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by danila on 23.12.15.
 */
public class RecipeFragment extends BaseFragment implements RecipeView, RecipeAdapterListener {

    @Inject
    RecipePresenter recipePresenter;

    @BindView(R.id.recyclerViewRecipes)
    RecyclerView recyclerViewRecipes;
    @BindView(R.id.tvReceiptNo)
    TextView tvReceiptNo;
    @BindView(R.id.tv_no_data)
    TextView tvNoData;
    @BindView(R.id.progress_bar)
    ProgressBar progressBar;
    @BindView(R.id.btn_update)
    Button btnUpdate;
    @BindView(R.id.ll_error)
    LinearLayout llProgressBar;

    private Context context;
    private RecipeAdapter recipeAdapter;
    private List<Recipe> recipeList;
    private LinearLayoutManager mLayoutManager;


    @Override
    void doInjection(FragmentComponent fragmentComponent) {
        fragmentComponent.inject(this);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_receipe, container, false);
        ButterKnife.bind(this, view);
        recipePresenter.attachView(this);
        context = getActivity();
        llProgressBar.setVisibility(View.VISIBLE);
        tvReceiptNo.setVisibility(View.GONE);
        recipeList = new ArrayList<>();
        recipeAdapter = new RecipeAdapter(context, recipeList);
        mLayoutManager = new LinearLayoutManager(context);
        recyclerViewRecipes.setLayoutManager(mLayoutManager);
        recyclerViewRecipes.setAdapter(recipeAdapter);
        recipePresenter.getRecipes();
        return view;
    }

    @Override
    public void onRecipeClick() {

    }

    @Override
    public void onDestroyView() {
        recipePresenter.detachView();
        super.onDestroyView();
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
    }

    @Override
    public void showRecipe(List<Recipe> recipeList) {
        llProgressBar.setVisibility(View.GONE);
        if (recipeList.size() == 0) {
            tvReceiptNo.setVisibility(View.VISIBLE);
            recyclerViewRecipes.setVisibility(View.INVISIBLE);
        } else {
            tvReceiptNo.setVisibility(View.GONE);
            recyclerViewRecipes.setVisibility(View.VISIBLE);
            recipeAdapter.setRecipeList(Recipe.sortRecipeList(recipeList));
            recipeAdapter.notifyDataSetChanged();
        }
    }

    @Override
    public void showError() {
        llProgressBar.setVisibility(View.GONE);
        tvReceiptNo.setVisibility(View.VISIBLE);
        recyclerViewRecipes.setVisibility(View.INVISIBLE);
    }
}
