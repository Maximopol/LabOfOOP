package by.bnty.fitr.fusman.labs.lab18;

import org.apache.log4j.Logger;

public class Log4jtest {
    private static final Logger log = Logger.getLogger(Log4jtest.class);

    public static void main(String[] args) throws Exception {
        Log4jtest log4jtest = new Log4jtest();
        log4jtest.test();

    }

    private void test() {

        log.info("Это информационное сообщение!");
        testing();
    }

    private void testing() {

        log.error("Это сообщение ошибки");
        log.debug("kek");
        log.warn("stop");
        log.fatal("кхъ");
    }
}