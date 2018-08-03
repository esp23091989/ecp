package com.ibis.ibisecp2.adapter;

import android.content.Context;
import android.graphics.Typeface;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import com.ibis.ibisecp2.R;
import com.ibis.ibisecp2.model.Sluch;
import com.ibis.ibisecp2.model.UslList;
import com.ibis.ibisecp2.utils.Utils;

import java.util.HashMap;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by danila on 29.06.16.
 */
public class ServiceRenderAdapter extends BaseExpandableListAdapter {
    private Context context;
    private LayoutInflater mInflater;
    private List<Sluch> headerList;
    private HashMap<Sluch, List<UslList>> childList;

    public ServiceRenderAdapter(Context context, List<Sluch> headerList,
                                HashMap<Sluch, List<UslList>> childList) {
        this.context = context;
        this.headerList = headerList;
        this.childList = childList;
        mInflater =
                (LayoutInflater) this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public UslList getChild(int groupPosition, int childPPosition) {
        return this.childList.get(this.headerList.get(groupPosition))
                .get(childPPosition);
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public View getChildView(int groupPosition, final int childPosition,
                             boolean isLastChild, View convertView, ViewGroup parent) {
        // header hide
//        if (childPosition == 0) return convertView = mInflater.inflate(R.layout.child_header, null);
        // A ViewHolder keeps references to children views to avoid unneccessary calls
        // to findViewById() on each row.
        ChildViewHolder holder = null;
        //for header childPosition - 1
        UslList childItem = getChild(groupPosition, childPosition);
        //Get ViewHolder first
        if (convertView != null) {
            holder = (ChildViewHolder) convertView.getTag();
        }
        //If no ViewHolder, then create a new child row as convertView is probably a header
        if (holder == null) {
            convertView = mInflater.inflate(R.layout.item_child_service_render, null);
            holder = new ChildViewHolder(convertView);
            convertView.setTag(holder);
        }
        holder.tvService.setText(childItem.getUslName() == null ? "" : childItem.getUslName());
        holder.tvStartDateService.setText(childItem.getDateEnd() == null ? "" : childItem.getDateEnd());
        holder.tvCostService.setText(childItem.getUslCount() == null ? "" : childItem.getUslCount());
        return convertView;
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return this.childList.get(this.headerList.get(groupPosition)).size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return this.headerList.get(groupPosition);
    }

    @Override
    public int getGroupCount() {
        return this.headerList.size();
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded,
                             View convertView, ViewGroup parent) {
        Sluch sluch = (Sluch) getGroup(groupPosition);
        if (convertView == null) {
            LayoutInflater layoutInflater = (LayoutInflater) this.context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(R.layout.group_header, null);
        }
        TextView lblListHeader = (TextView) convertView
                .findViewById(R.id.tvSluch);
/*
        TextView tvStartDateSluch = (TextView) convertView
                .findViewById(R.id.tvStartDateSluch);*/

        TextView tvEndDateSluch = (TextView) convertView
                .findViewById(R.id.tvEndDateSluch);

        TextView tvCostSluch = (TextView) convertView
                .findViewById(R.id.tvCostSluch);

        lblListHeader.setTypeface(null, Typeface.BOLD);
        lblListHeader.setText(sluch.getLpuName() == null ? "" : sluch.getLpuName());
//        tvStartDateSluch.setText(sluch.getDATE1() == null ? "" : sluch.getDATE1());
        tvEndDateSluch.setText(sluch.getDateEnd() == null ? "" : sluch.getDateEnd());
        tvCostSluch.setText(sluch.getSluchSum() == null ? "" : sluch.getSluchSum());
//        convertView.set(ContextCompat.getColor(context, R.color.white));
        Utils.SetBackground(convertView, ContextCompat.getDrawable(context,
                R.drawable.mono_light_green_button_background));
        return convertView;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }

    static class ChildViewHolder {
        @BindView(R.id.tvStartDateService)
        TextView tvStartDateService;
        @BindView(R.id.tvService)
        TextView tvService;
        @BindView(R.id.tvCostService)
        TextView tvCostService;

        public ChildViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
