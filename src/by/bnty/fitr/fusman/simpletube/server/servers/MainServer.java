package by.bnty.fitr.fusman.simpletube.server.servers;

import org.apache.log4j.Logger;

import java.io.IOException;
import java.net.ServerSocket;

public class MainServer {
    private static int DEFAULT_PORT = 65432;
    private static final Logger log = Logger.getLogger(MainServer.class);
    private static MainServer mainServer;

    public static MainServer getMainServer() {
        return mainServer == null ? mainServer = new MainServer() : mainServer;
    }

    private MainServer() {

    }

    public void run(String[] args) {
        //приемный пункт, где будет сортировка сообщений и отправка отдельных серверам
        ServerSocket servers = null;

        try {
            servers = new ServerSocket(DEFAULT_PORT);
        } catch (IOException e) {
            log.fatal("Couldn't listen to port " + DEFAULT_PORT);
            System.exit(-1);
        }


    }
}
