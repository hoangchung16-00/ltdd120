package com.example.appcaronline1.home.tabacitivity;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.appcaronline1.home.tabacitivity.taballactivity.AllActivityFragment;
import com.example.appcaronline1.home.tabacitivity.tabship.ShipFragment;

public class ActivityTabAdapter extends FragmentPagerAdapter {
    private Context context;
    int totalTabs;

    public ActivityTabAdapter(Context context, FragmentManager fragmentManager, int totalTabs){
        super(fragmentManager);
        this.context=context;
        this.totalTabs=totalTabs;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                AllActivityFragment allActivityFragment = new AllActivityFragment();
                return allActivityFragment;
            case 1:
                ShipFragment shipFragment  = new ShipFragment();

                return shipFragment;
            default:
                return null;

        }
    }

    @Override
    public int getCount() {
        return totalTabs;
    }
}
