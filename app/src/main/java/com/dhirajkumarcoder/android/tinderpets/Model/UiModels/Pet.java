package com.dhirajkumarcoder.android.tinderpets.Model.UiModels;

import com.dhirajkumarcoder.android.tinderpets.FirebaseUtil;

import java.util.List;
import java.util.Map;

/**
 * Created by srbhj on 21-10-2017.
 */

public class Pet {
    /*
    * name
    * ownerid
    * age
    * gender
    * breed
    * size
    * neutered
    * photos
    * info
    * healthDetails
    *       Map<String,String>
    * preferences:
    *       Map<String,String>
    * */

    public String id;
    public String name;
    public int age;
    public String ownerid;
    public String gender;
    public String breed;
    public String size;
    public boolean neutered;
    public List<String> photos;
    public String info;
    public Map<String,String> healthDetails;
    public Map<String,String> preferences;
    public String color;

    public Pet(){
        id = FirebaseUtil.getNewId();
    }
}
