package com.jlmcdeveloper.exemplomvp.data;

import android.util.Log;

import com.jlmcdeveloper.exemplomvp.data.db.CarsDAO;
import com.jlmcdeveloper.exemplomvp.data.db.model.Car;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import javax.inject.Inject;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


@RunWith(MockitoJUnitRunner.class)
public class AppDataManagerTest {

    @Mock
    CarsDAO carsDAO;

    private DataManager mDataManager;
    private String NAME_CAR = "teste Unitario";

    @Before
    public void setUp(){
        mDataManager = new AppDataManager(carsDAO);
    }

    @Test
    public void insertCar() {
        Car car = new Car(NAME_CAR,1850);

        mDataManager.insertCar(car);

        assertTrue(mDataManager.getAllCars().size() > 0);
    }

    @Test
    public void getAllCars() {
        List<Car> carList = mDataManager.getAllCars();

        Car car = null;
        for (Car c : carList) {
            Log.e("Car: ", c.getName());
            if (c.getName().contains(NAME_CAR))
                car = c;
        }

        assert car != null;
        assertEquals(NAME_CAR, car.getName());
        assertEquals(18850, car.getYear());
    }

    @Test
    public void removeCar() {
        List<Car> carList = mDataManager.getAllCars();

        for (Car car : carList) {
            if (car.getName().contains(NAME_CAR))
                mDataManager.removeCar(car);
        }

    }
}