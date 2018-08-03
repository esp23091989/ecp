// Generated code from Butter Knife. Do not modify!
package com.ibis.ibisecp2.ui.activity;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.AppCompatSpinner;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.ibis.ibisecp2.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class StartActivity_ViewBinding implements Unbinder {
  private StartActivity target;

  private View view2131296308;

  @UiThread
  public StartActivity_ViewBinding(StartActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public StartActivity_ViewBinding(final StartActivity target, View source) {
    this.target = target;

    View view;
    view = Utils.findRequiredView(source, R.id.buttonLogin, "field 'mButtonLogin' and method 'loginClick'");
    target.mButtonLogin = Utils.castView(view, R.id.buttonLogin, "field 'mButtonLogin'", Button.class);
    view2131296308 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.loginClick();
      }
    });
    target.departmentTextView = Utils.findRequiredViewAsType(source, R.id.departmentTextView, "field 'departmentTextView'", TextView.class);
    target.fab = Utils.findRequiredViewAsType(source, R.id.fab, "field 'fab'", FloatingActionButton.class);
    target.fabInfo = Utils.findRequiredViewAsType(source, R.id.fabInfo, "field 'fabInfo'", FloatingActionButton.class);
    target.mSpinner = Utils.findRequiredViewAsType(source, R.id.spinner, "field 'mSpinner'", AppCompatSpinner.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    StartActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.mButtonLogin = null;
    target.departmentTextView = null;
    target.fab = null;
    target.fabInfo = null;
    target.mSpinner = null;

    view2131296308.setOnClickListener(null);
    view2131296308 = null;
  }
}
