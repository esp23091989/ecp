package com.ibis.ibisecp2.ui.activity;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.ibis.ibisecp2.R;
import com.ibis.ibisecp2.adapter.MedicamentFindAdapter;
import com.ibis.ibisecp2.dagger.component.ActivityComponent;
import com.ibis.ibisecp2.helpers.DialogsHelper;
import com.ibis.ibisecp2.listeners.ShowDosageListener;
import com.ibis.ibisecp2.model.Medicament;
import com.ibis.ibisecp2.presenters.MedicamentFindPresenter;
import com.ibis.ibisecp2.ui.view.MedicamentFindView;
import com.ibis.ibisecp2.utils.AndroidUtils;
import com.ibis.ibisecp2.utils.SharedPreferencesUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by danila on 24.11.15.
 */
public class MedicamentFindActivity extends BaseActivity implements MedicamentFindView, ShowDosageListener {

    @BindView(R.id.byPriceTitleTitleTextView)
    TextView byPriceTitleTitleTextView;
    @BindView(R.id.downButton)
    ImageButton downButton;
    @BindView(R.id.separatorTitleTextView)
    TextView separatorTitleTextView;
    @BindView(R.id.upButton)
    ImageButton upButton;
    @BindView(R.id.bracketTitleTextView)
    TextView bracketTitleTextView;
    @BindView(R.id.rvServices)
    RecyclerView rvServices;
    @BindView(R.id.resultLayout)
    RelativeLayout resultLayout;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @Inject
    MedicamentFindPresenter medicamentFindPresenter;
    @Inject
    SharedPreferencesUtils preferencesUtils;
    @Inject
    DialogsHelper dialogsHelper;
    @BindView(R.id.tv_info_medicament)
    TextView tvInfoMedicament;
    @BindView(R.id.rl_info)
    RelativeLayout rlInfo;
    @BindView(R.id.nav_view)
    NavigationView navView;
    @BindView(R.id.drawer_layout)
    DrawerLayout drawer;
    Comparator<Medicament> medicamentServicesComparatorUp = (o1, o2) -> {
        if (o1.getPrice() == o2.getPrice())
            return o1.getName().compareTo(o2.getName());
        return Double.compare(o1.getPrice(), o2.getPrice());
    };
    Comparator<Medicament> medicamentServicesComparatorDown = (o1, o2) -> {
        if (o2.getPrice() == o1.getPrice())
            return o2.getName().compareTo(o1.getName());
        return Double.compare(o2.getPrice(), o1.getPrice());
    };
    @BindView(R.id.progress_layout)
    FrameLayout mProgressLayout;
    private List<Medicament> medicamentList;
    private MedicamentFindAdapter adapter;
    private LinearLayoutManager mLayoutManager;
    private SearchView mSearchView;
    SearchView.OnQueryTextListener listener = new SearchView.OnQueryTextListener() {
        @Override
        public boolean onQueryTextSubmit(String query) {
            medicamentFindPresenter.findMedicament(query);
            resultLayout.setVisibility(View.GONE);
            showLoad();
            rlInfo.setVisibility(View.GONE);
            mSearchView.clearFocus();
            AndroidUtils.hideKeyboard(getCurrentFocus());
            return false;
        }

        @Override
        public boolean onQueryTextChange(String newText) {
            // newText is text entered by user to SearchView
            return false;
        }
    };

    @Override
    void doInjections(ActivityComponent activityComponent) {
        activityComponent.inject(this);
    }

    @Override
    public void showLoad() {
        mProgressLayout.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoad() {
        mProgressLayout.setVisibility(View.GONE);

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medicament_find);
        ButterKnife.bind(this);
        medicamentFindPresenter.attachView(this);
        setTitle(getString(R.string.title_medicament_find));
        setupDrawer();
        setTitle(R.string.title_medicament_find);
        mLayoutManager = new LinearLayoutManager(this);
        rvServices.setLayoutManager(mLayoutManager);
        resultLayout.setVisibility(View.GONE);
        rlInfo.setVisibility(View.VISIBLE);
        hideLoad();
    }

