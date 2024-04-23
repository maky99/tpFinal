package com.softmaky.examenturismo.ui.lugaresTurist;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridLayout;

import com.softmaky.examenturismo.Lugares.Lugar;
import com.softmaky.examenturismo.R;
import com.softmaky.examenturismo.databinding.FragmentLugaresTuristBinding;
import com.softmaky.examenturismo.databinding.FragmentMapsBinding;

import java.util.List;

public class LugaresTuristFragment extends Fragment {

    private LugaresTuristViewModel mViewModel;
    private FragmentLugaresTuristBinding binding;

    public static LugaresTuristFragment newInstance() {
        return new LugaresTuristFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding=FragmentLugaresTuristBinding.inflate(getLayoutInflater());
        mViewModel=new ViewModelProvider(this).get(LugaresTuristViewModel.class);

        mViewModel.getListMuta().observe(getViewLifecycleOwner(), new Observer<List<Lugar>>() {
            @Override
            public void onChanged(List<Lugar> lugars) {
                LugareTurisAdapter lugAda=new LugareTurisAdapter(lugars,getContext(),getLayoutInflater());
                GridLayoutManager glm=new GridLayoutManager(getContext(),2,GridLayoutManager.VERTICAL,false);
                RecyclerView rc=binding.lugaresListado;
                rc.setLayoutManager(glm);
                rc.setAdapter(lugAda);

            }
        });
        mViewModel.crearLista();

        return binding.getRoot();
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(LugaresTuristViewModel.class);
        // TODO: Use the ViewModel
    }

}