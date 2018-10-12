package com.ibis.ibisecp2.presenters;

import com.ibis.ibisecp2.helpers.DialogsHelper;
import com.ibis.ibisecp2.helpers.MedicamentFindHelper;
import com.ibis.ibisecp2.helpers.ProgressDialogHelper;
import com.ibis.ibisecp2.model.Medicament;
import com.ibis.ibisecp2.model.MedicamentResponse;
import com.ibis.ibisecp2.presenters.impl.MedicamentFindPresenterImpl;
import com.ibis.ibisecp2.ui.view.MedicamentFindView;

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
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by danila on 28.11.16.
 */
@RunWith(MockitoJUnitRunner.class)
public class MedicamentFindPresenterTest {

    @Mock
    MedicamentFindHelper medicamentFindHelper;
    @Mock
    ProgressDialogHelper dialogHelper;
    @Mock
    DialogsHelper helper;

    @Mock
    MedicamentFindView medicamentFindView;

    private MedicamentFindPresenterImpl presenter;

    @Before
    public void setUp() throws Exception {
        presenter = new MedicamentFindPresenterImpl(dialogHelper, helper, medicamentFindHelper);
        presenter.attachView(medicamentFindView);
    }

    @Test
    public void findMedicament() throws Exception {

        MedicamentResponse medicamentResponse = new MedicamentResponse();
        List<Medicament> medicamentList = new ArrayList<Medicament>();
        medicamentList.add(new Medicament());
        medicamentResponse.setMedicamentList(medicamentList);

        when(medicamentFindHelper.findMedicament("1")).thenReturn(Observable.just(medicamentResponse));
        presenter.findMedicament("1");

        ArgumentCaptor<List<Medicament>> captor = new ArgumentCaptor<>();
        verify(medicamentFindView).showMedicament(captor.capture());
        assertEquals(medicamentList.size(), captor.getValue().size());
    }

}