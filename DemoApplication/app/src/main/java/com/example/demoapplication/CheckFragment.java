package com.example.demoapplication;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

import androidx.fragment.app.Fragment;

import java.util.Calendar;

public class CheckFragment extends Fragment {

    private Button dateBtn;
    private TextView dateTxt;
    private TextView currDate;
    private Button timeBtn;
    private TextView timeTxt;

    public CheckFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_check, container, false);

        dateTxt = (TextView) view.findViewById(R.id.display_date);
        dateBtn = (Button) view.findViewById(R.id.date_btn);
        currDate = (TextView) view.findViewById(R.id.textview_title);
        timeBtn = (Button) view.findViewById(R.id.time_btn);
        timeTxt = (TextView) view.findViewById(R.id.display_time);

        timeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Calendar c = Calendar.getInstance();

                int hour = c.get(Calendar.HOUR_OF_DAY);
                int min = c.get(Calendar.MINUTE);

                TimePickerDialog timePickerDialog = new TimePickerDialog(getContext(), new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int hourOfDay, int minOfDay) {
                        timeTxt.setText( hourOfDay + ":" + minOfDay);
                    }
                },hour,min,false);
                timePickerDialog.show();
            }
        });

        dateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                final Calendar c = Calendar.getInstance();

                int year = c.get(Calendar.YEAR);
                int month = c.get(Calendar.MONTH);
                int day = c.get(Calendar.DAY_OF_MONTH);

                currDate.setText("Date is: "+year+"-"+(month+1)+"-"+day);

                DatePickerDialog datePickerDialog = new DatePickerDialog(getContext(), new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int currYear, int monthOfYear, int dateOfMonth) {
                        dateTxt.setText("Date is: "+dateOfMonth+"-"+(monthOfYear+1)+"-"+currYear);
                    }
                },year,month,day);

                datePickerDialog.show();
            }
        });

        return view;
    }
}