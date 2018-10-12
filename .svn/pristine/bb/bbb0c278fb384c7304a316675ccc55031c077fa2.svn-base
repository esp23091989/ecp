package com.ibis.ibisecp2.ui.fragment;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.DialogFragment;
import android.support.v4.content.ContextCompat;
import android.telephony.PhoneNumberFormattingTextWatcher;
import android.text.Editable;
import android.text.InputFilter;
import android.text.InputType;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.ibis.ibisecp2.R;
import com.ibis.ibisecp2.events.ErrorChildEvent;
import com.ibis.ibisecp2.helpers.DialogsHelper;
import com.ibis.ibisecp2.presenters.LoginPresenter;
import com.ibis.ibisecp2.ui.Navigator;
import com.ibis.ibisecp2.ui.activity.BaseActivity;
import com.ibis.ibisecp2.ui.view.LoginView;
import com.ibis.ibisecp2.utils.AndroidUtils;
import com.ibis.ibisecp2.utils.SharedPreferencesUtils;

import org.greenrobot.eventbus.EventBus;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginFragment extends DialogFragment implements LoginView {

    @BindView(R.id.editTextLoginMobile)
    EditText mEditTextLogin;
    @BindView(R.id.editTextPassword)
    com.scottyab.showhidepasswordedittext.ShowHidePasswordEditText mEditTextPassword;
    @BindView(R.id.checkBoxSaveAuthentication)
    CheckBox mCheckBoxSaveAuthentication;
    @BindView(R.id.login_panel)
    RelativeLayout loginPanel;
    @BindView(R.id.tv_snils_type)
    TextView tvSnilsType;
    @BindView(R.id.tv_email_type)
    TextView tvEmailType;
    @BindView(R.id.tv_mobile_type)
    TextView tvMobileType;
    @BindView(R.id.til_login)
    TextInputLayout tilLogin;
    /*   @BindView(R.id.tv_agreement)
       TextView tvAgreement;
       @BindView(R.id.checkApprove)
       CheckBox checkApprove;*/
    @BindView(R.id.buttonDialogLogin)
    Button buttonDialogLogin;

    @Inject
    LoginPresenter loginPresenter;
    @Inject
    SharedPreferencesUtils preferencesUtils;
    @Inject
    DialogsHelper dialogsHelper;

    @Inject
    Navigator navigator;
    //http://stackoverflow.com/questions/14692764/android-format-edittext-view-for-phone-numbers
    PhoneNumberFormattingTextWatcher phoneNumberFormattingTextWatcher = new PhoneNumberFormattingTextWatcher() {
        //we need to know if the user is erasing or inputing some new character
        private boolean backspacingFlag = false;
        //we need to block the :afterTextChanges method to be called again after we just replaced the EditText text
        private boolean editedFlag = false;
        //we need to mark the cursor position and restore it after the edition
        private int cursorComplement;

        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            //we store the cursor local relative to the end of the string in the EditText before the edition
            cursorComplement = s.length() - mEditTextLogin.getSelectionStart();
            if (count > after) {
                backspacingFlag = true;
            } else {
                backspacingFlag = false;
            }
        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            // nothing to do here =D
        }

        @Override
        public void afterTextChanged(Editable s) {
            String code = "+7";
            if (s.toString().length() < 2) {
                mEditTextLogin.setText(code);
                mEditTextLogin.setSelection(mEditTextLogin.getText().length());
            } else {
                //what matters are the phone digits beneath the mask, so we always work with a raw string with only digits
                String phoneExtract = s.toString().substring(2, s.toString().length());
                String phone = phoneExtract.replaceAll("[^\\d]", "");
                //if the text was just edited, :afterTextChanged is called another time... so we need to verify the flag of edition
                //if the flag is false, this is a original user-typed entry. so we go on and do some magic
                if (!editedFlag) {
                    //we start verifying the worst case, many characters mask need to be added
                    //example: 999999999 <- 6+ digits already typed
                    // masked: (999)999-999
                    if (phone.length() >= 8 && !backspacingFlag) {
                        //we will edit. next call on this textWatcher will be ignored
                        editedFlag = true;
                        //here is the core. we substring the raw digits and add the mask as convenient
                        String ans = code + "(" + phone.substring(0, 3) + ")" + phone.substring(3, 6) + "-"
                                + phone.substring(6, 8) + "-" + phone.substring(8);
                        mEditTextLogin.setText(ans);
                        //we deliver the cursor to its original position relative to the end of the string
                        mEditTextLogin.setSelection(mEditTextLogin.getText().length() - cursorComplement);
                        //we end at the most simple case, when just one character mask is needed
                        //example: 99999 <- 3+ digits already typed
                        // masked: (999)99
                    } else if (phone.length() >= 6 && !backspacingFlag) {
                        //we will edit. next call on this textWatcher will be ignored
                        editedFlag = true;
                        //here is the core. we substring the raw digits and add the mask as convenient
                        String ans = code + "(" + phone.substring(0, 3) + ")" + phone.substring(3, 6) + "-" + phone.substring(6);
                        mEditTextLogin.setText(ans);
                        //we deliver the cursor to its original position relative to the end of the string
                        mEditTextLogin.setSelection(mEditTextLogin.getText().length() - cursorComplement);
                        //we end at the most simple case, when just one character mask is needed
                        //example: 99999 <- 3+ digits already typed
                        // masked: (999)99
                    } else if (phone.length() >= 3 && !backspacingFlag) {
                        editedFlag = true;
                        String ans = code + "(" + phone.substring(0, 3) + ")" + phone.substring(3);
                        mEditTextLogin.setText(ans);
                        mEditTextLogin.setSelection(mEditTextLogin.getText().length() - cursorComplement);
                    }
                    // We just edited the field, ignoring this cicle of the watcher and getting ready for the next
                } else {
                    editedFlag = false;
                }
            }
        }
    };
    PhoneNumberFormattingTextWatcher snilsFormattingTextWatcher = new PhoneNumberFormattingTextWatcher() {
        //we need to know if the user is erasing or inputing some new character
        private boolean backspacingFlag = false;
        //we need to block the :afterTextChanges method to be called again after we just replaced the EditText text
        private boolean editedFlag = false;
        //we need to mark the cursor position and restore it after the edition
        private int cursorComplement;

        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            //we store the cursor local relative to the end of the string in the EditText before the edition
            cursorComplement = s.length() - mEditTextLogin.getSelectionStart();
            if (count > after) {
                backspacingFlag = true;
            } else {
                backspacingFlag = false;
            }
        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            // nothing to do here =D
        }

        @Override
        public void afterTextChanged(Editable s) {
            String snils = s.toString();
            String phone = snils.replaceAll("[^\\d]", "");
            if (!editedFlag) {
                if (phone.length() >= 9 && !backspacingFlag) {
                    editedFlag = true;
                    String ans = "" + phone.substring(0, 3) + "-" + phone.substring(3, 6) + "-" + phone.substring(6, 9) + " " + phone.substring(9);
                    mEditTextLogin.setText(ans);
                    mEditTextLogin.setSelection(mEditTextLogin.getText().length() - cursorComplement);
                } else if (phone.length() >= 6 && !backspacingFlag) {
                    editedFlag = true;
                    String ans = "" + phone.substring(0, 3) + "-" + phone.substring(3, 6) + "-" + phone.substring(6);
                    mEditTextLogin.setText(ans);
                    mEditTextLogin.setSelection(mEditTextLogin.getText().length() - cursorComplement);
                } else if (phone.length() >= 3 && !backspacingFlag) {
                    editedFlag = true;
                    String ans = "" + phone.substring(0, 3) + "-" + phone.substring(3);
                    mEditTextLogin.setText(ans);
                    mEditTextLogin.setSelection(mEditTextLogin.getText().length() - cursorComplement);
                }
            } else {
                editedFlag = false;
            }
        }
    };
    @BindView(R.id.progress_layout)
    FrameLayout mProgressLayout;
    private String type = "";
    private boolean isError;

    public static LoginFragment newFragment(boolean isError) {
        LoginFragment fragment = new LoginFragment();
        fragment.isError = isError;
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_login, container, false);
        getDialog().getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        getDialog().getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        getDialog().getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT);
        getDialog().setCanceledOnTouchOutside(false);
        ButterKnife.bind(this, rootView);
        BaseActivity activity = (BaseActivity) getActivity();
        activity.getComponent().plusFragmentComponent().inject(this);

        loginPresenter.attachView(this);
        mProgressLayout.setVisibility(View.GONE);
        loginPanel.setVisibility(View.VISIBLE);
        if (preferencesUtils.getPatientId() != -1) {
            setUserLogin(String.valueOf(preferencesUtils.getSnils()), "");
        }
        mEditTextPassword.setOnEditorActionListener((v, actionId, event) -> {
            if (actionId == EditorInfo.IME_ACTION_DONE) {
//                if (checkApprove.isChecked()) {
                loginClick();
                AndroidUtils.hideKeyboard(mEditTextPassword);
//                }
                return true;
            }
            return false;
        });

