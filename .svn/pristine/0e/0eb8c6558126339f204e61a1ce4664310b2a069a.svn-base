package com.ibis.ibisecp2.ui.fragment;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AlertDialog;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.location.places.ui.PlacePicker;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.MarkerOptions;
import com.ibis.ibisecp2.R;
import com.ibis.ibisecp2.adapter.DialogAdapter;
import com.ibis.ibisecp2.events.LocationEvent;
import com.ibis.ibisecp2.helpers.DialogsHelper;
import com.ibis.ibisecp2.helpers.ShowHideLoadHelper;
import com.ibis.ibisecp2.model.Clinic;
import com.ibis.ibisecp2.presenters.ClinicNearMePresenter;
import com.ibis.ibisecp2.ui.activity.AppointmentActivity;
import com.ibis.ibisecp2.ui.activity.BaseActivity;
import com.ibis.ibisecp2.ui.view.ClinicNearMeView;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import static android.app.Activity.RESULT_OK;
import static android.content.Context.LOCATION_SERVICE;

/**
 * Created by comp on 12.04.17.
 */

public class ClinicNearMeFragment extends SupportMapFragment implements ClinicNearMeView {
    public final static String TAG = ClinicNearMeFragment.class.getSimpleName();
    public static final String ARG_ID = "cityId";
    private static final int PLACE_PICKER_REQUEST = 1;
    private static final int ENABLE_GPS = 2;
    @Inject
    ShowHideLoadHelper mShowHideLoadHelper;
    @Inject
    ClinicNearMePresenter mPresenter;
    @Inject
    DialogsHelper dialogsHelper;
    private GoogleApiClient mClient;
    private GoogleMap mMap;
    private List<Clinic> mClinicList = new ArrayList<>();
    private double myLat;
    private double myLon;
    private Snackbar mySnackbar;

    public static ClinicNearMeFragment newInstance(String cityId) {
        Bundle args = new Bundle();
        args.putSerializable(ARG_ID, cityId);
        ClinicNearMeFragment fragment = new ClinicNearMeFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
        BaseActivity activity = (BaseActivity) getActivity();
        activity.getComponent().plusFragmentComponent().inject(this);
        if (dialogsHelper != null) {
            mShowHideLoadHelper.showLoad();
        }
        setHasOptionsMenu(true);
        mPresenter.attachView(this);
        createClient();
        mPresenter.loadMyLocation();
        getMapAsync(new OnMapReadyCallback() {
            @Override
            public void onMapReady(GoogleMap googleMap) {
                mMap = googleMap;
                if (dialogsHelper != null) {
                    mShowHideLoadHelper.hideLoad();
                }
            }
        });
    }

    private void chooseWayLocationAlert(String address, LatLng latLng) {
        if (mySnackbar != null) mySnackbar.dismiss();
        AlertDialog.Builder dialogBuilder =
                new AlertDialog.Builder(getActivity(), R.style.MyAlertDialogStyle);
        dialogBuilder.setCancelable(false);
        List<String> selectList = new ArrayList<String>();
        selectList.add("Определить местоположение с помощью GPS");
        selectList.add("Задать местоположение");

        if (address != null && latLng != null) {
            selectList.add(address + " " + getCoords(latLng));
        } else if (latLng != null) {
            selectList.add(getCoords(latLng));
        }
        DialogAdapter adapter =
                new DialogAdapter(getActivity(), R.layout.dialog_item, selectList);
        dialogBuilder.setAdapter(adapter, (dialog, item) -> {
            if (item == 0) {
                checkPermission();
            } else if (item == 1) {
                mPresenter.openLocationScreen();
            } else if (item == 2) {
                mPresenter.getPatient();
            }
        });
        dialogBuilder.setNegativeButton(android.R.string.cancel, (dialog, which) -> {
            dialog.dismiss();
        });
        AlertDialog alertDialog = dialogBuilder.create();
        dialogsHelper.setupDialogParams(alertDialog);
    }

    private String getCoords(LatLng latLng) {
        String latitude = String.valueOf(latLng.latitude);
        if (latitude.length() > 9) {
            latitude = latitude.substring(0, 8);
        }
        String longitude = String.valueOf(latLng.longitude);
        if (longitude.length() > 9) {
            longitude = longitude.substring(0, 8);
        }
        return String.format("\nШирота: %s \nДолгота: %s", latitude, longitude);
    }


