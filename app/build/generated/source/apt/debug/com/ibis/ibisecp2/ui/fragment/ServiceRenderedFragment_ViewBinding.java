// Generated code from Butter Knife. Do not modify!
package com.ibis.ibisecp2.ui.fragment;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.ibis.ibisecp2.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class ServiceRenderedFragment_ViewBinding implements Unbinder {
  private ServiceRenderedFragment target;

  @UiThread
  public ServiceRenderedFragment_ViewBinding(ServiceRenderedFragment target, View source) {
    this.target = target;

    target.tvPeriod = Utils.findRequiredViewAsType(source, R.id.tvPeriod, "field 'tvPeriod'", TextView.class);
    target.tvDiaryDateEnd = Utils.findRequiredViewAsType(source, R.id.tvDiaryDateEnd, "field 'tvDiaryDateEnd'", TextView.class);
    target.tvDiaryDateStart = Utils.findRequiredViewAsType(source, R.id.tvDiaryDateStart, "field 'tvDiaryDateStart'", TextView.class);
    target.test = Utils.findRequiredViewAsType(source, R.id.test, "field 'test'", CardView.class);
    target.tvEndDateSluch = Utils.findRequiredViewAsType(source, R.id.tvEndDateSluch, "field 'tvEndDateSluch'", TextView.class);
    target.tvSluch = Utils.findRequiredViewAsType(source, R.id.tvSluch, "field 'tvSluch'", TextView.class);
    target.tvCostSluch = Utils.findRequiredViewAsType(source, R.id.tvCostSluch, "field 'tvCostSluch'", TextView.class);
    target.llGroupHeader = Utils.findRequiredViewAsType(source, R.id.llGroupHeader, "field 'llGroupHeader'", LinearLayout.class);
    target.tvNoDataService = Utils.findRequiredViewAsType(source, R.id.tvNoDataService, "field 'tvNoDataService'", TextView.class);
    target.expLvService = Utils.findRequiredViewAsType(source, R.id.expLvService, "field 'expLvService'", ExpandableListView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    ServiceRenderedFragment target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.tvPeriod = null;
    target.tvDiaryDateEnd = null;
    target.tvDiaryDateStart = null;
    target.test = null;
    target.tvEndDateSluch = null;
    target.tvSluch = null;
    target.tvCostSluch = null;
    target.llGroupHeader = null;
    target.tvNoDataService = null;
    target.expLvService = null;
  }
}
