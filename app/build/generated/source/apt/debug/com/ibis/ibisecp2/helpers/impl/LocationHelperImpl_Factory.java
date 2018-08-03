package com.ibis.ibisecp2.helpers.impl;

import android.content.Context;
import dagger.internal.Factory;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class LocationHelperImpl_Factory implements Factory<LocationHelperImpl> {
  private final Provider<Context> mContextProvider;

  public LocationHelperImpl_Factory(Provider<Context> mContextProvider) {
    assert mContextProvider != null;
    this.mContextProvider = mContextProvider;
  }

  @Override
  public LocationHelperImpl get() {
    return new LocationHelperImpl(mContextProvider.get());
  }

  public static Factory<LocationHelperImpl> create(Provider<Context> mContextProvider) {
    return new LocationHelperImpl_Factory(mContextProvider);
  }
}
