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

public class ServiceRenderAdapter$ChildViewHolder_ViewBinding implements Unbinder {
  private ServiceRenderAdapter.ChildViewHolder target;

  @UiThread
  public ServiceRenderAdapter$ChildViewHolder_ViewBinding(ServiceRenderAdapter.ChildViewHolder target,
      View source) {
    this.target = target;

    target.tvStartDateService = Utils.findRequiredViewAsType(source, R.id.tvStartDateService, "field 'tvStartDateService'", TextView.class);
    target.tvService = Utils.findRequiredViewAsType(source, R.id.tvService, "field 'tvService'", TextView.class);
    target.tvCostService = Utils.findRequiredViewAsType(source, R.id.tvCostService, "field 'tvCostService'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    ServiceRenderAdapter.ChildViewHolder target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.tvStartDateService = null;
    target.tvService = null;
    target.tvCostService = null;
  }
}
