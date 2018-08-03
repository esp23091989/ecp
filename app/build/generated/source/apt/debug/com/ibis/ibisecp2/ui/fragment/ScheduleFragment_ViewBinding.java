// Generated code from Butter Knife. Do not modify!
package com.ibis.ibisecp2.ui.fragment;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.ibis.ibisecp2.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class ScheduleFragment_ViewBinding implements Unbinder {
  private ScheduleFragment target;

  private View view2131296303;

  @UiThread
  public ScheduleFragment_ViewBinding(final ScheduleFragment target, View source) {
    this.target = target;

    View view;
    target.linearLayoutChooseData = Utils.findRequiredViewAsType(source, R.id.linearLayoutChooseData, "field 'linearLayoutChooseData'", LinearLayout.class);
    target.llError = Utils.findRequiredViewAsType(source, R.id.ll_error, "field 'llError'", LinearLayout.class);
    target.tvNoData = Utils.findRequiredViewAsType(source, R.id.tv_no_data, "field 'tvNoData'", TextView.class);
    view = Utils.findRequiredView(source, R.id.btn_update, "field 'btnUpdate' and method 'onClick'");
    target.btnUpdate = Utils.castView(view, R.id.btn_update, "field 'btnUpdate'", Button.class);
    view2131296303 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick();
      }
    });
    target.textViewChooseDataTitle = Utils.findRequiredViewAsType(source, R.id.textViewChooseDataTitle, "field 'textViewChooseDataTitle'", TextView.class);
    target.tvTitle = Utils.findRequiredViewAsType(source, R.id.tvTitle, "field 'tvTitle'", TextView.class);
    target.llDepartmentTitle = Utils.findRequiredViewAsType(source, R.id.llDepartmentTitle, "field 'llDepartmentTitle'", LinearLayout.class);
    target.mRvSchedule = Utils.findRequiredViewAsType(source, R.id.rvSchedule, "field 'mRvSchedule'", RecyclerView.class);
    target.mSwipeRefreshSchedule = Utils.findRequiredViewAsType(source, R.id.swipeRefreshSchedule, "field 'mSwipeRefreshSchedule'", SwipeRefreshLayout.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    ScheduleFragment target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.linearLayoutChooseData = null;
    target.llError = null;
    target.tvNoData = null;
    target.btnUpdate = null;
    target.textViewChooseDataTitle = null;
    target.tvTitle = null;
    target.llDepartmentTitle = null;
    target.mRvSchedule = null;
    target.mSwipeRefreshSchedule = null;

    view2131296303.setOnClickListener(null);
    view2131296303 = null;
  }
}
