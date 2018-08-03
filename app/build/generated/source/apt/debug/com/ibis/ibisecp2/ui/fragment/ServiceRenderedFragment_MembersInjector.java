package com.ibis.ibisecp2.ui.fragment;

import com.ibis.ibisecp2.helpers.ShowHideLoadHelper;
import com.ibis.ibisecp2.presenters.ServiceRenderedPresenter;
import dagger.MembersInjector;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class ServiceRenderedFragment_MembersInjector
    implements MembersInjector<ServiceRenderedFragment> {
  private final Provider<ServiceRenderedPresenter> serviceRenderedPresenterProvider;

  private final Provider<ShowHideLoadHelper> mShowHideLoadHelperProvider;

  public ServiceRenderedFragment_MembersInjector(
      Provider<ServiceRenderedPresenter> serviceRenderedPresenterProvider,
      Provider<ShowHideLoadHelper> mShowHideLoadHelperProvider) {
    assert serviceRenderedPresenterProvider != null;
    this.serviceRenderedPresenterProvider = serviceRenderedPresenterProvider;
    assert mShowHideLoadHelperProvider != null;
    this.mShowHideLoadHelperProvider = mShowHideLoadHelperProvider;
  }

  public static MembersInjector<ServiceRenderedFragment> create(
      Provider<ServiceRenderedPresenter> serviceRenderedPresenterProvider,
      Provider<ShowHideLoadHelper> mShowHideLoadHelperProvider) {
    return new ServiceRenderedFragment_MembersInjector(
        serviceRenderedPresenterProvider, mShowHideLoadHelperProvider);
  }

  @Override
  public void injectMembers(ServiceRenderedFragment instance) {
    if (instance == null) {
      throw new NullPointerException("Cannot inject members into a null reference");
    }
    instance.serviceRenderedPresenter = serviceRenderedPresenterProvider.get();
    instance.mShowHideLoadHelper = mShowHideLoadHelperProvider.get();
  }

  public static void injectServiceRenderedPresenter(
      ServiceRenderedFragment instance,
      Provider<ServiceRenderedPresenter> serviceRenderedPresenterProvider) {
    instance.serviceRenderedPresenter = serviceRenderedPresenterProvider.get();
  }

  public static void injectMShowHideLoadHelper(
      ServiceRenderedFragment instance, Provider<ShowHideLoadHelper> mShowHideLoadHelperProvider) {
    instance.mShowHideLoadHelper = mShowHideLoadHelperProvider.get();
  }
}
