package com.jlmcdeveloper.exemplomvp;

import android.app.Application;

import com.jlmcdeveloper.exemplomvp.contract.ApplicationComponent;
import com.jlmcdeveloper.exemplomvp.contract.DaggerApplicationComponent;
import com.jlmcdeveloper.exemplomvp.module.AppModule;
import com.jlmcdeveloper.exemplomvp.module.SQLiteModule;


public class AndroidApplication extends Application {

    public static ApplicationComponent component;

    public static ApplicationComponent getComponent(){
        return component;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        component = buildComponent();
    }

    private ApplicationComponent buildComponent(){
        return DaggerApplicationComponent.builder()
                .appModule(new AppModule(this))
                .sQLiteModule(new SQLiteModule())
                .build();
    }

}
