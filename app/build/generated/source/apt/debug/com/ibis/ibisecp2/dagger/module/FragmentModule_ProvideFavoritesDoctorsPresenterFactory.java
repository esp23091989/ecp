package com.ibis.ibisecp2.dagger.module;

import com.ibis.ibisecp2.presenters.FavoritesDoctorsPresenter;
import com.ibis.ibisecp2.presenters.impl.FavoritesDoctorsPresenterImpl;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class FragmentModule_ProvideFavoritesDoctorsPresenterFactory
    implements Factory<FavoritesDoctorsPresenter> {
  private final FragmentModule module;

  private final Provider<FavoritesDoctorsPresenterImpl> presenterProvider;

  public FragmentModule_ProvideFavoritesDoctorsPresenterFactory(
      FragmentModule module, Provider<FavoritesDoctorsPresenterImpl> presenterProvider) {
    assert module != null;
    this.module = module;
    assert presenterProvider != null;
    this.presenterProvider = presenterProvider;
  }

  @Override
  public FavoritesDoctorsPresenter get() {
    return Preconditions.checkNotNull(
        module.provideFavoritesDoctorsPresenter(presenterProvider.get()),
        "Cannot return null from a non-@Nullable @Provides method");
  }

  public static Factory<FavoritesDoctorsPresenter> create(
      FragmentModule module, Provider<FavoritesDoctorsPresenterImpl> presenterProvider) {
    return new FragmentModule_ProvideFavoritesDoctorsPresenterFactory(module, presenterProvider);
  }

  /**
   * Proxies {@link FragmentModule#provideFavoritesDoctorsPresenter(FavoritesDoctorsPresenterImpl)}.
   */
  public static FavoritesDoctorsPresenter proxyProvideFavoritesDoctorsPresenter(
      FragmentModule instance, FavoritesDoctorsPresenterImpl presenter) {
    return instance.provideFavoritesDoctorsPresenter(presenter);
  }
}
