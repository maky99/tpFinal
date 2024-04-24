package com.softmaky.examenturismo.ui.configuracion;

import android.app.Application;
import android.util.Log;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.softmaky.examenturismo.Lugares.Lugar;
import com.softmaky.examenturismo.R;
import com.softmaky.examenturismo.databinding.FragmentConfiguracionBinding;

import java.util.ArrayList;
import java.util.List;

public class ConfiguracionViewModel extends AndroidViewModel {
    private MutableLiveData<List<Lugar>> listMutIngle;
    private ConfiguracionViewModel viewModel;
    private FragmentConfiguracionBinding binding;
    public ConfiguracionViewModel(@NonNull Application application) {
        super(application);
    }


    public LiveData<List<Lugar>>getMutListInlge(){

        if (listMutIngle==null){
            listMutIngle=new MutableLiveData<>();
        }
        return listMutIngle;
    }
    public void crearListaInlge() {
        ArrayList<Lugar> place = new ArrayList<>();
        place.add(new Lugar("Potrero de los Funes", -33.2404, -66.2846, "Potrero de los Funes is a tourist destination known for its lake and racing circuit.", "8:00 AM to 4:00 PM", R.drawable.pdelosfunes1, R.drawable.pdelosfunes2));
        place.add(new Lugar("Sierras de San Luis", -33.4000, -66.0000, "The Sierras de San Luis offer impressive landscapes and various outdoor activities.", "06:00 AM to 6:00 PM", R.drawable.sierras, R.drawable.sierras2));
        place.add(new Lugar("Balneario La Florida", -33.2500, -66.3000, "Balneario La Florida is an ideal place to enjoy the river and practice water sports.", "06:00 AM to 7:00 PM", R.drawable.laflorida, R.drawable.laflorida2));
        place.add(new Lugar("Villa de la Quebrada", -33.2333, -66.4167, "Villa de la Quebrada is famous for its annual folklore festival and natural landscape.", "09:00 AM to 8:00 PM", R.drawable.villadelaquebrada, R.drawable.villadelaquebrada2));
        place.add(new Lugar("El Trapiche", -33.2306, -66.2428, "El Trapiche is known for its outdoor activities such as hiking and biking.", "06:00 AM to 12:00 AM", R.drawable.trapiche, R.drawable.trapiche2));
        place.add(new Lugar("Merlo", -32.3422, -65.0022, "Merlo is a tourist town known for its pleasant microclimate and adventure activities.", "09:00 AM to 8:00 PM", R.drawable.merlo, R.drawable.merlo2));
        place.add(new Lugar("Juana Koslay", -33.2897, -66.3497, "Juana Koslay is a quiet place with parks and green areas, ideal for relaxation.", "09:00 AM to 9:00 PM", R.drawable.jk, R.drawable.jk2));
        place.add(new Lugar("La Carolina", -32.4200, -66.2400, "La Carolina is an old mining town that is now a tourist destination with beautiful natural landscapes.", "08:00 AM to 8:00 PM", R.drawable.lacarolina, R.drawable.lacarolina2));
        place.add(new Lugar("Balde", -33.1547, -66.3211, "Balde is a small town that offers tranquility and natural landscapes, ideal for rural tourism.", "11:00 AM to 10:00 PM", R.drawable.balde, R.drawable.balde2));
        place.add(new Lugar("San Gerónimo", -33.4400, -65.8600, "San Gerónimo is known for its colonial history and centuries-old church, as well as its beautiful mountain landscapes.", "09:00 AM to 5:00 PM", R.drawable.sangero, R.drawable.sangero2));
        place.add(new Lugar("Salinas del Bebedero", -33.0555, -66.0513, "Salinas del Bebedero is a nature reserve of great importance, known for its salt flats and biodiversity.", "10:00 AM to 4:00 PM", R.drawable.salinas, R.drawable.salinas2));
        listMutIngle.setValue(place);
    }





}