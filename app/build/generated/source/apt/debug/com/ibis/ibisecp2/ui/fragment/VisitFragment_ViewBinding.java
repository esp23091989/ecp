// Generated code from Butter Knife. Do not modify!
package com.ibis.ibisecp2.ui.fragment;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.Button;
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

public class VisitFragment_ViewBinding implements Unbinder {
  private VisitFragment target;

  private View view2131296343;

  @UiThread
  public VisitFragment_ViewBinding(final VisitFragment target, View source) {
    this.target = target;

    View view;
    target.mDiaryTicketNumTitleTextView = Utils.findRequiredViewAsType(source, R.id.diaryTicketNumTitleTextView, "field 'mDiaryTicketNumTitleTextView'", TextView.class);
    target.mTvDiaryTicketMo = Utils.findRequiredViewAsType(source, R.id.tvDiaryTicketMo, "field 'mTvDiaryTicketMo'", TextView.class);
    target.mDiaryTicketAdressMoTextView = Utils.findRequiredViewAsType(source, R.id.diaryTicketAdressMoTextView, "field 'mDiaryTicketAdressMoTextView'", TextView.class);
    target.mDiaryTicketSpecialityTextView = Utils.findRequiredViewAsType(source, R.id.diaryTicketSpecialityTextView, "field 'mDiaryTicketSpecialityTextView'", TextView.class);
    target.mDiaryTicketDoctorFullNameTextView = Utils.findRequiredViewAsType(source, R.id.diaryTicketDoctorFullNameTextView, "field 'mDiaryTicketDoctorFullNameTextView'", TextView.class);
    target.mDiaryTicketDateTextView = Utils.findRequiredViewAsType(source, R.id.diaryTicketDateTextView, "field 'mDiaryTicketDateTextView'", TextView.class);
    target.mDiaryFioPatientTextView = Utils.findRequiredViewAsType(source, R.id.diaryFioPatientTextView, "field 'mDiaryFioPatientTextView'", TextView.class);
    target.mTvSource = Utils.findRequiredViewAsType(source, R.id.tvSource, "field 'mTvSource'", TextView.class);
    target.mTvStatus = Utils.findRequiredViewAsType(source, R.id.tvStatus, "field 'mTvStatus'", TextView.class);
    target.mDiaryTicketViewLayout = Utils.findRequiredViewAsType(source, R.id.diaryTicketViewLayout, "field 'mDiaryTicketViewLayout'", LinearLayout.class);
    view = Utils.findRequiredView(source, R.id.deleteDiaryTicketButton, "field 'mDeleteDiaryTicketButton' and method 'onClick'");
    target.mDeleteDiaryTicketButton = Utils.castView(view, R.id.deleteDiaryTicketButton, "field 'mDeleteDiaryTicketButton'", Button.class);
    view2131296343 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick();
      }
    });
    target.mDiaryTicketLayout = Utils.findRequiredViewAsType(source, R.id.diaryTicketLayout, "field 'mDiaryTicketLayout'", ScrollView.class);
    target.mFvProgressBar = Utils.findRequiredViewAsType(source, R.id.fv_progress_bar, "field 'mFvProgressBar'", ProgressBar.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    VisitFragment target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.mDiaryTicketNumTitleTextView = null;
    target.mTvDiaryTicketMo = null;
    target.mDiaryTicketAdressMoTextView = null;
    target.mDiaryTicketSpecialityTextView = null;
    target.mDiaryTicketDoctorFullNameTextView = null;
    target.mDiaryTicketDateTextView = null;
    target.mDiaryFioPatientTextView = null;
    target.mTvSource = null;
    target.mTvStatus = null;
    target.mDiaryTicketViewLayout = null;
    target.mDeleteDiaryTicketButton = null;
    target.mDiaryTicketLayout = null;
    target.mFvProgressBar = null;

    view2131296343.setOnClickListener(null);
    view2131296343 = null;
  }
}
