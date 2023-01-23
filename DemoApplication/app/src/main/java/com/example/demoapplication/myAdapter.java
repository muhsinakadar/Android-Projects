package com.example.demoapplication;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class myAdapter extends FragmentPagerAdapter {

    private Context myContext;
    int totalTabs;


    public myAdapter(@NonNull Context context, FragmentManager fm, int totalTabs) {
        super(fm);
        myContext = context;
        this.totalTabs = totalTabs;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0: Fragment f1 = new HomeFragment();
                   return f1;
            case 1: Fragment f2 = new PrefFragment();
                return f2;
//            case 2: Fragment f3 = new FavFragment();
//                return f3;
            case 2: Fragment f4 = new SettingsFragment();
                return f4;
            case 3: Fragment f5 = new CheckFragment();
                return f5;
            case 4: Fragment f6 = new CartFragment();
                return f6;
            default:return null;
        }
    }

    @Override
    public int getCount() {
        return totalTabs;
    }
}
