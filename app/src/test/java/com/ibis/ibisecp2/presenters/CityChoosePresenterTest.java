package com.ibis.ibisecp2.presenters;

import com.ibis.ibisecp2.helpers.CityLoaderHelper;
import com.ibis.ibisecp2.helpers.DialogsHelper;
import com.ibis.ibisecp2.helpers.PatientHelper;
import com.ibis.ibisecp2.model.City;
import com.ibis.ibisecp2.model.CityResponse;
import com.ibis.ibisecp2.presenters.impl.CityChoosePresenterImpl;
import com.ibis.ibisecp2.ui.Navigator;
import com.ibis.ibisecp2.ui.view.CityChooseView;
import com.ibis.ibisecp2.utils.SharedPreferencesUtils;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;

import rx.Observable;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by danila on 23.11.16.
 */
@RunWith(MockitoJUnitRunner.class)
public class CityChoosePresenterTest {

    @Mock
    CityChooseView cityChooseView;
    @Mock
    DialogsHelper dialogsHelper;
    @Mock
    SharedPreferencesUtils preferencesUtils;
    @Mock
    CityLoaderHelper cityLoaderHelper;
    @Mock
    PatientHelper patientHelper;
    @Mock
    Navigator navigator;

    private CityChoosePresenterImpl presenter;

    @Before
    public void setUp() throws Exception {
        presenter =
                new CityChoosePresenterImpl(dialogsHelper, cityLoaderHelper, preferencesUtils,
                        patientHelper, navigator);
        presenter.attachView(cityChooseView);
    }

    @Test
    public void loadCity() throws Exception {
        CityResponse cityResponse = new CityResponse();
        ArrayList<City> cityList = new ArrayList<City>();
        cityList.add(new City());
        cityResponse.setCityList(cityList);

        when(cityLoaderHelper.getCity()).thenReturn(Observable.just(cityResponse));

        presenter.loadCity();
        ArgumentCaptor<ArrayList<City>> captor = new ArgumentCaptor<>();
        verify(cityChooseView, never()).showCityError();
        verify(cityChooseView).showCity(captor.capture());
        assertEquals(cityList.size(), captor.getValue().size());
    }
}