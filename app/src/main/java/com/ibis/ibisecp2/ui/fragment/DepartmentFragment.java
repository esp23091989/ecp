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
import com.ibis.ibisecp2.helpers.DialogsHelper;
import com.ibis.ibisecp2.helpers.ShowHideLoadHelper;
import com.ibis.ibisecp2.listeners.ChooseDoctorListener;
import com.ibis.ibisecp2.listeners.DoctorListAdapterListener;
import com.ibis.ibisecp2.model.Doctor;
import com.ibis.ibisecp2.model.Patient;
import com.ibis.ibisecp2.presenters.DepartmentPresenter;
import com.ibis.ibisecp2.ui.view.DoctorView;
import com.ibis.ibisecp2.utils.AndroidUtils;
import com.ibis.ibisecp2.utils.SharedPreferencesUtils;
import com.ibis.ibisecp2.utils.ViewUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
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
public class DepartmentFragment extends BaseFragment implements DoctorView, ChooseDoctorListener,
        DoctorListAdapterListener {

    public static final String TAG = DepartmentFragment.class.getSimpleName();
    @BindView(R.id.tv_no_data)
    TextView tvNoData;
    @BindView(R.id.btn_update)
    Button btnUpdate;
    @BindView(R.id.ll_error)
    LinearLayout llError;
    @BindView(R.id.tvTitle)
    TextView tvClinicChoose;
    @BindView(R.id.recyclerViewDepartment)
    RecyclerView recyclerViewDepartment;
    @BindView(R.id.tvEmptyData)
    TextView tvEmptyData;
    @BindView(R.id.llDepartmentTitle)
    LinearLayout llDepartmentTitle;
    @BindView(R.id.cvDepartmentTitle)
    CardView cvDepartmentTitle;

    @Inject
    DepartmentPresenter presenter;
    @Inject
    SharedPreferencesUtils preferencesUtils;
    @Inject
    DialogsHelper mDialogsHelper;
    @Inject
    ShowHideLoadHelper mShowHideLoadHelper;

    Comparator comparator = new Comparator<Doctor>() {
        @Override
        public int compare(Doctor o1, Doctor o2) {
            return o1.getDeptCode().compareToIgnoreCase(o2.getDeptCode());
        }
    };
    Comparator sortByName = new Comparator<Doctor>() {
        @Override
        public int compare(Doctor o1, Doctor o2) {
            return o1.getDeptName().compareToIgnoreCase(o2.getDeptName());
        }
    };

    @BindView(R.id.swipeRefreshDepartment)
    SwipeRefreshLayout mSwipeRefreshDepartment;
    private String clinicId;
    private List<Doctor> doctorList = new ArrayList<>();
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
    private String cityId;

    public static DepartmentFragment newInstance(String clinicId) {
        DepartmentFragment fragment = new DepartmentFragment();
        fragment.clinicId = clinicId;
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
        presenter.getPatient();
        setupTitle(getString(R.string.title_choose_department));
        mLayoutManager = new LinearLayoutManager(getActivity());
        recyclerViewDepartment.setLayoutManager(mLayoutManager);
        recyclerViewDepartment.setHasFixedSize(true);
        mSwipeRefreshDepartment.setColorSchemeResources(R.color.colorAccent);
        mSwipeRefreshDepartment.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                getDoctors();
            }
        });
        departmentAdapter =
                new DoctorAdapter(getActivity(), new ArrayList<>(), this,
                        DoctorAdapter.DEPARTMENT);
        recyclerViewDepartment.setAdapter(departmentAdapter);
        return view;
    }

    @Override
    public void showDoctors(List<Doctor> doctorList) {
        mShowHideLoadHelper.hideLoad();
        mSwipeRefreshDepartment.setRefreshing(false);
        llError.setVisibility(View.GONE);
        if (doctorList != null && doctorList.size() > 0) {
            this.doctorList.clear();
            this.doctorList.addAll(doctorList);

            Set<Doctor> s = new TreeSet<>(comparator);
            s.addAll(this.doctorList);
            final List<Doctor> newList = new ArrayList(s);
            Collections.sort(newList, sortByName);
            departmentAdapter.setDoctorList(newList);
            departmentAdapter.notifyDataSetChanged();
            tvEmptyData.setVisibility(View.GONE);
        } else {
            tvEmptyData.setVisibility(View.VISIBLE);
            tvEmptyData.setText("Отсутствуют свободные для записи талоны");
        }

    }

    @Override
    public void showLoad() {
        mSwipeRefreshDepartment.setRefreshing(true);
    }

    @Override
    public void loadDoctors() {
        mSwipeRefreshDepartment.setRefreshing(true);
        presenter.loadFromInet(clinicId);
    }

    @Override
    public void showDoctorsError() {
        mShowHideLoadHelper.hideLoad();
        mSwipeRefreshDepartment.setRefreshing(false);
        llError.setVisibility(View.VISIBLE);
    }

    @Override
    public void showPatient(Patient patient) {
        mShowHideLoadHelper.hideLoad();
        tvClinicChoose.setText(patient.getClinicName());
        if (patient.getClinicAddress() != null) {
            tvClinicChoose.append(", адрес: " + patient.getClinicAddress());
        }
        if (patient.getClinicPhone() != null) {
            tvClinicChoose.append("\nТелефон: " + patient.getClinicPhone());
        }
        llDepartmentTitle.setVisibility(View.VISIBLE);
    }

    @OnClick(R.id.btn_update)
    public void onClick() {
        llError.setVisibility(View.GONE);
        getDoctors();
    }

    private void getDoctors() {
        mSwipeRefreshDepartment.setRefreshing(true);
        presenter.loadFromInet(clinicId);
    }

    @Override
    public void onDoctorClick(Doctor doctor) {
        presenter.openSpecialityScreen(doctor.getDeptCode());
    }

    @Override
    public void onDestroyView() {
        presenter.detachView();
        super.onDestroyView();
    }

    @Override
    public void onResume() {
        super.onResume();
        mSwipeRefreshDepartment.post(new Runnable() {
            @Override
            public void run() {
                mSwipeRefreshDepartment.setRefreshing(true);
                getDoctors();
            }
        });
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
        mSearchView.setOnSearchClickListener(v -> cvDepartmentTitle.setVisibility(View.GONE));
        mSearchView.setOnQueryTextListener(listener);
        ViewUtils.setOnActionExpandListener(searchItem, cvDepartmentTitle);
        mSearchView.setQueryHint(getString(R.string.title_search_department));
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

    /*
    @Subscribe(sticky = true)
    public void onCityEvent(City event) {
        EventBus.getDefault().removeStickyEvent(event);
        presenter.loadDoctors(event.getCityId());
    }*/
    public String getCityId() {
        return cityId;
    }

    public void setCityId(String cityId) {
        this.cityId = cityId;
    }

    public String getClinicId() {
        return clinicId;
    }

    public void setClinicId(String clinicId) {
        this.clinicId = clinicId;
    }

}
