package by.bnty.fitr.fusman.lab11;

import java.util.Random;

public class CreaterArrays {
    // public static
//    public static void rndInit(int[] array, int min, int max) {
//        Random random = new Random();
//        for (int i = 0; i < array.length; i++) {
//            array[i] = random.nextInt(max - min + 1) + min;
//        }
//    }
    public static double[] create(int length) {
        Random random = new Random();
        double[] mas = new double[length];
        for (int i = 0; i < mas.length; i++) {
            mas[i] = random.nextDouble();
        }

        return mas;
    }

    public static void init(double[] mas) {
        Random random = new Random();

        for (int i = 0; i < mas.length; i++) {
            mas[i] = random.nextDouble();
        }

    }

}

