package com.ibis.ibisecp2.ui.activity;

import android.os.Bundle;

import com.ibis.ibisecp2.R;
import com.ibis.ibisecp2.dagger.component.ActivityComponent;
import com.ibis.ibisecp2.model.EsiaTokenMarker;
import com.ibis.ibisecp2.presenters.LoginPresenter_;
import com.ibis.ibisecp2.ui.view.LoginView_;

import javax.inject.Inject;

import butterknife.ButterKnife;

public class LoginActivity extends BaseActivity implements LoginView_ {

    public static final String ERROR_CODE = "error_code";

    @Inject
    LoginPresenter_ presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        setTitle("Вход");

        presenter.attachView(this);
        presenter.onStart();
    }

    @Override
    void doInjections(ActivityComponent activityComponent) {
        activityComponent.inject(this);
    }

    @Override
    public void showLoad() {

    }

    @Override
    public void hideLoad() {

    }

    @Override
    protected void onDestroy() {
        presenter.detachView();
        super.onDestroy();
    }

    @Override
    public void onEsiaMarkerReceived(EsiaTokenMarker marker) {
        presenter.saveMarker(marker);
        setResult(RESULT_OK);
        finish();
    }
}
