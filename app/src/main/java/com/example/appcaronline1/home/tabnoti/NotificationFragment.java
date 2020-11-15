 package com.example.appcaronline1.home.tabnoti;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.fragment.app.Fragment;

import com.example.appcaronline1.R;

import java.util.ArrayList;


public class NotificationFragment extends Fragment {


    public NotificationFragment() {
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
        root = inflater.inflate(R.layout.fragment_notification, container, false);
        ArrayList<Message> messageArrayList = createData();
        ListView lvNoti = root.findViewById(R.id.lv_noti);
        lvNoti.setAdapter(new NotiAdapter(getContext(),messageArrayList));
        return root;
    }
     public ArrayList<Message> createData(){
         ArrayList<Message> list = new ArrayList<Message>();
         Message mess1 = new Message("title","bthome");
         list.add(mess1);
         return list;
     }

 }