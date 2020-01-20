package com.jlmcdeveloper.exemplomvp.contract;

import com.jlmcdeveloper.exemplomvp.module.ActivityModule;
import com.jlmcdeveloper.exemplomvp.scope.PerActivity;
import com.jlmcdeveloper.exemplomvp.ui.addcar.AddCarActivity;
import com.jlmcdeveloper.exemplomvp.ui.listcar.ListCarActivity;
import com.jlmcdeveloper.exemplomvp.ui.main.MainActivity;

import dagger.Component;

@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {

    void inject(MainActivity mainActivity);

    void inject(ListCarActivity listCarActivity);

    void inject(AddCarActivity addCarActivity);
}
