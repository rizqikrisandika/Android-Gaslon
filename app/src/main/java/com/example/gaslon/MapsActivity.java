package com.example.gaslon;

import androidx.fragment.app.FragmentActivity;

import android.location.Address;
import android.location.Geocoder;
import android.os.Bundle;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.Polyline;

import java.util.List;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private MarkerOptions place1, place2;
    Polyline curPolyline;
    private static final int MAX_RESULTS = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        MapFragment mapFragment = (MapFragment) getFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        place1 = new MarkerOptions().position(new LatLng(-7.702020, 110.408962)).title("Toko 1");
        place2 = new MarkerOptions().position(new LatLng(-7.702020, 110.408962)).title("Toko 1");

    }

    private String getUrl(LatLng origin, LatLng dest, String directionMode) {
        //origin of route
        String str_origin = "origin=" + origin.latitude + "," + origin.longitude;
        //Destination of route
        String str_dest = "destination=" + dest.latitude + "," + dest.longitude;
        //mode
        String mode = "node=" + directionMode;
        //building the parameter to the web services
        String parameters = str_origin + "&" +str_dest + "&" + mode;
        //output format
        String output = "json";
        //building the url to the web service
        String url = "https://maps.googleapis.com/maps/api/directions/" + output + "?" + parameters + "&key" + getString(R.string.google_maps_key);
        return url;
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

        // Add a marker in Sydney and move the camera
        LatLng sydney = new LatLng(-6.117664, 106.906349);
        mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(sydney,15f));
    }

    private LatLng getLatLngFromAddress(String address){
        Geocoder coder = new Geocoder(this);
        List<Address> addresses;

        try {
            addresses = coder.getFromLocationName(address,MAX_RESULTS);
            if (addresses == null){
                return null;
            }
            Address location = addresses.get(0);

            return new LatLng(location.getLatitude(), location.getLongitude());
        } catch (Exception e){
            Toast.makeText(this,"An error occured: "+e.toString(), Toast.LENGTH_SHORT).show();
            e.printStackTrace();
        }
        return null;
    }
}
