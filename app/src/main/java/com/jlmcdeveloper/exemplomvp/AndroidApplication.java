package com.jlmcdeveloper.exemplomvp;

import android.app.Application;

import com.jlmcdeveloper.exemplomvp.contract.ApplicationComponent;
import com.jlmcdeveloper.exemplomvp.contract.DaggerApplicationComponent;
import com.jlmcdeveloper.exemplomvp.module.ApplicationModule;


public class AndroidApplication extends Application {

    private ApplicationComponent component;

    public ApplicationComponent getComponent(){
        return component;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        component = buildComponent();
    }

    private ApplicationComponent buildComponent(){
        return DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .build();
    }

}