//        Spannable text = new SpannableString("Подтверждение согласия с политикой обработки " +
//                "персональных данных");
//        text.setSpan(new UnderlineSpan(), 25, text.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
//        text.setSpan(new ForegroundColorSpan(ContextCompat.getColor(getActivity(), R.color.blue_letter)),
//                25, text.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
//        tvAgreement.setText(text);
        setupInputSnils();
        return rootView;
    }

    public void setUserLogin(String login, String password) {
        mEditTextLogin.setText(login);
        setPassword(password);
        mEditTextLogin.setSelection(mEditTextLogin.length());
    }

    private void setPassword(String password) {
        if (password == null) {
            mCheckBoxSaveAuthentication.setChecked(false);
        } else {
            mEditTextPassword.setText(password);
            mCheckBoxSaveAuthentication.setChecked(true);
        }
    }

    @Override
    public void onStop() {
        super.onStop();
        loginPresenter.interruptRequest();
        mProgressLayout.setVisibility(View.GONE);
        loginPanel.setVisibility(View.VISIBLE);
    }

    private String validateLogin() {
        String login = mEditTextLogin.getText().toString();
        String validLogin = null;
        switch (type) {
            case "snils":
                validLogin = validateSnils(login);
                break;
            case "phone":
                validLogin = validateMobile(login);
                break;
            case "email":
                validLogin = validateEmail(login);
                break;
            default:
                break;
        }

        return validLogin;
    }

    private String validateMobile(String login) {
        int lengthNumber = 16;
        if (login.length() == lengthNumber) {
            //+7(***) ***-****
            // i = 2 - skip '+7(' ; i = 6 skip ')' ; i =10 skip - ; i =13 skip -
            for (int i = 3; i < lengthNumber; i++) {
                if (i != 6 && i != 10 && i != 13 && !checkSymbolInput(String.valueOf(login.charAt(i)))) {
                    dialogsHelper.alertDialogErrorMsg("Мобильный телефон введен неверно");
                    return null;
                }
            }
            return login.replace("-", "");
        } else {
            dialogsHelper.alertDialogErrorMsg("Мобильный телефон введен неверно");
            return null;
        }
    }

    private String validateEmail(String email) {
        // Check for a valid email address.
        if (TextUtils.isEmpty(email)) {
            email = null;
            dialogsHelper.alertDialogErrorMsg("Поле Email не может быть пустым");
        } else if (!email.contains("@") || !Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            email = null;
            dialogsHelper.alertDialogErrorMsg("Email введен неверно");
        }
        return email;
    }

    private boolean validatePassword(String password) {
        boolean flag = true;
        if (TextUtils.isEmpty(password)) {
            flag = false;
            dialogsHelper.alertDialogErrorMsg("Поле пароль не может быть пустым");
        }

        return flag;
    }

    @OnClick(R.id.buttonDialogLogin)
    public void loginClick() {
        AndroidUtils.hideKeyboard(getView());
        String login = validateLogin();
        if (login != null) {
            if (validatePassword(mEditTextPassword.getText().toString())) {
                loginPresenter.login(login, mEditTextPassword.getText().toString(),
                        mCheckBoxSaveAuthentication.isChecked(), type);
//                loginPresenter.login("06384918596", "anna19031984",
//                        mCheckBoxSaveAuthentication.isChecked(), type);
                mProgressLayout.setVisibility(View.VISIBLE);
                loginPanel.setVisibility(View.GONE);
            }
        }
    }

    @Override
    public void onDestroyView() {
        loginPresenter.detachView();
        super.onDestroyView();
    }

    @OnClick(R.id.buttonDialogList)
    public void listPatientShow() {
        navigator.openListPatientFragment();
        getDialog().dismiss();
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void errorLogin(Throwable e) {
        mProgressLayout.setVisibility(View.GONE);
        loginPanel.setVisibility(View.VISIBLE);
        dialogsHelper.alertDialogError(e);
    }

    @Override
    public void errorLoginMsg(String e) {
        mProgressLayout.setVisibility(View.GONE);
        loginPanel.setVisibility(View.VISIBLE);
        dialogsHelper.alertDialogErrorMsg(e);
    }

    @Override
    public void savePatient() {
        getDialog().dismiss();
        AndroidUtils.hideKeyboard(mEditTextPassword);
    }

    @Override
    public void onConfirm() {
        mProgressLayout.setVisibility(View.GONE);
        loginPanel.setVisibility(View.VISIBLE);
    }

    @Override
    public void onErrorChild(String text) {
        EventBus.getDefault().postSticky(new ErrorChildEvent(text));
    }

    private void setupCurrentTypeInput(TextView textView) {
        tvEmailType.setTextColor(ContextCompat.getColor(getActivity(), R.color.textSecondaryPrimary));
        tvMobileType.setTextColor(ContextCompat.getColor(getActivity(), R.color.textSecondaryPrimary));
        tvSnilsType.setTextColor(ContextCompat.getColor(getActivity(), R.color.textSecondaryPrimary));
        tvSnilsType.setSelected(false);
        tvMobileType.setSelected(false);
        tvEmailType.setSelected(false);
        textView.setTextColor(ContextCompat.getColor(getActivity(), R.color.colorAccent));
        textView.setSelected(true);

    }

    @OnClick({R.id.tv_snils_type, R.id.tv_email_type, R.id.tv_mobile_type})
    public void onClick(View view) {
        mEditTextPassword.setText("");
        mEditTextLogin.requestFocus();
        switch (view.getId()) {
            case R.id.tv_snils_type:
                setupInputSnils();
                break;
            case R.id.tv_email_type:
                setupInputEmail();
                break;
            case R.id.tv_mobile_type:
                setupInputMobile();
                break;
        }
    }

    // setup input login
    private void setupInputSnils() {
        removeTextWatherListener();
        type = "snils";
        setupCurrentTypeInput(tvSnilsType);
        mEditTextLogin.setInputType(InputType.TYPE_CLASS_NUMBER);
        tilLogin.setHint(getString(R.string.authorize_snils));
        mEditTextLogin.setText("");
        mEditTextLogin.setSelection(mEditTextLogin.length());
        mEditTextLogin.addTextChangedListener(snilsFormattingTextWatcher);
        // 14 - length snils with '-' and ' '
        mEditTextLogin.setFilters(new InputFilter[]{new InputFilter.LengthFilter(14)});
    }

    private void setupInputEmail() {
        removeTextWatherListener();
        type = "email";
        setupCurrentTypeInput(tvEmailType);
        mEditTextLogin.setFilters(new InputFilter[]{});
        mEditTextLogin.setInputType(InputType.TYPE_CLASS_TEXT |
                InputType.TYPE_TEXT_VARIATION_EMAIL_SUBJECT |
                InputType.TYPE_TEXT_VARIATION_EMAIL_ADDRESS | InputType.TYPE_TEXT_VARIATION_WEB_EMAIL_ADDRESS);
        tilLogin.setHint(getString(R.string.authorize_email));
        mEditTextLogin.setText("");
        mEditTextLogin.setSelection(mEditTextLogin.length());
    }

    private void setupInputMobile() {
        removeTextWatherListener();
        type = "phone";
        mEditTextLogin.setText("+7");
        setupCurrentTypeInput(tvMobileType);
        mEditTextLogin.setInputType(InputType.TYPE_CLASS_NUMBER);
        tilLogin.setHint(getString(R.string.authorize_mobile));
        mEditTextLogin.setSelection(mEditTextLogin.length());
        mEditTextLogin.addTextChangedListener(phoneNumberFormattingTextWatcher);
        // 15 - length mobile +7(999)999-9999
        mEditTextLogin.setFilters(new InputFilter[]{new InputFilter.LengthFilter(16)});
    }

    private boolean checkSymbolInput(String str) {
        Pattern p = Pattern.compile("[^\\D]");
        Matcher m = p.matcher(str);
        return m.matches();
    }

    private void removeTextWatherListener() {
        switch (type) {
            case "snils":
                mEditTextLogin.removeTextChangedListener(snilsFormattingTextWatcher);
                break;
            case "phone":
                mEditTextLogin.removeTextChangedListener(phoneNumberFormattingTextWatcher);
                break;
            default:
                break;
        }
    }

    /**
     * http://murzix.ru/2013/06/%D0%BF%D1%80%D0%BE%D0%B2%D0%B5%D1%80%D0%BA%D0%B0-%D1%81%D0%BD%D0%B8%D
     * // 0%BB%D1%81-%D1%81-%D0%BF%D0%BE%D0%BC%D0%BE%D1%89%D1%8C%D1%8E-javascript/
     */
    private String validateSnils(String snils) {
        int lengthSnils = 14;
        if (snils.length() == lengthSnils) {
            int checkSum = Integer.parseInt(snils.substring(12, 13) + snils.substring(13));

            int sum = (getInt(snils, 0) * 9 + getInt(snils, 1) * 8 + getInt(snils, 2) * 7 +
                    getInt(snils, 4) * 6 + getInt(snils, 5) * 5 + getInt(snils, 6) * 4 +
                    getInt(snils, 8) * 3 + getInt(snils, 9) * 2 + getInt(snils, 10));

            if (sum < 100 && sum == checkSum) {
                return snils.replace(" ", "+");
            } else if ((sum == 100 || sum == 101) && checkSum == 0) {
                return snils.replace(" ", "+");
            } else if (sum > 101 && (sum % 101 == checkSum || (sum % 101 == 100 && checkSum == 0))) {
                return snils.replace(" ", "+");
            } else {
                dialogsHelper.alertDialogErrorMsg("Введенный СНИЛС неверен");
                return null;
            }
        } else {
            dialogsHelper.alertDialogErrorMsg("Введенный СНИЛС неверен");
            return null;
        }
    }

    private int getInt(String checkedValue, int index) {
        return Integer.parseInt(String.valueOf(checkedValue.charAt(index)));
    }

    @OnClick({R.id.checkBoxSaveAuthentication})
    public void onClickChb(View view) {
        switch (view.getId()) {
            case R.id.checkBoxSaveAuthentication:
                AndroidUtils.hideKeyboard(getView());
                break;
        }
    }
}
