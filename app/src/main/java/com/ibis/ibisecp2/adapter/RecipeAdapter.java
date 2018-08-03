package com.ibis.ibisecp2.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ibis.ibisecp2.R;
import com.ibis.ibisecp2.model.Recipe;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by danila on 23.12.15.
 */
public class RecipeAdapter extends RecyclerView.Adapter<RecipeAdapter.ViewHolder> {

    private LayoutInflater mLayoutInflater;
    private List<Recipe> recipeList;


    public RecipeAdapter(Context context, List<Recipe> recipeList) {
        super();
        mLayoutInflater = LayoutInflater.from(context);
        this.recipeList = recipeList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mLayoutInflater.inflate(R.layout.recipe_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Recipe recipe = recipeList.get(position);
        String name;
        if ("".equals(recipe.getMnn()) || "~".equals(recipe.getMnn())) {
            name = recipe.getTrn();
        } else {
            name = recipe.getMnn();
        }
        holder.textViewTitleRecept.setText(name);

        holder.textViewDateRecipe.setText(recipe.getRecipeDate());

        holder.textViewRecipeDosage.setText(recipe.getDosage());
        holder.textViewQuantity.setText(recipe.getQuantity().toString());
        holder.textViewRecipeDoc.setText(recipe.getFioDoc());
        holder.textViewRecipeSeries.setText(recipe.getRecipeSeries());
        holder.textViewRecipeNumber.setText(recipe.getRecipeNumber().toString());
    }


    @Override
    public int getItemCount() {
        return recipeList.size();
    }

    public void setRecipeList(List<Recipe> recipeList) {
        this.recipeList = recipeList;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.textViewTitleRecept)
        TextView textViewTitleRecept;
        @BindView(R.id.textViewDateRecipe)
        TextView textViewDateRecipe;
        @BindView(R.id.textViewRecipeDosage)
        TextView textViewRecipeDosage;
        @BindView(R.id.textViewQuantity)
        TextView textViewQuantity;
        @BindView(R.id.textViewRecipeDoc)
        TextView textViewRecipeDoc;
        @BindView(R.id.textViewRecipeSeries)
        TextView textViewRecipeSeries;
        @BindView(R.id.textViewRecipeNumber)
        TextView textViewRecipeNumber;


        public ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);

        }
    }
}
