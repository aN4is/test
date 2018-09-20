import aircrafts.Airplane;
import aircrafts.BaseAircraft;

public class PenguinsAirways {
    public static void main(String[] args) {
        BaseAircraft airplane = new Airplane("iL", 1500f, 500f, 250f, 5f, 10000);

        airplane.isCreated();

        airplane.fly(12000);
        airplane.fly(8000);
        airplane.fly(2000);



    }


}
