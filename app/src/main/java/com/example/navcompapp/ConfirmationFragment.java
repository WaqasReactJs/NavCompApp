package com.example.navcompapp;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class ConfirmationFragment extends Fragment {

    View view;
    TextView tvName, tvAmount;

    public ConfirmationFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_confirmation, container, false);

        tvName = view.findViewById(R.id.name);
        tvAmount = view.findViewById(R.id.amount);

        tvName.setText(ConfirmationFragmentArgs.fromBundle(getArguments()).getName());
        tvAmount.setText(""+ConfirmationFragmentArgs.fromBundle(getArguments()).getAmount());


        return view;
    }
}