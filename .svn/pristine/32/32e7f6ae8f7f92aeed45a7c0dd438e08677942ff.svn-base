package com.ibis.ibisecp2.ui.fragment;


import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.ibis.ibisecp2.R;
import com.ibis.ibisecp2.events.ConfirmSmsEvent;
import com.ibis.ibisecp2.events.ErrorChildEvent;
import com.ibis.ibisecp2.helpers.DialogsHelper;
import com.ibis.ibisecp2.presenters.ConfirmSmsPresenter;
import com.ibis.ibisecp2.ui.activity.BaseActivity;
import com.ibis.ibisecp2.ui.view.ConfirmSmsView;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class ConfirmSmsFragment extends DialogFragment implements ConfirmSmsView {

    public static final int validTimeCode = 300000;

    MyCountDownTimer myCountDownTimer;
    Unbinder unbinder;
    @BindView(R.id.etCode)
    EditText etCode;

    @Inject
    ConfirmSmsPresenter presenter;
    @Inject
    DialogsHelper dialogsHelper;
    @BindView(R.id.llProgress)
    LinearLayout llProgress;
    @BindView(R.id.tvTitleConfirm)
    TextView tvTitleConfirm;
    @BindView(R.id.btnInputCode)
    Button btnInputCode;
    @BindView(R.id.tvTimeCode)
    TextView tvTimeCode;

    private boolean isSavePass;
    private String login;
    private boolean isFinishTimer;

    public ConfirmSmsFragment() {
        // Required empty public constructor
    }

    public static ConfirmSmsFragment newInstance(String login, boolean isSavePass) {
        ConfirmSmsFragment fragment = new ConfirmSmsFragment();
        fragment.isSavePass = isSavePass;
        fragment.login = login;
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_confirm_sms, container, false);
        getDialog().getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        getDialog().getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        getDialog().getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT);
        getDialog().setCanceledOnTouchOutside(false);
        BaseActivity activity = (BaseActivity) getActivity();
        activity.getComponent().plusFragmentComponent().inject(this);
        presenter.attachView(this);
        myCountDownTimer = new MyCountDownTimer(validTimeCode, 1000);
        myCountDownTimer.start();
        unbinder = ButterKnife.bind(this, rootView);
        showHideProgress(View.GONE);
        return rootView;
    }

    @Override
    public void onPause() {
        super.onPause();
    }

    @Override
    public void onStart() {
        super.onStart();
        if (!EventBus.getDefault().isRegistered(this)) {
            EventBus.getDefault().register(this);
        }
    }

    @Override
    public void onDestroyView() {
        presenter.detachView();
        super.onDestroyView();
        if (EventBus.getDefault().isRegistered(this)) {
            EventBus.getDefault().unregister(this);
        }
        myCountDownTimer.cancel();
        unbinder.unbind();
    }

    @OnClick(R.id.btnInputCode)
    public void onClick() {
        myCountDownTimer.cancel();
        if (checkCode()) {
            presenter.confirm(login, etCode.getText().toString(), isSavePass);
            showHideProgress(View.VISIBLE);
        }
    }

    private boolean checkCode() {
        String code = etCode.getText().toString();
        if (code.length() == 0) {
            dialogsHelper.alertDialogErrorMsg("Код не может быть пустым");
            return false;
        }
        return true;
    }

    @Override
    public void onSuccessConfirm() {
        dismiss();
        myCountDownTimer.cancel();
    }

    @Override
    public void onErrorConfirm() {
        showHideProgress(View.GONE);
        etCode.setText("");
        etCode.setError("Неверный код. Введите заново");
        myCountDownTimer.cancel();
        myCountDownTimer.onTick(validTimeCode);
        myCountDownTimer.start();

    }

    @Override
    public void onErrorConfirmOther() {
        showHideProgress(View.GONE);
    }

    @Override
    public void onErrorTryConfirm() {
        dismiss();
        dialogsHelper.alertDialogErrorMsg("Истекли попытки ввода кода.");
    }

    @Override
    public void onErrorChild(String text) {
        EventBus.getDefault().postSticky(new ErrorChildEvent(text));
    }

    @Override
    public void errorLoginMsg(String e) {
        dialogsHelper.alertDialogErrorMsg(e);
        dismiss();
    }

    @Subscribe
    public void onConfirmSmsEvent(ConfirmSmsEvent event) {
        etCode.setText(event.getCode());
        etCode.setSelection(etCode.length());
        presenter.confirm(login, etCode.getText().toString(), isSavePass);
        showHideProgress(View.VISIBLE);
    }

    private void showHideProgress(int progressVisible) {
        llProgress.setVisibility(progressVisible);
        int visible = progressVisible == View.VISIBLE ? View.GONE : View.VISIBLE;
        btnInputCode.setVisibility(visible);
        tvTimeCode.setVisibility(visible);
    }

    private class MyCountDownTimer extends CountDownTimer {

        private MyCountDownTimer(long millisInFuture, long countDownInterval) {
            super(millisInFuture, countDownInterval);
        }

        @Override
        public void onTick(long millisUntilFinished) {

            int time = (int) (millisUntilFinished / 1000);
            if (tvTimeCode != null) {
                tvTimeCode.setText("Код действителен еще " + time + " секунд");
            }

        }

        @Override
        public void onFinish() {
            isFinishTimer = true;
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        if (isFinishTimer) {
            dismiss();
        }
        isFinishTimer = false;
    }
}
