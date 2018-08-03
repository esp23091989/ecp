// Generated code from Butter Knife. Do not modify!
package com.ibis.ibisecp2.adapter;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.EditText;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.ibis.ibisecp2.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class DiaryRecordHorizontalAdapter$ViewHolder_ViewBinding implements Unbinder {
  private DiaryRecordHorizontalAdapter.ViewHolder target;

  @UiThread
  public DiaryRecordHorizontalAdapter$ViewHolder_ViewBinding(DiaryRecordHorizontalAdapter.ViewHolder target,
      View source) {
    this.target = target;

    target.etItemRecord = Utils.findRequiredViewAsType(source, R.id.et_item_record, "field 'etItemRecord'", EditText.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    DiaryRecordHorizontalAdapter.ViewHolder target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.etItemRecord = null;
  }
}
