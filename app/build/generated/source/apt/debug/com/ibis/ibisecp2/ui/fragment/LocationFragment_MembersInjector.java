package com.ibis.ibisecp2.ui.fragment;

import com.ibis.ibisecp2.helpers.ShowHideLoadHelper;
import com.ibis.ibisecp2.presenters.LocationPresenter;
import dagger.MembersInjector;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class LocationFragment_MembersInjector implements MembersInjector<LocationFragment> {
  private final Provider<LocationPresenter> mLocationPresenterProvider;

  private final Provider<ShowHideLoadHelper> mShowHideLoadHelperProvider;

  public LocationFragment_MembersInjector(
      Provider<LocationPresenter> mLocationPresenterProvider,
      Provider<ShowHideLoadHelper> mShowHideLoadHelperProvider) {
    assert mLocationPresenterProvider != null;
    this.mLocationPresenterProvider = mLocationPresenterProvider;
    assert mShowHideLoadHelperProvider != null;
    this.mShowHideLoadHelperProvider = mShowHideLoadHelperProvider;
  }

  public static MembersInjector<LocationFragment> create(
      Provider<LocationPresenter> mLocationPresenterProvider,
      Provider<ShowHideLoadHelper> mShowHideLoadHelperProvider) {
    return new LocationFragment_MembersInjector(
        mLocationPresenterProvider, mShowHideLoadHelperProvider);
  }

  @Override
  public void injectMembers(LocationFragment instance) {
    if (instance == null) {
      throw new NullPointerException("Cannot inject members into a null reference");
    }
    instance.mLocationPresenter = mLocationPresenterProvider.get();
    instance.mShowHideLoadHelper = mShowHideLoadHelperProvider.get();
  }

  public static void injectMLocationPresenter(
      LocationFragment instance, Provider<LocationPresenter> mLocationPresenterProvider) {
    instance.mLocationPresenter = mLocationPresenterProvider.get();
  }

  public static void injectMShowHideLoadHelper(
      LocationFragment instance, Provider<ShowHideLoadHelper> mShowHideLoadHelperProvider) {
    instance.mShowHideLoadHelper = mShowHideLoadHelperProvider.get();
  }
}
