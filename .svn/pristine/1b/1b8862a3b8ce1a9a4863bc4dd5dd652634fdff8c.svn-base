package com.ibis.ibisecp2.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ibis.ibisecp2.R;
import com.ibis.ibisecp2.listeners.OnItemAdapterListener;
import com.ibis.ibisecp2.model.SlotList;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by danila on 16.02.17.
 */

public class ScheduleTimeAdapter extends RecyclerView.Adapter<ScheduleTimeAdapter.ViewHolder> {

    private LayoutInflater mLayoutInflater;
    private List<SlotList> slotLists;
    private OnItemAdapterListener listener;

    public ScheduleTimeAdapter(Context context, List<SlotList> slotLists, OnItemAdapterListener
            listener) {
        super();
        mLayoutInflater = LayoutInflater.from(context);
        this.slotLists = slotLists;
        this.listener = listener;
    }

    public void setSlotLists(List<SlotList> slotLists) {
        this.slotLists = slotLists;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mLayoutInflater.inflate(R.layout.item_schedule, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        SlotList slotList = slotLists.get(position);
        holder.itemGridSchedule.setText(slotList.getStartTime());
    }

    @Override
    public int getItemCount() {
        return slotLists.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.itemGridSchedule)
        TextView itemGridSchedule;


        public ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
            view.setOnClickListener(v -> {
                listener.onItemClick(slotLists.get(getAdapterPosition()));
            });

        }
    }

}
