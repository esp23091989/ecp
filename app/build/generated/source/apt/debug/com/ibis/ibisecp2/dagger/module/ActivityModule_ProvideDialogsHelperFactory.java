package com.ibis.ibisecp2.dagger.module;

import com.ibis.ibisecp2.helpers.DialogsHelper;
import com.ibis.ibisecp2.helpers.impl.DialogHelperImpl;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class ActivityModule_ProvideDialogsHelperFactory implements Factory<DialogsHelper> {
  private final ActivityModule module;

  private final Provider<DialogHelperImpl> dialogHelperProvider;

  public ActivityModule_ProvideDialogsHelperFactory(
      ActivityModule module, Provider<DialogHelperImpl> dialogHelperProvider) {
    assert module != null;
    this.module = module;
    assert dialogHelperProvider != null;
    this.dialogHelperProvider = dialogHelperProvider;
  }

  @Override
  public DialogsHelper get() {
    return Preconditions.checkNotNull(
        module.provideDialogsHelper(dialogHelperProvider.get()),
        "Cannot return null from a non-@Nullable @Provides method");
  }

  public static Factory<DialogsHelper> create(
      ActivityModule module, Provider<DialogHelperImpl> dialogHelperProvider) {
    return new ActivityModule_ProvideDialogsHelperFactory(module, dialogHelperProvider);
  }

  /** Proxies {@link ActivityModule#provideDialogsHelper(DialogHelperImpl)}. */
  public static DialogsHelper proxyProvideDialogsHelper(
      ActivityModule instance, DialogHelperImpl dialogHelper) {
    return instance.provideDialogsHelper(dialogHelper);
  }
}
