
package com.softmaky.examenturismo.ui.mapas;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.location.Location;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.softmaky.examenturismo.R;
import com.softmaky.examenturismo.databinding.FragmentMapasBinding;

public class MapasFragment extends Fragment {

    private MapasViewModel mViewModel;
    private FragmentMapasBinding binding;
    private MapasViewModel mapasViewModel;

    public static MapasFragment newInstance() {
        return new MapasFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        mapasViewModel=new ViewModelProvider(this).get(MapasViewModel.class);
        binding=FragmentMapasBinding.inflate(inflater,container,false);
        View root=binding.getRoot();
        final TextView textView=binding.tvMapa;
        mapasViewModel.getMutLocation().observe(getViewLifecycleOwner(), new Observer<Location>() {
            @Override
            public void onChanged(Location location) {
                textView.setText("Latitud " + location.getLatitude() + "longitud" + location.getLatitude());

            }
        });
        //mapasViewModel.lecturaPermanete();
        mapasViewModel.crearLista();
        //mapasViewModel.obtenerUltimaUbicacion();//aca tengo mi ubicacion en lat y long
        return root;


        //return inflater.inflate(R.layout.fragment_mapas, container, false);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mapasViewModel.pararLecturaPermanete();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(MapasViewModel.class);
        // TODO: Use the ViewModel
    }

}
