package com.jlmcdeveloper.exemplomvp.ui.base;

import com.jlmcdeveloper.exemplomvp.data.DataManager;

import javax.inject.Inject;

public class BasePresenter<V extends MvpView> implements MvpPresenter<V>{

    private V mMvpView;

    private final DataManager mDataManager;

    @Inject
    public BasePresenter(DataManager dataManager){
        this.mDataManager = dataManager;
    }



    @Override
    public void onAttach(V mvpView) {
        this.mMvpView = mvpView;
    }

    @Override
    public void onDetach() {
        mMvpView = null;
    }

    public V getMvpView() {
        return mMvpView;
    }

    public DataManager getDataManager() {
        return mDataManager;
    }
}
