package com.example.navcompapp;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;


public class HomeFragment extends Fragment {


    View view;
    Button viewTransaction,viewSendMoney,viewBalance;


    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_home,container,false);
        viewTransaction = view.findViewById(R.id.view_transaction);
        viewSendMoney = view.findViewById(R.id.send_money);
        viewTransaction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(), "This is Home Toast", Toast.LENGTH_SHORT).show();
                Navigation.findNavController(view).navigate(R.id.action_homeFragment_to_transactionFragment);
            }
        });

        viewSendMoney = view.findViewById(R.id.send_money);
        viewSendMoney.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(view).navigate(R.id.action_homeFragment_to_recipientFragment);
            }
        });

        viewBalance = view.findViewById(R.id.view_balance);
        viewBalance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(view).navigate(R.id.action_homeFragment_to_viewBalanceFragment);
            }
        });

        // Inflate the layout for this fragment
        return view;
    }
}