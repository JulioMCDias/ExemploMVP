package com.jlmcdeveloper.exemplomvp.module;

import android.content.Context;

import com.jlmcdeveloper.exemplomvp.data.db.CarsDAO;
import com.jlmcdeveloper.exemplomvp.data.db.CustomSQLiteOpenHelper;

import javax.inject.Inject;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class SQLiteModule {

    @Provides
    @Singleton
    @Inject
    public CustomSQLiteOpenHelper provideCustomSQLiteOpenHelper(Context context){
        return new CustomSQLiteOpenHelper(context);
    }

    @Provides
    @Singleton
    @Inject
    public CarsDAO provideCarsDAO(CustomSQLiteOpenHelper sqLiteOpenHelper){
        return new CarsDAO(sqLiteOpenHelper);
    }
}
