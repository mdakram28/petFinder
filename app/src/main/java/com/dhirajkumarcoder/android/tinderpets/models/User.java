package com.dhirajkumarcoder.android.tinderpets.models;

import com.dhirajkumarcoder.android.tinderpets.FirebaseUtil;

/**
 * Created by srbhj on 21-10-2017.
 */

public class User {
    /*
Full Name:
Email Address:
Contact Number:
DOB:
H. no./Street:
City:
State:
Zip Code:
Country:
Checkbox
     */
    public String id;
    public String name;
    public String address;
    public String phone;
    public String dob;
    public String city;
    public String state;
    public String zipCode;
    public String country;
    public String shelter;
    public String info;
    public boolean verified;

    public User(){
        id = FirebaseUtil.getNewId();
    }
}
