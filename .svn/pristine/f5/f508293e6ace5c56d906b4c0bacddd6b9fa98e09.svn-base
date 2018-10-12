package com.ibis.ibisecp2.ui.fragment;

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
import com.ibis.ibisecp2.adapter.DoctorAdapter;
import com.ibis.ibisecp2.dagger.component.FragmentComponent;
import com.ibis.ibisecp2.helpers.ShowHideLoadHelper;
import com.ibis.ibisecp2.listeners.DoctorListAdapterListener;
import com.ibis.ibisecp2.model.Doctor;
import com.ibis.ibisecp2.model.Patient;
import com.ibis.ibisecp2.presenters.SpecialityPresenter;
import com.ibis.ibisecp2.ui.activity.AppointmentActivity;
import com.ibis.ibisecp2.ui.view.DoctorView;
import com.ibis.ibisecp2.utils.AndroidUtils;
import com.ibis.ibisecp2.utils.SharedPreferencesUtils;
import com.ibis.ibisecp2.utils.TextUtils;
import com.ibis.ibisecp2.utils.ViewUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by danila on 30.11.15.
 */
public class SpecialityFragment extends BaseFragment implements DoctorListAdapterListener,
        DoctorView {

    public static final String TAG = SpecialityFragment.class.getSimpleName();
    @BindView(R.id.tv_no_data)
    TextView tvNoData;
    @BindView(R.id.btn_update)
    Button btnUpdate;
    @BindView(R.id.ll_error)
    LinearLayout llError;
    @BindView(R.id.recyclerViewDepartment)
    RecyclerView recyclerViewDepartment;
    @BindView(R.id.tvTitle)
    TextView tvTitle;
    @BindView(R.id.llDepartmentTitle)
    LinearLayout llDepartmentTitle;
    @BindView(R.id.cvDepartmentTitle)
    CardView cvDepartmentTitle;

    @Inject
    SpecialityPresenter presenter;
    @Inject
    SharedPreferencesUtils preferencesUtils;
    @Inject
    ShowHideLoadHelper mShowHideLoadHelper;
    @BindView(R.id.tvEmptyData)
    TextView mTvEmptyData;
    @BindView(R.id.swipeRefreshDepartment)
    SwipeRefreshLayout mSwipeRefreshDepartment;

    private String deptCode;
    private LinearLayoutManager mLayoutManager;
    private DoctorAdapter departmentAdapter;
    SearchView.OnQueryTextListener listener = new SearchView.OnQueryTextListener() {
        @Override
        public boolean onQueryTextSubmit(String query) {
            return false;
        }

        @Override
        public boolean onQueryTextChange(String newText) {
            // newText is text entered by user to SearchView
            if (departmentAdapter != null) {
                departmentAdapter.getFilter().filter(newText);
            }
            return false;
        }
    };

    public static SpecialityFragment newInstance(String deptCode) {
        SpecialityFragment fragment = new SpecialityFragment();
        fragment.deptCode = deptCode;
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
        View view = inflater.inflate(R.layout.fragment_department, container, false);
        ButterKnife.bind(this, view);
        presenter.attachView(this);
        setupTitle(getString(R.string.title_choose_spec));
        presenter.loadDoctors(deptCode);
        mSwipeRefreshDepartment.setEnabled(false);
        return view;
    }

    @Override
    public void showDoctors(List<Doctor> doctorList) {
        mShowHideLoadHelper.hideLoad();
        if (doctorList != null && doctorList.size() > 0) {
            ((AppointmentActivity) getActivity()).setupClinicName(tvTitle, llDepartmentTitle,
                    TextUtils.spanGreyText(doctorList.get(0).getDeptName(), doctorList.get(0).getDeptAddress(), getActivity()));
            mLayoutManager = new LinearLayoutManager(getContext());
            recyclerViewDepartment.setLayoutManager(mLayoutManager);
            Set<Doctor> set =
                    new TreeSet<>((o1, o2) -> o1.getPositionName()
                            .compareToIgnoreCase(o2.getPositionName()));
            set.addAll(doctorList);
            final List<Doctor> newList = new ArrayList(set);
            departmentAdapter =
                    new DoctorAdapter(getActivity(), newList, this,
                            DoctorAdapter.SPECIALITY);
            recyclerViewDepartment.setAdapter(departmentAdapter);
            recyclerViewDepartment.setHasFixedSize(true);

            mTvEmptyData.setVisibility(View.GONE);
        } else {
            mTvEmptyData.setVisibility(View.VISIBLE);
            mTvEmptyData.setText("Отсутствуют свободные для записи талоны");
        }
    }

    @OnClick(R.id.btn_update)
    public void onClick() {
        llError.setVisibility(View.GONE);
        presenter.loadDoctors(deptCode);
    }

    @Override
    public void onDoctorClick(Doctor doctor) {
        presenter.openDoctors(doctor);
    }


    @Override
    public void onDestroyView() {
        presenter.detachView();
        super.onDestroyView();
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void showLoad() {
        mShowHideLoadHelper.showLoad();
    }

    @Override
    public void loadDoctors() {

    }

    @Override
    public void showDoctorsError() {
        mShowHideLoadHelper.hideLoad();
        llError.setVisibility(View.VISIBLE);
    }

    @Override
    public void showPatient(Patient patient) {

    }

    @Override
    public void onPause() {
        AndroidUtils.hideKeyboard(getView());
        super.onPause();
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        // Do something that differs the Activity's menu here
        inflater.inflate(R.menu.menu_choose, menu);
        MenuItem searchItem = menu.findItem(R.id.action_search);
        SearchView mSearchView = (SearchView) searchItem.getActionView();
        mSearchView.setOnQueryTextListener(listener);
        mSearchView.setOnSearchClickListener(v -> cvDepartmentTitle.setVisibility(View.GONE));
        ViewUtils.setOnActionExpandListener(searchItem, cvDepartmentTitle);
        mSearchView.setQueryHint(getString(R.string.title_search_speciality));
        super.onCreateOptionsMenu(menu, inflater);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_hospital:
                presenter.openClinicScreen();
                break;
            case R.id.menu_city:
                presenter.openCityScreen();
                break;
            case R.id.menu_doctor:
                presenter.openDoctorScreen();
                break;
            case R.id.menu_hospital_near_me:
                presenter.openClinicNearMeScreen();
                break;
            case R.id.menu_doctor_favorites:
                presenter.openDoctorFavorite();
                break;
            default:
                break;
        }

        return false;
    }

}
