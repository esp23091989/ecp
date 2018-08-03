package com.ibis.ibisecp2.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.ibis.ibisecp2.R;
import com.ibis.ibisecp2.listeners.PatientAdapterListener;
import com.ibis.ibisecp2.model.Patient;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by danila on 14.06.16.
 */
public class PatientAdapter extends RecyclerView.Adapter<PatientAdapter.ViewHolder> {
    private LayoutInflater mLayoutInflater;
    private List<Patient> patientList;
    private PatientAdapterListener adapterListener;
    private Context context;

    public PatientAdapter(Context context, List<Patient> patientList, PatientAdapterListener
            adapterListener) {
        super();
        mLayoutInflater = LayoutInflater.from(context);
        this.context = context;
        this.patientList = patientList;
        this.adapterListener = adapterListener;
    }

    public List<Patient> getPatientList() {
        return patientList;
    }

    public void setPatientList(List<Patient> patientList) {
        this.patientList = patientList;
        notifyDataSetChanged();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mLayoutInflater.inflate(R.layout.patient_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Patient patient = patientList.get(position);
        holder.label.setText(patient.getFullName());
    }

    public void removeItem(int position) {
        patientList.remove(position);
        notifyItemRemoved(position);
        notifyItemRangeChanged(position, patientList.size());
    }

    @Override
    public int getItemCount() {
        return patientList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.label)
        TextView label;
        @BindView(R.id.llPatientItem)
        LinearLayout llPatientItem;


        public ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
            llPatientItem.setOnClickListener(v -> {
                adapterListener.onPatientClick(patientList.get(getAdapterPosition()));
            });

        }
    }
}


