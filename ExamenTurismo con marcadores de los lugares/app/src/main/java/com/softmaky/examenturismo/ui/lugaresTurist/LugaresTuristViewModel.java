package com.softmaky.examenturismo.ui.lugaresTurist;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.softmaky.examenturismo.Lugares.Lugar;
import com.softmaky.examenturismo.R;

import java.util.ArrayList;
import java.util.List;

public class LugaresTuristViewModel extends AndroidViewModel {
    private MutableLiveData<List<Lugar>> listaMutable;
    public LugaresTuristViewModel(@NonNull Application application) {
        super(application);
    }

    public LiveData<List<Lugar>>getListMuta(){
        if (listaMutable==null){
            listaMutable=new MutableLiveData<>();
        }
        return listaMutable;
    }

    public void crearLista(){
        ArrayList<Lugar> lugar=new ArrayList<>();
        lugar.add(new Lugar("Potrero de los Funes", -33.2404, -66.2846, "Potrero de los Funes es un destino turístico conocido por su lago y su circuito de carreras.","8:00 a 16:00 hs", R.drawable.pdelosfunes1,R.drawable.pdelosfunes2));
        lugar.add(new Lugar("Sierras de San Luis", -33.4000, -66.0000, "Las Sierras de San Luis ofrecen paisajes impresionantes y diversas actividades al aire libre.", "06:00 a 18:00",  R.drawable.sierras,R.drawable.sierras2));
        lugar.add(new Lugar("Balneario La Florida", -33.2500, -66.3000, "El Balneario La Florida es un lugar ideal para disfrutar del río y practicar deportes acuáticos.", "06:00 a 19:00",  R.drawable.laflorida,R.drawable.laflorida2));
        lugar.add(new Lugar("Villa de la Quebrada", -33.2333, -66.4167, "Villa de la Quebrada es famosa por su festival anual de folklore y su paisaje natural.", "09:00 a 20:00",  R.drawable.villadelaquebrada,R.drawable.villadelaquebrada2));
        lugar.add(new Lugar("El Trapiche", -33.2306, -66.2428, "El Trapiche es conocido por sus actividades al aire libre, como senderismo y paseos en bicicleta.", "06:00 a 00:00",R.drawable.trapiche,R.drawable.trapiche2));
        lugar.add(new Lugar("Merlo", -32.3422, -65.0022, "Merlo es una ciudad turística conocida por su microclima agradable y su oferta de actividades de aventura.","09:00 a 20:00",R.drawable.merlo,R.drawable.merlo2));
        lugar.add(new Lugar("Juana Koslay", -33.2897, -66.3497, "Juana Koslay es un lugar tranquilo con parques y áreas verdes, ideal para relajarse.", "09:00 a 21:00", R.drawable.jk,R.drawable.jk2));
        lugar.add(new Lugar("La Carolina", -32.4200, -66.2400, "La Carolina es un antiguo pueblo minero que ahora es un destino turístico con hermosos paisajes naturales.", "08:00 a 20:00", R.drawable.lacarolina,R.drawable.lacarolina2));
        lugar.add(new Lugar("Balde", -33.1547, -66.3211, "Balde es un pequeño pueblo que ofrece tranquilidad y paisajes naturales, ideal para el turismo rural.", "11:00 A 22:00 HS", R.drawable.balde,R.drawable.balde2));
        lugar.add(new Lugar("San Gerónimo", -33.4400, -65.8600, "San Gerónimo es conocido por su historia colonial y su iglesia centenaria, además de sus hermosos paisajes serranos.", "09:00 A 17:00", R.drawable.sangero,R.drawable.sangero2));
        lugar.add(new Lugar("Salinas del Bebedero", -33.0555, -66.0513, "Las Salinas del Bebedero son una reserva natural de gran importancia, conocida por sus salares y su biodiversidad.", "10:00 a 16:00", R.drawable.salinas,R.drawable.salinas2));
        listaMutable.setValue(lugar);
    }
}