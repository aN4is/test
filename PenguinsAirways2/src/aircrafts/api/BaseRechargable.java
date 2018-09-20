package aircrafts.api;

import aircrafts.errors.NoFuelException;
import com.sun.istack.internal.NotNull;

import static utils.Utilities.randomBool;
import static utils.Utilities.round;


public abstract class BaseRechargable extends BaseAircraft {
    private double currentBatteryCapacity; // mAh
    private double batteryConsumptionRate; // mAh/100km

    public double getBatteryConsumptionRate() {
        return batteryConsumptionRate;
    }

    public void setBatteryConsumptionRate(double batteryConsumptionRate) {
        this.batteryConsumptionRate = batteryConsumptionRate;
    }

    public double getCurrentBatteryCapacity() {
        return currentBatteryCapacity;
    }

    public void setCurrentBatteryCapacity(double currentBatteryCapacity) {
        this.currentBatteryCapacity = currentBatteryCapacity;
    }

    public BaseRechargable(String name, float avgSpeed, double maxBatteryCapacity, double batteryConsumptionRate, int maxDistance) {
        super(name, avgSpeed, maxBatteryCapacity, batteryConsumptionRate, maxDistance);
        setCurrentBatteryCapacity(round((Math.random() * getMaxBatteryCapacity() + 1), 1));
    }


    public void charge() {
        System.out.println(getName() + ": Fuel-up is required!");
        chargingProgress();
        setMaxBatteryCapacity(getMaxBatteryCapacity());
        System.out.println("Your tesla " + getName() + " is fully charged and ready to go!");
    }


    public void chargingProgress() {
        System.out.print(getName() + ": charging is in progress: ");
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

    @Override
    public void fly(int distance) {
        if (getMaxDistance() < distance) {
            System.out.println();
            System.out.println(getName() + ": I can't fly that far! =(");
            System.out.println();
        } else if ((getCurrentBatteryCapacity() / getBatteryConsumptionRate()) * 50 < distance) {
              if (isChargingAvailable()) {
                    charge();
                    fly(distance);
                    System.out.println();
              } else {
                    throw new NoFuelException();
              }
        } else {
            System.out.println();
            System.out.println(getName() + " has flown " + distance + " km successfully! Congrats!");
            System.out.println();
        }
    }

    @NotNull
    public boolean isChargingAvailable() {
        return randomBool();
    }
}
