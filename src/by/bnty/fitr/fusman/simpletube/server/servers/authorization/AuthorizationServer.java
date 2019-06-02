package by.bnty.fitr.fusman.simpletube.server.servers.authorization;

import by.bnty.fitr.fusman.labs.lab10.blogers.Account;
import by.bnty.fitr.fusman.simpletube.client.authandreg.authoration.CreatePlaylists;
import by.bnty.fitr.fusman.simpletube.client.authandreg.register.registr.Register;
import by.bnty.fitr.fusman.simpletube.common.conveter.Converter;
import by.bnty.fitr.fusman.simpletube.server.createrserver.Server;
import by.bnty.fitr.fusman.simpletube.server.workersql.WorkerSQL;
import org.apache.log4j.Logger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.NoSuchElementException;

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
            log.info("run");
            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
            String email = bufferedReader.readLine();
            String pas = bufferedReader.readLine();

            log.info("Email:" + email);

            if (Register.isCheckedTrueInputEmail(email)) {
                log.info("Call WorkerSQL");
                String str2 = new WorkerSQL().singIn(email, pas);
                log.info(str2);

                if (str2 != null) {
                    Account account = new Account(str2, email);
                    account.setPlaylists(CreatePlaylists.create(new WorkerSQL().getPlaylist(Converter.convertToUnique(str2, email).toUpperCase())));

                    log.info(account);

                    oos.writeObject(account);
                    oos.flush();
                }
            } else {
                log.warn("Incorrect email");
                oos.writeObject(null);
                oos.flush();
            }

            oos.close();
            socket.close();
            log.info("Done!");

        } catch (IOException | NoSuchElementException e) {
            log.error(e);
        }
    }
}
