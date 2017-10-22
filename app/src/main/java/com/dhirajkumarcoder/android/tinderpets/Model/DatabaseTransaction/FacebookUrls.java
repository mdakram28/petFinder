package com.dhirajkumarcoder.android.tinderpets.Model.DatabaseTransaction;

import io.realm.RealmObject;

/**
 * Created by Abhinav on 22/10/17.
 */

public class FacebookUrls extends RealmObject {

    private String url ;

    public FacebookUrls() {
    }

    public FacebookUrls(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
