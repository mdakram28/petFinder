package com.dhirajkumarcoder.android.tinderpets.Model.Jobs;

import android.content.SharedPreferences;

import com.birbit.android.jobqueue.Job;
import com.birbit.android.jobqueue.Params;
import com.dhirajkumarcoder.android.tinderpets.Model.RetroAPI;

import javax.inject.Inject;

/**
 * Created by Abhinav on 22/10/17.
 */

abstract public class BaseJob extends Job {
    @Inject
    RetroAPI retroAPI;
    @Inject
    SharedPreferences sharedPreferences;
    @Inject
    SharedPreferences.Editor sharedPreferencesEditor;

    public BaseJob(Params params) {
        super(params);
    }
}