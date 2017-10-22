package com.dhirajkumarcoder.android.tinderpets;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dhirajkumarcoder.android.tinderpets.Model.UiModels.Pet;
import com.dhirajkumarcoder.android.tinderpets.interfaces.PetsReceived;

import java.util.ArrayList;
import java.util.List;

public class FindDogFragment extends android.app.Fragment {
    RecyclerView recyclerView1;
    RecyclerView.Adapter adapter1;
    RecyclerView.LayoutManager layoutManager1;
    String[] details;
    int[] Img_Res = {R.drawable.dog1, R.drawable.dog2, R.drawable.dog3, R.drawable.dog};
    ArrayList<Pet> pets = new ArrayList<Pet>();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        System.out.println("H");

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View view1 = inflater.inflate(R.layout.fragment_find_dog, container, false);
        recyclerView1 = (RecyclerView) view1.findViewById(R.id.find_dog_recycler);
        FirebaseUtil.getAllPets(new PetsReceived() {
            @Override
            public void petsReceived(ArrayList<Pet> pets) {
                adapter1 = new FindingDogRecyclerAdapter(pets);
                recyclerView1.setHasFixedSize(true);//improve the performance
                layoutManager1 = new LinearLayoutManager(getContext());
                recyclerView1.setLayoutManager(layoutManager1);
                recyclerView1.setAdapter(adapter1);
            }
        });

        return view1;
    }

}