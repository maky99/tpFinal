package com.softmaky.examenturismo.ui.salir;

import android.content.Context;
import android.content.DialogInterface;

import androidx.appcompat.app.AlertDialog;

public class DialogoSalir {
    public static void mostrarDialogo(Context context) {
        new AlertDialog.Builder(context)
                .setTitle("Confirmar salida")
                .setMessage("¿Desea salir? Si o no")
                .setPositiveButton("Si", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        System.exit(0);
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                })
                .show();
    }
}