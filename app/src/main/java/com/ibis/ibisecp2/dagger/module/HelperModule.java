package com.ibis.ibisecp2.dagger.module;

import com.ibis.ibisecp2.helpers.AuthHelper;
import com.ibis.ibisecp2.helpers.ChangeDiaryHelper;
import com.ibis.ibisecp2.helpers.ChangeVisitHelper;
import com.ibis.ibisecp2.helpers.CityLoaderHelper;
import com.ibis.ibisecp2.helpers.ClinicLoaderHelper;
import com.ibis.ibisecp2.helpers.ConfirmCodeHelper;
import com.ibis.ibisecp2.helpers.DiaryRecordsLoaderHelper;
import com.ibis.ibisecp2.helpers.DoctorLoaderHelper;
import com.ibis.ibisecp2.helpers.FavoritesDoctorsHelper;
import com.ibis.ibisecp2.helpers.LocationHelper;
import com.ibis.ibisecp2.helpers.MedicamentFindHelper;
import com.ibis.ibisecp2.helpers.PatientHelper;
import com.ibis.ibisecp2.helpers.RecipeLoaderHelper;
import com.ibis.ibisecp2.helpers.ReminderHelper;
import com.ibis.ibisecp2.helpers.ScheduleLoaderHelper;
import com.ibis.ibisecp2.helpers.ServiceRenderedLoaderHelper;
import com.ibis.ibisecp2.helpers.TasksHelper;
import com.ibis.ibisecp2.helpers.TestPostHelper;
import com.ibis.ibisecp2.helpers.VisitLoadHelper;
import com.ibis.ibisecp2.helpers.impl.AuthHelperImpl;
import com.ibis.ibisecp2.helpers.impl.ChangeDiaryHelperImpl;
import com.ibis.ibisecp2.helpers.impl.ChangeVisitHelperImpl;
import com.ibis.ibisecp2.helpers.impl.CityLoaderHelperImpl;
import com.ibis.ibisecp2.helpers.impl.ClinicLoaderHelperImpl;
import com.ibis.ibisecp2.helpers.impl.ConfirmCodeHelperImpl;
import com.ibis.ibisecp2.helpers.impl.DiaryRecordsLoaderHelperImpl;
import com.ibis.ibisecp2.helpers.impl.DoctorLoaderHelperImpl;
import com.ibis.ibisecp2.helpers.impl.FavoritesDoctorsHelperImpl;
import com.ibis.ibisecp2.helpers.impl.LocationHelperImpl;
import com.ibis.ibisecp2.helpers.impl.MedicamentFindHelperImpl;
import com.ibis.ibisecp2.helpers.impl.PatientHelperImpl;
import com.ibis.ibisecp2.helpers.impl.RecipeLoaderHelperImpl;
import com.ibis.ibisecp2.helpers.impl.ReminderHelperImpl;
import com.ibis.ibisecp2.helpers.impl.ScheduleLoaderHelperImpl;
import com.ibis.ibisecp2.helpers.impl.ServiceRenderedLoaderHelperImpl;
import com.ibis.ibisecp2.helpers.impl.TasksHelperImpl;
import com.ibis.ibisecp2.helpers.impl.TestPostHelperImpl;
import com.ibis.ibisecp2.helpers.impl.VisitLoadHelperImpl;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by danila on 20.10.16.
 */

@Module(includes = {ApiModule.class, UtilsModule.class})
public class HelperModule {
    @Provides
    @Singleton
    public AuthHelper provideAuthHelper(AuthHelperImpl authHelper) {
        return authHelper;
    }

    @Provides
    @Singleton
    public RecipeLoaderHelper provideRecipeLoaderHelper(RecipeLoaderHelperImpl helper) {
        return helper;
    }

    @Provides
    @Singleton
    public CityLoaderHelper provideCityLoaderHelper(CityLoaderHelperImpl helper) {
        return helper;
    }

    @Provides
    @Singleton
    public PatientHelper providePatientHelper(PatientHelperImpl helper) {
        return helper;
    }

    @Provides
    @Singleton
    public ClinicLoaderHelper provideClinicLoaderHelper(ClinicLoaderHelperImpl helper) {
        return helper;
    }

    @Provides
    @Singleton
    public DoctorLoaderHelper provideDoctorLoaderHelper(DoctorLoaderHelperImpl helper) {
        return helper;
    }

    @Provides
    @Singleton
    public MedicamentFindHelper provideMedicamentFindHelper(MedicamentFindHelperImpl helper) {
        return helper;
    }

    @Provides
    @Singleton
    public VisitLoadHelper provideVisitLoadHelper(VisitLoadHelperImpl helper) {
        return helper;
    }

    @Provides
    @Singleton
    public ScheduleLoaderHelper provideScheduleLoaderHelper(ScheduleLoaderHelperImpl helper) {
        return helper;
    }

    @Provides
    @Singleton
    public DiaryRecordsLoaderHelper provideDiaryRecordsLoaderHelper(DiaryRecordsLoaderHelperImpl helper) {
        return helper;
    }

    @Provides
    @Singleton
    public ChangeVisitHelper provideEnrollHelper(ChangeVisitHelperImpl helper) {
        return helper;
    }

    @Provides
    @Singleton
    public ServiceRenderedLoaderHelper provideServiceRenderedLoaderHelper(ServiceRenderedLoaderHelperImpl helper) {
        return helper;
    }

    @Provides
    @Singleton
    public TestPostHelper provideTestPostHelper(TestPostHelperImpl helper) {
        return helper;
    }

    @Provides
    @Singleton
    public ReminderHelper provideReminderHelper(ReminderHelperImpl helper) {
        return helper;
    }

    @Provides
    @Singleton
    public LocationHelper provideLocationHelper(LocationHelperImpl helper) {
        return helper;
    }

    @Provides
    @Singleton
    public ChangeDiaryHelper provideChangeDiaryHelper(ChangeDiaryHelperImpl helper) {
        return helper;
    }

    @Provides
    @Singleton
    public TasksHelper provideTasksHelper(TasksHelperImpl helper) {
        return helper;
    }

    @Provides
    @Singleton
    public ConfirmCodeHelper provideConfirmCodeHelper(ConfirmCodeHelperImpl helper) {
        return helper;
    }

    @Provides
    @Singleton
    public FavoritesDoctorsHelper provideFavoritesDoctorsHelper(FavoritesDoctorsHelperImpl helper) {
        return helper;
    }
}
