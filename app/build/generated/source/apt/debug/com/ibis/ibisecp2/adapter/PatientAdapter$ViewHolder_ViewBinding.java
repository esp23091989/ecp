// Generated code from Butter Knife. Do not modify!
package com.ibis.ibisecp2.adapter;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.ibis.ibisecp2.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class PatientAdapter$ViewHolder_ViewBinding implements Unbinder {
  private PatientAdapter.ViewHolder target;

  @UiThread
  public PatientAdapter$ViewHolder_ViewBinding(PatientAdapter.ViewHolder target, View source) {
    this.target = target;

    target.label = Utils.findRequiredViewAsType(source, R.id.label, "field 'label'", TextView.class);
    target.llPatientItem = Utils.findRequiredViewAsType(source, R.id.llPatientItem, "field 'llPatientItem'", LinearLayout.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    PatientAdapter.ViewHolder target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.label = null;
    target.llPatientItem = null;
  }
}
