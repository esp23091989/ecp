package com.ibis.ibisecp2.retrofit;

import dagger.internal.Factory;
import javax.annotation.Generated;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class RestRepository_Factory implements Factory<RestRepository> {
  private static final RestRepository_Factory INSTANCE = new RestRepository_Factory();

  @Override
  public RestRepository get() {
    return new RestRepository();
  }

  public static Factory<RestRepository> create() {
    return INSTANCE;
  }
}
