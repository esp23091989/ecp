package com.ibis.ibisecp2.dagger.module;

import android.app.Activity;

import com.ibis.ibisecp2.dagger.qualifier.PerActivity;
import com.ibis.ibisecp2.helpers.DialogsHelper;
import com.ibis.ibisecp2.helpers.ProgressDialogHelper;
import com.ibis.ibisecp2.helpers.ShowHideLoadHelper;
import com.ibis.ibisecp2.helpers.impl.DialogHelperImpl;
import com.ibis.ibisecp2.helpers.impl.ProgressDialogHelperImpl;
import com.ibis.ibisecp2.helpers.impl.ShowHideLoadHelperImpl;
import com.ibis.ibisecp2.presenters.AppointmentPresenter;
import com.ibis.ibisecp2.presenters.DiaryEditRecordsPresenter;
import com.ibis.ibisecp2.presenters.LoginPresenter;
import com.ibis.ibisecp2.presenters.LoginPresenter_;
import com.ibis.ibisecp2.presenters.MainPresenter;
import com.ibis.ibisecp2.presenters.MedicamentFindPresenter;
import com.ibis.ibisecp2.presenters.PersonalPresenter;
import com.ibis.ibisecp2.presenters.RegistryPagerPresenter;
import com.ibis.ibisecp2.presenters.StartPresenter;
import com.ibis.ibisecp2.presenters.impl.AppointmentPresenterImpl;
import com.ibis.ibisecp2.presenters.impl.DiaryEditRecordsPresenterImpl;
import com.ibis.ibisecp2.presenters.impl.LoginPresenterImpl;
import com.ibis.ibisecp2.presenters.impl.LoginPresenterImpl_;
import com.ibis.ibisecp2.presenters.impl.MainPresenterImpl;
import com.ibis.ibisecp2.presenters.impl.MedicamentFindPresenterImpl;
import com.ibis.ibisecp2.presenters.impl.PersonalPresenterImpl;
import com.ibis.ibisecp2.presenters.impl.RegistryPagerPresenterImpl;
import com.ibis.ibisecp2.presenters.impl.StartPresenterImpl;
import com.ibis.ibisecp2.ui.Navigator;

import dagger.Module;
import dagger.Provides;

/**
 * Created by danila on 26.06.16.
 */
@Module
public class ActivityModule {

    private Activity activity;

    public ActivityModule(Activity activity) {
        this.activity = activity;
    }

    @Provides
    @PerActivity
    Activity provideActivity() {
        return activity;
    }

    @Provides
    @PerActivity
    Navigator provideNavigator() {
        return new Navigator(activity);
    }

    @Provides
    @PerActivity
    DialogsHelper provideDialogsHelper(DialogHelperImpl dialogHelper) {
        return dialogHelper;
    }

    @Provides
    @PerActivity
    ProgressDialogHelper provideProgressDialogHelper(ProgressDialogHelperImpl progressDialogHelper) {
        return progressDialogHelper;
    }

    @Provides
    @PerActivity
    MedicamentFindPresenter provideMedicamentFindPresenter(MedicamentFindPresenterImpl presenter) {
        return presenter;
    }

    @Provides
    @PerActivity
    DiaryEditRecordsPresenter provideDiaryEditRecordsPresenter(DiaryEditRecordsPresenterImpl presenter) {
        return presenter;
    }

    @Provides
    @PerActivity
    StartPresenter provideStartPresenter(StartPresenterImpl presenter) {
        return presenter;
    }

    @Provides
    @PerActivity
    LoginPresenter_ provideLoginPresenter(LoginPresenterImpl_ presenter){
        return presenter;
    }

    @Provides
    @PerActivity
    AppointmentPresenter provideAppointmentPresenter(AppointmentPresenterImpl presenter) {
        return presenter;
    }

    @Provides
    @PerActivity
    RegistryPagerPresenter provideRegistryPagerPresenter(RegistryPagerPresenterImpl presenter) {
        return presenter;
    }

    @Provides
    @PerActivity
    public ShowHideLoadHelper provideShowHideLoadHelper(ShowHideLoadHelperImpl helper) {
        return helper;
    }

    @Provides
    @PerActivity
    MainPresenter provideMainPresenter(MainPresenterImpl presenter) {
        return presenter;
    }

    @Provides
    @PerActivity
    PersonalPresenter providePersonalPresenter(PersonalPresenterImpl presenter) {
        return presenter;
    }
}
