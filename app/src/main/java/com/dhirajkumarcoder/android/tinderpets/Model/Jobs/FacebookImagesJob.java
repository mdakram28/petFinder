package com.dhirajkumarcoder.android.tinderpets.Model.Jobs;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;

import com.birbit.android.jobqueue.Params;
import com.birbit.android.jobqueue.RetryConstraint;
import com.dhirajkumarcoder.android.tinderpets.Model.DatabaseTransaction.FacebookUrls;
import com.dhirajkumarcoder.android.tinderpets.Model.DatabaseTransaction.FacebookUrlsTransaction;
import com.dhirajkumarcoder.android.tinderpets.Model.UiModels.IndividualPhotoUrls;
import com.dhirajkumarcoder.android.tinderpets.Model.UiModels.UserAlbumPhotos;
import com.dhirajkumarcoder.android.tinderpets.Model.UiModels.UserAlbums;
import com.facebook.AccessToken;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.login.LoginResult;
import com.google.gson.Gson;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;

/**
 * Created by Abhinav on 22/10/17.
 */

public class FacebookImagesJob extends BaseJob{

    public static final int PRIORITY = 1;
    private LoginResult loginResult ;
    private AccessToken accessToken ;

    List<FacebookUrls> facebookUrlsList ;

    public FacebookImagesJob(LoginResult loginResult) {
        super(new Params(PRIORITY));
        this.loginResult = loginResult ;
        accessToken = loginResult.getAccessToken() ;
    }

    @Override
    public void onAdded() {

        Log.i("TAG", "FACEBOOK JOB onAdded: ");
        facebookUrlsList = new ArrayList<>() ;
    }

    @Override
    public void onRun() throws Throwable {



        GraphRequest request = GraphRequest.newGraphPathRequest(
                accessToken,
                "/me/albums",
                new GraphRequest.Callback() {
                    @Override
                    public void onCompleted(GraphResponse response) {

                        Log.i("TAG A", "onCompleted: ALBUMS " + response.getRawResponse());

                        final Gson gson = new Gson() ;
                        UserAlbums userAlbums = gson.fromJson(response.getRawResponse(), UserAlbums.class) ;

                        Log.i("TAG A", "onCompleted: RANDOM ALBUM ID " + userAlbums.getData()[0].getId());

                        for (int i = 0; i < 3; i++) {
                            GraphRequest request = GraphRequest.newGraphPathRequest(
                                    accessToken,
                                    "/" + userAlbums.getData()[i].getId() +  "/photos",
                                    new GraphRequest.Callback() {
                                        @Override
                                        public void onCompleted(GraphResponse response) {

                                            Log.i("TAG B", "onCompleted: ALBUM PHOTOS URLS" + response.getRawResponse());

                                            Gson gson1 = new Gson() ;
                                            IndividualPhotoUrls individualPhotoUrls = gson.fromJson(response.getRawResponse(), IndividualPhotoUrls.class) ;

                                            Log.i("TAG C", "onCompleted: " + individualPhotoUrls.getData()[0].getImages()[0].getSource());


                                            for (int j = 0; j < individualPhotoUrls.getData().length; j++) {
                                                facebookUrlsList.add(new FacebookUrls(individualPhotoUrls.getData()[j].getImages()[0].getSource())) ;
                                            }


                                            Realm realm = Realm.getDefaultInstance() ;
                                            realm.executeTransactionAsync(new FacebookUrlsTransaction(facebookUrlsList)) ;


                                            Log.i("TAG", "onCompleted: " + facebookUrlsList.size());
                                        }
                                    });

                            Bundle parameters = new Bundle();
                            parameters.putString("fields", "images");
                            request.setParameters(parameters);
                            request.executeAsync();
                        }


                    }
                });

        request.executeAsync();

    }

    @Override
    protected void onCancel(int cancelReason, @Nullable Throwable throwable) {

    }

    @Override
    protected RetryConstraint shouldReRunOnThrowable(@NonNull Throwable throwable, int runCount, int maxRunCount) {
        return null;
    }
}
