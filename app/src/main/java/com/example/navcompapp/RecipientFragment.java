package com.example.navcompapp;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RecipientFragment extends Fragment {

    View view;
    EditText editText;
    Button send,cancel;

    public RecipientFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_recipient, container, false);

        send = view.findViewById(R.id.send);
        cancel = view.findViewById(R.id.cancel);
        editText = view.findViewById(R.id.edName);

        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (editText.getText().toString().isEmpty()){
                    Toast.makeText(getActivity(), "Please fill Name", Toast.LENGTH_SHORT).show();
                    return;
                }
                NavDirections directions = RecipientFragmentDirections.actionRecipientFragmentToSpecifyAmountFragment(editText.getText().toString());
                //Navigation.findNavController(view).navigate(R.id.action_recipientFragment_to_specifyAmountFragment);
                Navigation.findNavController(view).navigate(directions);
            }
        });

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(view).navigateUp();
            }
        });


        return view;
    }
}