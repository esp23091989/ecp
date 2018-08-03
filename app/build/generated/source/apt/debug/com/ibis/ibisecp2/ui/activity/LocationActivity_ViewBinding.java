// Generated code from Butter Knife. Do not modify!
package com.ibis.ibisecp2.ui.activity;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.FrameLayout;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.ibis.ibisecp2.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class LocationActivity_ViewBinding implements Unbinder {
  private LocationActivity target;

  @UiThread
  public LocationActivity_ViewBinding(LocationActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public LocationActivity_ViewBinding(LocationActivity target, View source) {
    this.target = target;

    target.mProgressLayout = Utils.findRequiredViewAsType(source, R.id.progress_layout, "field 'mProgressLayout'", FrameLayout.class);
    target.mContentFrame = Utils.findRequiredViewAsType(source, R.id.contentFrame, "field 'mContentFrame'", FrameLayout.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    LocationActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.mProgressLayout = null;
    target.mContentFrame = null;
  }
}
