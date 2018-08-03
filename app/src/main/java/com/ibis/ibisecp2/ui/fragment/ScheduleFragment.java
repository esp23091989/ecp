package com.ibis.ibisecp2.ui.fragment;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
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
import com.ibis.ibisecp2.adapter.ScheduleAdapter;
import com.ibis.ibisecp2.dagger.component.FragmentComponent;
import com.ibis.ibisecp2.events.ChooseTimeEvent;
import com.ibis.ibisecp2.helpers.ShowHideLoadHelper;
import com.ibis.ibisecp2.listeners.OnItemAdapterListener;
import com.ibis.ibisecp2.model.Schedule;
import com.ibis.ibisecp2.presenters.DataChoosePresenter;
import com.ibis.ibisecp2.ui.view.DataChooseView;
import com.ibis.ibisecp2.utils.AndroidUtils;
import com.ibis.ibisecp2.utils.AutoFitGridLayoutManager;
import com.ibis.ibisecp2.utils.SharedPreferencesUtils;
import com.ibis.ibisecp2.utils.TextUtils;
import com.ibis.ibisecp2.utils.ViewUtils;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.ibis.ibisecp2.ui.viewutils.AnimationView.runLayoutAnimation;

/**
 * Created by danila on 03.12.15.
 */
public class ScheduleFragment extends BaseFragment implements DataChooseView, OnItemAdapterListener {
    public static final String TAG = ScheduleFragment.class.getSimpleName();

    @BindView(R.id.linearLayoutChooseData)
    LinearLayout linearLayoutChooseData;
    @BindView(R.id.ll_error)
    LinearLayout llError;
    @BindView(R.id.tv_no_data)
    TextView tvNoData;
    @BindView(R.id.btn_update)
    Button btnUpdate;
    @BindView(R.id.textViewChooseDataTitle)
    TextView textViewChooseDataTitle;
    @BindView(R.id.tvTitle)
    TextView tvTitle;
    @BindView(R.id.llDepartmentTitle)
    LinearLayout llDepartmentTitle;
    @Inject
    DataChoosePresenter dataChoosePresenter;
    @Inject
    SharedPreferencesUtils preferencesUtils;
    @Inject
    ShowHideLoadHelper mShowHideLoadHelper;
    @BindView(R.id.rvSchedule)
    RecyclerView mRvSchedule;
    @BindView(R.id.swipeRefreshSchedule)
    SwipeRefreshLayout mSwipeRefreshSchedule;

    private ScheduleAdapter scheduleAdapter;
    private String clinicId;
    private String profCode;
    private String doctorId;
    private String depCode;
    private String positionCode;
    private String beginDate;
    private String speciality;
    private String docName;
    private String depName;
    private String depAddress;
    private String note;

