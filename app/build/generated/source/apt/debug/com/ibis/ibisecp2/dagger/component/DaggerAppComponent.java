package com.ibis.ibisecp2.dagger.component;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import com.ibis.ibisecp2.dagger.module.ActivityModule;
import com.ibis.ibisecp2.dagger.module.ActivityModule_ProvideActivityFactory;
import com.ibis.ibisecp2.dagger.module.ActivityModule_ProvideAppointmentPresenterFactory;
import com.ibis.ibisecp2.dagger.module.ActivityModule_ProvideDialogsHelperFactory;
import com.ibis.ibisecp2.dagger.module.ActivityModule_ProvideDiaryEditRecordsPresenterFactory;
import com.ibis.ibisecp2.dagger.module.ActivityModule_ProvideLoginPresenterFactory;
import com.ibis.ibisecp2.dagger.module.ActivityModule_ProvideMainPresenterFactory;
import com.ibis.ibisecp2.dagger.module.ActivityModule_ProvideMedicamentFindPresenterFactory;
import com.ibis.ibisecp2.dagger.module.ActivityModule_ProvideNavigatorFactory;
import com.ibis.ibisecp2.dagger.module.ActivityModule_ProvidePersonalPresenterFactory;
import com.ibis.ibisecp2.dagger.module.ActivityModule_ProvideProgressDialogHelperFactory;
import com.ibis.ibisecp2.dagger.module.ActivityModule_ProvideRegistryPagerPresenterFactory;
import com.ibis.ibisecp2.dagger.module.ActivityModule_ProvideShowHideLoadHelperFactory;
import com.ibis.ibisecp2.dagger.module.ActivityModule_ProvideStartPresenterFactory;
import com.ibis.ibisecp2.dagger.module.ApiModule;
import com.ibis.ibisecp2.dagger.module.ApiModule_ProvideEcpApFactory;
import com.ibis.ibisecp2.dagger.module.ApiModule_ProvideEcpRetrofitFactory;
import com.ibis.ibisecp2.dagger.module.ApiModule_ProvideMedvedApiFactory;
import com.ibis.ibisecp2.dagger.module.ApiModule_ProvideMedvedRetrofitFactory;
import com.ibis.ibisecp2.dagger.module.ApiModule_ProvideOkHttpClientFactory;
import com.ibis.ibisecp2.dagger.module.ApiModule_ProvideOkHttpClientWFactory;
import com.ibis.ibisecp2.dagger.module.AppModule;
import com.ibis.ibisecp2.dagger.module.AppModule_ProvideApplicationFactory;
import com.ibis.ibisecp2.dagger.module.AppModule_ProvideContextFactory;
import com.ibis.ibisecp2.dagger.module.AppModule_ProvideDbFactory;
import com.ibis.ibisecp2.dagger.module.AppModule_ProvideResourceFactory;
import com.ibis.ibisecp2.dagger.module.AppModule_ProvideSharedPreferencesUtilsFactory;
import com.ibis.ibisecp2.dagger.module.FragmentModule;
import com.ibis.ibisecp2.dagger.module.FragmentModule_ProvideCityChoosePresenterFactory;
import com.ibis.ibisecp2.dagger.module.FragmentModule_ProvideClinicChoosePresenterFactory;
import com.ibis.ibisecp2.dagger.module.FragmentModule_ProvideClinicNearMePresenterFactory;
import com.ibis.ibisecp2.dagger.module.FragmentModule_ProvideConfirmSmsPresenterFactory;
import com.ibis.ibisecp2.dagger.module.FragmentModule_ProvideDataChoosePresenterFactory;
import com.ibis.ibisecp2.dagger.module.FragmentModule_ProvideDiaryRecordEditFragmentPresenterFactory;
import com.ibis.ibisecp2.dagger.module.FragmentModule_ProvideDiaryRecordPresenterFactory;
import com.ibis.ibisecp2.dagger.module.FragmentModule_ProvideDoctorPresenterFactory;
import com.ibis.ibisecp2.dagger.module.FragmentModule_ProvideDoctorsPresenterFactory;
import com.ibis.ibisecp2.dagger.module.FragmentModule_ProvideEnrollPresenterFactory;
import com.ibis.ibisecp2.dagger.module.FragmentModule_ProvideFavoritesDoctorsPresenterFactory;
import com.ibis.ibisecp2.dagger.module.FragmentModule_ProvideHistoryPresenterFactory;
import com.ibis.ibisecp2.dagger.module.FragmentModule_ProvideListPatientPresenterFactory;
import com.ibis.ibisecp2.dagger.module.FragmentModule_ProvideLocationPresenterFactory;
import com.ibis.ibisecp2.dagger.module.FragmentModule_ProvideLoginPresenterFactory;
import com.ibis.ibisecp2.dagger.module.FragmentModule_ProvideRecipePresenterFactory;
import com.ibis.ibisecp2.dagger.module.FragmentModule_ProvideRemembersPresenterFactory;
import com.ibis.ibisecp2.dagger.module.FragmentModule_ProvideReminderTimePresenterFactory;
import com.ibis.ibisecp2.dagger.module.FragmentModule_ProvideServiceRenderedPresenterFactory;
import com.ibis.ibisecp2.dagger.module.FragmentModule_ProvideSpecialityPresenterFactory;
import com.ibis.ibisecp2.dagger.module.FragmentModule_ProvideVisitPresenterFactory;
import com.ibis.ibisecp2.dagger.module.HelperModule;
import com.ibis.ibisecp2.dagger.module.HelperModule_ProvideAuthHelperFactory;
import com.ibis.ibisecp2.dagger.module.HelperModule_ProvideChangeDiaryHelperFactory;
import com.ibis.ibisecp2.dagger.module.HelperModule_ProvideCityLoaderHelperFactory;
import com.ibis.ibisecp2.dagger.module.HelperModule_ProvideClinicLoaderHelperFactory;
import com.ibis.ibisecp2.dagger.module.HelperModule_ProvideDiaryRecordsLoaderHelperFactory;
import com.ibis.ibisecp2.dagger.module.HelperModule_ProvideDoctorLoaderHelperFactory;
import com.ibis.ibisecp2.dagger.module.HelperModule_ProvideEnrollHelperFactory;
import com.ibis.ibisecp2.dagger.module.HelperModule_ProvideFavoritesDoctorsHelperFactory;
import com.ibis.ibisecp2.dagger.module.HelperModule_ProvideLocationHelperFactory;
import com.ibis.ibisecp2.dagger.module.HelperModule_ProvideMedicamentFindHelperFactory;
import com.ibis.ibisecp2.dagger.module.HelperModule_ProvidePatientHelperFactory;
import com.ibis.ibisecp2.dagger.module.HelperModule_ProvideRecipeLoaderHelperFactory;
import com.ibis.ibisecp2.dagger.module.HelperModule_ProvideScheduleLoaderHelperFactory;
import com.ibis.ibisecp2.dagger.module.HelperModule_ProvideServiceRenderedLoaderHelperFactory;
import com.ibis.ibisecp2.dagger.module.HelperModule_ProvideTasksHelperFactory;
import com.ibis.ibisecp2.dagger.module.HelperModule_ProvideVisitLoadHelperFactory;
import com.ibis.ibisecp2.dagger.module.UtilsModule;
import com.ibis.ibisecp2.dagger.module.UtilsModule_ProvideDistanceUtilFactory;
import com.ibis.ibisecp2.dagger.module.UtilsModule_ProvideEncryptUtilsFactory;
import com.ibis.ibisecp2.dagger.module.UtilsModule_ProvideRxUtilFactory;
import com.ibis.ibisecp2.dagger.module.UtilsModule_ProvideSharedPreferencesFactory;
import com.ibis.ibisecp2.helpers.AuthHelper;
import com.ibis.ibisecp2.helpers.ChangeDiaryHelper;
import com.ibis.ibisecp2.helpers.ChangeVisitHelper;
import com.ibis.ibisecp2.helpers.CityLoaderHelper;
import com.ibis.ibisecp2.helpers.ClinicLoaderHelper;
import com.ibis.ibisecp2.helpers.DialogsHelper;
import com.ibis.ibisecp2.helpers.DiaryRecordsLoaderHelper;
import com.ibis.ibisecp2.helpers.DoctorLoaderHelper;
import com.ibis.ibisecp2.helpers.FavoritesDoctorsHelper;
import com.ibis.ibisecp2.helpers.LocationHelper;
import com.ibis.ibisecp2.helpers.MedicamentFindHelper;
import com.ibis.ibisecp2.helpers.PatientHelper;
import com.ibis.ibisecp2.helpers.ProgressDialogHelper;
import com.ibis.ibisecp2.helpers.RecipeLoaderHelper;
import com.ibis.ibisecp2.helpers.ScheduleLoaderHelper;
import com.ibis.ibisecp2.helpers.ServiceRenderedLoaderHelper;
import com.ibis.ibisecp2.helpers.ShowHideLoadHelper;
import com.ibis.ibisecp2.helpers.TasksHelper;
import com.ibis.ibisecp2.helpers.VisitLoadHelper;
import com.ibis.ibisecp2.helpers.impl.AuthHelperImpl;
import com.ibis.ibisecp2.helpers.impl.AuthHelperImpl_Factory;
import com.ibis.ibisecp2.helpers.impl.ChangeDiaryHelperImpl;
import com.ibis.ibisecp2.helpers.impl.ChangeDiaryHelperImpl_Factory;
import com.ibis.ibisecp2.helpers.impl.ChangeVisitHelperImpl;
import com.ibis.ibisecp2.helpers.impl.ChangeVisitHelperImpl_Factory;
import com.ibis.ibisecp2.helpers.impl.CityLoaderHelperImpl;
import com.ibis.ibisecp2.helpers.impl.CityLoaderHelperImpl_Factory;
import com.ibis.ibisecp2.helpers.impl.ClinicLoaderHelperImpl;
import com.ibis.ibisecp2.helpers.impl.ClinicLoaderHelperImpl_Factory;
import com.ibis.ibisecp2.helpers.impl.DialogHelperImpl;
import com.ibis.ibisecp2.helpers.impl.DialogHelperImpl_Factory;
import com.ibis.ibisecp2.helpers.impl.DiaryRecordsLoaderHelperImpl;
import com.ibis.ibisecp2.helpers.impl.DiaryRecordsLoaderHelperImpl_Factory;
import com.ibis.ibisecp2.helpers.impl.DoctorLoaderHelperImpl;
import com.ibis.ibisecp2.helpers.impl.DoctorLoaderHelperImpl_Factory;
import com.ibis.ibisecp2.helpers.impl.FavoritesDoctorsHelperImpl;
import com.ibis.ibisecp2.helpers.impl.FavoritesDoctorsHelperImpl_Factory;
import com.ibis.ibisecp2.helpers.impl.LocationHelperImpl;
import com.ibis.ibisecp2.helpers.impl.LocationHelperImpl_Factory;
import com.ibis.ibisecp2.helpers.impl.MedicamentFindHelperImpl;
import com.ibis.ibisecp2.helpers.impl.MedicamentFindHelperImpl_Factory;
import com.ibis.ibisecp2.helpers.impl.PatientHelperImpl;
import com.ibis.ibisecp2.helpers.impl.PatientHelperImpl_Factory;
import com.ibis.ibisecp2.helpers.impl.ProgressDialogHelperImpl;
import com.ibis.ibisecp2.helpers.impl.ProgressDialogHelperImpl_Factory;
import com.ibis.ibisecp2.helpers.impl.RecipeLoaderHelperImpl;
import com.ibis.ibisecp2.helpers.impl.RecipeLoaderHelperImpl_Factory;
import com.ibis.ibisecp2.helpers.impl.ScheduleLoaderHelperImpl;
import com.ibis.ibisecp2.helpers.impl.ScheduleLoaderHelperImpl_Factory;
import com.ibis.ibisecp2.helpers.impl.ServiceRenderedLoaderHelperImpl;
import com.ibis.ibisecp2.helpers.impl.ServiceRenderedLoaderHelperImpl_Factory;
import com.ibis.ibisecp2.helpers.impl.ShowHideLoadHelperImpl;
import com.ibis.ibisecp2.helpers.impl.ShowHideLoadHelperImpl_Factory;
import com.ibis.ibisecp2.helpers.impl.TasksHelperImpl;
import com.ibis.ibisecp2.helpers.impl.TasksHelperImpl_Factory;
import com.ibis.ibisecp2.helpers.impl.VisitLoadHelperImpl;
import com.ibis.ibisecp2.helpers.impl.VisitLoadHelperImpl_Factory;
import com.ibis.ibisecp2.notification.AlarmReceiver;
import com.ibis.ibisecp2.notification.AlarmReceiver_MembersInjector;
import com.ibis.ibisecp2.notification.AlarmService;
import com.ibis.ibisecp2.notification.AlarmService_MembersInjector;
import com.ibis.ibisecp2.notification.AlarmSetter;
import com.ibis.ibisecp2.notification.AlarmSetter_MembersInjector;
import com.ibis.ibisecp2.presenters.AppointmentPresenter;
import com.ibis.ibisecp2.presenters.CityChoosePresenter;
import com.ibis.ibisecp2.presenters.ClinicChoosePresenter;
import com.ibis.ibisecp2.presenters.ClinicNearMePresenter;
import com.ibis.ibisecp2.presenters.ConfirmSmsPresenter;
import com.ibis.ibisecp2.presenters.CreateVisitPresenter;
import com.ibis.ibisecp2.presenters.DataChoosePresenter;
import com.ibis.ibisecp2.presenters.DepartmentPresenter;
import com.ibis.ibisecp2.presenters.DiaryEditRecordsPresenter;
import com.ibis.ibisecp2.presenters.DiaryRecordEditFragmentPresenter;
import com.ibis.ibisecp2.presenters.DiaryRecordPresenter;
import com.ibis.ibisecp2.presenters.DoctorsPresenter;
import com.ibis.ibisecp2.presenters.FavoritesDoctorsPresenter;
import com.ibis.ibisecp2.presenters.HistoryPresenter;
import com.ibis.ibisecp2.presenters.ListPatientPresenter;
import com.ibis.ibisecp2.presenters.LocationPresenter;
import com.ibis.ibisecp2.presenters.LoginPresenter;
import com.ibis.ibisecp2.presenters.LoginPresenter_;
import com.ibis.ibisecp2.presenters.MainPresenter;
import com.ibis.ibisecp2.presenters.MedicamentFindPresenter;
import com.ibis.ibisecp2.presenters.PersonalPresenter;
import com.ibis.ibisecp2.presenters.RecipePresenter;
import com.ibis.ibisecp2.presenters.RegistryPagerPresenter;
import com.ibis.ibisecp2.presenters.RemembersPresenter;
import com.ibis.ibisecp2.presenters.ReminderTimePresenter;
import com.ibis.ibisecp2.presenters.ServiceRenderedPresenter;
import com.ibis.ibisecp2.presenters.SpecialityPresenter;
import com.ibis.ibisecp2.presenters.StartPresenter;
import com.ibis.ibisecp2.presenters.VisitPresenter;
import com.ibis.ibisecp2.presenters.impl.AppointmentPresenterImpl;
import com.ibis.ibisecp2.presenters.impl.AppointmentPresenterImpl_Factory;
import com.ibis.ibisecp2.presenters.impl.CityChoosePresenterImpl;
import com.ibis.ibisecp2.presenters.impl.CityChoosePresenterImpl_Factory;
import com.ibis.ibisecp2.presenters.impl.ClinicChoosePresenterImpl;
import com.ibis.ibisecp2.presenters.impl.ClinicChoosePresenterImpl_Factory;
import com.ibis.ibisecp2.presenters.impl.ClinicNearMePresenterImpl;
import com.ibis.ibisecp2.presenters.impl.ClinicNearMePresenterImpl_Factory;
import com.ibis.ibisecp2.presenters.impl.ConfirmSmsPresenterImpl;
import com.ibis.ibisecp2.presenters.impl.ConfirmSmsPresenterImpl_Factory;
import com.ibis.ibisecp2.presenters.impl.CreateVisitPresenterImpl;
import com.ibis.ibisecp2.presenters.impl.CreateVisitPresenterImpl_Factory;
import com.ibis.ibisecp2.presenters.impl.DataChoosePresenterImpl;
import com.ibis.ibisecp2.presenters.impl.DataChoosePresenterImpl_Factory;
import com.ibis.ibisecp2.presenters.impl.DepartmentPresenterImpl;
import com.ibis.ibisecp2.presenters.impl.DepartmentPresenterImpl_Factory;
import com.ibis.ibisecp2.presenters.impl.DiaryEditRecordsPresenterImpl;
import com.ibis.ibisecp2.presenters.impl.DiaryEditRecordsPresenterImpl_Factory;
import com.ibis.ibisecp2.presenters.impl.DiaryRecordEditFragmentPresenterImpl;
import com.ibis.ibisecp2.presenters.impl.DiaryRecordEditFragmentPresenterImpl_Factory;
import com.ibis.ibisecp2.presenters.impl.DiaryRecordPresenterImpl;
import com.ibis.ibisecp2.presenters.impl.DiaryRecordPresenterImpl_Factory;
import com.ibis.ibisecp2.presenters.impl.DoctorsPresenterImpl;
import com.ibis.ibisecp2.presenters.impl.DoctorsPresenterImpl_Factory;
import com.ibis.ibisecp2.presenters.impl.FavoritesDoctorsPresenterImpl;
import com.ibis.ibisecp2.presenters.impl.FavoritesDoctorsPresenterImpl_Factory;
import com.ibis.ibisecp2.presenters.impl.HistoryPresenterImpl;
import com.ibis.ibisecp2.presenters.impl.HistoryPresenterImpl_Factory;
import com.ibis.ibisecp2.presenters.impl.ListPatientPresenterImpl;
import com.ibis.ibisecp2.presenters.impl.ListPatientPresenterImpl_Factory;
import com.ibis.ibisecp2.presenters.impl.LocationPresenterImpl;
import com.ibis.ibisecp2.presenters.impl.LocationPresenterImpl_Factory;
import com.ibis.ibisecp2.presenters.impl.LoginPresenterImpl;
import com.ibis.ibisecp2.presenters.impl.LoginPresenterImpl_;
import com.ibis.ibisecp2.presenters.impl.LoginPresenterImpl_Factory;
import com.ibis.ibisecp2.presenters.impl.LoginPresenterImpl__Factory;
import com.ibis.ibisecp2.presenters.impl.MainPresenterImpl;
import com.ibis.ibisecp2.presenters.impl.MainPresenterImpl_Factory;
import com.ibis.ibisecp2.presenters.impl.MedicamentFindPresenterImpl;
import com.ibis.ibisecp2.presenters.impl.MedicamentFindPresenterImpl_Factory;
import com.ibis.ibisecp2.presenters.impl.PersonalPresenterImpl;
import com.ibis.ibisecp2.presenters.impl.PersonalPresenterImpl_Factory;
import com.ibis.ibisecp2.presenters.impl.RecipePresenterImpl;
import com.ibis.ibisecp2.presenters.impl.RecipePresenterImpl_Factory;
import com.ibis.ibisecp2.presenters.impl.RegistryPagerPresenterImpl;
import com.ibis.ibisecp2.presenters.impl.RegistryPagerPresenterImpl_Factory;
import com.ibis.ibisecp2.presenters.impl.RemembersPresenterImpl;
import com.ibis.ibisecp2.presenters.impl.RemembersPresenterImpl_Factory;
import com.ibis.ibisecp2.presenters.impl.ReminderTimePresenterImpl;
import com.ibis.ibisecp2.presenters.impl.ReminderTimePresenterImpl_Factory;
import com.ibis.ibisecp2.presenters.impl.ServiceRenderedPresenterImpl;
import com.ibis.ibisecp2.presenters.impl.ServiceRenderedPresenterImpl_Factory;
import com.ibis.ibisecp2.presenters.impl.SpecialityPresenterImpl;
import com.ibis.ibisecp2.presenters.impl.SpecialityPresenterImpl_Factory;
import com.ibis.ibisecp2.presenters.impl.StartPresenterImpl;
import com.ibis.ibisecp2.presenters.impl.StartPresenterImpl_Factory;
import com.ibis.ibisecp2.presenters.impl.VisitPresenterImpl;
import com.ibis.ibisecp2.presenters.impl.VisitPresenterImpl_Factory;
import com.ibis.ibisecp2.retrofit.EcpAp;
import com.ibis.ibisecp2.retrofit.MedvedApi;
import com.ibis.ibisecp2.service.DoctorService;
import com.ibis.ibisecp2.service.DoctorService_MembersInjector;
import com.ibis.ibisecp2.service.FavoritesDoctorsService;
import com.ibis.ibisecp2.service.FavoritesDoctorsService_MembersInjector;
import com.ibis.ibisecp2.service.TrackGps;
import com.ibis.ibisecp2.storage.Storage;
import com.ibis.ibisecp2.ui.Navigator;
import com.ibis.ibisecp2.ui.activity.AgreementActivity;
import com.ibis.ibisecp2.ui.activity.AgreementActivity_MembersInjector;
import com.ibis.ibisecp2.ui.activity.AppointmentActivity;
import com.ibis.ibisecp2.ui.activity.AppointmentActivity_MembersInjector;
import com.ibis.ibisecp2.ui.activity.BaseActivity;
import com.ibis.ibisecp2.ui.activity.BaseActivity_MembersInjector;
import com.ibis.ibisecp2.ui.activity.DiaryActivity;
import com.ibis.ibisecp2.ui.activity.DiaryActivity_MembersInjector;
import com.ibis.ibisecp2.ui.activity.DiaryNewRecordsActivity;
import com.ibis.ibisecp2.ui.activity.DiaryNewRecordsActivity_MembersInjector;
import com.ibis.ibisecp2.ui.activity.LocationActivity;
import com.ibis.ibisecp2.ui.activity.LocationActivity_MembersInjector;
import com.ibis.ibisecp2.ui.activity.LoginActivity;
import com.ibis.ibisecp2.ui.activity.LoginActivity_MembersInjector;
import com.ibis.ibisecp2.ui.activity.MainActivity;
import com.ibis.ibisecp2.ui.activity.MainActivity_MembersInjector;
import com.ibis.ibisecp2.ui.activity.MedicamentFindActivity;
import com.ibis.ibisecp2.ui.activity.MedicamentFindActivity_MembersInjector;
import com.ibis.ibisecp2.ui.activity.PersonalActivity;
import com.ibis.ibisecp2.ui.activity.PersonalActivity_MembersInjector;
import com.ibis.ibisecp2.ui.activity.RecipeActivity;
import com.ibis.ibisecp2.ui.activity.RecipeActivity_MembersInjector;
import com.ibis.ibisecp2.ui.activity.RegistryActivity;
import com.ibis.ibisecp2.ui.activity.RegistryActivity_MembersInjector;
import com.ibis.ibisecp2.ui.activity.RegistryPagerActivity;
import com.ibis.ibisecp2.ui.activity.RegistryPagerActivity_MembersInjector;
import com.ibis.ibisecp2.ui.activity.ServiceRenderedActivity;
import com.ibis.ibisecp2.ui.activity.ServiceRenderedActivity_MembersInjector;
import com.ibis.ibisecp2.ui.activity.SetupNotificationActivity;
import com.ibis.ibisecp2.ui.activity.SetupNotificationActivity_MembersInjector;
import com.ibis.ibisecp2.ui.activity.StartActivity;
import com.ibis.ibisecp2.ui.activity.StartActivity_MembersInjector;
import com.ibis.ibisecp2.ui.activity.TasksActivity;
import com.ibis.ibisecp2.ui.activity.TasksActivity_MembersInjector;
import com.ibis.ibisecp2.ui.fragment.CityChooseFragment;
import com.ibis.ibisecp2.ui.fragment.CityChooseFragment_MembersInjector;
import com.ibis.ibisecp2.ui.fragment.ClinicChooseFragment;
import com.ibis.ibisecp2.ui.fragment.ClinicChooseFragment_MembersInjector;
import com.ibis.ibisecp2.ui.fragment.ClinicNearMeFragment;
import com.ibis.ibisecp2.ui.fragment.ClinicNearMeFragment_MembersInjector;
import com.ibis.ibisecp2.ui.fragment.ConfirmSmsFragment;
import com.ibis.ibisecp2.ui.fragment.ConfirmSmsFragment_MembersInjector;
import com.ibis.ibisecp2.ui.fragment.DepartmentFragment;
import com.ibis.ibisecp2.ui.fragment.DepartmentFragment_MembersInjector;
import com.ibis.ibisecp2.ui.fragment.DiaryRecordEditFragment;
import com.ibis.ibisecp2.ui.fragment.DiaryRecordEditFragment_MembersInjector;
import com.ibis.ibisecp2.ui.fragment.DiaryRecordsFragment;
import com.ibis.ibisecp2.ui.fragment.DiaryRecordsFragment_MembersInjector;
import com.ibis.ibisecp2.ui.fragment.DoctorsFragment;
import com.ibis.ibisecp2.ui.fragment.DoctorsFragment_MembersInjector;
import com.ibis.ibisecp2.ui.fragment.EnrollFragment;
import com.ibis.ibisecp2.ui.fragment.EnrollFragment_MembersInjector;
import com.ibis.ibisecp2.ui.fragment.FavoritesDoctorsFragment;
import com.ibis.ibisecp2.ui.fragment.FavoritesDoctorsFragment_MembersInjector;
import com.ibis.ibisecp2.ui.fragment.FreeTimeFragment;
import com.ibis.ibisecp2.ui.fragment.ListPatientFragment;
import com.ibis.ibisecp2.ui.fragment.ListPatientFragment_MembersInjector;
import com.ibis.ibisecp2.ui.fragment.LocationFragment;
import com.ibis.ibisecp2.ui.fragment.LocationFragment_MembersInjector;
import com.ibis.ibisecp2.ui.fragment.LoginFragment;
import com.ibis.ibisecp2.ui.fragment.LoginFragment_MembersInjector;
import com.ibis.ibisecp2.ui.fragment.RecipeFragment;
import com.ibis.ibisecp2.ui.fragment.RecipeFragment_MembersInjector;
import com.ibis.ibisecp2.ui.fragment.RemembersFragment;
import com.ibis.ibisecp2.ui.fragment.RemembersFragment_MembersInjector;
import com.ibis.ibisecp2.ui.fragment.ReminderHistoryFragment;
import com.ibis.ibisecp2.ui.fragment.ReminderHistoryFragment_MembersInjector;
import com.ibis.ibisecp2.ui.fragment.ReminderTimeFragment;
import com.ibis.ibisecp2.ui.fragment.ReminderTimeFragment_MembersInjector;
import com.ibis.ibisecp2.ui.fragment.ScheduleFragment;
import com.ibis.ibisecp2.ui.fragment.ScheduleFragment_MembersInjector;
import com.ibis.ibisecp2.ui.fragment.ServiceRenderedFragment;
import com.ibis.ibisecp2.ui.fragment.ServiceRenderedFragment_MembersInjector;
import com.ibis.ibisecp2.ui.fragment.SpecialityFragment;
import com.ibis.ibisecp2.ui.fragment.SpecialityFragment_MembersInjector;
import com.ibis.ibisecp2.ui.fragment.VisitFragment;
import com.ibis.ibisecp2.ui.fragment.VisitFragment_MembersInjector;
import com.ibis.ibisecp2.utils.DistanceUtil;
import com.ibis.ibisecp2.utils.EncryptUtils;
import com.ibis.ibisecp2.utils.RxUtil;
import com.ibis.ibisecp2.utils.SharedPreferencesUtils;
import dagger.MembersInjector;
import dagger.internal.DoubleCheck;
import dagger.internal.MembersInjectors;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import javax.inject.Provider;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class DaggerAppComponent implements AppComponent {
  private Provider<RxUtil> provideRxUtilProvider;

  private Provider<Context> provideContextProvider;

  private Provider<OkHttpClient> provideOkHttpClientProvider;

  private Provider<Application> provideApplicationProvider;

  private Provider<SharedPreferences> provideSharedPreferencesProvider;

  private Provider<SharedPreferencesUtils> provideSharedPreferencesUtilsProvider;

  private Provider<Retrofit> provideEcpRetrofitProvider;

  private Provider<EcpAp> provideEcpApProvider;

  private Provider<EncryptUtils> provideEncryptUtilsProvider;

  private Provider<Storage> provideDbProvider;

  private Provider<VisitLoadHelperImpl> visitLoadHelperImplProvider;

  private Provider<VisitLoadHelper> provideVisitLoadHelperProvider;

  private MembersInjector<AlarmService> alarmServiceMembersInjector;

  private MembersInjector<AlarmReceiver> alarmReceiverMembersInjector;

  private MembersInjector<AlarmSetter> alarmSetterMembersInjector;

  private Provider<FavoritesDoctorsHelperImpl> favoritesDoctorsHelperImplProvider;

  private Provider<FavoritesDoctorsHelper> provideFavoritesDoctorsHelperProvider;

  private MembersInjector<FavoritesDoctorsService> favoritesDoctorsServiceMembersInjector;

  private Provider<DoctorLoaderHelperImpl> doctorLoaderHelperImplProvider;

  private Provider<DoctorLoaderHelper> provideDoctorLoaderHelperProvider;

  private MembersInjector<DoctorService> doctorServiceMembersInjector;

  private Provider<MedicamentFindHelperImpl> medicamentFindHelperImplProvider;

  private Provider<MedicamentFindHelper> provideMedicamentFindHelperProvider;

  private Provider<ChangeDiaryHelperImpl> changeDiaryHelperImplProvider;

  private Provider<ChangeDiaryHelper> provideChangeDiaryHelperProvider;

  private Provider<PatientHelperImpl> patientHelperImplProvider;

  private Provider<PatientHelper> providePatientHelperProvider;

  private Provider<Resources> provideResourceProvider;

  private Provider<AuthHelperImpl> authHelperImplProvider;

  private Provider<AuthHelper> provideAuthHelperProvider;

  private Provider<CityLoaderHelperImpl> cityLoaderHelperImplProvider;

  private Provider<CityLoaderHelper> provideCityLoaderHelperProvider;

  private Provider<ClinicLoaderHelperImpl> clinicLoaderHelperImplProvider;

  private Provider<ClinicLoaderHelper> provideClinicLoaderHelperProvider;

  private Provider<LocationHelperImpl> locationHelperImplProvider;

  private Provider<LocationHelper> provideLocationHelperProvider;

  private Provider<DiaryRecordsLoaderHelperImpl> diaryRecordsLoaderHelperImplProvider;

  private Provider<DiaryRecordsLoaderHelper> provideDiaryRecordsLoaderHelperProvider;

  private Provider<TasksHelperImpl> tasksHelperImplProvider;

  private Provider<TasksHelper> provideTasksHelperProvider;

  private Provider<ChangeVisitHelperImpl> changeVisitHelperImplProvider;

  private Provider<ChangeVisitHelper> provideEnrollHelperProvider;

  private Provider<OkHttpClient> provideOkHttpClientWProvider;

  private Provider<Retrofit> provideMedvedRetrofitProvider;

  private Provider<MedvedApi> provideMedvedApiProvider;

  private Provider<RecipeLoaderHelperImpl> recipeLoaderHelperImplProvider;

  private Provider<RecipeLoaderHelper> provideRecipeLoaderHelperProvider;

  private Provider<ServiceRenderedLoaderHelperImpl> serviceRenderedLoaderHelperImplProvider;

  private Provider<ServiceRenderedLoaderHelper> provideServiceRenderedLoaderHelperProvider;

  private Provider<ScheduleLoaderHelperImpl> scheduleLoaderHelperImplProvider;

  private Provider<ScheduleLoaderHelper> provideScheduleLoaderHelperProvider;

  private Provider<DistanceUtil> provideDistanceUtilProvider;

  private DaggerAppComponent(Builder builder) {
    assert builder != null;
    initialize(builder);
  }

  public static Builder builder() {
    return new Builder();
  }

  @SuppressWarnings("unchecked")
  private void initialize(final Builder builder) {

    this.provideRxUtilProvider =
        DoubleCheck.provider(UtilsModule_ProvideRxUtilFactory.create(builder.utilsModule));

    this.provideContextProvider =
        DoubleCheck.provider(AppModule_ProvideContextFactory.create(builder.appModule));

    this.provideOkHttpClientProvider =
        DoubleCheck.provider(
            ApiModule_ProvideOkHttpClientFactory.create(builder.apiModule, provideContextProvider));

    this.provideApplicationProvider =
        DoubleCheck.provider(AppModule_ProvideApplicationFactory.create(builder.appModule));

    this.provideSharedPreferencesProvider =
        DoubleCheck.provider(
            UtilsModule_ProvideSharedPreferencesFactory.create(
                builder.utilsModule, provideApplicationProvider));

    this.provideSharedPreferencesUtilsProvider =
        DoubleCheck.provider(
            AppModule_ProvideSharedPreferencesUtilsFactory.create(
                builder.appModule, provideSharedPreferencesProvider));

    this.provideEcpRetrofitProvider =
        DoubleCheck.provider(
            ApiModule_ProvideEcpRetrofitFactory.create(
                builder.apiModule,
                provideOkHttpClientProvider,
                provideSharedPreferencesUtilsProvider));

    this.provideEcpApProvider =
        DoubleCheck.provider(
            ApiModule_ProvideEcpApFactory.create(builder.apiModule, provideEcpRetrofitProvider));

    this.provideEncryptUtilsProvider =
        DoubleCheck.provider(
            UtilsModule_ProvideEncryptUtilsFactory.create(
                builder.utilsModule, provideSharedPreferencesUtilsProvider));

    this.provideDbProvider =
        DoubleCheck.provider(AppModule_ProvideDbFactory.create(builder.appModule));

    this.visitLoadHelperImplProvider =
        VisitLoadHelperImpl_Factory.create(
            provideRxUtilProvider,
            provideEcpApProvider,
            provideEncryptUtilsProvider,
            provideDbProvider);

    this.provideVisitLoadHelperProvider =
        DoubleCheck.provider(
            HelperModule_ProvideVisitLoadHelperFactory.create(
                builder.helperModule, visitLoadHelperImplProvider));

    this.alarmServiceMembersInjector =
        AlarmService_MembersInjector.create(provideVisitLoadHelperProvider);

    this.alarmReceiverMembersInjector =
        AlarmReceiver_MembersInjector.create(provideVisitLoadHelperProvider);

    this.alarmSetterMembersInjector =
        AlarmSetter_MembersInjector.create(provideVisitLoadHelperProvider);

    this.favoritesDoctorsHelperImplProvider =
        FavoritesDoctorsHelperImpl_Factory.create(provideRxUtilProvider, provideDbProvider);

    this.provideFavoritesDoctorsHelperProvider =
        DoubleCheck.provider(
            HelperModule_ProvideFavoritesDoctorsHelperFactory.create(
                builder.helperModule, favoritesDoctorsHelperImplProvider));

    this.favoritesDoctorsServiceMembersInjector =
        FavoritesDoctorsService_MembersInjector.create(provideFavoritesDoctorsHelperProvider);

    this.doctorLoaderHelperImplProvider =
        DoctorLoaderHelperImpl_Factory.create(
            provideRxUtilProvider, provideEcpApProvider, provideDbProvider);

    this.provideDoctorLoaderHelperProvider =
        DoubleCheck.provider(
            HelperModule_ProvideDoctorLoaderHelperFactory.create(
                builder.helperModule, doctorLoaderHelperImplProvider));

    this.doctorServiceMembersInjector =
        DoctorService_MembersInjector.create(
            provideDoctorLoaderHelperProvider, provideSharedPreferencesUtilsProvider);

    this.medicamentFindHelperImplProvider =
        MedicamentFindHelperImpl_Factory.create(provideRxUtilProvider, provideEcpApProvider);

    this.provideMedicamentFindHelperProvider =
        DoubleCheck.provider(
            HelperModule_ProvideMedicamentFindHelperFactory.create(
                builder.helperModule, medicamentFindHelperImplProvider));

    this.changeDiaryHelperImplProvider =
        ChangeDiaryHelperImpl_Factory.create(
            provideEcpApProvider, provideRxUtilProvider, provideEncryptUtilsProvider);

    this.provideChangeDiaryHelperProvider =
        DoubleCheck.provider(
            HelperModule_ProvideChangeDiaryHelperFactory.create(
                builder.helperModule, changeDiaryHelperImplProvider));

    this.patientHelperImplProvider =
        PatientHelperImpl_Factory.create(provideDbProvider, provideRxUtilProvider);

    this.providePatientHelperProvider =
        DoubleCheck.provider(
            HelperModule_ProvidePatientHelperFactory.create(
                builder.helperModule, patientHelperImplProvider));

    this.provideResourceProvider =
        DoubleCheck.provider(AppModule_ProvideResourceFactory.create(builder.appModule));

    this.authHelperImplProvider =
        AuthHelperImpl_Factory.create(
            provideEcpApProvider, provideRxUtilProvider, provideEncryptUtilsProvider);

    this.provideAuthHelperProvider =
        DoubleCheck.provider(
            HelperModule_ProvideAuthHelperFactory.create(
                builder.helperModule, authHelperImplProvider));

    this.cityLoaderHelperImplProvider =
        CityLoaderHelperImpl_Factory.create(provideRxUtilProvider, provideEcpApProvider);

    this.provideCityLoaderHelperProvider =
        DoubleCheck.provider(
            HelperModule_ProvideCityLoaderHelperFactory.create(
                builder.helperModule, cityLoaderHelperImplProvider));

    this.clinicLoaderHelperImplProvider =
        ClinicLoaderHelperImpl_Factory.create(provideRxUtilProvider, provideEcpApProvider);

    this.provideClinicLoaderHelperProvider =
        DoubleCheck.provider(
            HelperModule_ProvideClinicLoaderHelperFactory.create(
                builder.helperModule, clinicLoaderHelperImplProvider));

    this.locationHelperImplProvider = LocationHelperImpl_Factory.create(provideContextProvider);

    this.provideLocationHelperProvider =
        DoubleCheck.provider(
            HelperModule_ProvideLocationHelperFactory.create(
                builder.helperModule, locationHelperImplProvider));

    this.diaryRecordsLoaderHelperImplProvider =
        DiaryRecordsLoaderHelperImpl_Factory.create(
            provideRxUtilProvider, provideEcpApProvider, provideEncryptUtilsProvider);

    this.provideDiaryRecordsLoaderHelperProvider =
        DoubleCheck.provider(
            HelperModule_ProvideDiaryRecordsLoaderHelperFactory.create(
                builder.helperModule, diaryRecordsLoaderHelperImplProvider));

    this.tasksHelperImplProvider =
        TasksHelperImpl_Factory.create(
            provideEcpApProvider, provideRxUtilProvider, provideEncryptUtilsProvider);

    this.provideTasksHelperProvider =
        DoubleCheck.provider(
            HelperModule_ProvideTasksHelperFactory.create(
                builder.helperModule, tasksHelperImplProvider));

    this.changeVisitHelperImplProvider =
        ChangeVisitHelperImpl_Factory.create(
            provideRxUtilProvider,
            provideEcpApProvider,
            provideEncryptUtilsProvider,
            provideDbProvider);

    this.provideEnrollHelperProvider =
        DoubleCheck.provider(
            HelperModule_ProvideEnrollHelperFactory.create(
                builder.helperModule, changeVisitHelperImplProvider));

    this.provideOkHttpClientWProvider =
        DoubleCheck.provider(ApiModule_ProvideOkHttpClientWFactory.create(builder.apiModule));

    this.provideMedvedRetrofitProvider =
        DoubleCheck.provider(
            ApiModule_ProvideMedvedRetrofitFactory.create(
                builder.apiModule, provideOkHttpClientWProvider));

    this.provideMedvedApiProvider =
        DoubleCheck.provider(
            ApiModule_ProvideMedvedApiFactory.create(
                builder.apiModule, provideMedvedRetrofitProvider));

    this.recipeLoaderHelperImplProvider =
        RecipeLoaderHelperImpl_Factory.create(provideMedvedApiProvider, provideRxUtilProvider);

    this.provideRecipeLoaderHelperProvider =
        DoubleCheck.provider(
            HelperModule_ProvideRecipeLoaderHelperFactory.create(
                builder.helperModule, recipeLoaderHelperImplProvider));

    this.serviceRenderedLoaderHelperImplProvider =
        ServiceRenderedLoaderHelperImpl_Factory.create(
            provideRxUtilProvider, provideEcpApProvider, provideEncryptUtilsProvider);

    this.provideServiceRenderedLoaderHelperProvider =
        DoubleCheck.provider(
            HelperModule_ProvideServiceRenderedLoaderHelperFactory.create(
                builder.helperModule, serviceRenderedLoaderHelperImplProvider));

    this.scheduleLoaderHelperImplProvider =
        ScheduleLoaderHelperImpl_Factory.create(provideRxUtilProvider, provideEcpApProvider);

    this.provideScheduleLoaderHelperProvider =
        DoubleCheck.provider(
            HelperModule_ProvideScheduleLoaderHelperFactory.create(
                builder.helperModule, scheduleLoaderHelperImplProvider));

    this.provideDistanceUtilProvider =
        DoubleCheck.provider(UtilsModule_ProvideDistanceUtilFactory.create(builder.utilsModule));
  }

  @Override
  public void inject(AlarmService alarmService) {
    alarmServiceMembersInjector.injectMembers(alarmService);
  }

  @Override
  public void inject(AlarmReceiver alarmReceiver) {
    alarmReceiverMembersInjector.injectMembers(alarmReceiver);
  }

  @Override
  public void inject(AlarmSetter alarmSetter) {
    alarmSetterMembersInjector.injectMembers(alarmSetter);
  }

  @Override
  public void inject(TrackGps trackGps) {
    MembersInjectors.<TrackGps>noOp().injectMembers(trackGps);
  }

  @Override
  public void inject(FavoritesDoctorsService favoritesDoctorsService) {
    favoritesDoctorsServiceMembersInjector.injectMembers(favoritesDoctorsService);
  }

  @Override
  public void inject(DoctorService doctorService) {
    doctorServiceMembersInjector.injectMembers(doctorService);
  }

  @Override
  public ActivityComponent plus(ActivityModule activityModule) {
    return new ActivityComponentImpl(activityModule);
  }

  public static final class Builder {
    private UtilsModule utilsModule;

    private AppModule appModule;

    private ApiModule apiModule;

    private HelperModule helperModule;

    private Builder() {}

    public AppComponent build() {
      if (utilsModule == null) {
        this.utilsModule = new UtilsModule();
      }
      if (appModule == null) {
        throw new IllegalStateException(AppModule.class.getCanonicalName() + " must be set");
      }
      if (apiModule == null) {
        this.apiModule = new ApiModule();
      }
      if (helperModule == null) {
        this.helperModule = new HelperModule();
      }
      return new DaggerAppComponent(this);
    }

    public Builder appModule(AppModule appModule) {
      this.appModule = Preconditions.checkNotNull(appModule);
      return this;
    }

    public Builder apiModule(ApiModule apiModule) {
      this.apiModule = Preconditions.checkNotNull(apiModule);
      return this;
    }

    public Builder helperModule(HelperModule helperModule) {
      this.helperModule = Preconditions.checkNotNull(helperModule);
      return this;
    }

    public Builder utilsModule(UtilsModule utilsModule) {
      this.utilsModule = Preconditions.checkNotNull(utilsModule);
      return this;
    }
  }

  private final class ActivityComponentImpl implements ActivityComponent {
    private final ActivityModule activityModule;

    private Provider<Navigator> provideNavigatorProvider;

    private Provider<Activity> provideActivityProvider;

    private Provider<DialogHelperImpl> dialogHelperImplProvider;

    private Provider<DialogsHelper> provideDialogsHelperProvider;

    private Provider<AppointmentPresenterImpl> appointmentPresenterImplProvider;

    private Provider<AppointmentPresenter> provideAppointmentPresenterProvider;

    private MembersInjector<AppointmentActivity> appointmentActivityMembersInjector;

    private Provider<MedicamentFindPresenterImpl> medicamentFindPresenterImplProvider;

    private Provider<MedicamentFindPresenter> provideMedicamentFindPresenterProvider;

    private MembersInjector<MedicamentFindActivity> medicamentFindActivityMembersInjector;

    private MembersInjector<RegistryActivity> registryActivityMembersInjector;

    private Provider<DiaryEditRecordsPresenterImpl> diaryEditRecordsPresenterImplProvider;

    private Provider<DiaryEditRecordsPresenter> provideDiaryEditRecordsPresenterProvider;

    private MembersInjector<DiaryNewRecordsActivity> diaryNewRecordsActivityMembersInjector;

    private MembersInjector<RecipeActivity> recipeActivityMembersInjector;

    private Provider<StartPresenterImpl> startPresenterImplProvider;

    private Provider<StartPresenter> provideStartPresenterProvider;

    private MembersInjector<StartActivity> startActivityMembersInjector;

    private MembersInjector<ServiceRenderedActivity> serviceRenderedActivityMembersInjector;

    private Provider<PersonalPresenterImpl> personalPresenterImplProvider;

    private Provider<PersonalPresenter> providePersonalPresenterProvider;

    private MembersInjector<PersonalActivity> personalActivityMembersInjector;

    private MembersInjector<SetupNotificationActivity> setupNotificationActivityMembersInjector;

    private Provider<ProgressDialogHelperImpl> progressDialogHelperImplProvider;

    private Provider<ProgressDialogHelper> provideProgressDialogHelperProvider;

    private MembersInjector<TasksActivity> tasksActivityMembersInjector;

    private MembersInjector<DiaryActivity> diaryActivityMembersInjector;

    private MembersInjector<BaseActivity> baseActivityMembersInjector;

    private MembersInjector<LocationActivity> locationActivityMembersInjector;

    private Provider<RegistryPagerPresenterImpl> registryPagerPresenterImplProvider;

    private Provider<RegistryPagerPresenter> provideRegistryPagerPresenterProvider;

    private MembersInjector<RegistryPagerActivity> registryPagerActivityMembersInjector;

    private Provider<MainPresenterImpl> mainPresenterImplProvider;

    private Provider<MainPresenter> provideMainPresenterProvider;

    private MembersInjector<MainActivity> mainActivityMembersInjector;

    private MembersInjector<AgreementActivity> agreementActivityMembersInjector;

    private Provider<LoginPresenterImpl_> loginPresenterImpl_Provider;

    private Provider<LoginPresenter_> provideLoginPresenterProvider;

    private MembersInjector<LoginActivity> loginActivityMembersInjector;

    private Provider<ShowHideLoadHelperImpl> showHideLoadHelperImplProvider;

    private Provider<ShowHideLoadHelper> provideShowHideLoadHelperProvider;

    private ActivityComponentImpl(ActivityModule activityModule) {
      this.activityModule = Preconditions.checkNotNull(activityModule);
      initialize();
    }

    @SuppressWarnings("unchecked")
    private void initialize() {

      this.provideNavigatorProvider =
          DoubleCheck.provider(ActivityModule_ProvideNavigatorFactory.create(activityModule));

      this.provideActivityProvider =
          DoubleCheck.provider(ActivityModule_ProvideActivityFactory.create(activityModule));

      this.dialogHelperImplProvider =
          DialogHelperImpl_Factory.create(provideActivityProvider, provideNavigatorProvider);

      this.provideDialogsHelperProvider =
          DoubleCheck.provider(
              ActivityModule_ProvideDialogsHelperFactory.create(
                  activityModule, dialogHelperImplProvider));

      this.appointmentPresenterImplProvider =
          AppointmentPresenterImpl_Factory.create(
              MembersInjectors.<AppointmentPresenterImpl>noOp(),
              provideNavigatorProvider,
              DaggerAppComponent.this.provideSharedPreferencesUtilsProvider);

      this.provideAppointmentPresenterProvider =
          DoubleCheck.provider(
              ActivityModule_ProvideAppointmentPresenterFactory.create(
                  activityModule, appointmentPresenterImplProvider));

      this.appointmentActivityMembersInjector =
          AppointmentActivity_MembersInjector.create(
              provideNavigatorProvider,
              provideDialogsHelperProvider,
              DaggerAppComponent.this.provideSharedPreferencesUtilsProvider,
              provideAppointmentPresenterProvider);

      this.medicamentFindPresenterImplProvider =
          MedicamentFindPresenterImpl_Factory.create(
              MembersInjectors.<MedicamentFindPresenterImpl>noOp(),
              provideDialogsHelperProvider,
              DaggerAppComponent.this.provideMedicamentFindHelperProvider);

      this.provideMedicamentFindPresenterProvider =
          DoubleCheck.provider(
              ActivityModule_ProvideMedicamentFindPresenterFactory.create(
                  activityModule, medicamentFindPresenterImplProvider));

      this.medicamentFindActivityMembersInjector =
          MedicamentFindActivity_MembersInjector.create(
              provideNavigatorProvider,
              provideDialogsHelperProvider,
              DaggerAppComponent.this.provideSharedPreferencesUtilsProvider,
              provideMedicamentFindPresenterProvider);

      this.registryActivityMembersInjector =
          RegistryActivity_MembersInjector.create(
              provideNavigatorProvider,
              provideDialogsHelperProvider,
              DaggerAppComponent.this.provideSharedPreferencesUtilsProvider);

      this.diaryEditRecordsPresenterImplProvider =
          DiaryEditRecordsPresenterImpl_Factory.create(
              MembersInjectors.<DiaryEditRecordsPresenterImpl>noOp(),
              DaggerAppComponent.this.provideChangeDiaryHelperProvider,
              provideDialogsHelperProvider);

      this.provideDiaryEditRecordsPresenterProvider =
          DoubleCheck.provider(
              ActivityModule_ProvideDiaryEditRecordsPresenterFactory.create(
                  activityModule, diaryEditRecordsPresenterImplProvider));

      this.diaryNewRecordsActivityMembersInjector =
          DiaryNewRecordsActivity_MembersInjector.create(
              provideNavigatorProvider,
              provideDialogsHelperProvider,
              DaggerAppComponent.this.provideSharedPreferencesUtilsProvider,
              provideDiaryEditRecordsPresenterProvider);

      this.recipeActivityMembersInjector =
          RecipeActivity_MembersInjector.create(
              provideNavigatorProvider,
              provideDialogsHelperProvider,
              DaggerAppComponent.this.provideSharedPreferencesUtilsProvider);

      this.startPresenterImplProvider =
          StartPresenterImpl_Factory.create(
              MembersInjectors.<StartPresenterImpl>noOp(),
              DaggerAppComponent.this.provideSharedPreferencesUtilsProvider,
              provideDialogsHelperProvider,
              DaggerAppComponent.this.providePatientHelperProvider,
              provideNavigatorProvider);

      this.provideStartPresenterProvider =
          DoubleCheck.provider(
              ActivityModule_ProvideStartPresenterFactory.create(
                  activityModule, startPresenterImplProvider));

      this.startActivityMembersInjector =
          StartActivity_MembersInjector.create(
              provideNavigatorProvider,
              provideDialogsHelperProvider,
              DaggerAppComponent.this.provideSharedPreferencesUtilsProvider,
              provideStartPresenterProvider,
              DaggerAppComponent.this.provideResourceProvider);

      this.serviceRenderedActivityMembersInjector =
          ServiceRenderedActivity_MembersInjector.create(
              provideNavigatorProvider,
              provideDialogsHelperProvider,
              DaggerAppComponent.this.provideSharedPreferencesUtilsProvider);

      this.personalPresenterImplProvider =
          PersonalPresenterImpl_Factory.create(
              MembersInjectors.<PersonalPresenterImpl>noOp(),
              DaggerAppComponent.this.providePatientHelperProvider,
              DaggerAppComponent.this.provideSharedPreferencesUtilsProvider);

      this.providePersonalPresenterProvider =
          DoubleCheck.provider(
              ActivityModule_ProvidePersonalPresenterFactory.create(
                  activityModule, personalPresenterImplProvider));

      this.personalActivityMembersInjector =
          PersonalActivity_MembersInjector.create(
              provideNavigatorProvider,
              provideDialogsHelperProvider,
              DaggerAppComponent.this.provideSharedPreferencesUtilsProvider,
              providePersonalPresenterProvider);

      this.setupNotificationActivityMembersInjector =
          SetupNotificationActivity_MembersInjector.create(
              provideNavigatorProvider,
              provideDialogsHelperProvider,
              DaggerAppComponent.this.provideSharedPreferencesUtilsProvider,
              DaggerAppComponent.this.provideResourceProvider);

      this.progressDialogHelperImplProvider =
          ProgressDialogHelperImpl_Factory.create(provideActivityProvider);

      this.provideProgressDialogHelperProvider =
          DoubleCheck.provider(
              ActivityModule_ProvideProgressDialogHelperFactory.create(
                  activityModule, progressDialogHelperImplProvider));

      this.tasksActivityMembersInjector =
          TasksActivity_MembersInjector.create(
              provideNavigatorProvider,
              provideDialogsHelperProvider,
              DaggerAppComponent.this.provideSharedPreferencesUtilsProvider,
              provideDiaryEditRecordsPresenterProvider,
              provideProgressDialogHelperProvider);

      this.diaryActivityMembersInjector =
          DiaryActivity_MembersInjector.create(
              provideNavigatorProvider,
              provideDialogsHelperProvider,
              DaggerAppComponent.this.provideSharedPreferencesUtilsProvider);

      this.baseActivityMembersInjector =
          BaseActivity_MembersInjector.create(
              provideNavigatorProvider,
              provideDialogsHelperProvider,
              DaggerAppComponent.this.provideSharedPreferencesUtilsProvider);

      this.locationActivityMembersInjector =
          LocationActivity_MembersInjector.create(
              provideNavigatorProvider,
              provideDialogsHelperProvider,
              DaggerAppComponent.this.provideSharedPreferencesUtilsProvider);

      this.registryPagerPresenterImplProvider =
          RegistryPagerPresenterImpl_Factory.create(
              MembersInjectors.<RegistryPagerPresenterImpl>noOp(),
              DaggerAppComponent.this.provideDbProvider,
              DaggerAppComponent.this.provideRxUtilProvider);

      this.provideRegistryPagerPresenterProvider =
          DoubleCheck.provider(
              ActivityModule_ProvideRegistryPagerPresenterFactory.create(
                  activityModule, registryPagerPresenterImplProvider));

      this.registryPagerActivityMembersInjector =
          RegistryPagerActivity_MembersInjector.create(
              provideNavigatorProvider,
              provideDialogsHelperProvider,
              DaggerAppComponent.this.provideSharedPreferencesUtilsProvider,
              provideRegistryPagerPresenterProvider);

      this.mainPresenterImplProvider =
          MainPresenterImpl_Factory.create(
              MembersInjectors.<MainPresenterImpl>noOp(),
              DaggerAppComponent.this.providePatientHelperProvider,
              DaggerAppComponent.this.provideSharedPreferencesUtilsProvider);

      this.provideMainPresenterProvider =
          DoubleCheck.provider(
              ActivityModule_ProvideMainPresenterFactory.create(
                  activityModule, mainPresenterImplProvider));

      this.mainActivityMembersInjector =
          MainActivity_MembersInjector.create(
              provideNavigatorProvider,
              provideDialogsHelperProvider,
              DaggerAppComponent.this.provideSharedPreferencesUtilsProvider,
              provideMainPresenterProvider);

      this.agreementActivityMembersInjector =
          AgreementActivity_MembersInjector.create(
              provideNavigatorProvider,
              provideDialogsHelperProvider,
              DaggerAppComponent.this.provideSharedPreferencesUtilsProvider);

      this.loginPresenterImpl_Provider =
          LoginPresenterImpl__Factory.create(
              MembersInjectors.<LoginPresenterImpl_>noOp(), provideNavigatorProvider);

      this.provideLoginPresenterProvider =
          DoubleCheck.provider(
              ActivityModule_ProvideLoginPresenterFactory.create(
                  activityModule, loginPresenterImpl_Provider));

      this.loginActivityMembersInjector =
          LoginActivity_MembersInjector.create(
              provideNavigatorProvider,
              provideDialogsHelperProvider,
              DaggerAppComponent.this.provideSharedPreferencesUtilsProvider,
              provideLoginPresenterProvider);

      this.showHideLoadHelperImplProvider =
          ShowHideLoadHelperImpl_Factory.create(provideActivityProvider);

      this.provideShowHideLoadHelperProvider =
          DoubleCheck.provider(
              ActivityModule_ProvideShowHideLoadHelperFactory.create(
                  activityModule, showHideLoadHelperImplProvider));
    }

    @Override
    public void inject(AppointmentActivity activity) {
      appointmentActivityMembersInjector.injectMembers(activity);
    }

    @Override
    public void inject(MedicamentFindActivity activity) {
      medicamentFindActivityMembersInjector.injectMembers(activity);
    }

    @Override
    public void inject(RegistryActivity activity) {
      registryActivityMembersInjector.injectMembers(activity);
    }

    @Override
    public void inject(DiaryNewRecordsActivity activity) {
      diaryNewRecordsActivityMembersInjector.injectMembers(activity);
    }

    @Override
    public void inject(RecipeActivity activity) {
      recipeActivityMembersInjector.injectMembers(activity);
    }

    @Override
    public void inject(StartActivity activity) {
      startActivityMembersInjector.injectMembers(activity);
    }

    @Override
    public void inject(ServiceRenderedActivity activity) {
      serviceRenderedActivityMembersInjector.injectMembers(activity);
    }

    @Override
    public void inject(PersonalActivity activity) {
      personalActivityMembersInjector.injectMembers(activity);
    }

    @Override
    public void inject(SetupNotificationActivity setupNotificationActivity) {
      setupNotificationActivityMembersInjector.injectMembers(setupNotificationActivity);
    }

    @Override
    public void inject(TasksActivity tasksActivity) {
      tasksActivityMembersInjector.injectMembers(tasksActivity);
    }

    @Override
    public void inject(DiaryActivity diaryActivity) {
      diaryActivityMembersInjector.injectMembers(diaryActivity);
    }

    @Override
    public void inject(BaseActivity baseActivity) {
      baseActivityMembersInjector.injectMembers(baseActivity);
    }

    @Override
    public void inject(LocationActivity baseActivity) {
      locationActivityMembersInjector.injectMembers(baseActivity);
    }

    @Override
    public void inject(RegistryPagerActivity baseActivity) {
      registryPagerActivityMembersInjector.injectMembers(baseActivity);
    }

    @Override
    public void inject(MainActivity baseActivity) {
      mainActivityMembersInjector.injectMembers(baseActivity);
    }

    @Override
    public void inject(AgreementActivity baseActivity) {
      agreementActivityMembersInjector.injectMembers(baseActivity);
    }

    @Override
    public void inject(LoginActivity loginActivity) {
      loginActivityMembersInjector.injectMembers(loginActivity);
    }

    @Override
    public FragmentComponent plusFragmentComponent() {
      return new FragmentComponentImpl();
    }

    private final class FragmentComponentImpl implements FragmentComponent {
      private final FragmentModule fragmentModule;

      private Provider<LoginPresenterImpl> loginPresenterImplProvider;

      private Provider<LoginPresenter> provideLoginPresenterProvider;

      private MembersInjector<LoginFragment> loginFragmentMembersInjector;

      private Provider<CityChoosePresenterImpl> cityChoosePresenterImplProvider;

      private Provider<CityChoosePresenter> provideCityChoosePresenterProvider;

      private MembersInjector<CityChooseFragment> cityChooseFragmentMembersInjector;

      private Provider<ClinicChoosePresenterImpl> clinicChoosePresenterImplProvider;

      private Provider<ClinicChoosePresenter> provideClinicChoosePresenterProvider;

      private MembersInjector<ClinicChooseFragment> clinicChooseFragmentMembersInjector;

      private Provider<DiaryRecordPresenterImpl> diaryRecordPresenterImplProvider;

      private Provider<DiaryRecordPresenter> provideDiaryRecordPresenterProvider;

      private MembersInjector<DiaryRecordsFragment> diaryRecordsFragmentMembersInjector;

      private Provider<RemembersPresenterImpl> remembersPresenterImplProvider;

      private Provider<RemembersPresenter> provideRemembersPresenterProvider;

      private MembersInjector<RemembersFragment> remembersFragmentMembersInjector;

      private Provider<DoctorsPresenterImpl> doctorsPresenterImplProvider;

      private Provider<DoctorsPresenter> provideDoctorsPresenterProvider;

      private MembersInjector<DoctorsFragment> doctorsFragmentMembersInjector;

      private Provider<DepartmentPresenterImpl> departmentPresenterImplProvider;

      private Provider<DepartmentPresenter> provideDoctorPresenterProvider;

      private MembersInjector<DepartmentFragment> departmentFragmentMembersInjector;

      private Provider<SpecialityPresenterImpl> specialityPresenterImplProvider;

      private Provider<SpecialityPresenter> provideSpecialityPresenterProvider;

      private MembersInjector<SpecialityFragment> specialityFragmentMembersInjector;

      private Provider<CreateVisitPresenterImpl> createVisitPresenterImplProvider;

      private Provider<CreateVisitPresenter> provideEnrollPresenterProvider;

      private MembersInjector<EnrollFragment> enrollFragmentMembersInjector;

      private Provider<RecipePresenterImpl> recipePresenterImplProvider;

      private Provider<RecipePresenter> provideRecipePresenterProvider;

      private MembersInjector<RecipeFragment> recipeFragmentMembersInjector;

      private Provider<ListPatientPresenterImpl> listPatientPresenterImplProvider;

      private Provider<ListPatientPresenter> provideListPatientPresenterProvider;

      private MembersInjector<ListPatientFragment> listPatientFragmentMembersInjector;

      private Provider<ServiceRenderedPresenterImpl> serviceRenderedPresenterImplProvider;

      private Provider<ServiceRenderedPresenter> provideServiceRenderedPresenterProvider;

      private MembersInjector<ServiceRenderedFragment> serviceRenderedFragmentMembersInjector;

      private Provider<DataChoosePresenterImpl> dataChoosePresenterImplProvider;

      private Provider<DataChoosePresenter> provideDataChoosePresenterProvider;

      private MembersInjector<ScheduleFragment> scheduleFragmentMembersInjector;

      private Provider<ReminderTimePresenterImpl> reminderTimePresenterImplProvider;

      private Provider<ReminderTimePresenter> provideReminderTimePresenterProvider;

      private MembersInjector<ReminderTimeFragment> reminderTimeFragmentMembersInjector;

      private Provider<HistoryPresenterImpl> historyPresenterImplProvider;

      private Provider<HistoryPresenter> provideHistoryPresenterProvider;

      private MembersInjector<ReminderHistoryFragment> reminderHistoryFragmentMembersInjector;

      private Provider<ConfirmSmsPresenterImpl> confirmSmsPresenterImplProvider;

      private Provider<ConfirmSmsPresenter> provideConfirmSmsPresenterProvider;

      private MembersInjector<ConfirmSmsFragment> confirmSmsFragmentMembersInjector;

      private Provider<VisitPresenterImpl> visitPresenterImplProvider;

      private Provider<VisitPresenter> provideVisitPresenterProvider;

      private MembersInjector<VisitFragment> visitFragmentMembersInjector;

      private Provider<DiaryRecordEditFragmentPresenterImpl>
          diaryRecordEditFragmentPresenterImplProvider;

      private Provider<DiaryRecordEditFragmentPresenter>
          provideDiaryRecordEditFragmentPresenterProvider;

      private MembersInjector<DiaryRecordEditFragment> diaryRecordEditFragmentMembersInjector;

      private Provider<ClinicNearMePresenterImpl> clinicNearMePresenterImplProvider;

      private Provider<ClinicNearMePresenter> provideClinicNearMePresenterProvider;

      private MembersInjector<ClinicNearMeFragment> clinicNearMeFragmentMembersInjector;

      private Provider<LocationPresenterImpl> locationPresenterImplProvider;

      private Provider<LocationPresenter> provideLocationPresenterProvider;

      private MembersInjector<LocationFragment> locationFragmentMembersInjector;

      private Provider<FavoritesDoctorsPresenterImpl> favoritesDoctorsPresenterImplProvider;

      private Provider<FavoritesDoctorsPresenter> provideFavoritesDoctorsPresenterProvider;

      private MembersInjector<FavoritesDoctorsFragment> favoritesDoctorsFragmentMembersInjector;

      private FragmentComponentImpl() {
        this.fragmentModule = new FragmentModule();
        initialize();
      }

      @SuppressWarnings("unchecked")
      private void initialize() {

        this.loginPresenterImplProvider =
            LoginPresenterImpl_Factory.create(
                MembersInjectors.<LoginPresenterImpl>noOp(),
                DaggerAppComponent.this.provideSharedPreferencesUtilsProvider,
                ActivityComponentImpl.this.provideNavigatorProvider,
                DaggerAppComponent.this.provideAuthHelperProvider,
                DaggerAppComponent.this.providePatientHelperProvider,
                ActivityComponentImpl.this.provideDialogsHelperProvider);

        this.provideLoginPresenterProvider =
            DoubleCheck.provider(
                FragmentModule_ProvideLoginPresenterFactory.create(
                    fragmentModule, loginPresenterImplProvider));

        this.loginFragmentMembersInjector =
            LoginFragment_MembersInjector.create(
                provideLoginPresenterProvider,
                DaggerAppComponent.this.provideSharedPreferencesUtilsProvider,
                ActivityComponentImpl.this.provideDialogsHelperProvider,
                ActivityComponentImpl.this.provideNavigatorProvider);

        this.cityChoosePresenterImplProvider =
            CityChoosePresenterImpl_Factory.create(
                MembersInjectors.<CityChoosePresenterImpl>noOp(),
                ActivityComponentImpl.this.provideDialogsHelperProvider,
                DaggerAppComponent.this.provideCityLoaderHelperProvider,
                DaggerAppComponent.this.provideSharedPreferencesUtilsProvider,
                DaggerAppComponent.this.providePatientHelperProvider,
                ActivityComponentImpl.this.provideNavigatorProvider);

        this.provideCityChoosePresenterProvider =
            DoubleCheck.provider(
                FragmentModule_ProvideCityChoosePresenterFactory.create(
                    fragmentModule, cityChoosePresenterImplProvider));

        this.cityChooseFragmentMembersInjector =
            CityChooseFragment_MembersInjector.create(
                ActivityComponentImpl.this.provideShowHideLoadHelperProvider,
                provideCityChoosePresenterProvider);

        this.clinicChoosePresenterImplProvider =
            ClinicChoosePresenterImpl_Factory.create(
                MembersInjectors.<ClinicChoosePresenterImpl>noOp(),
                ActivityComponentImpl.this.provideDialogsHelperProvider,
                DaggerAppComponent.this.provideSharedPreferencesUtilsProvider,
                DaggerAppComponent.this.providePatientHelperProvider,
                DaggerAppComponent.this.provideClinicLoaderHelperProvider,
                ActivityComponentImpl.this.provideNavigatorProvider,
                DaggerAppComponent.this.provideLocationHelperProvider,
                DaggerAppComponent.this.provideDbProvider);

        this.provideClinicChoosePresenterProvider =
            DoubleCheck.provider(
                FragmentModule_ProvideClinicChoosePresenterFactory.create(
                    fragmentModule, clinicChoosePresenterImplProvider));

        this.clinicChooseFragmentMembersInjector =
            ClinicChooseFragment_MembersInjector.create(
                provideClinicChoosePresenterProvider,
                DaggerAppComponent.this.provideSharedPreferencesUtilsProvider,
                ActivityComponentImpl.this.provideDialogsHelperProvider,
                ActivityComponentImpl.this.provideShowHideLoadHelperProvider);

        this.diaryRecordPresenterImplProvider =
            DiaryRecordPresenterImpl_Factory.create(
                MembersInjectors.<DiaryRecordPresenterImpl>noOp(),
                DaggerAppComponent.this.provideDiaryRecordsLoaderHelperProvider,
                ActivityComponentImpl.this.provideDialogsHelperProvider,
                ActivityComponentImpl.this.provideNavigatorProvider,
                DaggerAppComponent.this.provideTasksHelperProvider);

        this.provideDiaryRecordPresenterProvider =
            DoubleCheck.provider(
                FragmentModule_ProvideDiaryRecordPresenterFactory.create(
                    fragmentModule, diaryRecordPresenterImplProvider));

        this.diaryRecordsFragmentMembersInjector =
            DiaryRecordsFragment_MembersInjector.create(
                DaggerAppComponent.this.provideSharedPreferencesUtilsProvider,
                provideDiaryRecordPresenterProvider,
                ActivityComponentImpl.this.provideDialogsHelperProvider,
                ActivityComponentImpl.this.provideNavigatorProvider,
                ActivityComponentImpl.this.provideShowHideLoadHelperProvider);

        this.remembersPresenterImplProvider =
            RemembersPresenterImpl_Factory.create(
                MembersInjectors.<RemembersPresenterImpl>noOp(),
                DaggerAppComponent.this.provideEnrollHelperProvider,
                ActivityComponentImpl.this.provideDialogsHelperProvider,
                DaggerAppComponent.this.provideSharedPreferencesUtilsProvider,
                ActivityComponentImpl.this.provideNavigatorProvider,
                DaggerAppComponent.this.provideDbProvider);

        this.provideRemembersPresenterProvider =
            DoubleCheck.provider(
                FragmentModule_ProvideRemembersPresenterFactory.create(
                    fragmentModule, remembersPresenterImplProvider));

        this.remembersFragmentMembersInjector =
            RemembersFragment_MembersInjector.create(
                provideRemembersPresenterProvider,
                DaggerAppComponent.this.provideSharedPreferencesUtilsProvider,
                ActivityComponentImpl.this.provideNavigatorProvider,
                ActivityComponentImpl.this.provideShowHideLoadHelperProvider);

        this.doctorsPresenterImplProvider =
            DoctorsPresenterImpl_Factory.create(
                MembersInjectors.<DoctorsPresenterImpl>noOp(),
                ActivityComponentImpl.this.provideDialogsHelperProvider,
                DaggerAppComponent.this.provideDoctorLoaderHelperProvider,
                ActivityComponentImpl.this.provideNavigatorProvider,
                DaggerAppComponent.this.providePatientHelperProvider,
                DaggerAppComponent.this.provideSharedPreferencesUtilsProvider);

        this.provideDoctorsPresenterProvider =
            DoubleCheck.provider(
                FragmentModule_ProvideDoctorsPresenterFactory.create(
                    fragmentModule, doctorsPresenterImplProvider));

        this.doctorsFragmentMembersInjector =
            DoctorsFragment_MembersInjector.create(
                ActivityComponentImpl.this.provideNavigatorProvider,
                DaggerAppComponent.this.provideSharedPreferencesUtilsProvider,
                provideDoctorsPresenterProvider,
                ActivityComponentImpl.this.provideShowHideLoadHelperProvider);

        this.departmentPresenterImplProvider =
            DepartmentPresenterImpl_Factory.create(
                MembersInjectors.<DepartmentPresenterImpl>noOp(),
                ActivityComponentImpl.this.provideDialogsHelperProvider,
                DaggerAppComponent.this.provideDoctorLoaderHelperProvider,
                ActivityComponentImpl.this.provideNavigatorProvider,
                DaggerAppComponent.this.provideSharedPreferencesUtilsProvider,
                DaggerAppComponent.this.provideRxUtilProvider,
                DaggerAppComponent.this.providePatientHelperProvider);

        this.provideDoctorPresenterProvider =
            DoubleCheck.provider(
                FragmentModule_ProvideDoctorPresenterFactory.create(
                    fragmentModule, departmentPresenterImplProvider));

        this.departmentFragmentMembersInjector =
            DepartmentFragment_MembersInjector.create(
                provideDoctorPresenterProvider,
                DaggerAppComponent.this.provideSharedPreferencesUtilsProvider,
                ActivityComponentImpl.this.provideDialogsHelperProvider,
                ActivityComponentImpl.this.provideShowHideLoadHelperProvider);

        this.specialityPresenterImplProvider =
            SpecialityPresenterImpl_Factory.create(
                MembersInjectors.<SpecialityPresenterImpl>noOp(),
                ActivityComponentImpl.this.provideDialogsHelperProvider,
                DaggerAppComponent.this.provideDoctorLoaderHelperProvider,
                ActivityComponentImpl.this.provideNavigatorProvider,
                DaggerAppComponent.this.provideSharedPreferencesUtilsProvider,
                DaggerAppComponent.this.providePatientHelperProvider);

        this.provideSpecialityPresenterProvider =
            DoubleCheck.provider(
                FragmentModule_ProvideSpecialityPresenterFactory.create(
                    fragmentModule, specialityPresenterImplProvider));

        this.specialityFragmentMembersInjector =
            SpecialityFragment_MembersInjector.create(
                provideSpecialityPresenterProvider,
                DaggerAppComponent.this.provideSharedPreferencesUtilsProvider,
                ActivityComponentImpl.this.provideShowHideLoadHelperProvider);

        this.createVisitPresenterImplProvider =
            CreateVisitPresenterImpl_Factory.create(
                MembersInjectors.<CreateVisitPresenterImpl>noOp(),
                DaggerAppComponent.this.provideEnrollHelperProvider,
                DaggerAppComponent.this.provideSharedPreferencesUtilsProvider,
                ActivityComponentImpl.this.provideNavigatorProvider,
                ActivityComponentImpl.this.provideDialogsHelperProvider,
                DaggerAppComponent.this.providePatientHelperProvider,
                DaggerAppComponent.this.provideFavoritesDoctorsHelperProvider,
                DaggerAppComponent.this.provideDoctorLoaderHelperProvider);

        this.provideEnrollPresenterProvider =
            DoubleCheck.provider(
                FragmentModule_ProvideEnrollPresenterFactory.create(
                    fragmentModule, createVisitPresenterImplProvider));

        this.enrollFragmentMembersInjector =
            EnrollFragment_MembersInjector.create(
                provideEnrollPresenterProvider,
                DaggerAppComponent.this.provideSharedPreferencesUtilsProvider,
                ActivityComponentImpl.this.provideNavigatorProvider,
                ActivityComponentImpl.this.provideDialogsHelperProvider,
                ActivityComponentImpl.this.provideShowHideLoadHelperProvider);

        this.recipePresenterImplProvider =
            RecipePresenterImpl_Factory.create(
                MembersInjectors.<RecipePresenterImpl>noOp(),
                DaggerAppComponent.this.provideRecipeLoaderHelperProvider,
                DaggerAppComponent.this.provideSharedPreferencesUtilsProvider);

        this.provideRecipePresenterProvider =
            DoubleCheck.provider(
                FragmentModule_ProvideRecipePresenterFactory.create(
                    fragmentModule, recipePresenterImplProvider));

        this.recipeFragmentMembersInjector =
            RecipeFragment_MembersInjector.create(provideRecipePresenterProvider);

        this.listPatientPresenterImplProvider =
            ListPatientPresenterImpl_Factory.create(
                MembersInjectors.<ListPatientPresenterImpl>noOp(),
                DaggerAppComponent.this.provideSharedPreferencesUtilsProvider,
                ActivityComponentImpl.this.provideNavigatorProvider,
                DaggerAppComponent.this.providePatientHelperProvider);

        this.provideListPatientPresenterProvider =
            DoubleCheck.provider(
                FragmentModule_ProvideListPatientPresenterFactory.create(
                    fragmentModule, listPatientPresenterImplProvider));

        this.listPatientFragmentMembersInjector =
            ListPatientFragment_MembersInjector.create(
                provideListPatientPresenterProvider,
                ActivityComponentImpl.this.provideDialogsHelperProvider);

        this.serviceRenderedPresenterImplProvider =
            ServiceRenderedPresenterImpl_Factory.create(
                MembersInjectors.<ServiceRenderedPresenterImpl>noOp(),
                DaggerAppComponent.this.provideServiceRenderedLoaderHelperProvider,
                DaggerAppComponent.this.provideSharedPreferencesUtilsProvider,
                ActivityComponentImpl.this.provideDialogsHelperProvider);

        this.provideServiceRenderedPresenterProvider =
            DoubleCheck.provider(
                FragmentModule_ProvideServiceRenderedPresenterFactory.create(
                    fragmentModule, serviceRenderedPresenterImplProvider));

        this.serviceRenderedFragmentMembersInjector =
            ServiceRenderedFragment_MembersInjector.create(
                provideServiceRenderedPresenterProvider,
                ActivityComponentImpl.this.provideShowHideLoadHelperProvider);

        this.dataChoosePresenterImplProvider =
            DataChoosePresenterImpl_Factory.create(
                MembersInjectors.<DataChoosePresenterImpl>noOp(),
                DaggerAppComponent.this.provideScheduleLoaderHelperProvider,
                ActivityComponentImpl.this.provideDialogsHelperProvider,
                ActivityComponentImpl.this.provideNavigatorProvider,
                DaggerAppComponent.this.provideSharedPreferencesUtilsProvider);

        this.provideDataChoosePresenterProvider =
            DoubleCheck.provider(
                FragmentModule_ProvideDataChoosePresenterFactory.create(
                    fragmentModule, dataChoosePresenterImplProvider));

        this.scheduleFragmentMembersInjector =
            ScheduleFragment_MembersInjector.create(
                provideDataChoosePresenterProvider,
                DaggerAppComponent.this.provideSharedPreferencesUtilsProvider,
                ActivityComponentImpl.this.provideShowHideLoadHelperProvider);

        this.reminderTimePresenterImplProvider =
            ReminderTimePresenterImpl_Factory.create(
                MembersInjectors.<ReminderTimePresenterImpl>noOp(),
                ActivityComponentImpl.this.provideNavigatorProvider,
                DaggerAppComponent.this.provideVisitLoadHelperProvider);

        this.provideReminderTimePresenterProvider =
            DoubleCheck.provider(
                FragmentModule_ProvideReminderTimePresenterFactory.create(
                    fragmentModule, reminderTimePresenterImplProvider));

        this.reminderTimeFragmentMembersInjector =
            ReminderTimeFragment_MembersInjector.create(
                provideReminderTimePresenterProvider,
                ActivityComponentImpl.this.provideDialogsHelperProvider);

        this.historyPresenterImplProvider =
            HistoryPresenterImpl_Factory.create(
                MembersInjectors.<HistoryPresenterImpl>noOp(),
                DaggerAppComponent.this.provideEnrollHelperProvider,
                ActivityComponentImpl.this.provideDialogsHelperProvider,
                DaggerAppComponent.this.provideDbProvider,
                ActivityComponentImpl.this.provideNavigatorProvider);

        this.provideHistoryPresenterProvider =
            DoubleCheck.provider(
                FragmentModule_ProvideHistoryPresenterFactory.create(
                    fragmentModule, historyPresenterImplProvider));

        this.reminderHistoryFragmentMembersInjector =
            ReminderHistoryFragment_MembersInjector.create(
                ActivityComponentImpl.this.provideNavigatorProvider,
                provideHistoryPresenterProvider,
                DaggerAppComponent.this.provideSharedPreferencesUtilsProvider,
                ActivityComponentImpl.this.provideShowHideLoadHelperProvider);

        this.confirmSmsPresenterImplProvider =
            ConfirmSmsPresenterImpl_Factory.create(
                MembersInjectors.<ConfirmSmsPresenterImpl>noOp(),
                ActivityComponentImpl.this.provideNavigatorProvider,
                DaggerAppComponent.this.provideAuthHelperProvider,
                DaggerAppComponent.this.providePatientHelperProvider,
                DaggerAppComponent.this.provideSharedPreferencesUtilsProvider,
                ActivityComponentImpl.this.provideDialogsHelperProvider);

        this.provideConfirmSmsPresenterProvider =
            DoubleCheck.provider(
                FragmentModule_ProvideConfirmSmsPresenterFactory.create(
                    fragmentModule, confirmSmsPresenterImplProvider));

        this.confirmSmsFragmentMembersInjector =
            ConfirmSmsFragment_MembersInjector.create(
                provideConfirmSmsPresenterProvider,
                ActivityComponentImpl.this.provideDialogsHelperProvider);

        this.visitPresenterImplProvider =
            VisitPresenterImpl_Factory.create(
                MembersInjectors.<VisitPresenterImpl>noOp(),
                DaggerAppComponent.this.provideDbProvider,
                DaggerAppComponent.this.provideRxUtilProvider,
                DaggerAppComponent.this.provideEnrollHelperProvider,
                ActivityComponentImpl.this.provideNavigatorProvider,
                ActivityComponentImpl.this.provideDialogsHelperProvider,
                DaggerAppComponent.this.providePatientHelperProvider,
                DaggerAppComponent.this.provideSharedPreferencesUtilsProvider);

        this.provideVisitPresenterProvider =
            DoubleCheck.provider(
                FragmentModule_ProvideVisitPresenterFactory.create(
                    fragmentModule, visitPresenterImplProvider));

        this.visitFragmentMembersInjector =
            VisitFragment_MembersInjector.create(
                provideVisitPresenterProvider,
                DaggerAppComponent.this.provideSharedPreferencesUtilsProvider);

        this.diaryRecordEditFragmentPresenterImplProvider =
            DiaryRecordEditFragmentPresenterImpl_Factory.create(
                MembersInjectors.<DiaryRecordEditFragmentPresenterImpl>noOp(),
                DaggerAppComponent.this.provideChangeDiaryHelperProvider,
                ActivityComponentImpl.this.provideDialogsHelperProvider);

        this.provideDiaryRecordEditFragmentPresenterProvider =
            DoubleCheck.provider(
                FragmentModule_ProvideDiaryRecordEditFragmentPresenterFactory.create(
                    fragmentModule, diaryRecordEditFragmentPresenterImplProvider));

        this.diaryRecordEditFragmentMembersInjector =
            DiaryRecordEditFragment_MembersInjector.create(
                provideDiaryRecordEditFragmentPresenterProvider,
                ActivityComponentImpl.this.provideDialogsHelperProvider,
                ActivityComponentImpl.this.provideShowHideLoadHelperProvider);

        this.clinicNearMePresenterImplProvider =
            ClinicNearMePresenterImpl_Factory.create(
                MembersInjectors.<ClinicNearMePresenterImpl>noOp(),
                DaggerAppComponent.this.provideDbProvider,
                DaggerAppComponent.this.provideRxUtilProvider,
                DaggerAppComponent.this.provideSharedPreferencesUtilsProvider,
                DaggerAppComponent.this.providePatientHelperProvider,
                ActivityComponentImpl.this.provideDialogsHelperProvider,
                ActivityComponentImpl.this.provideNavigatorProvider,
                DaggerAppComponent.this.provideDistanceUtilProvider,
                DaggerAppComponent.this.provideClinicLoaderHelperProvider);

        this.provideClinicNearMePresenterProvider =
            DoubleCheck.provider(
                FragmentModule_ProvideClinicNearMePresenterFactory.create(
                    fragmentModule, clinicNearMePresenterImplProvider));

        this.clinicNearMeFragmentMembersInjector =
            ClinicNearMeFragment_MembersInjector.create(
                ActivityComponentImpl.this.provideShowHideLoadHelperProvider,
                provideClinicNearMePresenterProvider,
                ActivityComponentImpl.this.provideDialogsHelperProvider);

        this.locationPresenterImplProvider =
            LocationPresenterImpl_Factory.create(
                MembersInjectors.<LocationPresenterImpl>noOp(),
                DaggerAppComponent.this.providePatientHelperProvider,
                DaggerAppComponent.this.provideSharedPreferencesUtilsProvider);

        this.provideLocationPresenterProvider =
            DoubleCheck.provider(
                FragmentModule_ProvideLocationPresenterFactory.create(
                    fragmentModule, locationPresenterImplProvider));

        this.locationFragmentMembersInjector =
            LocationFragment_MembersInjector.create(
                provideLocationPresenterProvider,
                ActivityComponentImpl.this.provideShowHideLoadHelperProvider);

        this.favoritesDoctorsPresenterImplProvider =
            FavoritesDoctorsPresenterImpl_Factory.create(
                MembersInjectors.<FavoritesDoctorsPresenterImpl>noOp(),
                DaggerAppComponent.this.provideFavoritesDoctorsHelperProvider);

        this.provideFavoritesDoctorsPresenterProvider =
            DoubleCheck.provider(
                FragmentModule_ProvideFavoritesDoctorsPresenterFactory.create(
                    fragmentModule, favoritesDoctorsPresenterImplProvider));

        this.favoritesDoctorsFragmentMembersInjector =
            FavoritesDoctorsFragment_MembersInjector.create(
                provideFavoritesDoctorsPresenterProvider,
                ActivityComponentImpl.this.provideShowHideLoadHelperProvider,
                ActivityComponentImpl.this.provideNavigatorProvider,
                DaggerAppComponent.this.provideSharedPreferencesUtilsProvider,
                ActivityComponentImpl.this.provideDialogsHelperProvider);
      }

      @Override
      public Activity getActivity() {
        return ActivityComponentImpl.this.provideActivityProvider.get();
      }

      @Override
      public void inject(LoginFragment loginFragment) {
        loginFragmentMembersInjector.injectMembers(loginFragment);
      }

      @Override
      public void inject(CityChooseFragment activity) {
        cityChooseFragmentMembersInjector.injectMembers(activity);
      }

      @Override
      public void inject(ClinicChooseFragment activity) {
        clinicChooseFragmentMembersInjector.injectMembers(activity);
      }

      @Override
      public void inject(DiaryRecordsFragment activity) {
        diaryRecordsFragmentMembersInjector.injectMembers(activity);
      }

      @Override
      public void inject(RemembersFragment activity) {
        remembersFragmentMembersInjector.injectMembers(activity);
      }

      @Override
      public void inject(DoctorsFragment activity) {
        doctorsFragmentMembersInjector.injectMembers(activity);
      }

      @Override
      public void inject(FreeTimeFragment activity) {
        MembersInjectors.<FreeTimeFragment>noOp().injectMembers(activity);
      }

      @Override
      public void inject(DepartmentFragment activity) {
        departmentFragmentMembersInjector.injectMembers(activity);
      }

      @Override
      public void inject(SpecialityFragment activity) {
        specialityFragmentMembersInjector.injectMembers(activity);
      }

      @Override
      public void inject(EnrollFragment activity) {
        enrollFragmentMembersInjector.injectMembers(activity);
      }

      @Override
      public void inject(RecipeFragment activity) {
        recipeFragmentMembersInjector.injectMembers(activity);
      }

      @Override
      public void inject(ListPatientFragment activity) {
        listPatientFragmentMembersInjector.injectMembers(activity);
      }

      @Override
      public void inject(ServiceRenderedFragment activity) {
        serviceRenderedFragmentMembersInjector.injectMembers(activity);
      }

      @Override
      public void inject(ScheduleFragment scheduleFragment) {
        scheduleFragmentMembersInjector.injectMembers(scheduleFragment);
      }

      @Override
      public void inject(ReminderTimeFragment reminderTimeFragment) {
        reminderTimeFragmentMembersInjector.injectMembers(reminderTimeFragment);
      }

      @Override
      public void inject(ReminderHistoryFragment reminderHistoryFragment) {
        reminderHistoryFragmentMembersInjector.injectMembers(reminderHistoryFragment);
      }

      @Override
      public void inject(ConfirmSmsFragment confirmSmsFragment) {
        confirmSmsFragmentMembersInjector.injectMembers(confirmSmsFragment);
      }

      @Override
      public void inject(VisitFragment visitFragment) {
        visitFragmentMembersInjector.injectMembers(visitFragment);
      }

      @Override
      public void inject(DiaryRecordEditFragment diaryRecordEditFragment) {
        diaryRecordEditFragmentMembersInjector.injectMembers(diaryRecordEditFragment);
      }

      @Override
      public void inject(ClinicNearMeFragment clinicNearMeFragment) {
        clinicNearMeFragmentMembersInjector.injectMembers(clinicNearMeFragment);
      }

      @Override
      public void inject(LocationFragment locationFragment) {
        locationFragmentMembersInjector.injectMembers(locationFragment);
      }

      @Override
      public void inject(FavoritesDoctorsFragment favoritesDoctorsFragment) {
        favoritesDoctorsFragmentMembersInjector.injectMembers(favoritesDoctorsFragment);
      }
    }
  }
}
