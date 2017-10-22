package com.dhirajkumarcoder.android.tinderpets;

/**
 * Created by DHIRAJ KUMAR JAIN on 22-10-2017.
 */

public class FIndDogDataProvider {
    public FIndDogDataProvider(int img,String details)
    {

        this.setdetails(details);
        this.setimg(img);

    }
    private int img;
    private String details;
    public void setdetails(String details) {
        this.details = details;
    }

    public String getdetails() {
        return details;
    }




    public int getimg() {
        return img;
    }

    public void setimg(int img) {
        this.img = img;
    }


}



