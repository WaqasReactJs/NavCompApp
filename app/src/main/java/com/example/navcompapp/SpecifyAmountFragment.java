package com.example.navcompapp;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EdgeEffect;
import android.widget.EditText;
import android.widget.Toast;

public class SpecifyAmountFragment extends Fragment {

    View view;
    Button btnSend, btnCancel;
    EditText edAmount;

    public SpecifyAmountFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_specify_amount, container, false);

        //Reciving of arguments from Recipientfragment
        //SpecifyAmountFragmentArgs.fromBundle(getArguments()).getName();

        btnCancel = view.findViewById(R.id.cancel);
        btnSend = view.findViewById(R.id.send);
        edAmount = view.findViewById(R.id.edAmount);

        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (edAmount.getText().toString().isEmpty()){
                    Toast.makeText(getActivity(), "Please fill Amount", Toast.LENGTH_SHORT).show();
                    return;
                }

                //sending arguments to another fragment
                NavDirections directions = SpecifyAmountFragmentDirections.actionSpecifyAmountFragmentToConfirmationFragment(SpecifyAmountFragmentArgs.fromBundle(getArguments()).getName(), Integer.parseInt(edAmount.getText().toString()));
                //  Navigation.findNavController(view).navigate(R.id.action_specifyAmountFragment_to_confirmationFragment);
                Navigation.findNavController(view).navigate(directions);
            }
        });

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(view).navigateUp();
            }
        });


        return view;
    }
}