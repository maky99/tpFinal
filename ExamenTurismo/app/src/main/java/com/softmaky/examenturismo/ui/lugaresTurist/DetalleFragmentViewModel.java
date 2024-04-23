package com.softmaky.examenturismo.ui.lugaresTurist;

import android.app.Application;
import android.content.Intent;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.softmaky.examenturismo.Lugares.Lugar;

public class DetalleFragmentViewModel extends AndroidViewModel {

    private MutableLiveData<Lugar> lugarMutable;

    public DetalleFragmentViewModel(@NonNull Application application) {
        super(application);
    }

    public LiveData<Lugar> getLugarMutable(){

        if (lugarMutable==null){
            this.lugarMutable=new MutableLiveData<>();
        }
        return lugarMutable;
    }

    public void recuperoInformacion(Intent intent){
        Lugar lugar=(Lugar)intent.getSerializableExtra("lugare");
        if (lugar!=null){
            lugarMutable.setValue(lugar);
        }

    }
}
