// Generated code from Butter Knife. Do not modify!
package com.ibis.ibisecp2.ui.activity;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.LinearLayout;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.ibis.ibisecp2.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class PersonalActivity_ViewBinding implements Unbinder {
  private PersonalActivity target;

  @UiThread
  public PersonalActivity_ViewBinding(PersonalActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public PersonalActivity_ViewBinding(PersonalActivity target, View source) {
    this.target = target;

    target.toolbar = Utils.findRequiredViewAsType(source, R.id.toolbar, "field 'toolbar'", Toolbar.class);
    target.navView = Utils.findRequiredViewAsType(source, R.id.nav_view, "field 'navView'", NavigationView.class);
    target.drawer = Utils.findRequiredViewAsType(source, R.id.drawer_layout, "field 'drawer'", DrawerLayout.class);
    target.llPersonalInfo = Utils.findRequiredViewAsType(source, R.id.llPersonalInfo, "field 'llPersonalInfo'", LinearLayout.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    PersonalActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.toolbar = null;
    target.navView = null;
    target.drawer = null;
    target.llPersonalInfo = null;
  }
}
