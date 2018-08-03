package com.ibis.ibisecp2.dagger.module;

import com.ibis.ibisecp2.helpers.ChangeDiaryHelper;
import com.ibis.ibisecp2.helpers.impl.ChangeDiaryHelperImpl;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class HelperModule_ProvideChangeDiaryHelperFactory
    implements Factory<ChangeDiaryHelper> {
  private final HelperModule module;

  private final Provider<ChangeDiaryHelperImpl> helperProvider;

  public HelperModule_ProvideChangeDiaryHelperFactory(
      HelperModule module, Provider<ChangeDiaryHelperImpl> helperProvider) {
    assert module != null;
    this.module = module;
    assert helperProvider != null;
    this.helperProvider = helperProvider;
  }

  @Override
  public ChangeDiaryHelper get() {
    return Preconditions.checkNotNull(
        module.provideChangeDiaryHelper(helperProvider.get()),
        "Cannot return null from a non-@Nullable @Provides method");
  }

  public static Factory<ChangeDiaryHelper> create(
      HelperModule module, Provider<ChangeDiaryHelperImpl> helperProvider) {
    return new HelperModule_ProvideChangeDiaryHelperFactory(module, helperProvider);
  }
}
