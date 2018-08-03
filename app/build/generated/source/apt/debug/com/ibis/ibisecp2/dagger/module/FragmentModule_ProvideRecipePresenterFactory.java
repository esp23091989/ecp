package com.ibis.ibisecp2.dagger.module;

import com.ibis.ibisecp2.presenters.RecipePresenter;
import com.ibis.ibisecp2.presenters.impl.RecipePresenterImpl;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class FragmentModule_ProvideRecipePresenterFactory
    implements Factory<RecipePresenter> {
  private final FragmentModule module;

  private final Provider<RecipePresenterImpl> presenterProvider;

  public FragmentModule_ProvideRecipePresenterFactory(
      FragmentModule module, Provider<RecipePresenterImpl> presenterProvider) {
    assert module != null;
    this.module = module;
    assert presenterProvider != null;
    this.presenterProvider = presenterProvider;
  }

  @Override
  public RecipePresenter get() {
    return Preconditions.checkNotNull(
        module.provideRecipePresenter(presenterProvider.get()),
        "Cannot return null from a non-@Nullable @Provides method");
  }

  public static Factory<RecipePresenter> create(
      FragmentModule module, Provider<RecipePresenterImpl> presenterProvider) {
    return new FragmentModule_ProvideRecipePresenterFactory(module, presenterProvider);
  }

  /** Proxies {@link FragmentModule#provideRecipePresenter(RecipePresenterImpl)}. */
  public static RecipePresenter proxyProvideRecipePresenter(
      FragmentModule instance, RecipePresenterImpl presenter) {
    return instance.provideRecipePresenter(presenter);
  }
}
