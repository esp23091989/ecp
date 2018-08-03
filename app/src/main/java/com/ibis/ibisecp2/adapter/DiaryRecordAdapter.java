package com.ibis.ibisecp2.adapter;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.ibis.ibisecp2.R;
import com.ibis.ibisecp2.listeners.OnPositionAdapterListener;
import com.ibis.ibisecp2.model.DiaryRecord;
import com.ibis.ibisecp2.utils.TextUtils;
import com.ibis.ibisecp2.utils.Utils;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DiaryRecordAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private final int VIEW_TYPE_ITEM = 0;
    private final int VIEW_TYPE_LOADING = 1;

    private LayoutInflater mLayoutInflater;
    private List<DiaryRecord> diaryRecordList;
    private OnPositionAdapterListener listener;
    private Context context;

    public DiaryRecordAdapter(Context context, List<DiaryRecord> diaryRecordList,
                              OnPositionAdapterListener listener) {
        super();
        mLayoutInflater = LayoutInflater.from(context);
        this.diaryRecordList = diaryRecordList;
        this.listener = listener;
        this.context = context;
    }

    public void setDiaryRecordList(List<DiaryRecord> diaryRecordList) {
        this.diaryRecordList = diaryRecordList;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view;

        if (viewType == VIEW_TYPE_ITEM) {
            view = mLayoutInflater.inflate(R.layout.diary_record_layout, parent, false);
            return new ItemHolder(view);
        } else if (viewType == VIEW_TYPE_LOADING) {
            view = mLayoutInflater.inflate(R.layout.progress, parent, false);
            return new FooterHolder(view);
        }
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof ItemHolder) {
            ItemHolder itemHolder = (ItemHolder) holder;
            DiaryRecord diaryRecord = diaryRecordList.get(position);
            String note = diaryRecord.getNote();
            itemHolder.tvDiaryRecord.setText(TextUtils.greyText("Запись:", note, context));
            itemHolder.tvDateDiary.setText(TextUtils.greyText("Дата:", diaryRecord.getDate(), context));

            String[] mas = note.split("\n");
            String firstLine = mas[0];
            if (firstLine != null && firstLine.contains("=")) {
                Utils.SetBackground(itemHolder.diaryRecordLayout,
                        ContextCompat.getDrawable(context, R.drawable.mono_light_green_button_background));
            } else {
                Utils.SetBackground(itemHolder.diaryRecordLayout,
                        ContextCompat.getDrawable(context, R.drawable.grey_background));

            }
        } else if (holder instanceof FooterHolder) {
            FooterHolder loadingViewHolder = (FooterHolder) holder;
            loadingViewHolder.progressLoadMore.setIndeterminate(true);
        }
    }

    @Override
    public int getItemViewType(int position) {
        return diaryRecordList.get(position) == null ? VIEW_TYPE_LOADING : VIEW_TYPE_ITEM;
    }

    @Override
    public int getItemCount() {
        return diaryRecordList.size();
    }

    public void loadMore() {
        diaryRecordList.add(null);
        notifyItemInserted(diaryRecordList.size() - 1);
    }

    public class ItemHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tvDateDiary)
        TextView tvDateDiary;
        @BindView(R.id.tvDiaryRecord)
        TextView tvDiaryRecord;
        @BindView(R.id.diaryRecordLayout)
        RelativeLayout diaryRecordLayout;

        public ItemHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
            view.setOnClickListener(v -> {
                listener.onClick(getLayoutPosition());
            });
        }
    }

    public class FooterHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.progress_load_more)
        ProgressBar progressLoadMore;

        public FooterHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}