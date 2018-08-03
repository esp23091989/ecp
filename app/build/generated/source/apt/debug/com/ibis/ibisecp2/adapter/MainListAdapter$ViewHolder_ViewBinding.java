// Generated code from Butter Knife. Do not modify!
package com.ibis.ibisecp2.adapter;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.ibis.ibisecp2.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class MainListAdapter$ViewHolder_ViewBinding implements Unbinder {
  private MainListAdapter.ViewHolder target;

  @UiThread
  public MainListAdapter$ViewHolder_ViewBinding(MainListAdapter.ViewHolder target, View source) {
    this.target = target;

    target.mTextViewItemName = Utils.findRequiredViewAsType(source, R.id.textViewItemName, "field 'mTextViewItemName'", TextView.class);
    target.mImageViewIcon = Utils.findRequiredViewAsType(source, R.id.imageViewIcon, "field 'mImageViewIcon'", ImageView.class);
    target.itemMain = Utils.findRequiredViewAsType(source, R.id.item_main, "field 'itemMain'", RelativeLayout.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    MainListAdapter.ViewHolder target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.mTextViewItemName = null;
    target.mImageViewIcon = null;
    target.itemMain = null;
  }
}