    public static ScheduleFragment newInstance(String clinicId, String depCode, String doctorId,
                                               String profCode, String positionCode,
                                               String beginDate, String speciality, String docName,
                                               String depName, String depAddress) {
        ScheduleFragment fragment = new ScheduleFragment();
        fragment.clinicId = clinicId;
        fragment.doctorId = doctorId;
        fragment.depCode = depCode;
        fragment.profCode = profCode;
        fragment.positionCode = positionCode;
        fragment.beginDate = beginDate;
        fragment.speciality = speciality;
        fragment.docName = docName;
        fragment.depName = depName;
        fragment.depAddress = depAddress;
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

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_choose_data, container, false);
        ButterKnife.bind(this, rootView);
        dataChoosePresenter.attachView(this);
        mSwipeRefreshSchedule.setColorSchemeResources(R.color.colorAccent);
        mSwipeRefreshSchedule.post(new Runnable() {
            @Override
            public void run() {
                mSwipeRefreshSchedule.setRefreshing(true);
                dataChoosePresenter.loadSchedule(clinicId, depCode, doctorId, profCode, positionCode, beginDate);
            }
        });
        mSwipeRefreshSchedule.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                dataChoosePresenter.loadSchedule(clinicId, depCode, doctorId, profCode, positionCode, beginDate);
            }
        });
        setupTitle(getString(R.string.title_shedule));
        ViewUtils.addTextView(getActivity(), llDepartmentTitle, speciality);
        ViewUtils.addTextView(getActivity(), llDepartmentTitle, docName);
        mRvSchedule.setLayoutManager(new AutoFitGridLayoutManager(getActivity(),
                AndroidUtils.dpToPx(95)));
        scheduleAdapter = new ScheduleAdapter(getActivity(), new ArrayList<>(), this);
        mRvSchedule.setAdapter(scheduleAdapter);
        tvTitle.setText(TextUtils.spanGreyText(depName, depAddress, getActivity()));
        return rootView;
    }

    private void setupData(List<Schedule> scheduleItems) {
        textViewChooseDataTitle.setVisibility(View.VISIBLE);
        if (scheduleItems == null || scheduleItems.size() == 0) {
            textViewChooseDataTitle.setText("Свободного времени нет");
        } else {
            textViewChooseDataTitle.setText("Выбор даты приема");
            scheduleAdapter.setScheduleList(scheduleItems);
            runLayoutAnimation(mRvSchedule);
            linearLayoutChooseData.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void onDestroyView() {
        dataChoosePresenter.detachView();
        super.onDestroyView();
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void showSchedule(List<Schedule> scheduleList) {
        mSwipeRefreshSchedule.setRefreshing(false);
        setupData(scheduleList);
        mShowHideLoadHelper.hideLoad();
    }

    @Override
    public void addSchedule(List<Schedule> scheduleList) {
        scheduleAdapter.addScheduleList(scheduleList);
    }

    @Override
    public void showScheduleError() {
        mSwipeRefreshSchedule.setRefreshing(false);
        mShowHideLoadHelper.hideLoad();
        llError.setVisibility(View.VISIBLE);
        tvNoData.setVisibility(View.GONE);
    }

    @OnClick(R.id.btn_update)
    public void onClick() {
        dataChoosePresenter.loadSchedule(clinicId, depCode, doctorId, profCode, positionCode, beginDate);
        mShowHideLoadHelper.showLoad();
        llError.setVisibility(View.GONE);
    }


    @Override
    public void onStart() {
        if (!EventBus.getDefault().isRegistered(this)) {
            EventBus.getDefault().register(this);
        }
        super.onStart();
    }

    @Override
    public void onStop() {
        if (EventBus.getDefault().isRegistered(this)) {
            EventBus.getDefault().unregister(this);
        }
        super.onStop();
    }

    @Subscribe(sticky = true)
    public void onChoosenDate(ChooseTimeEvent event) {
        EventBus.getDefault().removeStickyEvent(event);
        dataChoosePresenter.openEnrollScreen(event.getSheduleId(), event.getTime(),
                doctorId, event.getType(), note);
    }


    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        // Do something that differs the Activity's menu here
        inflater.inflate(R.menu.menu_choose, menu);
        MenuItem searchItem = menu.findItem(R.id.action_search);
        searchItem.setVisible(false);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_hospital:
                dataChoosePresenter.openClinicScreen();
                break;
            case R.id.menu_city:
                dataChoosePresenter.openCityScreen();
                break;
            case R.id.menu_doctor:
                dataChoosePresenter.openDoctorScreen();
                break;
            case R.id.menu_hospital_near_me:
                dataChoosePresenter.openClinicNearMeScreen();
                break;
            case R.id.menu_doctor_favorites:
                dataChoosePresenter.openDoctorsFavoritesScreen();
                break;
            default:
                break;
        }

        return false;
    }


    @Override
    public <T> void onItemClick(T t) {
        Schedule schedule = (Schedule) t;
        dataChoosePresenter.loadFreeTime(schedule);
        note = schedule.getScheduleInfo();
    }
}
