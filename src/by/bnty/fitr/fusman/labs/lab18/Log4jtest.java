package by.bnty.fitr.fusman.labs.lab18;

import org.apache.log4j.Logger;

public class Log4jtest {
    private static final Logger log = Logger.getLogger(Log4jtest.class);

    public static void main(String[] args) throws Exception {
        Log4jtest log4jtest = new Log4jtest();
        log4jtest.doOrder();

    }

    public void doOrder() {

        log.info("Это информационное сообщение!");
        addToCart();
    }

    private void addToCart() {

        log.error("Это сообщение ошибки");
        log.debug("kek");
        log.warn("stop");
    }
}