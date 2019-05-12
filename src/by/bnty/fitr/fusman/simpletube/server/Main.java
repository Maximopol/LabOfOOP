package by.bnty.fitr.fusman.simpletube.server;

import by.bnty.fitr.fusman.simpletube.server.servers.main.MainServer;
import org.apache.log4j.Logger;

public class Main {
    public static void main(final String[] args) {
        final Logger log = Logger.getLogger(Main.class);
        log.info("Запуск");
        MainServer mainServer = MainServer.getMainServer();
        mainServer.run();
        log.info("Конец работы");
    }
}
