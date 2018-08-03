package com.ibis.ibisecp2.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

import com.ibis.ibisecp2.dagger.HasComponent;
import com.ibis.ibisecp2.dagger.component.FragmentComponent;
import com.ibis.ibisecp2.ui.activity.BaseActivity;

/**
 * Created by danila on 20.11.15.
 */
public abstract class BaseFragment extends Fragment implements HasComponent<FragmentComponent> {

    private FragmentComponent fragmentComponent;

    abstract void doInjection(FragmentComponent fragmentComponent);

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initFragmentComponent();
        doInjection(fragmentComponent);
    }

    private void initFragmentComponent() {
        BaseActivity activity = (BaseActivity) getActivity();
        fragmentComponent = activity.getComponent().plusFragmentComponent();
    }

    @Override
    public FragmentComponent getComponent() {
        return fragmentComponent;
    }

    public void setupTitle(String title) {
        if (getActivity() != null) getActivity().setTitle(title);
    }

}
