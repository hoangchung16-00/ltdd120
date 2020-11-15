package com.example.appcaronline1.home.tabpayment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.example.appcaronline1.R;
import com.example.appcaronline1.database.account.Account;


public class PaymentFragment extends Fragment {

    public PaymentFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root;
        root= inflater.inflate(R.layout.fragment_payment, container, false);
        TextView tvUserName = root.findViewById(R.id.tv_payment_username);
        tvUserName.setText((String) Account.AccountLogin.getName());
        return root;
    }
}