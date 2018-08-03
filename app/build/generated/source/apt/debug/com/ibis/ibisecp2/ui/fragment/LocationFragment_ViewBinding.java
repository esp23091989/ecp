// Generated code from Butter Knife. Do not modify!
package com.ibis.ibisecp2.ui.fragment;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.ibis.ibisecp2.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class LocationFragment_ViewBinding implements Unbinder {
  private LocationFragment target;

  private View view2131296394;

  @UiThread
  public LocationFragment_ViewBinding(final LocationFragment target, View source) {
    this.target = target;

    View view;
    target.mTextView = Utils.findRequiredViewAsType(source, R.id.fragment_location_coordinates_text_view, "field 'mTextView'", TextView.class);
    view = Utils.findRequiredView(source, R.id.fragment_location_change_button, "field 'mLocationChangeButton' and method 'onClick'");
    target.mLocationChangeButton = Utils.castView(view, R.id.fragment_location_change_button, "field 'mLocationChangeButton'", Button.class);
    view2131296394 = view;
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
    LocationFragment target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.mTextView = null;
    target.mLocationChangeButton = null;

    view2131296394.setOnClickListener(null);
    view2131296394 = null;
  }
}
