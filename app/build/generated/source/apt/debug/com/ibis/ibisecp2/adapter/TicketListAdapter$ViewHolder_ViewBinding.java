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

public class TicketListAdapter$ViewHolder_ViewBinding implements Unbinder {
  private TicketListAdapter.ViewHolder target;

  @UiThread
  public TicketListAdapter$ViewHolder_ViewBinding(TicketListAdapter.ViewHolder target,
      View source) {
    this.target = target;

    target.ticketDoctorTitleTextView = Utils.findRequiredViewAsType(source, R.id.ticketDoctorTitleTextView, "field 'ticketDoctorTitleTextView'", TextView.class);
    target.ticketDateTitleTextView = Utils.findRequiredViewAsType(source, R.id.ticketDateTitleTextView, "field 'ticketDateTitleTextView'", TextView.class);
    target.ticketDateTextView = Utils.findRequiredViewAsType(source, R.id.ticketDateTextView, "field 'ticketDateTextView'", TextView.class);
    target.ticketArrowImageView = Utils.findRequiredViewAsType(source, R.id.ticketArrowImageView, "field 'ticketArrowImageView'", ImageView.class);
    target.cvTicketItem = Utils.findRequiredViewAsType(source, R.id.rl_ticket_item, "field 'cvTicketItem'", RelativeLayout.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    TicketListAdapter.ViewHolder target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.ticketDoctorTitleTextView = null;
    target.ticketDateTitleTextView = null;
    target.ticketDateTextView = null;
    target.ticketArrowImageView = null;
    target.cvTicketItem = null;
  }
}
