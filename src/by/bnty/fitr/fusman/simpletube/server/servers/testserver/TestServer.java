package by.bnty.fitr.fusman.simpletube.server.servers.testserver;

import by.bnty.fitr.fusman.simpletube.server.createrserver.Server;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

public class TestServer extends Thread implements Server {
    private Logger log;
    private Socket socket;
    private PrintWriter printWriter;

    public TestServer(Socket socket) {
        log = Logger.getLogger(TestServer.class);
        this.socket = socket;
        try {
            this.printWriter = new PrintWriter(socket.getOutputStream(), true);
        } catch (IOException e) {
            this.printWriter = null;
            log.error(e);
        }
    }

    public void run() {
        log.info("run");
        try {
            printWriter.println(true);
            log.info("Sent: " + true);
            socket.close();
        } catch (IOException e) {
            log.error(e);
        }
    }
}
