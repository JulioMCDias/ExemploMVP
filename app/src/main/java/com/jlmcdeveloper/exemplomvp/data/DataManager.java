package com.jlmcdeveloper.exemplomvp.data;

import com.jlmcdeveloper.exemplomvp.data.db.model.Car;

import java.util.List;

public interface DataManager {

    void insertCar(final Car car);

    List<Car> getAllCars();

    void removeCar(Car car);
}
