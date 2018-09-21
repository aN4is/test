import aircrafts.api.BaseAircraft;
import aircrafts.errors.InvalidDistanceException;
import aircrafts.impl.Airplane;
import aircrafts.impl.Balloon;
import aircrafts.impl.Quadcopter;
import aircrafts.impl.Tesla;
import utils.Utilities;

public class PenguinsAirways {
    public static void main(String[] args) throws InvalidDistanceException {

        final int AIRCRAFTS_COUNT = 5;

        //creating an array of objects
        BaseAircraft[] aircrafts = new BaseAircraft[AIRCRAFTS_COUNT];

        //creating an object for every class we have
        aircrafts[0] = new Airplane(Utilities.randomAirplaneName(), 1500f, 500f, 5f, 5f, 10000);
        aircrafts[1] = new Tesla(Utilities.randomTeslaName(), 100f, 200000d, 80000f, 250);
        aircrafts[2] = new Balloon(Utilities.randomBalloonName(), 60f, 100f, 1f, 5f, 500);
        aircrafts[3] = new Quadcopter(Utilities.randomQuadcopterName(), 30f, 4000d, 40000f, 10);

        //anonymous class
        aircrafts[4] = new BaseAircraft("UFO", 99999f, 999999999f, 999999999f, 0.00001f, 999999999) {
            @Override
            public void isCreated() {
                System.out.println();
                System.out.println("Unidentified flying object has appeared on radars!");
                System.out.println();
            }

            @Override
            public void teleport(int distance) {
                System.out.println();
                System.out.println(SUCCESS + " UFO has teleported");
                System.out.println();
            }
        };

        //invoking isCreated() method for every aircraft
        System.out.println("CREATED:");
        for (int i = 0; i < aircrafts.length; i++) {
            BaseAircraft aircraft = aircrafts[i];
            aircraft.isCreated();

        }

        int userInput = Utilities.userInput();

        while (userInput != -1) {
            if (userInput != -2) {
                //invoking fly() method for each aircraft catching NoFuelException()
                for (int i = 0; i < aircrafts.length; i++) {
                    BaseAircraft aircraft = aircrafts[i];
                    if (aircraft.isKilled()) {
                        continue;
                    }
                    if (aircrafts[i] == aircrafts[4]) {
                        aircraft.teleport(userInput);
                    } else if (aircrafts[i] == aircrafts[3]) {
                        aircraft.fly(userInput);
                        System.out.println();
                    } else {
                        aircraft.fly(userInput);
                        System.out.println();
                    }

                }
                userInput = Utilities.userInput();
            } else {
                aircrafts[4].killMe();
                System.out.println("UFO is shot and it won't bother you again!");
                System.out.println();
                userInput = Utilities.userInput();
            }
        }
    }
}
