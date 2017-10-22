package com.dhirajkumarcoder.android.tinderpets.Presenter;

import android.util.Log;

import com.birbit.android.jobqueue.JobManager;
import com.dhirajkumarcoder.android.tinderpets.Interfaces.LoginInterface;
import com.dhirajkumarcoder.android.tinderpets.Model.Jobs.FacebookImagesJob;
import com.facebook.login.LoginResult;


import javax.inject.Inject;

/**
 * Created by Abhinav on 22/10/17.
 */

public class LoginPresenter implements LoginInterface{

    @Inject
    JobManager jobManager ;

    private LoginInterface loginInterface ;

    @Inject
    public LoginPresenter() {
    }

    public void register(LoginInterface loginInterface){
        this.loginInterface = loginInterface ;
        //EventBus.getDefault().register(this);
    }

    public void getRequiredImages(LoginResult loginResult) {
        Log.i("TAG", "Presenter here: ");
        jobManager.addJobInBackground(new FacebookImagesJob(loginResult));
    }


    public void unRegister(){
        //EventBus.getDefault().unregister(this);
    }
}
