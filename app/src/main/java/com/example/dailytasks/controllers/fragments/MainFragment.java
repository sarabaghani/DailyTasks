package com.example.dailytasks.controllers.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.fragment.app.Fragment;

import com.example.dailytasks.R;
import com.example.dailytasks.controllers.activities.ListActivity;


public class MainFragment extends Fragment {
    public static final String EXTRA_USERNAME = "extra username";
    public static final String EXTRA_NUMBER = "extra number";
    private Button mButtonSubmit;
    private EditText mTxtUsername;
    private EditText mTxtNumber;


    public MainFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        mTxtUsername = view.findViewById(R.id.user_name);
        mTxtNumber = view.findViewById(R.id.task_number);
        mButtonSubmit = view.findViewById(R.id.submit_btn);
        mButtonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), ListActivity.class
                );
                intent.putExtra(EXTRA_USERNAME, mTxtUsername.getText().toString());
                intent.putExtra(EXTRA_NUMBER, mTxtNumber.getText().toString());
                startActivity(intent);
            }
        });
        return view;
    }
}