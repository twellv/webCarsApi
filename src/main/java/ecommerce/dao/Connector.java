package ecommerce.dao;

import ecommerce.util.Logger;

import java.sql.*;

public class Connector {

    private static Connection connection = null;
    private static Statement statement = null;
    private final static String JDBC_DRIVER = "org.postgresql.Driver";
    public final static String DATABASE_URL = "jdbc:postgresql://localhost:5432/webcars";
    public final static String user = "postgres";
    public final static String password = "123456";

    public static Connection connect() {
        try {
            Class.forName(JDBC_DRIVER);
            connection = DriverManager.getConnection(DATABASE_URL, user, password);
            statement = connection.createStatement();
        } catch(ClassNotFoundException erroClass) {
            Logger.sendError("Driver não localizado: "+ erroClass);
        } catch (Exception exception) {
            Logger.sendError("Error in method connect:"+exception.getMessage());
        }
        return connection;
    }

    public static Connection connect(String database) {
        try {
            connection = DriverManager.getConnection
                    (DATABASE_URL.substring(0, 33) + database, user, password);
        } catch (Exception exception) {
            Logger.sendError("Error in method connect:"+exception.getMessage());
        }
        return connection;
    }

    public static ResultSet query(String string) {
        ResultSet resultSet = null;
        try {
            resultSet = statement.executeQuery(string);
        } catch (Exception e) {
            Logger.sendError("Error in method query: " + e.getMessage());
        }
        return resultSet;
    }

    public static void update(String huh) {
        try {
            System.out.println(huh);
            statement.executeUpdate(huh);
        } catch (Exception e) {
            Logger.sendError("Error in upDate method" + e.getMessage());
        }
    }

    public static void close() {
        try {
            connection.close();
        } catch (Exception e) {
            Logger.sendError("Error in method close: " + e.getMessage());
        }
    }

}
