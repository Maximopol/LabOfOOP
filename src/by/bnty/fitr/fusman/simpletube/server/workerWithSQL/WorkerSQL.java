package by.bnty.fitr.fusman.simpletube.server.workerWithSQL;

import java.sql.*;

public class WorkerSQL {

    public boolean reg(String mail, String pas, String nickname) {

        String createTableSQL = "CREATE TABLE REGTABLE3("
                + "email varchar(30) NOT NULL,"
                + "pass varchar(30) NOT NULL,"
                + "nickname varchar(30) NOT NULL"
                + ")";

        try (Connection dbConnection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/", "postgres", "en3kDH5bLSm6kAk"); Statement statement = dbConnection.createStatement()) {
            //  statement.executeUpdate("INSERT INTO DBUSER VALUES ('Pinsk',50,90);");
            // statement.execute(createTableSQL);
            ResultSet rs = statement.executeQuery("SELECT * FROM REGTABLE3");


            boolean flag = true;

            while (rs.next()) {
                String userid = rs.getString("email");
                String username = rs.getString("pass");
                String useride = rs.getString("nickname");

                System.out.println("email : " + userid);
                System.out.println("pass : " + username);
                System.out.println("nickname : " + useride);

                if (mail.equals(userid)) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                statement.executeUpdate("INSERT INTO REGTABLE3 VALUES ('" + mail + "','" + pas + "','" + nickname + "');");
                System.out.println("add");
                return true;
            }


        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
        return false;
    }

    public boolean singIn(String mail, String pas) {
        boolean flag = false;
        try (Connection dbConnection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/", "postgres", "en3kDH5bLSm6kAk"); Statement statement = dbConnection.createStatement()) {

            ResultSet rs = statement.executeQuery("SELECT * FROM REGTABLE3");


            while (rs.next()) {
                String userid = rs.getString("email");
                String username = rs.getString("pass");
                // String useride = rs.getString("nickname");

                System.out.println("email : " + userid);
                System.out.println("pass : " + username);
                // System.out.println("nickname : " + useride);

                if (mail.equals(userid)) {
                    if (pas.equals(username)) {
                        flag = true;
                    }
                    break;
                }
            }


        } catch (SQLException e) {
            System.out.println(e.getMessage());
            flag = false;
        }
        return flag;
    }

    private boolean createTable(String str) {
        return false;
    }

    public boolean delete() {
        return false;
    }
}
