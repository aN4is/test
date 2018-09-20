package aircrafts;

import jdk.jshell.spi.ExecutionControl;

public abstract class BaseAircraft {
    private String Name;
    private Float AvgSpeed, FuelCapacity, CurrentFuelLevel, ConsumptionRate; //avg speed is in km/h
    private Integer MaxDistance;


    public BaseAircraft(String Name, Float AvgSpeed, Float FuelCapacity, Float CurrentFuelLevel, Float ConsumptionRate, Integer MaxDistance) {
        setValues(Name, AvgSpeed, FuelCapacity, CurrentFuelLevel, ConsumptionRate, MaxDistance);
    }



    protected void setValues(String Name, Float AvgSpeed, Float FuelCapacity, Float CurrentFuelLevel, Float ConsumptionRate, Integer MaxDistance) {
        setName(Name);
        setAvgSpeed(AvgSpeed);
        setFuelCapacity(FuelCapacity);
        setCurrentFuelLevel(CurrentFuelLevel);
        setConsumptionRate(ConsumptionRate);
        setMaxDistance(MaxDistance);
    }

    public abstract void isCreated();

    public void fuelUp() throws ExecutionControl.NotImplementedException {
        throw new ExecutionControl.NotImplementedException("sorry, not implemented yet") {

        };
    }

    public void fly(int distance) {
        if (MaxDistance < distance) {
            System.out.println("I can't fly that far! =(");
        } else if ((getCurrentFuelLevel() / getConsumptionRate()) * 100 < distance) {
            System.out.println("Fuel up is required!!");
            try {
                fuelUp();
            } catch (ExecutionControl.NotImplementedException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println(getName() + " has flown " + distance + " km successfully! Congrats!");
        }

    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public Float getAvgSpeed() {
        return AvgSpeed;
    }

    public void setAvgSpeed(Float avgSpeed) {
        AvgSpeed = avgSpeed;
    }

    public Float getFuelCapacity() {
        return FuelCapacity;
    }

    public void setFuelCapacity(Float fuelCapacity) {
        FuelCapacity = fuelCapacity;
    }

    public Integer getMaxDistance() {
        return MaxDistance;
    }

    public void setMaxDistance(Integer maxDistance) {
        MaxDistance = maxDistance;
    }

    public Float getCurrentFuelLevel() {
        return CurrentFuelLevel;
    }

    public void setCurrentFuelLevel(Float currentFuelLevel) {
        CurrentFuelLevel = currentFuelLevel;
    }


    public Float getConsumptionRate() {
        return ConsumptionRate;
    }

    public void setConsumptionRate(Float consumptionRate) {
        ConsumptionRate = consumptionRate;
    }
}