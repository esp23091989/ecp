// Generated code from Butter Knife. Do not modify!
package com.ibis.ibisecp2.ui.activity;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.AppCompatSpinner;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.CheckBox;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.ibis.ibisecp2.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class SetupNotificationActivity_ViewBinding implements Unbinder {
  private SetupNotificationActivity target;

  private View view2131296317;

  @UiThread
  public SetupNotificationActivity_ViewBinding(SetupNotificationActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public SetupNotificationActivity_ViewBinding(final SetupNotificationActivity target,
      View source) {
    this.target = target;

    View view;
    target.spinner = Utils.findRequiredViewAsType(source, R.id.spinnerReminderTime, "field 'spinner'", AppCompatSpinner.class);
    target.toolbar = Utils.findRequiredViewAsType(source, R.id.toolbar, "field 'toolbar'", Toolbar.class);
    target.navView = Utils.findRequiredViewAsType(source, R.id.nav_view, "field 'navView'", NavigationView.class);
    target.drawer = Utils.findRequiredViewAsType(source, R.id.drawer_layout, "field 'drawer'", DrawerLayout.class);
    view = Utils.findRequiredView(source, R.id.chbOnNotification, "field 'chbOnNotification' and method 'onClick'");
    target.chbOnNotification = Utils.castView(view, R.id.chbOnNotification, "field 'chbOnNotification'", CheckBox.class);
    view2131296317 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick();
      }
    });
  }

  @Override
  @CallSuper
  public void unbind() {
    SetupNotificationActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.spinner = null;
    target.toolbar = null;
    target.navView = null;
    target.drawer = null;
    target.chbOnNotification = null;

    view2131296317.setOnClickListener(null);
    view2131296317 = null;
  }
}
