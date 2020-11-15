package com.example.appcaronline1.home.tabacitivity.taballactivity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.example.appcaronline1.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link AllActivityFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AllActivityFragment extends Fragment {


    public AllActivityFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_all_activity, container, false);
    }
}