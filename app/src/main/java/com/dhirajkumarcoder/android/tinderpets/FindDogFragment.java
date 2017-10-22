package com.dhirajkumarcoder.android.tinderpets;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link FindDogFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link FindDogFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FindDogFragment extends android.app.Fragment {
    RecyclerView recyclerView1;
    RecyclerView.Adapter adapter1;
    RecyclerView.LayoutManager layoutManager1;
    String [] details;
    int[] Img_Res={R.drawable.dog1,R.drawable.dog2,R.drawable.dog3,R.drawable.dog};
    ArrayList<FIndDogDataProvider> arrayList1=new ArrayList<FIndDogDataProvider>();
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
        recyclerView1=(RecyclerView)view1.findViewById(R.id.find_dog_recycler);
        details=getResources().getStringArray(R.array.detailarray);
        int i=0;
        for(String name:details)
        {
            FIndDogDataProvider dataprovider=new FIndDogDataProvider(Img_Res[i],name);
            arrayList1.add(dataprovider);
            i++;
        }
        adapter1=new FindingDogRecyclerAdapter(arrayList1);
        recyclerView1.setHasFixedSize(true);//improve the performance
        layoutManager1=new LinearLayoutManager(getContext());
        recyclerView1.setLayoutManager(layoutManager1);
        recyclerView1.setAdapter(adapter1);

        return view1;
    }

}