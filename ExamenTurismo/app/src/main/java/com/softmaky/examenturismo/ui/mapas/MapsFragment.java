package com.softmaky.examenturismo.ui.mapas;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationResult;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.location.Priority;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.softmaky.examenturismo.Lugares.LugTuris;
import com.softmaky.examenturismo.R;
import com.softmaky.examenturismo.databinding.FragmentMapsBinding;

import java.util.List;

public class MapsFragment extends Fragment {
    private MapasViewModel mapasViewModel ;

    private OnMapReadyCallback callback = new OnMapReadyCallback() {




        /**
         * Manipulates the map once available.
         * This callback is triggered when the map is ready to be used.
         * This is where we can add markers or lines, add listeners or move the camera.
         * In this case, we just add a marker near Sydney, Australia.
         * If Google Play services is not installed on the device, the user will be prompted to
         * install it inside the SupportMapFragment. This method will only be triggered once the
         * user has installed Google Play services and returned to the app.
         */
        @Override
        public void onMapReady(GoogleMap googleMap) {
            lecturaPermanete(googleMap);

            mapasViewModel.getMutLugTuris().observe(getViewLifecycleOwner(), new Observer<List<LugTuris>>() {
                @Override
                public void onChanged(List<LugTuris> lugTurises) {
                    for (LugTuris lugar : lugTurises) {
                        LatLng turismo = new LatLng(lugar.getLatitud(), lugar.getLongitud());
                        googleMap.addMarker(new MarkerOptions().position(turismo).title(lugar.getNombre()));
                    }
                }
            });
        }
    };

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View root= inflater.inflate(R.layout.fragment_maps, container, false);
        mapasViewModel = new ViewModelProvider(this).get(MapasViewModel.class);
        mapasViewModel.crearLista();
        return root;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mapasViewModel = new ViewModelProvider(this).get(MapasViewModel.class);
        SupportMapFragment mapFragment =
                (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.map);
        if (mapFragment != null) {
            mapFragment.getMapAsync(callback);
        }
    }
    public void lecturaPermanete(GoogleMap googleMap) {
        com.google.android.gms.location.LocationRequest request = new LocationRequest.Builder(Priority.PRIORITY_HIGH_ACCURACY, 5000).build();
        LocationCallback callback =  new LocationCallback() {
            @Override
            public void onLocationResult(@NonNull LocationResult locationResult) {
                if (locationResult == null || googleMap == null) {
                    return;
                }
                Location location = locationResult.getLastLocation();
                LatLng currentLocation = new LatLng(location.getLatitude(), location.getLongitude());
                googleMap.addMarker(new MarkerOptions().position(currentLocation).title("mi ubicación"));
                float zoomLevel = 10.0f;
                googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(currentLocation, zoomLevel));
                //googleMap.moveCamera(CameraUpdateFactory.newLatLng(currentLocation));
                googleMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE);

            }
        };
        if (ActivityCompat.checkSelfPermission(getContext(), Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(getContext(), Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        LocationServices.getFusedLocationProviderClient(requireActivity()).requestLocationUpdates(request, callback, null);
    }

}