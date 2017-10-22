package com.dhirajkumarcoder.android.tinderpets;

import android.util.Log;

import com.dhirajkumarcoder.android.tinderpets.interfaces.UserReceived;
import com.dhirajkumarcoder.android.tinderpets.Model.UiModels.Pet;
import com.dhirajkumarcoder.android.tinderpets.Model.UiModels.User;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

/**
 * Created by srbhj on 21-10-2017.
 */

public class FirebaseUtil {
    static FirebaseDatabase database;
    static DatabaseReference myRef;

//    static HashMap<String, User> users = new HashMap<String, User>();

    public FirebaseUtil(){
        database = FirebaseDatabase.getInstance();
        myRef = database.getReference();
        Log.d("firebase","Attaching listender");
    }

    public static String getNewId(){
        return Integer.toString((int)(Math.random()*10000));
    }

    public static void addUser(User user){
        DatabaseReference usersRef = myRef.child("users");
        usersRef.child(user.id).setValue(user);
    }

    public static void addPet(Pet pet){
        myRef.child("pets").child(pet.id).setValue(pet);
    }

    public static void getUserById(String id, final UserReceived callback){
        myRef.child("users").child(id).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                callback.userReceived(dataSnapshot.getValue(User.class));
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

}
