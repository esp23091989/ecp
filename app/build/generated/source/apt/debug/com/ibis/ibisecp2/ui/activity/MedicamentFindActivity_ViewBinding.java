// Generated code from Butter Knife. Do not modify!
package com.ibis.ibisecp2.ui.activity;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.ibis.ibisecp2.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class MedicamentFindActivity_ViewBinding implements Unbinder {
  private MedicamentFindActivity target;

  private View view2131296367;

  private View view2131296695;

  @UiThread
  public MedicamentFindActivity_ViewBinding(MedicamentFindActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public MedicamentFindActivity_ViewBinding(final MedicamentFindActivity target, View source) {
    this.target = target;

    View view;
    target.byPriceTitleTitleTextView = Utils.findRequiredViewAsType(source, R.id.byPriceTitleTitleTextView, "field 'byPriceTitleTitleTextView'", TextView.class);
    view = Utils.findRequiredView(source, R.id.downButton, "field 'downButton' and method 'downButtonClick'");
    target.downButton = Utils.castView(view, R.id.downButton, "field 'downButton'", ImageButton.class);
    view2131296367 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.downButtonClick();
      }
    });
    target.separatorTitleTextView = Utils.findRequiredViewAsType(source, R.id.separatorTitleTextView, "field 'separatorTitleTextView'", TextView.class);
    view = Utils.findRequiredView(source, R.id.upButton, "field 'upButton' and method 'upButtonClick'");
    target.upButton = Utils.castView(view, R.id.upButton, "field 'upButton'", ImageButton.class);
    view2131296695 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.upButtonClick();
      }
    });
    target.bracketTitleTextView = Utils.findRequiredViewAsType(source, R.id.bracketTitleTextView, "field 'bracketTitleTextView'", TextView.class);
    target.rvServices = Utils.findRequiredViewAsType(source, R.id.rvServices, "field 'rvServices'", RecyclerView.class);
    target.resultLayout = Utils.findRequiredViewAsType(source, R.id.resultLayout, "field 'resultLayout'", RelativeLayout.class);
    target.toolbar = Utils.findRequiredViewAsType(source, R.id.toolbar, "field 'toolbar'", Toolbar.class);
    target.tvInfoMedicament = Utils.findRequiredViewAsType(source, R.id.tv_info_medicament, "field 'tvInfoMedicament'", TextView.class);
    target.rlInfo = Utils.findRequiredViewAsType(source, R.id.rl_info, "field 'rlInfo'", RelativeLayout.class);
    target.navView = Utils.findRequiredViewAsType(source, R.id.nav_view, "field 'navView'", NavigationView.class);
    target.drawer = Utils.findRequiredViewAsType(source, R.id.drawer_layout, "field 'drawer'", DrawerLayout.class);
    target.mProgressLayout = Utils.findRequiredViewAsType(source, R.id.progress_layout, "field 'mProgressLayout'", FrameLayout.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    MedicamentFindActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.byPriceTitleTitleTextView = null;
    target.downButton = null;
    target.separatorTitleTextView = null;
    target.upButton = null;
    target.bracketTitleTextView = null;
    target.rvServices = null;
    target.resultLayout = null;
    target.toolbar = null;
    target.tvInfoMedicament = null;
    target.rlInfo = null;
    target.navView = null;
    target.drawer = null;
    target.mProgressLayout = null;

    view2131296367.setOnClickListener(null);
    view2131296367 = null;
    view2131296695.setOnClickListener(null);
    view2131296695 = null;
  }
}
