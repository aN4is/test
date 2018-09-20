package aircrafts.impl;

import aircrafts.api.BaseAircraft;
import aircrafts.api.FuelType;

public class Balloon extends BaseAircraft {
    public Balloon(String name, float avgSpeed, float fuelCapacity, float currentFuelLevel, float consumptionRate, int maxDistance) {
        super(name, avgSpeed, fuelCapacity, currentFuelLevel, consumptionRate, maxDistance);
        this.fuelType = FuelType.GAS;
    }


    @Override
    public void isCreated(){
        System.out.println("Balloon " + getName() + " has been created successfully!! It is working on " + getFuelType());
    }
}
