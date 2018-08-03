package com.ibis.ibisecp2.dagger.component;

import android.app.Activity;

import com.ibis.ibisecp2.dagger.module.FragmentModule;
import com.ibis.ibisecp2.dagger.qualifier.PerFragment;
import com.ibis.ibisecp2.ui.fragment.CityChooseFragment;
import com.ibis.ibisecp2.ui.fragment.ClinicChooseFragment;
import com.ibis.ibisecp2.ui.fragment.ClinicNearMeFragment;
import com.ibis.ibisecp2.ui.fragment.ConfirmSmsFragment;
import com.ibis.ibisecp2.ui.fragment.DepartmentFragment;
import com.ibis.ibisecp2.ui.fragment.DiaryRecordEditFragment;
import com.ibis.ibisecp2.ui.fragment.DiaryRecordsFragment;
import com.ibis.ibisecp2.ui.fragment.DoctorsFragment;
import com.ibis.ibisecp2.ui.fragment.EnrollFragment;
import com.ibis.ibisecp2.ui.fragment.FavoritesDoctorsFragment;
import com.ibis.ibisecp2.ui.fragment.FreeTimeFragment;
import com.ibis.ibisecp2.ui.fragment.ListPatientFragment;
import com.ibis.ibisecp2.ui.fragment.LocationFragment;
import com.ibis.ibisecp2.ui.fragment.LoginByEsiaFragment;
import com.ibis.ibisecp2.ui.fragment.LoginFragment;
import com.ibis.ibisecp2.ui.fragment.RecipeFragment;
import com.ibis.ibisecp2.ui.fragment.RemembersFragment;
import com.ibis.ibisecp2.ui.fragment.ReminderHistoryFragment;
import com.ibis.ibisecp2.ui.fragment.ReminderTimeFragment;
import com.ibis.ibisecp2.ui.fragment.ScheduleFragment;
import com.ibis.ibisecp2.ui.fragment.ServiceRenderedFragment;
import com.ibis.ibisecp2.ui.fragment.SpecialityFragment;
import com.ibis.ibisecp2.ui.fragment.VisitFragment;

import dagger.Subcomponent;

/**
 * Created by danila on 28.07.16.
 */
@PerFragment
@Subcomponent(modules = {FragmentModule.class})
public interface FragmentComponent {
    Activity getActivity();

    void inject(LoginFragment loginFragment);

    void inject(CityChooseFragment activity);

    void inject(ClinicChooseFragment activity);

    void inject(DiaryRecordsFragment activity);

    void inject(RemembersFragment activity);

    void inject(DoctorsFragment activity);

    void inject(FreeTimeFragment activity);

    void inject(DepartmentFragment activity);

    void inject(SpecialityFragment activity);

    void inject(EnrollFragment activity);

    void inject(RecipeFragment activity);

    void inject(ListPatientFragment activity);

    void inject(ServiceRenderedFragment activity);

    void inject(ScheduleFragment scheduleFragment);

    void inject(ReminderTimeFragment reminderTimeFragment);

    void inject(ReminderHistoryFragment reminderHistoryFragment);

    void inject(ConfirmSmsFragment confirmSmsFragment);

    void inject(VisitFragment visitFragment);

    void inject(DiaryRecordEditFragment diaryRecordEditFragment);

    void inject(ClinicNearMeFragment clinicNearMeFragment);

    void inject(LocationFragment locationFragment);

    void inject(FavoritesDoctorsFragment favoritesDoctorsFragment);

    void inject(LoginByEsiaFragment loginByEsiaFragment);
}
