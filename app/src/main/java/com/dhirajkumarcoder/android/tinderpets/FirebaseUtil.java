package com.dhirajkumarcoder.android.tinderpets;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Base64;
import android.util.Log;

import com.dhirajkumarcoder.android.tinderpets.Model.UiModels.Pet;
import com.dhirajkumarcoder.android.tinderpets.Model.UiModels.Request;
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
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by srbhj on 21-10-2017.
 */

public class FirebaseUtil {
    static FirebaseDatabase database;
    static DatabaseReference myRef;
//    public HashMap<String, Pet> allPets = new HashMap<>();

    static HashMap<String, User> allUsers = new HashMap<String, User>();

    public FirebaseUtil(){
        database = FirebaseDatabase.getInstance();
        myRef = database.getReference();
        Log.d("firebase","Attaching listender");
        myRef.child("users").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                allUsers.clear();
                for(DataSnapshot child : dataSnapshot.getChildren()){
                    allUsers.put(child.getKey(), child.getValue(User.class));
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    public static void getAllPets(final PetsReceived callback){
        myRef.child("pets").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                ArrayList<Pet> allPets = new ArrayList<Pet>();
                for(DataSnapshot child : dataSnapshot.getChildren()){
                    allPets.add(child.getValue(Pet.class));
                }

                callback.petsReceived(allPets);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

    }

    public static void getAllUserPets(final String userid, final PetsReceived callback){
        myRef.child("pets").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                ArrayList<Pet> allPets = new ArrayList<Pet>();
                for(DataSnapshot child : dataSnapshot.getChildren()){
                    Pet pet = child.getValue(Pet.class);
                    if(pet.ownerid == userid)
                        allPets.add(pet);
                }

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

    public void sendRequest(String petid,String userid){
        myRef.child("pets").child(petid).child("requests").child(userid).setValue(new Date().getTime());
    }

    public void getAllUserRequests(String userid, final RequestsReceived callback){
        getAllUserPets(userid, new PetsReceived() {
            @Override
            public void petsReceived(ArrayList<Pet> pets) {
                ArrayList<Request> requests = new ArrayList<Request>();
                for(Pet pet : pets){
                    Iterator it = pet.requests.entrySet().iterator();
                    while (it.hasNext()) {
                        Map.Entry pair = (Map.Entry)it.next();
                        requests.add(new Request(pet, allUsers.get(pair.getKey())));
                        it.remove(); // avoids a ConcurrentModificationException
                    }
                }
                callback.requestsReceived(requests);
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
