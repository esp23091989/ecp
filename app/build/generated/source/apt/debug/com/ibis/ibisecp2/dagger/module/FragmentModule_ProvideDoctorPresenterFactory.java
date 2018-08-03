package com.ibis.ibisecp2.dagger.module;

import com.ibis.ibisecp2.presenters.DepartmentPresenter;
import com.ibis.ibisecp2.presenters.impl.DepartmentPresenterImpl;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class FragmentModule_ProvideDoctorPresenterFactory
    implements Factory<DepartmentPresenter> {
  private final FragmentModule module;

  private final Provider<DepartmentPresenterImpl> presenterProvider;

  public FragmentModule_ProvideDoctorPresenterFactory(
      FragmentModule module, Provider<DepartmentPresenterImpl> presenterProvider) {
    assert module != null;
    this.module = module;
    assert presenterProvider != null;
    this.presenterProvider = presenterProvider;
  }

  @Override
  public DepartmentPresenter get() {
    return Preconditions.checkNotNull(
        module.provideDoctorPresenter(presenterProvider.get()),
        "Cannot return null from a non-@Nullable @Provides method");
  }

  public static Factory<DepartmentPresenter> create(
      FragmentModule module, Provider<DepartmentPresenterImpl> presenterProvider) {
    return new FragmentModule_ProvideDoctorPresenterFactory(module, presenterProvider);
  }

  /** Proxies {@link FragmentModule#provideDoctorPresenter(DepartmentPresenterImpl)}. */
  public static DepartmentPresenter proxyProvideDoctorPresenter(
      FragmentModule instance, DepartmentPresenterImpl presenter) {
    return instance.provideDoctorPresenter(presenter);
  }
}
