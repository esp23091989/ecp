package com.ibis.ibisecp2.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.TextView;

import com.ibis.ibisecp2.R;
import com.ibis.ibisecp2.listeners.DoctorListAdapterListener;
import com.ibis.ibisecp2.model.Doctor;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by danila on 14.02.17.
 */

public class DoctorAdapter extends RecyclerView.Adapter<DoctorAdapter.ViewHolder> {

    public static final String DEPARTMENT = "department";
    public static final String SPECIALITY = "speciality";
    public static final String DOCTORS = "doctors";
    public static final String DOCTORS_BY_SPEC = "doctorBySpec";

    private LayoutInflater mLayoutInflater;


    private List<Doctor> doctorList = new ArrayList<>();
    private List<Doctor> doctorArrayList;
    private DoctorFilter filter;
    private String type;

    private DoctorListAdapterListener doctorListAdapterListener;

    public DoctorAdapter(Context context, List<Doctor> doctorList, DoctorListAdapterListener
            doctorListAdapterListener, String type) {
        super();
        mLayoutInflater = LayoutInflater.from(context);
        this.doctorList.addAll(doctorList);
        this.doctorArrayList = doctorList;
        this.doctorListAdapterListener = doctorListAdapterListener;
        this.type = type;
    }

    public void setDoctorList(List<Doctor> doctorList) {
        this.doctorArrayList = doctorList;
        this.doctorList.clear();
        this.doctorList.addAll(doctorList);
        notifyDataSetChanged();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mLayoutInflater.inflate(R.layout.doctor_fio_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Doctor doctor = doctorArrayList.get(position);
        if (DEPARTMENT.equals(type)) {
            setupDataInView(holder.tvDoctorName, doctor.getDeptName());
            setupDataInView(holder.tvDoctorSpeciality, doctor.getDeptAddress());
        } else if (SPECIALITY.equals(type)) {
            setupDataInView(holder.tvDoctorName, doctor.getPositionName());
            holder.tvDoctorSpeciality.setVisibility(View.GONE);
        } else if (DOCTORS_BY_SPEC.equals(type)) {
            setupDataInView(holder.tvDoctorName, doctor.getSpecialityName());
            holder.tvDoctorSpeciality.setText("Ближайшая дата приема: " + doctor.getNearestDate());
        } else {
            holder.tvDoctorName.setText(doctor.getSpecialityName());
            holder.tvDoctorSpeciality.setText(doctor.getDeptName()
                    + "\n" + doctor.getPositionName() + "\n" + "Ближайшая дата приема: " + doctor.getNearestDate());
        }
    }

    @Override
    public int getItemCount() {
        return doctorArrayList.size();
    }

    private void setupDataInView(TextView textView, String txt) {
        if (txt == null || "".equals(txt)) {
            textView.setVisibility(View.GONE);
        } else {
            textView.setVisibility(View.VISIBLE);
            textView.setText(txt);
        }

    }

    public Filter getFilter() {
        if (filter == null) {
            filter = new DoctorFilter();
        }
        return filter;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tv_doctor_name)
        TextView tvDoctorName;
        @BindView(R.id.tv_doctor_speciality)
        TextView tvDoctorSpeciality;

        public ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
            view.setOnClickListener(v -> {
                doctorListAdapterListener.onDoctorClick(doctorArrayList.get(getAdapterPosition()));
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
                ArrayList<Doctor> filteredContacts = new ArrayList<Doctor>();
                for (Doctor doctor : doctorList) {
                    String searchField;
                    if (DEPARTMENT.equals(type)) {
                        searchField = doctor.getDeptName();
                    } else if (SPECIALITY.equals(type)) {
                        searchField = doctor.getPositionName();
                    } else {
                        searchField = doctor.getSpecialityName();
                    }

                    if (searchField.toLowerCase().contains(constraint.toString().toLowerCase())) {
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
            doctorArrayList = (List<Doctor>) results.values;
            notifyDataSetChanged();
        }
    }
}
