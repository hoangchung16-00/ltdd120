package com.example.appcaronline1.home.tabhome;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.LinearLayout;

import androidx.fragment.app.Fragment;

import com.example.appcaronline1.R;
import com.example.appcaronline1.standard.Standard;

import java.util.ArrayList;


public class HomeFragment extends Fragment {


    public HomeFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root;
        root = inflater.inflate(R.layout.fragment_home, container, false);
        LinearLayout standard = (LinearLayout) root.findViewById(R.id.li_home_311);
        standard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(getActivity(), Standard.class);
                getActivity().startActivity(myIntent);
            }
        });
        LinearLayout standard1 = (LinearLayout) root.findViewById(R.id.li_home_312);
        standard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(getActivity(), Standard.class);
                getActivity().startActivity(myIntent);
            }
        });
        ArrayList<ActiveEvent> eventArrayList = createData();
        GridView gvHome = root.findViewById(R.id.gv_home_1);
        gvHome.setAdapter(new EventAdapter(getContext(),eventArrayList));
        return root;
    }
    public ArrayList<ActiveEvent> createData(){
        ArrayList<ActiveEvent> list = new ArrayList<ActiveEvent>();
        ActiveEvent event1 = new ActiveEvent("xin chào chào","li1");
        ActiveEvent event2 = new ActiveEvent("xin chào xin chào","li2");
        ActiveEvent event3 = new ActiveEvent("xin chào xin chào","li3");
        ActiveEvent event4 = new ActiveEvent("xin chào xin chào","li4");
        ActiveEvent event5 = new ActiveEvent("xin chào chào","li1");
        ActiveEvent event6 = new ActiveEvent("xin chào xin chào","li2");
        ActiveEvent event7 = new ActiveEvent("xin chào xin chào","li3");
        ActiveEvent event8 = new ActiveEvent("xin chào xin chào","li4");

        list.add(event1);
        list.add(event2);
        list.add(event3);
        list.add(event4);
        list.add(event5);
        list.add(event6);
        list.add(event7);
        list.add(event8);

        return list;
    }



}