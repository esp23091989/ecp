package com.ibis.ibisecp2.ui.fragment;

import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.ibis.ibisecp2.R;
import com.ibis.ibisecp2.events.CreateNotificationEvent;
import com.ibis.ibisecp2.events.DeleteNotificationEvent;
import com.ibis.ibisecp2.helpers.DialogsHelper;
import com.ibis.ibisecp2.presenters.ReminderTimePresenter;
import com.ibis.ibisecp2.ui.activity.BaseActivity;
import com.ibis.ibisecp2.ui.view.ReminderTimeView;

import org.greenrobot.eventbus.EventBus;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by danila on 16.11.16.
 */

public class ReminderTimeFragment extends DialogFragment implements ReminderTimeView {

    @BindView(R.id.time)
    TextView time;
    @BindView(R.id.timeValue)
    TextView timeValue;
    @BindView(R.id.llTime)
    LinearLayout llTime;
    @BindView(R.id.dataValue)
    TextView dataValue;
    @BindView(R.id.llData)
    LinearLayout llData;

    @Inject
    ReminderTimePresenter reminderTimePresenter;

    @Inject
    DialogsHelper dialogsHelper;
    @BindView(R.id.progress_bar)
    ProgressBar progressBar;
    @BindView(R.id.svReminderTime)
    ScrollView svReminderTime;

    private long id;

    public ReminderTimeFragment() {
    }

    public static ReminderTimeFragment newInstance(long id) {
        ReminderTimeFragment fragment = new ReminderTimeFragment();
        fragment.id = id;
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_reminder_time, container, false);
        getDialog().getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        getDialog().setCanceledOnTouchOutside(false);
        ButterKnife.bind(this, rootView);
        BaseActivity activity = (BaseActivity) getActivity();
        activity.getComponent().plusFragmentComponent().inject(this);
        reminderTimePresenter.attachView(this);
        reminderTimePresenter.getReminder(id);
        return rootView;
    }

    @Override
    public void onDestroyView() {
        reminderTimePresenter.detachView();
        super.onDestroyView();
    }

    @OnClick({R.id.imgBack, R.id.llTime, R.id.llData, R.id.imgSave, R.id.imgDelete})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.imgBack:
                dismiss();
                break;
            case R.id.llTime:
                reminderTimePresenter.setReminderTime(timeValue);
                break;
            case R.id.llData:
                reminderTimePresenter.setReminderData(dataValue);
                break;
            case R.id.imgSave:
                setupReminderData();
                break;
            case R.id.imgDelete:
                reminderTimePresenter.deleteReminder();
                break;
        }
    }

    private void setupReminderData() {
        String date = dataValue.getText().toString();
        String time = timeValue.getText().toString();
        if (date.length() > 0 && time.length() > 0) {
            reminderTimePresenter.saveReminder(date + " " + time, id);
        } else {
            String msg;
            if (date.length() == 0) {
                msg = "Введите дату";
            } else {
                msg = "Введите время";
            }
            dialogsHelper.alertDialogErrorMsg(msg);
        }
    }

    @Override
    public void showLoad() {
        progressBar.setVisibility(View.VISIBLE);
        svReminderTime.setVisibility(View.GONE);
    }

    @Override
    public void hideLoad() {
        progressBar.setVisibility(View.GONE);
        svReminderTime.setVisibility(View.VISIBLE);
    }

    @Override
    public void showError() {
        hideLoad();
        Toast.makeText(getActivity(), "Ошибка создания напоминания", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void success() {
        EventBus.getDefault().postSticky(new CreateNotificationEvent(dataValue.getText().toString() +
                " " + timeValue.getText()));
        dismiss();
    }

    @Override
    public void successDelete() {
        dismiss();
        EventBus.getDefault().postSticky(new DeleteNotificationEvent());
    }

    @Override
    public void setDataAndTime(String data, String time) {
        dataValue.setText(data);
        timeValue.setText(time);
    }
}