    private void createClient() {
        mClient = new GoogleApiClient.Builder(getActivity())
                .addApi(LocationServices.API)
                .addConnectionCallbacks(new GoogleApiClient.ConnectionCallbacks() {
                    @Override
                    public void onConnected(@Nullable Bundle bundle) {
                    }

                    @Override
                    public void onConnectionSuspended(int i) {

                    }
                })
                .build();
    }


    private void myLocation() {
        LocationRequest request = LocationRequest.create();
        request.setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);
        request.setNumUpdates(1);
        request.setInterval(0);
        if (ActivityCompat.checkSelfPermission(getActivity(), Manifest.permission.ACCESS_FINE_LOCATION) !=
                PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(getActivity(),
                Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            return;
        }
        if (mClient.isConnected()) {
            LocationServices.FusedLocationApi
                    .requestLocationUpdates(mClient, request, location -> {
                        myLat = location.getLatitude();
                        myLon = location.getLongitude();
                        mClinicList.clear();
                        mShowHideLoadHelper.showLoad();
                        shooseMyLocation(myLat, myLon);
                        updateUI(mClinicList, myLat, myLon);
                    });

       /*     mySnackbar = Snackbar
                    .make(getView(), "Запомнить мое местоположение?", Snackbar.LENGTH_INDEFINITE);
            mySnackbar.setAction("Да", new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    shooseMyLocation(myLat, myLon);
                }
            });
            mySnackbar.show();*/
        } else {
            dialogsHelper.alertDialogErrorMsg("Обновите Google Play Services");
            mShowHideLoadHelper.hideLoad();
        }

    }

