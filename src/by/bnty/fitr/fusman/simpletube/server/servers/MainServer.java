package by.bnty.fitr.fusman.simpletube.server.servers;

import by.bnty.fitr.fusman.simpletube.common.command.Command;
import by.bnty.fitr.fusman.simpletube.server.servers.authorizationserver.AuthorizationServer;
import by.bnty.fitr.fusman.simpletube.server.servers.primaryserver.PrimaryServer;
import by.bnty.fitr.fusman.simpletube.server.servers.registrationserver.RegistrationServer;
import by.bnty.fitr.fusman.simpletube.server.servers.testserver.TestServer;
import org.apache.log4j.Logger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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

    public void run() {
        try {
            ServerSocket serverSocket = new ServerSocket(DEFAULT_PORT);

            while (true) {

                Socket socket = serverSocket.accept();
                log.info("New client " + socket);
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

                if (bufferedReader.readLine().equals(Command.TEST_CONNECT)) {
                    new TestServer(socket).run();

                } else if (bufferedReader.readLine().equals(Command.WALKING)) {
                    new PrimaryServer().run();

                } else if (bufferedReader.readLine().equals(Command.REGISTRATION)) {
                    new RegistrationServer().run();

                } else if (bufferedReader.readLine().equals(Command.AUTHORIZATION)) {
                    new AuthorizationServer().run();

                } else {
                    socket.close();
                }

                bufferedReader.close();
                //socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

//    public void run(String[] args) {
//        System.out.println("Welcome to Server side");
//        BufferedReader in = null;
//        PrintWriter out = null;
//
//        ServerSocket servers = null;
//        Socket fromclient = null;
//
//
//        try {
//            servers = new ServerSocket(4444);
//        } catch (IOException e) {
//            System.out.println("Couldn't listen to port 4444");
//            System.exit(-1);
//        }
//
//        try {
//            System.out.print("Waiting for a client...");
//            while (true) {
//                fromclient = servers.accept();
//                System.out.println("Client connected");
//
//
//                in = new BufferedReader(new
//                        InputStreamReader(fromclient.getInputStream()));
//                out = new PrintWriter(fromclient.getOutputStream(), true);
//                String input, output;
//
//                System.out.println("Wait for messages");
//                while ((input = in.readLine()) != null) {
//                    if (input.equalsIgnoreCase("exit")) break;
//                    new TestServer2().work(fromclient);
//                    //out.println("S ::: " + input);
//                    //System.out.println(input);
//                }
//
//                out.close();
//                in.close();
//                fromclient.close();
//            }
//
//        } catch (IOException e) {
//            System.out.println("Can't accept");
//            System.exit(-1);
//        } finally {
//            try {
//                servers.close();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//    }

//    public void run(String[] args) {
//        //приемный пункт, где будет сортировка сообщений и отправка отдельных серверам
//        ServerSocket servers = null;
//        Socket client = null;
//        BufferedReader in = null;
//        PrintWriter out = null;
//
//        try {
//            servers = new ServerSocket(DEFAULT_PORT);
//
//        } catch (IOException e) {
//            log.fatal("Couldn't listen to port " + DEFAULT_PORT);
//            System.exit(-1);
//        }
//
//        while (true) {
//            log.info("Waiting for a client...");
//            try {
//
//                client = servers.accept();
//                log.info("Client connected");
//                in = new BufferedReader(new
//                        InputStreamReader(client.getInputStream()));
//                out = new PrintWriter(client.getOutputStream(), true);
//                String input;
//                while ((input = in.readLine()) != null) {
//                    String string = in.readLine();
//                    if (string.equals(Command.TEST_CONNECT)) {
//                        new TestServer2().work(client);
//                    }
////                if (string.equals(Command.TEST_CONNECT)) {
////                    //
////                } else if (string.equals(Command.REGISTRATION)) {
////
////                } else if (string.equals(Command.AUTHORIZATION)) {
////
////                }
//
//                }
//            } catch (IOException e) {
//                log.error(e);
//            }
//        }
//    }


}
