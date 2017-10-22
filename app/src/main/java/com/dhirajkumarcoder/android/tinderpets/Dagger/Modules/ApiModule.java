package com.dhirajkumarcoder.android.tinderpets.Dagger.Modules;

import com.dhirajkumarcoder.android.tinderpets.Model.RetroAPI;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Abhinav on 22/10/17.
 */

@Module
public class ApiModule {
    @Provides
    @Singleton
    RetroAPI provideRetroAPI(){ return new RetroAPI();}
}
