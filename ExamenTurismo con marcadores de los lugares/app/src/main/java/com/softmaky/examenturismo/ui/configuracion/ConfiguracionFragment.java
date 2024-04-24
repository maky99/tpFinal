package com.softmaky.examenturismo.ui.configuracion;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.softmaky.examenturismo.R;
import com.softmaky.examenturismo.databinding.FragmentConfiguracionBinding;

public class ConfiguracionFragment extends Fragment {

    private ConfiguracionViewModel mViewModel;
    private FragmentConfiguracionBinding binding;

    public static ConfiguracionFragment newInstance() {
        return new ConfiguracionFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = FragmentConfiguracionBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        binding.rbIngles.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {

                // Actualiza el ViewModel con el estado del idioma inglés seleccionado
                Log.d("pepe", "verdad");
            } else {
                // Si el RadioButton no está seleccionado, puedes manejarlo aquí
                Log.d("pepe", "en el else");
            }
        });


        return root;
    }



    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(ConfiguracionViewModel.class);
        // TODO: Use the ViewModel
    }


}