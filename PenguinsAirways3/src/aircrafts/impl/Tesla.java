package aircrafts.impl;

import aircrafts.api.BaseRechargable;
import aircrafts.api.FuelType;

import static utils.Utilities.round;

public class Tesla extends BaseRechargable {
    private double currentBatteryCapacity;

    public double getCurrentBatteryCapacity() {
        return currentBatteryCapacity;
    }

    public void setCurrentBatteryCapacity(double currentBatteryCapacity) {
        this.currentBatteryCapacity = currentBatteryCapacity;
    }

    public Tesla(String name, float avgSpeed, double maxBatteryCapacity, double batteryConsumptionRate, int maxDistance) {
        super(name, avgSpeed, maxBatteryCapacity, batteryConsumptionRate, maxDistance);
        setCurrentBatteryCapacity(round((Math.random() * getMaxBatteryCapacity() + 1), 1));
        this.fuelType = FuelType.ELECTRICITY;
    }

    @Override
    public void isCreated() {
        System.out.println("TESLA " + getName() + " (" + getFuelType() + " -- POWER LEVEL -- " + getCurrentBatteryCapacity() + "/" + (int)getMaxBatteryCapacity() + ")");
    }

}

