package com.ibis.ibisecp2.ui.activity;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.webkit.WebView;
import android.widget.TextView;

import com.ibis.ibisecp2.BuildConfig;
import com.ibis.ibisecp2.R;
import com.ibis.ibisecp2.dagger.component.ActivityComponent;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by danila on 14.12.15.
 */
public class InfoActivity extends BaseActivity {
    public static final String ARG_MENU = "menu";

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.tvInfo)
    WebView tvInfo;
    @BindView(R.id.tvVersion)
    TextView mTvVersion;

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
        setContentView(R.layout.activity_info);
        ButterKnife.bind(this);
        String versionName = BuildConfig.VERSION_NAME;
        Date buildDate = BuildConfig.buildTime;
        SimpleDateFormat fmt = new SimpleDateFormat("dd.MM.yyyy", new Locale("ru", "RU"));
        fmt.format(buildDate);
        mTvVersion.setText(String.format("Версия приложения: %s\nДата обновления: " +
                        "%s\nРазработчик: ООО \"Облачные технологии\"",
                versionName, fmt.format(buildDate)));
        tvInfo.loadUrl("file:///android_asset/info.html");

        if (getIntent().hasExtra(ARG_MENU)) {
            setupDrawer();
            setTitle("Справка");
        } else {
            toolbar.setNavigationOnClickListener((View v) -> {
                onBackPressed();
            });
            setSupportActionBar(toolbar);
            setTitle("Информация");
        }

    }
}
