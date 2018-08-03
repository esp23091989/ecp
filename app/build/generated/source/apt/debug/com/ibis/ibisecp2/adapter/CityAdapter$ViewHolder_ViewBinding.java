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

public class CityAdapter$ViewHolder_ViewBinding implements Unbinder {
  private CityAdapter.ViewHolder target;

  @UiThread
  public CityAdapter$ViewHolder_ViewBinding(CityAdapter.ViewHolder target, View source) {
    this.target = target;

    target.tvCity = Utils.findRequiredViewAsType(source, R.id.tvCity, "field 'tvCity'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    CityAdapter.ViewHolder target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.tvCity = null;
  }
}
