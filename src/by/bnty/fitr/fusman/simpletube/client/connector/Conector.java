package by.bnty.fitr.fusman.simpletube.client.connector;

import org.apache.log4j.Logger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Conector {
    public static final int DEFAULT_PORT = 4444;
    public static final String DEFAULT_HOST = "localhost";
    private static final String MESS_TO_SEND_SERVER = "test message";
    private static final Logger log = Logger.getLogger(Conector.class);

    public static boolean checkServer(String host, int port) {
        boolean status = false;

        log.warn("Попытка подключение. Хост: " + host + " порт:" + port);
        try {
            Socket socket = new Socket(host, port);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            out.println(MESS_TO_SEND_SERVER);
            String lol = bufferedReader.readLine();
            log.info(lol);

            if (lol.equals("S ::: " + MESS_TO_SEND_SERVER)) {
                status = true;
            }

            out.close();
            socket.close();

        } catch (IOException e) {
            log.error(e.toString());

        }

        log.info("Message:" + status);
        return status;
    }

    public static boolean checkServer() {
        return checkServer(DEFAULT_HOST, DEFAULT_PORT);
    }

    public static boolean checkNnewUpdate(String host, int port) {
        return false;
    }

    public static void main(String[] args) {
        System.out.println(Conector.checkServer("localhost", DEFAULT_PORT));
    }

}
