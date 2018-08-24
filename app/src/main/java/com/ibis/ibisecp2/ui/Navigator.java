package com.ibis.ibisecp2.ui;

import android.Manifest;
import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Parcelable;
import android.provider.CalendarContract;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.ibis.ibisecp2.R;
import com.ibis.ibisecp2.model.DiaryRecord;
import com.ibis.ibisecp2.model.Schedule;
import com.ibis.ibisecp2.model.Task;
import com.ibis.ibisecp2.model.Visit;
import com.ibis.ibisecp2.notification.AlarmService;
import com.ibis.ibisecp2.ui.activity.AppointmentActivity;
import com.ibis.ibisecp2.ui.activity.DiaryPagerActivity;
import com.ibis.ibisecp2.ui.activity.InfoActivity;
import com.ibis.ibisecp2.ui.activity.LoginActivity;
import com.ibis.ibisecp2.ui.activity.MainActivity;
import com.ibis.ibisecp2.ui.activity.RegistryActivity;
import com.ibis.ibisecp2.ui.activity.RegistryPagerActivity;
import com.ibis.ibisecp2.ui.activity.TasksActivity;
import com.ibis.ibisecp2.ui.fragment.CityChooseFragment;
import com.ibis.ibisecp2.ui.fragment.ClinicChooseFragment;
import com.ibis.ibisecp2.ui.fragment.ClinicNearMeFragment;
import com.ibis.ibisecp2.ui.fragment.ConfirmSmsFragment;
import com.ibis.ibisecp2.ui.fragment.DateDialogFragment;
import com.ibis.ibisecp2.ui.fragment.DepartmentFragment;
import com.ibis.ibisecp2.ui.fragment.DiaryRecordsFragment;
import com.ibis.ibisecp2.ui.fragment.DoctorsFragment;
import com.ibis.ibisecp2.ui.fragment.EnrollFragment;
import com.ibis.ibisecp2.ui.fragment.FavoritesDoctorsFragment;
import com.ibis.ibisecp2.ui.fragment.FreeTimeFragment;
import com.ibis.ibisecp2.ui.fragment.ListPatientFragment;
import com.ibis.ibisecp2.ui.fragment.LocationFragment;
import com.ibis.ibisecp2.ui.fragment.LoginByEsiaFragment;
import com.ibis.ibisecp2.ui.fragment.LoginFragment;
import com.ibis.ibisecp2.ui.fragment.ReminderTimeFragment;
import com.ibis.ibisecp2.ui.fragment.ScheduleFragment;
import com.ibis.ibisecp2.ui.fragment.SpecialityFragment;
import com.ibis.ibisecp2.ui.fragment.TimePickerFragment;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Created by danila on 26.06.16.
 */
@Singleton
public class Navigator {
    private Activity activity;

    @Inject
    public Navigator(Activity activity) {
        this.activity = activity;
    }

    public void openAppointmentScreen(String value) {
        Intent intent = new Intent(activity, AppointmentActivity.class);
        if (value != null) {
            intent.putExtra(value, value);
        }
        activity.startActivity(intent);
        activity.overridePendingTransition(R.anim.left_in, R.anim.left_out);
    }

