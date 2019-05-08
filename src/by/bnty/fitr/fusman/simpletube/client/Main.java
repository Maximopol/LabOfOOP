package by.bnty.fitr.fusman.simpletube.client;

import by.bnty.fitr.fusman.simpletube.client.mainform.MainForm;
import org.apache.log4j.Logger;

public class Main {
    public static void main(final String[] args) {
        final Logger log = Logger.getLogger(Main.class);
        log.info("Запуск");
        MainForm.run();
        log.info("Конец работы");
    }
}
