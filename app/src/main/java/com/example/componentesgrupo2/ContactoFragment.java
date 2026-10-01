package com.example.componentesgrupo2;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

/*
 * Vista "Contacto".
 * Se abre desde el Navigation Drawer.
 * Su diseño está en res/layout/fragment_contacto.xml
 * (solo muestra información, por eso no necesita más código)
 */
public class ContactoFragment extends Fragment {

    public ContactoFragment() {
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
                R.layout.fragment_contacto,
                container,
                false
        );
    }
}
