package com.jlmcdeveloper.exemplomvp.ui.base;

public interface MvpPresenter<V extends MvpView> {

    void onAttach(V mvpView);

    void onDetach();

}
