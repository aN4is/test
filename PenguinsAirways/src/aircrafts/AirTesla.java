package aircrafts;

import interfaces.Rechargable;

public class AirTesla extends BaseAircraft implements Rechargable {
    public AirTesla(String Name, Float AvgSpeed, Float FuelCapacity, Float CurrentFuelLevel, Float ConsumptionRate, Integer MaxDistance) {
        super(Name, AvgSpeed, FuelCapacity, CurrentFuelLevel, ConsumptionRate, MaxDistance);
    }

    @Override
    public void isCreated() {
        System.out.println("Air Tesla " + getName() + " has been created successfully!!");
    }


}

