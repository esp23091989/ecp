package com.ibis.ibisecp2.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.ibis.ibisecp2.R;
import com.ibis.ibisecp2.adapter.CityAdapter;
import com.ibis.ibisecp2.dagger.component.FragmentComponent;
import com.ibis.ibisecp2.helpers.ShowHideLoadHelper;
import com.ibis.ibisecp2.listeners.OnItemAdapterListener;
import com.ibis.ibisecp2.model.City;
import com.ibis.ibisecp2.presenters.CityChoosePresenter;
import com.ibis.ibisecp2.ui.view.CityChooseView;
import com.ibis.ibisecp2.utils.AndroidUtils;

import java.util.ArrayList;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by danila on 20.11.15.
 */
public class CityChooseFragment extends BaseFragment implements CityChooseView,
        OnItemAdapterListener {

    public static final String CITY_LIST = "CITY_LIST";
    public static final String TAG = CityChooseFragment.class.getSimpleName();

    @Inject
    ShowHideLoadHelper mHideLoadHelper;

    @Inject
    CityChoosePresenter cityChoosePresenter;
    @BindView(R.id.tv_no_data)
    TextView tvNoData;
    @BindView(R.id.btn_update)
    Button btnUpdate;
    @BindView(R.id.ll_error)
    LinearLayout llError;
    @BindView(R.id.tv_choose_city_title)
    TextView tvChooseCityTitle;
    @BindView(R.id.rvCity)
    RecyclerView rvCity;

    private LinearLayoutManager mLayoutManager;
    private ArrayList<City> cityList;
    private CityAdapter cityAdapter;


    public CityChooseFragment() {
    }

    @Override
    void doInjection(FragmentComponent fragmentComponent) {
        fragmentComponent.inject(this);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
        setHasOptionsMenu(true);
    }

    @SuppressWarnings("unchecked")
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (savedInstanceState != null) {
            cityList = savedInstanceState.getParcelableArrayList(CITY_LIST);
        } else {
            cityList = null;
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_choose_city, container, false);
        ButterKnife.bind(this, view);
        cityChoosePresenter.attachView(this);
        mHideLoadHelper.showLoad();
        cityChoosePresenter.loadCity();
        setupTitle(getString(R.string.title_choose_city));
        mLayoutManager = new LinearLayoutManager(getActivity());
        rvCity.setLayoutManager(mLayoutManager);
        cityAdapter = new CityAdapter(getActivity(), new ArrayList<>(), this);
        rvCity.setAdapter(cityAdapter);

        return view;
    }

    @Override
    public void onDestroyView() {
        cityChoosePresenter.detachView();
        super.onDestroyView();

    }

    @Override
    public void onPause() {
        super.onPause();
        AndroidUtils.hideKeyboard(getView());
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        outState.putParcelableArrayList(CITY_LIST, cityList);
        super.onSaveInstanceState(outState);
    }

    @Override
    public void showCity(ArrayList<City> cityList) {
        mHideLoadHelper.hideLoad();
        this.cityList = cityList;
        if (this.cityList == null) {
            tvChooseCityTitle.setVisibility(View.VISIBLE);
            tvChooseCityTitle.setText(getString(R.string.title_list_empty));
        } else {
            tvChooseCityTitle.setVisibility(View.GONE);
            cityAdapter.setCityList(this.cityList);
        }

    }

    @Override
    public void showCityError() {
        mHideLoadHelper.hideLoad();
        llError.setVisibility(View.VISIBLE);
    }

    @OnClick(R.id.btn_update)
    public void onClick() {
        mHideLoadHelper.showLoad();
        llError.setVisibility(View.GONE);
        cityChoosePresenter.loadCity();
    }

    @Override
    public <T> void onItemClick(T t) {
        cityChoosePresenter.openClinicScreen(((City) t).getCityId(), ((City) t).getName());
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        // Do something that differs the Activity's menu here
        inflater.inflate(R.menu.menu_city, menu);
        MenuItem searchItem = menu.findItem(R.id.action_search);
        SearchView mSearchView = (SearchView) searchItem.getActionView();
        mSearchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                if (cityAdapter != null) {
                    cityAdapter.getFilter().filter(newText);
                }
                return false;
            }
        });
        mSearchView.setQueryHint(getString(R.string.title_search_city));
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_hospital_near_me:
                cityChoosePresenter.openClinicNearMeScreen();
                return true;
            case R.id.menu_doctor_favorites:
                cityChoosePresenter.openFavoriteDoctors();
                return true;
            default:
                break;
        }

        return false;
    }
}
