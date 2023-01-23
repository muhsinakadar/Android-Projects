package com.example.demoapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.ActionMenuView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity{

//    private int counter = 0;
//    TextView textView;
//    DrawerLayout drawerLayout;
//    NavigationView navigationView;
//    Toolbar toolBar;
//    TabLayout tabLayout;
//    ViewPager viewPager;
//    //Bottom Navigation View
//    BottomNavigationView bottomNavigationView;
//
////    //Icons for tabLayout
////    private int[] iconArray =  {
////            R.drawable.ic_baseline_settings_24,
////            R.drawable.ic_baseline_room_preferences_24,
////            R.drawable.ic_baseline_favorite_border_24
////    };
//
//
//    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_main);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(getApplicationContext(),MainActivity2.class);
                startActivity(intent);

                finish();
            }
        },2000);

//
//        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
//        navigationView = (NavigationView) findViewById(R.id.navigation_view);
//
//        toolBar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolBar);
//
//
//        if (getSupportActionBar()!=null){
//            getSupportActionBar().setDisplayShowHomeEnabled(true);
////            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
//            getSupportActionBar().setLogo(R.drawable.androidicon);
//            getSupportActionBar().setDisplayUseLogoEnabled(true);
//            getSupportActionBar().setTitle("APP");
//        }
//
//
////        tabLayout = (TabLayout) findViewById(R.id.tab_layout);
////        viewPager = (ViewPager) findViewById(R.id.view_pager_1);
//
////        //adding tab items
////        tabLayout.addTab(tabLayout.newTab().setText("Settings"));
////        tabLayout.addTab(tabLayout.newTab().setText("preferences"));
////        tabLayout.addTab(tabLayout.newTab().setText("favourites"));
////        tabLayout.addTab(tabLayout.newTab().setText("Settings1"));
////        tabLayout.addTab(tabLayout.newTab().setText("preferences1"));
////        tabLayout.addTab(tabLayout.newTab().setText("favourites1"));
////        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
//////        calling function for tab icons
////        setUpTabIcons();
////        tabLayout.setInlineLabel(true);
//
//
////        final myAdapter adapter = new myAdapter(this,getSupportFragmentManager(),tabLayout.getTabCount());
////        viewPager.setAdapter(adapter);
////
////        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
////
////        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
////            @Override
////            public void onTabSelected(TabLayout.Tab tab) {
////                viewPager.setCurrentItem(tab.getPosition());
////            }
////
////            @Override
////            public void onTabUnselected(TabLayout.Tab tab) {
////
////            }
////
////            @Override
////            public void onTabReselected(TabLayout.Tab tab) {
////
////            }
////        });
//
//        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this,drawerLayout,toolBar, R.string.open_drawer,R.string.close_drawer);
//        drawerLayout.addDrawerListener(toggle);
//        toggle.syncState();
//
//        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
//            @Override
//            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
//
//                int navId = item.getItemId();
//
//                if (navId == R.id.item1){
//                    LoadFragment(new SettingsFragment());
//                }
//                else if (navId == R.id.item2){
//                    LoadFragment(new PrefFragment());
//                }
//                else if (navId == R.id.item3){
//                    LoadFragment(new FavFragment());
//                }
//                else if (navId == R.id.item4){
//                    LoadFragment(new LogoutFragment());
//                }
//
//                drawerLayout.closeDrawer(GravityCompat.START);
//
//                return true;
//            }
//        });
//
////        textView = (TextView) findViewById(R.id.text1);
////        ImageView imgView = (ImageView) findViewById(R.id.phoneIcon);
////
////        imgView.setOnClickListener(new View.OnClickListener() {
////            @Override
////            public void onClick(View view) {
////                counter++;
////                textView.setText(""+counter);
////            }
////        });
//
//        //Bottom Navigation View
//
//        bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottom_nav_view);
//        bottomNavigationView.setOnNavigationItemSelectedListener(this);
////        bottomNavigationView.setSelectedItemId(R.id.save_frag_menu);
//
    }
//
//////    function for tabIcons
////    private void setUpTabIcons() {
////
////        tabLayout.getTabAt(0).setIcon(iconArray[0]);
////        tabLayout.getTabAt(1).setIcon(iconArray[1]);
////        tabLayout.getTabAt(2).setIcon(iconArray[2]);
////        tabLayout.getTabAt(3).setIcon(iconArray[0]);
////        tabLayout.getTabAt(4).setIcon(iconArray[1]);
////        tabLayout.getTabAt(5).setIcon(iconArray[2]);
////
////    }
//
//    public void LoadFragment(Fragment fragment){
//
//        FragmentManager fm1 = getSupportFragmentManager();
//        FragmentTransaction ft1 = fm1.beginTransaction();
//        ft1.add(R.id.container,fragment).commit();
//
//    }
//
//    @Override
//    public void onBackPressed() {
//
//            if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
//                drawerLayout.closeDrawer(GravityCompat.START);
//            } else {
//                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
//
//                builder.setMessage("Do you want to exit?");
//
//                builder.setTitle("ALERT!!");
//
//                builder.setCancelable(false);
//
//                builder.setPositiveButton("Yes", (DialogInterface.OnClickListener) (Dialog, which) -> {
//                    System.exit(0);
//                });
//
//                builder.setNegativeButton("No", (DialogInterface.OnClickListener) (Dialog, which) -> {
//                    Dialog.cancel();
//                });
//
//                AlertDialog alertDialog = builder.create();
//                alertDialog.show();
//            }
//    }
//
//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
////        new MenuInflater(this).inflate(R.menu.main_menu,menu);
//        this.getMenuInflater().inflate(R.menu.main_menu,menu);
//        return super.onCreateOptionsMenu(menu);
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
//        int itemId = item.getItemId();
//
//        if (itemId == R.id.cart_item){
//            Toast.makeText(this, "Cart is clicked", Toast.LENGTH_SHORT).show();
//            Intent intent = new Intent(getApplicationContext(),CartActivity.class);
//            startActivity(intent);
//        }
//        else if (itemId == R.id.check_item){
//            Toast.makeText(this, "Check is clicked", Toast.LENGTH_SHORT).show();
//            Intent intent = new Intent(getApplicationContext(),CheckActivity.class);
//            startActivity(intent);
//        }
//        else if (itemId == android.R.id.home){
//            Toast.makeText(this, "Home is clicked", Toast.LENGTH_SHORT).show();
//            super.onBackPressed();
//        }
//        else if(itemId == R.id.save_item){
//            Toast.makeText(this, "save is clicked", Toast.LENGTH_SHORT).show();
//            Intent intent = new Intent(getApplicationContext(),SaveActivity.class);
//            startActivity(intent);
//        }
//        return super.onOptionsItemSelected(item);
//    }
//
//
//    // bottom Navigation View
//    @Override
//    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
//        switch (item.getItemId()){
//            case R.id.save_frag_menu:
//                Intent intent1 = new Intent(getApplicationContext(),SaveActivity.class);
//                startActivity(intent1);
//                return true;
//            case R.id.cart_frag_menu:
//                Intent intent2 = new Intent(getApplicationContext(),CartActivity.class);
//                startActivity(intent2);
//                return true;
//            case R.id.check_frag_menu:
//                Intent intent3 = new Intent(getApplicationContext(),CheckActivity.class);
//                startActivity(intent3);
//                return true;
//        }
//        return false;
//    }
}