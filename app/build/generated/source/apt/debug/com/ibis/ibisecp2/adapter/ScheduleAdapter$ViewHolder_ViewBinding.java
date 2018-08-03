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

public class ScheduleAdapter$ViewHolder_ViewBinding implements Unbinder {
  private ScheduleAdapter.ViewHolder target;

  @UiThread
  public ScheduleAdapter$ViewHolder_ViewBinding(ScheduleAdapter.ViewHolder target, View source) {
    this.target = target;

    target.mItemGridSchedule = Utils.findRequiredViewAsType(source, R.id.itemGridSchedule, "field 'mItemGridSchedule'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    ScheduleAdapter.ViewHolder target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.mItemGridSchedule = null;
  }
}
