package com.ibis.ibisecp2.ui.fragment;

import com.ibis.ibisecp2.presenters.VisitPresenter;
import com.ibis.ibisecp2.utils.SharedPreferencesUtils;
import dagger.MembersInjector;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class VisitFragment_MembersInjector implements MembersInjector<VisitFragment> {
  private final Provider<VisitPresenter> mVisitPresenterProvider;

  private final Provider<SharedPreferencesUtils> preferencesUtilsProvider;

  public VisitFragment_MembersInjector(
      Provider<VisitPresenter> mVisitPresenterProvider,
      Provider<SharedPreferencesUtils> preferencesUtilsProvider) {
    assert mVisitPresenterProvider != null;
    this.mVisitPresenterProvider = mVisitPresenterProvider;
    assert preferencesUtilsProvider != null;
    this.preferencesUtilsProvider = preferencesUtilsProvider;
  }

  public static MembersInjector<VisitFragment> create(
      Provider<VisitPresenter> mVisitPresenterProvider,
      Provider<SharedPreferencesUtils> preferencesUtilsProvider) {
    return new VisitFragment_MembersInjector(mVisitPresenterProvider, preferencesUtilsProvider);
  }

  @Override
  public void injectMembers(VisitFragment instance) {
    if (instance == null) {
      throw new NullPointerException("Cannot inject members into a null reference");
    }
    instance.mVisitPresenter = mVisitPresenterProvider.get();
    instance.preferencesUtils = preferencesUtilsProvider.get();
  }

  public static void injectMVisitPresenter(
      VisitFragment instance, Provider<VisitPresenter> mVisitPresenterProvider) {
    instance.mVisitPresenter = mVisitPresenterProvider.get();
  }

  public static void injectPreferencesUtils(
      VisitFragment instance, Provider<SharedPreferencesUtils> preferencesUtilsProvider) {
    instance.preferencesUtils = preferencesUtilsProvider.get();
  }
}
