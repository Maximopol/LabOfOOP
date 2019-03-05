package by.bnty.fitr.fusman.Printer;


/**
 * Заменяет команду System.out.print на print
 *
 * @author Maksim Malaschuk
 * @version 1.0
 */
public class Printer {
    public static void println(Object obj) {
        System.out.println(obj);
    }

    public static void print(Object obj) {
        System.out.print(obj);
    }
}
