package com.pabloes99.commonbeats.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.pabloes99.commonbeats.iu.Evento.AmigosFragment;
import com.pabloes99.commonbeats.iu.Evento.EventosFragment;
import com.pabloes99.commonbeats.iu.Evento.MisEventosFragment;
import com.pabloes99.commonbeats.iu.Evento.PublicacionFragment;

public class ViewPageAdapter extends FragmentStatePagerAdapter {

    int numeroTabs;

    public ViewPageAdapter(@NonNull FragmentManager fm, int numeroTabs) {
        super(fm);
        this.numeroTabs = numeroTabs;
    }

    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0:
                return new EventosFragment();
            case 1:
                return new MisEventosFragment();
            case 2:
                return new AmigosFragment();
            case 3:
                return  new PublicacionFragment();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return numeroTabs;
    }
}
