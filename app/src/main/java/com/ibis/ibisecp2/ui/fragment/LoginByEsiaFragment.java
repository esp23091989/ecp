package com.ibis.ibisecp2.ui.fragment;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ProgressBar;

import com.ibis.ibisecp2.R;
import com.ibis.ibisecp2.dagger.component.FragmentComponent;
import com.ibis.ibisecp2.helpers.DialogsHelper;
import com.ibis.ibisecp2.helpers.ProgressDialogHelper;
import com.ibis.ibisecp2.model.EsiaTokenMarker;
import com.ibis.ibisecp2.presenters.LoginByEsiaPresenter;
import com.ibis.ibisecp2.ui.activity.BaseActivity;
import com.ibis.ibisecp2.ui.view.LoginByEsiaView;
import com.ibis.ibisecp2.ui.viewutils.AuthenticatingWebView;
import com.ibis.ibisecp2.ui.viewutils.AuthenticatingWebViewCallbackMethods;
import com.ibis.ibisecp2.utils.AndroidUtils;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class LoginByEsiaFragment extends DialogFragment implements LoginByEsiaView {
    public static final String TAG = LoginByEsiaFragment.class.getSimpleName();
    public static final String URL_ESIA = "https://ecp-test.miacugra.ru/esia";

    @BindView(R.id.webView)
    WebView webView;
    @BindView(R.id.pb_web)
    ProgressBar progressBar;

    @Inject
    LoginByEsiaPresenter presenter;

    @Inject
    DialogsHelper dialogsHelper;

    @Inject
    ProgressDialogHelper progressDialogHelper;

    private AuthenticatingWebView authenticatingWebView;

    public static LoginByEsiaFragment newInstance() {
        return new LoginByEsiaFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_login_by_esia, container, false);
        ButterKnife.bind(this, view);
        setRetainInstance(true);

        getDialog().getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        getDialog().getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        getDialog().getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT);
        getDialog().setCanceledOnTouchOutside(false);
        getDialog().getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE);
        ButterKnife.bind(this, view);
        BaseActivity activity = (BaseActivity) getActivity();
        activity.getComponent().plusFragmentComponent().inject(this);

        presenter.attachView(this);
        webView.getSettings().setLoadWithOverviewMode(true);
        webView.getSettings().setUseWideViewPort(true);

        authenticatingWebView = new AuthenticatingWebView(webView, new AuthenticatingWebViewCallbackMethods() {
            @Override
            public void startProgressDialog() {
                showWebLoading();
            }

            @Override
            public void stopProgressDialog() {
                hideWebLoading();
            }

            @Override
            public void displayResults(EsiaTokenMarker marker) {
                presenter.saveEsiaMarker(marker);
                presenter.getPatient();
                Log.d("","");

            }
        });
        authenticatingWebView.makeRequest(URL_ESIA);
        return view;
    }

    @Override
    public void showWebLoading() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideWebLoading() {
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void showLoading() {
        progressDialogHelper.showDialog();
    }

    @Override
    public void hideLoading() {
        progressDialogHelper.hideDialog();
    }

    @Override
    public void errorLoginMsg(String e) {
        authenticatingWebView.makeRequest(URL_ESIA);
        dialogsHelper.alertDialogErrorMsg(e);
    }

    @Override
    public void savePatient() {
        AndroidUtils.hideKeyboard(this);
    }

    @OnClick(R.id.buttonDialogList)
    public void listPatientShow() {
        presenter.openPatientListScreen();
        getDialog().dismiss();
    }
}
