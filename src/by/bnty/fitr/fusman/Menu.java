package by.bnty.fitr.fusman;

import by.bnty.fitr.fusman.lab11.CreaterArrays;

import java.util.Arrays;

public class Menu {
    public static void main(String[] args) {
        System.out.println("hello world");
//        int[] mas= new int[4];
//        CreaterArrays.rndInit(mas,-100,100);
        for (double x : CreaterArrays.create(10)
        ) {
            System.out.println(x);
        }
        System.out.println("=====");
        double[] mas = new double[10];
        CreaterArrays.init(mas);
        for (double x : mas) {
            System.out.println(x);
        }

    }
}
