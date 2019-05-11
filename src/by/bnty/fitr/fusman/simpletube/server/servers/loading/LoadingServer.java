package by.bnty.fitr.fusman.simpletube.server.servers.loading;

import by.bnty.fitr.fusman.simpletube.server.servers.createrserver.Server;

import java.io.*;
import java.net.Socket;

public class LoadingServer extends Thread implements Server {
    BufferedReader bufferedReader;
    private Socket socket;

    public LoadingServer(Socket socket, BufferedReader bufferedReader) {
        this.socket = socket;
        this.bufferedReader = bufferedReader;
    }


    public void run() {
        try {

            System.out.println("Подождите...");
//            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
//
//            out.println(Command.DONWLOAIDING);

            System.out.println("послано");
            String s1 = bufferedReader.readLine();
            String s2 = bufferedReader.readLine();
            System.out.println(s1);
            System.out.println(s2);
            String xsdFolder = "F://serverstorage//" + s1 + Math.abs(s2.hashCode()) + "//";

            File dir = new File(xsdFolder);
            if (!dir.exists()) {
                dir.mkdirs();
            }
            //new File(xsdFolder).mkdir();

            DataInputStream din = new DataInputStream(socket.getInputStream());

            int filesCount = din.readInt();
            System.out.println("count:" + filesCount);

            for (int j = 0; j < filesCount; j++) {

                long fileSize = din.readLong();
                String fileName = din.readUTF();
                System.out.println(fileName);
                byte[] buffer = new byte[64 * 1024];
                FileOutputStream outF = new FileOutputStream(xsdFolder + fileName);

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

            }

            System.out.println("Готово!");

            // out.close();
            din.close();
            socket.close();
//            System.out.println("Подождите...");
//
//            System.out.println("послано");
//            String xsdFolder = "F://serverstorage//" + bufferedReader.readLine() + Math.abs(bufferedReader.readLine().hashCode()) + "//";
//            DataInputStream din = new DataInputStream(socket.getInputStream());
//
//            int filesCount = din.readInt();
//            System.out.println(filesCount);
//
//            for (int j = 0; j < filesCount; j++) {
//
//                long fileSize = din.readLong();
//                String fileName = din.readUTF();
//                System.out.println(fileName);
//                byte[] buffer = new byte[64 * 1024];
//                FileOutputStream outF = new FileOutputStream(xsdFolder + fileName);
//
//                long left = fileSize;
//                do {
//                    int nextPackSize = (int) Math.min(left, buffer.length);
//                    int count = din.read(buffer, 0, nextPackSize);
//                    if (count <= 0) {
//                        throw new RuntimeException("Что-то пошло не так!");
//                    }
//
//                    outF.write(buffer, 0, count);
//
//                    left -= count;
//                } while (left != 0);
//
//                outF.flush();
//                outF.close();
//
//
//            }
//
//            System.out.println("Готово!");
//
//            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
