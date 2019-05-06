package by.bnty.fitr.fusman.simpletube.server.servers.createrserver;

import java.net.Socket;

public interface Creator {
    Server createServer(String str, Socket socket);
}
