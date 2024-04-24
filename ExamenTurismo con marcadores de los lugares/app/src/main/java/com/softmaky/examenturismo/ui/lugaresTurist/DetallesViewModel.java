package com.softmaky.examenturismo.ui.lugaresTurist;

import android.app.Application;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.softmaky.examenturismo.Lugares.Lugar;
import com.softmaky.examenturismo.databinding.FragmentDetallesBinding;

public class DetallesViewModel extends AndroidViewModel {

    private MutableLiveData<Lugar> mutaLugar;



    public DetallesViewModel(@NonNull Application application) {
        super(application);
    }


    public LiveData<Lugar>getMutableLugar(){
        if (mutaLugar==null){
            mutaLugar=new MutableLiveData<>();
        }
        return mutaLugar;
    }



    public void recuperoLugar (Bundle bundle){
        Lugar lugar=null;
        if (bundle!=null){
            lugar=(Lugar) bundle.getSerializable("recuperadolugar");
        }
        if (lugar!=null){
            mutaLugar.setValue(lugar);
        }
    }

}