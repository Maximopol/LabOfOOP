package by.bnty.fitr.fusman.simpletube.server.servers;

import by.bnty.fitr.fusman.simpletube.server.servers.createrserver.CrearerMiniServer;
import org.apache.log4j.Logger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class MainServer {
    private static int DEFAULT_PORT = 65432;
    private static final Logger log = Logger.getLogger(MainServer.class);
    private static MainServer mainServer;

    public static MainServer getMainServer() {
        return mainServer == null ? mainServer = new MainServer() : mainServer;
    }

    private MainServer() {

    }

    public void run() {
        try {
            ServerSocket serverSocket = new ServerSocket(DEFAULT_PORT);

            while (true) {

                Socket socket = serverSocket.accept();
                log.info("New client " + socket);
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

                new CrearerMiniServer().createServer(bufferedReader.readLine(), socket).run();

                bufferedReader.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
