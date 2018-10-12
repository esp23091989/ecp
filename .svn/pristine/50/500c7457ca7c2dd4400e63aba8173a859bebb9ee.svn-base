package com.ibis.ibisecp2.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.ibis.ibisecp2.R;
import com.ibis.ibisecp2.adapter.ServiceRenderAdapter;
import com.ibis.ibisecp2.dagger.component.FragmentComponent;
import com.ibis.ibisecp2.helpers.ShowHideLoadHelper;
import com.ibis.ibisecp2.model.Sluch;
import com.ibis.ibisecp2.model.UslList;
import com.ibis.ibisecp2.presenters.ServiceRenderedPresenter;
import com.ibis.ibisecp2.ui.view.ServiceRenderedView;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by danila on 28.06.16.
 */
public class ServiceRenderedFragment extends BaseFragment implements ServiceRenderedView {


    @Inject
    ServiceRenderedPresenter serviceRenderedPresenter;
    @BindView(R.id.tvPeriod)
    TextView tvPeriod;
    @BindView(R.id.tvDiaryDateEnd)
    TextView tvDiaryDateEnd;
    @BindView(R.id.tvDiaryDateStart)
    TextView tvDiaryDateStart;
    @BindView(R.id.test)
    CardView test;
    @BindView(R.id.tvEndDateSluch)
    TextView tvEndDateSluch;
    @BindView(R.id.tvSluch)
    TextView tvSluch;
    @BindView(R.id.tvCostSluch)
    TextView tvCostSluch;
    @BindView(R.id.llGroupHeader)
    LinearLayout llGroupHeader;
    @BindView(R.id.tvNoDataService)
    TextView tvNoDataService;
    @BindView(R.id.expLvService)
    ExpandableListView expLvService;

    @Inject
    ShowHideLoadHelper mShowHideLoadHelper;

    private ServiceRenderAdapter serviceRenderAdapter;


    @Override
    public void onStart() {
        super.onStart();
        tvDiaryDateStart.setOnClickListener(v -> showDateFragment(v));
        tvDiaryDateEnd.setOnClickListener(v -> showDateFragment(v));
    }

    private void showDateFragment(View v) {
        DateDialog dateDialog = new DateDialog(v);
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        dateDialog.show(ft, dateDialog.getTag());
    }

    @Override
    void doInjection(FragmentComponent fragmentComponent) {
        fragmentComponent.inject(this);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_service_rendered, container, false);
        ButterKnife.bind(this, view);
        serviceRenderedPresenter.attachView(this);
        llGroupHeader.setVisibility(View.GONE);
        mShowHideLoadHelper.hideLoad();
        Date currentDate = new Date();
        Format formatterDate = new SimpleDateFormat("dd.MM.yyyy");
        tvDiaryDateEnd.setText(formatterDate.format(currentDate));
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(currentDate);
        calendar.add(Calendar.DATE, -30);
        tvDiaryDateStart.setText(formatterDate.format(calendar.getTime()));

        return view;
    }

    private void setupParamMu(String lpuName, String sMo, String enp) {
//        llClinicChoose.setVisibility(View.VISIBLE);
//        if (lpuName != null) {
//            tvClinicChoose.setText("МО прикрепления пациента: " + lpuName);
//        }
//        if (sMo != null) {
//            tvClinicChoose.append("\n" + "СМО страхования пациента: " + sMo);
//        }
//        if (enp != null) {
//            tvClinicChoose.append("\n" + "Единый номер полиса (ЕНП): " + enp);
//        }
    }

    @Override
    public void onDestroyView() {
        serviceRenderedPresenter.detachView();
        super.onDestroyView();
    }

    @Override
    public void showService(List<Sluch> headerList, HashMap<Sluch, List<UslList>> childLis) {
        mShowHideLoadHelper.hideLoad();
        setHasOptionsMenu(true);
        tvDiaryDateStart.setEnabled(true);
        tvDiaryDateEnd.setEnabled(true);
        if (headerList.size() == 0) {
            llGroupHeader.setVisibility(View.GONE);
            tvNoDataService.setVisibility(View.VISIBLE);
        } else {
            serviceRenderAdapter = new ServiceRenderAdapter(getActivity(), headerList, childLis);
            expLvService.setAdapter(serviceRenderAdapter);
            llGroupHeader.setVisibility(View.VISIBLE);
            expLvService.setVisibility(View.VISIBLE);
            tvNoDataService.setVisibility(View.GONE);
        }
    }

    @Override
    public void showParamMu(String lpuName, String sMo, String enp) {
        setupParamMu(lpuName, sMo, enp);
    }

    @Override
    public void showError() {
        setHasOptionsMenu(true);
        tvDiaryDateStart.setEnabled(true);
        tvDiaryDateEnd.setEnabled(true);
        mShowHideLoadHelper.hideLoad();
    }

    public void update() {
        serviceRenderedPresenter.getServiceRendered(tvDiaryDateStart.getText().toString(),
                tvDiaryDateEnd.getText().toString());
        mShowHideLoadHelper.showLoad();
        tvDiaryDateStart.setEnabled(false);
        tvDiaryDateEnd.setEnabled(false);
        setHasOptionsMenu(false);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        // Do something that differs the Activity's menu here
        inflater.inflate(R.menu.menu_update, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_update:
                update();
                break;
            default:
                break;
        }

        return false;
    }
}
