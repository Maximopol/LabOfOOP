package by.bnty.fitr.fusman.simpletube.server.servers.testserver;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

public class TestServer extends Thread {
    private Socket socket;
    private PrintWriter printWriter;

    public TestServer(Socket socket) {
        this.socket = socket;
        try {
            this.printWriter = new PrintWriter(socket.getOutputStream(), true);
        } catch (IOException e) {
            this.printWriter = null;
            e.printStackTrace();
        }
    }

    public void run() {
        try {
            printWriter.println(true);
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
