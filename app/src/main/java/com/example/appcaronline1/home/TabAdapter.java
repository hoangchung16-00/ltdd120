package com.example.appcaronline1.home;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.appcaronline1.home.tabaccount.AccountFragment;
import com.example.appcaronline1.home.tabacitivity.ActitivityFragment;
import com.example.appcaronline1.home.tabhome.HomeFragment;
import com.example.appcaronline1.home.tabnoti.NotificationFragment;
import com.example.appcaronline1.home.tabpayment.PaymentFragment;

public class TabAdapter extends FragmentPagerAdapter {
    private Context context;
    int totalTabs;

    public TabAdapter(Context context, FragmentManager fragmentManager, int totalTabs){
        super(fragmentManager);
        this.context=context;
        this.totalTabs=totalTabs;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                HomeFragment homeFragment = new HomeFragment();
                return homeFragment;
            case 2:
                PaymentFragment paymentFragment  = new PaymentFragment();
                return paymentFragment;
            case 3:
                NotificationFragment notificationFragment = new NotificationFragment();
                return notificationFragment;
            case 4:
                AccountFragment accountFragment = new AccountFragment();
                return accountFragment;
            case 1:
                ActitivityFragment actitivityFragment = new ActitivityFragment();
                return actitivityFragment;
            default:
                return null;

        }
    }

    @Override
    public int getCount() {
        return totalTabs;
    }
}
