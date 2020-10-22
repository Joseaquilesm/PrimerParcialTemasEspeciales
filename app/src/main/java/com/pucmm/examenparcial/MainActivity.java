package com.pucmm.examenparcial;

import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;

public class MainActivity extends FragmentActivity {
 //public static int orientacion;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       setContentView(R.layout.activity_main);
        MenuFragment menuFragment = new MenuFragment();
        FragmentManager manager = getSupportFragmentManager();
        manager.beginTransaction().replace(R.id.conceptoLayout, menuFragment).commit();
    }

    @Override
    protected void onResume() {
        super.onResume();
   // orientacion = getResources().getConfiguration().orientation;

    }
}