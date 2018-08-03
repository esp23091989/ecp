// Generated code from Butter Knife. Do not modify!
package com.ibis.ibisecp2.adapter;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.ibis.ibisecp2.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class ScheduleTimeAdapter$ViewHolder_ViewBinding implements Unbinder {
  private ScheduleTimeAdapter.ViewHolder target;

  @UiThread
  public ScheduleTimeAdapter$ViewHolder_ViewBinding(ScheduleTimeAdapter.ViewHolder target,
      View source) {
    this.target = target;

    target.itemGridSchedule = Utils.findRequiredViewAsType(source, R.id.itemGridSchedule, "field 'itemGridSchedule'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    ScheduleTimeAdapter.ViewHolder target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.itemGridSchedule = null;
  }
}
