package com.ibis.ibisecp2.ui.fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.ScrollView;
import android.widget.TextView;

import com.ibis.ibisecp2.R;
import com.ibis.ibisecp2.dagger.component.FragmentComponent;
import com.ibis.ibisecp2.events.CancelVisit;
import com.ibis.ibisecp2.model.Patient;
import com.ibis.ibisecp2.model.Visit;
import com.ibis.ibisecp2.presenters.VisitPresenter;
import com.ibis.ibisecp2.ui.view.VisitView;
import com.ibis.ibisecp2.utils.SharedPreferencesUtils;
import com.ibis.ibisecp2.utils.TextUtils;

import org.greenrobot.eventbus.EventBus;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

public class VisitFragment extends BaseFragment implements VisitView {
    private static final String ARG_CASE_NUMBER = "caseNumber";
    private static final String ARG_IS_HISTORY = "isHistory";
    @BindView(R.id.diaryTicketNumTitleTextView)
    TextView mDiaryTicketNumTitleTextView;
    @BindView(R.id.tvDiaryTicketMo)
    TextView mTvDiaryTicketMo;
    @BindView(R.id.diaryTicketAdressMoTextView)
    TextView mDiaryTicketAdressMoTextView;
    @BindView(R.id.diaryTicketSpecialityTextView)
    TextView mDiaryTicketSpecialityTextView;
    @BindView(R.id.diaryTicketDoctorFullNameTextView)
    TextView mDiaryTicketDoctorFullNameTextView;
    @BindView(R.id.diaryTicketDateTextView)
    TextView mDiaryTicketDateTextView;
    @BindView(R.id.diaryFioPatientTextView)
    TextView mDiaryFioPatientTextView;
    @BindView(R.id.tvSource)
    TextView mTvSource;
    @BindView(R.id.tvStatus)
    TextView mTvStatus;
    @BindView(R.id.diaryTicketViewLayout)
    LinearLayout mDiaryTicketViewLayout;
    @BindView(R.id.deleteDiaryTicketButton)
    Button mDeleteDiaryTicketButton;
    @BindView(R.id.diaryTicketLayout)
    ScrollView mDiaryTicketLayout;
    @Inject
    VisitPresenter mVisitPresenter;
    @Inject
    SharedPreferencesUtils preferencesUtils;

    Unbinder unbinder;
    @BindView(R.id.fv_progress_bar)
    ProgressBar mFvProgressBar;
    private String caseNumber;
    private boolean isHistory;
    int i = 0;

    public VisitFragment() {
        // Required empty public constructor
    }

    public static VisitFragment newInstance(String caseNumber, boolean isHistory) {
        VisitFragment fragment = new VisitFragment();
        Bundle args = new Bundle();
        args.putString(ARG_CASE_NUMBER, caseNumber);
        args.putBoolean(ARG_IS_HISTORY, isHistory);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    void doInjection(FragmentComponent fragmentComponent) {
        fragmentComponent.inject(this);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        caseNumber = (String) getArguments().getSerializable(ARG_CASE_NUMBER);
        isHistory = (boolean) getArguments().getSerializable(ARG_IS_HISTORY);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_visit, container, false);
        mVisitPresenter.attachView(this);
        unbinder = ButterKnife.bind(this, view);
        mVisitPresenter.getVisit(caseNumber, isHistory);
        mDeleteDiaryTicketButton.setVisibility(isHistory ? View.GONE : View.VISIBLE);
        mDiaryTicketLayout.setVisibility(View.GONE);
        showLoad();
        setupTitle("Просмотр записи");
        return view;
    }

    private void showLoad() {
        mDiaryTicketLayout.setVisibility(View.GONE);
        mFvProgressBar.setVisibility(View.VISIBLE);
    }


    @Override
    public void showVisit(Visit visit) {
        i++;
        Log.d("----------------", visit.getClinicName() + "      " + i);
        if (isHistory) {
            mDeleteDiaryTicketButton.setVisibility(View.GONE);
        } else {
            mDeleteDiaryTicketButton.setVisibility(View.VISIBLE);

            if (visit.getSource().equalsIgnoreCase(getString(R.string.txt_mo))) {
                mDeleteDiaryTicketButton.setVisibility(View.GONE);
            } else if (visit.getSource().equalsIgnoreCase(getString(R.string.txt_fer))) {
                mDeleteDiaryTicketButton.setVisibility(View.GONE);
            } else if (visit.getSource().equalsIgnoreCase(getString(R.string.txt_cite_mo))) {
                mDeleteDiaryTicketButton.setVisibility(View.GONE);
            } else if (visit.getSource().equalsIgnoreCase(getString(R.string.txt_terminal))) {
                mDeleteDiaryTicketButton.setVisibility(View.GONE);
            }
        }
        setTicketData(visit);
    }

    @Override
    public void hideLoad() {
        mDiaryTicketLayout.setVisibility(View.VISIBLE);
        mFvProgressBar.setVisibility(View.GONE);
    }

    @Override
    public void cancelVisit() {
        hideLoad();
        EventBus.getDefault().postSticky(new CancelVisit());
        getActivity().finish();
    }

    @Override
    public void showPatient(Patient patient) {
        mDiaryFioPatientTextView.setText(TextUtils.spanBoldText("Пациент:",
                String.format("%s, %sг.р.", patient.getFullName(),
                        patient.getBirthDate()), getActivity()));
    }

    public void setTicketData(Visit currentVisit) {
        mDiaryTicketLayout.setVisibility(View.VISIBLE);
        hideLoad();
        mDiaryTicketNumTitleTextView.setText("ТАЛОН № " + currentVisit.getCaseNumber());

        mDiaryTicketDateTextView.setText(TextUtils.spanBoldText("Дата и время приема:",
                currentVisit.getStartOn() == null ? "" : currentVisit.getStartOn(), getActivity()));

        mDiaryTicketSpecialityTextView.setText(TextUtils.spanBoldText("Должность врача:",
                currentVisit.getSpecialityName() == null ? "" : currentVisit.getSpecialityName()
                , getActivity()));
        mDiaryTicketDoctorFullNameTextView.setText(TextUtils.spanBoldText("ФИО врача:",
                currentVisit.getDoctorName() == null ? "" : currentVisit.getDoctorName(), getActivity()));
        mDiaryTicketAdressMoTextView.setText(TextUtils.spanBoldText("Адрес МО:",
                currentVisit.getAddress() == null ? "" : currentVisit.getAddress(), getActivity()));

        mTvDiaryTicketMo.setText(TextUtils.spanBoldText("МО:",
                currentVisit.getClinicName() == null ? "" : currentVisit.getClinicName(), getActivity()));

        mTvSource.setText(TextUtils.spanBoldText("Источник записи:",
                currentVisit.getSource() == null ? "" : currentVisit.getSource(), getActivity()));

        mTvStatus.setText(TextUtils.spanBoldText("Статус записи:",
                currentVisit.getStatus() == null ? "" : currentVisit.getStatus(), getActivity()));

    }

    @Override
    public void onDestroyView() {
        mVisitPresenter.detachView();
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick(R.id.deleteDiaryTicketButton)
    public void onClick() {
        mDiaryTicketLayout.setVisibility(View.GONE);
        showLoad();
        mVisitPresenter.cancelVisit();
    }
}
