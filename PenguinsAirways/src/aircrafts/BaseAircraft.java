package aircrafts;

public abstract class BaseAircraft {
    private String Name;
    private Float AvgSpeed, Weight, MaxCargoCapacity, MaxTakeOffWeight, FuelCapacity;
    private Integer MaxPassengerCapacity;
    private Double MaxDistance;


    public BaseAircraft(String Name, Float AvgSpeed, Float Weight, Float MaxCargoCapacity, Float MaxTakeOffWeight, Float FuelCapacity, Integer MaxPassengerCapacity, Double MaxDistance) {
        setValues(Name, AvgSpeed, Weight, MaxCargoCapacity, MaxTakeOffWeight, FuelCapacity, MaxPassengerCapacity, MaxDistance);
    }

    private void setValues(String Name, Float AvgSpeed, Float Weight, Float MaxCargoCapacity, Float MaxTakeOffWeight, Float FuelCapacity, Integer MaxPassengerCapacity, Double MaxDistance) {
        setName(Name);
        setAvgSpeed(AvgSpeed);
        setWeight(Weight);
        setMaxCargoCapacity(MaxCargoCapacity);
        setMaxTakeOffWeight(MaxTakeOffWeight);
        setFuelCapacity(FuelCapacity);
        setMaxPassengerCapcity(MaxPassengerCapacity);
        setMaxDistance(MaxDistance);
    }


    }
}

