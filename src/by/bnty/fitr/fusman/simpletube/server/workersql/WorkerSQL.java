package by.bnty.fitr.fusman.simpletube.server.workersql;

import by.bnty.fitr.fusman.simpletube.common.conveter.Converter;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.Date;

public class WorkerSQL {
    private Logger log;

    public WorkerSQL() {
        log = Logger.getLogger(WorkerSQL.class);
    }

    private static final String CREATE_TABLE_SQL = "CREATE TABLE REGTABLE3("
            + "email varchar(30) NOT NULL,"
            + "pass varchar(30) NOT NULL,"
            + "nickname varchar(30) NOT NULL"
            + ")";
    private static final String CREATE_TABLE_SQL_2 = "CREATE TABLE REGTABLE3("
            + "email varchar(30) NOT NULL,"
            + "pass varchar(30) NOT NULL,"
            + "nickname varchar(30) NOT NULL,"
            + "unictable varchar(30) NOT NULL"
            + ")";

    private static final String PREFIX = "CREATE TABLE ";
    private static final String SUFFIX =
            "(playlist varchar(30) NOT NULL," +
                    "videoname varchar(30) NOT NULL," +
                    "videopath varchar(30) NOT NULL," +
                    "videodate varchar(30) NOT NULL," +
                    "videoviews int NOT NULL," +
                    "videolikes int NOT NULL," +
                    "videodizlikes int NOT NULL );";


    public boolean reg(String mail, String pas, String nickname) {
        log.info("start");
        try (Connection dbConnection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/", "postgres", "en3kDH5bLSm6kAk"); Statement statement = dbConnection.createStatement()) {
            // statement.execute(CREATE_TABLE_SQL);
            ResultSet rs = statement.executeQuery("SELECT * FROM REGTABLE3");

            boolean flag = true;

            while (rs.next()) {
                String userid = rs.getString("email");
                String useride = rs.getString("nickname");

                log.info("email : " + userid + " nickname : " + useride);

                if (mail.equals(userid)) {
                    flag = false;
                    log.warn("It is exsist");
                    break;
                }
            }
            if (flag) {
                statement.executeUpdate("INSERT INTO REGTABLE3 VALUES ('" + mail + "','" + pas + "','" + nickname + "');");
                log.info("add");
                String string = PREFIX + Converter.convertToUnique(nickname, mail).toUpperCase() + SUFFIX;
                System.out.println(string);
                statement.execute(string);
                log.info("сreated");
                return true;
            }

        } catch (SQLException e) {
            log.error(e);
            return false;
        }
        return false;
    }

    public String singIn(String mail, String pas) {
        String flag = "" + false;
        log.info("run");
        try (Connection dbConnection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/", "postgres", "en3kDH5bLSm6kAk"); Statement statement = dbConnection.createStatement()) {

            ResultSet rs = statement.executeQuery("SELECT * FROM REGTABLE3");

            while (rs.next()) {
                String userid = rs.getString("email");
                String username = rs.getString("pass");
                String nick = rs.getString("nickname");

                log.info("Email: " + userid);

                if (mail.equals(userid)) {
                    if (pas.equals(username)) {
                        flag = "" + true + "\n" + nick;
                        log.info("Success");
                    }
                    break;
                }
            }

        } catch (SQLException e) {
            log.error(e);
            flag = "" + false;
        }
        log.info("Total point:" + flag);

        return flag;
    }

    public boolean addVideo(String unictable, String playlist, String name, String path) {
        boolean flag = false;
        log.info("run");
        log.info(unictable);

        try (Connection dbConnection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/", "postgres", "en3kDH5bLSm6kAk"); Statement statement = dbConnection.createStatement()) {
            statement.executeUpdate("INSERT INTO " + unictable + " VALUES " + "('" + playlist + "','" +
                    name + "','" +
                    path +
                    "','" + new Date().toString()
                    + "'," + 0 + "," + 0 + "," + 0 + ");");

            flag = true;
            log.info("Success");
        } catch (SQLException e) {
            log.error(e);
        }
        return flag;
    }

    public StringBuilder getPlaylist(String unictable) {
        log.info("run");
        log.info(unictable);
        StringBuilder stringBuilder = new StringBuilder();
        try (Connection dbConnection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/", "postgres", "en3kDH5bLSm6kAk"); Statement statement = dbConnection.createStatement()) {
            ResultSet rs = statement.executeQuery("SELECT * FROM " + unictable);
            while (rs.next()) {
                String playlist = rs.getString("playlist");
                String videoname = rs.getString("videoname");
                String videopath = rs.getString("videopath");
                String videodate = rs.getString("videodate");
                int videoviews = rs.getInt("videoviews");
                int videolikes = rs.getInt("videolikes");
                int videodizlikes = rs.getInt("videodizlikes");

                stringBuilder.append(playlist).append("\n");
                stringBuilder.append(videoname).append("\n");
                stringBuilder.append(videopath).append("\n");
                stringBuilder.append(videodate).append("\n");
                stringBuilder.append(videoviews).append("\n");
                stringBuilder.append(videolikes).append("\n");
                stringBuilder.append(videodizlikes).append("\n");
            }
        } catch (SQLException e) {
            log.error(e);
        }
        return stringBuilder;
    }
}
