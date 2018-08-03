package com.ibis.ibisecp2.presenters.impl;

import com.ibis.ibisecp2.events.EventCalendar;
import com.ibis.ibisecp2.helpers.ChangeVisitHelper;
import com.ibis.ibisecp2.helpers.DialogsHelper;
import com.ibis.ibisecp2.helpers.DoctorLoaderHelper;
import com.ibis.ibisecp2.helpers.FavoritesDoctorsHelper;
import com.ibis.ibisecp2.helpers.PatientHelper;
import com.ibis.ibisecp2.model.Doctor;
import com.ibis.ibisecp2.model.FavoriteDoctor;
import com.ibis.ibisecp2.model.ItemResponse;
import com.ibis.ibisecp2.model.Patient;
import com.ibis.ibisecp2.model.Visit;
import com.ibis.ibisecp2.presenters.CreateVisitPresenter;
import com.ibis.ibisecp2.ui.Navigator;
import com.ibis.ibisecp2.ui.activity.AppointmentActivity;
import com.ibis.ibisecp2.ui.view.EnrollView;
import com.ibis.ibisecp2.utils.SharedPreferencesUtils;

import javax.inject.Inject;

import rx.Observable;
import rx.Observer;
import rx.functions.Func1;

/**
 * Created by danila on 05.08.16.
 */
public class CreateVisitPresenterImpl extends CreateVisitPresenter {
    private ChangeVisitHelper changeVisitHelper;
    private SharedPreferencesUtils preferencesUtils;
    private Navigator navigator;
    private DialogsHelper dialogsHelper;
    private PatientHelper mPatientHelper;
    private Patient mPatient;
    private Visit visit;
    private FavoritesDoctorsHelper mFavoritesDoctorsHelper;
    private DoctorLoaderHelper mDoctorLoaderHelper;


    @Inject
    public CreateVisitPresenterImpl(ChangeVisitHelper changeVisitHelper, SharedPreferencesUtils
            preferencesUtils, Navigator navigator, DialogsHelper dialogsHelper,
                                    PatientHelper patientHelper,
                                    FavoritesDoctorsHelper favoritesDoctorsHelper,
                                    DoctorLoaderHelper doctorLoaderHelper) {
        this.preferencesUtils = preferencesUtils;
        this.navigator = navigator;
        this.changeVisitHelper = changeVisitHelper;
        this.dialogsHelper = dialogsHelper;
        mPatientHelper = patientHelper;
        mFavoritesDoctorsHelper = favoritesDoctorsHelper;
        mDoctorLoaderHelper = doctorLoaderHelper;
    }

    @Override
    public void attachView(EnrollView view) {
        this.view = view;
    }

    @Override
    public void detachView() {
        this.view = null;
        if (subscription != null) subscription.unsubscribe();
    }


    @Override
    public void createVisit(String scheduleId, String doctorName, String specialityName,
                            String startOn) {
        unsubscribedSubscription();
        /**
         * 1 - create visit
         * 3 - cancel visit
         * */
        subscription = changeVisitHelper.changeVisit(scheduleId, 1)
                .subscribe(new Observer<ItemResponse>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        if (isViewAttached()) {
                            dialogsHelper.alertDialogError(e);
                            view.showError();
                        }
                    }

                    @Override
                    public void onNext(ItemResponse response) {
                        if (isViewAttached()) {
                            visit = new Visit();
                            visit.set_id(System.currentTimeMillis());
                            visit.setStartOn(startOn);
                            if (mPatient != null) {
                                visit.setAddress(mPatient.getClinicAddress());
                                visit.setClinicName(mPatient.getClinicName());
                            }
                            visit.setScheduleId(scheduleId);
                            visit.setDoctorName(doctorName);
                            visit.setCaseNumber(String.valueOf(response.getItem()));
                            visit.setSpecialityName(specialityName);
                            long defaultInterval = 60;
                            long time = preferencesUtils.getReminder() == 0 ? defaultInterval :
                                    preferencesUtils.getReminder();
                            visit.setTime(time);
                            view.enroll();
                        }
                    }
                });
    }

    @Override
    public void createNotification() {
        try {
            saveReminder(new EventCalendar(visit.get_id(), visit.getCaseNumber(),
                    navigator.createDayNotificationInCalendar(visit)));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void openMainScreen() {
        navigator.openScreen(AppointmentActivity.class);
        navigator.getActivity().finish();
    }

    @Override
    public void getDoctorById(long id) {
        unsubscribedSubscription();
        subscription = mFavoritesDoctorsHelper.getFavoriteDoctorById(id)
                .subscribe(new Observer<FavoriteDoctor>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        if (isViewAttached()) {
                            view.showError();
                        }
                    }

                    @Override
                    public void onNext(FavoriteDoctor doctor) {
                        if (doctor == null) {
                            getDoctor(id);
                        } else {
                            view.showFavoriteDoctor(doctor);
                        }
                    }
                });

    }

    private void showClinicInfo(Patient patient) {
        String info = patient.getClinicName();
        if (patient.getClinicAddress() != null)
            info = String.format("%s%s", info, ", адрес: " + patient.getClinicAddress());
        if (patient.getClinicPhone() != null)
            info = String.format("%s\nТелефон: %s", info, patient.getClinicPhone());
        view.showClinicInfo(info);
    }

    private void getDoctor(long id) {
        unsubscribedSubscription();
        subscription = mPatientHelper.getPatient(preferencesUtils.getPatientId())
                .flatMap(new Func1<Patient, Observable<Doctor>>() {
                    @Override
                    public Observable<Doctor> call(Patient patient) {
                        showClinicInfo(patient);
                        return mDoctorLoaderHelper.getDoctorById(id);
                    }
                }).subscribe(new Observer<Doctor>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        if (isViewAttached()) {
                            view.showError();
                        }
                    }

                    @Override
                    public void onNext(Doctor doctor) {
                        view.showDoctor(doctor);
                    }
                });
    }

    private void saveReminder(EventCalendar eventCalendar) {
        unsubscribedSubscription();
        subscription = changeVisitHelper.saveReminder(eventCalendar)
                .subscribe(new Observer<Boolean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        if (isViewAttached()) {
                            view.showError(e.getMessage());
                        }
                    }

                    @Override
                    public void onNext(Boolean aBoolean) {
                        if (isViewAttached()) {
                            view.createNotification();
                        }
                    }
                });
    }
}
