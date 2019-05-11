package by.bnty.fitr.fusman.simpletube.server.workersql;

import org.apache.log4j.Logger;

import java.sql.*;
import java.util.Date;

public class WorkerSQL {
    private static final Logger log = Logger.getLogger(WorkerSQL.class);

    private static final String createTableSQL = "CREATE TABLE REGTABLE3("
            + "email varchar(30) NOT NULL,"
            + "pass varchar(30) NOT NULL,"
            + "nickname varchar(30) NOT NULL"
            + ")";

    private static final String createPlaylis = "CREATE TABLE ";
    private static final String suffix =
            "(playlist varchar(30) NOT NULL," +
                    "videoname varchar(30) NOT NULL," +
                    "videopath varchar(30) NOT NULL," +
                    "videodate varchar(30) NOT NULL," +
                    "videoviews int NOT NULL," +
                    "videolikes int NOT NULL," +
                    "videodizlikes int NOT NULL );";


    public boolean reg(String mail, String pas, String nickname) {

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
                String string = createPlaylis + (nickname + mail.hashCode()).toUpperCase() + suffix;
                System.out.println(string);
                statement.execute(string);
                System.out.println("сreated");
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

    public boolean addVideo(String unictable, String playlist, String name, String path) {
        boolean flag = false;

        System.out.println(unictable);
        try (Connection dbConnection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/", "postgres", "en3kDH5bLSm6kAk"); Statement statement = dbConnection.createStatement()) {
            //  ResultSet rs = statement.executeQuery("SELECT * FROM"+unictable +")";

            statement.executeUpdate("INSERT INTO " + unictable + " VALUES " + "('" + playlist + "','" +
                    name + "','" +
                    path +
                    "','" + new Date().toString()
                    + "'," + 0 + "," + 0 + "," + 0 + ");");


            flag = true;
            System.out.println("lll");

        } catch (SQLException e) {
            e.printStackTrace();

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
