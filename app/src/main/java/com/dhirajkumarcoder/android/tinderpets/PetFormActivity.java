package com.dhirajkumarcoder.android.tinderpets;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;

import com.dhirajkumarcoder.android.tinderpets.Model.UiModels.Pet;

public class PetFormActivity extends AppCompatActivity implements View.OnClickListener {

    EditText etName;
    EditText etAge;
    Spinner etGender;
    Spinner etBreed;
    Spinner etSize;
    CheckBox etNeutered;
    EditText etInfo;
    Spinner etColor;

    Button submitButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pet_form);

        submitButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Pet pet = new Pet();
        pet.name = etName.getText().toString();
        pet.age  = Integer.parseInt(etAge.getText().toString());
        pet.gender = etGender.getSelectedItem().toString();
        pet.breed  = etBreed.getSelectedItem().toString();
        pet.size  = etSize.getSelectedItem().toString();
        pet.neutered = etNeutered.isSelected();
        pet.info = etInfo.getText().toString();
        pet.color = etColor.getSelectedItem().toString();
        FirebaseUtil.addPet(pet);
        finish();
    }
}
