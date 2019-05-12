package by.bnty.fitr.fusman.simpletube.server.servers.registration;

import by.bnty.fitr.fusman.simpletube.client.authandreg.register.registr.Register;
import by.bnty.fitr.fusman.simpletube.server.createrserver.Server;
import by.bnty.fitr.fusman.simpletube.server.workersql.WorkerSQL;
import org.apache.log4j.Logger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

public class RegistrationServer extends Thread implements Server {
    private Logger log;
    private Socket socket;
    private BufferedReader bufferedReader;

    public RegistrationServer(Socket socket, BufferedReader bufferedReader) {
        log = Logger.getLogger(RegistrationServer.class);
        this.socket = socket;
        this.bufferedReader = bufferedReader;
    }

    public void run() {
        try {
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            WorkerSQL workerSQL = new WorkerSQL();

            String email = bufferedReader.readLine();
            String pas = bufferedReader.readLine();
            String nick = bufferedReader.readLine();

            log.info("Email: " + email + " Nickname: " + nick);

            String str = "false";

            if (Register.isCheckedTrueInputEmail(email)) {
                log.info("Call WorkerSQL");
                if (workerSQL.reg(email, pas, nick)) {
                    str = "true";
                }
                log.warn("Incorrect pass or not register your account");
            } else {
                log.warn("Incorrect email");
                str = "incorr email";
            }
            log.info("Value from WorkerSQL:" + str);

            out.print(str);
            out.close();
            socket.close();
            log.info("Done!");

        } catch (IOException e) {
            log.error(e);
        }
    }
}
