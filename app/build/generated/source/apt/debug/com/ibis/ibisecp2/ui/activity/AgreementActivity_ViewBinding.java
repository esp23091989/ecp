// Generated code from Butter Knife. Do not modify!
package com.ibis.ibisecp2.ui.activity;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.ibis.ibisecp2.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class AgreementActivity_ViewBinding implements Unbinder {
  private AgreementActivity target;

  @UiThread
  public AgreementActivity_ViewBinding(AgreementActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public AgreementActivity_ViewBinding(AgreementActivity target, View source) {
    this.target = target;

    target.toolbar = Utils.findRequiredViewAsType(source, R.id.toolbar, "field 'toolbar'", Toolbar.class);
    target.tvAgreement = Utils.findRequiredViewAsType(source, R.id.agreement, "field 'tvAgreement'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    AgreementActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.toolbar = null;
    target.tvAgreement = null;
  }
}
