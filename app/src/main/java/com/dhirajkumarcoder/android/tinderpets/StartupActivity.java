package com.dhirajkumarcoder.android.tinderpets;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
public class StartupActivity extends AppCompatActivity {

   // private TextView mTextMessage;

    protected BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_dog:
                    FragmentManager fragmentManager = getFragmentManager();
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                    PutDogFragment pf = new PutDogFragment();
                    fragmentTransaction.add(R.id.content, pf, null);
                    fragmentTransaction.commit();
                    return true;
                case R.id.navigation_maps:
                    FragmentManager fragmentManager1 = getFragmentManager();
                    FragmentTransaction fragmentTransaction1 = fragmentManager1.beginTransaction();
                    FindDogFragment pf1 = new FindDogFragment();
                    fragmentTransaction1.add(R.id.content, pf1, null);
                    fragmentTransaction1.commit();
                  //  mTextMessage.setText(R.string.title_dashboard);
                    return true;
                case R.id.navigation_profile:
                    FragmentManager fragmentManager2 = getFragmentManager();
                    FragmentTransaction fragmentTransaction2 = fragmentManager2.beginTransaction();
                    ProfileFragment pf2 = new ProfileFragment();
                    fragmentTransaction2.add(R.id.content, pf2, null);
                    fragmentTransaction2.commit();
                    return true;
            }
            return false;
        }

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_startup);

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        FragmentManager fragmentManager=getFragmentManager();
        FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
        PutDogFragment pf=new PutDogFragment();
        fragmentTransaction.add(R.id.content, pf, null);
        fragmentTransaction.commit();
    }

}