    @OnClick(R.id.downButton)
    public void downButtonClick() {
        if (medicamentList != null && medicamentList.size() > 0) {
            upButton.setImageResource(R.drawable.up_arrow);
            downButton.setImageResource(R.drawable.down_arrow_selected);
            Collections.sort(medicamentList, medicamentServicesComparatorDown);
            updateAdapter();
        }

    }

    @OnClick(R.id.upButton)
    public void upButtonClick() {
        if (medicamentList != null && medicamentList.size() > 0) {
            upButton.setImageResource(R.drawable.up_arrow_selected);
            downButton.setImageResource(R.drawable.down_arrow);
            Collections.sort(medicamentList, medicamentServicesComparatorUp);
            updateAdapter();
        }

    }

    public void updateAdapter() {
        adapter.setMedicamentList(medicamentList);
        adapter.notifyDataSetChanged();
    }

    @Override
    protected void onDestroy() {
        medicamentFindPresenter.detachView();
        super.onDestroy();
    }

    @Override
    public void onPause() {
        super.onPause();
        AndroidUtils.hideKeyboard(getCurrentFocus());
    }

    @Override
    public void onResume() {
        preferencesUtils.saveItemId(R.id.nav_find_medicament);
        super.onResume();
    }

    @Override
    public void showMedicament(List<Medicament> medicamentList) {
        rlInfo.setVisibility(View.GONE);
        hideLoad();
        resultLayout.setVisibility(View.VISIBLE);
        this.medicamentList = medicamentList;
        if (this.medicamentList == null) {
            this.medicamentList = new ArrayList<>();
        }
        int count = this.medicamentList.size();
        String find = "Найдено: ";
        if (count == 100) {
            find = "Первые ";
        }
        String results =
                this.getResources().getQuantityString(R.plurals.plurals_medicament, count, count);
        byPriceTitleTitleTextView.setText(find + results);
        if (this.medicamentList.size() != 0) {
            if (adapter == null) {
                adapter = new MedicamentFindAdapter(this, this.medicamentList, this);
                rvServices.setAdapter(adapter);
            } else {
                updateAdapter();
            }
            rvServices.setVisibility(View.VISIBLE);
        } else {
            rvServices.setVisibility(View.GONE);
        }

    }

    @Override
    public void error() {
        resultLayout.setVisibility(View.VISIBLE);
        hideLoad();
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_find_medicament, menu);
        MenuItem searchItem = menu.findItem(R.id.action_search);
        mSearchView = (SearchView) searchItem.getActionView();
        setupSearchView();
        return super.onCreateOptionsMenu(menu);
    }

    private void setupSearchView() {
        mSearchView.setOnQueryTextListener(listener);
        mSearchView.setIconified(false);
        mSearchView.setQueryHint("Поиск препарата");
    }

    @Override
    public void showDosage(String traidName, String dosage) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this, R.style.MyAlertDialogStyle);
        builder.setMessage(dosage)
                .setCancelable(false)
                .setPositiveButton(android.R.string.ok,
                        (dialog, id) -> {
                            dialog.cancel();
                        });
        AlertDialog alertDialog = builder.create();
        dialogsHelper.setupDialogParams(alertDialog);
    }

    @Override
    public void find(String findName) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this, R.style.MyAlertDialogStyle);
        builder.setMessage("Найти \"" + findName + "\"?")
                .setCancelable(false)
                .setPositiveButton(android.R.string.ok,
                        (dialog, id) -> {
                            if (mSearchView != null) {
                                mSearchView.setQuery(findName, true);
                            }
                        })
                .setNegativeButton(android.R.string.cancel,
                        (dialog, id) -> {
                            dialog.cancel();
                        });
        AlertDialog alertDialog = builder.create();
        dialogsHelper.setupDialogParams(alertDialog);
    }
}

