package com.jlmcdeveloper.exemplomvp.contract;

import com.jlmcdeveloper.exemplomvp.module.RecycleAdapterModule;
import com.jlmcdeveloper.exemplomvp.scope.PerActivity;
import com.jlmcdeveloper.exemplomvp.ui.listcar.ListCarActivity;

import dagger.Component;

@Component(dependencies = ApplicationComponent.class, modules = RecycleAdapterModule.class)
@PerActivity
public interface ActivityComponent {
    void inject(ListCarActivity listCarActivity);
}
