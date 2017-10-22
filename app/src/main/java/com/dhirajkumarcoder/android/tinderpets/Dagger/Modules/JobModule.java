package com.dhirajkumarcoder.android.tinderpets.Dagger.Modules;

import android.content.Context;

import com.birbit.android.jobqueue.Job;
import com.birbit.android.jobqueue.JobManager;
import com.birbit.android.jobqueue.config.Configuration;
import com.birbit.android.jobqueue.di.DependencyInjector;
import com.dhirajkumarcoder.android.tinderpets.AppController;
import com.dhirajkumarcoder.android.tinderpets.Model.Jobs.BaseJob;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Abhinav on 22/10/17.
 */


@Module
public class JobModule {
    Context context;
    JobManager jobManager;

    public JobModule(final Context context){
        this.context = context;

        DependencyInjector dependencyInjector = new DependencyInjector() {
            @Override
            public void inject(Job job) {
                ((AppController) context.getApplicationContext()).get().inject((BaseJob) job);
            }
        };
        Configuration configuration = new Configuration.Builder(context.getApplicationContext())
                .minConsumerCount(5)
                .loadFactor(1)
                .injector(dependencyInjector)
                .build();
        jobManager = new JobManager(configuration);
    }

    @Provides
    @Singleton
    public JobManager providesJobManager(){
        return jobManager;
    }
}
