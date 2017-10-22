package com.dhirajkumarcoder.android.tinderpets;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link PutDogFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link PutDogFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PutDogFragment extends android.app.Fragment {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_put_dog, container, false);
    }
}