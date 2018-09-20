package utils;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Random;

public class Utilities {

    public static double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();
        BigDecimal bd = new BigDecimal(Double.toString(value));
        bd = bd.setScale(places, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }

    public static boolean randomBool() {
        Random random = new Random();
        return random.nextBoolean();
    }
}
