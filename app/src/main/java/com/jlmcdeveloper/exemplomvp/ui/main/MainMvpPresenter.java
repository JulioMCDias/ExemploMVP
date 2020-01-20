package com.jlmcdeveloper.exemplomvp.ui.main;

import com.jlmcdeveloper.exemplomvp.ui.base.MvpPresenter;

public interface MainMvpPresenter<V extends MainMvpView> extends MvpPresenter<V> {

    void btnAddCar();

    void btnListCar();
}
