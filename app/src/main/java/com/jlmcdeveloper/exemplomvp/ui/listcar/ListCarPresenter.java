package com.jlmcdeveloper.exemplomvp.ui.listcar;

import com.jlmcdeveloper.exemplomvp.data.DataManager;
import com.jlmcdeveloper.exemplomvp.data.db.model.Car;
import com.jlmcdeveloper.exemplomvp.ui.base.BasePresenter;


import java.util.List;

import javax.inject.Inject;

public class ListCarPresenter<V extends ListCarMvpView> extends BasePresenter<V> implements ListCarMvpPresenter<V> {

    private DataManager dataManager;

    @Inject
    public ListCarPresenter(DataManager dataManager) {
        super(dataManager);
        this.dataManager = dataManager;
    }


    @Override
    public List<Car> getAllCars() {
        return dataManager.getAllCars();
    }

    @Override
    public void removeCar(Car car) {
        dataManager.removeCar(car);
    }
}
