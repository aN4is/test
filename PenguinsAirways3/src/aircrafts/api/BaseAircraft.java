package aircrafts.api;

import aircrafts.errors.InvalidDistanceException;
import aircrafts.errors.NoFuelException;
import aircrafts.errors.TurbulanceException;
import com.sun.istack.internal.NotNull;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import static utils.Utilities.randomBool;

public abstract class BaseAircraft {

    protected static final String SUCCESS = "SUCCESS -- ";
    protected static final String FAILED = "FAILED -- ";

    private String name;
    private float avgSpeed; //km/h
    private float fuelCapacity; // liters
    private float currentFuelLevel; // liters
    private float consumptionRate; // liters/100km
    private int maxDistance; // km
    private double maxBatteryCapacity; // mAh
    private double batteryConsumptionRate; // mAh/100km
    protected FuelType fuelType;
    private boolean isKilled = false;


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

    public boolean isKilled() {
        return isKilled;
    }

    private void setKilled(boolean killed) {
        isKilled = killed;
    }

    //constructor for gas/petrol type aircrafts
    public BaseAircraft(String name, float avgSpeed, float fuelCapacity, float currentFuelLevel, float consumptionRate, int maxDistance) {
        this.name = name;
        this.avgSpeed = avgSpeed;
        this.fuelCapacity = fuelCapacity;
        this.currentFuelLevel = currentFuelLevel;
        this.consumptionRate = consumptionRate;
        this.maxDistance = maxDistance;
    }

    //constuctor for electricity type aircrafts
    public BaseAircraft(String name, float avgSpeed, double maxBatteryCapacity, double batteryConsumptionRate, int maxDistance) {
        this.name = name;
        this.avgSpeed = avgSpeed;
        this.maxBatteryCapacity = maxBatteryCapacity;
        this.batteryConsumptionRate = batteryConsumptionRate;
        this.maxDistance = maxDistance;
    }

    public abstract void isCreated();

    public void fuelUp() {
        System.out.println(getName() + ": not enough fuel");
        fuelingProgress();
        setCurrentFuelLevel(getFuelCapacity());
        System.out.println(getName() + ": is ready for the flight");
    }

    //flight logic for BaseAircraft type
    public void fly(int distance) throws InvalidDistanceException {
        if (isKilled) {
            throw new RuntimeException(getName() + " : I'm dead!");
        }
        if (distance <= 0) {
            throw new InvalidDistanceException(FAILED + "InvalidDistanceException -- distance should be more than 0.");
        } else if (getMaxDistance() < distance) {
            System.out.println();
            System.out.println(FAILED + getName() + ": given distance is too big. Max distance for current aircraft is " + getMaxDistance() + " km.");
            System.out.println();
        } else if ((getCurrentFuelLevel() / getConsumptionRate()) * 100 < distance) {
            try {
                if (isFuelUpAvailable()) {
                    fuelUp();
                    fly(distance);
                    System.out.println();
                } else {
                    throw new NoFuelException();
                }
            } catch (NoFuelException e) {
                System.out.println(FAILED + getName() + " NoFuelException -- not enough fuel. no avaiable refilling stations");
            }
        } else {
            try {
                System.out.println(getName() + ": starting the flight...");
                Thread.sleep(5000);
                if (randomBool()) {
                    System.out.println(SUCCESS + getName() + " has flown " + distance + " km successfully!");
                    System.out.println();
                } else {
                    throw new TurbulanceException();
                }
            } catch (TurbulanceException e) {
                System.out.println(getName() + " TurbulanceException -- turbulance!");
                new TurbulenceAnimation().turbulenceIsInProgress();
                if (randomBool()) {
                    System.out.println(SUCCESS + "turbulance is gone. " + getName() + " has landed and flown " + distance + " km in total! Congrats!");
                } else {
                    System.out.println(FAILED + getName() + " got crashed.");
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    public void fuelingProgress() {
        System.out.print(getName() + ": fueling up is in progress: ");
        try {
            for (int i = 0; i < 30; i++) {
                Thread.sleep(500);
                System.out.print(">");
            }
            System.out.print(">FULL TANK");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println();
    }

    @NotNull
    public boolean isFuelUpAvailable() {
        return randomBool();
    }

    public void teleport(int distance) {
        throw new NotImplementedException();
    }

    public void killMe() {
        setKilled(true);
    }

    // inner class
    static class TurbulenceAnimation {
        void turbulenceIsInProgress() {
            try {
                for (int i = 0; i < 20; i++) {
                    Thread.sleep(200);
                    System.out.print(".");

                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println();
        }
    }

}