package com.ibis.ibisecp2.presenters;

import com.ibis.ibisecp2.helpers.ClinicLoaderHelper;
import com.ibis.ibisecp2.helpers.DialogsHelper;
import com.ibis.ibisecp2.helpers.LocationHelper;
import com.ibis.ibisecp2.helpers.PatientHelper;
import com.ibis.ibisecp2.model.Clinic;
import com.ibis.ibisecp2.model.ClinicResponse;
import com.ibis.ibisecp2.presenters.impl.ClinicChoosePresenterImpl;
import com.ibis.ibisecp2.ui.Navigator;
import com.ibis.ibisecp2.ui.view.ClinicChooseView;
import com.ibis.ibisecp2.utils.SharedPreferencesUtils;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import rx.Observable;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by danila on 28.11.16.
 */
@RunWith(MockitoJUnitRunner.class)
public class ClinicChoosePresenterTest {

    @Mock
    DialogsHelper dialogsHelper;
    @Mock
    SharedPreferencesUtils preferencesUtils;
    @Mock
    PatientHelper patientHelper;
    @Mock
    ClinicLoaderHelper clinicLoaderHelper;
    @Mock
    LocationHelper locationHelper;
    @Mock
    Navigator navigator;

    @Mock
    ClinicChooseView cityChooseView;

    private ClinicChoosePresenterImpl presenter;

    @Before
    public void setUp() throws Exception {
        presenter = new ClinicChoosePresenterImpl(dialogsHelper, preferencesUtils, patientHelper,
                clinicLoaderHelper, navigator, locationHelper);
        presenter.attachView(cityChooseView);
    }

    @Test
    public void loadClinic() throws Exception {

        ClinicResponse cityResponse = new ClinicResponse();
        List<Clinic> clinicList = new ArrayList<Clinic>();
        clinicList.add(new Clinic());
        cityResponse.setData(clinicList);
        when(clinicLoaderHelper.getClinic("1")).thenReturn(Observable.just(cityResponse));

        presenter.loadClinic("1");

        ArgumentCaptor<List<Clinic>> captor = new ArgumentCaptor<>();
        verify(cityChooseView).showClinic(captor.capture());
        verify(cityChooseView, never()).showClinicError();
        assertEquals(clinicList.size(), captor.getValue().size());
    }

    @Test
    public void savePatient() throws Exception {

    }

    @Test
    public void openDoctorFragment() throws Exception {

    }

}