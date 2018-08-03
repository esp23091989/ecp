package com.ibis.ibisecp2.dagger.module;

import com.ibis.ibisecp2.helpers.DiaryRecordsLoaderHelper;
import com.ibis.ibisecp2.helpers.impl.DiaryRecordsLoaderHelperImpl;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class HelperModule_ProvideDiaryRecordsLoaderHelperFactory
    implements Factory<DiaryRecordsLoaderHelper> {
  private final HelperModule module;

  private final Provider<DiaryRecordsLoaderHelperImpl> helperProvider;

  public HelperModule_ProvideDiaryRecordsLoaderHelperFactory(
      HelperModule module, Provider<DiaryRecordsLoaderHelperImpl> helperProvider) {
    assert module != null;
    this.module = module;
    assert helperProvider != null;
    this.helperProvider = helperProvider;
  }

  @Override
  public DiaryRecordsLoaderHelper get() {
    return Preconditions.checkNotNull(
        module.provideDiaryRecordsLoaderHelper(helperProvider.get()),
        "Cannot return null from a non-@Nullable @Provides method");
  }

  public static Factory<DiaryRecordsLoaderHelper> create(
      HelperModule module, Provider<DiaryRecordsLoaderHelperImpl> helperProvider) {
    return new HelperModule_ProvideDiaryRecordsLoaderHelperFactory(module, helperProvider);
  }
}
