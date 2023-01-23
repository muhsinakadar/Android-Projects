package com.example.demoapplication;

import android.annotation.SuppressLint;

import androidx.activity.OnBackPressedDispatcherOwner;
import androidx.appcompat.app.AlertDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.core.view.GravityCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager.widget.ViewPager;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.material.tabs.TabLayout;

public class FavFragment extends Fragment{

    ProgressBar progressBar1;
    Button pbBtn1;
    Button pbBtn2;
    Button progressBtn1;
    boolean isProgressVisible = false;
    ProgressDialog progressBar2;
    TabLayout tabLayout;
    ViewPager viewPager;

    Handler progressHandler = new Handler();
    long fileSize = 0;
    int progressStatus = 0;

        //Icons for tabLayout
    private int[] iconArray =  {
            R.drawable.ic_baseline_settings_24,
            R.drawable.ic_baseline_room_preferences_24,
            R.drawable.ic_baseline_favorite_border_24
    };

    public FavFragment() {
        // Required empty public constructor
    }

    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View favView = inflater.inflate(R.layout.fragment_fav, container, false);

        progressBar1 = (ProgressBar) favView.findViewById(R.id.pgBar1);
        pbBtn1 = (Button) favView.findViewById(R.id.pbBtn1);
        pbBtn2 = (Button) favView.findViewById(R.id.pbBtn2);
        progressBtn1 = (Button) favView.findViewById(R.id.pb2ProgessBtn);

        tabLayout = (TabLayout) favView.findViewById(R.id.tab_layout);
        viewPager = (ViewPager) favView.findViewById(R.id.view_pager_1);

        //adding tab items
        tabLayout.addTab(tabLayout.newTab().setText("Settings"));
        tabLayout.addTab(tabLayout.newTab().setText("preferences"));
//        tabLayout.addTab(tabLayout.newTab().setText("favourites"));
        tabLayout.addTab(tabLayout.newTab().setText("Settings1"));
        tabLayout.addTab(tabLayout.newTab().setText("preferences1"));
        tabLayout.addTab(tabLayout.newTab().setText("favourites1"));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
//        calling function for tab icons
        setUpTabIcons();
        tabLayout.setInlineLabel(true);

        FragmentManager fm = getFragmentManager();

        final myAdapter adapter = new myAdapter(getContext(),fm,tabLayout.getTabCount());
        viewPager.setAdapter(adapter);

        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        pbBtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isProgressVisible){

                    pbBtn1.setText("Show Progress Bar");
                    progressBar1.setVisibility(view.GONE);
                    isProgressVisible = false;

                }else{

                    isProgressVisible = true;
                    pbBtn1.setText("Hide Progress Bar");
                    progressBar1.setVisibility(view.VISIBLE);

                }
            }
        });

        progressBtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                progressStatus += 10;
            }
        });

        pbBtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                progressBar2 = new ProgressDialog(view.getContext());
                progressBar2.setCancelable(true);
                progressBar2.setMessage("File Downloading...");
                progressBar2.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
                progressBar2.setProgress(0);
                progressBar2.setMax(100);
                progressBar2.show();
//                progressStatus = 0;
//                fileSize = 0;

                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        while (progressStatus<100) {
                            try {
                                Thread.sleep(1000);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                            progressHandler.post(new Runnable() {
                                @Override
                                public void run() {
                                    progressBar2.setProgress(progressStatus);
                                }
                            });
                        }

                        if (progressStatus>=100){
                            try {
                                Thread.sleep(1000);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                            progressBar2.dismiss();
                            progressStatus = 0;
                        }
                    }
                }).start();

            }
        });


        return favView;


    }



    //    function for tabIcons
    private void setUpTabIcons() {

        tabLayout.getTabAt(0).setIcon(iconArray[0]);
        tabLayout.getTabAt(1).setIcon(iconArray[1]);
        tabLayout.getTabAt(2).setIcon(iconArray[2]);
        tabLayout.getTabAt(3).setIcon(iconArray[0]);
        tabLayout.getTabAt(4).setIcon(iconArray[1]);

    }


    public void onBackPressed() {

            AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

            builder.setMessage("jjjn");

            builder.setTitle("ALERT!!");

            builder.setCancelable(false);

            builder.setPositiveButton("Yes", (DialogInterface.OnClickListener) (Dialog, which) -> {
                Toast.makeText(getActivity(), "Alert yes", Toast.LENGTH_SHORT).show();
            });

            builder.setNegativeButton("No", (DialogInterface.OnClickListener) (Dialog, which) -> {
                Dialog.cancel();
            });

            AlertDialog alertDialog = builder.create();
            alertDialog.show();
        }

}


//    public int doOperation(){
//        while (fileSize<=10000){
//            fileSize++;
//            if (fileSize == 1000){
//                return 10;
//            }else if (fileSize == 2000){
//                return 20;
//            }
//            else if (fileSize == 3000){
//                return 30;
//            }
//            else if (fileSize == 4000){
//                return 40;
//            }
//            else if (fileSize == 5000){
//                return 50;
//            }
//            else{
//                return 100;
//            }
//
//        }
//        return 100;
//    }
