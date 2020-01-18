package com.jlmcdeveloper.exemplomvp.module;

import android.app.Application;
import android.content.Context;

import androidx.annotation.NonNull;

import dagger.Module;
import dagger.Provides;

@Module
public class AppModule {
    Application myApplication;

    public AppModule(@NonNull Application application){
        myApplication = application;
    }

    @Provides
    public Context provideContext(){
        return myApplication;
    }
}