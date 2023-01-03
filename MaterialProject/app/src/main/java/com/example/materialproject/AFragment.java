package com.example.materialproject;

import android.os.Bundle;

import androidx.appcompat.widget.SwitchCompat;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;
import android.widget.ToggleButton;

import com.google.android.material.snackbar.Snackbar;

public class AFragment extends Fragment {
    CheckBox painting,reading,singing,cooking;
    Button btnSubmit,btnRadio;
    View rootview;
    ToggleButton tb1, tb2;
    SwitchCompat switchCompat;

    public AFragment(){

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootview = inflater.inflate(R.layout.fragment_a, container, false);
        addListenerOnButtonClick();
        return rootview;

    }


    private void addListenerOnButtonClick() {
        //Getting instance of CheckBoxes and Button from the activty_main.xml file
        painting=(CheckBox)rootview.findViewById(R.id.checkBox);
        reading=(CheckBox)rootview.findViewById(R.id.checkBox2);
        singing=(CheckBox)rootview.findViewById(R.id.checkBox3);
        cooking=(CheckBox)rootview.findViewById(R.id.checkBox4);
        btnSubmit=(Button)rootview.findViewById(R.id.button);
        tb1= (ToggleButton)rootview.findViewById(R.id.tb1);
        tb2=(ToggleButton)rootview.findViewById(R.id.tb2);
        switchCompat=(SwitchCompat)rootview.findViewById(R.id.switchButton);

        switchCompat.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                Snackbar.make(buttonView, "Switch state checked "+isChecked, Snackbar.LENGTH_LONG)
                        .setAction("ACTION",null).show();
            }
        });


        //Applying the Listener on the Button click
        btnSubmit.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                int totalamount=0;
                StringBuilder result=new StringBuilder();
                result.append("Selected Items:");
                if(painting.isChecked()){
                    result.append("\nPainting");
                }
                if(reading.isChecked()){
                    result.append("\nReading");
                }
                if(singing.isChecked()){
                    result.append("\nSinging");
                }
                if(cooking.isChecked()){
                    result.append("\nCooking");
                }
                //Displaying the message on the toast
                Toast.makeText(getActivity(), result.toString(), Toast.LENGTH_LONG).show();
            }

        });
    }
}