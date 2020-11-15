package com.example.appcaronline1.home;

import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.example.appcaronline1.R;
import com.google.android.material.tabs.TabLayout;

public class HomeAcitivity extends AppCompatActivity {
    TabLayout tabLayout;
    ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        requestWindowFeature(Window.FEATURE_NO_TITLE); //will hide the title
        getSupportActionBar().hide(); // hide the title bar
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN); //enable full screen
        setContentView(R.layout.activity_home);
        tabLayout= (TabLayout) findViewById(R.id.tablayout_home);
        viewPager=(ViewPager) findViewById(R.id.viewpaper_home);

        tabLayout.addTab(tabLayout.newTab().setText("Home"));
        tabLayout.addTab(tabLayout.newTab().setText("Acitivity"));
        tabLayout.addTab(tabLayout.newTab().setText("Payment"));

        tabLayout.addTab(tabLayout.newTab().setText("Notification"));

        tabLayout.addTab(tabLayout.newTab().setText("Account"));
        tabLayout.getTabAt(0).setIcon(R.drawable.bthome);
        tabLayout.getTabAt(1).setIcon(R.drawable.document2);
        tabLayout.getTabAt(2).setIcon(R.drawable.credit);
        tabLayout.getTabAt(3).setIcon(R.drawable.message1);
        tabLayout.getTabAt(4).setIcon(R.drawable.document);
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        final TabAdapter adapter = new TabAdapter(this,getSupportFragmentManager(), tabLayout.getTabCount());
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