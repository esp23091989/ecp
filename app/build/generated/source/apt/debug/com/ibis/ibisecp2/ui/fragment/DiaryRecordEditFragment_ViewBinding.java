// Generated code from Butter Knife. Do not modify!
package com.ibis.ibisecp2.ui.fragment;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.EditText;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.ibis.ibisecp2.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class DiaryRecordEditFragment_ViewBinding implements Unbinder {
  private DiaryRecordEditFragment target;

  @UiThread
  public DiaryRecordEditFragment_ViewBinding(DiaryRecordEditFragment target, View source) {
    this.target = target;

    target.mDiaryEditContentEditText = Utils.findRequiredViewAsType(source, R.id.diary_edit_content_edit_text, "field 'mDiaryEditContentEditText'", EditText.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    DiaryRecordEditFragment target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.mDiaryEditContentEditText = null;
  }
}
