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
        ActiveEvent event1 = new ActiveEvent("title","bthome");
        list.add(event1);
        return list;
    }



}