package com.ibis.ibisecp2.ui.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.ibis.ibisecp2.R;
import com.ibis.ibisecp2.adapter.DiaryRecordAdapter;
import com.ibis.ibisecp2.dagger.component.FragmentComponent;
import com.ibis.ibisecp2.events.UpdateDiaryEvent;
import com.ibis.ibisecp2.helpers.DialogsHelper;
import com.ibis.ibisecp2.helpers.ShowHideLoadHelper;
import com.ibis.ibisecp2.listeners.OnPositionAdapterListener;
import com.ibis.ibisecp2.model.DiaryRecord;
import com.ibis.ibisecp2.model.Task;
import com.ibis.ibisecp2.presenters.DiaryRecordPresenter;
import com.ibis.ibisecp2.ui.Navigator;
import com.ibis.ibisecp2.ui.activity.DiaryNewRecordsActivity;
import com.ibis.ibisecp2.ui.view.DiaryRecordView;
import com.ibis.ibisecp2.utils.SharedPreferencesUtils;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static android.app.Activity.RESULT_OK;

/**
 * Created by danila on 24.11.15.
 */
public class DiaryRecordsFragment extends BaseFragment implements DiaryRecordView,
        OnPositionAdapterListener {

    public final static String DATE_RECORD = "recordDate";
    public final static String TAG = DiaryRecordsFragment.class.getSimpleName();
    public final static String RECORD = "record";
    public static final int PAGE_SIZE = 2;
    @Inject
    SharedPreferencesUtils preferencesUtils;
    @BindView(R.id.btn_update)
    Button btnUpdate;
    @BindView(R.id.diaryNoDataTitleTextView)
    TextView diaryNoDataTitleTextView;
    @BindView(R.id.rvDiary)
    RecyclerView rvDiary;
    @BindView(R.id.diarysLayout)
    RelativeLayout diarysLayout;
    @BindView(R.id.buttonAddNewDiaryRecord)
    FloatingActionButton mFloatingActionButton;
    @BindView(R.id.swipe_refresh)
    SwipeRefreshLayout swipeRefresh;
    @Inject
    DiaryRecordPresenter diaryRecordPresenter;
    @Inject
    DialogsHelper dialogsHelper;
    @Inject
    Navigator navigator;
    @Inject
    ShowHideLoadHelper mShowHideLoadHelper;
    private boolean isLoading = false;
    private DiaryRecordAdapter adapter;
    private LinearLayoutManager mLayoutManager;
    final RecyclerView.OnScrollListener onScrollListener = new RecyclerView.OnScrollListener() {
        @Override
        public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
            int visibleItemCount = mLayoutManager.getChildCount();
            int totalItemCount = mLayoutManager.getItemCount();
            int firstVisibleItemPosition = mLayoutManager.findFirstVisibleItemPosition();

            if (!isLoading) {
                if ((visibleItemCount + firstVisibleItemPosition) >= totalItemCount
                        && firstVisibleItemPosition >= 0
                        && totalItemCount >= PAGE_SIZE) {
                    adapter.loadMore();
                    swipeRefresh.setRefreshing(true);
                    diaryRecordPresenter.getDiaryRecords(String.valueOf(totalItemCount));
                    isLoading = true;
                }
            }
        }

    };
    private List<DiaryRecord> diaryRecordList = new ArrayList<>();

    public static DiaryRecordsFragment newInstance() {
        DiaryRecordsFragment fragment = new DiaryRecordsFragment();
        return fragment;
    }

    @Override
    void doInjection(FragmentComponent fragmentComponent) {
        fragmentComponent.inject(this);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_diary_records, container, false);
        ButterKnife.bind(this, view);
        diaryRecordPresenter.attachView(this);
        mLayoutManager = new LinearLayoutManager(getActivity());
        rvDiary.setLayoutManager(mLayoutManager);
        rvDiary.addOnScrollListener(onScrollListener);
        swipeRefresh.setColorSchemeResources(R.color.colorAccent);
        adapter = new DiaryRecordAdapter(getActivity(), diaryRecordList, this);
        rvDiary.setAdapter(adapter);
        swipeRefresh.setOnRefreshListener(() -> updateRecords());
        swipeRefresh.post(() -> {
            updateRecords();
        });

        rvDiary.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                if (dy > 0) {
                    mFloatingActionButton.setVisibility(View.GONE);
                } else if (dy < 0) {
                    mFloatingActionButton.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
            }
        });
        mShowHideLoadHelper.hideLoad();
        return view;
    }

    public void updateRecords() {
        swipeRefresh.setRefreshing(true);
        diaryRecordPresenter.getDiaryRecords(String.valueOf(0));
    }

    private void setupDiaryRecords(final List<DiaryRecord> diaryRecordList) {
        mFloatingActionButton.setVisibility(View.VISIBLE);
        if (diaryRecordList == null || diaryRecordList.size() == 0) {
            rvDiary.setVisibility(View.GONE);
            diaryNoDataTitleTextView.setVisibility(View.VISIBLE);
        } else {
            rvDiary.setVisibility(View.VISIBLE);
            diaryNoDataTitleTextView.setVisibility(View.GONE);

            if (adapter == null) {
                adapter = new DiaryRecordAdapter(getActivity(), diaryRecordList, this);

                rvDiary.setAdapter(adapter);
            } else {
                adapter.setDiaryRecordList(diaryRecordList);
                adapter.notifyDataSetChanged();
            }
        }
    }

    @Override
    public void showDiaryRecords(List<DiaryRecord> diaryRecordList, List<Task> tasksList, boolean isLoading) {
        this.diaryRecordList = diaryRecordList;
        this.isLoading = !isLoading;
        btnUpdate.setVisibility(View.GONE);
        swipeRefresh.setRefreshing(false);
        setupDiaryRecords(diaryRecordList);
        setHasOptionsMenu(tasksList != null && tasksList.size() > 0);
    }

    @Override
    public void showLoad() {
        swipeRefresh.setRefreshing(true);
    }

    @Override
    public void showError() {
        swipeRefresh.setRefreshing(false);
        btnUpdate.setVisibility(View.VISIBLE);
    }

    @Override
    public void onDestroyView() {
        diaryRecordPresenter.detachView();
        super.onDestroyView();
        if (EventBus.getDefault().isRegistered(this)) {
            EventBus.getDefault().unregister(this);
        }
    }

    @OnClick(R.id.buttonAddNewDiaryRecord)
    public void addNewDiaryRecord() {
        Intent intent = new Intent(getActivity(), DiaryNewRecordsActivity.class);
        this.startActivityForResult(intent, 1);
        getActivity().overridePendingTransition(R.anim.left_in, R.anim.left_out);
    }

    @Override
    public void onStart() {
        super.onStart();
        if (!EventBus.getDefault().isRegistered(this)) {
            EventBus.getDefault().register(this);
        }
    }

    @Override
    public void onPause() {
        super.onPause();
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.add_menu, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.menu_add:
                diaryRecordPresenter.openTasksScreen(this);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @OnClick(R.id.btn_update)
    public void onUpdate() {
        updateRecords();
        btnUpdate.setVisibility(View.GONE);
    }

    @Subscribe(sticky = true)
    public void onUpdateDiaryEvent(UpdateDiaryEvent event) {
        EventBus.getDefault().removeStickyEvent(event);
        updateDiary(event);
    }

    private void updateDiary(UpdateDiaryEvent event) {
        if (!event.getDiaryRecord().getNote().equals("")) {
            diaryRecordList.set(event.getPosition(), event.getDiaryRecord());
            adapter.notifyItemChanged(event.getPosition());
        } else {
            diaryRecordList.remove(event.getPosition());
            adapter.notifyItemRemoved(event.getPosition());
        }
    }

    @Override
    public void onClick(int position) {
        navigator.openDiaryPagerActivity(diaryRecordList, position);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            Bundle bundle = data.getExtras();
            String msg = bundle.getString("msg");
            if (msg != null) {
                dialogsHelper.alertDialogErrorMsg(msg);
            }
            updateRecords();
        }
    }

}

