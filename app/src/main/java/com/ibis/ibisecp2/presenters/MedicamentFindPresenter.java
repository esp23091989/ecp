package com.ibis.ibisecp2.presenters;

import com.ibis.ibisecp2.ui.view.MedicamentFindView;

/**
 * Created by danila on 05.08.16.
 */
public abstract class MedicamentFindPresenter extends BasePresenter<MedicamentFindView> {
    public abstract void findMedicament(String name);
}
