package com.ibis.ibisecp2.ui.view;

import com.ibis.ibisecp2.model.Doctor;
import com.ibis.ibisecp2.model.FavoriteDoctor;

/**
 * Created by danila on 05.08.16.
 */
public interface EnrollView {
    void enroll();

    void showError(String msg);

    void showError();

    void createNotification();

    void onChangePassword(String msg);

    void showFavoriteDoctor(FavoriteDoctor doctor);

    void showDoctor(Doctor doctor);

    void showClinicInfo(String clinicInfo);
}
