// Generated code from Butter Knife. Do not modify!
package com.ibis.ibisecp2.ui.fragment;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.ibis.ibisecp2.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class FreeTimeFragment_ViewBinding implements Unbinder {
  private FreeTimeFragment target;

  @UiThread
  public FreeTimeFragment_ViewBinding(FreeTimeFragment target, View source) {
    this.target = target;

    target.rvFreTime = Utils.findRequiredViewAsType(source, R.id.rvFreTime, "field 'rvFreTime'", RecyclerView.class);
    target.appointmentTimeLayoutTitleTextView = Utils.findRequiredViewAsType(source, R.id.appointmentTimeLayoutTitleTextView, "field 'appointmentTimeLayoutTitleTextView'", TextView.class);
    target.tvScheduleInfo = Utils.findRequiredViewAsType(source, R.id.tvScheduleInfo, "field 'tvScheduleInfo'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    FreeTimeFragment target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.rvFreTime = null;
    target.appointmentTimeLayoutTitleTextView = null;
    target.tvScheduleInfo = null;
  }
}
