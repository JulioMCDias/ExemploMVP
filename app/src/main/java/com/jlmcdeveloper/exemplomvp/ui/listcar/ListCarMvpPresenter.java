package com.jlmcdeveloper.exemplomvp.ui.listcar;

import com.jlmcdeveloper.exemplomvp.data.db.model.Car;
import com.jlmcdeveloper.exemplomvp.ui.base.MvpPresenter;

import java.util.List;

public interface ListCarMvpPresenter<V extends ListCarMvpView> extends MvpPresenter<V> {

    List<Car> getAllCars();

}
