package com.jlmcdeveloper.exemplomvp.data.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import com.jlmcdeveloper.exemplomvp.data.db.model.Car;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

public class CarsDAO {
    private SQLiteDatabase database ;


    CustomSQLiteOpenHelper sqliteOpenHelper ;

    private String [] columns = { CustomSQLiteOpenHelper.COLUMN_ID,
            CustomSQLiteOpenHelper.COLUMN_NAMES,
            CustomSQLiteOpenHelper.COLUMN_YEAR};


    @Inject
    public CarsDAO (CustomSQLiteOpenHelper sqliteOpenHelper) {
        this.sqliteOpenHelper = sqliteOpenHelper;
    }


    public void open () throws SQLException {
        database = sqliteOpenHelper.getWritableDatabase();
    }


    public void close () {
        sqliteOpenHelper.close();
    }


    public Car create ( Car car ) {
        ContentValues values = new ContentValues();
        values.put(CustomSQLiteOpenHelper.COLUMN_NAMES, car.getName());
        values.put(CustomSQLiteOpenHelper.COLUMN_YEAR, car.getYear());
        long insertId = database.insert(CustomSQLiteOpenHelper.TABLE_CARS, null,
                values);
        Cursor cursor = database.query(CustomSQLiteOpenHelper.TABLE_CARS,
                columns, CustomSQLiteOpenHelper.COLUMN_ID + " = " + insertId, null,
                null, null, null);
        cursor.moveToFirst();
        Car newCar = new Car();
        newCar.setId(cursor.getLong(0));
        newCar.setName(cursor.getString(1));
        newCar.setYear(cursor.getInt(2));
        cursor.close();
        return newCar;
    }


    public void delete ( Car car ) {
        long id = car.getId();
        database.delete(CustomSQLiteOpenHelper.TABLE_CARS, CustomSQLiteOpenHelper.COLUMN_ID
                + " = " + id, null);
    }

    public List<Car> getAll () {
        List<Car> cars = new ArrayList<>();
        Cursor cursor = database.query(CustomSQLiteOpenHelper.TABLE_CARS,
                columns, null, null, null, null, null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            Car car = new Car();
            car.setId(cursor.getLong(0));
            car.setName(cursor.getString(1));
            car.setYear(cursor.getInt(2));
            cars.add(car);
            cursor.moveToNext();
        }
        cursor.close();
        return cars;
    }
}
