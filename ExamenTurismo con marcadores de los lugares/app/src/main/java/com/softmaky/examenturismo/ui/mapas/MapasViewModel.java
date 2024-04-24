package com.softmaky.examenturismo.ui.mapas;

import android.Manifest;
import android.app.Application;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Build;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.google.android.gms.location.*;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.softmaky.examenturismo.Lugares.LugTuris;
import com.softmaky.examenturismo.Lugares.Lugar;
import com.softmaky.examenturismo.R;

import java.util.ArrayList;
import java.util.List;

public class MapasViewModel extends AndroidViewModel {

    private MutableLiveData<Location> mLocation;
    private MutableLiveData<List<LugTuris>> mutLugTuris;

    private FusedLocationProviderClient fused;
    private LocationCallback callback;


    public MapasViewModel(@NonNull Application application) {
        super(application);
        fused = LocationServices.getFusedLocationProviderClient(getApplication());
        mutLugTuris = new MutableLiveData<>();
    }

    public LiveData<Location> getMutLocation() {

        if (mLocation == null) {
            this.mLocation = new MutableLiveData<>();
        }
        return mLocation;
    }

    public void obtenerUltimaUbicacion() {

        if (ActivityCompat.checkSelfPermission(getApplication(), Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(getApplication(), Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            Log.d("salida ", "Sin permisos");
            return;
        }
        Task<Location> tarea = fused.getLastLocation();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
            tarea.addOnSuccessListener(getApplication().getMainExecutor(), new OnSuccessListener<Location>() {
                @Override
                public void onSuccess(Location location) {
                    if (location != null) {
                        mLocation.postValue(location);
                    }
                }
            });
        }

    }


    public void lecturaPermanete() {
        com.google.android.gms.location.LocationRequest request = new LocationRequest.Builder(Priority.PRIORITY_HIGH_ACCURACY, 5000).build();
        callback = new LocationCallback() {
            @Override
            public void onLocationResult(@NonNull LocationResult locationResult) {
                if (locationResult == null) {
                    return;
                }
                Location location = locationResult.getLastLocation();
                mLocation.postValue(location);
            }
        };
        if (ActivityCompat.checkSelfPermission(getApplication(), Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(getApplication(), Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        fused.requestLocationUpdates(request, callback, null);
    }
    public void pararLecturaPermanete(){
        fused.removeLocationUpdates(callback);

    }

    public MutableLiveData<List<LugTuris>> getMutLugTuris(){
        if (mutLugTuris==null){
            mutLugTuris=new MutableLiveData<>();
        }
        return mutLugTuris;
    }

    public void crearLista(){
        ArrayList<LugTuris> lugtur=new ArrayList<>();
        lugtur.add(new LugTuris("Potrero de los Funes",-33.2404,-66.2846));
        lugtur.add(new LugTuris("Sierras de San Luis", -33.4000, -66.0000));
        lugtur.add(new LugTuris("Balneario La Florida", -33.2500, -66.3000));
        lugtur.add(new LugTuris("Villa de la Quebrada", -33.2333, -66.4167));
        lugtur.add(new LugTuris("El Trapiche", -33.2306, -66.2428));
        lugtur.add(new LugTuris("Merlo", -32.3422, -65.0022));
        lugtur.add(new LugTuris("Juana Koslay", -33.2897, -66.3497));
        lugtur.add(new LugTuris("La Carolina", -32.4200, -66.2400));
        lugtur.add(new LugTuris("Balde", -33.1547, -66.3211));
        lugtur.add(new LugTuris("San Gerónimo", -33.4400, -65.8600));
        lugtur.add(new LugTuris("Salinas del Bebedero", -33.0555, -66.0513));
        mutLugTuris.setValue(lugtur);
    }

}