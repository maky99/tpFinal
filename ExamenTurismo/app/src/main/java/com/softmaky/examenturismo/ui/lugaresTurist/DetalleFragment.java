package com.softmaky.examenturismo.ui.lugaresTurist;

import static android.content.Intent.getIntent;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.softmaky.examenturismo.DetalleViewModel;
import com.softmaky.examenturismo.Lugares.Lugar;
import com.softmaky.examenturismo.R;
import com.softmaky.examenturismo.databinding.FragmentDetalleBinding;

public class DetalleFragment extends AppCompatActivity {

    private DetalleFragmentViewModel mViewModel;
    private FragmentDetalleBinding bindig;

    public static DetalleFragment newInstance() {
        return new DetalleFragment();
    }


    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        bindig=FragmentDetalleBinding.inflate(getLayoutInflater());
        mViewModel=new ViewModelProvider(this).get(DetalleFragmentViewModel.class);
        mViewModel.getLugarMutable().observe(this, new Observer<Lugar>() {
            @Override
            public void onChanged(Lugar lugar) {
                TextView titulo=bindig.tvTitulo;
                ImageView foto1=bindig.ivImagen1;
                ImageView foto2=bindig.ivImagen2;
                TextView detalle=bindig.tvDetalle;
                TextView horario=bindig.tvHorario;
                titulo.setText(lugar.getNombre());
                foto1.setImageResource(lugar.getFoto());
                foto2.setImageResource(lugar.getFoto());
                detalle.setText(lugar.getDescripcion());
                horario.setText(lugar.getHorario());
            }
        });
        mViewModel.recuperoInformacion(getIntent());

        return inflater.inflate(R.layout.fragment_detalle, container, false);
    }

/*
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(DetalleViewModel.class);
        // TODO: Use the ViewModel
    }*/

}