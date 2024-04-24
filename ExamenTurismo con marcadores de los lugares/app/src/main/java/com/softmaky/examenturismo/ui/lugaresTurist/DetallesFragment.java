package com.softmaky.examenturismo.ui.lugaresTurist;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.softmaky.examenturismo.Lugares.Lugar;
import com.softmaky.examenturismo.R;
import com.softmaky.examenturismo.databinding.FragmentDetallesBinding;

public class DetallesFragment extends Fragment {

    private DetallesViewModel mViewModel;
    private FragmentDetallesBinding binding;

    public static DetallesFragment newInstance() {
        return new DetallesFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding= FragmentDetallesBinding.inflate(inflater,container,false);
        View root=binding.getRoot();
        mViewModel=new ViewModelProvider(this).get(DetallesViewModel.class);
        mViewModel.getMutableLugar().observe(getViewLifecycleOwner(), new Observer<Lugar>() {
            @Override
            public void onChanged(Lugar lugar) {
                binding.tvTitulo.setText(lugar.getNombre());
                binding.ivImagen1.setImageResource(lugar.getFoto());
                binding.ivImagen2.setImageResource(lugar.getFoto2());
                binding.tvDetalle.setText(lugar.getDescripcion());
                binding.tvHorario.setText(lugar.getHorario());
            }
        });
        mViewModel.recuperoLugar(getArguments());

        return root;
    }

}