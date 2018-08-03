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
import com.ibis.ibisecp2.model.City;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


public class CityAdapter extends RecyclerView.Adapter<CityAdapter.ViewHolder> {
    private LayoutInflater mLayoutInflater;
    private List<City> cityList = new ArrayList<>();
    private List<City> cityArrayList;
    private OnItemAdapterListener listener;
    private CityFilter filter;


    public CityAdapter(Context context, List<City> cityArrayList, OnItemAdapterListener listener) {
        super();
        mLayoutInflater = LayoutInflater.from(context);
        setupListCity(cityArrayList);
        this.listener = listener;
    }

    private void setupListCity(List<City> cityArrayList) {
        this.cityArrayList = cityArrayList;
        this.cityList.clear();
        this.cityList.addAll(cityArrayList);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mLayoutInflater.inflate(R.layout.item_city, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        City city = cityArrayList.get(position);
        holder.tvCity.setText(city.getName());
    }


    @Override
    public int getItemCount() {
        return cityArrayList.size();
    }

    public void setCityList(List<City> cityArrayList) {
        setupListCity(cityArrayList);
        notifyDataSetChanged();
    }

    public Filter getFilter() {
        if (filter == null) {
            filter = new CityFilter();
        }
        return filter;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tvCity)
        TextView tvCity;

        public ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
            view.setOnClickListener(v -> {
                listener.onItemClick(cityArrayList.get(getAdapterPosition()));
            });
        }
    }

    private class CityFilter extends Filter {

        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            // Create a FilterResults object
            FilterResults results = new FilterResults();
            if (constraint == null || constraint.length() == 0) {
                results.values = cityList;
                results.count = cityList.size();
            } else {
                ArrayList<City> filteredContacts = new ArrayList<>();
                for (City city : cityList) {
                    if (city.getName().toLowerCase().contains(constraint.toString().toLowerCase())) {
                        filteredContacts.add(city);
                    }
                }
                results.values = filteredContacts;
                results.count = filteredContacts.size();
            }
            return results;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            cityArrayList = (List<City>) results.values;
            notifyDataSetChanged();
        }
    }
}