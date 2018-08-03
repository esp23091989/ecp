// Generated code from Butter Knife. Do not modify!
package com.ibis.ibisecp2.ui.fragment;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.Button;
import android.widget.ScrollView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.ibis.ibisecp2.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class EnrollFragment_ViewBinding implements Unbinder {
  private EnrollFragment target;

  private View view2131296309;

  private View view2131296305;

  @UiThread
  public EnrollFragment_ViewBinding(final EnrollFragment target, View source) {
    this.target = target;

    View view;
    target.textViewApproveClinic = Utils.findRequiredViewAsType(source, R.id.textViewApproveClinic, "field 'textViewApproveClinic'", TextView.class);
    target.textViewApproveClinicName = Utils.findRequiredViewAsType(source, R.id.textViewApproveClinicName, "field 'textViewApproveClinicName'", TextView.class);
    target.textViewApproveDoctorTitle = Utils.findRequiredViewAsType(source, R.id.textViewApproveDoctorTitle, "field 'textViewApproveDoctorTitle'", TextView.class);
    target.textViewApproveDoctorName = Utils.findRequiredViewAsType(source, R.id.textViewApproveDoctorName, "field 'textViewApproveDoctorName'", TextView.class);
    target.textViewApproveDateTitle = Utils.findRequiredViewAsType(source, R.id.textViewApproveDateTitle, "field 'textViewApproveDateTitle'", TextView.class);
    target.textViewApproveDate = Utils.findRequiredViewAsType(source, R.id.textViewApproveDate, "field 'textViewApproveDate'", TextView.class);
    target.textViewApproveTimeTitle = Utils.findRequiredViewAsType(source, R.id.textViewApproveTimeTitle, "field 'textViewApproveTimeTitle'", TextView.class);
    target.textViewApproveTime = Utils.findRequiredViewAsType(source, R.id.textViewApproveTime, "field 'textViewApproveTime'", TextView.class);
    view = Utils.findRequiredView(source, R.id.buttonOkApprove, "field 'buttonOkApprove' and method 'onClick'");
    target.buttonOkApprove = Utils.castView(view, R.id.buttonOkApprove, "field 'buttonOkApprove'", Button.class);
    view2131296309 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick();
      }
    });
    view = Utils.findRequiredView(source, R.id.buttonCancelApprove, "field 'buttonCancelApprove' and method 'cancelApprove'");
    target.buttonCancelApprove = Utils.castView(view, R.id.buttonCancelApprove, "field 'buttonCancelApprove'", Button.class);
    view2131296305 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.cancelApprove();
      }
    });
    target.tvDepName = Utils.findRequiredViewAsType(source, R.id.tvDepName, "field 'tvDepName'", TextView.class);
    target.tvSpecName = Utils.findRequiredViewAsType(source, R.id.tvSpecName, "field 'tvSpecName'", TextView.class);
    target.tvSlotTypeTitle = Utils.findRequiredViewAsType(source, R.id.tvSlotTypeTitle, "field 'tvSlotTypeTitle'", TextView.class);
    target.tvSlotType = Utils.findRequiredViewAsType(source, R.id.tvSlotType, "field 'tvSlotType'", TextView.class);
    target.tvNoteTitle = Utils.findRequiredViewAsType(source, R.id.tvNoteTitle, "field 'tvNoteTitle'", TextView.class);
    target.tvNote = Utils.findRequiredViewAsType(source, R.id.tvNote, "field 'tvNote'", TextView.class);
    target.svAppointmentApprove = Utils.findRequiredViewAsType(source, R.id.svAppointmentApprove, "field 'svAppointmentApprove'", ScrollView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    EnrollFragment target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.textViewApproveClinic = null;
    target.textViewApproveClinicName = null;
    target.textViewApproveDoctorTitle = null;
    target.textViewApproveDoctorName = null;
    target.textViewApproveDateTitle = null;
    target.textViewApproveDate = null;
    target.textViewApproveTimeTitle = null;
    target.textViewApproveTime = null;
    target.buttonOkApprove = null;
    target.buttonCancelApprove = null;
    target.tvDepName = null;
    target.tvSpecName = null;
    target.tvSlotTypeTitle = null;
    target.tvSlotType = null;
    target.tvNoteTitle = null;
    target.tvNote = null;
    target.svAppointmentApprove = null;

    view2131296309.setOnClickListener(null);
    view2131296309 = null;
    view2131296305.setOnClickListener(null);
    view2131296305 = null;
  }
}
