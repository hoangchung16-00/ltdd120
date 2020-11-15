package com.example.appcaronline1.home.tabacitivity.activityhistory;

import android.content.Context;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class HistoryAdapter extends FragmentPagerAdapter {
    private Context myContext;
    int totalTabs;

    public HistoryAdapter(Context context, FragmentManager fragmentManager, int totalTabs) {
        super(fragmentManager);
        myContext = context;
        this.totalTabs = totalTabs;
    }
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                MoveHistoryFragment moveHistoryFragment = new MoveHistoryFragment();
                return moveHistoryFragment;
            case 1:
                ShipHistoryFragment shipHistoryFragment = new ShipHistoryFragment();
                return shipHistoryFragment;
            default:
                return null;
        }
    }
    // this counts total number of tabs
    @Override
    public int getCount() {
        return totalTabs;
    }
}
