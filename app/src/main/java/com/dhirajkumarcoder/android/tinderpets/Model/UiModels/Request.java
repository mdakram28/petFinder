package com.dhirajkumarcoder.android.tinderpets.Model.UiModels;

/**
 * Created by srbhj on 22-10-2017.
 */

public class Request {
    public Pet pet;
    public User user;

    public Request(Pet pet, User user) {
        this.pet = pet;
        this.user = user;
    }
}
