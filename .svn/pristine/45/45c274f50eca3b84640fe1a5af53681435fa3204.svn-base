package com.ibis.ibisecp2.ui.activity;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.content.ContextCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.ibis.ibisecp2.R;
import com.ibis.ibisecp2.dagger.component.ActivityComponent;
import com.ibis.ibisecp2.model.Patient;
import com.ibis.ibisecp2.presenters.PersonalPresenter;
import com.ibis.ibisecp2.ui.view.PersonalView;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by danila on 11.12.15.
 */
public class PersonalActivity extends BaseActivity implements PersonalView {
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.nav_view)
    NavigationView navView;
    @BindView(R.id.drawer_layout)
    DrawerLayout drawer;
    @BindView(R.id.llPersonalInfo)
    LinearLayout llPersonalInfo;

    @Inject
    PersonalPresenter mPersonalPresenter;

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
        setContentView(R.layout.activity_personal);
        ButterKnife.bind(this);
        mPersonalPresenter.attachView(this);
        setTitle(getString(R.string.title_my_profile));
        mPersonalPresenter.getPatient();
        setupDrawer();
    }

    @Override
    protected void onResume() {
        preferencesUtils.saveItemId(R.id.nav_profile);
        super.onResume();
    }

    @Override
    protected void onDestroy() {
        mPersonalPresenter.detachView();
        super.onDestroy();
    }

    private void addItem(String nameText, String subscriptionText, Drawable iconImage) {
        View view = LayoutInflater.from(this).inflate(R.layout.item_personal, null);
        TextView name = ButterKnife.findById(view, R.id.tvName);
        TextView subscription = ButterKnife.findById(view, R.id.tvSubscription);
        ImageView icon = ButterKnife.findById(view, R.id.ivIcon);
        name.setText(nameText);
        subscription.setText(subscriptionText);
        icon.setImageDrawable(iconImage);
        llPersonalInfo.addView(view);

    }

    private void setupInfo(Patient patient) {
        if (patient != null) {
            if (patient.getFullName() != null) {
                addItem(patient.getFullName(), "Фамилия, Имя, Отчество",
                        ContextCompat.getDrawable(this, R.drawable.ic_person_black_36dp));
            }
            if (patient.getBirthDate() != null) {
                addItem(patient.getBirthDate(), "Дата рождения",
                        ContextCompat.getDrawable(this, R.drawable.select_date));
            }
            if (patient.getPhone() != null) {
                addItem(patient.getPhone(), "телефон",
                        ContextCompat.getDrawable(this, R.drawable.ic_call_black_36dp));
            }

            if (patient.getSNILS() != null) {
                addItem(patient.getSNILS(), "СНИЛС",
                        ContextCompat.getDrawable(this, R.drawable.ic_add_box_black_36dp));
            }

            if (patient.getEMail() != null) {
                addItem(patient.getEMail(), "E-mail",
                        ContextCompat.getDrawable(this, R.drawable.ic_contact_mail_black_36dp));
            }
        }
    }

    @Override
    public void showPatient(Patient patient) {
        setupInfo(patient);
    }
}
