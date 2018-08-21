package com.ibis.ibisecp2.ui.activity;

import android.support.design.widget.TabLayout;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.ibis.ibisecp2.R;
import com.ibis.ibisecp2.adapter.ViewPagerAdapter;
import com.ibis.ibisecp2.dagger.component.ActivityComponent;
import com.ibis.ibisecp2.presenters.LoginPresenter_;
import com.ibis.ibisecp2.ui.LocalLoginNavigator;
import com.ibis.ibisecp2.ui.fragment.ListPatientFragment;
import com.ibis.ibisecp2.ui.fragment.LoginByEsiaFragment;
import com.ibis.ibisecp2.ui.view.LoginView_;
import com.ibis.ibisecp2.utils.AndroidUtils;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LoginActivity extends BaseActivity implements LoginView_ {

    public static final String ERROR_CODE = "error_code";

    @Inject
    LoginPresenter_ presenter;

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    
    @BindView(R.id.viewpager)
    ViewPager viewPager;

    @BindView(R.id.tabs)
    TabLayout tabs;

    private static final int PATIENT_LIST_VP_POSITION = 1;

    private ViewPagerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        toolbar.setNavigationOnClickListener((View v) -> {
            onBackPressed();
        });
        setSupportActionBar(toolbar);
        setTitle("Вход");

        initUi();
        presenter.attachView(this);
        presenter.onStart(getIntent().hasExtra(ERROR_CODE));
    }

    private void initUi() {
        initViewPager();
    }

    private void initViewPager() {
        adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(LoginByEsiaFragment.newInstance(),
                getString(R.string.login_tab_add_new_patient));
        adapter.addFragment(new ListPatientFragment(),
                getString(R.string.login_tab_list_patients));
        viewPager.setAdapter(adapter);

        tabs.setupWithViewPager(viewPager);
        tabs.setSelectedTabIndicatorColor((ContextCompat.getColor(this, R.color.white)));

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {
                AndroidUtils.hideKeyboard(getCurrentFocus());
            }
        });
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
    public void openPatientList(boolean smoothScroll) {
        viewPager.setCurrentItem(PATIENT_LIST_VP_POSITION,smoothScroll);
    }

    @Override
    public void openMainScreen() {
        navigator.openMainScreen(true);
    }
}
