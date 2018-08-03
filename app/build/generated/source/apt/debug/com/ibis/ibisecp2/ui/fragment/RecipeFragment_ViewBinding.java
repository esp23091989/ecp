// Generated code from Butter Knife. Do not modify!
package com.ibis.ibisecp2.ui.fragment;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.ibis.ibisecp2.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class RecipeFragment_ViewBinding implements Unbinder {
  private RecipeFragment target;

  @UiThread
  public RecipeFragment_ViewBinding(RecipeFragment target, View source) {
    this.target = target;

    target.recyclerViewRecipes = Utils.findRequiredViewAsType(source, R.id.recyclerViewRecipes, "field 'recyclerViewRecipes'", RecyclerView.class);
    target.tvReceiptNo = Utils.findRequiredViewAsType(source, R.id.tvReceiptNo, "field 'tvReceiptNo'", TextView.class);
    target.tvNoData = Utils.findRequiredViewAsType(source, R.id.tv_no_data, "field 'tvNoData'", TextView.class);
    target.progressBar = Utils.findRequiredViewAsType(source, R.id.progress_bar, "field 'progressBar'", ProgressBar.class);
    target.btnUpdate = Utils.findRequiredViewAsType(source, R.id.btn_update, "field 'btnUpdate'", Button.class);
    target.llProgressBar = Utils.findRequiredViewAsType(source, R.id.ll_error, "field 'llProgressBar'", LinearLayout.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    RecipeFragment target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.recyclerViewRecipes = null;
    target.tvReceiptNo = null;
    target.tvNoData = null;
    target.progressBar = null;
    target.btnUpdate = null;
    target.llProgressBar = null;
  }
}
