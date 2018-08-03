package com.ibis.ibisecp2.dagger.module;

import com.ibis.ibisecp2.helpers.ProgressDialogHelper;
import com.ibis.ibisecp2.helpers.impl.ProgressDialogHelperImpl;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class ActivityModule_ProvideProgressDialogHelperFactory
    implements Factory<ProgressDialogHelper> {
  private final ActivityModule module;

  private final Provider<ProgressDialogHelperImpl> progressDialogHelperProvider;

  public ActivityModule_ProvideProgressDialogHelperFactory(
      ActivityModule module, Provider<ProgressDialogHelperImpl> progressDialogHelperProvider) {
    assert module != null;
    this.module = module;
    assert progressDialogHelperProvider != null;
    this.progressDialogHelperProvider = progressDialogHelperProvider;
  }

  @Override
  public ProgressDialogHelper get() {
    return Preconditions.checkNotNull(
        module.provideProgressDialogHelper(progressDialogHelperProvider.get()),
        "Cannot return null from a non-@Nullable @Provides method");
  }

  public static Factory<ProgressDialogHelper> create(
      ActivityModule module, Provider<ProgressDialogHelperImpl> progressDialogHelperProvider) {
    return new ActivityModule_ProvideProgressDialogHelperFactory(
        module, progressDialogHelperProvider);
  }

  /** Proxies {@link ActivityModule#provideProgressDialogHelper(ProgressDialogHelperImpl)}. */
  public static ProgressDialogHelper proxyProvideProgressDialogHelper(
      ActivityModule instance, ProgressDialogHelperImpl progressDialogHelper) {
    return instance.provideProgressDialogHelper(progressDialogHelper);
  }
}
