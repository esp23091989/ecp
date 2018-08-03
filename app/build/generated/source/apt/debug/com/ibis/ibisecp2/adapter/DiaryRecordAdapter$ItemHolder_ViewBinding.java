// Generated code from Butter Knife. Do not modify!
package com.ibis.ibisecp2.adapter;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.ibis.ibisecp2.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class DiaryRecordAdapter$ItemHolder_ViewBinding implements Unbinder {
  private DiaryRecordAdapter.ItemHolder target;

  @UiThread
  public DiaryRecordAdapter$ItemHolder_ViewBinding(DiaryRecordAdapter.ItemHolder target,
      View source) {
    this.target = target;

    target.tvDateDiary = Utils.findRequiredViewAsType(source, R.id.tvDateDiary, "field 'tvDateDiary'", TextView.class);
    target.tvDiaryRecord = Utils.findRequiredViewAsType(source, R.id.tvDiaryRecord, "field 'tvDiaryRecord'", TextView.class);
    target.diaryRecordLayout = Utils.findRequiredViewAsType(source, R.id.diaryRecordLayout, "field 'diaryRecordLayout'", RelativeLayout.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    DiaryRecordAdapter.ItemHolder target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.tvDateDiary = null;
    target.tvDiaryRecord = null;
    target.diaryRecordLayout = null;
  }
}
