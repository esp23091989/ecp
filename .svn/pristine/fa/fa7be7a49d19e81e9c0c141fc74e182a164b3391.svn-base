package com.ibis.ibisecp2.ui.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.location.places.ui.PlacePicker;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.ibis.ibisecp2.R;
import com.ibis.ibisecp2.dagger.component.FragmentComponent;
import com.ibis.ibisecp2.helpers.ShowHideLoadHelper;
import com.ibis.ibisecp2.presenters.LocationPresenter;
import com.ibis.ibisecp2.ui.view.LocationView;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

import static android.app.Activity.RESULT_OK;

/**
 * Created by comp on 17.04.17.
 */

public class LocationFragment extends BaseFragment implements LocationView {
    public final static String TAG = LocationFragment.class.getSimpleName();
    private final static int PLACE_PICKER_REQUEST = 1;
    @BindView(R.id.fragment_location_coordinates_text_view)
    TextView mTextView;
    Unbinder unbinder;

    @Inject
    LocationPresenter mLocationPresenter;
    @Inject
    ShowHideLoadHelper mShowHideLoadHelper;
    @BindView(R.id.fragment_location_change_button)
    Button mLocationChangeButton;


    @Override
    void doInjection(FragmentComponent fragmentComponent) {
        fragmentComponent.inject(this);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_location, container, false);
        unbinder = ButterKnife.bind(this, view);
        mLocationPresenter.attachView(this);
        mLocationPresenter.getLocation();
        return view;
    }

    @OnClick(R.id.fragment_location_change_button)
    public void onClick() {
//        try {
//            LatLngBounds latLngBounds = new LatLngBounds()
//            Intent intent = new PlacePicker.IntentBuilder().setLatLngBounds().build(getActivity());
//            this.startActivityForResult(intent, PLACE_PICKER_REQUEST);
//            mShowHideLoadHelper.showLoad();
//        } catch (GooglePlayServicesRepairableException e) {
//            e.printStackTrace();
//        } catch (GooglePlayServicesNotAvailableException e) {
//            e.printStackTrace();
//        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == PLACE_PICKER_REQUEST) {
            if (resultCode == RESULT_OK) {
                Place place = PlacePicker.getPlace(getActivity(), data);
                setAddress(place.getAddress().toString());
                mLocationPresenter.saveLocation(place);
                mShowHideLoadHelper.showLoad();

            } else {
                mShowHideLoadHelper.hideLoad();
            }
        }
    }

    private void setAddress(String address) {
        if (address == null) {
            mTextView.setText("Мое местоположение не задано");
            mLocationChangeButton.setText("Задать");

        } else {
            mTextView.setText(String.format("Мое местоположение: %s", address));
            mLocationChangeButton.setText("Изменить");
        }
    }

    @Override
    public void onDestroyView() {
        mLocationPresenter.detachView();
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public void saveLocation() {
        mShowHideLoadHelper.hideLoad();
    }

    @Override
    public void showLocation(LatLng address) {
        Intent intent;
        try {
            if (address != null) {
                LatLngBounds latLngBounds = new LatLngBounds(address, address);
                intent = new PlacePicker.IntentBuilder().setLatLngBounds(latLngBounds).build(getActivity());
            } else {
                intent = new PlacePicker.IntentBuilder().build(getActivity());
            }
            this.startActivityForResult(intent, PLACE_PICKER_REQUEST);
            mShowHideLoadHelper.showLoad();
        } catch (GooglePlayServicesRepairableException e) {
            e.printStackTrace();
        } catch (GooglePlayServicesNotAvailableException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void error() {
        mShowHideLoadHelper.hideLoad();
    }

}
