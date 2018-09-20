package aircrafts;

public class Airplane extends BaseAircraft {
    public Airplane(String Name, Float AvgSpeed, Float FuelCapacity, Float CurrentFuelLevel, Float ConsumptionRate, Integer MaxDistance) {
        super(Name, AvgSpeed, FuelCapacity, CurrentFuelLevel, ConsumptionRate, MaxDistance);
    }

    @Override
    public void isCreated(){
        System.out.println("Airplane " + getName() + " has been created successfully!!");
    }
}
