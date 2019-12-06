package com.pabloes99.commonbeats.iu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.google.android.material.tabs.TabLayout;
import com.pabloes99.commonbeats.R;
import com.pabloes99.commonbeats.adapter.EventoAdapter;
import com.pabloes99.commonbeats.adapter.EventosCreadosAdapter;
import com.pabloes99.commonbeats.adapter.EventosSuscritosAdapter;
import com.pabloes99.commonbeats.adapter.ViewPageAdapter;
import com.pabloes99.commonbeats.iu.Evento.AcercaDeNosotrosActivity;
import com.pabloes99.commonbeats.iu.Perfil.PerfilActivity;
import com.pabloes99.commonbeats.data.Repository.EventoRepository;
import com.pabloes99.commonbeats.data.Repository.EventosCreadosRepository;
import com.pabloes99.commonbeats.data.Repository.EventosSuscritosRepository;
import com.pabloes99.commonbeats.data.pojo.Evento;

import java.util.Collections;

public class PanelActivity extends AppCompatActivity {

    private TabLayout tblEventos;
    private ViewPager viewPager;
    private ViewPageAdapter viewPageAdapter;
    private static EventoAdapter eventoAdapter;
    private static EventosCreadosAdapter eventosCreadosAdapter;
    private static EventosSuscritosAdapter eventosSuscritosAdapter;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()) {
            case R.id.acercaDeNosotros:
                lanzarActividadAcercaDeNosotros();
                return true;
            case R.id.perfil:
                lanzarActividadPerfil();
                return true;
            case R.id.ordenarPorTitulo:
                Collections.sort(EventoRepository.getInstance().getList(),new Evento.TituloEventoComparator());
                Collections.sort(EventosCreadosRepository.getInstancia().getListaEventosCreados(),new Evento.TituloEventoComparator());
                Collections.sort(EventosSuscritosRepository.getInstance().getListEventosSuscritos(),new Evento.TituloEventoComparator());
                eventoAdapter.notifyDataSetChanged();
                eventosCreadosAdapter.notifyDataSetChanged();
                eventosSuscritosAdapter.notifyDataSetChanged();
                return true;
            case R.id.ordenarPorFecha:
                Collections.sort(EventoRepository.getInstance().getList(),new Evento.FechaEventoComparator());
                Collections.sort(EventosCreadosRepository.getInstancia().getListaEventosCreados(),new Evento.FechaEventoComparator());
                Collections.sort(EventosSuscritosRepository.getInstance().getListEventosSuscritos(),new Evento.FechaEventoComparator());
                eventoAdapter.notifyDataSetChanged();
                eventosCreadosAdapter.notifyDataSetChanged();
                eventosSuscritosAdapter.notifyDataSetChanged();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public static void pasarEventoAdapter(EventoAdapter eventoAdapterD){
        eventoAdapter = eventoAdapterD;
    }

    public static void pasarEventosCreadosAdapter(EventosCreadosAdapter eventosCreadosAdapterD){
        eventosCreadosAdapter = eventosCreadosAdapterD;
    }

    public static void pasarEventosSuscritosAdapter(EventosSuscritosAdapter eventosSuscritosAdapterD){
        eventosSuscritosAdapter = eventosSuscritosAdapterD;
    }


    private void lanzarActividadPerfil() {
        Intent intent = new Intent(PanelActivity.this, PerfilActivity.class);
        startActivity(intent);
    }

    private void lanzarActividadAcercaDeNosotros() {
        Intent intent = new Intent(PanelActivity.this, AcercaDeNosotrosActivity.class);
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_panel);

        tblEventos = findViewById(R.id.tblEventos);
        viewPager = findViewById(R.id.viewPager);

        tblEventos.addTab(tblEventos.newTab().setText("Eventos"));
        tblEventos.addTab(tblEventos.newTab().setText("Mis Eventos"));
        tblEventos.addTab(tblEventos.newTab().setText("Amigos"));
        tblEventos.addTab(tblEventos.newTab().setText("Publicaciones"));
        tblEventos.setTabGravity(TabLayout.GRAVITY_FILL);

        viewPageAdapter = new ViewPageAdapter(getSupportFragmentManager(), tblEventos.getTabCount());

        viewPager.setAdapter(viewPageAdapter);

        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tblEventos));

        tblEventos.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {

                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }
}
