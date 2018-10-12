package com.ibis.ibisecp2.ui.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.CardView;
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
import com.ibis.ibisecp2.adapter.ClinicAdapter;
import com.ibis.ibisecp2.dagger.component.FragmentComponent;
import com.ibis.ibisecp2.helpers.DialogsHelper;
import com.ibis.ibisecp2.helpers.ShowHideLoadHelper;
import com.ibis.ibisecp2.listeners.OnItemAdapterListener;
import com.ibis.ibisecp2.listeners.OnSearchItemListener;
import com.ibis.ibisecp2.model.Clinic;
import com.ibis.ibisecp2.presenters.ClinicChoosePresenter;
import com.ibis.ibisecp2.ui.view.ClinicChooseView;
import com.ibis.ibisecp2.utils.AndroidUtils;
import com.ibis.ibisecp2.utils.ProgressDialogUtils;
import com.ibis.ibisecp2.utils.SharedPreferencesUtils;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ClinicChooseFragment extends BaseFragment implements ClinicChooseView,
        OnItemAdapterListener, OnSearchItemListener {

    @BindView(R.id.btn_update)
    Button btnUpdate;
    @BindView(R.id.ll_error)
    LinearLayout llError;
    @BindView(R.id.empty_text_view)
    TextView mEmptyTextView;
    @BindView(R.id.tv_no_data)
    TextView tvNoData;
    @BindView(R.id.rvClinic)
    RecyclerView rvClinic;
    @Inject
    ClinicChoosePresenter clinicChoosePresenter;
    @Inject
    SharedPreferencesUtils preferencesUtils;
    @Inject
    DialogsHelper dialogsHelper;
    @Inject
    ShowHideLoadHelper mShowHideLoadHelper;
    @BindView(R.id.tvTitle)
    TextView mTvTitle;
    @BindView(R.id.cvDepartmentTitle)
    CardView mCardView;
    @BindView(R.id.swipeRefreshClinic)
    SwipeRefreshLayout mSwipeRefreshClinic;

    private Context context;
    private String cityId;
    private Clinic clinic;
    private ClinicAdapter clinicAdapter;

    SearchView.OnQueryTextListener listener = new SearchView.OnQueryTextListener() {
        @Override
        public boolean onQueryTextSubmit(String query) {
            return false;
        }

        @Override
        public boolean onQueryTextChange(String newText) {
            if (clinicAdapter != null) {
                clinicAdapter.getFilter().filter(newText);
            }
            return false;
        }
    };
    private List<Clinic> clinicList = new ArrayList<>();
    private LinearLayoutManager mLayoutManager;

    public ClinicChooseFragment() {
    }

    public static ClinicChooseFragment newInstance(String cityId) {
        ClinicChooseFragment fragment = new ClinicChooseFragment();
        fragment.cityId = cityId;
        return fragment;
    }

    @Override
    void doInjection(FragmentComponent fragmentComponent) {
        fragmentComponent.inject(this);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_find_clinics, container, false);
        ButterKnife.bind(this, view);
        clinicChoosePresenter.attachView(this);
        mShowHideLoadHelper.hideLoad();
        mSwipeRefreshClinic.setColorSchemeResources(R.color.colorAccent);
        mSwipeRefreshClinic.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                clinicChoosePresenter.loadClinic(cityId);
            }
        });
        mSwipeRefreshClinic.post(new Runnable() {
            @Override
            public void run() {
                mSwipeRefreshClinic.setRefreshing(true);
                clinicChoosePresenter.loadClinic(cityId);
            }
        });
        context = getActivity();
        mLayoutManager = new LinearLayoutManager(getActivity());
        rvClinic.setLayoutManager(mLayoutManager);
        rvClinic.setVisibility(View.INVISIBLE);
        setupClinicAdapter(context);
        setupTitle(getString(R.string.title_choose_clinic));
        return view;
    }

    private void setupClinicAdapter(Context context) {
        clinicAdapter = new ClinicAdapter(context, clinicList, this, this);
        rvClinic.setAdapter(clinicAdapter);
    }

    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
        ProgressDialogUtils.hideProgressDialog();
        AndroidUtils.hideKeyboard(getView());
    }

    @Override
    public void onDestroyView() {
        clinicChoosePresenter.detachView();
        super.onDestroyView();
    }

    @Override
    public void showClinic(List<Clinic> clinicList) {
        this.clinicList = clinicList;
        mSwipeRefreshClinic.setRefreshing(false);
        if (clinicList == null || clinicList.isEmpty()) {
            mEmptyTextView.setText(getString(R.string.title_list_empty));
            mEmptyTextView.setVisibility(View.VISIBLE);
            rvClinic.setVisibility(View.GONE);
        } else {
            mEmptyTextView.setVisibility(View.GONE);
            rvClinic.setVisibility(View.VISIBLE);
            clinicAdapter.setClinicList(clinicList);
        }
    }

    @Override
    public void showClinicError() {
        mSwipeRefreshClinic.setRefreshing(false);
        llError.setVisibility(View.VISIBLE);
    }

    @Override
    public void onClickClinic(Clinic clinic) {
    }

    @Override
    public void setupCity(String city) {
        if (city == null) {
            mCardView.setVisibility(View.GONE);
        } else {
            mCardView.setVisibility(View.VISIBLE);
            mTvTitle.setText(city);
        }
    }

    @OnClick(R.id.btn_update)
    public void onClick() {
        mSwipeRefreshClinic.setRefreshing(true);
        llError.setVisibility(View.GONE);
        clinicChoosePresenter.loadClinic(cityId);
    }

    @Override
    public <T> void onItemClick(T t) {
        clinic = (Clinic) t;
        clinicChoosePresenter.savePatient(clinic, cityId);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        // Do something that differs the Activity's menu here
        inflater.inflate(R.menu.menu_clinic, menu);
        MenuItem searchItem = menu.findItem(R.id.action_search);
        SearchView mSearchView = (SearchView) searchItem.getActionView();
        mSearchView.setOnQueryTextListener(listener);
        mSearchView.setQueryHint(getString(R.string.title_search_clinic));
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_hospital_near_me:
                clinicChoosePresenter.openClinicNearMeFragment();
                return true;
            case R.id.menu_city:
                clinicChoosePresenter.openCityFragment();
                return true;
            case R.id.menu_doctor_favorites:
                clinicChoosePresenter.openFavoriteDoctors();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void onEmpty(boolean isEmpty) {
        if (isEmpty) {
            mEmptyTextView.setText("Больницы не найдены");
            mEmptyTextView.setVisibility(View.VISIBLE);
            rvClinic.setVisibility(View.GONE);
        } else {
            mEmptyTextView.setVisibility(View.GONE);
            rvClinic.setVisibility(View.VISIBLE);
        }
    }
}
