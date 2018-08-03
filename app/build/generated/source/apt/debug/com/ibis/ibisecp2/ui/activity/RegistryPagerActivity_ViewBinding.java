// Generated code from Butter Knife. Do not modify!
package com.ibis.ibisecp2.ui.activity;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.FrameLayout;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.ibis.ibisecp2.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class RegistryPagerActivity_ViewBinding implements Unbinder {
  private RegistryPagerActivity target;

  @UiThread
  public RegistryPagerActivity_ViewBinding(RegistryPagerActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public RegistryPagerActivity_ViewBinding(RegistryPagerActivity target, View source) {
    this.target = target;

    target.mToolbar = Utils.findRequiredViewAsType(source, R.id.toolbar, "field 'mToolbar'", Toolbar.class);
    target.mProgressLayout = Utils.findRequiredViewAsType(source, R.id.progress_layout, "field 'mProgressLayout'", FrameLayout.class);
    target.mViewPagerRegistry = Utils.findRequiredViewAsType(source, R.id.viewPagerRegistry, "field 'mViewPagerRegistry'", ViewPager.class);
    target.drawer = Utils.findRequiredViewAsType(source, R.id.drawer_layout, "field 'drawer'", DrawerLayout.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    RegistryPagerActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.mToolbar = null;
    target.mProgressLayout = null;
    target.mViewPagerRegistry = null;
    target.drawer = null;
  }
}
