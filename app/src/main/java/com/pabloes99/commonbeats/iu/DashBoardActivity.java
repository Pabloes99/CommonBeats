package com.pabloes99.commonbeats.iu;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;
import com.pabloes99.commonbeats.R;
import com.pabloes99.commonbeats.adapter.ViewPageAdapter;

public class DashBoardActivity extends AppCompatActivity {

    private TabLayout tblEventos;
    private ViewPager viewPager;
    private ViewPageAdapter viewPageAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dash_board);

        tblEventos = findViewById(R.id.tblEventos);
        viewPager = findViewById(R.id.viewPager);

        tblEventos.addTab(tblEventos.newTab().setText("Eventos"));
        tblEventos.addTab(tblEventos.newTab().setText("Mis Eventos"));
        tblEventos.addTab(tblEventos.newTab().setText("Amigos"));
        tblEventos.setTabGravity(TabLayout.GRAVITY_FILL);

        viewPageAdapter = new ViewPageAdapter(getSupportFragmentManager(), tblEventos.getTabCount());

        viewPager.setAdapter(viewPageAdapter);

        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tblEventos));

        tblEventos.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {

                viewPager.setCurrentItem( tab.getPosition());
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