    private void updateUI(List<Clinic> clinics, double lat, double lon) {
        if (mMap == null) {
            return;
        }
        mShowHideLoadHelper.hideLoad();
        mMap.clear();

        myLat = lat;
        myLon = lon;

        LatLngBounds.Builder builder = new LatLngBounds.Builder();
        LatLng position = new LatLng(lat, lon);
        MarkerOptions options = new MarkerOptions()
                .position(position)
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED));
        mMap.addMarker(options);
        builder.include(position);

        CameraUpdate update;
        if (clinics != null && !(clinics.isEmpty())) {
            for (int i = 0; i <= clinics.size() - 1; i++) {
                addPlaceToMap(mMap, clinics.get(i), builder);
            }
            LatLngBounds bounds = builder.build();
            update = CameraUpdateFactory.newLatLngBounds(bounds, 30);
            mMap.setOnMarkerClickListener(marker -> {
                chooseClinicAlert(marker.getTitle(), marker.getPosition().latitude,
                        marker.getPosition().longitude);
                return true;
            });
        } else {
            update = CameraUpdateFactory.newLatLngZoom(position, 18);
        }
        mMap.animateCamera(update);
    }

    private void addPlaceToMap(GoogleMap map, Clinic clinic, LatLngBounds.Builder builder) {
        LatLng position = new LatLng(clinic.getLatitude(), clinic.getLongitude());
        MarkerOptions markerOptions = new MarkerOptions()
                .position(position)
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE))
                .title(clinic.getFullName());
        map.addMarker(markerOptions);
        builder.include(position);
    }

    @Override
    public void onResume() {
        super.onResume();
        getActivity().setTitle("Ближайшие больницы");
    }

    @Override
    public void onStart() {
        super.onStart();
        mClient.connect();
        if (!EventBus.getDefault().isRegistered(this)) {
            EventBus.getDefault().register(this);
        }
    }

    @Override
    public void onDestroyView() {
        mPresenter.detachView();
        super.onDestroyView();
        if (mySnackbar != null) mySnackbar.dismiss();
        mClient.disconnect();
        if (EventBus.getDefault().isRegistered(this)) {
            EventBus.getDefault().unregister(this);
        }
    }

    @Override
    public void showClinic(List<Clinic> clinicList, double lat, double lon) {
        mClinicList = clinicList;
        updateUI(mClinicList, lat, lon);

    }

    @Override
    public void showLocation(LatLng address) {
        Intent intent;
        try {
            if (address != null) {
                LatLngBounds latLngBounds = new LatLngBounds(address, address);
                intent = new PlacePicker.IntentBuilder().setLatLngBounds(latLngBounds)
                        .build(getActivity());
            } else {
                intent = new PlacePicker.IntentBuilder().build(getActivity());
            }
            this.startActivityForResult(intent, PLACE_PICKER_REQUEST);
            mShowHideLoadHelper.showLoad();
        } catch (GooglePlayServicesRepairableException e) {
            dialogsHelper.alertDialogErrorMsg("Обновите Google Play Services");
            e.printStackTrace();
        } catch (GooglePlayServicesNotAvailableException e) {
            dialogsHelper.alertDialogErrorMsg("Не доступны Google Play Services");
            e.printStackTrace();
        }
    }

    @Override
    public void successSaveLocation() {

    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == PLACE_PICKER_REQUEST) {
            if (resultCode == RESULT_OK) {
                Place place = PlacePicker.getPlace(getActivity(), data);
                mPresenter.saveLocation(place.getAddress().toString(), place.getLatLng());
                mShowHideLoadHelper.showLoad();
            } else {
                mShowHideLoadHelper.hideLoad();
            }
        } else if (requestCode == ENABLE_GPS) {
            defineMyLocation();
        }
    }

    @Override
    public void error() {
        mShowHideLoadHelper.hideLoad();
    }

    @Override
    public void showAddress(String address, LatLng latLng) {
        chooseWayLocationAlert(address, latLng);
    }


    private void chooseClinicAlert(String msg, double lat, double lon) {
        if (lat == myLat && lon == myLon) {
            return;
        }
        if (mySnackbar != null) mySnackbar.dismiss();
        AlertDialog.Builder dialogBuilder =
                new AlertDialog.Builder(getActivity(), R.style.MyAlertDialogStyle);
        dialogBuilder.setMessage(msg);
        dialogBuilder.setCancelable(false);
        dialogBuilder.setPositiveButton("Выбрать",
                (dialog, which) -> {
                    getClinic(lat, lon);
                });

        dialogBuilder.setNegativeButton("отмена",
                (dialog, which) -> {
                    dialog.cancel();
                });
        AlertDialog alertDialog = dialogBuilder.create();
        dialogsHelper.setupDialogParams(alertDialog);
    }

    private void shooseMyLocation(double lat, double lon) {
        Geocoder geocoder = new Geocoder(getActivity());
        try {
            List<Address> addressList = geocoder.getFromLocation(lat, lon, 1);
            addressList.size();
            if (addressList.size() > 0) {
                Address address = addressList.get(0);
                String addr = "";
                for (int i = 0; i <= address.getMaxAddressLineIndex(); i++) {
                    addr = String.format("%s%s", addr, address.getAddressLine(i));
                    if (address.getMaxAddressLineIndex() != i) {
                        addr = String.format("%s, ", addr);
                    }
                }
                mPresenter.saveLocation(addr, new LatLng(lat, lon));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void getClinic(double lat, double lon) {
        for (Clinic clinic : mClinicList) {
            if (clinic.getLatitude() == lat && clinic.getLongitude() == lon) {
                mPresenter.savePatient(clinic, clinic.getCityId());
                break;
            }
        }
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        // Do something that differs the Activity's menu here
        inflater.inflate(R.menu.menu_location, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_location:
                mPresenter.loadMyLocation();
                return true;
            case R.id.menu_city:
                mPresenter.loadCity();
                return true;
            case R.id.menu_doctor_favorites:
                mPresenter.loadFavoriteDoctors();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void checkPermission() {
        if (Build.VERSION.SDK_INT >= 23) {
            if (!((AppointmentActivity) getActivity()).runtimePermissionsLocation()) {
                defineMyLocation();
            }
        } else {
            defineMyLocation();
        }
    }

    private void defineMyLocation() {
        LocationManager locationManager =
                (LocationManager) getActivity().getSystemService(LOCATION_SERVICE);
        if (locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER) &&
                locationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER)) {
            myLocation();
            mShowHideLoadHelper.showLoad();
        } else {
            showSettingsAlert();
        }
    }

    private void showSettingsAlert() {
        android.app.AlertDialog.Builder alertDialog =
                new android.app.AlertDialog.Builder(getActivity());
        alertDialog.setTitle("GPS выключен");
        alertDialog.setMessage("Вы хотите включить GPS?");
        alertDialog.setPositiveButton("да", (dialog, which) -> {
            this.startActivityForResult(new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS),
                    ENABLE_GPS);
        });

        alertDialog.setNegativeButton("нет", (dialog, which) -> dialog.cancel());
        alertDialog.show();
    }

    @Subscribe(sticky = true)
    public void onLocationEvent(LocationEvent event) {
        EventBus.getDefault().removeStickyEvent(event);
        if (Build.VERSION.SDK_INT >= 23) {
            defineMyLocation();
        }
    }

}
