package com.example.gaslon;

import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.os.Bundle;
import android.widget.Toast;

import androidx.core.app.ActivityCompat;
import androidx.fragment.app.FragmentActivity;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.List;

import javax.annotation.Nonnull;


public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private static final int MAX_RESULT = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        /*** ERROR HERE ***/
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    private LatLng getLatlngFromAddress(String address){
        Geocoder coder = new Geocoder(this);
        List<Address> addresses;
        try {
            addresses = coder.getFromLocationName(address, MAX_RESULT);
            if(addresses==null){
                return null;
            }
            Address location = addresses.get(0);

            return new LatLng(location.getLatitude(),location.getLongitude());
        }catch (Exception e){
            Toast.makeText(this, "Error : "+e.toString(),Toast.LENGTH_SHORT).show();
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        LatLng address = getLatlngFromAddress("Amikom");
        if (address != null){
            googleMap.addMarker(new MarkerOptions().position(address).title("RUMAH"));
            float zoomlevel = 20.0f;
            googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(address, zoomlevel));
        }

        requestLocationPermission();
        if (ActivityCompat.checkSelfPermission(this,Manifest.permission.ACCESS_FINE_LOCATION)== PackageManager.PERMISSION_GRANTED){
            enableMyLocationButton();
        }

        // Add a marker in Sydney and move the camera
        //LatLng amikom = new LatLng(-7.759582, 110.40828);
        //mMap.addMarker(new MarkerOptions().position(amikom).title("Marker in Sydney"));
        //mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(amikom, 14f));
    }

    private void enableMyLocationButton(){
        mMap.setMyLocationEnabled(true);
        mMap.setOnMyLocationButtonClickListener(new GoogleMap.OnMyLocationButtonClickListener() {
            @Override
            public boolean onMyLocationButtonClick() {
                Toast.makeText(MapsActivity.this,"Lokasi anda saat ini", Toast.LENGTH_SHORT).show();
                return false;
            }
        });
    }

    private static final int REQUEST_CODE_LOCATION = 0;

    private void requestLocationPermission(){
        if(ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)!= PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION},REQUEST_CODE_LOCATION);
        }
    }
    private void onRequestPermissionResult(int requestcode, @Nonnull String[] permissions,@Nonnull int[] grantResult){
        super.onRequestPermissionsResult(requestcode,permissions,grantResult);
        if (requestcode==REQUEST_CODE_LOCATION && grantResult.length>0 && grantResult[0] == PackageManager.PERMISSION_GRANTED){
            enableMyLocationButton();
        }
    }
}