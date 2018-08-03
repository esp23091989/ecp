// Generated code from Butter Knife. Do not modify!
package com.ibis.ibisecp2.ui.fragment;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.ibis.ibisecp2.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class DiaryRecordsFragment_ViewBinding implements Unbinder {
  private DiaryRecordsFragment target;

  private View view2131296303;

  private View view2131296304;

  @UiThread
  public DiaryRecordsFragment_ViewBinding(final DiaryRecordsFragment target, View source) {
    this.target = target;

    View view;
    view = Utils.findRequiredView(source, R.id.btn_update, "field 'btnUpdate' and method 'onUpdate'");
    target.btnUpdate = Utils.castView(view, R.id.btn_update, "field 'btnUpdate'", Button.class);
    view2131296303 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onUpdate();
      }
    });
    target.diaryNoDataTitleTextView = Utils.findRequiredViewAsType(source, R.id.diaryNoDataTitleTextView, "field 'diaryNoDataTitleTextView'", TextView.class);
    target.rvDiary = Utils.findRequiredViewAsType(source, R.id.rvDiary, "field 'rvDiary'", RecyclerView.class);
    target.diarysLayout = Utils.findRequiredViewAsType(source, R.id.diarysLayout, "field 'diarysLayout'", RelativeLayout.class);
    view = Utils.findRequiredView(source, R.id.buttonAddNewDiaryRecord, "field 'mFloatingActionButton' and method 'addNewDiaryRecord'");
    target.mFloatingActionButton = Utils.castView(view, R.id.buttonAddNewDiaryRecord, "field 'mFloatingActionButton'", FloatingActionButton.class);
    view2131296304 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.addNewDiaryRecord();
      }
    });
    target.swipeRefresh = Utils.findRequiredViewAsType(source, R.id.swipe_refresh, "field 'swipeRefresh'", SwipeRefreshLayout.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    DiaryRecordsFragment target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.btnUpdate = null;
    target.diaryNoDataTitleTextView = null;
    target.rvDiary = null;
    target.diarysLayout = null;
    target.mFloatingActionButton = null;
    target.swipeRefresh = null;

    view2131296303.setOnClickListener(null);
    view2131296303 = null;
    view2131296304.setOnClickListener(null);
    view2131296304 = null;
  }
}
