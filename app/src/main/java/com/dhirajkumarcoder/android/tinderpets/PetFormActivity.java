package com.dhirajkumarcoder.android.tinderpets;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;

import com.dhirajkumarcoder.android.tinderpets.Model.UiModels.Pet;

import java.util.ArrayList;
import java.util.List;

public class PetFormActivity extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemSelectedListener {

    private static final int SELECT_PICTURE =0 ;
    EditText etName;
    EditText etAge;
    Spinner etGender;
    EditText etBreed;
    EditText etSize;
    CheckBox etNeutered;
    EditText etInfo;
    Spinner etColor;

    Button submitButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pet_form);

        // Spinner element
        Spinner spinner = (Spinner) findViewById(R.id.etGender);

        // Spinner click listener
        spinner.setOnItemSelectedListener(this);

        // Spinner Drop down elements
        List<String> categories = new ArrayList<String>();
        categories.add("Male");
        categories.add("Female");
        categories.add("Others");
        // Creating adapter for spinner
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, categories);

        // Drop down layout style - list view with radio button
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // attaching data adapter to spinner
        spinner.setAdapter(dataAdapter);

        submitButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Pet pet = new Pet();
        pet.name = etName.getText().toString();
        pet.age  = Integer.parseInt(etAge.getText().toString());
        pet.gender = etGender.getSelectedItem().toString();
        pet.breed  = etBreed.getText().toString();
        pet.size  = etSize.getText().toString();
        pet.neutered = etNeutered.isSelected();
        pet.info = etInfo.getText().toString();
        pet.color = etColor.getSelectedItem().toString();
        FirebaseUtil.addPet(pet);
        finish();
    }

 
        private void selectImage() {

            Intent intent = new Intent();
            intent.setType("image/*");
            intent.setAction(Intent.ACTION_GET_CONTENT);
            startActivityForResult(Intent.createChooser(intent, "Select Picture"), SELECT_PICTURE);
        }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}

