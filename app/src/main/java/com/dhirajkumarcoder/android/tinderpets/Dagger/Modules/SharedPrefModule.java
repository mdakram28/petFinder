package com.dhirajkumarcoder.android.tinderpets.Dagger.Modules;

import android.content.Context;
import android.content.SharedPreferences;

import com.dhirajkumarcoder.android.tinderpets.Model.Util.Constants;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Abhinav on 22/10/17.
 */

@Module
public class SharedPrefModule {
    Context context;
    SharedPreferences sharedPrefs;

    public SharedPrefModule(Context context){
        this.context=context;
        sharedPrefs = context.getSharedPreferences(Constants.SHARED_PREFS,Context.MODE_PRIVATE);
    }

    @Provides
    @Singleton
    SharedPreferences providesSharedPrefs() {
        return sharedPrefs;
    }

    @Provides
    @Singleton
    SharedPreferences.Editor providesSharedPrefsEditor() {
        return context.getSharedPreferences(Constants.SHARED_PREFS,Context.MODE_PRIVATE).edit();
    }

}

