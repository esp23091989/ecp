package com.ibis.ibisecp2.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.TextView;

import com.ibis.ibisecp2.R;
import com.ibis.ibisecp2.listeners.OnItemAdapterListener;
import com.ibis.ibisecp2.listeners.OnSearchItemListener;
import com.ibis.ibisecp2.model.Clinic;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by danila on 17.02.17.
 */

public class ClinicAdapter extends RecyclerView.Adapter<ClinicAdapter.ViewHolder> {
    private LayoutInflater mLayoutInflater;
    private List<Clinic> clinicList = new ArrayList<>();
    private List<Clinic> clinicArrayList;
    private OnItemAdapterListener listener;
    private OnSearchItemListener mSearchItemListener;
    private ClinicFilter filter;

    public ClinicAdapter(Context context, List<Clinic> clinicList, OnItemAdapterListener listener,
                         OnSearchItemListener searchItemListener) {
        super();
        mLayoutInflater = LayoutInflater.from(context);
        setupClinicList(clinicList);
        this.listener = listener;
        mSearchItemListener = searchItemListener;
    }

    private void setupClinicList(List<Clinic> clinicArrayList) {
        this.clinicArrayList = clinicArrayList;
        this.clinicList.clear();
        this.clinicList.addAll(clinicArrayList);
    }

    public void setClinicList(List<Clinic> clinicArrayList) {
        setupClinicList(clinicArrayList);
        notifyDataSetChanged();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mLayoutInflater.inflate(R.layout.item_clinic, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Clinic lpuViewModel = clinicArrayList.get(position);
        holder.appointmentLpuNameTextView.setText(lpuViewModel.getFullName());
        if (lpuViewModel.getAddress() == null) {
            holder.appointmentLpuAddressTextView.setVisibility(View.GONE);
        } else {
            holder.appointmentLpuAddressTextView.setVisibility(View.VISIBLE);
            holder.appointmentLpuAddressTextView.setText("Адрес: " + lpuViewModel.getAddress());
        }
    }


    @Override
    public int getItemCount() {
        return clinicArrayList.size();
    }

    public Filter getFilter() {
        if (filter == null) {
            filter = new ClinicFilter();
        }
        return filter;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.appointmentLpuNameTextView)
        TextView appointmentLpuNameTextView;
        @BindView(R.id.appointmentLpuAddressTextView)
        TextView appointmentLpuAddressTextView;

        public ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
            view.setOnClickListener(v -> {
                listener.onItemClick(clinicArrayList.get(getAdapterPosition()));
            });
        }
    }

    private class ClinicFilter extends Filter {

        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            // Create a FilterResults object
            FilterResults results = new FilterResults();
            if (constraint == null || constraint.length() == 0) {
                results.values = clinicList;
                results.count = clinicList.size();
            } else {
                ArrayList<Clinic> filteredContacts = new ArrayList<>();
                for (Clinic clinic : clinicList) {
                    if (clinic.getFullName().toLowerCase().contains(constraint.toString().toLowerCase())) {
                        filteredContacts.add(clinic);
                    }
                }
                results.values = filteredContacts;
                results.count = filteredContacts.size();
            }
            return results;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            clinicArrayList = (List<Clinic>) results.values;
            notifyDataSetChanged();
            mSearchItemListener.onEmpty(clinicArrayList.isEmpty());
        }
    }
}
