package by.bnty.fitr.fusman.simpletube.server.createrserver;

import by.bnty.fitr.fusman.simpletube.common.command.Command;
import by.bnty.fitr.fusman.simpletube.server.servers.authorization.AuthorizationServer;
import by.bnty.fitr.fusman.simpletube.server.servers.donloading.DonloadingServer;
import by.bnty.fitr.fusman.simpletube.server.servers.loading.LoadingServer;
import by.bnty.fitr.fusman.simpletube.server.servers.registration.RegistrationServer;
import by.bnty.fitr.fusman.simpletube.server.servers.searching.SearchingServer;
import by.bnty.fitr.fusman.simpletube.server.servers.testserver.TestServer;

import java.io.BufferedReader;
import java.net.Socket;

public class CrearerMiniServer implements Creator {
    public Server createServer(String str, Socket socket, BufferedReader bufferedReader) {
        Server server = null;

        if (str.equals(Command.TEST_CONNECT)) {
            server = new TestServer(socket);
        } else if (str.equals(Command.DONWLOAIDING)) {
            server = new DonloadingServer(socket, bufferedReader);
        } else if (str.equals(Command.REGISTRATION)) {
            server = new RegistrationServer(socket, bufferedReader);
        } else if (str.equals(Command.AUTHORIZATION)) {
            server = new AuthorizationServer(socket, bufferedReader);
        } else if (str.equals(Command.LOADING)) {
            server = new LoadingServer(socket, bufferedReader);
        } else if (str.equals(Command.SEARCHING)) {
            server = new SearchingServer(socket, bufferedReader);
        }

        return server;
    }
}

