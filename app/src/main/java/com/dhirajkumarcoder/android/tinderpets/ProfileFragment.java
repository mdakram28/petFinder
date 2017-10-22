package com.dhirajkumarcoder.android.tinderpets;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.dhirajkumarcoder.android.tinderpets.Model.UiModels.User;

import butterknife.BindView;
import butterknife.ButterKnife;


public class ProfileFragment extends android.app.Fragment implements View.OnClickListener {

    @BindView(R.id.userName)
    TextView name;

    @BindView(R.id.userEmail)
    TextView email;

    @BindView(R.id.userContact)
    TextView contact;

    @BindView(R.id.btnAddPet)
    Button btnAddPet;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_profile, container, false);
        ButterKnife.bind(this,view);
        btnAddPet.setOnClickListener(this);
        name.setText(User.user.name);
        return view;
    }

    @Override
    public void onClick(View view) {
        Intent i = new Intent(this.getContext(), PetFormActivity.class);
        startActivity(i);
    }
}