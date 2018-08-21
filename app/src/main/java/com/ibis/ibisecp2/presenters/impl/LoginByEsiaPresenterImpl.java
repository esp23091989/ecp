package com.ibis.ibisecp2.presenters.impl;

import android.util.Log;

import com.ibis.ibisecp2.events.NewPatientrRegistredEvent;
import com.ibis.ibisecp2.helpers.AuthHelper;
import com.ibis.ibisecp2.helpers.PatientHelper;
import com.ibis.ibisecp2.model.AuthResponse;
import com.ibis.ibisecp2.model.Child;
import com.ibis.ibisecp2.model.EsiaTokenMarker;
import com.ibis.ibisecp2.model.Patient;
import com.ibis.ibisecp2.model.Warning;
import com.ibis.ibisecp2.presenters.LoginByEsiaPresenter;
import com.ibis.ibisecp2.utils.RxUtil;
import com.ibis.ibisecp2.utils.SharedPreferencesUtils;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.inject.Inject;

import rx.Observable;
import rx.Observer;
import rx.SingleSubscriber;
import rx.functions.Func1;

public class LoginByEsiaPresenterImpl extends LoginByEsiaPresenter {

    private final SharedPreferencesUtils preferencesUtils;
    private final AuthHelper authHelper;
    private final RxUtil rxUtil;
    private final PatientHelper patientHelper;

    private EsiaTokenMarker marker;

    @Inject
    public LoginByEsiaPresenterImpl(
            SharedPreferencesUtils sharedPreferencesUtils,
            AuthHelper authHelper,
            RxUtil rxUtil,
            PatientHelper patientHelper) {
        this.preferencesUtils = sharedPreferencesUtils;
        this.authHelper = authHelper;
        this.rxUtil = rxUtil;
        this.patientHelper = patientHelper;
    }

    @Override
    public void saveEsiaMarker(EsiaTokenMarker marker) {
        preferencesUtils.saveEsiaMarker(marker);
        this.marker = marker;
    }

    @Override
    public void interruptRequest() {
        if (subscription != null) subscription.unsubscribe();
    }

    @Override
    public void getPatient() {
        subscription = authHelper.auth(marker)
                .compose(rxUtil.schedulers())
                .doOnSubscribe(() -> view.showLoading())
                .doOnEach((s) -> {
                    view.hideLoading();
                    view.refreshWebView();
                })
                .subscribe(new SingleSubscriber<AuthResponse>() {
                    @Override
                    public void onSuccess(AuthResponse authResponse) {
                        Log.d("","");
                        Patient patient = authResponse.getPatient();
                        if (patient.getSNILS() != null) {
                            patient = authResponse.getPatient();
                            patient.set_id(Long.parseLong(patient.getSNILS()
                                    .replaceAll("-", "").replace(" ", "")));
                            patient.setSNILS(patient.getSNILS().replaceAll("-", "")
                                    .replace(" ", ""));
                            preferencesUtils.hasPassword(false);
                            getPatient(patient);
                        } else {
                            view.errorLoginMsg("Чтобы пользоваться приложением необходима как минимум Стандартная учетная запись Госуслуг, в которой СНИЛС должен быть введен и верефицирован.");
                        }
                    }

                    @Override
                    public void onError(Throwable error) {
                        Log.d("", "");
                        view.errorLoginMsg("Ошибка авторизации");
                    }
                });
    }

