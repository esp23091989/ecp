package com.ibis.ibisecp2.dagger.module;

import com.ibis.ibisecp2.presenters.RemembersPresenter;
import com.ibis.ibisecp2.presenters.impl.RemembersPresenterImpl;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class FragmentModule_ProvideRemembersPresenterFactory
    implements Factory<RemembersPresenter> {
  private final FragmentModule module;

  private final Provider<RemembersPresenterImpl> presenterProvider;

  public FragmentModule_ProvideRemembersPresenterFactory(
      FragmentModule module, Provider<RemembersPresenterImpl> presenterProvider) {
    assert module != null;
    this.module = module;
    assert presenterProvider != null;
    this.presenterProvider = presenterProvider;
  }

  @Override
  public RemembersPresenter get() {
    return Preconditions.checkNotNull(
        module.provideRemembersPresenter(presenterProvider.get()),
        "Cannot return null from a non-@Nullable @Provides method");
  }

  public static Factory<RemembersPresenter> create(
      FragmentModule module, Provider<RemembersPresenterImpl> presenterProvider) {
    return new FragmentModule_ProvideRemembersPresenterFactory(module, presenterProvider);
  }

  /** Proxies {@link FragmentModule#provideRemembersPresenter(RemembersPresenterImpl)}. */
  public static RemembersPresenter proxyProvideRemembersPresenter(
      FragmentModule instance, RemembersPresenterImpl presenter) {
    return instance.provideRemembersPresenter(presenter);
  }
}
