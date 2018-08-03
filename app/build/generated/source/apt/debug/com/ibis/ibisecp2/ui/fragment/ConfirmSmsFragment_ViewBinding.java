// Generated code from Butter Knife. Do not modify!
package com.ibis.ibisecp2.ui.fragment;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.ibis.ibisecp2.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class ConfirmSmsFragment_ViewBinding implements Unbinder {
  private ConfirmSmsFragment target;

  private View view2131296301;

  @UiThread
  public ConfirmSmsFragment_ViewBinding(final ConfirmSmsFragment target, View source) {
    this.target = target;

    View view;
    target.etCode = Utils.findRequiredViewAsType(source, R.id.etCode, "field 'etCode'", EditText.class);
    target.llProgress = Utils.findRequiredViewAsType(source, R.id.llProgress, "field 'llProgress'", LinearLayout.class);
    target.tvTitleConfirm = Utils.findRequiredViewAsType(source, R.id.tvTitleConfirm, "field 'tvTitleConfirm'", TextView.class);
    view = Utils.findRequiredView(source, R.id.btnInputCode, "field 'btnInputCode' and method 'onClick'");
    target.btnInputCode = Utils.castView(view, R.id.btnInputCode, "field 'btnInputCode'", Button.class);
    view2131296301 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick();
      }
    });
    target.tvTimeCode = Utils.findRequiredViewAsType(source, R.id.tvTimeCode, "field 'tvTimeCode'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    ConfirmSmsFragment target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.etCode = null;
    target.llProgress = null;
    target.tvTitleConfirm = null;
    target.btnInputCode = null;
    target.tvTimeCode = null;

    view2131296301.setOnClickListener(null);
    view2131296301 = null;
  }
}
