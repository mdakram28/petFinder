package com.dhirajkumarcoder.android.tinderpets;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Base64;
import android.util.Log;

import com.dhirajkumarcoder.android.tinderpets.Model.UiModels.Pet;
import com.dhirajkumarcoder.android.tinderpets.Model.UiModels.User;
import com.dhirajkumarcoder.android.tinderpets.Interfaces.*;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by srbhj on 21-10-2017.
 */

public class FirebaseUtil {
    static FirebaseDatabase database;
    static DatabaseReference myRef;
//    public HashMap<String, Pet> allPets = new HashMap<>();

//    static HashMap<String, User> users = new HashMap<String, User>();

    public FirebaseUtil(){
        database = FirebaseDatabase.getInstance();
        myRef = database.getReference();
        Log.d("firebase","Attaching listender");

    }

    public static void getAllPets(final PetsReceived callback){
        myRef.child("pets").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                ArrayList<Pet> allPets = new ArrayList<Pet>();
                for(DataSnapshot child : dataSnapshot.getChildren()){
                    allPets.add(child.getValue(Pet.class));
                }

                Log.d("firebase",allPets.toString());
                callback.petsReceived(allPets);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

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
        myRef.child("users").child(id).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                callback.userReceived(dataSnapshot.getValue(User.class));
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    public static String encodeBitmap(Bitmap image){
        ByteArrayOutputStream byteArrayOS = new ByteArrayOutputStream();
        image.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOS);
        return Base64.encodeToString(byteArrayOS.toByteArray(), Base64.DEFAULT);
    }

    public static Bitmap decodeBase64(String input){
        byte[] decodedBytes = Base64.decode(input, Base64.DEFAULT);
        Log.d("firebase", Arrays.toString(decodedBytes));
        Bitmap ret = BitmapFactory.decodeByteArray(decodedBytes, 0, decodedBytes.length);
        Log.d("firebase", ret.toString());
        return ret;
    }


}
