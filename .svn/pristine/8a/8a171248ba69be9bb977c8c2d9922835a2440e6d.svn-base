package com.ibis.ibisecp2.ui.activity;


import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.widget.TextView;

import com.ibis.ibisecp2.R;
import com.ibis.ibisecp2.dagger.component.ActivityComponent;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

import butterknife.BindView;
import butterknife.ButterKnife;


public class AgreementActivity extends BaseActivity {

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.agreement)
    TextView tvAgreement;

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
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_agreement);
        ButterKnife.bind(this);
        setupToolbar(toolbar);
        setTitle("Политика");
        tvAgreement.setText(Html.fromHtml(readTxtAgreement()));
    }


    private String readTxtAgreement() {

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int i;
        try {
            InputStream inputStream = getResources().getAssets().open("agreement.html");
            i = inputStream.read();
            while (i != -1) {
                byteArrayOutputStream.write(i);
                i = inputStream.read();
            }
            inputStream.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return byteArrayOutputStream.toString();
    }
}


