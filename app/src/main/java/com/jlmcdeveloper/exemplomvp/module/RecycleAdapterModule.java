package com.jlmcdeveloper.exemplomvp.module;

import android.content.Context;

import androidx.appcompat.app.AppCompatActivity;

import com.jlmcdeveloper.exemplomvp.data.db.CarsDAO;
import com.jlmcdeveloper.exemplomvp.scope.PerActivity;
import com.jlmcdeveloper.exemplomvp.ui.listcar.RecycleAdapter;

import javax.inject.Inject;

import dagger.Module;
import dagger.Provides;

@Module
public class RecycleAdapterModule {
    private AppCompatActivity mActivity;


    public RecycleAdapterModule(AppCompatActivity appCompatActivity){
        this.mActivity = appCompatActivity;
    }

    @Provides
    @PerActivity
    public Context provideContext() {
        return mActivity;
    }


    @Provides
    @PerActivity
    @Inject
    public RecycleAdapter provideRecycleAdapter(CarsDAO carsDAO){
        carsDAO.open();
        RecycleAdapter adapter = new RecycleAdapter(carsDAO.getAll());
        carsDAO.close();
        return adapter;
    }
}
