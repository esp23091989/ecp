package com.ibis.ibisecp2.service;

import com.ibis.ibisecp2.helpers.DoctorLoaderHelper;
import com.ibis.ibisecp2.utils.SharedPreferencesUtils;
import dagger.MembersInjector;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class DoctorService_MembersInjector implements MembersInjector<DoctorService> {
  private final Provider<DoctorLoaderHelper> mDoctorLoaderHelperProvider;

  private final Provider<SharedPreferencesUtils> mPreferencesProvider;

  public DoctorService_MembersInjector(
      Provider<DoctorLoaderHelper> mDoctorLoaderHelperProvider,
      Provider<SharedPreferencesUtils> mPreferencesProvider) {
    assert mDoctorLoaderHelperProvider != null;
    this.mDoctorLoaderHelperProvider = mDoctorLoaderHelperProvider;
    assert mPreferencesProvider != null;
    this.mPreferencesProvider = mPreferencesProvider;
  }

  public static MembersInjector<DoctorService> create(
      Provider<DoctorLoaderHelper> mDoctorLoaderHelperProvider,
      Provider<SharedPreferencesUtils> mPreferencesProvider) {
    return new DoctorService_MembersInjector(mDoctorLoaderHelperProvider, mPreferencesProvider);
  }

  @Override
  public void injectMembers(DoctorService instance) {
    if (instance == null) {
      throw new NullPointerException("Cannot inject members into a null reference");
    }
    instance.mDoctorLoaderHelper = mDoctorLoaderHelperProvider.get();
    instance.mPreferences = mPreferencesProvider.get();
  }

  public static void injectMDoctorLoaderHelper(
      DoctorService instance, Provider<DoctorLoaderHelper> mDoctorLoaderHelperProvider) {
    instance.mDoctorLoaderHelper = mDoctorLoaderHelperProvider.get();
  }

  public static void injectMPreferences(
      DoctorService instance, Provider<SharedPreferencesUtils> mPreferencesProvider) {
    instance.mPreferences = mPreferencesProvider.get();
  }
}
