package utils;

import aircrafts.data.AirplaneNames;
import aircrafts.data.BalloonNames;
import aircrafts.data.QuadcopterNames;
import aircrafts.data.TeslaNames;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Random;
import java.util.Scanner;


public class Utilities {

    private static final Random RANDOM = new Random();

    public static double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();
        BigDecimal bd = new BigDecimal(Double.toString(value));
        bd = bd.setScale(places, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }

    public static boolean randomBool() {
        return RANDOM.nextBoolean();
    }


    //selecting random name for each aircraft from enum lists
    public static String randomAirplaneName() {
        int pick = RANDOM.nextInt(AirplaneNames.values().length);
        return AirplaneNames.values()[pick].toString();
    }

    public static String randomBalloonName() {
        int pick = RANDOM.nextInt(BalloonNames.values().length);
        return BalloonNames.values()[pick].toString();
    }

    public static String randomTeslaName() {
        int pick = RANDOM.nextInt(TeslaNames.values().length);
        return TeslaNames.values()[pick].toString();
    }

    public static String randomQuadcopterName() {
        int pick = RANDOM.nextInt(QuadcopterNames.values().length);
        return QuadcopterNames.values()[pick].toString();
    }


    //prompt user to enter the flight distance
    public static int userInput(){
        Scanner reader = new Scanner(System.in);
        System.out.println();
        System.out.println("Enter a distance in kilometers (whole number) which all the aircrafts should fly: ");
        System.out.println("To exit the program enter -1");
        System.out.println("To destory UFO in case it annoys you enter -2");
        return reader.nextInt();
    }

}
