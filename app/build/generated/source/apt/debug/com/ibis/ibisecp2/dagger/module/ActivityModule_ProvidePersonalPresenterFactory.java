package com.ibis.ibisecp2.dagger.module;

import com.ibis.ibisecp2.presenters.PersonalPresenter;
import com.ibis.ibisecp2.presenters.impl.PersonalPresenterImpl;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class ActivityModule_ProvidePersonalPresenterFactory
    implements Factory<PersonalPresenter> {
  private final ActivityModule module;

  private final Provider<PersonalPresenterImpl> presenterProvider;

  public ActivityModule_ProvidePersonalPresenterFactory(
      ActivityModule module, Provider<PersonalPresenterImpl> presenterProvider) {
    assert module != null;
    this.module = module;
    assert presenterProvider != null;
    this.presenterProvider = presenterProvider;
  }

  @Override
  public PersonalPresenter get() {
    return Preconditions.checkNotNull(
        module.providePersonalPresenter(presenterProvider.get()),
        "Cannot return null from a non-@Nullable @Provides method");
  }

  public static Factory<PersonalPresenter> create(
      ActivityModule module, Provider<PersonalPresenterImpl> presenterProvider) {
    return new ActivityModule_ProvidePersonalPresenterFactory(module, presenterProvider);
  }

  /** Proxies {@link ActivityModule#providePersonalPresenter(PersonalPresenterImpl)}. */
  public static PersonalPresenter proxyProvidePersonalPresenter(
      ActivityModule instance, PersonalPresenterImpl presenter) {
    return instance.providePersonalPresenter(presenter);
  }
}
