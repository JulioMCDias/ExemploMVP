package com.jlmcdeveloper.exemplomvp.data.db;

import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.platform.app.InstrumentationRegistry;

import com.jlmcdeveloper.exemplomvp.TestComponentRule;
import com.jlmcdeveloper.exemplomvp.data.db.model.Car;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.RuleChain;
import org.junit.rules.TestRule;
import org.junit.runner.RunWith;

import javax.inject.Inject;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

@RunWith(AndroidJUnit4.class)
public class CarsDAOTest {
    private String NAME_CAR = "teste Unitario";

    @Inject
    CarsDAO carsDAO;


    public final TestComponentRule component =
            new TestComponentRule(InstrumentationRegistry.getInstrumentation().getTargetContext());

    @Rule
    public TestRule chain = RuleChain.outerRule(component);


    @Before
    public void setUp() throws Exception {
        component.getTestComponent().inject(this);
        carsDAO.open();
    }

    @After
    public void tearDown() throws Exception {
        carsDAO.close();
    }

    @Test
    public void create() {
        Car car = new Car(NAME_CAR,1850);
        carsDAO.create(car);
        assertTrue(carsDAO.getAll().size() > 0);
    }

    @Test
    public void getAll() {
        assertTrue(carsDAO.getAll().size() > 0);
    }

    @Test
    public void delete() {
        Car car = null;
        for (Car c : carsDAO.getAll()) {
            if (c.getName().contains(NAME_CAR))
                car = c;
        }
        assertNotNull(car);
        carsDAO.delete(car);

        car = null;
        for (Car c : carsDAO.getAll()) {
            if (c.getName().contains(NAME_CAR))
                car = c;
        }
        assertNull(car);
    }
}