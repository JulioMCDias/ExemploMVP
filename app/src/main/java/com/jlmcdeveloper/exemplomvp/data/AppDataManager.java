package com.jlmcdeveloper.exemplomvp.data;

import android.content.Context;

import com.jlmcdeveloper.exemplomvp.data.db.CarsDAO;
import com.jlmcdeveloper.exemplomvp.data.db.CustomSQLiteOpenHelper;
import com.jlmcdeveloper.exemplomvp.data.db.model.Car;
import com.jlmcdeveloper.exemplomvp.scope.ApplicationContext;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;


@Singleton
public class AppDataManager implements DataManager {

    private Context context;
    private CarsDAO carsDAO;

    @Inject
    public AppDataManager(@ApplicationContext Context context, CarsDAO carsDAO) {
        this.context = context;
        this.carsDAO = carsDAO;
    }



    @Override
    public void insertCar(Car car) {
        carsDAO.open();
        carsDAO.create(car);
        carsDAO.close();
    }

    @Override
    public List<Car> getAllCars() {
        carsDAO.open();
        List<Car> cars = carsDAO.getAll();
        carsDAO.close();

        return cars;
    }
}
