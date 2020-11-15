package com.example.appcaronline1.home.tabacitivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.example.appcaronline1.R;
import com.example.appcaronline1.activityhistory.ActivityHistory;
import com.google.android.material.tabs.TabLayout;


public class ActitivityFragment extends Fragment  {


    TabLayout tabLayout;
    ViewPager viewPager;
    public ActitivityFragment() {
        // Required empty public constructor
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root;
        root = inflater.inflate(R.layout.fragment_acitivity,container,false);
        LinearLayout history = (LinearLayout) root.findViewById(R.id.li_history_1121);
        history.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), ActivityHistory.class);
                intent.putExtra("login","Login");
                startActivity(intent);
            }
        });
        tabLayout= (TabLayout) root.findViewById(R.id.tablayout_history);
        viewPager=(ViewPager) root.findViewById(R.id.viewpaper_history);

        tabLayout.addTab(tabLayout.newTab().setText("All activity"));
        tabLayout.addTab(tabLayout.newTab().setText("Ship"));

        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        final ActivityTabAdapter adapter = new ActivityTabAdapter(root.getContext(),getFragmentManager(), tabLayout.getTabCount());
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

        return root;

    }
}