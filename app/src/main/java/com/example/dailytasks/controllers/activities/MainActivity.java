package com.example.dailytasks.controllers.activities;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.example.dailytasks.controllers.fragments.MainFragment;
import com.example.dailytasks.R;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FragmentManager fragmentManager = getSupportFragmentManager();
        Fragment fragment = fragmentManager.findFragmentById(R.id.main_container);
        MainFragment mainFragment = new MainFragment();
        if (fragment == null) {
            fragmentManager.beginTransaction()
                    .add(R.id.main_container, mainFragment)
                    .commit();
        }
    }
}