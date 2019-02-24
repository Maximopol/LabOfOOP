package by.bnty.fitr.fusman;

import by.bnty.fitr.fusman.lab11.CreaterArrays;
import by.bnty.fitr.fusman.lab11.WorkerWithArrays;

import java.util.Arrays;

public class Menu {
    public static void main(String[] args) {

        System.out.println(Arrays.toString(CreaterArrays.create(10)));

        double[] mas = new double[10];
        CreaterArrays.init(mas);


        System.out.println(Arrays.toString(mas));
        System.out.println(WorkerWithArrays.searchIndexOfMinElement(mas));

    }
}
