package com.softmaky.examenturismo.ui.lugaresTurist;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.softmaky.examenturismo.Lugares.Lugar;
import com.softmaky.examenturismo.R;
import com.softmaky.examenturismo.databinding.FragmentConfiguracionBinding;
import com.softmaky.examenturismo.databinding.FragmentLugaresTuristBinding;
import com.softmaky.examenturismo.ui.configuracion.ConfiguracionViewModel;

import java.util.List;

public class LugaresTuristFragment extends Fragment {
    private FragmentLugaresTuristBinding binding;
    private FragmentConfiguracionBinding bin;
    private ConfiguracionViewModel conVM;


    public static LugaresTuristFragment newInstance() {
        return new LugaresTuristFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        conVM=new ViewModelProvider(this).get(ConfiguracionViewModel.class);
        LugaresTuristViewModel mv=new ViewModelProvider(this).get(LugaresTuristViewModel.class);

        binding=FragmentLugaresTuristBinding.inflate(inflater,container,false);
        View root=binding.getRoot();

        bin=FragmentConfiguracionBinding.inflate(inflater,container,false);
        bin.rbIngles.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                Log.d("pepa","seleccionad");
                //return root;

            } else {
                Log.d("pepa2", "verdad");
                mv.getListMuta().observe(getViewLifecycleOwner(), new Observer<List<Lugar>>() {
                    @Override
                    public void onChanged(List<Lugar> lugars) {
                        LugareTurisAdapter lugAda=new LugareTurisAdapter(requireContext(),R.layout.card,lugars,getLayoutInflater());
                        RecyclerView rv =binding.lugaresListado;
                        GridLayoutManager glm =new GridLayoutManager((getContext()),2,GridLayoutManager.VERTICAL,false);
                        rv.setLayoutManager(glm);
                        rv.setAdapter(lugAda);
                    }
                });
                mv.crearLista();

            }
        });
        conVM.getMutListInlge().observe(getViewLifecycleOwner(), new Observer<List<Lugar>>() {
            @Override
            public void onChanged(List<Lugar> lugars) {
                LugareTurisAdapter lugIng=new LugareTurisAdapter(requireContext(),R.layout.card,lugars,getLayoutInflater());
                RecyclerView rv=binding.lugaresListado;
                GridLayoutManager glm=new GridLayoutManager((getContext()),2,GridLayoutManager.VERTICAL,false);
                rv.setLayoutManager(glm);
                rv.setAdapter(lugIng);
            }
        });
        conVM.crearListaInlge();
        return root;
    }

@Override
public void onDestroyView(){
        super.onDestroyView();
        binding=null;
}

}