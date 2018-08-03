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

public class ClinicChooseFragment_ViewBinding implements Unbinder {
  private ClinicChooseFragment target;

  private View view2131296303;

  @UiThread
  public ClinicChooseFragment_ViewBinding(final ClinicChooseFragment target, View source) {
    this.target = target;

    View view;
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
    target.mEmptyTextView = Utils.findRequiredViewAsType(source, R.id.empty_text_view, "field 'mEmptyTextView'", TextView.class);
    target.tvNoData = Utils.findRequiredViewAsType(source, R.id.tv_no_data, "field 'tvNoData'", TextView.class);
    target.rvClinic = Utils.findRequiredViewAsType(source, R.id.rvClinic, "field 'rvClinic'", RecyclerView.class);
    target.mTvTitle = Utils.findRequiredViewAsType(source, R.id.tvTitle, "field 'mTvTitle'", TextView.class);
    target.mCardView = Utils.findRequiredViewAsType(source, R.id.cvDepartmentTitle, "field 'mCardView'", CardView.class);
    target.mSwipeRefreshClinic = Utils.findRequiredViewAsType(source, R.id.swipeRefreshClinic, "field 'mSwipeRefreshClinic'", SwipeRefreshLayout.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    ClinicChooseFragment target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.btnUpdate = null;
    target.llError = null;
    target.mEmptyTextView = null;
    target.tvNoData = null;
    target.rvClinic = null;
    target.mTvTitle = null;
    target.mCardView = null;
    target.mSwipeRefreshClinic = null;

    view2131296303.setOnClickListener(null);
    view2131296303 = null;
  }
}
