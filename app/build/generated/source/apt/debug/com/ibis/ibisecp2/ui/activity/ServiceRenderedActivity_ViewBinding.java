// Generated code from Butter Knife. Do not modify!
package com.ibis.ibisecp2.ui.activity;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.FrameLayout;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.ibis.ibisecp2.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class ServiceRenderedActivity_ViewBinding implements Unbinder {
  private ServiceRenderedActivity target;

  @UiThread
  public ServiceRenderedActivity_ViewBinding(ServiceRenderedActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public ServiceRenderedActivity_ViewBinding(ServiceRenderedActivity target, View source) {
    this.target = target;

    target.toolbar = Utils.findRequiredViewAsType(source, R.id.toolbar, "field 'toolbar'", Toolbar.class);
    target.navView = Utils.findRequiredViewAsType(source, R.id.nav_view, "field 'navView'", NavigationView.class);
    target.drawer = Utils.findRequiredViewAsType(source, R.id.drawer_layout, "field 'drawer'", DrawerLayout.class);
    target.mProgressLayout = Utils.findRequiredViewAsType(source, R.id.progress_layout, "field 'mProgressLayout'", FrameLayout.class);
    target.mContentFrame = Utils.findRequiredViewAsType(source, R.id.contentFrame, "field 'mContentFrame'", FrameLayout.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    ServiceRenderedActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.toolbar = null;
    target.navView = null;
    target.drawer = null;
    target.mProgressLayout = null;
    target.mContentFrame = null;
  }
}
