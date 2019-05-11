package by.bnty.fitr.fusman.simpletube.server.servers;

import by.bnty.fitr.fusman.simpletube.server.servers.createrserver.CrearerMiniServer;
import by.bnty.fitr.fusman.simpletube.server.servers.createrserver.Creator;
import by.bnty.fitr.fusman.simpletube.server.servers.createrserver.Server;
import org.apache.log4j.Logger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class MainServer {
    private static final int DEFAULT_PORT = 65432;
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
            Creator creator = new CrearerMiniServer();
            log.info(serverSocket);

            while (true) {
                log.info("waiting");
                Socket socket = serverSocket.accept();
                log.info("New client " + socket);

                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                String str = bufferedReader.readLine();
                log.info(str);

                Server server = creator.createServer(str, socket, bufferedReader);
                if (server != null) {
                    server.run();
                } else {
                    socket.close();
                }

                bufferedReader.close();
            }
        } catch (IOException e) {
            log.fatal(e);
        }
    }
}
