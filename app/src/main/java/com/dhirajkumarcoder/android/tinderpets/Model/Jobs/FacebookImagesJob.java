package com.dhirajkumarcoder.android.tinderpets.Model.Jobs;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;

import com.birbit.android.jobqueue.Params;
import com.birbit.android.jobqueue.RetryConstraint;
import com.facebook.AccessToken;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.login.LoginResult;

/**
 * Created by Abhinav on 22/10/17.
 */

public class FacebookImagesJob extends BaseJob{

    public static final int PRIORITY = 1;
    private LoginResult loginResult ;
    private AccessToken accessToken ;

    public FacebookImagesJob(LoginResult loginResult) {
        super(new Params(PRIORITY));
        this.loginResult = loginResult ;
        accessToken = loginResult.getAccessToken() ;
    }

    @Override
    public void onAdded() {
        Log.i("TAG", "FACEBOOK JOB onAdded: ");
    }

    @Override
    public void onRun() throws Throwable {

        GraphRequest request = GraphRequest.newGraphPathRequest(
                accessToken,
                "/me/albums",
                new GraphRequest.Callback() {
                    @Override
                    public void onCompleted(GraphResponse response) {

                        Log.i("TAG", "onCompleted: " + response.getRawResponse());


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
