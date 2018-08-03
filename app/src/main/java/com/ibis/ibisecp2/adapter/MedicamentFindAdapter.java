package com.ibis.ibisecp2.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.ibis.ibisecp2.R;
import com.ibis.ibisecp2.listeners.ShowDosageListener;
import com.ibis.ibisecp2.model.Medicament;

import java.util.List;
import java.util.Locale;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by danila on 24.11.15.
 */
public class MedicamentFindAdapter extends RecyclerView.Adapter<MedicamentFindAdapter.ViewHolder> {

    private LayoutInflater mLayoutInflater;
    private List<Medicament> medicamentList;
    private ShowDosageListener listener;
    private Context context;

    public MedicamentFindAdapter(Context context, List<Medicament> medicamentList,
                                 ShowDosageListener listener) {
        super();
        mLayoutInflater = LayoutInflater.from(context);
        this.medicamentList = medicamentList;
        this.listener = listener;
        this.context = context;
    }

    public void setMedicamentList(List<Medicament> medicamentList) {
        this.medicamentList = medicamentList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mLayoutInflater.inflate(R.layout.medicamental_find_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Medicament item = medicamentList.get(position);
        String priceText = String.format(Locale.US, "%.2f", item.getPrice());
        holder.costTextView.setText(priceText);
        String traidName = item.getTradename() == null ? "" : item.getTradename();
        if ("".equals(traidName)) {
            holder.nameTextView.setText(item.getName());
        } else {
            traidName = " (" + traidName + ")";
            holder.nameTextView.setText(item.getName() + traidName);
        }
        holder.lpuInfoTextView.setText(item.getManufacturer());

    }

    @Override
    public int getItemCount() {
        return medicamentList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.medicamentServiceInfoLayout)
        LinearLayout medicamentServiceInfoLayout;
        @BindView(R.id.nameTextView)
        TextView nameTextView;
        @BindView(R.id.lpuInfoTextView)
        TextView lpuInfoTextView;
        @BindView(R.id.costTextView)
        TextView costTextView;
        @BindView(R.id.dosageButton)
        Button dosageButton;
        @BindView(R.id.itemDosageLayout)
        LinearLayout itemDosageLayout;

        public ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
            dosageButton.setOnClickListener(view1 -> {
                Medicament item = medicamentList.get(getAdapterPosition());
                listener.showDosage(item.getTradename(), item.getDose());
            });
            view.setOnClickListener(view12 ->
                    listener.find(medicamentList.get(getAdapterPosition()).getTradename()));
        }
    }
}
