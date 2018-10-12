package com.ibis.ibisecp2.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.format.DateFormat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ibis.ibisecp2.R;
import com.ibis.ibisecp2.listeners.OnItemAdapterListener;
import com.ibis.ibisecp2.model.Schedule;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by danila on 03.12.15.
 */
public class ScheduleAdapter extends RecyclerView.Adapter<ScheduleAdapter.ViewHolder> {

    private LayoutInflater mLayoutInflater;
    private List<Schedule> mScheduleList;
    private OnItemAdapterListener listener;

    public ScheduleAdapter(Context context, List<Schedule> scheduleList, OnItemAdapterListener
            listener) {
        super();
        mLayoutInflater = LayoutInflater.from(context);
        mScheduleList = scheduleList;
        this.listener = listener;
    }

    public void setScheduleList(List<Schedule> scheduleList) {
        mScheduleList = scheduleList;
        notifyDataSetChanged();
    }

    public void addScheduleList(List<Schedule> scheduleList) {
        int sizeBefore = mScheduleList.size() - 1;
        mScheduleList.addAll(scheduleList);
        notifyItemRangeInserted(sizeBefore, scheduleList.size());
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mLayoutInflater.inflate(R.layout.item_schedule, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ScheduleAdapter.ViewHolder holder, int position) {
        Schedule schedule = mScheduleList.get(position);
        if (schedule.getScheduleDate() != null) {
            String dayOfTheWeek = "";
            SimpleDateFormat fmt = new SimpleDateFormat("dd.MM.yyyy", new Locale("ru", "RU"));
            Date date = null;
            try {
                date = fmt.parse(schedule.getScheduleDate());
                dayOfTheWeek = (String) DateFormat.format("EE", date);
                dayOfTheWeek = dayOfTheWeek.substring(0, 1).toUpperCase() +
                        dayOfTheWeek.substring(1, dayOfTheWeek.length());
            } catch (ParseException e) {
                e.printStackTrace();
            }
            String dateTime = dayOfTheWeek.equals("") ? schedule.getScheduleDate() : dayOfTheWeek +
                    ": " + schedule.getScheduleDate();
            holder.mItemGridSchedule.setText(dateTime);
        }
    }

    @Override
    public int getItemCount() {
        return mScheduleList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.itemGridSchedule)
        TextView mItemGridSchedule;

        public ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
            view.setOnClickListener(v -> {
                listener.onItemClick(mScheduleList.get(getAdapterPosition()));
            });

        }
    }

/*extends ArrayAdapter<Schedule> {

    Context context;
    private List<Schedule> scheduleItems;

    public ScheduleAdapter(Context context, int textViewResourceId, List<Schedule>
            scheduleItems) {
        super(context, textViewResourceId, scheduleItems);
        // TODO Auto-generated constructor stub
        this.scheduleItems = scheduleItems;

        this.context = context;
    }

    public void setScheduleItems(List<Schedule> scheduleItems) {
        this.scheduleItems = scheduleItems;
        notifyDataSetChanged();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        TextView label = null;
        if (view == null) {
            LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = layoutInflater.inflate(R.layout.item_schedule, null, false);

        }
        label = (TextView) view.findViewById(R.id.itemGridSchedule);
        GridView.LayoutParams layoutParams = new GridView.LayoutParams(GridView.LayoutParams.MATCH_PARENT,
                (int) context.getResources().getDimension(R.dimen.time_button_height));

        label.setLayoutParams(layoutParams);

        Schedule schedule = scheduleItems.get(position);
        label.setTextColor(ContextCompat.getColor(context, R.color.textSecondaryPrimary));
        if (schedule.getScheduleDate() != null) {
            String dayOfTheWeek = "";
            SimpleDateFormat fmt = new SimpleDateFormat("dd.MM.yyyy", new Locale("ru", "RU"));
            Date date = null;
            try {
                date = fmt.parse(schedule.getScheduleDate());
                dayOfTheWeek = (String) DateFormat.format("EE", date);
                dayOfTheWeek = dayOfTheWeek.substring(0, 1).toUpperCase() +
                        dayOfTheWeek.substring(1, dayOfTheWeek.length());
            } catch (ParseException e) {
                e.printStackTrace();
            }
            String dateTime = dayOfTheWeek.equals("") ? schedule.getScheduleDate() : dayOfTheWeek +
                    ": " + schedule.getScheduleDate();
            label.setText(dateTime);
        }

        return (label);
    }

    public Schedule GetItem(int position) {
        return scheduleItems.get(position);
    }
}*/
}
