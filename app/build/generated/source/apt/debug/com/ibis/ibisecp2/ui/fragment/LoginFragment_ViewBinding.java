// Generated code from Butter Knife. Do not modify!
package com.ibis.ibisecp2.ui.fragment;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.design.widget.TextInputLayout;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.ibis.ibisecp2.R;
import com.scottyab.showhidepasswordedittext.ShowHidePasswordEditText;
import java.lang.IllegalStateException;
import java.lang.Override;

public class LoginFragment_ViewBinding implements Unbinder {
  private LoginFragment target;

  private View view2131296318;

  private View view2131296693;

  private View view2131296686;

  private View view2131296690;

  private View view2131296307;

  private View view2131296306;

  @UiThread
  public LoginFragment_ViewBinding(final LoginFragment target, View source) {
    this.target = target;

    View view;
    target.mEditTextLogin = Utils.findRequiredViewAsType(source, R.id.editTextLoginMobile, "field 'mEditTextLogin'", EditText.class);
    target.mEditTextPassword = Utils.findRequiredViewAsType(source, R.id.editTextPassword, "field 'mEditTextPassword'", ShowHidePasswordEditText.class);
    view = Utils.findRequiredView(source, R.id.checkBoxSaveAuthentication, "field 'mCheckBoxSaveAuthentication' and method 'onClickChb'");
    target.mCheckBoxSaveAuthentication = Utils.castView(view, R.id.checkBoxSaveAuthentication, "field 'mCheckBoxSaveAuthentication'", CheckBox.class);
    view2131296318 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClickChb(p0);
      }
    });
    target.loginPanel = Utils.findRequiredViewAsType(source, R.id.login_panel, "field 'loginPanel'", RelativeLayout.class);
    view = Utils.findRequiredView(source, R.id.tv_snils_type, "field 'tvSnilsType' and method 'onClick'");
    target.tvSnilsType = Utils.castView(view, R.id.tv_snils_type, "field 'tvSnilsType'", TextView.class);
    view2131296693 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.tv_email_type, "field 'tvEmailType' and method 'onClick'");
    target.tvEmailType = Utils.castView(view, R.id.tv_email_type, "field 'tvEmailType'", TextView.class);
    view2131296686 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.tv_mobile_type, "field 'tvMobileType' and method 'onClick'");
    target.tvMobileType = Utils.castView(view, R.id.tv_mobile_type, "field 'tvMobileType'", TextView.class);
    view2131296690 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
    target.tilLogin = Utils.findRequiredViewAsType(source, R.id.til_login, "field 'tilLogin'", TextInputLayout.class);
    view = Utils.findRequiredView(source, R.id.buttonDialogLogin, "field 'buttonDialogLogin' and method 'loginClick'");
    target.buttonDialogLogin = Utils.castView(view, R.id.buttonDialogLogin, "field 'buttonDialogLogin'", Button.class);
    view2131296307 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.loginClick();
      }
    });
    target.mProgressLayout = Utils.findRequiredViewAsType(source, R.id.progress_layout, "field 'mProgressLayout'", FrameLayout.class);
    view = Utils.findRequiredView(source, R.id.buttonDialogList, "method 'listPatientShow'");
    view2131296306 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.listPatientShow();
      }
    });
  }

  @Override
  @CallSuper
  public void unbind() {
    LoginFragment target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.mEditTextLogin = null;
    target.mEditTextPassword = null;
    target.mCheckBoxSaveAuthentication = null;
    target.loginPanel = null;
    target.tvSnilsType = null;
    target.tvEmailType = null;
    target.tvMobileType = null;
    target.tilLogin = null;
    target.buttonDialogLogin = null;
    target.mProgressLayout = null;

    view2131296318.setOnClickListener(null);
    view2131296318 = null;
    view2131296693.setOnClickListener(null);
    view2131296693 = null;
    view2131296686.setOnClickListener(null);
    view2131296686 = null;
    view2131296690.setOnClickListener(null);
    view2131296690 = null;
    view2131296307.setOnClickListener(null);
    view2131296307 = null;
    view2131296306.setOnClickListener(null);
    view2131296306 = null;
  }
}
