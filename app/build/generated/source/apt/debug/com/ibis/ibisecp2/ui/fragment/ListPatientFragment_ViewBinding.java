// Generated code from Butter Knife. Do not modify!
package com.ibis.ibisecp2.ui.fragment;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.ibis.ibisecp2.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class ListPatientFragment_ViewBinding implements Unbinder {
  private ListPatientFragment target;

  private View view2131296300;

  @UiThread
  public ListPatientFragment_ViewBinding(final ListPatientFragment target, View source) {
    this.target = target;

    View view;
    target.rvPatients = Utils.findRequiredViewAsType(source, R.id.recyclerViewPatients, "field 'rvPatients'", RecyclerView.class);
    target.tvNoPatients = Utils.findRequiredViewAsType(source, R.id.tvNoPatients, "field 'tvNoPatients'", TextView.class);
    view = Utils.findRequiredView(source, R.id.btnAddPatient, "method 'onClick'");
    view2131296300 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick();
      }
    });
  }

  @Override
  @CallSuper
  public void unbind() {
    ListPatientFragment target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.rvPatients = null;
    target.tvNoPatients = null;

    view2131296300.setOnClickListener(null);
    view2131296300 = null;
  }
}
