package com.ibis.ibisecp2.ui.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.ibis.ibisecp2.R;
import com.ibis.ibisecp2.dagger.component.FragmentComponent;
import com.ibis.ibisecp2.helpers.DialogsHelper;
import com.ibis.ibisecp2.helpers.ShowHideLoadHelper;
import com.ibis.ibisecp2.model.DiaryRecord;
import com.ibis.ibisecp2.presenters.DiaryRecordEditFragmentPresenter;
import com.ibis.ibisecp2.ui.activity.DiaryPagerActivity;
import com.ibis.ibisecp2.ui.view.DiaryRecordEditFragmentView;
import com.ibis.ibisecp2.utils.AndroidUtils;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by comp on 07.04.17.
 */

public class DiaryRecordEditFragment extends BaseFragment implements DiaryRecordEditFragmentView {
    public static final String ARG_DIARY_RECORD = "diary_record";

    @BindView(R.id.diary_edit_content_edit_text)
    EditText mDiaryEditContentEditText;
    Unbinder unbinder;
    @Inject
    DiaryRecordEditFragmentPresenter mPresenter;
    @Inject
    DialogsHelper dialogsHelper;
    @Inject
    ShowHideLoadHelper mShowHideLoadHelper;
    private DiaryRecord diaryRecord;

    public DiaryRecordEditFragment() {
    }

    public static DiaryRecordEditFragment newInstance(DiaryRecord diaryRecord) {
        DiaryRecordEditFragment fragment = new DiaryRecordEditFragment();
        Bundle args = new Bundle();
        args.putParcelable(ARG_DIARY_RECORD, diaryRecord);
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
        setHasOptionsMenu(true);
        diaryRecord = getArguments().getParcelable(ARG_DIARY_RECORD);
    }

    @Override
    public void onPause() {
        super.onPause();
        AndroidUtils.hideKeyboard(getView());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_diary_record_edit, container, false);
        unbinder = ButterKnife.bind(this, view);
        mPresenter.attachView(this);
        setupTitle("Редактирование записи");
        if (diaryRecord != null) {
            mDiaryEditContentEditText.setText(diaryRecord.getNote());
            mDiaryEditContentEditText.setSelection(mDiaryEditContentEditText.length());
        }
        mShowHideLoadHelper.hideLoad();
        return view;
    }

    @Override
    public void onDestroyView() {
        mPresenter.detachView();
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        // Do something that differs the Activity's menu here
        inflater.inflate(R.menu.edit_record_menu, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_save:
                saveRecord();
                return true;
            case R.id.menu_delete:
                cancelRecord();
                return true;
            default:
                break;
        }

        return false;
    }

    private void saveRecord() {
        String record = mDiaryEditContentEditText.getText().toString().trim();
        if ("".equals(record)) {
            dialogsHelper.alertDialogErrorMsg(getString(R.string.title_diary_input_text));
        } else {
            diaryRecord.setNote(mDiaryEditContentEditText.getText().toString()
                    .trim());
            AndroidUtils.hideKeyboard(mDiaryEditContentEditText);
            mPresenter.saveDiary(diaryRecord.getNote(), diaryRecord.getDate());
            mShowHideLoadHelper.showLoad();
        }
    }

    private void cancelRecord() {
        diaryRecord.setNote("");
        mPresenter.saveDiary("", diaryRecord.getDate());
        mShowHideLoadHelper.showLoad();
    }

    @Override
    public void successEdit(String msg) {
        dialogsHelper.alertDialogErrorMsg(msg);
        mShowHideLoadHelper.hideLoad();
        ((DiaryPagerActivity) getActivity()).updateList(diaryRecord);
    }

    @Override
    public void showError() {
        mShowHideLoadHelper.hideLoad();
    }
}
