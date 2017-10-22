package com.dhirajkumarcoder.android.tinderpets;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.dhirajkumarcoder.android.tinderpets.Model.UiModels.Pet;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by DHIRAJ KUMAR JAIN on 22-10-2017.
 */

public class FindingDogRecyclerAdapter extends RecyclerView.Adapter<FindingDogRecyclerAdapter.RecyclerViewHolder> {
    private ArrayList<Pet> pets =new ArrayList<>();
    public FindingDogRecyclerAdapter(ArrayList<Pet> arrayList2)
    {
        this.pets =arrayList2;
    }

    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.finddoglayout,parent,false);
      //  FindingDogRecyclerAdapter.RecyclerViewHolder recyclerViewHolder1=new FindingDogRecyclerAdapter.RecyclerViewHolder(view);
        FindingDogRecyclerAdapter.RecyclerViewHolder recyclerViewHolder1=new FindingDogRecyclerAdapter.RecyclerViewHolder(view);
        return recyclerViewHolder1;

    }

    @Override
    public void onBindViewHolder(FindingDogRecyclerAdapter.RecyclerViewHolder holder1, int position) {
        Pet pet = pets.get(position);
        Log.d("firebase",pet.photos.entrySet().iterator().next().getValue() );
        holder1.imageView.setImageBitmap(FirebaseUtil.decodeBase64(pet.photos.entrySet().iterator().next().getValue()));
        holder1.details.setText(
                        "<b>Name : </b>" + pet.name +
                        "<br/><b>Age</b> : " + pet.age +
                        "<br/><b>Breed</b> : " +pet.breed+
                        "<br/><b>Color</b> : " +pet.color+
                        "<br/><b>Gender</b> : " +pet.gender+
                        "<br/><b>Neutered</b> : " +pet.neutered+
                        "<br/><b>Size</b> : " +pet.size);
    }

    @Override
    public int getItemCount() {
        return pets.size();
    }

    public static class RecyclerViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.petimage) ImageView imageView;
        @BindView(R.id.subTitle) TextView details;

        public RecyclerViewHolder(View view) {
            super(view);
            ButterKnife.bind(view);
        }
    }
}