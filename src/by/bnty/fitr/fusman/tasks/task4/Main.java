package by.bnty.fitr.fusman.tasks.task4;

import java.util.Arrays;

import static Printer.Printer.println;

public class Main {
    public static void main(String[] args) {
        for (int[] mas : Matrix.searchMax(new int[][]{{111, 2, 3}, {4, 5, 6}, {1000, 8, 19}})
        ) {
            println(Arrays.toString(mas));
        }


        println(Matrix.isSymmetry(new int[][]{{4, 2, 4}, {2, 6, 3}, {4, 3, 8}}));

        println(Matrix.isSymmetry(new int[][]{{4, 2, 5}, {2, 6, 3}, {4, 3, 8}}));
    }
}
