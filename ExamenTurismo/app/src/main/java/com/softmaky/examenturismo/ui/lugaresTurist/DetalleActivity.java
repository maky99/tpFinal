package com.softmaky.examenturismo.ui.lugaresTurist;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.softmaky.examenturismo.Lugares.Lugar;
import com.softmaky.examenturismo.R;
import com.softmaky.examenturismo.databinding.ActivityDetalleBinding;

public class DetalleActivity extends AppCompatActivity {

    private DetalleFragmentViewModel mViewModel;
    private ActivityDetalleBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        binding=ActivityDetalleBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        mViewModel= ViewModelProvider.AndroidViewModelFactory.getInstance(getApplication()).create(DetalleFragmentViewModel.class);
        mViewModel.getLugarMutable().observe(this, new Observer<Lugar>() {
            @Override
            public void onChanged(Lugar lugar) {
                TextView titulo=binding.tvTitulo;
                ImageView foto1=binding.ivImagen1;
                ImageView foto2=binding.ivImagen2;
                TextView detalle=binding.tvDetalle;
                TextView horario=binding.tvHorario;
                titulo.setText(lugar.getNombre());
                foto1.setImageResource(lugar.getFoto());
                foto2.setImageResource(lugar.getFoto());
                detalle.setText(lugar.getDescripcion());
                horario.setText(lugar.getHorario());
            }
        });
        mViewModel.recuperoInformacion(getIntent());
        Button bt=findViewById(R.id.btVolver);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DetalleActivity.this, LugaresTuristViewModel.class);
                startActivity(intent);
            }
        });

    }
}