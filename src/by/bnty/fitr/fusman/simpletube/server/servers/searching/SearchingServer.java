package by.bnty.fitr.fusman.simpletube.server.servers.searching;

import by.bnty.fitr.fusman.simpletube.server.createrserver.Server;
import org.apache.log4j.Logger;

import java.io.BufferedReader;
import java.net.Socket;

public class SearchingServer extends Thread implements Server {
    private Logger log;
    private BufferedReader bufferedReader;
    private Socket socket;

    public SearchingServer(Socket socket, BufferedReader bufferedReader) {
        log = Logger.getLogger(SearchingServer.class);
        this.socket = socket;
        this.bufferedReader = bufferedReader;
    }

    public void run() {

    }
}
