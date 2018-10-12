package com.ibis.ibisecp2.ui.activity;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.AppCompatSpinner;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.CheckBox;

import com.ibis.ibisecp2.R;
import com.ibis.ibisecp2.adapter.SpinnerAdapter;
import com.ibis.ibisecp2.dagger.component.ActivityComponent;
import com.ibis.ibisecp2.utils.SharedPreferencesUtils;

import java.util.Arrays;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SetupNotificationActivity extends BaseActivity {

    @BindView(R.id.spinnerReminderTime)
    AppCompatSpinner spinner;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @Inject
    Resources resources;
    @Inject
    SharedPreferencesUtils preferencesUtils;
    @BindView(R.id.nav_view)
    NavigationView navView;
    @BindView(R.id.drawer_layout)
    DrawerLayout drawer;
    @BindView(R.id.chbOnNotification)
    CheckBox chbOnNotification;

    private long[] timeMin = {15, 30, 45, 60, 120, 180, 12 * 60, 24 * 60, 48 * 60, 7 * 24 * 60};

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
        setContentView(R.layout.activity_setup_reminder);
        ButterKnife.bind(this);
        setTitle("Настройки уведомлений");
        setupDrawer();
        chbOnNotification.setChecked(!preferencesUtils.getNotification());
        if (chbOnNotification.isChecked()) {
            setupReminderValue();
        } else {
            spinner.setVisibility(View.GONE);
        }
    }

    @Override
    protected void onResume() {
        preferencesUtils.saveItemId(R.id.nav_setup);
        super.onResume();
    }

    private void setupReminderValue() {
        List<String> list = Arrays.asList(resources.getStringArray(R.array.reminder_time));
        SpinnerAdapter adapterSpinner = new SpinnerAdapter(this, R.layout.simple_list_item, list);
        spinner.setAdapter(adapterSpinner);

        if (preferencesUtils.getReminderValue() != null) {
            for (String item : list) {
                if (item.equals(preferencesUtils.getReminderValue())) {
                    spinner.setSelection(list.indexOf(item));
                    break;
                }
            }
        } else {
            /** 3 - position 1 hour*/
            spinner.setSelection(3);
        }

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1,
                                       int arg2, long arg3) {
                preferencesUtils.saveReminder(timeMin[arg2]);
                preferencesUtils.saveReminderValue(list.get(arg2));
            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
            }
        });
    }

    @OnClick(R.id.chbOnNotification)
    public void onClick() {
        preferencesUtils.onNotification(!chbOnNotification.isChecked());
        if (chbOnNotification.isChecked()) {
            spinner.setVisibility(View.VISIBLE);
            setupReminderValue();
        } else {
            spinner.setVisibility(View.GONE);
        }
    }
}
