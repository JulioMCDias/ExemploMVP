package com.jlmcdeveloper.exemplomvp.data.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import javax.inject.Inject;

public class CustomSQLiteOpenHelper extends SQLiteOpenHelper {
    public static final String TABLE_CARS = "cars";
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_NAMES = "name";
    public static final String COLUMN_YEAR = "year";
    private static final String DATABASE_NAME = "cars.db";
    private static final int DATABASE_VERSION = 1;

    // Database creation sql statement
    private static final String DATABASE_CREATE = " create table "
            + TABLE_CARS + "(" + COLUMN_ID
            + " integer primary key autoincrement , " + COLUMN_NAMES
            + " text not null , " + COLUMN_YEAR + " integer );";

    @Inject
    public CustomSQLiteOpenHelper ( Context context ) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate ( SQLiteDatabase database ) {
        database.execSQL(DATABASE_CREATE);
    }

    @Override
    public void onUpgrade ( SQLiteDatabase db , int oldVersion , int newVersion ) {
        db.execSQL(" DROP TABLE IF EXISTS " + TABLE_CARS);
        onCreate(db);
    }
}