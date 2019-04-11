package by.bnty.fitr.fusman.labs.lab18;

import org.apache.log4j.Logger;

public class Main {

    private static final Logger LOG;

    static {
        LOG = Logger.getRootLogger();//Logger.getLogger("F:\\4\\OOP\\lol\\src\\by\\bnty\\fitr\\fusman\\labs\\lab18\\log4j.properties");//
    }

    public static void main(String[] args) {
        //  Layout lol= new SimpleLayout();
//        Layout layout = new SimpleLayout();
//        Appender consoleAppender = new ConsoleAppender();
        LOG.trace("trace lolkek");
        LOG.debug("debug lolkek");
        LOG.error("error lolkek");
        LOG.warn("warn lolkek");
        LOG.fatal("fatal lolkek");
        LOG.info("info lolkek");
    }
}
