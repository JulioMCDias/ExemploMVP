package com.jlmcdeveloper.exemplomvp.contract;


import com.jlmcdeveloper.exemplomvp.module.AppModule;
import com.jlmcdeveloper.exemplomvp.module.SQLiteModule;
import com.jlmcdeveloper.exemplomvp.ui.addcar.AddCarActivity;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {AppModule.class, SQLiteModule.class})
public interface ApplicationComponent {
    void inject(AddCarActivity addCarActivity);
}
