package com.jlmcdeveloper.exemplomvp.contract;


import com.jlmcdeveloper.exemplomvp.AndroidApplication;
import com.jlmcdeveloper.exemplomvp.data.DataManager;
import com.jlmcdeveloper.exemplomvp.module.ApplicationModule;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {

    void inject(AndroidApplication androidApplication);


    DataManager getDataManager();
}
