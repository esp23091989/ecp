// Generated code from Butter Knife. Do not modify!
package com.ibis.ibisecp2.ui.activity;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.FrameLayout;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.ibis.ibisecp2.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class DiaryNewRecordsActivity_ViewBinding implements Unbinder {
  private DiaryNewRecordsActivity target;

  @UiThread
  public DiaryNewRecordsActivity_ViewBinding(DiaryNewRecordsActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public DiaryNewRecordsActivity_ViewBinding(DiaryNewRecordsActivity target, View source) {
    this.target = target;

    target.mProgressLayout = Utils.findRequiredViewAsType(source, R.id.progress_layout, "field 'mProgressLayout'", FrameLayout.class);
    target.mEditTextDiaryNewRecordContent = Utils.findRequiredViewAsType(source, R.id.editTextDiaryNewRecordContent, "field 'mEditTextDiaryNewRecordContent'", EditText.class);
    target.mToolbar = Utils.findRequiredViewAsType(source, R.id.toolbar, "field 'mToolbar'", Toolbar.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    DiaryNewRecordsActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.mProgressLayout = null;
    target.mEditTextDiaryNewRecordContent = null;
    target.mToolbar = null;
  }
}
