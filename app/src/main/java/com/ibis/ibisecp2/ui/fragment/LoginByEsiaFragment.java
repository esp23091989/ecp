package com.ibis.ibisecp2.ui.fragment;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.ProgressBar;

import com.ibis.ibisecp2.R;
import com.ibis.ibisecp2.dagger.component.FragmentComponent;
import com.ibis.ibisecp2.events.ErrorChildEvent;
import com.ibis.ibisecp2.helpers.DialogsHelper;
import com.ibis.ibisecp2.helpers.ProgressDialogHelper;
import com.ibis.ibisecp2.model.EsiaTokenMarker;
import com.ibis.ibisecp2.presenters.LoginByEsiaPresenter;
import com.ibis.ibisecp2.ui.EsiaMarkerReceiveListener;
import com.ibis.ibisecp2.ui.activity.BaseActivity;
import com.ibis.ibisecp2.ui.view.LoginByEsiaView;
import com.ibis.ibisecp2.ui.viewutils.AuthenticatingWebView;
import com.ibis.ibisecp2.ui.viewutils.AuthenticatingWebViewCallbackMethods;
import com.ibis.ibisecp2.utils.AndroidUtils;

import org.greenrobot.eventbus.EventBus;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;


public class LoginByEsiaFragment extends BaseFragment implements LoginByEsiaView {
    public static final String TAG = LoginByEsiaFragment.class.getSimpleName();
    public static final String URL_ESIA = " https://ecp-test.miacugra.ru/esia/Account/LoginTest?provider=ESIA";

    @BindView(R.id.webView)
    WebView webView;
    @BindView(R.id.pb_web)
    ProgressBar progressBar;

    @Inject
    LoginByEsiaPresenter presenter;

    private AuthenticatingWebView authenticatingWebView;
    private EsiaMarkerReceiveListener esiaMarkerReceiveListener;

    public static LoginByEsiaFragment newInstance() {
        return new LoginByEsiaFragment();
    }

    @Override
    void doInjection(FragmentComponent fragmentComponent) {
        fragmentComponent.inject(this);
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
                if(esiaMarkerReceiveListener != null){
                    esiaMarkerReceiveListener.onEsiaMarkerReceived(marker);
                }
                presenter.saveEsiaMarker(marker);

            }
        });
        authenticatingWebView.makeRequest(URL_ESIA);
        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if(context instanceof EsiaMarkerReceiveListener) {
            this.esiaMarkerReceiveListener = (EsiaMarkerReceiveListener) context;
        }
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
