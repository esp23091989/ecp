// Generated code from Butter Knife. Do not modify!
package com.ibis.ibisecp2.adapter;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.ibis.ibisecp2.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class SpecialityListAdapter$ViewHolder_ViewBinding implements Unbinder {
  private SpecialityListAdapter.ViewHolder target;

  @UiThread
  public SpecialityListAdapter$ViewHolder_ViewBinding(SpecialityListAdapter.ViewHolder target,
      View source) {
    this.target = target;

    target.mTextViewItemName = Utils.findRequiredViewAsType(source, R.id.textViewItemSpec, "field 'mTextViewItemName'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    SpecialityListAdapter.ViewHolder target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.mTextViewItemName = null;
  }
}
