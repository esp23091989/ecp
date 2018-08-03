package com.ibis.ibisecp2.dagger.module;

import com.ibis.ibisecp2.presenters.DiaryRecordEditFragmentPresenter;
import com.ibis.ibisecp2.presenters.impl.DiaryRecordEditFragmentPresenterImpl;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class FragmentModule_ProvideDiaryRecordEditFragmentPresenterFactory
    implements Factory<DiaryRecordEditFragmentPresenter> {
  private final FragmentModule module;

  private final Provider<DiaryRecordEditFragmentPresenterImpl> presenterProvider;

  public FragmentModule_ProvideDiaryRecordEditFragmentPresenterFactory(
      FragmentModule module, Provider<DiaryRecordEditFragmentPresenterImpl> presenterProvider) {
    assert module != null;
    this.module = module;
    assert presenterProvider != null;
    this.presenterProvider = presenterProvider;
  }

  @Override
  public DiaryRecordEditFragmentPresenter get() {
    return Preconditions.checkNotNull(
        module.provideDiaryRecordEditFragmentPresenter(presenterProvider.get()),
        "Cannot return null from a non-@Nullable @Provides method");
  }

  public static Factory<DiaryRecordEditFragmentPresenter> create(
      FragmentModule module, Provider<DiaryRecordEditFragmentPresenterImpl> presenterProvider) {
    return new FragmentModule_ProvideDiaryRecordEditFragmentPresenterFactory(
        module, presenterProvider);
  }

  /**
   * Proxies {@link
   * FragmentModule#provideDiaryRecordEditFragmentPresenter(DiaryRecordEditFragmentPresenterImpl)}.
   */
  public static DiaryRecordEditFragmentPresenter proxyProvideDiaryRecordEditFragmentPresenter(
      FragmentModule instance, DiaryRecordEditFragmentPresenterImpl presenter) {
    return instance.provideDiaryRecordEditFragmentPresenter(presenter);
  }
}
