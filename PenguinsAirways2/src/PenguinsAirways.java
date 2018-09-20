import aircrafts.api.BaseAircraft;
import aircrafts.impl.AirTesla;
import aircrafts.impl.Airplane;
import aircrafts.impl.Balloon;
import aircrafts.impl.Quadcopter;

public class PenguinsAirways {
    public static void main(String[] args) {

        final int AIRCRAFTS_COUNT = 4;

        //creating an array of objects
        BaseAircraft[] aircrafts = new BaseAircraft[AIRCRAFTS_COUNT];

        //creating an object for every class we have
        aircrafts[0] = new Airplane("'A380-800'", 1500f, 500f, 5f, 5f, 10000);
        aircrafts[1] = new AirTesla("'Model F'", 1500f, 200000d, 80000f, 250);
        aircrafts[2] = new Balloon("'Easy Going'", 60f, 100f, 1f, 5f, 500);
        aircrafts[3] = new Quadcopter("'Phantom 4 Pro'", 1500f, 4000d, 40000f, 10);


        for (int i = 0; i < aircrafts.length; i++) {
            BaseAircraft aircraft = aircrafts[i];
            aircraft.isCreated();

        }

        for (int i = 0; i < aircrafts.length; i++) {
            BaseAircraft aircraft = aircrafts[i];
            if (aircrafts[i] == aircrafts[3]) {
                try {
                    aircraft.fly(9);
                } catch (Exception e) {
                    System.out.println("'" + aircraft.getName() + "'" + ": I gotta fuel-up! But there are no avaiable refilling stations around! =(");
                }
            } else {
                try {
                    aircraft.fly(240);
                } catch (Exception e) {
                    System.out.println("'" + aircraft.getName() + "'" + ": I gotta fuel-up! But there are no avaiable refilling stations around! =(");
                }
            }
        }


    }


}
