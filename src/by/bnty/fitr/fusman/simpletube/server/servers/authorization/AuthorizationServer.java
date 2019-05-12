package by.bnty.fitr.fusman.simpletube.server.servers.authorization;

import by.bnty.fitr.fusman.simpletube.client.authandreg.register.registr.Register;
import by.bnty.fitr.fusman.simpletube.server.servers.createrserver.Server;
import by.bnty.fitr.fusman.simpletube.server.workersql.WorkerSQL;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

public class AuthorizationServer extends Thread implements Server {
    private Socket socket;
    private BufferedReader bufferedReader;

    public AuthorizationServer(Socket socket, BufferedReader bufferedReader) {
        this.socket = socket;
        this.bufferedReader = bufferedReader;
    }

    public void run() {
        try {
            // DataInputStream din = new DataInputStream(socket.getInputStream());
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            String email = bufferedReader.readLine();
            String pas = bufferedReader.readLine();

            System.out.println(email);
            System.out.println(pas);

            String str = "false";

            if (Register.isCheckedTrueInputEmail(email)) {
                System.out.println("вызов рега");
                String str2 = new WorkerSQL().singIn(email, pas);
                if (!str2.endsWith("" + false)) {
                    str = str2;
                    //   str2.replace(str + "\n", "");
                    System.out.println(str2);
                    //out.print("true");
                }
            } else {
                System.out.println("неправильаня почта");
                str = "incorr email";
            }

            out.print(str);
            // din.close();
            out.close();
            socket.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
