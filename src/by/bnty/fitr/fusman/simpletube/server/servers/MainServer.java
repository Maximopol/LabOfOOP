package by.bnty.fitr.fusman.simpletube.server.servers;

import by.bnty.fitr.fusman.simpletube.common.command.Command;
import org.apache.log4j.Logger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
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

    public void run(String[] args) {
        //приемный пункт, где будет сортировка сообщений и отправка отдельных серверам
        ServerSocket servers = null;
        Socket client = null;
        BufferedReader in = null;
        PrintWriter out = null;

        try {
            servers = new ServerSocket(DEFAULT_PORT);

        } catch (IOException e) {
            log.fatal("Couldn't listen to port " + DEFAULT_PORT);
            System.exit(-1);
        }

        while (true) {
            log.info("Waiting for a client...");
            try {
                //создать новый поток который будет працовать с асобными клиентами
                client = servers.accept();
                log.info("Client connected");
                in = new BufferedReader(new
                        InputStreamReader(client.getInputStream()));
                out = new PrintWriter(client.getOutputStream(), true);

                String string = in.readLine();
                if (string.equals(Command.TEST_CONNECT)) {
                    //
                } else if (string.equals(Command.REGISTRATION)) {

                } else if (string.equals(Command.AUTHORIZATION)) {

                }
//                switch (in.readLine()) {
//                    case "": {
//                        break;
//                    }
//                    case ""+ Command.TEST_CONNECT: {
//                        out.println("S ::: " + true);
//                        break;
//                    }
//                    case "regigcter": {
//                        out.println(1);
//                        break;
//                    }
//                }

            } catch (IOException e) {
                log.error(e);
            }
        }
    }
}
