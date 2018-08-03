package com.ibis.ibisecp2.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ibis.ibisecp2.R;
import com.ibis.ibisecp2.listeners.SpecialityListAdapterListener;
import com.ibis.ibisecp2.model.Speciality;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by danila on 20.11.15.
 */
public class SpecialityListAdapter extends RecyclerView.Adapter<SpecialityListAdapter.ViewHolder> {

    private LayoutInflater mLayoutInflater;
    private List<Speciality> specialityList;
    private Context context;
    private SpecialityListAdapterListener specialityListAdapterListener;

    public SpecialityListAdapter(Context context, List<Speciality> specialityList,
                                 SpecialityListAdapterListener specialityListAdapterListener) {
        super();
        mLayoutInflater = LayoutInflater.from(context);
        this.context = context;
        this.specialityList = specialityList;
        this.specialityListAdapterListener = specialityListAdapterListener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mLayoutInflater.inflate(R.layout.speciality_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(SpecialityListAdapter.ViewHolder holder, int position) {

        holder.mTextViewItemName.setText(specialityList.get(position).getName());

    }


    @Override
    public int getItemCount() {
        return specialityList.size();
    }

    public void setSpecialityList(List<Speciality> specialityList) {
        this.specialityList = specialityList;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.textViewItemSpec)
        TextView mTextViewItemName;

        public ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
            view.setOnClickListener(v -> {
                specialityListAdapterListener
                        .onSelectedSpeciality(specialityList.get(getAdapterPosition()));
            });

        }
    }
}
