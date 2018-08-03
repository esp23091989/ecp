package com.ibis.ibisecp2.dagger.module;

import com.ibis.ibisecp2.presenters.DiaryRecordPresenter;
import com.ibis.ibisecp2.presenters.impl.DiaryRecordPresenterImpl;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class FragmentModule_ProvideDiaryRecordPresenterFactory
    implements Factory<DiaryRecordPresenter> {
  private final FragmentModule module;

  private final Provider<DiaryRecordPresenterImpl> presenterProvider;

  public FragmentModule_ProvideDiaryRecordPresenterFactory(
      FragmentModule module, Provider<DiaryRecordPresenterImpl> presenterProvider) {
    assert module != null;
    this.module = module;
    assert presenterProvider != null;
    this.presenterProvider = presenterProvider;
  }

  @Override
  public DiaryRecordPresenter get() {
    return Preconditions.checkNotNull(
        module.provideDiaryRecordPresenter(presenterProvider.get()),
        "Cannot return null from a non-@Nullable @Provides method");
  }

  public static Factory<DiaryRecordPresenter> create(
      FragmentModule module, Provider<DiaryRecordPresenterImpl> presenterProvider) {
    return new FragmentModule_ProvideDiaryRecordPresenterFactory(module, presenterProvider);
  }

  /** Proxies {@link FragmentModule#provideDiaryRecordPresenter(DiaryRecordPresenterImpl)}. */
  public static DiaryRecordPresenter proxyProvideDiaryRecordPresenter(
      FragmentModule instance, DiaryRecordPresenterImpl presenter) {
    return instance.provideDiaryRecordPresenter(presenter);
  }
}
