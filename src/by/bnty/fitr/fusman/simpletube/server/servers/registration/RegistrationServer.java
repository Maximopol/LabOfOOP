package by.bnty.fitr.fusman.simpletube.server.servers.registration;

import by.bnty.fitr.fusman.simpletube.client.authandreg.register.registr.Register;
import by.bnty.fitr.fusman.simpletube.server.servers.createrserver.Server;
import by.bnty.fitr.fusman.simpletube.server.workersql.WorkerSQL;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

public class RegistrationServer extends Thread implements Server {
    private Socket socket;
    private BufferedReader bufferedReader;

    public RegistrationServer(Socket socket, BufferedReader bufferedReader) {
        this.socket = socket;
        this.bufferedReader = bufferedReader;
    }

    public void run() {
        try {
            // DataInputStream din = new DataInputStream(socket.getInputStream());

            PrintWriter out = new
                    PrintWriter(socket.getOutputStream(), true);

            WorkerSQL workerSQL = new WorkerSQL();

            String email = bufferedReader.readLine();
            String pas = bufferedReader.readLine();
            String nick = bufferedReader.readLine();

            System.out.println(email);
            System.out.println(pas);
            System.out.println(nick);

            String str = "false";

            if (Register.isCheckedTrueInputEmail(email)) {
                System.out.println("вызов рега");

                if (workerSQL.reg(email, pas, nick)) {
                    str = "true";
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
