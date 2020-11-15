package com.example.appcaronline1.home.tabaccount;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.fragment.app.Fragment;

import com.example.appcaronline1.R;
import com.example.appcaronline1.editaccount.EditAccount;
import com.example.appcaronline1.memberrank.MemberRank;


public class AccountFragment extends Fragment{

    public AccountFragment() {
    }




    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root;
        root=  inflater.inflate(R.layout.fragment_account,container,false);
        LinearLayout memberrank = (LinearLayout) root.findViewById(R.id.li_account_121);
        memberrank.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), MemberRank.class);
                intent.putExtra("meber","home");
                startActivity(intent);
            }
        });
        LinearLayout editaccount = (LinearLayout) root.findViewById(R.id.li_account_11);
        editaccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(getActivity(), EditAccount.class);
                getActivity().startActivity(myIntent);
            }
        });
        return root;
    }

}