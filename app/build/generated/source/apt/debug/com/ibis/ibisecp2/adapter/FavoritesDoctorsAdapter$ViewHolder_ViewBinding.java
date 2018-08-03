// Generated code from Butter Knife. Do not modify!
package com.ibis.ibisecp2.adapter;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.ibis.ibisecp2.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class FavoritesDoctorsAdapter$ViewHolder_ViewBinding implements Unbinder {
  private FavoritesDoctorsAdapter.ViewHolder target;

  @UiThread
  public FavoritesDoctorsAdapter$ViewHolder_ViewBinding(FavoritesDoctorsAdapter.ViewHolder target,
      View source) {
    this.target = target;

    target.mItemFavoritesDoctorsFio = Utils.findRequiredViewAsType(source, R.id.item_favorites_doctors_fio, "field 'mItemFavoritesDoctorsFio'", TextView.class);
    target.mItemFavoritesDoctorsSpeciality = Utils.findRequiredViewAsType(source, R.id.item_favorites_doctors_speciality, "field 'mItemFavoritesDoctorsSpeciality'", TextView.class);
    target.mItemFavoritesDoctorsClinic = Utils.findRequiredViewAsType(source, R.id.item_favorites_doctors_clinic, "field 'mItemFavoritesDoctorsClinic'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    FavoritesDoctorsAdapter.ViewHolder target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.mItemFavoritesDoctorsFio = null;
    target.mItemFavoritesDoctorsSpeciality = null;
    target.mItemFavoritesDoctorsClinic = null;
  }
}
