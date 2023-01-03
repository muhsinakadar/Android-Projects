package com.example.materialproject;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class NotesFragment extends Fragment {
    View rootview;
    Button alert;
    private ProgressBar progressBar;
    private TextView progressText;
    int i = 0;

    public NotesFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootview = inflater.inflate(R.layout.fragment_notes, container, false);

        // set the id for the progressbar and progress text
        progressBar = rootview.findViewById(R.id.progress_bar);
        progressText = rootview.findViewById(R.id.progress_text);
        alert = rootview.findViewById(R.id.btnAlert);

        alert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

                // Set the message show for the Alert time
                builder.setMessage("Do you want to exit ?");

                // Set Alert Title
                builder.setTitle("Alert !");

                // Set Cancelable false for when the user clicks on the outside the Dialog Box then it will remain show
                builder.setCancelable(false);

                // Set the positive button with yes name Lambda OnClickListener method is use of DialogInterface interface.
                builder.setPositiveButton("Yes", (DialogInterface.OnClickListener) (dialog, which) -> {
                    // When the user click yes button then app will close

                    Fragment fragment = new AFragment();
                    FragmentManager fm = getFragmentManager();
                    FragmentTransaction transaction = fm.beginTransaction();
                    transaction.add(R.id.container, fragment);
                    transaction.commit();
//                    finish();
                });

                // Set the Negative button with No name Lambda OnClickListener method is use of DialogInterface interface.
                builder.setNegativeButton("No", (DialogInterface.OnClickListener) (dialog, which) -> {
                    // If user click no then dialog box is canceled.
                    dialog.cancel();
                });

                // Create the Alert dialog
                AlertDialog alertDialog = builder.create();
                // Show the Alert Dialog box
                alertDialog.show();
            }

            private void finish() {
            }
        });

        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                // set the limitations for the numeric
                // text under the progress bar
                if (i <= 100) {
                    progressText.setText("" + i);
                    progressBar.setProgress(i);
                    i++;
                    handler.postDelayed(this, 200);
                } else {
                    handler.removeCallbacks(this);
                }
            }
        }, 200);
        return rootview;


    }
 }