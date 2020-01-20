package com.jlmcdeveloper.exemplomvp.ui.addcar;

import com.jlmcdeveloper.exemplomvp.data.DataManager;
import com.jlmcdeveloper.exemplomvp.data.db.model.Car;
import com.jlmcdeveloper.exemplomvp.ui.base.BasePresenter;

import javax.inject.Inject;

public class AddCarPresenter<V extends AddCarMvpView> extends BasePresenter<V> implements AddCarMvpPresenter<V> {

    private DataManager dataManager;

    @Inject
    public AddCarPresenter(DataManager dataManager) {
        super(dataManager);
        this.dataManager = dataManager;
    }


    @Override
    public void insertCar(String name, int ano) {
        dataManager.insertCar(new Car(name, ano));
        getMvpView().closeActivity();
    }
}
