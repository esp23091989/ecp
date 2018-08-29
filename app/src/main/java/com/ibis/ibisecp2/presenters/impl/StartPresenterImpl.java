package com.ibis.ibisecp2.presenters.impl;

import android.util.Log;

import com.ibis.ibisecp2.events.NewPatientrRegistredEvent;
import com.ibis.ibisecp2.helpers.AuthHelper;
import com.ibis.ibisecp2.helpers.DialogsHelper;
import com.ibis.ibisecp2.helpers.PatientHelper;
import com.ibis.ibisecp2.model.AuthResponse;
import com.ibis.ibisecp2.model.Child;
import com.ibis.ibisecp2.model.EsiaTokenMarker;
import com.ibis.ibisecp2.model.Patient;
import com.ibis.ibisecp2.model.Warning;
import com.ibis.ibisecp2.presenters.StartPresenter;
import com.ibis.ibisecp2.ui.Navigator;
import com.ibis.ibisecp2.ui.activity.InfoActivity;
import com.ibis.ibisecp2.ui.activity.LoginActivity;
import com.ibis.ibisecp2.utils.RxUtil;
import com.ibis.ibisecp2.utils.SharedPreferencesUtils;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import javax.inject.Inject;

import rx.Observable;
import rx.Observer;
import rx.SingleSubscriber;
import rx.functions.Func1;

/**
 * Created by danila on 09.08.16.
 */
public class StartPresenterImpl extends StartPresenter {

    private static final int REQUEST_CODE_ESIA_MARKER = 10001;

    private SharedPreferencesUtils preferencesUtils;
    private DialogsHelper dialogsHelper;
    private List<Patient> patientList = Collections.emptyList();
    private PatientHelper patientHelper;
    private final AuthHelper authHelper;
    private final RxUtil rxUtil;
    private Navigator navigator;

    @Inject
    public StartPresenterImpl(SharedPreferencesUtils preferencesUtils, DialogsHelper dialogsHelper,
                              PatientHelper patientHelper, AuthHelper authHelper, RxUtil rxUtil, Navigator navigator) {
        this.preferencesUtils = preferencesUtils;
        this.dialogsHelper = dialogsHelper;
        this.patientHelper = patientHelper;
        this.authHelper = authHelper;
        this.rxUtil = rxUtil;
        this.navigator = navigator;
    }

    @Override
    public void getPatients() {
        if (subscription != null) {
            subscription.unsubscribe();
        }
        subscription = patientHelper.getPatientList().subscribe(new Observer<List<Patient>>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(List<Patient> patients) {
                if (isViewAttached()) {
                    patientList.clear();
                    patientList = patients;
                    view.showPatients(patientList);
                }
            }
        });
    }

    @Override
    public void openMainScreen() {
        navigator.openMainScreen(false);
        navigator.getActivity().finish();
    }

    @Override
    public void openDialogCall() {
        dialogsHelper.createDialogCall();
    }

    @Override
    public void openInfoScreen() {
        navigator.openScreen(InfoActivity.class);
    }

    @Override
    public void start(boolean hasError) {
        if (hasError) {
            savePatient();
        } else {
            startMainActivity();
        }
    }

    private void startMainActivity() {
        if (preferencesUtils.getPatientId() != -1
                && preferencesUtils.getPassword()) {
            openMainScreen();
        } else {
            getPatients();
        }
    }

    @Override
    public void savePatient() {
        preferencesUtils.hasPassword(false);
        view.savePatient();
//        preferencesUtils.savePacient(patient);
//        subscription = patientHelper.savePatient(patient).subscribe(new Observer<Boolean>() {
//            @Override
//            public void onCompleted() {
//
//            }
//
//            @Override
//            public void onError(Throwable e) {
//
//            }
//
//            @Override
//            public void onNext(Boolean aBoolean) {
//                if (isViewAttached()) {
//                    view.savePatient();
//                }
//            }
//        });
    }

    @Override
    public void deletePatient(Patient patient) {
        if (subscription != null) {
            subscription.unsubscribe();
        }
        subscription = patientHelper.deletePatient(patient).subscribe(new Observer<Boolean>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(Boolean aBoolean) {
                if (isViewAttached()) {
                    view.deletePatient();
                }
            }
        });
    }

    public List<Patient> getPatientList() {
        return patientList;
    }

    @Override
    public void login() {
        if (subscription != null) {
            subscription.unsubscribe();
        }
        subscription = patientHelper.getPatientList().subscribe(new Observer<List<Patient>>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(List<Patient> patients) {
                if (isViewAttached()) {
                    if (patients.isEmpty()) {
                        navigator.openScreenForResult(LoginActivity.class, REQUEST_CODE_ESIA_MARKER);
                    } else {
                        navigator.openListPatientFragment();
                    }
                }
            }
        });
    }

    @Override
    public void interruptRequest() {
        if (subscription != null) subscription.unsubscribe();
    }

    @Override
    public void getPatient() {
        EsiaTokenMarker marker = preferencesUtils.getEsiaMarker();
        subscription = authHelper.auth(marker)
                .compose(rxUtil.schedulers())
                .doOnSubscribe(() -> view.showLoad())
                .doOnEach((s) -> {
                    view.hideLoad();
                })
                .subscribe(new SingleSubscriber<AuthResponse>() {
                    @Override
                    public void onSuccess(AuthResponse authResponse) {
                        Patient patient = authResponse.getPatient();
                        if (patient != null) {
                            if (patient.getError() == null) {
                                if (patient.getSNILS() != null) {
                                    patient = authResponse.getPatient();
                                    patient.set_id(Long.parseLong(patient.getSNILS()
                                            .replaceAll("-", "").replace(" ", "")));
                                    patient.setSNILS(patient.getSNILS().replaceAll("-", "")
                                            .replace(" ", ""));
                                    getPatient(patient);
                                } else {
                                    view.errorLoginMsg("Чтобы пользоваться приложением необходима как минимум Стандартная учетная запись Госуслуг, в которой СНИЛС должен быть введен и верефицирован.");
                                }
                            } else {
                                view.errorLoginMsg(patient.getError().getErrorText() == null ? "Ошибка авторизации" : patient.getError().getErrorText());
                            }
                        } else {
                            if (authResponse.getError() != null) {
                                if (isViewAttached()) {
                                    if (authResponse.getError().getCode() == -1) {
                                        view.errorLoginMsg("Ошибка в данных пользователя. Обратитесь в контакт-центр по тел. 88001008603");
                                    } else {
                                        view.errorLoginMsg(authResponse.getError().getErrorText());
                                    }
                                }

                            }
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
                            view.errorLoginMsg("Ошибка сохранения пользователя");
                        }
                    }

                    @Override
                    public void onNext(Boolean aBoolean) {
                        EventBus.getDefault().postSticky(new NewPatientrRegistredEvent());
                        if (isViewAttached()) {
                            view.savePatient();
                            if (patient.getChildren() != null && patient.getChildren().size() > 0) {
                                navigator.openListPatientFragment();
                            } else {
                                navigator.openMainScreen(true);
                            }
                        }
                    }
                });
    }
}
