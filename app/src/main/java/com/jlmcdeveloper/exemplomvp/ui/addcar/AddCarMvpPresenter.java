package com.jlmcdeveloper.exemplomvp.ui.addcar;

import com.jlmcdeveloper.exemplomvp.ui.base.MvpPresenter;

public interface AddCarMvpPresenter<V extends AddCarMvpView> extends MvpPresenter<V> {

    void insertCar(String name, int ano);
}
