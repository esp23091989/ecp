package com.ibis.ibisecp2.presenters.impl;

import com.ibis.ibisecp2.helpers.DialogsHelper;
import com.ibis.ibisecp2.helpers.ScheduleLoaderHelper;
import com.ibis.ibisecp2.model.Schedule;
import com.ibis.ibisecp2.model.ScheduleResponse;
import com.ibis.ibisecp2.presenters.DataChoosePresenter;
import com.ibis.ibisecp2.ui.Navigator;
import com.ibis.ibisecp2.utils.SharedPreferencesUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import javax.inject.Inject;

import rx.Observable;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.functions.Func3;
import rx.schedulers.Schedulers;

/**
 * Created by danila on 04.08.16.
 */
public class DataChoosePresenterImpl extends DataChoosePresenter {

    private ScheduleLoaderHelper loadSchedule;
    private Navigator navigator;
    private String dateMonth;
    private SharedPreferencesUtils preferencesUtils;


    @Inject
    public DataChoosePresenterImpl(ScheduleLoaderHelper loadSchedule, DialogsHelper dialogsHelper,
                                   Navigator navigator, SharedPreferencesUtils preferencesUtils) {
        this.loadSchedule = loadSchedule;
        this.navigator = navigator;
        this.preferencesUtils = preferencesUtils;
    }

    @Override
    public void loadSchedule(String clinicId, String depCode, String doctorId,
                             String profCode, String positionCode, String beginDate) {
        if (subscription != null) subscription.unsubscribe();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
        Date date = null;
        //NullPointerException in version 55
        if (beginDate == null) {
            beginDate = "";
        }
        try {
            date = dateFormat.parse(beginDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        if (date != null) {
            Calendar currentCal = Calendar.getInstance();
            currentCal.setTime(date);
            //21 - api can return for 21 days schedule
            currentCal.add(Calendar.DATE, 21);
            String toDate = dateFormat.format(currentCal.getTime());
            currentCal.add(Calendar.DATE, 21);
            String toDateTwo = dateFormat.format(currentCal.getTime());

            //load three schedule, about for 63 days
            getAllSchedule(clinicId, depCode, doctorId, profCode, positionCode, beginDate,
                    toDate, toDateTwo);
        }
    }

    private void getAllSchedule(String clinicId, String depCode, String doctorId,
                                String profCode, String positionCode, String beginDate, String date1, String date2) {
        // here we are using zip operator to combine both request
        if (subscription != null) subscription.unsubscribe();
        subscription = Observable.zip(
                loadSchedule.getSchedule(clinicId, depCode, doctorId, profCode, positionCode,
                        beginDate).onErrorReturn(new Func1<Throwable, ScheduleResponse>() {
                    @Override
                    public ScheduleResponse call(final Throwable throwable) {
                        return new ScheduleResponse();
                    }
                }),

                loadSchedule.getSchedule(clinicId, depCode, doctorId, profCode, positionCode,
                        date1).onErrorReturn(new Func1<Throwable, ScheduleResponse>() {
                    @Override
                    public ScheduleResponse call(final Throwable throwable) {
                        return new ScheduleResponse();
                    }
                }), loadSchedule.getSchedule(clinicId, depCode, doctorId, profCode, positionCode,
                        date2).onErrorReturn(new Func1<Throwable, ScheduleResponse>() {
                    @Override
                    public ScheduleResponse call(final Throwable throwable) {
                        return new ScheduleResponse();
                    }
                }),
                new Func3<ScheduleResponse, ScheduleResponse, ScheduleResponse, List<Schedule>>() {
                    @Override
                    public List<Schedule> call(ScheduleResponse one,
                                               ScheduleResponse two,
                                               ScheduleResponse tree) {
                        List<Schedule> schedule1List = new ArrayList<>();
                        schedule1List.addAll(one.getSchedule1List());
                        schedule1List.addAll(two.getSchedule1List());
                        schedule1List.addAll(tree.getSchedule1List());
                        return schedule1List;
                    }
                })
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<List<Schedule>>() {
                    @Override
                    public void onCompleted() {
                        // do anything onComplete
                    }

                    @Override
                    public void onError(Throwable e) {
                        // handle error
                    }

                    @Override
                    public void onNext(List<Schedule> scheduleList) {
                        Set<Schedule> s = new TreeSet<>(new Comparator<Schedule>() {
                            @Override
                            public int compare(Schedule o1, Schedule o2) {
                                return o1.getScheduleDate().compareToIgnoreCase(o2.getScheduleDate());
                            }
                        });
                        s.addAll(scheduleList);
                        final List<Schedule> newList = new ArrayList(s);

                        Collections.sort(newList, comparatorByDate);
                        view.showSchedule(newList);
                    }
                });
    }

    Comparator comparatorByDate = new Comparator<Schedule>() {
        @Override
        public int compare(Schedule o1, Schedule o2) {
            return o1.getDate().compareTo(o2.getDate());
        }
    };

    @Override
    public void loadFreeTime(Schedule dateMonth) {
        this.dateMonth = dateMonth.getScheduleDate();
        navigator.openFreeTimeFragment(dateMonth);
    }

    @Override
    public void openEnrollScreen(String scheduleId, String time, String doctorId, String type,
                                 String note) {
        navigator.openEnrollFragment(scheduleId, time, dateMonth, doctorId, type, note);
    }

    @Override
    public void openCityScreen() {
        navigator.clearBackstack();
        navigator.openCityFragment();
    }

    @Override
    public void openClinicScreen() {
        navigator.clearBackstack();
        navigator.openClinicFragment(preferencesUtils.getCityId());
    }

    @Override
    public void openClinicNearMeScreen() {
        navigator.clearBackstack();
        navigator.openClinicNearMeFragment();
    }

    @Override
    public void openDoctorScreen() {
        navigator.clearBackstack();
        navigator.openDoctorsFragment();
    }

    @Override
    public void openDoctorsFavoritesScreen() {
        navigator.clearBackstack();
        navigator.openDoctorsFavoritesScreen();
    }
}
