package com.ibis.ibisecp2.ui.activity;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatSpinner;
import android.support.v7.widget.LinearLayoutCompat;
import android.support.v7.widget.Toolbar;
import android.text.InputFilter;
import android.text.Spanned;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.ibis.ibisecp2.R;
import com.ibis.ibisecp2.adapter.SpinnerAdapter;
import com.ibis.ibisecp2.dagger.component.ActivityComponent;
import com.ibis.ibisecp2.helpers.DialogsHelper;
import com.ibis.ibisecp2.helpers.ProgressDialogHelper;
import com.ibis.ibisecp2.model.Task;
import com.ibis.ibisecp2.presenters.DiaryEditRecordsPresenter;
import com.ibis.ibisecp2.ui.view.DiaryEditRecordsView;
import com.ibis.ibisecp2.utils.AndroidUtils;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class TasksActivity extends BaseActivity implements DiaryEditRecordsView {
    public static final String ARG_NAME = "listTasks";

    @BindView(R.id.ll_command)
    RelativeLayout llCommand;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.ll_commands)
    LinearLayout llCommandsContainer;

    @BindView(R.id.spinner_type_command)
    AppCompatSpinner spinner;
    @Inject
    DiaryEditRecordsPresenter presenter;
    @Inject
    DialogsHelper dialogsHelper;
    @Inject
    ProgressDialogHelper progressDialogHelper;
    /**
     * запрет ввода символов: ';' , '='  для поля параметра
     */

    InputFilter filter = new InputFilter() {
        public CharSequence filter(CharSequence source, int start, int end,
                                   Spanned dest, int dstart, int dend) {
            for (int i = start; i < end; i++) {
                if (';' == source.charAt(i) || '=' == source.charAt(i)) {
                    return "";
                }
            }
            return null;
        }
    };
    private SpinnerAdapter spinnerAdapter;
    private String command;
    private String help;
    private EditText editTextView;

    @Override
    void doInjections(ActivityComponent activityComponent) {
        activityComponent.inject(this);
    }

    @Override
    public void showLoad() {

    }

    @Override
    public void hideLoad() {

    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_command);
        ButterKnife.bind(this);
        presenter.attachView(this);
        setTitle("Создание задачи");
        setupToolbar(toolbar);
        setupSpinnerCommand();
        addFieldForInputParam();
    }

    private void setupSpinnerCommand() {
        if (getIntent().hasExtra(ARG_NAME)) {
            List<Task> tasksList = getIntent().getParcelableArrayListExtra(ARG_NAME);
            List<String> tasksListString = new ArrayList<>();
            for (Task task : tasksList) {
                tasksListString.add(task.getKey());
            }
            spinnerAdapter = new SpinnerAdapter(this, R.layout.simple_list_item, tasksListString);
            spinner.setAdapter(spinnerAdapter);
//            if (preferencesUtils.getReminderValue() != null) {
//                for (String item : list) {
//                    if (item.equals(preferencesUtils.getReminderValue())) {
//                        spinner.setSelection(list.indexOf(item));
//                        break;
//                    }
//                }
//            }

            spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> arg0, View arg1,
                                           int arg2, long arg3) {
                    help = tasksList.get(arg2).getValue();
                    command = tasksList.get(arg2).getKey();
                }

                @Override
                public void onNothingSelected(AdapterView<?> arg0) {
                }
            });
        }
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
                presenter.saveDiary(generateTask(), null);
                progressDialogHelper.showDialog();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void addFieldForInputParam() {
        if (allFieldFilling()) {
            editTextView = new EditText(this);
            editTextView.setFilters(new InputFilter[]{filter});
            editTextView.setMaxLines(1);
            editTextView.setSingleLine();
            editTextView.requestFocus();
            editTextView.setCompoundDrawablesWithIntrinsicBounds(0, 0,
                    android.R.drawable.ic_menu_close_clear_cancel, 0);
            setDrawableCancelListener(editTextView);
            editTextView.setMinHeight(AndroidUtils.pxToDp(48));
            LinearLayoutCompat.LayoutParams params =
                    new LinearLayoutCompat.LayoutParams(LinearLayoutCompat.LayoutParams.MATCH_PARENT,
                            LinearLayoutCompat.LayoutParams.WRAP_CONTENT, 0);
            params.setMargins(0, 0, 16, 0);
            editTextView.setLayoutParams(params);
            llCommandsContainer.addView(editTextView);
        } else {
            dialogsHelper.alertDialogErrorMsg("Перед добавлением нового параметра, " +
                    "заполните предыдущие");
        }
    }

    private void setDrawableCancelListener(final EditText editText) {
        View.OnTouchListener onTouchListener = (v, event) -> {
            final int DRAWABLE_RIGHT = 2;
            if (event.getAction() == MotionEvent.ACTION_UP) {
                if (editText.getCompoundDrawables()[DRAWABLE_RIGHT] != null
                        && event.getRawX() >= (editText.getRight() -
                        editText.getCompoundDrawables()[DRAWABLE_RIGHT].getBounds().width())) {
                    AndroidUtils.hideKeyboard(editText);
                    llCommandsContainer.removeView(editText);
                    return true;
                }
            }
            return false;
        };
        editText.setOnTouchListener(onTouchListener);
    }

    private String generateTask() {
        String params = "";
        for (int i = 0; i < llCommandsContainer.getChildCount(); i++) {
            View view = llCommandsContainer.getChildAt(i);
            if (view instanceof EditText) {
                final String text = ((EditText) view).getText().toString();
                if (text.length() > 0) {
                    params = params + text + ";";

                }
            }
        }


        return command + "=" + params;
    }

    private boolean allFieldFilling() {
        boolean flag = true;
        for (int i = 0; i < llCommandsContainer.getChildCount(); i++) {
            View view = llCommandsContainer.getChildAt(i);
            if (view instanceof EditText) {
                if (((EditText) view).getText().length() == 0) {
                    flag = false;
                }
            }
        }
        return flag;
    }

    @Override
    protected void onPause() {
        AndroidUtils.hideKeyboard(getCurrentFocus());
        super.onPause();
    }

    @Override
    protected void onDestroy() {
        presenter.detachView();
        super.onDestroy();
    }

    @OnClick(R.id.btn_add_commands)
    public void onClick() {
        addFieldForInputParam();
    }

    @Override
    public void successEdit(String msg) {
        Intent intent = new Intent();
        intent.putExtra("msg", msg);
        setResult(RESULT_OK, intent);
        finish();
        progressDialogHelper.hideDialog();
    }

    @Override
    public void showError() {
        progressDialogHelper.hideDialog();
    }


    @OnClick(R.id.ivHelp)
    public void onClickHelp() {
        dialogsHelper.alertDialogErrorMsg(help);
    }
}
