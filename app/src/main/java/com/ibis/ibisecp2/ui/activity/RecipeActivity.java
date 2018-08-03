package com.ibis.ibisecp2.ui.activity;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.ibis.ibisecp2.R;
import com.ibis.ibisecp2.dagger.component.ActivityComponent;
import com.ibis.ibisecp2.ui.fragment.RecipeFragment;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by danila on 15.12.15.
 */
public class RecipeActivity extends BaseActivity {

    @BindView(R.id.toolbar)
    Toolbar toolbar;

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
        setContentView(R.layout.fragment_container);
        ButterKnife.bind(this);
        setTitle(getString(R.string.title_my_recipe));
        if (savedInstanceState == null) {
            RecipeFragment fragment = new RecipeFragment();
            String tag = fragment.getClass().getSimpleName();
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.contentFrame, fragment, tag)
                    .addToBackStack(null)
                    .commit();
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }
}
