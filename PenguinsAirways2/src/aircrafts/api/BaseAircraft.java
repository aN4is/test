package aircrafts.api;

import aircrafts.errors.NoFuelException;
import aircrafts.errors.TurbulanceException;
import com.sun.istack.internal.NotNull;

import java.util.Random;

import static utils.Utilities.randomBool;

public abstract class BaseAircraft {

    private String name;
    private float avgSpeed; //km/h
    private float fuelCapacity; // liters
    private float currentFuelLevel; // liters
    private float consumptionRate; // liters/100km
    private int maxDistance; // km
    private double maxBatteryCapacity; // mAh
    private double batteryConsumptionRate; // mAh/100km
    protected FuelType fuelType;

    Random random = new Random();


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getAvgSpeed() {
        return avgSpeed;
    }

    public void setAvgSpeed(float avgSpeed) {
        this.avgSpeed = avgSpeed;
    }

    public float getFuelCapacity() {
        return fuelCapacity;
    }

    public void setFuelCapacity(float fuelCapacity) {
        this.fuelCapacity = fuelCapacity;
    }

    public int getMaxDistance() {
        return maxDistance;
    }

    public void setMaxDistance(int maxDistance) {
        this.maxDistance = maxDistance;
    }

    public float getCurrentFuelLevel() {
        return currentFuelLevel;
    }

    public void setCurrentFuelLevel(float currentFuelLevel) {
        this.currentFuelLevel = currentFuelLevel;
    }


    public float getConsumptionRate() {
        return consumptionRate;
    }

    public void setConsumptionRate(float consumptionRate) {
        this.consumptionRate = consumptionRate;
    }

    public double getBatteryConsumptionRate() {
        return batteryConsumptionRate;
    }

    public void setBatteryConsumptionRate(double batteryConsumptionRate) {
        this.batteryConsumptionRate = batteryConsumptionRate;
    }

    public double getMaxBatteryCapacity() {
        return maxBatteryCapacity;
    }

    public void setMaxBatteryCapacity(double maxBatteryCapacity) {
        this.maxBatteryCapacity = maxBatteryCapacity;
    }

    public FuelType getFuelType() {
        return fuelType;
    }

    public void setFuelType(FuelType fuelType) {
        this.fuelType = fuelType;
    }


    public BaseAircraft(String name, float avgSpeed, float fuelCapacity, float currentFuelLevel, float consumptionRate, int maxDistance) {
        this.name = name;
        this.avgSpeed = avgSpeed;
        this.fuelCapacity = fuelCapacity;
        this.currentFuelLevel = currentFuelLevel;
        this.consumptionRate = consumptionRate;
        this.maxDistance = maxDistance;
    }

    public BaseAircraft(String name, float avgSpeed, double maxBatteryCapacity, double batteryConsumptionRate, int maxDistance) {
        this.name = name;
        this.avgSpeed = avgSpeed;
        this.maxBatteryCapacity = maxBatteryCapacity;
        this.batteryConsumptionRate = batteryConsumptionRate;
        this.maxDistance = maxDistance;
    }

    public abstract void isCreated();

    public void fuelUp() {
        System.out.println(getName() + ": Fuel-up is required!");
        fuelingProgress();
        setCurrentFuelLevel(getFuelCapacity());
        System.out.println(getName() + ": Feels good... now I'm stuffed... let's fly, boyz!");
    }

    public void fly(int distance) {
        if (getMaxDistance() < distance) {
            System.out.println();
            System.out.println(getName() + ": I can't fly that far! =(");
            System.out.println();
        } else if ((getCurrentFuelLevel() / getConsumptionRate()) * 100 < distance) {
            if (isFuelUpAvailable()) {
                fuelUp();
                fly(distance);
                System.out.println();
            } else {
                throw new NoFuelException(getName() + ": I gotta fuel-up! But there are no avaiable refilling stations around! =(");
            }
        } else {
            try {
                System.out.println();
                System.out.println(getName() + ": Starting the flight...");
                Thread.sleep(5000);
                if (random.nextBoolean()) {
                    System.out.println(getName() + " has flown " + distance + " km successfully! Congrats!");
                    System.out.println();
                } else {
                    throw new TurbulanceException();
                }
            } catch (TurbulanceException e) {
                System.out.println("'" + getName() + "'" + ": Turbulance! Hold your belts!!");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    public void fuelingProgress() {
        System.out.print(getName() + ": Fueling up is in progress: ");
        try {
            for (int i = 0; i < 30; i++) {
                Thread.sleep(500);
                System.out.print(">");
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println();
    }

    @NotNull
    public boolean isFuelUpAvailable() {
        return randomBool();
    }

}