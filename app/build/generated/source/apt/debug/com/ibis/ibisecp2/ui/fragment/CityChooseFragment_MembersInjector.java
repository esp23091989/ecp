package com.ibis.ibisecp2.ui.fragment;

import com.ibis.ibisecp2.helpers.ShowHideLoadHelper;
import com.ibis.ibisecp2.presenters.CityChoosePresenter;
import dagger.MembersInjector;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class CityChooseFragment_MembersInjector
    implements MembersInjector<CityChooseFragment> {
  private final Provider<ShowHideLoadHelper> mHideLoadHelperProvider;

  private final Provider<CityChoosePresenter> cityChoosePresenterProvider;

  public CityChooseFragment_MembersInjector(
      Provider<ShowHideLoadHelper> mHideLoadHelperProvider,
      Provider<CityChoosePresenter> cityChoosePresenterProvider) {
    assert mHideLoadHelperProvider != null;
    this.mHideLoadHelperProvider = mHideLoadHelperProvider;
    assert cityChoosePresenterProvider != null;
    this.cityChoosePresenterProvider = cityChoosePresenterProvider;
  }

  public static MembersInjector<CityChooseFragment> create(
      Provider<ShowHideLoadHelper> mHideLoadHelperProvider,
      Provider<CityChoosePresenter> cityChoosePresenterProvider) {
    return new CityChooseFragment_MembersInjector(
        mHideLoadHelperProvider, cityChoosePresenterProvider);
  }

  @Override
  public void injectMembers(CityChooseFragment instance) {
    if (instance == null) {
      throw new NullPointerException("Cannot inject members into a null reference");
    }
    instance.mHideLoadHelper = mHideLoadHelperProvider.get();
    instance.cityChoosePresenter = cityChoosePresenterProvider.get();
  }

  public static void injectMHideLoadHelper(
      CityChooseFragment instance, Provider<ShowHideLoadHelper> mHideLoadHelperProvider) {
    instance.mHideLoadHelper = mHideLoadHelperProvider.get();
  }

  public static void injectCityChoosePresenter(
      CityChooseFragment instance, Provider<CityChoosePresenter> cityChoosePresenterProvider) {
    instance.cityChoosePresenter = cityChoosePresenterProvider.get();
  }
}
