package com.ibis.ibisecp2.ui.fragment;

import android.app.Dialog;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.TextView;

import com.ibis.ibisecp2.R;
import com.ibis.ibisecp2.adapter.PatientAdapter;
import com.ibis.ibisecp2.events.ErrorChildEvent;
import com.ibis.ibisecp2.helpers.DialogsHelper;
import com.ibis.ibisecp2.listeners.PatientAdapterListener;
import com.ibis.ibisecp2.model.Patient;
import com.ibis.ibisecp2.presenters.ListPatientPresenter;
import com.ibis.ibisecp2.ui.activity.BaseActivity;
import com.ibis.ibisecp2.ui.view.ListPatientView;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by danila on 10.06.16.
 */
public class ListPatientFragment extends DialogFragment implements PatientAdapterListener,
        ListPatientView {

    @BindView(R.id.recyclerViewPatients)
    RecyclerView rvPatients;

    @Inject
    ListPatientPresenter presenter;
    @Inject
    DialogsHelper dialogsHelper;
    @BindView(R.id.tvNoPatients)
    TextView tvNoPatients;

    private PatientAdapter patientAdapter;
    private Paint p = new Paint();

    public static ListPatientFragment newInstance() {
        ListPatientFragment fragment = new ListPatientFragment();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_list_patient, container, false);
        getDialog().getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        getDialog().getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        getDialog().setCanceledOnTouchOutside(false);
        ButterKnife.bind(this, rootView);
        BaseActivity activity = (BaseActivity) getActivity();
        activity.getComponent().plusFragmentComponent().inject(this);
        presenter.attachView(this);
        presenter.getPatientList();
        patientAdapter = new PatientAdapter(getActivity(), new ArrayList<>(), this);
        rvPatients.setLayoutManager(new LinearLayoutManager(getActivity()));
        rvPatients.setAdapter(patientAdapter);
        initSwipe();
        return rootView;
    }

    @Override
    public void onStart() {
        super.onStart();
        Dialog dialog = getDialog();
        if (dialog != null && dialog.getWindow() != null) {
            dialog.getWindow().setLayout(ViewGroup.LayoutParams.WRAP_CONTENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT);
        }

        if (!EventBus.getDefault().isRegistered(this)) {
            EventBus.getDefault().register(this);
        }
    }

    @Override
    public void onDestroyView() {
        presenter.detachView();
        super.onDestroyView();
        if (EventBus.getDefault().isRegistered(this)) {
            EventBus.getDefault().unregister(this);
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
    public void onPatientClick(Patient patient) {
        patient.setHasPass(true);
        presenter.onPatientClick(patient);
        dismiss();
    }

    @OnClick(R.id.btnAddPatient)
    public void onClick() {
        presenter.newPatientLogin();
        dismiss();
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
        itemTouchHelper.attachToRecyclerView(rvPatients);
    }

    private void deleteAlertDialog(int currentAdapterPosition) {
        AlertDialog.Builder
                builder = new AlertDialog.Builder(getActivity(), R.style.MyAlertDialogStyle)
                .setMessage("Удалить пользователя?")
                .setCancelable(false)
                .setNegativeButton(android.R.string.cancel,
                        (dialog, which) -> {
                            patientAdapter.notifyDataSetChanged();
                            dialog.cancel();
                        })
                .setPositiveButton(android.R.string.ok,
                        (dialog, which) -> {
                            presenter.deletePatient(patientAdapter.getPatientList()
                                    .get(currentAdapterPosition));
                            patientAdapter.removeItem(currentAdapterPosition);
                        });
        AlertDialog alertDialog = builder.create();
        dialogsHelper.setupDialogParams(alertDialog);

    }

    @Override
    public void showListPatient(List<Patient> patientList) {
        if (patientList != null && patientList.size() > 0) {
            patientAdapter.setPatientList(patientList);
            tvNoPatients.setVisibility(View.GONE);
        } else {
            tvNoPatients.setVisibility(View.VISIBLE);
        }
    }

    @Subscribe(sticky = true)
    public void onErrorChildEvent(ErrorChildEvent event) {
        EventBus.getDefault().removeStickyEvent(event);
        dialogsHelper.alertDialogErrorMsg(event.getError());
    }
}
