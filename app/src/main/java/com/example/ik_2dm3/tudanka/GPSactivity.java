
package com.example.ik_2dm3.tudanka;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Criteria;
import android.location.Location;


import android.location.LocationManager;
import android.os.Bundle;

import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.support.v4.content.ContextCompat;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.GoogleMap.OnMyLocationButtonClickListener;
import com.google.android.gms.maps.GoogleMap.OnMyLocationClickListener;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;


public class GPSactivity extends FragmentActivity
        implements OnMyLocationButtonClickListener,
        OnMyLocationClickListener,
        OnMapReadyCallback,
        GoogleMap.OnMarkerClickListener,
        ActivityCompat.OnRequestPermissionsResultCallback {


    private static final String IDIOMA = "idioma";

    private static final int LOCATION_PERMISSION_REQUEST_CODE = 1;


    private boolean mPermissionDenied = false;


    private GoogleMap mMap;
    private Marker mCinturon;
    private Marker mFabrica;
    private Marker mAyuntamiento;
    private Marker mIglesia;
    private Marker mFuente;
    private  float distance,distance1,distance2,distance3,distance4;

    private String[] nombre = new String[5];
    private float[] color = new float[5];
    private double[] longitud = new double[5];
    private double[] latitud = new double[5];
    private LatLng[] coordenadas = new LatLng[5];
    private Marcadores marcador;
    private Marcadores[] marcadores = new Marcadores[5];
    public double longitude;
    public double latitude;
    SupportMapFragment mapFragment;
    Location location;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.my_location);


        mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);


        Bundle datos = this.getIntent().getExtras();
        latitud = datos.getDoubleArray("latitud");
        longitud = datos.getDoubleArray("longitud");
        color = datos.getFloatArray("marcador");
        nombre = datos.getStringArray("nombre");

        for (int i = 0; i < 5; i++) {
            marcador = new Marcadores();
            marcador.setLatitud(latitud[i]);
            marcador.setLongitud(longitud[i]);
            marcador.setMarcador(color[i]);
            marcador.setNombre(nombre[i]);
            marcadores[i] = marcador;

            coordenadas[i] = new LatLng(latitud[i], longitud[i]);

        }

        HiloGps hola = new HiloGps(this);
        hola.start();

    }

    public void comprobar() {
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            return;
        }

        LocationManager locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);

        Criteria criteria = new Criteria();
             location = locationManager.getLastKnownLocation(locationManager
                    .getBestProvider(criteria, true));



            if (location != null) {
                latitude = location.getLatitude();
                longitude = location.getLongitude();

            }

            System.out.println(location);
            Location locationA = new Location("punto");

            locationA.setLatitude(latitude);
            locationA.setLongitude(longitude);

            Location locationB = new Location("punto");
            locationB.setLatitude(latitud[0]);
            locationB.setLongitude(longitud[0]);

            Location locationC = new Location("punto");
            locationC.setLatitude(latitud[1]);
            locationC.setLongitude(longitud[1]);

            Location locationD = new Location("punto");
            locationD.setLatitude(latitud[2]);
            locationD.setLongitude(longitud[2]);

            Location locationE = new Location("punto");
            locationE.setLatitude(latitud[3]);
            locationE.setLongitude(longitud[3]);

            Location locationF = new Location("punto");
            locationF.setLatitude(latitud[4]);
            locationF.setLongitude(longitud[4]);


            distance = locationA.distanceTo(locationB);
            distance1 = locationA.distanceTo(locationC);
            distance2 = locationA.distanceTo(locationD);
            distance3 = locationA.distanceTo(locationE);
            distance4 = locationA.distanceTo(locationF);


        }



    @Override
    public void onMapReady(GoogleMap map) {

        mMap = map;


        mMap.setOnMyLocationButtonClickListener(this);
        mMap.setOnMyLocationClickListener(this);

        enableMyLocation();

        // Show Sydney on the map.
        mMap.moveCamera(CameraUpdateFactory
                .newLatLngZoom(new LatLng(43.1813639, -2.9024153), 16));

        mCinturon = map.addMarker(new MarkerOptions()
                .position(coordenadas[1])
                .title(marcadores[1].getNombre())
                .icon(BitmapDescriptorFactory.defaultMarker(marcadores[1].getMarcador())));
        mCinturon.setTag(0);

        mAyuntamiento = map.addMarker(new MarkerOptions()
                .position(coordenadas[0])
                .title(marcadores[0].getNombre())
                .icon(BitmapDescriptorFactory.defaultMarker(marcadores[0].getMarcador())));

        mAyuntamiento.setTag(0);

        mIglesia = map.addMarker(new MarkerOptions()
                .position(coordenadas[4])
                .title(marcadores[4].getNombre())
                .icon(BitmapDescriptorFactory.defaultMarker(marcadores[4].getMarcador())));

        mIglesia.setTag(0);

        mFabrica = map.addMarker(new MarkerOptions()
                .position(coordenadas[2])
                .title(marcadores[2].getNombre())
                .icon(BitmapDescriptorFactory.defaultMarker(marcadores[2].getMarcador())));

        mFabrica.setTag(0);

        mFuente = map.addMarker(new MarkerOptions()
                .position(coordenadas[3])
                .title(marcadores[3].getNombre())
                .icon(BitmapDescriptorFactory.defaultMarker(marcadores[3].getMarcador())));
        mFuente.setTag(0);

        mMap.setOnMarkerClickListener(this);

    }



    public boolean onMarkerClick(final Marker marker) {
        Intent Lenguaje = getIntent();
        final String LENG;
        LENG =Lenguaje.getStringExtra(IDIOMA);

        if (distance>=0){
            if (marker.equals(mAyuntamiento)) {
                Intent TudankaP3 = new Intent(GPSactivity.this, TudankaP3.class);
                System.out.print(Lenguaje.getStringExtra(IDIOMA));
                if(LENG.equals("Castellano")){
                    TudankaP3.putExtra(IDIOMA, "Castellano");}else
                    TudankaP3.putExtra(IDIOMA, "Euskera");
                startActivity(TudankaP3);
            }
        }


        if (distance1>=0) {
            if (marker.equals(mCinturon)) {
                Intent TudankaP1 = new Intent(GPSactivity.this, TudankaP1.class);
                System.out.print(Lenguaje.getStringExtra(IDIOMA));
                if(LENG.equals("Castellano")){
                    TudankaP1.putExtra(IDIOMA, "Castellano");}else
                    TudankaP1.putExtra(IDIOMA, "Euskera");
                startActivity(TudankaP1);
            }
        }

        if (distance2>=0) {
            if (marker.equals(mFabrica)) {
                Intent TudankaP5 = new Intent(GPSactivity.this, TudankaP5.class);
                System.out.print(Lenguaje.getStringExtra(IDIOMA));
                if(LENG.equals("Castellano")){
                    TudankaP5.putExtra(IDIOMA, "Castellano");}else
                    TudankaP5.putExtra(IDIOMA, "Euskera");
                startActivity(TudankaP5);
            }
        }

        if (distance3>=0) {
            if (marker.equals(mFuente)) {
                Intent TudankaP4 = new Intent(GPSactivity.this, TudankaP4.class);
                System.out.print(Lenguaje.getStringExtra(IDIOMA));
                if(LENG.equals("Castellano")){
                    TudankaP4.putExtra(IDIOMA, "Castellano");}else
                    TudankaP4.putExtra(IDIOMA, "Euskera");
                startActivity(TudankaP4);
            }
        }
        if (distance4>=0) {
            if (marker.equals(mIglesia)) {
                Intent TudankaP2 = new Intent(GPSactivity.this, TudankaP2.class);

                System.out.print(Lenguaje.getStringExtra(IDIOMA));

                if(LENG.equals("Castellano")){
                    TudankaP2.putExtra(IDIOMA, "Castellano");}else
                    TudankaP2.putExtra(IDIOMA, "Euskera");
                startActivity(TudankaP2);
            }
        }

        return false;
    }

    private void enableMyLocation() {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED) {
            // Permission to access the location is missing.
            PermissionUtils.requestPermission(this, LOCATION_PERMISSION_REQUEST_CODE,
                    Manifest.permission.ACCESS_FINE_LOCATION, true);
        } else if (mMap != null) {
            // Access to the location has been granted to the app.
            mMap.setMyLocationEnabled(true);

        }
    }

    @Override
    public boolean onMyLocationButtonClick() {
        return false;
    }


    @Override
    public void onMyLocationClick(@NonNull Location location) {

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions,
                                           @NonNull int[] grantResults) {
        if (requestCode != LOCATION_PERMISSION_REQUEST_CODE) {
            return;
        }

        if (PermissionUtils.isPermissionGranted(permissions, grantResults,
                Manifest.permission.ACCESS_FINE_LOCATION)) {
            // Enable the my location layer if the permission has been granted.
            enableMyLocation();
        } else {
            // Display the missing permission error dialog when the fragments resume.
            mPermissionDenied = true;
        }
    }

    @Override
    protected void onResumeFragments() {
        super.onResumeFragments();
        if (mPermissionDenied) {
            // Permission was not granted, display error dialog.
            showMissingPermissionError();
            mPermissionDenied = false;
        }
    }


    private void showMissingPermissionError() {
        PermissionUtils.PermissionDeniedDialog
                .newInstance(true).show(getSupportFragmentManager(), "dialog");
    }



}
