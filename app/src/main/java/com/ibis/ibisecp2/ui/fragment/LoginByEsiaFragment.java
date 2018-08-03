package com.ibis.ibisecp2.ui.fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ibis.ibisecp2.R;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link LoginByEsiaFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link LoginByEsiaFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class LoginByEsiaFragment extends Fragment {
    public static final String TAG = LoginByEsiaFragment.class.getSimpleName();

    public static LoginByEsiaFragment newInstance() {
        return new LoginByEsiaFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_login_by_esia, container, false);
    }
}
