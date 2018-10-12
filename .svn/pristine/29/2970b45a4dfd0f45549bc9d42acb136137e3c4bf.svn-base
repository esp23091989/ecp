package com.ibis.ibisecp2.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.ibis.ibisecp2.R;
import com.ibis.ibisecp2.listeners.TicketListAdapterListener;
import com.ibis.ibisecp2.model.Visit;
import com.ibis.ibisecp2.utils.TextUtils;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class TicketListAdapter extends RecyclerView.Adapter<TicketListAdapter.ViewHolder> {


    private LayoutInflater mLayoutInflater;
    private List<Visit> visitList;
    private TicketListAdapterListener adapterListener;
    private Context context;

    public TicketListAdapter(Context context, List<Visit> visitList, TicketListAdapterListener
            adapterListener) {
        super();
        mLayoutInflater = LayoutInflater.from(context);
        this.context = context;
        this.visitList = visitList;
        this.adapterListener = adapterListener;
    }

    public void setVisitList(List<Visit> visitList) {
        this.visitList = visitList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mLayoutInflater.inflate(R.layout.ticket_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Visit visit = visitList.get(position);
//        if(visit.getStatus() != null && visit.getStatus() == 1){
        holder.ticketDoctorTitleTextView.setText(TextUtils.spanBoldText(context.getResources()
                .getString(R.string.title_recipe_doctor), visit.getClinicName(), context));
        holder.ticketDateTextView.setText(visit.getStartOn() == null ? "" : visit.getStartOn());
//        } else {
//            return;
//        }

//        switch (visit.getStatus()) {
//            case 0:
//                holder.ticketStatusTextView.setText("Ожидание");
//                break;
//            case 1:
//                holder.ticketStatusTextView.setText("Одобрен");
//                break;
//            case 2:
//                holder.ticketStatusTextView.setText("Передвинут");
//                break;
//            case 3:
//                holder.ticketStatusTextView.setText("Отклонен");
//                break;
//            default:
//        }
    }


    @Override
    public int getItemCount() {
        return visitList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.ticketDoctorTitleTextView)
        TextView ticketDoctorTitleTextView;
        @BindView(R.id.ticketDateTitleTextView)
        TextView ticketDateTitleTextView;
        @BindView(R.id.ticketDateTextView)
        TextView ticketDateTextView;
        @BindView(R.id.ticketArrowImageView)
        ImageView ticketArrowImageView;
        @BindView(R.id.rl_ticket_item)
        RelativeLayout cvTicketItem;

        public ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
            cvTicketItem.setOnClickListener(v -> {
                if (getAdapterPosition() > -1) {
                    adapterListener.onTicketClick(visitList.get(getAdapterPosition()));
                }
            });

        }
    }
}

