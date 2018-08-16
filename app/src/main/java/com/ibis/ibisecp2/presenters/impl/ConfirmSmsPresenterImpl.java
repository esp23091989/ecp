package com.ibis.ibisecp2.presenters.impl;

import com.google.gson.Gson;
import com.ibis.ibisecp2.helpers.AuthHelper;
import com.ibis.ibisecp2.helpers.DialogsHelper;
import com.ibis.ibisecp2.helpers.PatientHelper;
import com.ibis.ibisecp2.model.AuthResponse;
import com.ibis.ibisecp2.model.Child;
import com.ibis.ibisecp2.model.ErrorResponse;
import com.ibis.ibisecp2.model.Patient;
import com.ibis.ibisecp2.model.Warning;
import com.ibis.ibisecp2.presenters.ConfirmSmsPresenter;
import com.ibis.ibisecp2.ui.Navigator;
import com.ibis.ibisecp2.utils.SharedPreferencesUtils;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.inject.Inject;

import retrofit2.adapter.rxjava.HttpException;
import rx.Observable;
import rx.Observer;
import rx.functions.Func1;

/**
 * Created by comp on 21.03.17.
 */

public class ConfirmSmsPresenterImpl extends ConfirmSmsPresenter {

    private Navigator navigator;
    private AuthHelper authHelper;
    private PatientHelper patientHelper;
    private SharedPreferencesUtils preferencesUtils;
    private DialogsHelper dialogsHelper;

    @Inject
    public ConfirmSmsPresenterImpl(Navigator navigator, AuthHelper authHelper,
                                   PatientHelper patientHelper,
                                   SharedPreferencesUtils preferencesUtils, DialogsHelper dialogsHelper) {
        this.navigator = navigator;
        this.authHelper = authHelper;
        this.patientHelper = patientHelper;
        this.preferencesUtils = preferencesUtils;
        this.dialogsHelper = dialogsHelper;
    }

    @Override
    public void confirm(String login, String code, boolean isSavePass) {
//        interruptRequest();
//        subscription = authHelper.auth(login, code, "code")
//                .subscribe(new Observer<AuthResponse>() {
//                    @Override
//                    public void onCompleted() {
//
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//                        Gson gson = new Gson();
//                        ErrorResponse error = null;
//                        try {
//                            error = gson.fromJson(((HttpException) e).response().errorBody().string(),
//                                    ErrorResponse.class);
//                        } catch (Exception e1) {
//                            e1.printStackTrace();
//                        }
//                        if (error != null && error.getError() != null && error.getError().getCode() == -2) {
//                            view.onErrorTryConfirm();
//                        } else {
//                            dialogsHelper.alertDialogError(e);
//                            view.onErrorConfirmOther();
//                        }
//
//                    }
//
//                    @Override
//                    public void onNext(AuthResponse response) {
//                        Patient patient = response.getPatient();
//                        if (patient != null) {
//                            if (patient.getError() == null) {
//                                if (patient.getSNILS() != null) {
//                                    patient = response.getPatient();
//                                    patient.set_id(Long.parseLong(patient.getSNILS()
//                                            .replaceAll("-", "").replace(" ", "")));
//                                    patient.setSNILS(patient.getSNILS().replaceAll("-", "")
//                                            .replace(" ", ""));
//                                    preferencesUtils.hasPassword(isSavePass);
//                                    getPatient(patient);
//                                } else {
//                                    view.errorLoginMsg("Чтобы пользоваться приложением необходима как минимум Стандартная учетная запись Госуслуг, в которой СНИЛС должен быть введен и верефицирован.");
//                                }
//                            } else {
//                                view.errorLoginMsg(patient.getError().getErrorText() == null ? "Ошибка авторизации" : patient.getError().getErrorText());
//                            }
//                        } else {
//                            if (response.getError() != null) {
//                                if (isViewAttached()) {
//                                    if (response.getError().getCode() == 3) {
//                                        view.onErrorConfirm();
//                                        // for new version get child
//                                    } else if (response.getError().getCode() == -1) {
//                                        view.errorLoginMsg("Ошибка в данных пользователя. Обратитесь в контакт-центр по тел. 88001008603");
//                                    } else {
//                                        view.errorLoginMsg(response.getError().getErrorText());
//                                    }
//                                }
//
//                            }
//                        }
//
//                    }
//
//                });
    }

    public void interruptRequest() {
        if (subscription != null) subscription.unsubscribe();
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

            if (!warnMsg.equals(""))
                view.onErrorChild("Ошибка в данных " + child + warnMsg
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
//                            view.errorLoginMsg("Ошибка сохранения пользователя");
                        }
                    }

                    @Override
                    public void onNext(Boolean aBoolean) {
                        if (isViewAttached()) {
//                            view.savePatient();
                            view.onSuccessConfirm();
                            if (patient.getChildren() != null && patient.getChildren().size() > 0) {
                                navigator.openListPatientFragment();
                            } else {
//                                openMainScreen();
                                navigator.openMainScreen(false);
                            }
                        }
                    }
                });
    }
}
