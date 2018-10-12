package com.ibis.ibisecp2.ui.activity;

import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import com.ibis.ibisecp2.R;
import com.ibis.ibisecp2.dagger.component.ActivityComponent;
import com.ibis.ibisecp2.model.Patient;
import com.ibis.ibisecp2.presenters.MainPresenter;
import com.ibis.ibisecp2.ui.view.MainView;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity implements MainView {

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.nav_view)
    NavigationView navView;
    @BindView(R.id.drawer_layout)
    DrawerLayout drawer;
    @BindView(R.id.tvHi)
    TextView tvHi;

    @Inject
    MainPresenter mMainPresenter;

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
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        mMainPresenter.attachView(this);
        mMainPresenter.getPatient();
        setTitle("Эл. кабинет пациента");
//        /*update doctors*/
//        Intent intent = DoctorService.newIntent(this);
//        startService(intent);
        setupDrawer();
    }

    private void openMainMenu() {
        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                openDrawer();
            }
        }, 3000);
    }

    @Override
    protected void onResume() {
        super.onResume();
        preferencesUtils.saveItemId(-1);
        openMainMenu();
    }

    @Override
    protected void onDestroy() {
        mMainPresenter.detachView();
        super.onDestroy();
    }

    @Override
    public void showPatient(Patient patient) {
        tvHi.setText(String.format("Рады приветствовать Вас,\n%s %s!", patient.getFirstName(),
                patient.getMiddleName()));
    }
}
