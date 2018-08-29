package com.ibis.ibisecp2.ui.activity;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.ibis.ibisecp2.EcpApplication;
import com.ibis.ibisecp2.R;
import com.ibis.ibisecp2.dagger.HasComponent;
import com.ibis.ibisecp2.dagger.component.ActivityComponent;
import com.ibis.ibisecp2.dagger.module.ActivityModule;
import com.ibis.ibisecp2.events.LocationEvent;
import com.ibis.ibisecp2.events.LogoutEvent;
import com.ibis.ibisecp2.events.NotificationEvent;
import com.ibis.ibisecp2.helpers.DialogsHelper;
import com.ibis.ibisecp2.ui.Navigator;
import com.ibis.ibisecp2.utils.AndroidUtils;
import com.ibis.ibisecp2.utils.SharedPreferencesUtils;

import org.greenrobot.eventbus.EventBus;

import javax.inject.Inject;

/**
 * Created by danila on 08.11.15.
 */
public abstract class BaseActivity extends AppCompatActivity
        implements HasComponent<ActivityComponent>, NavigationView.OnNavigationItemSelectedListener {

    public static final int MY_PERMISSIONS_REQUEST_CALL_PHONE = 100;
    private static final int MY_PERMISSIONS_REQUEST_WRITE_CALENDAR = 101;
    private static final int MY_PERMISSIONS_REQUEST_LOCATION = 102;
    protected ActionBarDrawerToggle toggle;
    @Inject
    Navigator navigator;
    @Inject
    DialogsHelper dialogsHelper;
    @Inject
    SharedPreferencesUtils preferencesUtils;
    private ActivityComponent activityComponent;
    private DrawerLayout drawer;
    private Toolbar toolbar;
    private NavigationView navView;
    private int id;

    private String mTelephone;

    abstract void doInjections(ActivityComponent activityComponent);


    public abstract void showLoad();

    public abstract void hideLoad();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        initActivityComponent();
//        activityComponent.inject(this);
        doInjections(activityComponent);
        super.onCreate(savedInstanceState);

    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        // Sync the toggle state after onRestoreInstanceState has occurred.
        if (toggle != null) {
            toggle.syncState();
        }
    }


    private void initActivityComponent() {
        EcpApplication.getInstance().getComponent().plus(new ActivityModule(this));
        activityComponent = EcpApplication.getInstance().getComponent().plus(new ActivityModule(this));
    }

    @Override
    public void onBackPressed() {
        if (drawer != null && drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            FragmentManager fragmentManager = getSupportFragmentManager();
            int backCount = fragmentManager.getBackStackEntryCount();
            if (backCount > 1) {
                fragmentManager.popBackStack();
            } else {
                if (this.isTaskRoot()) {
                    alertExit();
                } else {
                    finish();
                    overridePendingTransition(R.anim.right_in, R.anim.right_out);
                }
            }
            hideLoad();
        }
    }

    private void alertExit() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this, R.style.MyAlertDialogStyle)
                .setMessage("Выйти из приложения?")
                .setCancelable(false)
                .setNegativeButton(android.R.string.cancel,
                        (dialog, which) -> {
                            dialog.cancel();
                        })
                .setPositiveButton(android.R.string.ok,
                        (dialog, which) -> {
                            finish();
                            overridePendingTransition(R.anim.right_in, R.anim.right_out);
                        });
        AlertDialog alertDialog = builder.create();
        dialogsHelper.setupDialogParams(alertDialog);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (toggle != null && toggle.onOptionsItemSelected(menuItem)) {
            return true;
        }
        switch (menuItem.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
        }
        return (super.onOptionsItemSelected(menuItem));
    }

    protected int getFragmentCount() {
        return getSupportFragmentManager().getBackStackEntryCount();
    }

    private Fragment getFragmentAt(int index) {
        return getFragmentCount() > 0 ? getSupportFragmentManager().findFragmentByTag(Integer.toString(index)) : null;
    }

    protected Fragment getCurrentFragment() {
        return getFragmentAt(getFragmentCount() - 1);
    }

    public void setupClinicName(TextView tvClinicChoose, LinearLayout linearLayout,
                                CharSequence charSequence) {
        if (charSequence != null) {
            linearLayout.setVisibility(View.VISIBLE);
            tvClinicChoose.setVisibility(View.VISIBLE);
            tvClinicChoose.setText(charSequence);
        } else {
            if (linearLayout != null) {
                linearLayout.setVisibility(View.GONE);
            }
        }
    }

    protected void setupToolbar(android.support.v7.widget.Toolbar toolbar) {
        toolbar.setNavigationOnClickListener((View v) -> {
            onBackPressed();
        });
        setSupportActionBar(toolbar);
    }

    protected void setupDrawer() {
        // R.id.drawer_layout should be in every activity with exactly the same id.
        id = -1;
        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        navView = (NavigationView) findViewById(R.id.nav_view);
        setupToolbar(toolbar);
        View header = getLayoutInflater().inflate(R.layout.nav_header_main, null);
//        TextView nameUser = (TextView) header.findViewById(R.id.textViewNameUser);
        navView.addHeaderView(header);
        navView.setNavigationItemSelectedListener(this);
        toggle = new ActionBarDrawerToggle(this, drawer, toolbar,
                R.string.navigation_drawer_open, R.string.navigation_drawer_close) {

            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                AndroidUtils.hideKeyboard(drawerView);
            }

            @Override
            public void onDrawerStateChanged(int newState) {
                super.onDrawerStateChanged(newState);
                setSelectedItemMenu();
                if (newState == DrawerLayout.STATE_IDLE) {
                    openScreen(id);
                    id = -1;
                }
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
            }
        };
        toggle.syncState();
        drawer.addDrawerListener(toggle);
        getSupportFragmentManager().addOnBackStackChangedListener(() -> {
            if (getSupportFragmentManager().getBackStackEntryCount() > 1) {
                getSupportActionBar().setDisplayHomeAsUpEnabled(true); // show back button
                toolbar.setNavigationOnClickListener(v -> onBackPressed());
            } else {
                //show hamburger
                getSupportActionBar().setDisplayHomeAsUpEnabled(false);
                toggle.syncState();
                toolbar.setNavigationOnClickListener(v -> {
                    drawer.openDrawer(GravityCompat.START);
                });
            }
        });
    }

    private void setSelectedItemMenu() {
        int itemId = preferencesUtils.getItemId();
        if (itemId == -1) {
            int size = navView.getMenu().size();
            for (int i = 0; i < size; i++) {
                navView.getMenu().getItem(i).setChecked(false);
            }
        } else {
            navView.setCheckedItem(itemId);
        }
    }

    @Override
    public ActivityComponent getComponent() {
        return activityComponent;
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        id = item.getItemId();
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    protected void openDrawer() {
        drawer.openDrawer(GravityCompat.START);
    }

    private void openScreen(int id) {
        switch (id) {
            case R.id.nav_appointment:
                navigator.openScreenNoHistory(AppointmentActivity.class);
                break;
            case R.id.nav_cartulary:
                navigator.openScreenNoHistory(RegistryActivity.class);
                break;
            case R.id.nav_diary:
                navigator.openScreenNoHistory(DiaryActivity.class);
                break;
            case R.id.nav_my_services:
                navigator.openScreenNoHistory(ServiceRenderedActivity.class);
                break;
            case R.id.nav_find_medicament:
                navigator.openScreenNoHistory(MedicamentFindActivity.class);
                break;
            case R.id.nav_call:
                if (Build.VERSION.SDK_INT >= 23) {
                    if (!runtimePermissionsCall(null)) {
                        dialogsHelper.createDialogCall();
                    }
                } else {
                    dialogsHelper.createDialogCall();
                }
                break;
            case R.id.nav_profile:
                navigator.openScreenNoHistory(PersonalActivity.class);
                break;
            case R.id.nav_rate:
                navigator.openPlayMarketScreen();
                break;
            case R.id.nav_setup:
                navigator.openScreenNoHistory(SetupNotificationActivity.class);
                break;
            case R.id.nav_info:
                navigator.openScreenInfo();
                break;
            case R.id.nav_exit:
                navigator.openScreen(StartActivity.class);
                EventBus.getDefault().postSticky(new LogoutEvent());
                preferencesUtils.savePatientId(-1);
                finish();
                break;
            default:
                break;
        }
    }


    public boolean runtimePermissionsCall(String tel) {
        mTelephone = tel;
        // Here, thisActivity is the current activity
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE)
                != PackageManager.PERMISSION_GRANTED) {
            // Should we show an explanation?
            if (ActivityCompat.shouldShowRequestPermissionRationale(this,
                    Manifest.permission.CALL_PHONE)) {
                dialogsHelper.alertDialogErrorMsg(getString(R.string.msg_error_permission_call));
            } else {
                // No explanation needed, we can request the permission.
                ActivityCompat.requestPermissions(this,
                        new String[]{Manifest.permission.CALL_PHONE},
                        MY_PERMISSIONS_REQUEST_CALL_PHONE);
            }
            return true;
        }
        return false;

    }

    public boolean runtimePermissionsCalendar() {
        // Here, thisActivity is the current activity
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_CALENDAR)
                != PackageManager.PERMISSION_GRANTED) {
            // Should we show an explanation?
            if (ActivityCompat.shouldShowRequestPermissionRationale(this,
                    Manifest.permission.WRITE_CALENDAR)) {
//                dialogsHelper.alertDialogErrorMsg(getString(R.string.msg_error_permission_calendar));

                AlertDialog.Builder dialogBuilder =
                        new AlertDialog.Builder(this, R.style.MyAlertDialogStyle);

                dialogBuilder.setMessage(getString(R.string.msg_error_permission_calendar));
                dialogBuilder.setCancelable(false);
                dialogBuilder.setPositiveButton(android.R.string.ok,
                        (dialog, which) -> {
                            dialog.dismiss();
                            EventBus.getDefault().postSticky(new NotificationEvent(false));
                        });
                AlertDialog alertDialog = dialogBuilder.create();
                dialogsHelper.setupDialogParams(alertDialog);

            } else {
                // No explanation needed, we can request the permission.
                ActivityCompat.requestPermissions(this,
                        new String[]{Manifest.permission.WRITE_CALENDAR},
                        MY_PERMISSIONS_REQUEST_WRITE_CALENDAR);
            }
            return true;
        }
        return false;

    }


    public boolean runtimePermissionsLocation() {
        if (ContextCompat.checkSelfPermission(this,
                Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED
                && ContextCompat.checkSelfPermission(this,
                Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {

            if (ActivityCompat.shouldShowRequestPermissionRationale(this,
                    Manifest.permission.ACCESS_COARSE_LOCATION) &&
                    ActivityCompat.shouldShowRequestPermissionRationale(this,
                            Manifest.permission.ACCESS_FINE_LOCATION)) {
                dialogsHelper.alertDialogErrorMsg(getString(R.string.msg_error_permission_location));
            } else {
                // No explanation needed, we can request the permission.
                ActivityCompat.requestPermissions(this,
                        new String[]{Manifest.permission.ACCESS_FINE_LOCATION,
                                Manifest.permission.ACCESS_COARSE_LOCATION},
                        MY_PERMISSIONS_REQUEST_LOCATION);
            }
            return true;
        }
        return false;
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        for (int i = 0, len = permissions.length; i < len; i++) {
            String permission = permissions[i];
            if (Manifest.permission.CALL_PHONE.equals(permission)) {
                if (requestCode == MY_PERMISSIONS_REQUEST_CALL_PHONE) {
                    if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                        if (mTelephone != null) {
                            navigator.startCallIntent(mTelephone);
                        } else {
                            dialogsHelper.createDialogCall();
                        }
                    } else {
                        runtimePermissionsCall(mTelephone);
                    }
                } else {
                    runtimePermissionsCall(mTelephone);
                }
                break;
            } else if (Manifest.permission.WRITE_CALENDAR.equals(permission)) {
                if (requestCode == MY_PERMISSIONS_REQUEST_WRITE_CALENDAR) {
                    if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                        EventBus.getDefault().postSticky(new NotificationEvent(true));
                    } else {
                        runtimePermissionsCalendar();
                    }
                } else {
                    runtimePermissionsCalendar();
                }
                break;
            } else if (Manifest.permission.ACCESS_COARSE_LOCATION.equals(permission) ||
                    Manifest.permission.ACCESS_FINE_LOCATION.equals(permission)) {
                if (requestCode == MY_PERMISSIONS_REQUEST_LOCATION) {
                    if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                        EventBus.getDefault().postSticky(new LocationEvent());
                    } else {
                        runtimePermissionsLocation();
                    }
                } else {
                    runtimePermissionsLocation();
                }
                break;
            }
        }
    }

    public ActionBarDrawerToggle getToggle() {
        return toggle;
    }
}
