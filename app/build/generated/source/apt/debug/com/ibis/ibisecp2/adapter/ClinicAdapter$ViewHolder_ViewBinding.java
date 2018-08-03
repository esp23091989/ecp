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

public class ClinicAdapter$ViewHolder_ViewBinding implements Unbinder {
  private ClinicAdapter.ViewHolder target;

  @UiThread
  public ClinicAdapter$ViewHolder_ViewBinding(ClinicAdapter.ViewHolder target, View source) {
    this.target = target;

    target.appointmentLpuNameTextView = Utils.findRequiredViewAsType(source, R.id.appointmentLpuNameTextView, "field 'appointmentLpuNameTextView'", TextView.class);
    target.appointmentLpuAddressTextView = Utils.findRequiredViewAsType(source, R.id.appointmentLpuAddressTextView, "field 'appointmentLpuAddressTextView'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    ClinicAdapter.ViewHolder target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.appointmentLpuNameTextView = null;
    target.appointmentLpuAddressTextView = null;
  }
}
