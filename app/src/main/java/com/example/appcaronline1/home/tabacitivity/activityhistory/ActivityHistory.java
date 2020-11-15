package com.example.appcaronline1.home.tabacitivity.activityhistory;

import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.example.appcaronline1.R;
import com.google.android.material.tabs.TabLayout;

public class ActivityHistory extends AppCompatActivity {
    TabLayout tabLayout;
    ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE); //will hide the title
        getSupportActionBar().hide(); // hide the title bar
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN); //enable full screen  ;
        setContentView(R.layout.activity_history);
        tabLayout=(TabLayout)findViewById(R.id.tablayout_history);
        viewPager=(ViewPager)findViewById(R.id.viewpaper_history);

        tabLayout.addTab(tabLayout.newTab().setText("Đi lại"));
        tabLayout.addTab(tabLayout.newTab().setText("Giao hàng"));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        final HistoryAdapter adapter = new HistoryAdapter(this,getSupportFragmentManager(), tabLayout.getTabCount());
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
    }
}