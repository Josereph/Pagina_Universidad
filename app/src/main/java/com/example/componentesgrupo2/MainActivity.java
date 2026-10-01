package com.example.componentesgrupo2;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import androidx.activity.OnBackPressedCallback;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.google.android.material.navigation.NavigationView;

/*
 * Actividad principal (app informativa de la universidad).
 * Aquí están los dos componentes del Grupo 2:
 *   1) Navigation Drawer (DrawerLayout + NavigationView) -> cambia entre las vistas
 *   2) Toolbar usada como ActionBar con su menú de opciones -> buscar, compartir, acerca de, salir
 */
public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private static final String KEY_TITULO = "titulo_actual";

    private DrawerLayout drawerLayout;
    private NavigationView navigationView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);


        // =====================================================
        // ESPACIO PARA LAS BARRAS DEL TELÉFONO
        // =====================================================

        // En Android 15+ la app se dibuja de borde a borde.
        // Arriba dejamos espacio para la barra de estado (se ve el degradado)
        // y abajo para la barra de navegación (se ve el fondo claro).
        View contenido = findViewById(R.id.contenido_principal);
        View contenedor = findViewById(R.id.contenedor_fragment);

        ViewCompat.setOnApplyWindowInsetsListener(contenido, (v, insets) -> {
            Insets barras = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(barras.left, barras.top, barras.right, 0);
            contenedor.setPadding(0, 0, 0, barras.bottom);
            return insets;
        });


        // =====================================================
        // COMPONENTE 2: TOOLBAR COMO ACTIONBAR
        // =====================================================

        MaterialToolbar toolbar = findViewById(R.id.toolbar);

        // La Toolbar reemplaza a la ActionBar clásica
        setSupportActionBar(toolbar);


        // =====================================================
        // COMPONENTE 1: NAVIGATION DRAWER
        // =====================================================

        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);

        // Escucha los toques en las opciones del menú lateral
        navigationView.setNavigationItemSelectedListener(this);

        // El "toggle" dibuja el ícono de hamburguesa en la Toolbar
        // y abre / cierra el menú al tocarlo
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this,
                drawerLayout,
                toolbar,
                R.string.drawer_abrir,
                R.string.drawer_cerrar
        );

        drawerLayout.addDrawerListener(toggle);

        // Sincroniza el ícono con el estado (abierto / cerrado)
        toggle.syncState();


        // =====================================================
        // VISTA INICIAL
        // =====================================================

        if (savedInstanceState == null) {

            // Primera vez que se abre la app: mostramos Carreras
            mostrarVista(new CarrerasFragment(), getString(R.string.menu_carreras));
            navigationView.setCheckedItem(R.id.nav_carreras);

        } else {

            // Si se giró la pantalla, recuperamos el título
            setTitle(savedInstanceState.getCharSequence(KEY_TITULO));
        }


        // =====================================================
        // BOTÓN ATRÁS
        // =====================================================

        // Si el menú lateral está abierto, "atrás" primero lo cierra
        getOnBackPressedDispatcher().addCallback(this, new OnBackPressedCallback(true) {
            @Override
            public void handleOnBackPressed() {

                if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
                    drawerLayout.closeDrawer(GravityCompat.START);
                } else {
                    setEnabled(false);
                    getOnBackPressedDispatcher().onBackPressed();
                }
            }
        });
    }


    // =========================================================
    // CLIC EN UNA OPCIÓN DEL NAVIGATION DRAWER
    // =========================================================

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        int id = item.getItemId();

        // Se usa if / else porque en proyectos nuevos
        // los R.id ya no son constantes (no sirven en switch)
        if (id == R.id.nav_carreras) {
            mostrarVista(new CarrerasFragment(), getString(R.string.menu_carreras));

        } else if (id == R.id.nav_noticias) {
            mostrarVista(new NoticiasFragment(), getString(R.string.menu_noticias));

        } else if (id == R.id.nav_contacto) {
            mostrarVista(new ContactoFragment(), getString(R.string.menu_contacto));

        } else if (id == R.id.nav_acerca) {
            mostrarAcercaDe();
        }

        // Cerramos el menú después de elegir
        drawerLayout.closeDrawer(GravityCompat.START);

        // "Acerca de" no es una vista, así que no la dejamos marcada
        return id != R.id.nav_acerca;
    }


    // =========================================================
    // CAMBIAR DE VISTA (FRAGMENT)
    // =========================================================

    private void mostrarVista(Fragment vista, String titulo) {

        // Reemplaza lo que haya en el contenedor por la nueva vista
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.contenedor_fragment, vista)
                .commit();

        // El título de la Toolbar cambia según la vista
        setTitle(titulo);
    }


    // =========================================================
    // MENÚ DE OPCIONES DE LA TOOLBAR: CARGAR
    // =========================================================

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        // "Infla" (carga) el archivo res/menu/toolbar_menu.xml
        getMenuInflater().inflate(R.menu.toolbar_menu, menu);

        // true = mostrar el menú
        return true;
    }


    // =========================================================
    // MENÚ DE OPCIONES DE LA TOOLBAR: CLIC
    // =========================================================

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.action_buscar) {

            Toast.makeText(this, R.string.msg_buscar, Toast.LENGTH_SHORT).show();
            return true;

        } else if (id == R.id.action_compartir) {

            compartirApp();
            return true;

        } else if (id == R.id.action_acerca) {

            mostrarAcercaDe();
            return true;

        } else if (id == R.id.action_salir) {

            finish();   // cierra la app
            return true;
        }

        // Si no es una opción nuestra, la maneja el sistema
        return super.onOptionsItemSelected(item);
    }


    // =========================================================
    // COMPARTIR APP
    // =========================================================

    private void compartirApp() {

        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_TEXT, getString(R.string.texto_compartir));

        // Muestra la lista de apps para compartir (WhatsApp, Gmail, etc.)
        startActivity(Intent.createChooser(intent, getString(R.string.action_compartir)));
    }


    // =========================================================
    // DIÁLOGO "ACERCA DE"
    // =========================================================

    private void mostrarAcercaDe() {

        new MaterialAlertDialogBuilder(this)
                .setTitle(R.string.action_acerca)
                .setMessage(R.string.texto_acerca)
                .setPositiveButton(android.R.string.ok, null)
                .show();
    }


    // =========================================================
    // GUARDAR TÍTULO AL GIRAR LA PANTALLA
    // =========================================================

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putCharSequence(KEY_TITULO, getTitle());
    }
}
