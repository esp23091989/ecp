// Generated code from Butter Knife. Do not modify!
package com.ibis.ibisecp2.adapter;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.ProgressBar;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.ibis.ibisecp2.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class DiaryRecordAdapter$FooterHolder_ViewBinding implements Unbinder {
  private DiaryRecordAdapter.FooterHolder target;

  @UiThread
  public DiaryRecordAdapter$FooterHolder_ViewBinding(DiaryRecordAdapter.FooterHolder target,
      View source) {
    this.target = target;

    target.progressLoadMore = Utils.findRequiredViewAsType(source, R.id.progress_load_more, "field 'progressLoadMore'", ProgressBar.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    DiaryRecordAdapter.FooterHolder target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.progressLoadMore = null;
  }
}
