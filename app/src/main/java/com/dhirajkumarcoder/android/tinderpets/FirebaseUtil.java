package com.dhirajkumarcoder.android.tinderpets;

import com.dhirajkumarcoder.android.tinderpets.models.User;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;

/**
 * Created by srbhj on 21-10-2017.
 */

public class FirebaseUtil {
    static FirebaseDatabase database = FirebaseDatabase.getInstance();
    static DatabaseReference myRef = database.getReference("tinderpets-714d6");

    static HashMap<String, User> users = new HashMap<String, User>();

    static {
        myRef.child("users").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                users = (HashMap<String, User>) dataSnapshot.getValue();
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

    public static User getUserById(String id){
        return users.get(id);
    }
}
