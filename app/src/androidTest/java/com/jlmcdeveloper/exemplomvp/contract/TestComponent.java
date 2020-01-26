package com.jlmcdeveloper.exemplomvp.contract;

import com.jlmcdeveloper.exemplomvp.data.db.CarsDAOTest;
import com.jlmcdeveloper.exemplomvp.module.ApplicationTestModule;

import javax.inject.Singleton;

import dagger.Component;


@Singleton
@Component(modules = ApplicationTestModule.class)
public interface TestComponent extends ApplicationComponent{

    void inject(CarsDAOTest carsDAOTest);
}