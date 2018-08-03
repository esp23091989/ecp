package com.ibis.ibisecp2.adapter;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.ibis.ibisecp2.R;

import java.util.Collections;
import java.util.List;

/**
 * Created by danila on 17.11.16.
 */

public class SpinnerAdapter extends ArrayAdapter {
    // Your sent context
    private Context context;
    // Your custom values for the spinner
    private List<String> values = Collections.emptyList();

    public SpinnerAdapter(Context context, int textViewResourceId, List<String> values) {
        super(context, textViewResourceId, values);
        this.context = context;
        this.values = values;
    }

    public int getCount() {
        return values.size();
    }

    public String getItem(int position) {
        return values.get(position);
    }

    public long getItemId(int position) {
        return position;
    }

    // And the "magic" goes here
    // This is for the "passive" state of the spinner
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // I created a dynamic TextView here, but you can reference your own  custom layout for each spinner item
        TextView label = setupTextView(position);
        label.setSingleLine();
        // And finally return your dynamic (or custom) view for each spinner item

        return label;
    }

    @NonNull
    private View getTextView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        if (view == null) {
            LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = layoutInflater.inflate(R.layout.dialog_item, parent, false);
        }
        TextView label = (TextView) view.findViewById(R.id.tv_item_dialog);
        label.setText(getItem(position));
        label.setSingleLine();
        return view;
    }

    // And here is when the "chooser" is popped up
    // Normally is the same view, but you can customize it if you want
    @Override
    public View getDropDownView(int position, View convertView,
                                ViewGroup parent) {
        return getTextView(position, convertView, parent);
    }

    @NonNull
    private TextView setupTextView(int position) {
        TextView label = new TextView(context);
        label.setTextColor(Color.BLACK);
        // Then you can get the current item using the values array and the current position
        // You can NOW reference each method you has created in your bean object
        label.setText((String) values.get(position));
        return label;
    }
}
