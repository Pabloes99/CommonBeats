package com.pabloes99.commonbeats.iu.Evento;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import com.pabloes99.commonbeats.R;

public class ChatActivity extends AppCompatActivity {

    FragmentTransaction fragmentTransaction;
    FragmentManager fragmentManager;
    ChatFragment chatFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);

        cargarChatFragment();
    }

    private void cargarChatFragment() {

        fragmentManager = getSupportFragmentManager();

        fragmentTransaction = fragmentManager.beginTransaction();

        chatFragment = ChatFragment.crearNuevaInstancia(null);

        fragmentTransaction.add(android.R.id.content, chatFragment, ChatFragment.TAG);

        fragmentTransaction.commit();
    }
}
