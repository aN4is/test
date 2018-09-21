package aircrafts.api;

import aircrafts.errors.BrokenEngineException;
import aircrafts.errors.InvalidDistanceException;
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
        System.out.println(getName() + ": not enough fuel");
        chargingProgress();
        setMaxBatteryCapacity(getMaxBatteryCapacity());
        System.out.println(getName() + " fully charged and ready for the flight");
    }


    public void chargingProgress() {
        System.out.print(getName() + ": charging is in progress: ");
        try {
            for (int i = 0; i < 30; i++) {
                Thread.sleep(500);
                System.out.print(">");
            }
            System.out.print(">FULL BATTERY");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println();
    }


    //flight logic for BaseRechargable type
    @Override
    public void fly(int distance) throws InvalidDistanceException {
        if (distance <= 0) {
            throw new InvalidDistanceException(FAILED + " InvalidDistanceException -- distance should be more than 0.");
        } else if (getMaxDistance() < distance) {
            System.out.println();
            System.out.println(FAILED + getName() + ": given distance is too big. Max distance for current aircraft is " + getMaxDistance() + " km.");
            System.out.println();
        } else if ((getCurrentBatteryCapacity() / getBatteryConsumptionRate()) * 50 < distance) {
            try {
                if (isChargingAvailable()) {
                      charge();
                      fly(distance);
                      System.out.println();
                } else {
                      throw new NoFuelException();
                }
            } catch (NoFuelException e) {
                System.out.println(FAILED + getName() + " NoFuelException -- not enough fuel. no avaiable charging stations");
            }
        } else {
            try {
                System.out.println(getName() + ": starting the flight...");
                Thread.sleep(5000);
                try {
                    if (randomBool()) {
                        System.out.println(SUCCESS + getName() + " has flown " + distance + " km successfully!");
                        System.out.println();
                    } else {
                        throw new BrokenEngineException();
                    }
                } catch (BrokenEngineException e) {
                    System.out.println(FAILED + getName() + " BrokenEngineException -- engine got broken");
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @NotNull
    public boolean isChargingAvailable() {
        return randomBool();
    }


}
