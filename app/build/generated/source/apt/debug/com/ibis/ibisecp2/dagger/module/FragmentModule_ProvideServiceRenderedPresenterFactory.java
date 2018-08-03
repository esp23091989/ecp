package com.ibis.ibisecp2.dagger.module;

import com.ibis.ibisecp2.presenters.ServiceRenderedPresenter;
import com.ibis.ibisecp2.presenters.impl.ServiceRenderedPresenterImpl;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class FragmentModule_ProvideServiceRenderedPresenterFactory
    implements Factory<ServiceRenderedPresenter> {
  private final FragmentModule module;

  private final Provider<ServiceRenderedPresenterImpl> presenterProvider;

  public FragmentModule_ProvideServiceRenderedPresenterFactory(
      FragmentModule module, Provider<ServiceRenderedPresenterImpl> presenterProvider) {
    assert module != null;
    this.module = module;
    assert presenterProvider != null;
    this.presenterProvider = presenterProvider;
  }

  @Override
  public ServiceRenderedPresenter get() {
    return Preconditions.checkNotNull(
        module.provideServiceRenderedPresenter(presenterProvider.get()),
        "Cannot return null from a non-@Nullable @Provides method");
  }

  public static Factory<ServiceRenderedPresenter> create(
      FragmentModule module, Provider<ServiceRenderedPresenterImpl> presenterProvider) {
    return new FragmentModule_ProvideServiceRenderedPresenterFactory(module, presenterProvider);
  }

  /**
   * Proxies {@link FragmentModule#provideServiceRenderedPresenter(ServiceRenderedPresenterImpl)}.
   */
  public static ServiceRenderedPresenter proxyProvideServiceRenderedPresenter(
      FragmentModule instance, ServiceRenderedPresenterImpl presenter) {
    return instance.provideServiceRenderedPresenter(presenter);
  }
}
