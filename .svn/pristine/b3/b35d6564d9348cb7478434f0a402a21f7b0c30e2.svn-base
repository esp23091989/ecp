package com.ibis.ibisecp2.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.FrameLayout;

import com.ibis.ibisecp2.R;
import com.ibis.ibisecp2.dagger.component.ActivityComponent;
import com.ibis.ibisecp2.helpers.DialogsHelper;
import com.ibis.ibisecp2.presenters.DiaryEditRecordsPresenter;
import com.ibis.ibisecp2.ui.fragment.DiaryRecordsFragment;
import com.ibis.ibisecp2.ui.view.DiaryEditRecordsView;
import com.ibis.ibisecp2.utils.AndroidUtils;
import com.ibis.ibisecp2.utils.ProgressDialogUtils;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by danila on 24.11.15.
 */
public class DiaryNewRecordsActivity extends BaseActivity implements DiaryEditRecordsView {

    @Inject
    DiaryEditRecordsPresenter diaryEditRecordsPresenter;
    @Inject
    DialogsHelper dialogsHelper;
    @BindView(R.id.progress_layout)
    FrameLayout mProgressLayout;
    @BindView(R.id.editTextDiaryNewRecordContent)
    EditText mEditTextDiaryNewRecordContent;
    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    private String record;
    private String dateRecord;

    @Override
    void doInjections(ActivityComponent activityComponent) {
        activityComponent.inject(this);
    }

    @Override
    public void showLoad() {
        mProgressLayout.setVisibility(View.VISIBLE);
        mEditTextDiaryNewRecordContent.setVisibility(View.GONE);
    }

    @Override
    public void hideLoad() {
        mProgressLayout.setVisibility(View.GONE);
        mEditTextDiaryNewRecordContent.setVisibility(View.VISIBLE);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diary_new_record);
        ButterKnife.bind(this);
        diaryEditRecordsPresenter.attachView(this);
        setupDrawer();
        toggle.setDrawerIndicatorEnabled(false);
        mToolbar.setNavigationOnClickListener(v -> onBackPressed());
        toggle.syncState();
        setTitle(getString(R.string.title_add_record_diary));
        hideLoad();
        setDiaryRecordsData();
    }

    public void setDiaryRecordsData() {
        if (getIntent().hasExtra(DiaryRecordsFragment.RECORD)
                && getIntent().hasExtra(DiaryRecordsFragment.DATE_RECORD)) {
            record = getIntent().getStringExtra(DiaryRecordsFragment.RECORD);
            dateRecord = getIntent().getStringExtra(DiaryRecordsFragment.DATE_RECORD);
            mEditTextDiaryNewRecordContent.setText(record);
            mEditTextDiaryNewRecordContent.setSelection(mEditTextDiaryNewRecordContent.length());
        }
    }

    @Override
    public void onPause() {
        super.onPause();
        AndroidUtils.hideKeyboard(mEditTextDiaryNewRecordContent);
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onDestroy() {
        diaryEditRecordsPresenter.detachView();
        super.onDestroy();
    }

    public void saveRecord() {
        String record = mEditTextDiaryNewRecordContent.getText().toString().trim();
        if ("".equals(record)) {
            dialogsHelper.alertDialogErrorMsg(getString(R.string.title_diary_input_text));
        } else {
            AndroidUtils.hideKeyboard(mEditTextDiaryNewRecordContent);
            diaryEditRecordsPresenter.saveDiary(mEditTextDiaryNewRecordContent.getText().toString()
                    .trim(), dateRecord);
            showLoad();
        }
    }


    @Override
    public void successEdit(String msg) {
        ProgressDialogUtils.hideProgressDialog();
        Intent intent = new Intent();
        intent.putExtra("msg", msg);
        setResult(RESULT_OK, intent);
        finish();
    }

    @Override
    public void showError() {
        hideLoad();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.save_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.menu_save:
                saveRecord();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

}
