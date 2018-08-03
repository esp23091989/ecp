package com.ibis.ibisecp2.dagger.module;

import com.ibis.ibisecp2.presenters.DiaryEditRecordsPresenter;
import com.ibis.ibisecp2.presenters.impl.DiaryEditRecordsPresenterImpl;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class ActivityModule_ProvideDiaryEditRecordsPresenterFactory
    implements Factory<DiaryEditRecordsPresenter> {
  private final ActivityModule module;

  private final Provider<DiaryEditRecordsPresenterImpl> presenterProvider;

  public ActivityModule_ProvideDiaryEditRecordsPresenterFactory(
      ActivityModule module, Provider<DiaryEditRecordsPresenterImpl> presenterProvider) {
    assert module != null;
    this.module = module;
    assert presenterProvider != null;
    this.presenterProvider = presenterProvider;
  }

  @Override
  public DiaryEditRecordsPresenter get() {
    return Preconditions.checkNotNull(
        module.provideDiaryEditRecordsPresenter(presenterProvider.get()),
        "Cannot return null from a non-@Nullable @Provides method");
  }

  public static Factory<DiaryEditRecordsPresenter> create(
      ActivityModule module, Provider<DiaryEditRecordsPresenterImpl> presenterProvider) {
    return new ActivityModule_ProvideDiaryEditRecordsPresenterFactory(module, presenterProvider);
  }

  /**
   * Proxies {@link ActivityModule#provideDiaryEditRecordsPresenter(DiaryEditRecordsPresenterImpl)}.
   */
  public static DiaryEditRecordsPresenter proxyProvideDiaryEditRecordsPresenter(
      ActivityModule instance, DiaryEditRecordsPresenterImpl presenter) {
    return instance.provideDiaryEditRecordsPresenter(presenter);
  }
}
