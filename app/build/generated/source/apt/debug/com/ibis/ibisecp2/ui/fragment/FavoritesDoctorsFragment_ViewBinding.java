// Generated code from Butter Knife. Do not modify!
package com.ibis.ibisecp2.ui.fragment;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.ibis.ibisecp2.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class FavoritesDoctorsFragment_ViewBinding implements Unbinder {
  private FavoritesDoctorsFragment target;

  @UiThread
  public FavoritesDoctorsFragment_ViewBinding(FavoritesDoctorsFragment target, View source) {
    this.target = target;

    target.mRecyclerView = Utils.findRequiredViewAsType(source, R.id.fragment_favorites_doctors_recycler_view, "field 'mRecyclerView'", RecyclerView.class);
    target.mEmptyTextView = Utils.findRequiredViewAsType(source, R.id.fragment_favorites_doctors_text_view, "field 'mEmptyTextView'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    FavoritesDoctorsFragment target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.mRecyclerView = null;
    target.mEmptyTextView = null;
  }
}
