package by.bnty.fitr.fusman.simpletube.server.servers;

import by.bnty.fitr.fusman.simpletube.client.connector.Conector;
import org.apache.log4j.Logger;

public class MainServer {
    private static final Logger log = Logger.getLogger(MainServer.class);
    private static MainServer mainServer;

    public static MainServer getMainServer() {
        return mainServer == null ? mainServer = new MainServer() : mainServer;
    }

    private MainServer() {

    }

    public void run(String[] args) {
        //приемный пункт, где будет сортировка сообщений и отправка отдельных серверам
        int i = 1;
        switch (i) {
            case 1: {
                break;
            }
            case 2: {
                //
                Conector.checkServer();
                break;
            }
        }
    }
}
