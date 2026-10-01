package com.example.componentesgrupo2;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.android.material.dialog.MaterialAlertDialogBuilder;

/*
 * Vista "Noticias".
 * Se abre desde el Navigation Drawer.
 * Su diseño está en res/layout/fragment_noticias.xml
 */
public class NoticiasFragment extends Fragment {

    public NoticiasFragment() {
        // Constructor vacío obligatorio
    }


    @Nullable
    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater,
            @Nullable ViewGroup container,
            @Nullable Bundle savedInstanceState
    ) {

        // Carga el diseño XML de esta vista
        return inflater.inflate(
                R.layout.fragment_noticias,
                container,
                false
        );
    }


    @Override
    public void onViewCreated(
            @NonNull View view,
            @Nullable Bundle savedInstanceState
    ) {

        super.onViewCreated(view, savedInstanceState);


        // =====================================================
        // TARJETAS
        // =====================================================

        // Al tocar cada noticia se abre su información completa
        configurarTarjeta(view, R.id.cardNoticia1, R.id.txtTitulo1, R.id.txtInfo1, R.id.txtExtra1, R.id.txtDescripcion1);
        configurarTarjeta(view, R.id.cardNoticia2, R.id.txtTitulo2, R.id.txtInfo2, R.id.txtExtra2, R.id.txtDescripcion2);
        configurarTarjeta(view, R.id.cardNoticia3, R.id.txtTitulo3, R.id.txtInfo3, R.id.txtExtra3, R.id.txtDescripcion3);
        configurarTarjeta(view, R.id.cardNoticia4, R.id.txtTitulo4, R.id.txtInfo4, R.id.txtExtra4, R.id.txtDescripcion4);
    }


    // =========================================================
    // ABRIR UNA TARJETA AL TOCARLA
    // =========================================================

    private void configurarTarjeta(
            View view,
            int idTarjeta,
            int idTitulo,
            int idInfo,
            int idExtra,
            int idDescripcion
    ) {

        View tarjeta = view.findViewById(idTarjeta);

        TextView titulo = view.findViewById(idTitulo);
        TextView info = view.findViewById(idInfo);
        TextView extra = view.findViewById(idExtra);
        TextView descripcion = view.findViewById(idDescripcion);

        tarjeta.setOnClickListener(v -> {

            // En la tarjeta la descripción se ve cortada,
            // pero getText() devuelve el texto completo
            String mensaje = info.getText()
                    + "  ·  " + extra.getText()
                    + "\n\n" + descripcion.getText();

            new MaterialAlertDialogBuilder(requireContext())
                    .setTitle(titulo.getText())
                    .setMessage(mensaje)
                    .setPositiveButton(R.string.btn_cerrar, null)
                    .show();
        });
    }
}
