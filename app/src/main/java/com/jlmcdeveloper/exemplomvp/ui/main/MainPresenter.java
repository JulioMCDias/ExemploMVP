package com.jlmcdeveloper.exemplomvp.ui.main;

import com.jlmcdeveloper.exemplomvp.data.DataManager;
import com.jlmcdeveloper.exemplomvp.ui.base.BasePresenter;

import javax.inject.Inject;

public class MainPresenter<V extends MainMvpView> extends BasePresenter<V> implements MainMvpPresenter<V>{

    @Inject
    public MainPresenter(DataManager dataManager) {
        super(dataManager);
    }


    @Override
    public void btnAddCar() {
        getMvpView().openAddCarActivity();
    }

    @Override
    public void btnListCar() {
        getMvpView().openListCarActivity();
    }
}
