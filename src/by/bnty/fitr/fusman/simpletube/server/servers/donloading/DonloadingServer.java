package by.bnty.fitr.fusman.simpletube.server.servers.donloading;

import by.bnty.fitr.fusman.simpletube.server.servers.createrserver.Server;

import java.io.*;
import java.net.Socket;

public class DonloadingServer extends Thread implements Server {
    private Socket socket;

    private ObjectOutputStream out;
    // private ObjectOutputStream printWriter;

    // private BufferedOutputStream printWriter;
    private OutputStream os;

    public DonloadingServer(Socket socket) {
        this.socket = socket;

    }

    public void run() {
        try {
            DataOutputStream outD = new DataOutputStream(socket.getOutputStream());
            // String xsdPath = "F://serverstorage//";
            //String []filenames = new File(xsdPath).list();
            // assert filenames != null;
            // int numFiles = filenames.length;
            outD.writeInt(1);
            //for (String filename : filenames) {
            File f = new File("F://serverstorage//12.mp4");

            outD.writeLong(f.length());//отсылаем размер файла
            outD.writeUTF(f.getName());//отсылаем имя файла

            System.out.println(f.length());
            System.out.println(f.getName());

            FileInputStream in = new FileInputStream(f);
            byte[] buffer = new byte[64 * 1024];
            int count;

            while ((count = in.read(buffer)) != -1) {
                outD.write(buffer, 0, count);
            }

            outD.flush();
            in.close();
            socket.close();
            // }
        } catch (Exception e) {
            System.err.println(e);
        }
    }
}
