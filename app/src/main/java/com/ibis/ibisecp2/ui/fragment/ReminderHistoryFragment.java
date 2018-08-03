package com.ibis.ibisecp2.ui.fragment;


import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.ibis.ibisecp2.R;
import com.ibis.ibisecp2.adapter.TicketListAdapter;
import com.ibis.ibisecp2.dagger.component.FragmentComponent;
import com.ibis.ibisecp2.helpers.ShowHideLoadHelper;
import com.ibis.ibisecp2.listeners.TicketListAdapterListener;
import com.ibis.ibisecp2.model.Visit;
import com.ibis.ibisecp2.presenters.HistoryPresenter;
import com.ibis.ibisecp2.ui.Navigator;
import com.ibis.ibisecp2.ui.view.HistoryView;
import com.ibis.ibisecp2.utils.SharedPreferencesUtils;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * A simple {@link BaseFragment} subclass.
 */
public class ReminderHistoryFragment extends BaseFragment implements HistoryView, TicketListAdapterListener {


    @BindView(R.id.tv_no_data)
    TextView mTvNoData;
    @BindView(R.id.btn_update)
    Button mBtnUpdate;
    @BindView(R.id.ll_error)
    LinearLayout mLlError;
    @BindView(R.id.textViewDiaryTicketNo)
    TextView mTextViewDiaryTicketNo;
    @BindView(R.id.recyclerViewTickets)
    RecyclerView mRecyclerViewTickets;
    @BindView(R.id.swipe_tickets)
    SwipeRefreshLayout mSwipeTickets;

    @Inject
    Navigator navigator;
    @Inject
    HistoryPresenter historyPresenter;
    @Inject
    SharedPreferencesUtils preferencesUtils;
    @Inject
    ShowHideLoadHelper mShowHideLoadHelper;

    private LinearLayoutManager mLayoutManager;
    private boolean isLoad = true;

    public ReminderHistoryFragment() {
        // Required empty public constructor
    }

    @Override
    void doInjection(FragmentComponent fragmentComponent) {
        fragmentComponent.inject(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_remembers, container, false);
        ButterKnife.bind(this, view);
        historyPresenter.attachView(this);
//        historyPresenter.loadHistory(isLoad);
        mSwipeTickets.setColorSchemeResources(R.color.colorAccent);
        mSwipeTickets.post(new Runnable() {
            @Override
            public void run() {
                mSwipeTickets.setRefreshing(true);
                historyPresenter.loadHistory(isLoad);
            }
        });
        isLoad = false;
        mLayoutManager = new LinearLayoutManager(getActivity());
        mRecyclerViewTickets.setLayoutManager(mLayoutManager);
        mSwipeTickets.setOnRefreshListener(() -> {
            mSwipeTickets.setRefreshing(true);
            historyPresenter.loadHistory(true);
        });
        return view;
    }

    @Override
    public void showHistory(List<Visit> visitList) {
        mSwipeTickets.setRefreshing(false);
        if (visitList != null && visitList.size() == 0) {
            mTextViewDiaryTicketNo.setVisibility(View.VISIBLE);
            mRecyclerViewTickets.setVisibility(View.GONE);
        } else {
            mTextViewDiaryTicketNo.setVisibility(View.GONE);
            mRecyclerViewTickets.setVisibility(View.VISIBLE);
        }
        mShowHideLoadHelper.hideLoad();
        TicketListAdapter ticketListAdapter = new TicketListAdapter(getActivity(), visitList, this);
        mRecyclerViewTickets.setAdapter(ticketListAdapter);
    }

    @Override
    public void errorLoad() {
        mLlError.setVisibility(View.VISIBLE);
        mShowHideLoadHelper.hideLoad();
    }

    @Override
    public void showLoad() {
        mLlError.setVisibility(View.GONE);
        mShowHideLoadHelper.showLoad();
    }

    @Override
    public void cancelVisit() {
        historyPresenter.loadHistory(true);
    }

    @Override
    public void onTicketClick(Visit visit) {
        navigator.openRegistryPagerActivity(getActivity(), visit.getCaseNumber(), true);
    }

    @OnClick(R.id.btn_update)
    public void onClick() {
        historyPresenter.loadHistory(true);
        showLoad();
    }

    @Override
    public void onDestroyView() {
        historyPresenter.detachView();
        super.onDestroyView();
    }
}
