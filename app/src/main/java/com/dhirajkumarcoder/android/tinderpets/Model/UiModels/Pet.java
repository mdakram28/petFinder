package com.dhirajkumarcoder.android.tinderpets.Model.UiModels;

import com.dhirajkumarcoder.android.tinderpets.FirebaseUtil;

import java.util.ArrayList;
import java.util.HashMap;
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
    public HashMap<String,String> photos;
    public String info;
    public Map<String,String> healthDetails;
    public Map<String,String> preferences;
    public String color;

    public Pet(){
        id = FirebaseUtil.getNewId();
        photos = new HashMap<>();
        healthDetails = new HashMap<>();
        preferences = new HashMap<>();
    }

    @Override
    public String toString() {
        return "Pet{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", ownerid='" + ownerid + '\'' +
                ", gender='" + gender + '\'' +
                ", breed='" + breed + '\'' +
                ", size='" + size + '\'' +
                ", neutered=" + neutered +
                ", photos=" + photos +
                ", info='" + info + '\'' +
                ", healthDetails=" + healthDetails +
                ", preferences=" + preferences +
                ", color='" + color + '\'' +
                '}';
    }
}
