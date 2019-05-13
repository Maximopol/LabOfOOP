package by.bnty.fitr.fusman.simpletube.server.servers.donloading;

import by.bnty.fitr.fusman.simpletube.server.createrserver.Server;
import org.apache.log4j.Logger;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.net.Socket;

public class DonloadingServer extends Thread implements Server {
    private Logger log;
    private Socket socket;
    private BufferedReader bufferedReader;

    public DonloadingServer(Socket socket, BufferedReader bufferedReader) {
        this.socket = socket;
        this.bufferedReader = bufferedReader;
        log = Logger.getLogger(DonloadingServer.class);
    }

    public void run() {
        try {
            DataOutputStream outD = new DataOutputStream(socket.getOutputStream());

            String path = "F://serverstorage//";// bufferedReader.readLine();
            String path2 = bufferedReader.readLine();

            log.info("File path:" + path + path2);

            File f = new File(path + path2);

            outD.writeLong(f.length());
            outD.writeUTF(f.getName());

            log.info("File length:" + f.length() + " name:" + f.getName());

            FileInputStream in = new FileInputStream(f);

            byte[] buffer = new byte[64 * 1024];
            int count;

            while ((count = in.read(buffer)) != -1) {
                outD.write(buffer, 0, count);
            }

            outD.flush();
            outD.close();
            in.close();
            socket.close();

            log.info("Done!");

        } catch (Exception e) {
            log.error(e);
        }
    }
}
