package com.example.dailytasks.controllers.activities;

import androidx.fragment.app.Fragment;

import com.example.dailytasks.controllers.fragments.TaskListFrag;

public class ListActivity extends SingleFragmentActivity {


    @Override
    public Fragment createFragment() {
        return new TaskListFrag();
    }
}