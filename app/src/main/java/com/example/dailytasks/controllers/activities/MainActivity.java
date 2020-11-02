package com.example.dailytasks.controllers.activities;

import androidx.fragment.app.Fragment;

import com.example.dailytasks.controllers.fragments.MainFragment;

public class MainActivity extends SingleFragmentActivity {


    @Override
    public Fragment createFragment() {
        return new MainFragment();
    }
}