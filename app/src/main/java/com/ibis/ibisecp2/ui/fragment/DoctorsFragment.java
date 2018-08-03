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
import com.ibis.ibisecp2.presenters.DoctorsPresenter;
import com.ibis.ibisecp2.ui.Navigator;
import com.ibis.ibisecp2.ui.view.DoctorsView;
import com.ibis.ibisecp2.utils.AndroidUtils;
import com.ibis.ibisecp2.utils.SharedPreferencesUtils;
import com.ibis.ibisecp2.utils.TextUtils;
import com.ibis.ibisecp2.utils.ViewUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by danila on 25.11.15.
 */
public class DoctorsFragment extends BaseFragment implements DoctorListAdapterListener, DoctorsView {

    public static final String TAG = DoctorsFragment.class.getSimpleName();
    @BindView(R.id.tv_no_data)
    TextView tvNoData;
    @BindView(R.id.btn_update)
    Button btnUpdate;
    @BindView(R.id.ll_error)
    LinearLayout llError;
    @BindView(R.id.cvDepartmentTitle)
    CardView cvDepartmentTitle;
    @BindView(R.id.recyclerViewDepartment)
    RecyclerView recyclerViewDepartment;
    @BindView(R.id.tvTitle)
    TextView tvTitle;
    @BindView(R.id.llDepartmentTitle)
    LinearLayout llDepartmentTitle;
    @Inject
    Navigator navigator;
    @Inject
    SharedPreferencesUtils preferencesUtils;
    @Inject
    DoctorsPresenter presenter;
    @Inject
    ShowHideLoadHelper mShowHideLoadHelper;
    @BindView(R.id.swipeRefreshDepartment)
    SwipeRefreshLayout mSwipeRefreshDepartment;

    Comparator sort = (Comparator<Doctor>) (o1, o2) ->
            o1.getSpecialityName().compareToIgnoreCase(o2.getSpecialityName());
    private LinearLayoutManager mLayoutManager;
    private DoctorAdapter doctorAdapter;
    SearchView.OnQueryTextListener listener = new SearchView.OnQueryTextListener() {
        @Override
        public boolean onQueryTextSubmit(String query) {
            return false;
        }

        @Override
        public boolean onQueryTextChange(String newText) {
            if (doctorAdapter != null) {
                doctorAdapter.getFilter().filter(newText);
            }
            return false;
        }
    };
    private String positionName;
    private String depCode;

    public DoctorsFragment() {
    }

    public static DoctorsFragment newInstance(String positionName, String depCode) {
        DoctorsFragment fragment = new DoctorsFragment();
        fragment.depCode = depCode;
        fragment.positionName = positionName;
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
        if (positionName != null && depCode != null) {
            presenter.loadDoctors(depCode);
            doctorAdapter =
                    new DoctorAdapter(getActivity(), new ArrayList<>(), this,
                            DoctorAdapter.DOCTORS_BY_SPEC);
        } else {
            presenter.getDoctors();
            doctorAdapter =
                    new DoctorAdapter(getActivity(), new ArrayList<>(), this, DoctorAdapter.DOCTORS);
        }
        setupTitle(getString(R.string.title_choose_doctors));
        mShowHideLoadHelper.showLoad();
        mLayoutManager = new LinearLayoutManager(getContext());
        recyclerViewDepartment.setLayoutManager(mLayoutManager);
        recyclerViewDepartment.setAdapter(doctorAdapter);
        recyclerViewDepartment.setHasFixedSize(true);
        mSwipeRefreshDepartment.setEnabled(false);
        return view;
    }

    @Override
    public void showDoctors(List<Doctor> doctorList, boolean bySpeciality) {
        mShowHideLoadHelper.hideLoad();
        List<Doctor> doctors = new ArrayList<>();
        if (bySpeciality) {
            if (doctorList != null && doctorList.size() > 0) {
                tvTitle.setText(TextUtils.spanGreyText(doctorList.get(0).getDeptName(),
                        doctorList.get(0).getDeptAddress(), getActivity()));
                ViewUtils.addTextView(getActivity(), llDepartmentTitle, positionName);
                for (Doctor doc : doctorList) {
                    if (doc.getPositionName().equals(positionName)) {
                        doctors.add(doc);
                    }
                }
            }
        } else {
            if (doctorList != null && doctorList.size() > 0) {
                doctors.addAll(doctorList);
            }
        }
        Collections.sort(doctors, sort);
        doctorAdapter.setDoctorList(doctors);
    }

    @Override
    public void showPatient(Patient patient) {
        if (positionName == null && depCode == null) {
            tvTitle.setText(patient.getClinicName());
            if (patient.getClinicAddress() != null) {
                tvTitle.append(", адрес: " + patient.getClinicAddress());
            }
            if (patient.getClinicPhone() != null) {
                tvTitle.append("\nТелефон: " + patient.getClinicPhone());
            }
        }
    }

    @Override
    public void showDoctorsError() {
        mShowHideLoadHelper.hideLoad();
    }

    @OnClick(R.id.btn_update)
    public void onClick() {

    }

    @Override
    public void onDoctorClick(Doctor doctor) {
        navigator.openDataChooseFragment(preferencesUtils.getClinicId(),
                doctor.getDeptCode(), String.valueOf(doctor.getSnils()), doctor.getProfCode(),
                doctor.getPositionCode(), doctor.getNearestDate(), doctor.getPositionName(),
                doctor.getSpecialityName(), doctor.getDeptName(), doctor.getDeptAddress());
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
    public void onPause() {
        AndroidUtils.hideKeyboard(getView());
        super.onPause();
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        // Do something that differs the Activity's menu here
        inflater.inflate(R.menu.menu_choose, menu);
        MenuItem menuItem = menu.findItem(R.id.menu_doctor);
        menuItem.setVisible(positionName != null && depCode != null);
        MenuItem searchItem = menu.findItem(R.id.action_search);
        SearchView mSearchView = (SearchView) searchItem.getActionView();
        mSearchView.setOnQueryTextListener(listener);
        mSearchView.setOnSearchClickListener(v -> cvDepartmentTitle.setVisibility(View.GONE));
        ViewUtils.setOnActionExpandListener(searchItem, cvDepartmentTitle);
        mSearchView.setQueryHint(getString(R.string.title_search_doctors));
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_hospital:
                navigator.clearBackstack();
                navigator.openClinicFragment(preferencesUtils.getCityId());
                break;
            case R.id.menu_city:
                navigator.clearBackstack();
                navigator.openCityFragment();
                break;
            case R.id.menu_doctor:
                navigator.clearBackstack();
                presenter.openDoctorScreen();
                break;
            case R.id.menu_hospital_near_me:
                navigator.clearBackstack();
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
