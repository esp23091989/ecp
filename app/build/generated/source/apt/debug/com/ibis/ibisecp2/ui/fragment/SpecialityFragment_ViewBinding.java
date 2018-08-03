// Generated code from Butter Knife. Do not modify!
package com.ibis.ibisecp2.ui.fragment;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.CardView;
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

public class SpecialityFragment_ViewBinding implements Unbinder {
  private SpecialityFragment target;

  private View view2131296303;

  @UiThread
  public SpecialityFragment_ViewBinding(final SpecialityFragment target, View source) {
    this.target = target;

    View view;
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
    target.llError = Utils.findRequiredViewAsType(source, R.id.ll_error, "field 'llError'", LinearLayout.class);
    target.recyclerViewDepartment = Utils.findRequiredViewAsType(source, R.id.recyclerViewDepartment, "field 'recyclerViewDepartment'", RecyclerView.class);
    target.tvTitle = Utils.findRequiredViewAsType(source, R.id.tvTitle, "field 'tvTitle'", TextView.class);
    target.llDepartmentTitle = Utils.findRequiredViewAsType(source, R.id.llDepartmentTitle, "field 'llDepartmentTitle'", LinearLayout.class);
    target.cvDepartmentTitle = Utils.findRequiredViewAsType(source, R.id.cvDepartmentTitle, "field 'cvDepartmentTitle'", CardView.class);
    target.mTvEmptyData = Utils.findRequiredViewAsType(source, R.id.tvEmptyData, "field 'mTvEmptyData'", TextView.class);
    target.mSwipeRefreshDepartment = Utils.findRequiredViewAsType(source, R.id.swipeRefreshDepartment, "field 'mSwipeRefreshDepartment'", SwipeRefreshLayout.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    SpecialityFragment target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.tvNoData = null;
    target.btnUpdate = null;
    target.llError = null;
    target.recyclerViewDepartment = null;
    target.tvTitle = null;
    target.llDepartmentTitle = null;
    target.cvDepartmentTitle = null;
    target.mTvEmptyData = null;
    target.mSwipeRefreshDepartment = null;

    view2131296303.setOnClickListener(null);
    view2131296303 = null;
  }
}
