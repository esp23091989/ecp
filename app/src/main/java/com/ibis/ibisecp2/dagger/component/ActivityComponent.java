package com.ibis.ibisecp2.dagger.component;

import com.ibis.ibisecp2.dagger.module.ActivityModule;
import com.ibis.ibisecp2.dagger.qualifier.PerActivity;
import com.ibis.ibisecp2.ui.activity.AgreementActivity;
import com.ibis.ibisecp2.ui.activity.AppointmentActivity;
import com.ibis.ibisecp2.ui.activity.BaseActivity;
import com.ibis.ibisecp2.ui.activity.DiaryActivity;
import com.ibis.ibisecp2.ui.activity.DiaryNewRecordsActivity;
import com.ibis.ibisecp2.ui.activity.LocationActivity;
import com.ibis.ibisecp2.ui.activity.LoginActivity;
import com.ibis.ibisecp2.ui.activity.MainActivity;
import com.ibis.ibisecp2.ui.activity.MedicamentFindActivity;
import com.ibis.ibisecp2.ui.activity.PersonalActivity;
import com.ibis.ibisecp2.ui.activity.RecipeActivity;
import com.ibis.ibisecp2.ui.activity.RegistryActivity;
import com.ibis.ibisecp2.ui.activity.RegistryPagerActivity;
import com.ibis.ibisecp2.ui.activity.ServiceRenderedActivity;
import com.ibis.ibisecp2.ui.activity.SetupNotificationActivity;
import com.ibis.ibisecp2.ui.activity.StartActivity;
import com.ibis.ibisecp2.ui.activity.TasksActivity;

import dagger.Subcomponent;

/**
 * Created by danila on 26.06.16.
 */
@PerActivity
@Subcomponent(modules = ActivityModule.class)
public interface ActivityComponent {

    FragmentComponent plusFragmentComponent();

    void inject(AppointmentActivity activity);

    void inject(MedicamentFindActivity activity);

    void inject(RegistryActivity activity);

    void inject(DiaryNewRecordsActivity activity);

    void inject(RecipeActivity activity);

    void inject(StartActivity activity);

    void inject(ServiceRenderedActivity activity);

    void inject(PersonalActivity activity);

    void inject(SetupNotificationActivity setupNotificationActivity);

    void inject(TasksActivity tasksActivity);

    void inject(DiaryActivity diaryActivity);

    void inject(BaseActivity baseActivity);

    void inject(LocationActivity baseActivity);

    void inject(RegistryPagerActivity baseActivity);

    void inject(MainActivity baseActivity);

    void inject(AgreementActivity baseActivity);

    void inject(LoginActivity loginActivity);
}
