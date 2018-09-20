package aircrafts;

import interfaces.Rechargable;

public class Quadcopter extends BaseAircraft implements Rechargable {
    public Quadcopter(String Name, Float AvgSpeed, Float FuelCapacity, Float CurrentFuelLevel, Float ConsumptionRate, Integer MaxDistance) {
        super(Name, AvgSpeed, FuelCapacity, CurrentFuelLevel, ConsumptionRate, MaxDistance);
    }

    @Override
    public void isCreated(){
        System.out.println("Quadcopter " + getName() + " has been created successfully!!");
    }
}
