package com.dhirajkumarcoder.android.tinderpets.Dagger.Components;

import com.dhirajkumarcoder.android.tinderpets.Dagger.Modules.ApiModule;
import com.dhirajkumarcoder.android.tinderpets.Dagger.Modules.JobModule;
import com.dhirajkumarcoder.android.tinderpets.Dagger.Modules.SharedPrefModule;
import com.dhirajkumarcoder.android.tinderpets.LoginActivity;
import com.dhirajkumarcoder.android.tinderpets.Model.Jobs.BaseJob;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by Abhinav on 22/10/17.
 */

@Component(modules = {ApiModule.class, SharedPrefModule.class, JobModule.class})
@Singleton
public interface AppComponent {

    void inject(BaseJob job) ;
    void inject(LoginActivity loginActivity) ;
}
