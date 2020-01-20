package com.jlmcdeveloper.exemplomvp.module;


import android.content.Context;

import androidx.appcompat.app.AppCompatActivity;

import com.jlmcdeveloper.exemplomvp.scope.ActivityContext;
import com.jlmcdeveloper.exemplomvp.ui.addcar.AddCarMvpPresenter;
import com.jlmcdeveloper.exemplomvp.ui.addcar.AddCarMvpView;
import com.jlmcdeveloper.exemplomvp.ui.addcar.AddCarPresenter;
import com.jlmcdeveloper.exemplomvp.ui.listcar.ListCarMvpPresenter;
import com.jlmcdeveloper.exemplomvp.ui.listcar.ListCarMvpView;
import com.jlmcdeveloper.exemplomvp.ui.listcar.ListCarPresenter;
import com.jlmcdeveloper.exemplomvp.ui.main.MainMvpPresenter;
import com.jlmcdeveloper.exemplomvp.ui.main.MainMvpView;
import com.jlmcdeveloper.exemplomvp.ui.main.MainPresenter;

import dagger.Module;
import dagger.Provides;

@Module
public class ActivityModule {

    private AppCompatActivity mActivity;


    public ActivityModule(AppCompatActivity activity){
        mActivity = activity;
    }

    @Provides
    @ActivityContext
    Context provideContext(){
        return mActivity;
    }

    @Provides
    AppCompatActivity provideActivity() {
        return mActivity;
    }


    @Provides
    MainMvpPresenter<MainMvpView> provideMainPresenter(MainPresenter<MainMvpView> presenter){
        return presenter;
    }


    @Provides
    AddCarMvpPresenter<AddCarMvpView> provideAddCarPresenter(AddCarPresenter<AddCarMvpView> presenter){
        return presenter;
    }

    @Provides
    ListCarMvpPresenter<ListCarMvpView> provideListCarPresenter(ListCarPresenter<ListCarMvpView> presenter){
        return presenter;
    }
}
