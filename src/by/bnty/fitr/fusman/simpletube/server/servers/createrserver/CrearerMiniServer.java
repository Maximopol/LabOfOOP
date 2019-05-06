package by.bnty.fitr.fusman.simpletube.server.servers.createrserver;

import by.bnty.fitr.fusman.simpletube.common.command.Command;
import by.bnty.fitr.fusman.simpletube.server.servers.authorizationserver.AuthorizationServer;
import by.bnty.fitr.fusman.simpletube.server.servers.notworkingserver.NotWorkingServer;
import by.bnty.fitr.fusman.simpletube.server.servers.primaryserver.PrimaryServer;
import by.bnty.fitr.fusman.simpletube.server.servers.registrationserver.RegistrationServer;
import by.bnty.fitr.fusman.simpletube.server.servers.testserver.TestServer;

import java.net.Socket;

public class CrearerMiniServer implements Creator {
    public Server createServer(String str, Socket socket) {
        Server server = null;

        if (str.equals(Command.TEST_CONNECT)) {
            server = new TestServer(socket);

        } else if (str.equals(Command.WALKING)) {
            server = new PrimaryServer();

        } else if (str.equals(Command.REGISTRATION)) {
            server = new RegistrationServer();

        } else if (str.equals(Command.AUTHORIZATION)) {
            server = new AuthorizationServer();

        } else {
            server = new NotWorkingServer(socket);
        }

        return server;
    }
}

