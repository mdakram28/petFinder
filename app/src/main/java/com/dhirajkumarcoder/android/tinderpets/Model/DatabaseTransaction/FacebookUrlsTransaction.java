package com.dhirajkumarcoder.android.tinderpets.Model.DatabaseTransaction;

import java.util.List;

import io.realm.Realm;

/**
 * Created by Abhinav on 22/10/17.
 */

public class FacebookUrlsTransaction implements Realm.Transaction {

    private List<FacebookUrls> urlsList ;

    public FacebookUrlsTransaction(List<FacebookUrls> urlsList) {
        this.urlsList = urlsList;
    }

    @Override
    public void execute(Realm realm) {
        realm.copyToRealmOrUpdate(urlsList) ;
    }
}
