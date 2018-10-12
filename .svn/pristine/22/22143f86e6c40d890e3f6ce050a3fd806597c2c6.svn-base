package com.ibis.ibisecp2.ui.fragment;


import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ibis.ibisecp2.R;
import com.ibis.ibisecp2.adapter.FavoritesDoctorsAdapter;
import com.ibis.ibisecp2.dagger.component.FragmentComponent;
import com.ibis.ibisecp2.helpers.DialogsHelper;
import com.ibis.ibisecp2.helpers.ShowHideLoadHelper;
import com.ibis.ibisecp2.listeners.OnItemAdapterListener;
import com.ibis.ibisecp2.model.FavoriteDoctor;
import com.ibis.ibisecp2.presenters.FavoritesDoctorsPresenter;
import com.ibis.ibisecp2.ui.Navigator;
import com.ibis.ibisecp2.ui.view.FavoritesDoctorsView;
import com.ibis.ibisecp2.utils.SharedPreferencesUtils;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class FavoritesDoctorsFragment extends BaseFragment implements FavoritesDoctorsView,
        OnItemAdapterListener {
    public final static String TAG = FavoritesDoctorsFragment.class.getSimpleName();
    @Inject
    FavoritesDoctorsPresenter mPresenter;
    @Inject
    ShowHideLoadHelper mHelper;
    @Inject
    Navigator navigator;
    @Inject
    SharedPreferencesUtils preferencesUtils;
    @Inject
    DialogsHelper dialogsHelper;
    @Inject
    ShowHideLoadHelper mShowHideLoadHelper;

    @BindView(R.id.fragment_favorites_doctors_recycler_view)
    RecyclerView mRecyclerView;
    Unbinder unbinder;
    @BindView(R.id.fragment_favorites_doctors_text_view)
    TextView mEmptyTextView;


    private FavoritesDoctorsAdapter mAdapter;
    private Paint p = new Paint();

    public FavoritesDoctorsFragment() {
        // Required empty public constructor
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

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_favorites_doctors, container, false);
        mPresenter.attachView(this);
        mPresenter.getDoctors();
        mHelper.showLoad();
        unbinder = ButterKnife.bind(this, view);
        mEmptyTextView.setVisibility(View.GONE);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mAdapter = new FavoritesDoctorsAdapter(getActivity(), new ArrayList<>(), this);
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setHasFixedSize(true);
        setupTitle("Избранные врачи");
        initSwipe();
        return view;
    }

    private void initSwipe() {
        ItemTouchHelper.SimpleCallback simpleItemTouchCallback =
                new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {

                    @Override
                    public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder,
                                          RecyclerView.ViewHolder target) {
                        return false;
                    }

                    @Override
                    public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {
                        int position = viewHolder.getAdapterPosition();

                        if (direction == ItemTouchHelper.LEFT || direction == ItemTouchHelper.RIGHT) {
                            deleteAlertDialog(position);
                        }
                    }

                    @Override
                    public void onChildDraw(Canvas c, RecyclerView recyclerView,
                                            RecyclerView.ViewHolder viewHolder, float dX, float dY,
                                            int actionState, boolean isCurrentlyActive) {

                        Bitmap icon;
                        if (actionState == ItemTouchHelper.ACTION_STATE_SWIPE) {

                            View itemView = viewHolder.itemView;
                            float height = (float) itemView.getBottom() - (float) itemView.getTop();
                            float width = height / 3;

                            if (dX > 0) {
                                p.setColor(Color.parseColor("#B6B6B6"));
                                RectF background = new RectF((float) itemView.getLeft(), (float) itemView.getTop(), dX, (float) itemView.getBottom());
                                c.drawRect(background, p);
                                icon = BitmapFactory.decodeResource(getResources(), R.drawable.ic_delete_black);
                                RectF icon_dest = new RectF((float) itemView.getLeft() + width, (float) itemView.getTop() + width, (float) itemView.getLeft() + 2 * width, (float) itemView.getBottom() - width);
                                c.drawBitmap(icon, null, icon_dest, p);
                            } else {
                                p.setColor(Color.parseColor("#B6B6B6"));
                                RectF background = new RectF((float) itemView.getRight() + dX, (float) itemView.getTop(), (float) itemView.getRight(), (float) itemView.getBottom());
                                c.drawRect(background, p);
                                icon = BitmapFactory.decodeResource(getResources(), R.drawable.ic_delete_black);
                                RectF icon_dest = new RectF((float) itemView.getRight() - 2 * width, (float) itemView.getTop() + width, (float) itemView.getRight() - width, (float) itemView.getBottom() - width);
                                c.drawBitmap(icon, null, icon_dest, p);
                            }

                        }
                        super.onChildDraw(c, recyclerView, viewHolder, dX, dY, actionState, isCurrentlyActive);
                    }
                };
        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(simpleItemTouchCallback);
        itemTouchHelper.attachToRecyclerView(mRecyclerView);
    }

    private void deleteAlertDialog(int currentAdapterPosition) {
        AlertDialog.Builder
                builder = new AlertDialog.Builder(getActivity(), R.style.MyAlertDialogStyle)
                .setMessage("Удалить врача?")
                .setCancelable(false)
                .setNegativeButton(android.R.string.cancel,
                        (dialog, which) -> {
                            mAdapter.notifyDataSetChanged();
                            dialog.cancel();
                        })
                .setPositiveButton(android.R.string.ok,
                        (dialog, which) -> {
                            mShowHideLoadHelper.showLoad();
                            mPresenter.deleteDoctor(mAdapter.getItems().get(currentAdapterPosition));
                            mAdapter.removeItem(currentAdapterPosition);
                            mEmptyTextView.setVisibility(mAdapter.getItemCount() == 0 ? View.VISIBLE : View.GONE);
                        });
        AlertDialog alertDialog = builder.create();
        dialogsHelper.setupDialogParams(alertDialog);

    }

    @Override
    public void onDestroyView() {
        mPresenter.detachView();
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public void showFavorites(List<FavoriteDoctor> favoriteDoctors) {
        if (favoriteDoctors == null || favoriteDoctors.isEmpty()) {
            mEmptyTextView.setVisibility(View.VISIBLE);
        } else {
            mEmptyTextView.setVisibility(View.GONE);
        }
        mHelper.hideLoad();
        mAdapter.setItems(favoriteDoctors);
    }

    @Override
    public void successDelete() {
        mShowHideLoadHelper.hideLoad();
    }

    @Override
    public <T> void onItemClick(T t) {
        navigator.openDataChooseFragment(((FavoriteDoctor) t).getClinicId(),
                ((FavoriteDoctor) t).getDeptCode(),
                ((FavoriteDoctor) t).getSnils(),
                ((FavoriteDoctor) t).getProfCode(),
                ((FavoriteDoctor) t).getPositionCode(),
                ((FavoriteDoctor) t).getNearestDateFavoritDoctor(),
                ((FavoriteDoctor) t).getPositionName(),
                ((FavoriteDoctor) t).getSpecialityName(),
                ((FavoriteDoctor) t).getDeptName(),
                ((FavoriteDoctor) t).getDeptAddress());
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        // Do something that differs the Activity's menu here
        inflater.inflate(R.menu.menu_choose, menu);
        MenuItem searchItem = menu.findItem(R.id.action_search);
        SearchView mSearchView = (SearchView) searchItem.getActionView();
        mSearchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                if (mAdapter != null) {
                    mAdapter.getFilter().filter(newText);
                }
                return false;
            }
        });
        mSearchView.setQueryHint(getString(R.string.title_search_department));
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
                break;
            default:
                break;
        }

        return false;
    }
}
