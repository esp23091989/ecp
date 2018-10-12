package com.ibis.ibisecp2.ui.fragment;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.TextView;

import com.ibis.ibisecp2.R;
import com.ibis.ibisecp2.adapter.ScheduleTimeAdapter;
import com.ibis.ibisecp2.events.ChooseTimeEvent;
import com.ibis.ibisecp2.listeners.OnItemAdapterListener;
import com.ibis.ibisecp2.model.Schedule;
import com.ibis.ibisecp2.model.SlotList;

import org.greenrobot.eventbus.EventBus;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by danila on 30.11.15.
 */
public class FreeTimeFragment extends DialogFragment implements OnItemAdapterListener {

    public static final String TAG = FreeTimeFragment.class.getSimpleName();

    @BindView(R.id.rvFreTime)
    RecyclerView rvFreTime;
    @BindView(R.id.appointmentTimeLayoutTitleTextView)
    TextView appointmentTimeLayoutTitleTextView;
    @BindView(R.id.tvScheduleInfo)
    TextView tvScheduleInfo;

    private Schedule freeTimeList;


    public static FreeTimeFragment newInstance(Schedule freeTimeList) {
        FreeTimeFragment fragment = new FreeTimeFragment();
        fragment.freeTimeList = freeTimeList;
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_free_time, container, false);
        getDialog().getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        getDialog().getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        getDialog().getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT);
        ButterKnife.bind(this, rootView);
        if (freeTimeList.getScheduleInfo() != null) {
            tvScheduleInfo.setText(freeTimeList.getScheduleInfo());
        } else {
            tvScheduleInfo.setVisibility(View.GONE);
        }
        if (freeTimeList.getSlotList() == null || freeTimeList.getSlotList().size() == 0) {
            appointmentTimeLayoutTitleTextView.setText("Свободного времени нет");
            rvFreTime.setVisibility(View.GONE);
        } else {
            GridLayoutManager lLayout = new GridLayoutManager(getActivity(), 4);
            rvFreTime.setHasFixedSize(true);
            rvFreTime.setLayoutManager(lLayout);
            ScheduleTimeAdapter adapter =
                    new ScheduleTimeAdapter(getActivity(), freeTimeList.getSlotList(), this);
            rvFreTime.setVisibility(View.VISIBLE);
            rvFreTime.setAdapter(adapter);
        }

        return rootView;
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

    @Override
    public <T> void onItemClick(T t) {
        EventBus.getDefault().postSticky(new ChooseTimeEvent(((SlotList) t).getScheduleId(),
                ((SlotList) t).getStartTime(), ((SlotList) t).getSlotType()));
        dismiss();
    }
}
