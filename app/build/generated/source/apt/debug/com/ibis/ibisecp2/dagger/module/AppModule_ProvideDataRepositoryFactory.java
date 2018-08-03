package com.ibis.ibisecp2.dagger.module;

import com.ibis.ibisecp2.retrofit.Repository;
import com.ibis.ibisecp2.retrofit.RestRepository;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class AppModule_ProvideDataRepositoryFactory implements Factory<Repository> {
  private final AppModule module;

  private final Provider<RestRepository> repositoryProvider;

  public AppModule_ProvideDataRepositoryFactory(
      AppModule module, Provider<RestRepository> repositoryProvider) {
    assert module != null;
    this.module = module;
    assert repositoryProvider != null;
    this.repositoryProvider = repositoryProvider;
  }

  @Override
  public Repository get() {
    return Preconditions.checkNotNull(
        module.provideDataRepository(repositoryProvider.get()),
        "Cannot return null from a non-@Nullable @Provides method");
  }

  public static Factory<Repository> create(
      AppModule module, Provider<RestRepository> repositoryProvider) {
    return new AppModule_ProvideDataRepositoryFactory(module, repositoryProvider);
  }

  /** Proxies {@link AppModule#provideDataRepository(RestRepository)}. */
  public static Repository proxyProvideDataRepository(
      AppModule instance, RestRepository repository) {
    return instance.provideDataRepository(repository);
  }
}
