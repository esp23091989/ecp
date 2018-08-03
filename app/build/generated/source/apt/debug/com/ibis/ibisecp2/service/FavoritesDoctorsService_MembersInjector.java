package com.ibis.ibisecp2.service;

import com.ibis.ibisecp2.helpers.FavoritesDoctorsHelper;
import dagger.MembersInjector;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class FavoritesDoctorsService_MembersInjector
    implements MembersInjector<FavoritesDoctorsService> {
  private final Provider<FavoritesDoctorsHelper> mHelperProvider;

  public FavoritesDoctorsService_MembersInjector(Provider<FavoritesDoctorsHelper> mHelperProvider) {
    assert mHelperProvider != null;
    this.mHelperProvider = mHelperProvider;
  }

  public static MembersInjector<FavoritesDoctorsService> create(
      Provider<FavoritesDoctorsHelper> mHelperProvider) {
    return new FavoritesDoctorsService_MembersInjector(mHelperProvider);
  }

  @Override
  public void injectMembers(FavoritesDoctorsService instance) {
    if (instance == null) {
      throw new NullPointerException("Cannot inject members into a null reference");
    }
    instance.mHelper = mHelperProvider.get();
  }

  public static void injectMHelper(
      FavoritesDoctorsService instance, Provider<FavoritesDoctorsHelper> mHelperProvider) {
    instance.mHelper = mHelperProvider.get();
  }
}
