package by.bnty.fitr.fusman.Input;

import java.util.Scanner;

public class Input {
    private static Scanner scanner;

    static {
        scanner = new Scanner(System.in);
    }

    public static int inputInt() {
        while (!scanner.hasNextInt()) {
            scanner.next();
        }
        return scanner.nextInt();
    }

    public static int inputInt(String mes) {
        System.out.print(mes);
        while (!scanner.hasNextInt()) {
            scanner.next();
        }
        return scanner.nextInt();
    }
    public static String inputString() {
        while (!scanner.hasNext()) {
            scanner.next();
        }
        return scanner.next();
    }
    public static String inputString(String mes) {
        System.out.println(mes);
        while (!scanner.hasNext()) {
            scanner.next();
        }
        return scanner.next();
    }

    public static char inputChar() {
        while (!scanner.hasNext()) {
            scanner.next();
        }
        return scanner.next().charAt(0);
    }
}