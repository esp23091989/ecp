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

public class DoctorAdapter$ViewHolder_ViewBinding implements Unbinder {
  private DoctorAdapter.ViewHolder target;

  @UiThread
  public DoctorAdapter$ViewHolder_ViewBinding(DoctorAdapter.ViewHolder target, View source) {
    this.target = target;

    target.tvDoctorName = Utils.findRequiredViewAsType(source, R.id.tv_doctor_name, "field 'tvDoctorName'", TextView.class);
    target.tvDoctorSpeciality = Utils.findRequiredViewAsType(source, R.id.tv_doctor_speciality, "field 'tvDoctorSpeciality'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    DoctorAdapter.ViewHolder target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.tvDoctorName = null;
    target.tvDoctorSpeciality = null;
  }
}
