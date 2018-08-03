package com.ibis.ibisecp2.presenters.impl;

import com.ibis.ibisecp2.helpers.FavoritesDoctorsHelper;
import dagger.MembersInjector;
import dagger.internal.Factory;
import dagger.internal.MembersInjectors;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class FavoritesDoctorsPresenterImpl_Factory
    implements Factory<FavoritesDoctorsPresenterImpl> {
  private final MembersInjector<FavoritesDoctorsPresenterImpl>
      favoritesDoctorsPresenterImplMembersInjector;

  private final Provider<FavoritesDoctorsHelper> doctorsHelperProvider;

  public FavoritesDoctorsPresenterImpl_Factory(
      MembersInjector<FavoritesDoctorsPresenterImpl> favoritesDoctorsPresenterImplMembersInjector,
      Provider<FavoritesDoctorsHelper> doctorsHelperProvider) {
    assert favoritesDoctorsPresenterImplMembersInjector != null;
    this.favoritesDoctorsPresenterImplMembersInjector =
        favoritesDoctorsPresenterImplMembersInjector;
    assert doctorsHelperProvider != null;
    this.doctorsHelperProvider = doctorsHelperProvider;
  }

  @Override
  public FavoritesDoctorsPresenterImpl get() {
    return MembersInjectors.injectMembers(
        favoritesDoctorsPresenterImplMembersInjector,
        new FavoritesDoctorsPresenterImpl(doctorsHelperProvider.get()));
  }

  public static Factory<FavoritesDoctorsPresenterImpl> create(
      MembersInjector<FavoritesDoctorsPresenterImpl> favoritesDoctorsPresenterImplMembersInjector,
      Provider<FavoritesDoctorsHelper> doctorsHelperProvider) {
    return new FavoritesDoctorsPresenterImpl_Factory(
        favoritesDoctorsPresenterImplMembersInjector, doctorsHelperProvider);
  }
}
