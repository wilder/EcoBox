package com.wilderpereira.ecobox;


import android.*;
import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;


/**
 * A simple {@link Fragment} subclass.
 */
public class MapFragment extends Fragment implements GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener {

    MapView mMapView;
    Context context;
    private GoogleMap googleMap;
    GoogleApiClient mGoogleApiClient;
    private Location mLastLocation;
    LatLng mLocation;
    private GoogleMap mMap;

    public MapFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_map, container, false);
        context = getContext();

        mGoogleApiClient = new GoogleApiClient.Builder(context)
                .addConnectionCallbacks(this)
                .addOnConnectionFailedListener(this)
                .addApi(LocationServices.API)
                .build();

        mMapView = (MapView) v.findViewById(R.id.mapView);
        mMapView.onCreate(savedInstanceState);
        mMapView.onResume();// needed to get the map to display immediately

        try {
            MapsInitializer.initialize(getActivity().getApplicationContext());
        } catch (Exception e) {
            e.printStackTrace();
        }

        mMapView.getMapAsync(new OnMapReadyCallback() {
            @Override
            public void onMapReady(GoogleMap mMap) {
                googleMap = mMap;

                if (ActivityCompat.checkSelfPermission(context, android.Manifest.permission.ACCESS_FINE_LOCATION)
                        != PackageManager.PERMISSION_GRANTED) {

                    ActivityCompat.requestPermissions(getActivity(), new String[]{android.Manifest.permission.ACCESS_FINE_LOCATION}, 0);

                }

                if (ActivityCompat.checkSelfPermission(context, Manifest.permission.ACCESS_COARSE_LOCATION)
                        != PackageManager.PERMISSION_GRANTED) {

                    ActivityCompat.requestPermissions(getActivity(), new String[]{android.Manifest.permission.ACCESS_COARSE_LOCATION}, 0);

                }

                if (ActivityCompat.checkSelfPermission(context, Manifest.permission.ACCESS_FINE_LOCATION)
                        != PackageManager.PERMISSION_GRANTED) {

                    ActivityCompat.requestPermissions(getActivity(), new String[]{android.Manifest.permission.ACCESS_FINE_LOCATION}, 0);

                }

                googleMap.setMyLocationEnabled(true);

            }
        });

        return v;
    }

    @Override
    public void onResume() {
        super.onResume();
        mMapView.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
        mMapView.onPause();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mMapView.onDestroy();
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        mMapView.onLowMemory();
    }

    @Override
    public void onStart() {
        mGoogleApiClient.connect();
        super.onStart();
    }

    @Override
    public void onStop() {
        mGoogleApiClient.disconnect();
        super.onStop();
    }

    @Override
    public void onConnected(@Nullable Bundle bundle) {
        if (ActivityCompat.checkSelfPermission(context, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(context, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        mLastLocation = LocationServices.FusedLocationApi.getLastLocation(
                mGoogleApiClient);
        if (mLastLocation != null) {

            // For dropping a marker at a point on the Map
            mLocation = new LatLng(mLastLocation.getLatitude(), mLastLocation.getLongitude());
            googleMap.addMarker(new MarkerOptions()
                    .position(mLocation)
                    .title("RecyKing")
                    .snippet("Daniel Oliveira"))
                    .setIcon(BitmapDescriptorFactory
                    .fromResource(R.drawable.ic_marker));

            // For zooming automatically to the location of the marker
            CameraPosition cameraPosition = new CameraPosition.Builder().target(mLocation).zoom(12).build();
            //mMap.moveCamera(CameraUpdateFactory.newLatLng(mLocation));
            googleMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));

            LatLng mLocation2 = new LatLng(-23.524423,-46.670640700000035);
            googleMap.addMarker(new MarkerOptions()
                    .position(mLocation2)
                    .title("RecyQueen")
                    .snippet("Joanne D."))
                    .setIcon(BitmapDescriptorFactory
                            .fromResource(R.drawable.ic_marker));

            mLocation2 = new LatLng(-23.5996933,-46.62317529999996);
            googleMap.addMarker(new MarkerOptions()
                    .position(mLocation2)
                    .title("RecyQueen")
                    .snippet("Kesia Ventura"))
                    .setIcon(BitmapDescriptorFactory
                            .fromResource(R.drawable.ic_marker));


            mLocation2 = new LatLng(-23.4722745,-46.669822599999975);
            googleMap.addMarker(new MarkerOptions()
                    .position(mLocation2)
                    .title("RecyQueen")
                    .snippet("Joanne D."))
                    .setIcon(BitmapDescriptorFactory
                            .fromResource(R.drawable.ic_marker));

            mLocation2 = new LatLng(-23.5584042,-46.68748900000003);
            googleMap.addMarker(new MarkerOptions()
                    .position(mLocation2)
                    .title("RecyQueen")
                    .snippet("Julio Cesar"))
                    .setIcon(BitmapDescriptorFactory
                            .fromResource(R.drawable.ic_marker));

            mLocation2 = new LatLng(-23.5931297,-46.63511790000001);
            googleMap.addMarker(new MarkerOptions()
                    .position(mLocation2)
                    .title("RecyQueen")
                    .snippet("Joanne D."))
                    .setIcon(BitmapDescriptorFactory
                            .fromResource(R.drawable.ic_marker));
            mLocation2 = new LatLng(-23.5299194,-46.58302359999999);
            googleMap.addMarker(new MarkerOptions()
                    .position(mLocation2)
                    .title("RecyQueen")
                    .snippet("Kesia Ventura"))
                    .setIcon(BitmapDescriptorFactory
                            .fromResource(R.drawable.ic_marker));
            mLocation2 = new LatLng(-23.6532661,-46.64945510000001);
            googleMap.addMarker(new MarkerOptions()
                    .position(mLocation2)
                    .title("RecyKing")
                    .snippet("Wilder Pereira"))
                    .setIcon(BitmapDescriptorFactory
                            .fromResource(R.drawable.ic_marker));
            mLocation2 = new LatLng(-23.6117038,-46.6446474);
            googleMap.addMarker(new MarkerOptions()
                    .position(mLocation2)
                    .title("RecyKing")
                    .snippet("Diego Moreno"))
                    .setIcon(BitmapDescriptorFactory
                            .fromResource(R.drawable.ic_marker));
            mLocation2 = new LatLng(-23.5506966,-46.52565129999999);
            googleMap.addMarker(new MarkerOptions()
                    .position(mLocation2)
                    .title("RecyKing")
                    .snippet("John Doe"))
                    .setIcon(BitmapDescriptorFactory
                            .fromResource(R.drawable.ic_marker));
            mLocation2 = new LatLng(-23.664129,-46.77536629999997);
            googleMap.addMarker(new MarkerOptions()
                    .position(mLocation2)
                    .title("RecyKing")
                    .snippet("Diego Moreno"))
                    .setIcon(BitmapDescriptorFactory
                            .fromResource(R.drawable.ic_marker));
            mLocation2 = new LatLng(-23.6729898,-46.7910445);
            googleMap.addMarker(new MarkerOptions()
                    .position(mLocation2)
                    .title("RecyKing")
                    .snippet("John Doe"))
                    .setIcon(BitmapDescriptorFactory
                            .fromResource(R.drawable.ic_marker));
            mLocation2 = new LatLng(-23.6384647,-46.75496780000003);
            googleMap.addMarker(new MarkerOptions()
                    .position(mLocation2)
                    .title("RecyKing")
                    .snippet("John Doe"))
                    .setIcon(BitmapDescriptorFactory
                            .fromResource(R.drawable.ic_marker));
            mLocation2 = new LatLng(-23.638313,-46.74193630000002);
            googleMap.addMarker(new MarkerOptions()
                    .position(mLocation2)
                    .title("Recyking")
                    .snippet("John Doe"))
                    .setIcon(BitmapDescriptorFactory
                            .fromResource(R.drawable.ic_marker));

            mLocation2 = new LatLng(-23.622432,-46.72546990000001);
            googleMap.addMarker(new MarkerOptions()
                    .position(mLocation2)
                    .title("Recyking")
                    .snippet("John Doe"))
                    .setIcon(BitmapDescriptorFactory
                            .fromResource(R.drawable.ic_marker));


        }


    }

    @Override
    public void onConnectionSuspended(int i) {

    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {

    }
}
