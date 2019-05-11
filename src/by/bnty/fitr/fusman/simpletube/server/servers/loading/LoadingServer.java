package by.bnty.fitr.fusman.simpletube.server.servers.loading;

import by.bnty.fitr.fusman.simpletube.server.servers.createrserver.Server;
import by.bnty.fitr.fusman.simpletube.server.workersql.WorkerSQL;

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

            String s1 = bufferedReader.readLine();
            String s2 = bufferedReader.readLine();

            String p = bufferedReader.readLine();
            String name = bufferedReader.readLine();
            String playlist = bufferedReader.readLine();
            String intcount = bufferedReader.readLine();

            System.out.println(s1);
            System.out.println(s2);
            System.out.println(p);
            System.out.println(name);
            System.out.println(playlist);
            System.out.println(intcount);
            //                path+"\n"+
//                        textField1.getText()+"\n"+
//                        textField2.getText());
            String xsdFolder = "F://serverstorage//" + s1 + Math.abs(s2.hashCode()) + "//";

            File dir = new File(xsdFolder);
            if (!dir.exists()) {
                dir.mkdirs();
            }


            //new File(xsdFolder).mkdir();

            DataInputStream din = new DataInputStream(socket.getInputStream());


            System.out.println("====");

            //for (int j = 0; j < filesCount; j++) {

            long fileSize = Long.parseLong(intcount);
            // String fileName = din.readUTF();
            System.out.println(name);
            byte[] buffer = new byte[64 * 1024];
            FileOutputStream outF = new FileOutputStream(xsdFolder + p);

            System.out.println(xsdFolder + p);

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


            // }

            System.out.println("Готово!");

            String sss = (s1 + Math.abs(s2.hashCode())).toUpperCase();
            System.out.println(sss);
            new WorkerSQL().addVideo(sss, playlist, name, p);
            // out.close();
            din.close();
            socket.close();

        } catch (IOException e) {
            e.printStackTrace();
        } catch (RuntimeException r) {
            r.printStackTrace();
        }
    }
}
