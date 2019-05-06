package by.bnty.fitr.fusman.simpletube.server.servers.notworkingserver;

import by.bnty.fitr.fusman.simpletube.server.servers.createrserver.Server;

import java.io.IOException;
import java.net.Socket;

public class NotWorkingServer extends Thread implements Server {
    private Socket socket;

    public NotWorkingServer(Socket socket) {
        this.socket = socket;
        this.setPriority(1);
    }

    public void run() {
        try {
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}