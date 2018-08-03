package com.ibis.ibisecp2.ui.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;

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
                progressDialogHelper.showDialog();
            }

            @Override
            public void stopProgressDialog() {
                progressDialogHelper.hideDialog();
            }

            @Override
            public void displayResults(EsiaTokenMarker dataDTO) {

            }
        });
        authenticatingWebView.makeRequest(URL_ESIA);
        return view;
    }



    @Override
    void doInjection(FragmentComponent fragmentComponent) {
        fragmentComponent.inject(this);
    }
}
