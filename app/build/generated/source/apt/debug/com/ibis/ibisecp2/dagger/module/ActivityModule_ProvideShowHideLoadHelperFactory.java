package com.ibis.ibisecp2.dagger.module;

import com.ibis.ibisecp2.helpers.ShowHideLoadHelper;
import com.ibis.ibisecp2.helpers.impl.ShowHideLoadHelperImpl;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class ActivityModule_ProvideShowHideLoadHelperFactory
    implements Factory<ShowHideLoadHelper> {
  private final ActivityModule module;

  private final Provider<ShowHideLoadHelperImpl> helperProvider;

  public ActivityModule_ProvideShowHideLoadHelperFactory(
      ActivityModule module, Provider<ShowHideLoadHelperImpl> helperProvider) {
    assert module != null;
    this.module = module;
    assert helperProvider != null;
    this.helperProvider = helperProvider;
  }

  @Override
  public ShowHideLoadHelper get() {
    return Preconditions.checkNotNull(
        module.provideShowHideLoadHelper(helperProvider.get()),
        "Cannot return null from a non-@Nullable @Provides method");
  }

  public static Factory<ShowHideLoadHelper> create(
      ActivityModule module, Provider<ShowHideLoadHelperImpl> helperProvider) {
    return new ActivityModule_ProvideShowHideLoadHelperFactory(module, helperProvider);
  }
}
