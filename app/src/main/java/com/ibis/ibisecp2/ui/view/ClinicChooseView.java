package com.ibis.ibisecp2.ui.view;

import com.ibis.ibisecp2.model.Clinic;

import java.util.List;

/**
 * Created by danila on 03.08.16.
 */
public interface ClinicChooseView {
    void showClinic(List<Clinic> clinicList);

    void showClinicError();

    void onClickClinic(Clinic clinic);

    void setupCity(String city);
}
