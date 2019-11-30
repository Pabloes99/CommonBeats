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
import com.pabloes99.commonbeats.adapter.ViewPageAdapter;
import com.pabloes99.commonbeats.iu.Evento.AcercaDeNosotrosActivity;
import com.pabloes99.commonbeats.iu.Perfil.PerfilActivity;

public class DashBoardActivity extends AppCompatActivity {

    private TabLayout tblEventos;
    private ViewPager viewPager;
    private ViewPageAdapter viewPageAdapter;

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
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void lanzarActividadPerfil() {
        Intent intent = new Intent(DashBoardActivity.this, PerfilActivity.class);
        startActivity(intent);
    }

    private void lanzarActividadAcercaDeNosotros() {
        Intent intent = new Intent(DashBoardActivity.this, AcercaDeNosotrosActivity.class);
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dash_board);

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
