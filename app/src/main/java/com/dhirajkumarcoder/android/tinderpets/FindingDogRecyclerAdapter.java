package com.dhirajkumarcoder.android.tinderpets;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by DHIRAJ KUMAR JAIN on 22-10-2017.
 */

public class FindingDogRecyclerAdapter extends RecyclerView.Adapter<FindingDogRecyclerAdapter.RecyclerViewHolder> {
    private ArrayList<FIndDogDataProvider> arrayList1=new ArrayList<>();
    public FindingDogRecyclerAdapter(ArrayList<FIndDogDataProvider> arrayList2)
    {
        this.arrayList1=arrayList2;
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
        FIndDogDataProvider dataprovider=arrayList1.get(position);
        holder1.imageView.setImageResource(dataprovider.getimg());
        holder1.details.setText(dataprovider.getdetails());




    }

    @Override
    public int getItemCount() {
        return arrayList1.size();
    }
    public static class RecyclerViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView details;

        public RecyclerViewHolder(View view) {
            super(view);
            imageView = (ImageView) view.findViewById(R.id.imageViewfinddog);
            details=(TextView)view.findViewById(R.id.TextViewfinddog);


        }
    }
}