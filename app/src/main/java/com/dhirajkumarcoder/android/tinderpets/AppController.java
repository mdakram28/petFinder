package com.dhirajkumarcoder.android.tinderpets;

import android.app.Application;

import com.dhirajkumarcoder.android.tinderpets.Dagger.Components.AppComponent;
import com.dhirajkumarcoder.android.tinderpets.Dagger.Components.DaggerAppComponent;
import com.dhirajkumarcoder.android.tinderpets.Dagger.Modules.ApiModule;
import com.dhirajkumarcoder.android.tinderpets.Dagger.Modules.JobModule;
import com.dhirajkumarcoder.android.tinderpets.Dagger.Modules.SharedPrefModule;

import io.realm.Realm;

/**
 * Created by Abhinav on 22/10/17.
 */

public class AppController extends Application{

    private AppComponent appComponent ;

    @Override
    public void onCreate() {
        super.onCreate();

        Realm.init(this);

        this.appComponent = DaggerAppComponent.builder()
                .apiModule(new ApiModule())
                .sharedPrefModule(new SharedPrefModule(this))
                .jobModule(new JobModule(this))
                .build();
    }

    public AppComponent get() {
        return appComponent;
    }
}
