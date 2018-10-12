package com.ibis.ibisecp2.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.ibis.ibisecp2.R;

import java.util.List;

/**
 * Created by comp on 02.03.17.
 */

public class DialogAdapter extends ArrayAdapter<String> {


    Context context;
    private List<String> stringList;

    public DialogAdapter(Context context, int textViewResourceId, List<String>
            stringList) {
        super(context, textViewResourceId, stringList);
        // TODO Auto-generated constructor stub
        this.stringList = stringList;

        this.context = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        TextView label = null;
        if (view == null) {
            LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = layoutInflater.inflate(R.layout.dialog_item, null, false);

        }
        label = (TextView) view.findViewById(R.id.tv_item_dialog);
        label.setText(getItem(position));
        return view;
    }

    public String getItem(int position) {
        return stringList.get(position);
    }
}
