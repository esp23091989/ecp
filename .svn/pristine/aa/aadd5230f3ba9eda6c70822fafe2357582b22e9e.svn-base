package com.ibis.ibisecp2.ui.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.ibis.ibisecp2.R;
import com.ibis.ibisecp2.dagger.component.FragmentComponent;
import com.ibis.ibisecp2.events.NotificationEvent;
import com.ibis.ibisecp2.helpers.DialogsHelper;
import com.ibis.ibisecp2.helpers.ShowHideLoadHelper;
import com.ibis.ibisecp2.listeners.EnrollHelperListener;
import com.ibis.ibisecp2.model.Doctor;
import com.ibis.ibisecp2.model.FavoriteDoctor;
import com.ibis.ibisecp2.presenters.CreateVisitPresenter;
import com.ibis.ibisecp2.service.FavoritesDoctorsService;
import com.ibis.ibisecp2.ui.Navigator;
import com.ibis.ibisecp2.ui.activity.AppointmentActivity;
import com.ibis.ibisecp2.ui.activity.StartActivity;
import com.ibis.ibisecp2.ui.view.EnrollView;
import com.ibis.ibisecp2.utils.ProgressDialogUtils;
import com.ibis.ibisecp2.utils.SharedPreferencesUtils;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.ibis.ibisecp2.service.FavoritesDoctorsService.EXTRA_DOCTOR;

/**
 * This screen for enroll to the doctor
 */
public class EnrollFragment extends BaseFragment implements EnrollHelperListener, EnrollView {

    public static final String TAG = EnrollFragment.class.getSimpleName();

    @BindView(R.id.textViewApproveClinic)
    TextView textViewApproveClinic;
    @BindView(R.id.textViewApproveClinicName)
    TextView textViewApproveClinicName;
    @BindView(R.id.textViewApproveDoctorTitle)
    TextView textViewApproveDoctorTitle;
    @BindView(R.id.textViewApproveDoctorName)
    TextView textViewApproveDoctorName;
    @BindView(R.id.textViewApproveDateTitle)
    TextView textViewApproveDateTitle;
    @BindView(R.id.textViewApproveDate)
    TextView textViewApproveDate;
    @BindView(R.id.textViewApproveTimeTitle)
    TextView textViewApproveTimeTitle;
    @BindView(R.id.textViewApproveTime)
    TextView textViewApproveTime;
    @BindView(R.id.buttonOkApprove)
    Button buttonOkApprove;
    @BindView(R.id.buttonCancelApprove)
    Button buttonCancelApprove;
    @BindView(R.id.tvDepName)
    TextView tvDepName;
    @BindView(R.id.tvSpecName)
    TextView tvSpecName;
    @BindView(R.id.tvSlotTypeTitle)
    TextView tvSlotTypeTitle;
    @BindView(R.id.tvSlotType)
    TextView tvSlotType;
    @BindView(R.id.tvNoteTitle)
    TextView tvNoteTitle;
    @BindView(R.id.tvNote)
    TextView tvNote;
    @BindView(R.id.svAppointmentApprove)
    ScrollView svAppointmentApprove;
    @Inject
    CreateVisitPresenter createVisitPresenter;
    @Inject
    SharedPreferencesUtils preferencesUtils;
    @Inject
    Navigator navigator;
    @Inject
    DialogsHelper dialogsHelper;
    @Inject
    ShowHideLoadHelper mShowHideLoadHelper;

    private Context context;
    private String scheduleId;
    private String date;
    private String dateMonth;
    private String time;
    private String type;
    private String note;
    private String doctorId;
    private FavoriteDoctor mFavoriteDoctor;
    private Doctor mDoctor;


    public EnrollFragment() {
    }

    public static EnrollFragment newInstance(String scheduleId, String date, String dateMonth,
                                             String time, String type, String note, String doctorId) {
        EnrollFragment fragment = new EnrollFragment();
        fragment.scheduleId = scheduleId;
        fragment.date = date;
        fragment.dateMonth = dateMonth;
        fragment.time = time;
        fragment.type = type;
        fragment.note = note;
        fragment.doctorId = doctorId;
        return fragment;
    }

