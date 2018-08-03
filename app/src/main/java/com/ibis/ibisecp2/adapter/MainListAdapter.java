package com.ibis.ibisecp2.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.ibis.ibisecp2.R;
import com.ibis.ibisecp2.listeners.MainListAdapterListener;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by danila on 20.11.15.
 */
public class MainListAdapter extends RecyclerView.Adapter<MainListAdapter.ViewHolder> {

    private LayoutInflater mLayoutInflater;
    private List<String> items;
    private Integer[] iconId;
    private MainListAdapterListener mainListAdapterListener;

    public MainListAdapter(Context context, List<String> items, Integer[] iconId,
                           MainListAdapterListener mainListAdapterListener) {
        super();
        mLayoutInflater = LayoutInflater.from(context);
        this.items = items;
        this.iconId = iconId;
        this.mainListAdapterListener = mainListAdapterListener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mLayoutInflater.inflate(R.layout.main_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.mTextViewItemName.setText(items.get(position));
        holder.mImageViewIcon.setImageResource(iconId[position]);
    }


    @Override
    public int getItemCount() {
        return items.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.textViewItemName)
        TextView mTextViewItemName;
        @BindView(R.id.imageViewIcon)
        ImageView mImageViewIcon;
        @BindView(R.id.item_main)
        RelativeLayout itemMain;

        public ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
            itemMain.setOnClickListener(v -> {
                mainListAdapterListener.onItemClick(getAdapterPosition());
            });


        }
    }
}
