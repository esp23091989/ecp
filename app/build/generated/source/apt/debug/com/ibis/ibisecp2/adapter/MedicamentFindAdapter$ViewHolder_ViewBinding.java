// Generated code from Butter Knife. Do not modify!
package com.ibis.ibisecp2.adapter;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.ibis.ibisecp2.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class MedicamentFindAdapter$ViewHolder_ViewBinding implements Unbinder {
  private MedicamentFindAdapter.ViewHolder target;

  @UiThread
  public MedicamentFindAdapter$ViewHolder_ViewBinding(MedicamentFindAdapter.ViewHolder target,
      View source) {
    this.target = target;

    target.medicamentServiceInfoLayout = Utils.findRequiredViewAsType(source, R.id.medicamentServiceInfoLayout, "field 'medicamentServiceInfoLayout'", LinearLayout.class);
    target.nameTextView = Utils.findRequiredViewAsType(source, R.id.nameTextView, "field 'nameTextView'", TextView.class);
    target.lpuInfoTextView = Utils.findRequiredViewAsType(source, R.id.lpuInfoTextView, "field 'lpuInfoTextView'", TextView.class);
    target.costTextView = Utils.findRequiredViewAsType(source, R.id.costTextView, "field 'costTextView'", TextView.class);
    target.dosageButton = Utils.findRequiredViewAsType(source, R.id.dosageButton, "field 'dosageButton'", Button.class);
    target.itemDosageLayout = Utils.findRequiredViewAsType(source, R.id.itemDosageLayout, "field 'itemDosageLayout'", LinearLayout.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    MedicamentFindAdapter.ViewHolder target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.medicamentServiceInfoLayout = null;
    target.nameTextView = null;
    target.lpuInfoTextView = null;
    target.costTextView = null;
    target.dosageButton = null;
    target.itemDosageLayout = null;
  }
}