    @Override
    void doInjection(FragmentComponent fragmentComponent) {
        fragmentComponent.inject(this);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_enroll, container, false);
        ButterKnife.bind(this, view);
        createVisitPresenter.attachView(this);
        context = getActivity();
        try {
            createVisitPresenter.getDoctorById(Long.parseLong(doctorId));
            mShowHideLoadHelper.showLoad();
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        SimpleDateFormat fmt = new SimpleDateFormat("dd.MM.yyyy", new Locale("ru", "RU"));
        if (dateMonth != null) {
            Date date;
            try {
                date = fmt.parse(dateMonth);
                SimpleDateFormat fmtOut = new SimpleDateFormat("dd MMMM yyyy, EEEE", new Locale("ru", "RU"));
                textViewApproveDate.setText(fmtOut.format(date));
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        textViewApproveTime.setText(time);
        setupTitle(getString(R.string.title_appointment));
        setupNote();
        setupType();
        return view;
    }

    private void setupNote() {
        if (note != null && !(note.equals(""))) {
            tvNote.setText(note);
            tvNote.setVisibility(View.VISIBLE);
            tvNoteTitle.setVisibility(View.VISIBLE);
        } else {
            tvNote.setVisibility(View.GONE);
            tvNoteTitle.setVisibility(View.GONE);
        }
    }

    private void setupType() {
        if (type != null && !(type.equals(""))) {
            tvSlotType.setText(type);
            tvSlotType.setVisibility(View.VISIBLE);
            tvSlotTypeTitle.setVisibility(View.VISIBLE);
        } else {
            tvSlotType.setVisibility(View.GONE);
            tvSlotTypeTitle.setVisibility(View.GONE);
        }
    }

    @Override
    public void onSuccessEnroll() {
        createVisitPresenter.openMainScreen();
        ProgressDialogUtils.hideProgressDialog();
        Toast.makeText(context,
                "Запись выполнена", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onErrorEnroll(int code) {
        if (code == -2) {
            openMainScreen();
        }
        ProgressDialogUtils.hideProgressDialog();
    }


    @Override
    public void onStart() {
        super.onStart();
        if (!EventBus.getDefault().isRegistered(this)) {
            EventBus.getDefault().register(this);
        }
    }

    @Override
    public void onDestroyView() {
        createVisitPresenter.detachView();
        super.onDestroyView();
        if (EventBus.getDefault().isRegistered(this)) {
            EventBus.getDefault().unregister(this);
        }
    }


    @Override
    public void enroll() {
        mShowHideLoadHelper.hideLoad();
        svAppointmentApprove.setVisibility(View.VISIBLE);
        createVisitPresenter.getDoctorById(Long.parseLong(doctorId));
        Toast.makeText(context, "Запись выполнена", Toast.LENGTH_SHORT).show();
        if (!preferencesUtils.getNotification()) {
            createAlertDialog();
        } else {
            navigator.clearBackstack();
            navigator.openDoctorFragment(preferencesUtils.getClinicId());
        }
    }

    private void saveFavoriteDoctor() {
        if (mDoctor != null) {
            Intent intent = new Intent(getActivity(), FavoritesDoctorsService.class);
            intent.putExtra(EXTRA_DOCTOR, new FavoriteDoctor(
                    textViewApproveClinicName.getText().toString(), preferencesUtils.getClinicId(),
                    mDoctor.getDeptCode(), mDoctor.getSnils(), mDoctor.getProfCode(),
                    mDoctor.getPositionCode(), mDoctor.getNearestDate(), mDoctor.getPositionName(),
                    mDoctor.getSpecialityName(), mDoctor.getDeptName(), mDoctor.getDeptAddress()));
            getActivity().startService(intent);
        }
    }

    @Override
    public void showError(String msg) {
        mShowHideLoadHelper.hideLoad();
        svAppointmentApprove.setVisibility(View.VISIBLE);
        Toast.makeText(context, msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showError() {
        mShowHideLoadHelper.hideLoad();
        svAppointmentApprove.setVisibility(View.VISIBLE);
    }

    @Override
    public void createNotification() {
        navigator.clearBackstack();
        navigator.openDoctorFragment(preferencesUtils.getClinicId());
    }

    @Override
    public void onChangePassword(String msg) {
        Toast.makeText(context, msg, Toast.LENGTH_SHORT).show();
        openMainScreen();

    }

    private void openMainScreen() {
        Intent intent = new Intent(getActivity(), StartActivity.class);
        intent.putExtra(StartActivity.ERROR_CODE, StartActivity.ERROR_CODE);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
        getActivity().overridePendingTransition(R.anim.left_in, R.anim.left_out);
    }

    @Override
    public void showFavoriteDoctor(FavoriteDoctor doctor) {
        mShowHideLoadHelper.hideLoad();
        if (doctor == null) return;
        textViewApproveDoctorName.setText(doctor.getSpecialityName());
        String depAddress = doctor.getDeptAddress() == null ? "" : doctor.getDeptAddress();
        tvDepName.setText(doctor.getDeptName() + "\n" + depAddress);
        tvSpecName.setText(doctor.getPositionName());
        this.mFavoriteDoctor = doctor;
        if (doctor.getClinic() != null) {
            textViewApproveClinicName.setText(doctor.getClinic());
        }
    }

    @Override
    public void showDoctor(Doctor doctor) {
        mShowHideLoadHelper.hideLoad();
        if (doctor == null) return;
        textViewApproveDoctorName.setText(doctor.getSpecialityName());
        String depAddress = doctor.getDeptAddress() == null ? "" : doctor.getDeptAddress();
        tvDepName.setText(doctor.getDeptName() + "\n" + depAddress);
        tvSpecName.setText(doctor.getPositionName());
        this.mDoctor = doctor;
    }

    @Override
    public void showClinicInfo(String clinicInfo) {
        textViewApproveClinicName.setText(clinicInfo);
    }

    @OnClick(R.id.buttonCancelApprove)
    public void cancelApprove() {
        getFragmentManager().popBackStack();
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
    }

    @OnClick(R.id.buttonOkApprove)
    public void onClick() {
        /**
         * save favorite doctor
         * */
        saveFavoriteDoctor();
        mShowHideLoadHelper.showLoad();
        svAppointmentApprove.setVisibility(View.GONE);
        if (mDoctor != null) {
            createVisitPresenter.createVisit(scheduleId, mDoctor.getSpecialityName(),
                    mDoctor.getPositionName(), date);
        } else if (mFavoriteDoctor != null) {
            createVisitPresenter.createVisit(scheduleId, mFavoriteDoctor.getSpecialityName(),
                    mFavoriteDoctor.getPositionName(), date);
        }
    }


    private void createAlertDialog() {
        AlertDialog.Builder builder =
                new AlertDialog.Builder(getActivity(), R.style.MyAlertDialogStyle);
        builder.setTitle("Напоминание на \n" + getDateReminder())
                .setMessage("Создать напоминание в календаре?\nПри необходимости, Вы можете изменить" +
                        " дату и время напоминания в календаре.")
                .setCancelable(false)
                .setPositiveButton(android.R.string.ok,
                        (dialog, id) -> {
                            dialog.cancel();
                            if (Build.VERSION.SDK_INT >= 23) {
                                if (!((AppointmentActivity) getActivity()).runtimePermissionsCalendar()) {
                                    createVisitPresenter.createNotification();
                                }
                            } else {
                                createVisitPresenter.createNotification();
                            }
                        })
                .setNegativeButton(android.R.string.cancel,
                        (dialog, id) -> {
                            dialog.cancel();
                            navigator.clearBackstack();
                            navigator.openDoctorFragment(preferencesUtils.getClinicId());
                        });
        AlertDialog alertDialog = builder.create();
        dialogsHelper.setupDialogParams(alertDialog);
    }

    private String getDateReminder() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd.MM.yyyy HH:mm");

        String dateReminder = "";
        try {
            Date dateStartOn = simpleDateFormat.parse(date);
            final long min = 60000;
            final long sixty = 60;
            long interval = preferencesUtils.getReminder();
            if (interval == 0) {
                interval = sixty;
            }
            long time = dateStartOn.getTime() - (min * interval);
            dateStartOn.setTime(time);
            dateReminder = simpleDateFormat.format(dateStartOn);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return dateReminder;
    }


    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        // Do something that differs the Activity's menu here
        inflater.inflate(R.menu.menu_choose, menu);
        MenuItem searchItem = menu.findItem(R.id.action_search);
        searchItem.setVisible(false);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_hospital:
                navigator.clearBackstack();
                navigator.openClinicFragment(preferencesUtils.getCityId());
                break;
            case R.id.menu_city:
                navigator.clearBackstack();
                navigator.openCityFragment();
                break;
            case R.id.menu_doctor:
                navigator.clearBackstack();
                navigator.openDoctorsFragment();
                break;
            case R.id.menu_hospital_near_me:
                navigator.clearBackstack();
                navigator.openClinicNearMeFragment();
                break;
            case R.id.menu_doctor_favorites:
                navigator.clearBackstack();
                navigator.openDoctorsFavoritesScreen();
                break;
            default:
                break;
        }

        return false;
    }

    @Subscribe(sticky = true)
    public void onNotificationEvent(NotificationEvent event) {
        EventBus.getDefault().removeStickyEvent(event);
        if (Build.VERSION.SDK_INT >= 23) {
            if (event.isCreateNotification()) {
                createVisitPresenter.createNotification();
            } else {
                createNotification();
            }
        }
    }
}
