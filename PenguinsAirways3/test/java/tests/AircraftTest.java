package tests;

import aircrafts.api.BaseAircraft;
import aircrafts.impl.Airplane;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class AircraftTest {

    @Test
    public void checkNewlyCreatedFuelType() {
        BaseAircraft aircraft = new Airplane("test", 1231231, 123123123, 111, 111, 111);
        Assert.assertEquals("test message", aircraft, aircraft);

    }

    @Before
    public void setUp() {

    }

    @After
    public void TearDown() {

    }
}
