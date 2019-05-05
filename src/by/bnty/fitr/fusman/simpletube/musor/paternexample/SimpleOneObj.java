package by.bnty.fitr.fusman.simpletube.musor.paternexample;

import static Printer.Printer.println;

public class SimpleOneObj {
    private static SimpleOneObj simpleOneObj;

    private SimpleOneObj() {
        println("Create new obj");
    }

    public static SimpleOneObj getSimpleOneOobg() {
        // return new SimpleOneObj();
        return simpleOneObj == null ? simpleOneObj = new SimpleOneObj() : simpleOneObj;
    }

    public static void main(String[] args) {
        println(SimpleOneObj.simpleOneObj);
        println(SimpleOneObj.getSimpleOneOobg());
        println(SimpleOneObj.simpleOneObj);
        println(SimpleOneObj.getSimpleOneOobg());
    }
}
