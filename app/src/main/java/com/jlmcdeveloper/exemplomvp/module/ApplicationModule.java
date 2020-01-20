package com.jlmcdeveloper.exemplomvp.module;

import android.app.Application;
import android.content.Context;

import androidx.annotation.NonNull;

import com.jlmcdeveloper.exemplomvp.data.AppDataManager;
import com.jlmcdeveloper.exemplomvp.data.DataManager;
import com.jlmcdeveloper.exemplomvp.data.db.CarsDAO;
import com.jlmcdeveloper.exemplomvp.data.db.CustomSQLiteOpenHelper;
import com.jlmcdeveloper.exemplomvp.scope.ApplicationContext;
import com.jlmcdeveloper.exemplomvp.utils.Constants;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class ApplicationModule {
    private Application myApplication;

    public ApplicationModule(@NonNull Application application){
        myApplication = application;
    }

    @Provides
    @ApplicationContext
    Context provideContext(){
        return myApplication;
    }

    @Provides
    @Singleton
    DataManager provideDataManager(AppDataManager dataManager){
        return dataManager;
    }


    @Provides
    String provideDatabaseName(){
        return Constants.DATABASE_NAME;
    }


    @Provides
    @Singleton
    CustomSQLiteOpenHelper provideCustomSQLiteOpenHelper(@ApplicationContext Context context, String databaseName){
        return new CustomSQLiteOpenHelper(context, databaseName);
    }

    @Provides
    @Singleton
    CarsDAO provideCarsDAO(CustomSQLiteOpenHelper sqLiteOpenHelper){
        return new CarsDAO(sqLiteOpenHelper);
    }

}