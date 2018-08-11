package com.ibis.ibisecp2.ui.activity;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.AppCompatSpinner;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.TextView;

import com.ibis.ibisecp2.BuildConfig;
import com.ibis.ibisecp2.EcpApplication;
import com.ibis.ibisecp2.R;
import com.ibis.ibisecp2.adapter.SpinnerAdapter;
import com.ibis.ibisecp2.dagger.component.ActivityComponent;
import com.ibis.ibisecp2.helpers.DialogsHelper;
import com.ibis.ibisecp2.model.Patient;
import com.ibis.ibisecp2.presenters.StartPresenter;
import com.ibis.ibisecp2.ui.Navigator;
import com.ibis.ibisecp2.ui.view.StartView;
import com.ibis.ibisecp2.utils.SharedPreferencesUtils;

import java.util.Arrays;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class StartActivity extends BaseActivity implements StartView {

    public static final String ERROR_CODE = "error_code";

    @BindView(R.id.buttonLogin)
    Button mButtonLogin;
    @BindView(R.id.departmentTextView)
    TextView departmentTextView;
    @BindView(R.id.fab)
    FloatingActionButton fab;
    @BindView(R.id.fabInfo)
    FloatingActionButton fabInfo;
    @BindView(R.id.spinner)
    AppCompatSpinner mSpinner;
    @Inject
    StartPresenter startPresenter;
    @Inject
    SharedPreferencesUtils preferencesUtils;
    @Inject
    DialogsHelper dialogsHelper;
    @Inject
    Navigator navigator;
    @Inject
    Resources resources;
    @Inject
    SharedPreferencesUtils mPreferencesUtils;

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
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.start_activity);
        ButterKnife.bind(this);
        startPresenter.attachView(this);
        startPresenter.start(getIntent().hasExtra(ERROR_CODE));

        fab.setOnClickListener(view -> {
            if (Build.VERSION.SDK_INT >= 23) {
                if (!runtimePermissionsCall(null)) {
                    startPresenter.openDialogCall();
                }
            } else {
                startPresenter.openDialogCall();
            }
        });

        fabInfo.setOnClickListener(view -> {
            startPresenter.openInfoScreen();
        });

        if (BuildConfig.DEBUG) {
            mSpinner.setVisibility(View.VISIBLE);
            setupSpinner();
        } else {
            mSpinner.setVisibility(View.GONE);
        }
    }

    @Override
    protected void onDestroy() {
        startPresenter.detachView();
        super.onDestroy();
    }

    @OnClick(R.id.buttonLogin)
    public void loginClick() {
        if (getIntent().hasExtra(ERROR_CODE)) {
            navigator.openLoginByEsiaFragment();
        } else {
            startPresenter.login();
        }
//        navigator.openScreen(LoginActivity.class);
    }

    @Override
    public void showPatients(List<Patient> patientList) {
        if (getIntent().hasExtra(ERROR_CODE)) {
            loginClick();
        }
    }


    @Override
    public void savePatient() {
        startPresenter.getPatients();
    }

    @Override
    public void deletePatient() {

    }

    private void setupSpinner() {
        List<String> list = Arrays.asList(resources.getStringArray(R.array.urls));
        SpinnerAdapter adapterSpinner = new SpinnerAdapter(this, R.layout.simple_list_item, list);
        mSpinner.setAdapter(adapterSpinner);
        if (!preferencesUtils.getUrl().equals("")) {
            for (String item : list) {
                if (item.equals(preferencesUtils.getUrl())) {
                    mSpinner.setSelection(list.indexOf(item));
                    break;
                }
            }
        }
        mSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1,
                                       int arg2, long arg3) {
                if (arg2 != 0 && !(list.get(arg2).equals(preferencesUtils.getUrl()))) {
                    mPreferencesUtils.saveUrl(list.get(arg2));
                    Intent i = getBaseContext().getPackageManager()
                            .getLaunchIntentForPackage(getBaseContext().getPackageName());
                    i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP
                            | Intent.FLAG_ACTIVITY_CLEAR_TASK
                            | Intent.FLAG_ACTIVITY_NEW_TASK);

                    PendingIntent pendingIntent = PendingIntent.getActivity(EcpApplication.getInstance().getBaseContext(), 0, i, PendingIntent.FLAG_ONE_SHOT);

                    AlarmManager mgr = (AlarmManager) EcpApplication.getInstance().getBaseContext().getSystemService(Context.ALARM_SERVICE);
                    mgr.set(AlarmManager.RTC, System.currentTimeMillis() + 100, pendingIntent);

                    StartActivity.this.finish();
                    System.exit(2);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
            }
        });
    }
}
