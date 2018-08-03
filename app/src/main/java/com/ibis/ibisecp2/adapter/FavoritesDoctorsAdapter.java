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
import com.ibis.ibisecp2.model.FavoriteDoctor;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by comp on 21.04.17.
 */

public class FavoritesDoctorsAdapter extends RecyclerView.Adapter<FavoritesDoctorsAdapter.ViewHolder> {

    private LayoutInflater mLayoutInflater;
    private List<FavoriteDoctor> items;
    private List<FavoriteDoctor> doctorList = new ArrayList<>();

    private OnItemAdapterListener mListener;
    private DoctorFilter filter;


    public FavoritesDoctorsAdapter(Context context, List<FavoriteDoctor> items,
                                   OnItemAdapterListener listener) {
        super();
        mLayoutInflater = LayoutInflater.from(context);
        this.doctorList.addAll(items);
        this.items = items;
        mListener = listener;
    }

    public List<FavoriteDoctor> getItems() {
        return items;
    }

    public void setItems(List<FavoriteDoctor> items) {
        this.doctorList.addAll(items);
        this.items = items;
        notifyDataSetChanged();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mLayoutInflater.inflate(R.layout.item_favorites_doctors, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        FavoriteDoctor doctor = items.get(position);
        holder.mItemFavoritesDoctorsFio.setText(doctor.getSpecialityName());
        holder.mItemFavoritesDoctorsSpeciality.setText(doctor.getPositionName());
        holder.mItemFavoritesDoctorsClinic.setText(doctor.getClinic());
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public void removeItem(int position) {
        items.remove(position);
        notifyItemRemoved(position);
        notifyItemRangeChanged(position, items.size());
    }

    public Filter getFilter() {
        if (filter == null) {
            filter = new DoctorFilter();
        }
        return filter;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.item_favorites_doctors_fio)
        TextView mItemFavoritesDoctorsFio;
        @BindView(R.id.item_favorites_doctors_speciality)
        TextView mItemFavoritesDoctorsSpeciality;
        @BindView(R.id.item_favorites_doctors_clinic)
        TextView mItemFavoritesDoctorsClinic;

        public ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
            view.setOnClickListener(v -> {
                mListener.onItemClick(items.get(getAdapterPosition()));
            });
        }
    }

    private class DoctorFilter extends Filter {

        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            // Create a FilterResults object
            FilterResults results = new FilterResults();
            if (constraint == null || constraint.length() == 0) {
                results.values = doctorList;
                results.count = doctorList.size();
            } else {
                ArrayList<FavoriteDoctor> filteredContacts = new ArrayList<>();
                for (FavoriteDoctor doctor : doctorList) {

                    if (doctor.getSpecialityName().toLowerCase()
                            .contains(constraint.toString().toLowerCase())) {
                        filteredContacts.add(doctor);
                    }
                }
                results.values = filteredContacts;
                results.count = filteredContacts.size();
            }
            return results;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            items = (List<FavoriteDoctor>) results.values;
            notifyDataSetChanged();
        }
    }
}
