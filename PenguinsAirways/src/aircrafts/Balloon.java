package aircrafts;

public class Balloon extends BaseAircraft {
    public Balloon(String Name, Float AvgSpeed, Float FuelCapacity, Float CurrentFuelLevel, Float ConsumptionRate, Integer MaxDistance) {
        super(Name, AvgSpeed, FuelCapacity, CurrentFuelLevel, ConsumptionRate, MaxDistance);
    }


    @Override
    public void isCreated(){
        System.out.println("Balloon " + getName() + " has been created successfully!!");
    }
}
