package by.bnty.fitr.fusman.labs.lab11;

import java.util.Random;

public class ArrayInitializer {
    public static void rndInit(Arrays arrays, int min, int max) {
        Random random = new Random();
        for (int i = 0; i < arrays.getLength(); i++) {
            arrays.setElement(i, random.nextInt(max - min + 1) + min);
        }
    }
}
