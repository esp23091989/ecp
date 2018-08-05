package com.ibis.ibisecp2.ui.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.ProgressBar;

import com.ibis.ibisecp2.R;
import com.ibis.ibisecp2.dagger.component.FragmentComponent;
import com.ibis.ibisecp2.helpers.ProgressDialogHelper;
import com.ibis.ibisecp2.model.EsiaTokenMarker;
import com.ibis.ibisecp2.presenters.LoginByEsiaPresenter;
import com.ibis.ibisecp2.ui.view.LoginByEsiaView;
import com.ibis.ibisecp2.ui.viewutils.AuthenticatingWebView;
import com.ibis.ibisecp2.ui.viewutils.AuthenticatingWebViewCallbackMethods;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;


public class LoginByEsiaFragment extends BaseFragment implements LoginByEsiaView {
    public static final String TAG = LoginByEsiaFragment.class.getSimpleName();
    public static final String URL_ESIA = "https://ecp-test.miacugra.ru/esia";

    @BindView(R.id.webView)
    WebView webView;
    @BindView(R.id.pb_web)
    ProgressBar progressBar;

    @Inject
    LoginByEsiaPresenter presenter;

    @Inject
    ProgressDialogHelper progressDialogHelper;

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
        presenter.attachView(this);
        AuthenticatingWebView authenticatingWebView = new AuthenticatingWebView(webView, new AuthenticatingWebViewCallbackMethods() {
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
//                presenter.getPatient(marker);
                Log.d("","");
            }
        });
        authenticatingWebView.makeRequest(URL_ESIA);
        return view;
    }


    @Override
    void doInjection(FragmentComponent fragmentComponent) {
        fragmentComponent.inject(this);
    }

    @Override
    public void showWebLoading() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideWebLoading() {
        progressBar.setVisibility(View.GONE);
    }
}
