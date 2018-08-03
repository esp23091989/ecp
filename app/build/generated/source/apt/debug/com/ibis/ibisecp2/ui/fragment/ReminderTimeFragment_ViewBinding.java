// Generated code from Butter Knife. Do not modify!
package com.ibis.ibisecp2.ui.fragment;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.ScrollView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.ibis.ibisecp2.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class ReminderTimeFragment_ViewBinding implements Unbinder {
  private ReminderTimeFragment target;

  private View view2131296444;

  private View view2131296438;

  private View view2131296412;

  private View view2131296414;

  private View view2131296413;

  @UiThread
  public ReminderTimeFragment_ViewBinding(final ReminderTimeFragment target, View source) {
    this.target = target;

    View view;
    target.time = Utils.findRequiredViewAsType(source, R.id.time, "field 'time'", TextView.class);
    target.timeValue = Utils.findRequiredViewAsType(source, R.id.timeValue, "field 'timeValue'", TextView.class);
    view = Utils.findRequiredView(source, R.id.llTime, "field 'llTime' and method 'onClick'");
    target.llTime = Utils.castView(view, R.id.llTime, "field 'llTime'", LinearLayout.class);
    view2131296444 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
    target.dataValue = Utils.findRequiredViewAsType(source, R.id.dataValue, "field 'dataValue'", TextView.class);
    view = Utils.findRequiredView(source, R.id.llData, "field 'llData' and method 'onClick'");
    target.llData = Utils.castView(view, R.id.llData, "field 'llData'", LinearLayout.class);
    view2131296438 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
    target.progressBar = Utils.findRequiredViewAsType(source, R.id.progress_bar, "field 'progressBar'", ProgressBar.class);
    target.svReminderTime = Utils.findRequiredViewAsType(source, R.id.svReminderTime, "field 'svReminderTime'", ScrollView.class);
    view = Utils.findRequiredView(source, R.id.imgBack, "method 'onClick'");
    view2131296412 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.imgSave, "method 'onClick'");
    view2131296414 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.imgDelete, "method 'onClick'");
    view2131296413 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
  }

  @Override
  @CallSuper
  public void unbind() {
    ReminderTimeFragment target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.time = null;
    target.timeValue = null;
    target.llTime = null;
    target.dataValue = null;
    target.llData = null;
    target.progressBar = null;
    target.svReminderTime = null;

    view2131296444.setOnClickListener(null);
    view2131296444 = null;
    view2131296438.setOnClickListener(null);
    view2131296438 = null;
    view2131296412.setOnClickListener(null);
    view2131296412 = null;
    view2131296414.setOnClickListener(null);
    view2131296414 = null;
    view2131296413.setOnClickListener(null);
    view2131296413 = null;
  }
}