    public <T> void openScreen(Class<T> entityClass) {
        try {
            Intent intent = new Intent(activity, entityClass);
            intent.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP).addFlags(
                    Intent.FLAG_ACTIVITY_CLEAR_TOP);
            activity.startActivity(intent);
            activity.overridePendingTransition(R.anim.left_in, R.anim.left_out);
        } catch (ActivityNotFoundException e) {
            Toast.makeText(activity, e.getMessage(), Toast.LENGTH_LONG).show();
        }
    }

    public <T> void openScreenForResult(Class<T> entityClass, int requestCode) {
        try {
            Intent intent = new Intent(activity, entityClass);
            intent.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP).addFlags(
                    Intent.FLAG_ACTIVITY_CLEAR_TOP);
            activity.startActivityForResult(intent, requestCode);
            activity.overridePendingTransition(R.anim.left_in, R.anim.left_out);
        } catch (ActivityNotFoundException e) {
            Toast.makeText(activity, e.getMessage(), Toast.LENGTH_LONG).show();
        }
    }

    public <T> void openScreenNoHistory(Class<T> entityClass) {
        if (!(activity instanceof MainActivity)) {
            activity.finish();
        }
        try {
            Intent intent = new Intent(activity, entityClass);
            intent.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
            activity.startActivity(intent);
            activity.overridePendingTransition(R.anim.left_in, R.anim.left_out);
        } catch (ActivityNotFoundException e) {
            Toast.makeText(activity, e.getMessage(), Toast.LENGTH_LONG).show();
        }
    }

    public void openScreenInfo() {
        if (!(activity instanceof MainActivity)) {
            activity.finish();
        }
        try {
            Intent intent = new Intent(activity, InfoActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
            intent.putExtra(InfoActivity.ARG_MENU, InfoActivity.ARG_MENU);
            activity.startActivity(intent);
            activity.overridePendingTransition(R.anim.left_in, R.anim.left_out);
        } catch (ActivityNotFoundException e) {
            Toast.makeText(activity, e.getMessage(), Toast.LENGTH_LONG).show();
        }
    }

    public void openMainScreen(boolean isNew) {
        try {
            Intent intent = new Intent(activity, MainActivity.class);
            if (isNew) {
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK).addFlags(
                        Intent.FLAG_ACTIVITY_NEW_TASK);
            } else {
                intent.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP).addFlags(
                        Intent.FLAG_ACTIVITY_CLEAR_TOP);
            }
            activity.startActivity(intent);
            activity.overridePendingTransition(R.anim.left_in, R.anim.left_out);
        } catch (ActivityNotFoundException e) {
            Toast.makeText(activity, e.getMessage(), Toast.LENGTH_LONG).show();
        }
    }

    public void openDiaryActivityScreen(String value) {
        Intent intent = new Intent(activity, RegistryActivity.class);
        if (value != null) {
            intent.putExtra(value, value);
        }
        activity.startActivity(intent);
        activity.overridePendingTransition(R.anim.left_in, R.anim.left_out);
    }

    public void openPlayMarketScreen() throws ActivityNotFoundException {
        try {
            Uri uri = Uri.parse("market://details?id=" + activity.getPackageName());
            Intent goToMarket = new Intent(Intent.ACTION_VIEW, uri);
            activity.startActivity(goToMarket);
        } catch (ActivityNotFoundException e) {
            Toast.makeText(activity, e.getMessage(), Toast.LENGTH_LONG).show();
        }
    }

    public Activity getActivity() {
        return activity;
    }

    //fragment operations

    private void addFragment(android.support.v4.app.Fragment fragment, String tag) {
        getFragmentManager().beginTransaction().add(R.id.contentFrame, fragment, tag)
                .addToBackStack(tag).commit();
    }

    private void replaceFragment(android.support.v4.app.Fragment fragment, String tag) {
        getFragmentManager().beginTransaction().setCustomAnimations(R.anim.left_in, R.anim.left_out,
                R.anim.right_in, R.anim.right_out)
                .replace(R.id.contentFrame, fragment, tag).addToBackStack(tag).commit();
    }

    private void replaceFragmentWithoutBackStack(android.support.v4.app.Fragment fragment) {
        getFragmentManager().beginTransaction().setCustomAnimations(R.anim.enter_animation,
                R.anim.stay, R.anim.stay, R.anim.exit_animation).replace(R.id.contentFrame,
                fragment).commit();
    }

    private void removeFragment(android.support.v4.app.Fragment fragment) {
        getFragmentManager().beginTransaction().remove(fragment).commit();
    }

    public android.support.v4.app.Fragment getFragmentByTag(String tag) {
        return getFragmentManager().findFragmentByTag(tag);
    }

    private FragmentManager getFragmentManager() {
        AppCompatActivity activity = (AppCompatActivity) this.activity;
        return activity.getSupportFragmentManager();
    }

    public void openCityFragment() {
        CityChooseFragment fragment = new CityChooseFragment();
        replaceFragment(fragment, CityChooseFragment.TAG);
    }

    public void openClinicFragment(String cityId) {
        ClinicChooseFragment fragment = ClinicChooseFragment.newInstance(cityId);
        replaceFragment(fragment, ClinicChooseFragment.class.getSimpleName());
    }

    public void openDoctorFragment(String clinicId) {
        DepartmentFragment fragment = DepartmentFragment.newInstance(clinicId);
        replaceFragment(fragment, DepartmentFragment.TAG);
    }

    public void openDataChooseFragment(String clinicId,
                                       String depCode, String doctorId, String profCode,
                                       String positionCode, String beginDate, String speciality,
                                       String docName, String depName, String depAddress) {
        ScheduleFragment fragment;
        if (getFragmentByTag(ScheduleFragment.TAG) != null) {
            fragment = (ScheduleFragment) getFragmentByTag(ScheduleFragment.TAG);
        } else {
            fragment =
                    ScheduleFragment.newInstance(clinicId, depCode, doctorId, profCode, positionCode, beginDate,
                            speciality, docName, depName, depAddress);
        }
        replaceFragment(fragment, ScheduleFragment.TAG);
    }

    public void openFreeTimeFragment(Schedule freeTimeList) {
        FreeTimeFragment freeTimeFragment = FreeTimeFragment.newInstance(freeTimeList);
        freeTimeFragment.show(getFragmentManager(), FreeTimeFragment.TAG);
    }

    public void openEnrollFragment(String scheduleId, String time, String dateMonth,
                                   String doctorId, String type, String note) {
        EnrollFragment fragment =
                EnrollFragment.newInstance(scheduleId, dateMonth + " " + time, dateMonth, time,
                        type, note, doctorId);
        replaceFragment(fragment, EnrollFragment.TAG);
    }

    public String createDayNotificationInCalendar(Visit reminder) {
        String id = "";
        Intent intent = new Intent(Intent.ACTION_INSERT);
        intent.setType("vnd.android.cursor.item/event");
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd.MM.yyyy HH:mm");
        final String data = reminder.getStartOn() == null ? "" : reminder.getStartOn();
        final String address = reminder.getAddress() == null ? "" : reminder.getAddress();
        final String doctorName = reminder.getDoctorName() == null ? "" : reminder.getDoctorName();
        final String msg = data + "\n" + address + "\n" + doctorName;
        final String title = activity.getString(R.string.title_reception);

        try {
            Date now = simpleDateFormat.parse(data);
            long startTime = now.getTime();
            id = addReminderInCalendar(title, msg, startTime, reminder.getTime());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return id;
    }


    private String addReminderInCalendar(String title, String description, long startTime,
                                         long interval) {

        Uri EVENTS_URI = Uri.parse(getCalendarUriBase(true) + "events");
        ContentResolver cr = activity.getContentResolver();
        TimeZone timeZone = TimeZone.getDefault();

        /** Inserting an event in calendar. */
        ContentValues values = new ContentValues();
        values.put(CalendarContract.Events.CALENDAR_ID, 1);
        values.put(CalendarContract.Events.TITLE, title);
        values.put(CalendarContract.Events.DESCRIPTION, description);
        values.put(CalendarContract.Events.ALL_DAY, 0);
        // event starts at 11 minutes from now
        values.put(CalendarContract.Events.DTSTART, startTime);
        // ends 60 minutes from now
        values.put(CalendarContract.Events.DTEND, startTime);
        values.put(CalendarContract.Events.EVENT_TIMEZONE, timeZone.getID());
        values.put(CalendarContract.Events.HAS_ALARM, 1);
        Uri event = cr.insert(EVENTS_URI, values);
        // Display event id.
        Toast.makeText(activity, "Напоминание создано в календаре", Toast.LENGTH_SHORT).show();

        /** Adding reminder for event added. */
        Uri REMINDERS_URI = Uri.parse(getCalendarUriBase(true) + "reminders");
        values = new ContentValues();
        values.put(CalendarContract.Reminders.EVENT_ID, Long.parseLong(event.getLastPathSegment()));
        values.put(CalendarContract.Reminders.METHOD, CalendarContract.Reminders.METHOD_ALERT);
        values.put(CalendarContract.Reminders.MINUTES, interval);
        cr.insert(REMINDERS_URI, values);
        return event.getLastPathSegment();
    }

    /**
     * Returns Calendar Base URI, supports both new and old OS.
     */
    private String getCalendarUriBase(boolean eventUri) {
        Uri calendarURI = null;
        try {
            if (android.os.Build.VERSION.SDK_INT <= 7) {
                calendarURI = (eventUri) ? Uri.parse("content://calendar/") :
                        Uri.parse("content://calendar/calendars");
            } else {
                calendarURI = (eventUri) ? Uri.parse("content://com.android.calendar/") : Uri
                        .parse("content://com.android.calendar/calendars");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return calendarURI.toString();
    }

    public void openReminderTime(long id) {
        ReminderTimeFragment reminderTimeFragment = ReminderTimeFragment.newInstance(id);
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        reminderTimeFragment.show(ft, reminderTimeFragment.getTag());
    }

    public void showDateFragment(View v) {
        DateDialogFragment dateDialog = new DateDialogFragment(v);
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        dateDialog.show(ft, dateDialog.getTag());
    }

    public void showTimeFragment(View v) {
        TimePickerFragment dateDialog = TimePickerFragment.newInstance(v);
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        dateDialog.show(ft, dateDialog.getTag());
    }

    public void createAlarm(long id) {
        Intent alarm = new Intent(activity, AlarmService.class);
        alarm.putExtra("id", id);
        alarm.setAction(AlarmService.CREATE);
        activity.startService(alarm);
    }

    public void deleteAlarm(long id) {
        ContentResolver cr = activity.getContentResolver();
        Uri deleteUri = Uri.parse(getCalendarUriBase(true) + "events");
        deleteUri = ContentUris.withAppendedId(deleteUri, id);
        int rows = cr.delete(deleteUri, null, null);
    }


    public void addReminder(Visit visit, long interval) {

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd.MM.yyyy HH:mm");
        try {
            Date date = simpleDateFormat.parse(visit.getStartOn());

            final long min = 60000;
            final long hour = 60;
            if (interval == 0) {
                interval = hour;
            }
            long time = date.getTime() + min;//- (min * interval);
            visit.setTime(time);
            createAlarm(visit.get_id());
        } catch (ParseException e) {
            e.printStackTrace();
        }


    }

    public void openTasksScreen(List<Task> tasksList, DiaryRecordsFragment recordsFragment) {
        Intent intent = new Intent(activity, TasksActivity.class);
        if (tasksList != null) {
            intent.putParcelableArrayListExtra(TasksActivity.ARG_NAME, new ArrayList<>(tasksList));
        }
        recordsFragment.startActivityForResult(intent, 1);
        activity.overridePendingTransition(R.anim.left_in, R.anim.left_out);
    }

    public void openSpecialityFragment(String deptCode) {
        SpecialityFragment fragment = SpecialityFragment.newInstance(deptCode);
        replaceFragment(fragment, SpecialityFragment.TAG);
    }

    public void openDoctorsFragment() {
        DoctorsFragment fragment = new DoctorsFragment();
        replaceFragment(fragment, DoctorsFragment.TAG);
    }

    public void openDoctorsFragment(String positionName, String depCode) {
        DoctorsFragment fragment = DoctorsFragment.newInstance(positionName, depCode);
        replaceFragment(fragment, DoctorsFragment.TAG);
    }


    public void openDiaryFragment() {
        DiaryRecordsFragment fragment = DiaryRecordsFragment.newInstance();
        replaceFragment(fragment, DiaryRecordsFragment.TAG);
    }

    public void openConfirmSmsFragment(String login, boolean isSavePass) {
        FragmentManager fm = getFragmentManager();
        ConfirmSmsFragment confirmSmsFragment = ConfirmSmsFragment.newInstance(login, isSavePass);
        confirmSmsFragment.show(fm, ConfirmSmsFragment.class.getSimpleName());
    }

    public void openListPatientFragment() {
        FragmentManager fm = getFragmentManager();
        ListPatientFragment patientFragment = ListPatientFragment.newInstance();
        patientFragment.show(fm, ListPatientFragment.class.getSimpleName());
    }

    public void openLoginFragment(boolean isError) {
        FragmentManager fm = getFragmentManager();
        LoginFragment dialogFragment = LoginFragment.newFragment(isError);
        dialogFragment.show(fm, LoginFragment.class.getSimpleName());
    }

    public void openLoginByEsiaFragment(){
        LoginByEsiaFragment loginByEsiaFragment = LoginByEsiaFragment.newInstance();
        replaceFragment(loginByEsiaFragment, LoginByEsiaFragment.TAG);

    }

    public void openRegistryPagerActivity(Context packageContext, String caseNumber,
                                          boolean isHistory) {
        Intent intent = new Intent(packageContext, RegistryPagerActivity.class);
        intent.putExtra(RegistryPagerActivity.EXTRA_VISIT_CASE_NUMBER, caseNumber);
        intent.putExtra(RegistryPagerActivity.EXTRA_IS_HISTORY, isHistory);
        intent.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
        activity.startActivity(intent);
        activity.overridePendingTransition(R.anim.left_in, R.anim.left_out);
    }

    public void openDiaryPagerActivity(List<DiaryRecord> diaryRecordList, int position) {
        Intent intent = new Intent(activity, DiaryPagerActivity.class);
        intent.putParcelableArrayListExtra(DiaryPagerActivity.EXTRA_DIARY_LIST,
                (ArrayList<? extends Parcelable>) diaryRecordList);
        intent.putExtra(DiaryPagerActivity.EXTRA_DIARY_POSITION, position);
        intent.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
        activity.startActivity(intent);
        activity.overridePendingTransition(R.anim.left_in, R.anim.left_out);
    }

    public void openClinicNearMeFragment() {
        ClinicNearMeFragment fragment = new ClinicNearMeFragment();
        replaceFragment(fragment, ClinicNearMeFragment.TAG);
    }

    public void openLocationFragment() {
        LocationFragment fragment = new LocationFragment();
        replaceFragment(fragment, LocationFragment.TAG);
    }

    public void clearBackstack() {
        if (getFragmentManager().getBackStackEntryCount() > 0) {
            FragmentManager.BackStackEntry entry = getFragmentManager().getBackStackEntryAt(0);
            getFragmentManager().popBackStack(entry.getId(),
                    FragmentManager.POP_BACK_STACK_INCLUSIVE);
            getFragmentManager().executePendingTransactions();
        }

    }

    public void openDoctorsFavoritesScreen() {
        FavoritesDoctorsFragment fragment = new FavoritesDoctorsFragment();
        replaceFragment(fragment, FavoritesDoctorsFragment.TAG);
    }

    public void startCallIntent(String telephon) {
        try {
            Intent callIntent = new Intent(Intent.ACTION_CALL);
            callIntent.setData(Uri.parse("tel:" + telephon));
//           if(!runtimePermissions()) {
            if (ActivityCompat.checkSelfPermission(activity, Manifest.permission.CALL_PHONE)
                    != PackageManager.PERMISSION_GRANTED) {
                return;
            }
            activity.startActivity(callIntent);
//           }
        } catch (ActivityNotFoundException e) {
            Toast.makeText(activity, activity.getString(R.string.error_message_call) +
                    e.getMessage(), Toast.LENGTH_LONG).show();
        }
    }

}