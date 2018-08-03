package com.ibis.ibisecp2.dagger.module;

import com.ibis.ibisecp2.presenters.SpecialityPresenter;
import com.ibis.ibisecp2.presenters.impl.SpecialityPresenterImpl;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class FragmentModule_ProvideSpecialityPresenterFactory
    implements Factory<SpecialityPresenter> {
  private final FragmentModule module;

  private final Provider<SpecialityPresenterImpl> presenterProvider;

  public FragmentModule_ProvideSpecialityPresenterFactory(
      FragmentModule module, Provider<SpecialityPresenterImpl> presenterProvider) {
    assert module != null;
    this.module = module;
    assert presenterProvider != null;
    this.presenterProvider = presenterProvider;
  }

  @Override
  public SpecialityPresenter get() {
    return Preconditions.checkNotNull(
        module.provideSpecialityPresenter(presenterProvider.get()),
        "Cannot return null from a non-@Nullable @Provides method");
  }

  public static Factory<SpecialityPresenter> create(
      FragmentModule module, Provider<SpecialityPresenterImpl> presenterProvider) {
    return new FragmentModule_ProvideSpecialityPresenterFactory(module, presenterProvider);
  }

  /** Proxies {@link FragmentModule#provideSpecialityPresenter(SpecialityPresenterImpl)}. */
  public static SpecialityPresenter proxyProvideSpecialityPresenter(
      FragmentModule instance, SpecialityPresenterImpl presenter) {
    return instance.provideSpecialityPresenter(presenter);
  }
}
