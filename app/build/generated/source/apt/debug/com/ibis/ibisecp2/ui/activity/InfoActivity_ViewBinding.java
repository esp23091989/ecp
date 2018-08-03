// Generated code from Butter Knife. Do not modify!
package com.ibis.ibisecp2.ui.activity;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.webkit.WebView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.ibis.ibisecp2.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class InfoActivity_ViewBinding implements Unbinder {
  private InfoActivity target;

  @UiThread
  public InfoActivity_ViewBinding(InfoActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public InfoActivity_ViewBinding(InfoActivity target, View source) {
    this.target = target;

    target.toolbar = Utils.findRequiredViewAsType(source, R.id.toolbar, "field 'toolbar'", Toolbar.class);
    target.tvInfo = Utils.findRequiredViewAsType(source, R.id.tvInfo, "field 'tvInfo'", WebView.class);
    target.mTvVersion = Utils.findRequiredViewAsType(source, R.id.tvVersion, "field 'mTvVersion'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    InfoActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.toolbar = null;
    target.tvInfo = null;
    target.mTvVersion = null;
  }
}
