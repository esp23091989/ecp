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

public class RemembersFragment_ViewBinding implements Unbinder {
  private RemembersFragment target;

  private View view2131296303;

  @UiThread
  public RemembersFragment_ViewBinding(final RemembersFragment target, View source) {
    this.target = target;

    View view;
    target.mTvNoData = Utils.findRequiredViewAsType(source, R.id.tv_no_data, "field 'mTvNoData'", TextView.class);
    view = Utils.findRequiredView(source, R.id.btn_update, "field 'mBtnUpdate' and method 'onClick'");
    target.mBtnUpdate = Utils.castView(view, R.id.btn_update, "field 'mBtnUpdate'", Button.class);
    view2131296303 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick();
      }
    });
    target.mLlError = Utils.findRequiredViewAsType(source, R.id.ll_error, "field 'mLlError'", LinearLayout.class);
    target.mTextViewDiaryTicketNo = Utils.findRequiredViewAsType(source, R.id.textViewDiaryTicketNo, "field 'mTextViewDiaryTicketNo'", TextView.class);
    target.mRecyclerViewTickets = Utils.findRequiredViewAsType(source, R.id.recyclerViewTickets, "field 'mRecyclerViewTickets'", RecyclerView.class);
    target.mSwipeTickets = Utils.findRequiredViewAsType(source, R.id.swipe_tickets, "field 'mSwipeTickets'", SwipeRefreshLayout.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    RemembersFragment target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.mTvNoData = null;
    target.mBtnUpdate = null;
    target.mLlError = null;
    target.mTextViewDiaryTicketNo = null;
    target.mRecyclerViewTickets = null;
    target.mSwipeTickets = null;

    view2131296303.setOnClickListener(null);
    view2131296303 = null;
  }
}
