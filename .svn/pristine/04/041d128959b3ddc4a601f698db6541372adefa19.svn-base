package com.ibis.ibisecp2.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
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
import com.ibis.ibisecp2.presenters.RemembersPresenter;
import com.ibis.ibisecp2.ui.Navigator;
import com.ibis.ibisecp2.ui.view.RemembersView;
import com.ibis.ibisecp2.utils.SharedPreferencesUtils;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by danila on 24.11.15.
 */
public class RemembersFragment extends BaseFragment implements TicketListAdapterListener, RemembersView {

    @Inject
    RemembersPresenter remembersPresenter;
    @Inject
    SharedPreferencesUtils preferencesUtils;
    @Inject
    Navigator navigator;
    @Inject
    ShowHideLoadHelper mShowHideLoadHelper;
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

    private RecyclerView.LayoutManager mLayoutManager;
    private TicketListAdapter ticketListAdapter;
    private List<Visit> visitList = new ArrayList<>();
    private int id = -1;

    public static RemembersFragment newInstance(int id) {
        RemembersFragment fragment = new RemembersFragment();
        fragment.id = id;
        return fragment;
    }

    @Override
    void doInjection(FragmentComponent fragmentComponent) {
        fragmentComponent.inject(this);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_remembers, container, false);
        ButterKnife.bind(this, view);
        remembersPresenter.attachView(this);
        mShowHideLoadHelper.hideLoad();
        mLayoutManager = new LinearLayoutManager(getActivity());
        mRecyclerViewTickets.setLayoutManager(mLayoutManager);
        ticketListAdapter = new TicketListAdapter(getActivity(), visitList, this);
        mRecyclerViewTickets.setAdapter(ticketListAdapter);
        mSwipeTickets.setColorSchemeResources(R.color.colorAccent);
        mSwipeTickets.post(new Runnable() {
            @Override
            public void run() {
                mSwipeTickets.setRefreshing(true);
                remembersPresenter.getTickets();
            }
        });
        mSwipeTickets.setOnRefreshListener(() -> remembersPresenter.getTickets());
        return view;
    }

    private void refreshTickets(List<Visit> visitList) {
        if (visitList == null || visitList.size() == 0) {
            mTextViewDiaryTicketNo.setVisibility(View.VISIBLE);
            mRecyclerViewTickets.setVisibility(View.GONE);
        } else {
            mTextViewDiaryTicketNo.setVisibility(View.GONE);
            mRecyclerViewTickets.setVisibility(View.VISIBLE);
            ticketListAdapter.setVisitList(visitList);
            ticketListAdapter.notifyDataSetChanged();
            if (id >= 0 && id < visitList.size()) {
                onTicketClick(visitList.get(id));
            }
        }

    }

    @Override
    public void onDestroyView() {
        remembersPresenter.detachView();
        super.onDestroyView();
    }

    @Override
    public void onResume() {
        super.onResume();
        remembersPresenter.getTickets();
    }

    @Override
    public void onPause() {
        super.onPause();
    }

    @Override
    public void onTicketClick(Visit visit) {
        navigator.openRegistryPagerActivity(getActivity(), visit.getCaseNumber(), false);
    }

    @Override
    public void showTickets(List<Visit> visitList) {
        refreshTickets(visitList);
        mSwipeTickets.setRefreshing(false);
    }

    @Override
    public void hideLoad() {
        mShowHideLoadHelper.hideLoad();
        mLlError.setVisibility(View.VISIBLE);
        mSwipeTickets.setRefreshing(false);
    }

    @Override
    public void showLoad() {
        mSwipeTickets.setRefreshing(true);
        mLlError.setVisibility(View.GONE);
    }

    @Override
    public void cancelVisit() {
        remembersPresenter.getTickets();
    }

    @OnClick(R.id.btn_update)
    public void onClick() {
        remembersPresenter.getTickets();
        showLoad();
    }
}