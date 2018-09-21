package aircrafts.impl;

import aircrafts.api.BaseAircraft;
import aircrafts.api.FuelType;

public class Airplane extends BaseAircraft {
    public Airplane(String name, float avgSpeed, float fuelCapacity, float currentFuelLevel, float consumptionRate, int maxDistance) {
        super(name, avgSpeed, fuelCapacity, currentFuelLevel, consumptionRate, maxDistance);
        this.fuelType = FuelType.PETROL;
    }

    @Override
    public void isCreated(){
        System.out.println("AIRPLANE " + getName() + " (" + getFuelType() + " -- FUEL LEVEL -- " + getCurrentFuelLevel() + "/" + (int)getFuelCapacity() + ")");
    }

}
