package com.example.dailytasks.controllers.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.content.Intent;
import android.os.Bundle;

import com.example.dailytasks.R;
import com.example.dailytasks.controllers.fragments.TaskListFrag;

public class ListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        FragmentManager fragmentManager = getSupportFragmentManager();
        Fragment fragment = fragmentManager.findFragmentById(R.id.list_container);
        TaskListFrag taskListFrag = new TaskListFrag();
        if (fragment == null) {
            fragmentManager.beginTransaction()
                    .add(R.id.list_container, taskListFrag)
                    .commit();
        }
    }
}