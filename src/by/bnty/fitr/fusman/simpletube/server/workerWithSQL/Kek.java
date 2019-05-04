package by.bnty.fitr.fusman.simpletube.server.workerWithSQL;


import java.sql.*;

public class Kek {
    private static final String DB_DRIVER = "org.postgresql.Driver";

    public static void main(String[] args) {

        try {
            createDbUserTable();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }


//        try {
//            Class.forName(DB_DRIVER);
//            Connection connection = DriverManager.getConnection("jdbc:postgresql://hostname:port/dbname","username", "password");
//            connection.close();
//        } catch (ClassNotFoundException e) {
//            System.out.println("Where is your MySQL JDBC Driver?");
//            e.printStackTrace();
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
    }

    private static void createDbUserTable() throws SQLException {

        String createTableSQL = "CREATE TABLE DBUSER("
                + "city varchar(90) NOT NULL, "
                + "pos_x int NOT NULL, "
                + "pos_y int NOT NULL "
                + ")";

        try (Connection dbConnection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/", "postgres", ""); Statement statement = dbConnection.createStatement()) {

            // выполнить SQL запрос
            // statement.execute(createTableSQL);
            //  statement.executeUpdate("INSERT INTO DBUSER VALUES ('Pinsk',50,90);");

            ResultSet rs = statement.executeQuery("SELECT * FROM DBUSER");

            // И если что то было получено то цикл while сработает
            while (rs.next()) {
                String userid = rs.getString("city");
                int username = rs.getInt("pos_x");

                System.out.println("userid : " + userid);
                System.out.println("username : " + username);
            }

            System.out.println("Table \"dbuser\" is created!");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
