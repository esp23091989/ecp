package com.ibis.ibisecp2.presenters;

import com.ibis.ibisecp2.model.Schedule;
import com.ibis.ibisecp2.ui.view.DataChooseView;

/**
 * Created by danila on 04.08.16.
 */
public abstract class DataChoosePresenter extends BasePresenter<DataChooseView> {
    public abstract void loadSchedule(String clinicId, String depCode, String doctorId,
                                      String profCode, String positionCode, String beginDate);

    public abstract void loadFreeTime(Schedule dateMonth);

    public abstract void openEnrollScreen(String scheduleId, String time, String doctorId,
                                          String type, String note);

    public abstract void openCityScreen();

    public abstract void openClinicScreen();

    public abstract void openClinicNearMeScreen();

    public abstract void openDoctorScreen();

    public abstract void openDoctorsFavoritesScreen();
}
