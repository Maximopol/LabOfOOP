package by.bnty.fitr.fusman.simpletube.server.servers.authorization;

import by.bnty.fitr.fusman.simpletube.client.authandreg.register.registr.Register;
import by.bnty.fitr.fusman.simpletube.common.Converter;
import by.bnty.fitr.fusman.simpletube.server.createrserver.Server;
import by.bnty.fitr.fusman.simpletube.server.workersql.WorkerSQL;
import org.apache.log4j.Logger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class AuthorizationServer extends Thread implements Server {
    private Logger log;
    private Socket socket;
    private BufferedReader bufferedReader;

    public AuthorizationServer(Socket socket, BufferedReader bufferedReader) {
        this.socket = socket;
        this.bufferedReader = bufferedReader;
        log = Logger.getLogger(AuthorizationServer.class);
    }

    public void run() {
        try {
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            String email = bufferedReader.readLine();
            String pas = bufferedReader.readLine();

            log.info("Email:" + email);


            String str = "false";

            if (Register.isCheckedTrueInputEmail(email)) {
                log.info("Call WorkerSQL");
                String str2 = new WorkerSQL().singIn(email, pas);
                if (!str2.endsWith("" + false)) {
                    str = str2;
                    System.out.println(str2);
                }
                log.warn("not success");
            } else {
                log.warn("Incorrect email");
                str = "incor email";
            }
            log.info("Total point:" + str);
            // out.print(str);
            String nick = "";
            if (!str.equals("" + false)) {
                Scanner scanner = new Scanner(str);
                while (scanner.hasNextLine()) {
                    scanner.nextLine();
                    nick = scanner.nextLine();
                }
                log.info(nick);
                out.print(str + "\n" + new WorkerSQL().getPlaylist(Converter.convertToUnique(nick, email).toUpperCase()));
            } else {
                out.print(str);
            }
            out.close();
            socket.close();
            log.info("Done!");

        } catch (IOException e) {
            log.error(e);
        }
    }
}
