package by.bnty.fitr.fusman.simpletube.server.servers.loading;

import by.bnty.fitr.fusman.simpletube.common.conveter.Converter;
import by.bnty.fitr.fusman.simpletube.server.createrserver.Server;
import by.bnty.fitr.fusman.simpletube.server.workersql.WorkerSQL;
import org.apache.log4j.Logger;

import java.io.*;
import java.net.Socket;

public class LoadingServer extends Thread implements Server {
    private Logger log;
    private BufferedReader bufferedReader;
    private Socket socket;

    public LoadingServer(Socket socket, BufferedReader bufferedReader) {
        log = Logger.getLogger(LoadingServer.class);
        this.socket = socket;
        this.bufferedReader = bufferedReader;
    }


    public void run() {
        try {
            log.info("Starts up");
            String s1 = bufferedReader.readLine();
            String s2 = bufferedReader.readLine();
            String p = bufferedReader.readLine();
            String name = bufferedReader.readLine();
            String playlist = bufferedReader.readLine();
            String intcount = bufferedReader.readLine();
            String unicCode = Converter.convertToUnique(s1, s2);

            log.info("Email: " + s2 + " nickname: " + s1);
            log.info("File name: " + name + " path: " + p + " playlist: " + playlist + " size: " + intcount);
            String xsdFolder = "F://serverstorage//" + unicCode + "//";
            log.info("Folder:" + xsdFolder);

            File dir = new File(xsdFolder);
            if (!dir.exists()) {
                log.info("This dir:" + dir.mkdirs());
            }

            DataInputStream din = new DataInputStream(socket.getInputStream());

            long fileSize = Long.parseLong(intcount);

            byte[] buffer = new byte[64 * 1024];
            FileOutputStream outF = new FileOutputStream(xsdFolder + p);

            long left = fileSize;
            do {
                int nextPackSize = (int) Math.min(left, buffer.length);
                int count = din.read(buffer, 0, nextPackSize);

                if (count <= 0) {
                    throw new RuntimeException("Что-то пошло не так!");
                }

                outF.write(buffer, 0, count);

                left -= count;
            } while (left != 0);

            outF.flush();
            outF.close();

            new WorkerSQL().addVideo(unicCode.toUpperCase(), playlist, name, p);

            din.close();
            socket.close();

            log.info("Done!");

        } catch (IOException | RuntimeException e) {
            log.error(e);
        }
    }
}