    private void getPatient(Patient patient1) {
        interruptRequest();
        subscription = patientHelper.getPatient(patient1.get_id())
                .subscribe(new Observer<Patient>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(Patient patient) {
                        if (patient == null) {
                            savePatient(patient1);
                            updatePatient(patient1);
                        } else {
                            updatePatient(patient);
                            //warning update
                            patient.setWarnings(patient1.getWarnings());

                            if (patient1.getChildren() != null && patient1.getChildren().size() > 0) {
                                patient.setChildren(patient1.getChildren());
                            } else {
                                if (patient.getChildren() != null && patient.getChildren().size() > 0) {
                                    patient.setChildren(null);
                                }
                            }
                            if (patient1.getAddress() != null) {
                                patient.setAddress(patient1.getAddress());
                            }
                            if (patient1.getLatLng() != null) {
                                patient.setLatLng(patient1.getLatLng());
                            }
                            savePatient(patient);
                        }
                    }
                });
    }

    private void updatePatient(Patient patient) {
        preferencesUtils.saveSnils(patient.getSNILS());
        preferencesUtils.savePatientId(patient.get_id());
        preferencesUtils.saveCityId(patient.getCityId());
        preferencesUtils.saveClinicId(patient.getClinicId());
    }

    private void savePatient(Patient patient) {
        interruptRequest();

        List<Patient> patientsTemp = new ArrayList<>();
        if (patient.getChildren() != null) {
            for (Iterator<Child> childWar = patient.getChildren().iterator(); childWar.hasNext();) {
                Child child = childWar.next();
                Patient patient1 = new Patient();
                if (child.getSNILS() != null) {
                    patient1.set_id(Long.parseLong(child.getSNILS()
                            .replaceAll("-", "").replace(" ", "")));
                    patient1.setSNILS(child.getSNILS().replaceAll("-", "")
                            .replace(" ", ""));
                }
                patient1.setBirthDate(child.getBirthDate());
                patient1.setLastName(child.getLastName());
                patient1.setMiddleName(child.getMiddleName());
                patient1.setFirstName(child.getFirstName());
                patient1.setGender(child.getGender());
                patientsTemp.add(patient1);
            }
        }
        patientsTemp.add(0, patient);
        if (patient.getWarnings() != null) {
            String warnMsg = "";
            int warCount = 0;
            for(Iterator<Warning> iterWar = patient.getWarnings().iterator(); iterWar.hasNext();){
                Warning warning = iterWar.next();
                if (warning.getMessage() != null) {
                    warnMsg = String.format("%s\n\n%s", warnMsg, warning.getMessage());
                } else {
                    warnMsg = String.format("%s%s%s", warnMsg, "\n", patient.getFullName());
                }
                for(Iterator<Patient> iter = patientsTemp.iterator(); iter.hasNext();){
                    Patient pat = iter.next();
                    if(warning.getSNILS() == null){
                        if(pat.getSNILS() == null) {
                            warCount++;
                            //warnMsg = String.format("%s%s%s", warnMsg, "\n", pat.getFullName());
                            iter.remove();
                        }
                    } else {
                        if (warning.getSNILS().equals(pat.getSNILS()) && pat != patient) {
                            warCount++;
                            /*if (!warnMsg.equals("")) {
                                warnMsg = warnMsg + ",";
                            }
                            warnMsg = String.format("%s%s%s", warnMsg, "\n", pat.getFullName());*/
                            iter.remove();
                            break;
                        }
                    }
                }
            }

            String child = "ребенка:";
            if(warCount > 1){
                child = "детей:";
            }

            if(!warnMsg.equals(""))
                view.onErrorChild("Ошиб]ка в данных " + child + warnMsg
                        + ".\n\nОбратитесь в контакт-центр по тел. 88001008603");
        }

        subscription = patientHelper.savePatient(patient)
                .flatMap(new Func1<Boolean, Observable<Boolean>>() {
                    @Override
                    public Observable<Boolean> call(Boolean aBoolean) {
                        return patientHelper.savePatientList(patientsTemp);
                    }
                })
                .subscribe(new Observer<Boolean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        if (isViewAttached()) {
                            view.errorLoginMsg("Ошибка сохранения пользователя");
                        }
                    }

                    @Override
                    public void onNext(Boolean aBoolean) {
                        EventBus.getDefault().postSticky(new NewPatientrRegistredEvent());
                        if (isViewAttached()) {
                            view.savePatient();
//                            if (patient.getChildren() != null && patient.getChildren().size() > 0) {
//                                view.openPatientList();
//                            } else {
//                                view.openMainScreen();
//                            }
                            view.openPatientList();
                        }
                    }
                });
    }

}
