package com.example.demoapplication;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;

import androidx.appcompat.widget.SwitchCompat;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.ToggleButton;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;


public class PrefFragment extends Fragment {

    ToggleButton toggleButton1, toggleButton2;
    SwitchCompat switchBtn1;
    FloatingActionButton floatBtn;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    public PrefFragment() {
        // Required empty public constructor
    }


    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_pref, container, false);

        floatBtn = (FloatingActionButton) rootView.findViewById(R.id.floatingBtn1);
        floatBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                StringBuilder result = new StringBuilder();
                result.append("Toggle Button 1: ").append(toggleButton1.getText());
                result.append("\n Toggle Button 2: ").append(toggleButton2.getText());

                Snackbar snackbar = Snackbar.make(view, result.toString(), Snackbar.LENGTH_LONG).setAction("SWITCH ENABLE", new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        switchBtn1.setChecked(true);
                    }
                });

                snackbar.setActionTextColor(Color.RED);
                snackbar.show();
            }
        });

        toggleButton1 = (ToggleButton) rootView.findViewById(R.id.tgBtn1);
        toggleButton2 = (ToggleButton) rootView.findViewById(R.id.tgBtn2);
        switchBtn1 = (SwitchCompat) rootView.findViewById(R.id.switchBtn);

        switchBtn1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                Snackbar.make(compoundButton, "Switch State Checked "+isChecked,Snackbar.LENGTH_LONG).setAction("ACTION", null).show();
            }
        });

        return rootView;
    }
}