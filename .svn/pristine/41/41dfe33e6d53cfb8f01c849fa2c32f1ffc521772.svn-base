package com.ibis.ibisecp2.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.ibis.ibisecp2.R;
import com.ibis.ibisecp2.listeners.OnDiaryRecordClickListener;
import com.ibis.ibisecp2.model.DiaryRecord;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by danila on 15.12.16.
 */

public class DiaryRecordHorizontalAdapter extends RecyclerView.Adapter<DiaryRecordHorizontalAdapter.ViewHolder> {

    private LayoutInflater mLayoutInflater;
    private List<DiaryRecord> diaryRecords;
    private OnDiaryRecordClickListener listener;

    public DiaryRecordHorizontalAdapter(Context context, List<DiaryRecord> diaryRecords,
                                        OnDiaryRecordClickListener listener) {
        super();
        mLayoutInflater = LayoutInflater.from(context);
        this.diaryRecords = diaryRecords;
        this.listener = listener;
    }

    public void setPatientList(List<DiaryRecord> diaryRecords) {
        this.diaryRecords = diaryRecords;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mLayoutInflater.inflate(R.layout.item_record_horizontal, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        DiaryRecord record = diaryRecords.get(position);
        holder.etItemRecord.setText(record.getNote() != null ? record.getNote() : "");
    }

    @Override
    public int getItemCount() {
        return diaryRecords.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.et_item_record)
        EditText etItemRecord;

        public ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
            etItemRecord.setOnClickListener(view1 -> listener.onClickDiaryRecord(getAdapterPosition()));
        }
    }
}
