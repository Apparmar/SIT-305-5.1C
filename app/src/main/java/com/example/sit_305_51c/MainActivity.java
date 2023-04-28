package com.example.sit_305_51c;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Fragment fragment = new HomeFragment();
        FragmentManager fgm = getSupportFragmentManager();
        FragmentTransaction fgt = fgm.beginTransaction();
        fgt.replace(R.id.mainFrame,fragment);
        fgt.commit();
    }
}