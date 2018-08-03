// Generated code from Butter Knife. Do not modify!
package com.ibis.ibisecp2.ui.activity;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.v7.widget.AppCompatSpinner;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.ibis.ibisecp2.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class TasksActivity_ViewBinding implements Unbinder {
  private TasksActivity target;

  private View view2131296302;

  private View view2131296425;

  @UiThread
  public TasksActivity_ViewBinding(TasksActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public TasksActivity_ViewBinding(final TasksActivity target, View source) {
    this.target = target;

    View view;
    target.llCommand = Utils.findRequiredViewAsType(source, R.id.ll_command, "field 'llCommand'", RelativeLayout.class);
    target.toolbar = Utils.findRequiredViewAsType(source, R.id.toolbar, "field 'toolbar'", Toolbar.class);
    target.llCommandsContainer = Utils.findRequiredViewAsType(source, R.id.ll_commands, "field 'llCommandsContainer'", LinearLayout.class);
    target.spinner = Utils.findRequiredViewAsType(source, R.id.spinner_type_command, "field 'spinner'", AppCompatSpinner.class);
    view = Utils.findRequiredView(source, R.id.btn_add_commands, "method 'onClick'");
    view2131296302 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick();
      }
    });
    view = Utils.findRequiredView(source, R.id.ivHelp, "method 'onClickHelp'");
    view2131296425 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClickHelp();
      }
    });
  }

  @Override
  @CallSuper
  public void unbind() {
    TasksActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.llCommand = null;
    target.toolbar = null;
    target.llCommandsContainer = null;
    target.spinner = null;

    view2131296302.setOnClickListener(null);
    view2131296302 = null;
    view2131296425.setOnClickListener(null);
    view2131296425 = null;
  }
}
