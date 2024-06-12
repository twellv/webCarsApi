package ecommerce.dao;

import ecommerce.util.Logger;

import java.sql.*;

public class Connector {

    private static Connection connection = null;
    private static Statement statement = null;
    private final static String JDBC_DRIVER = "org.postgresql.Driver";
    public final static String DATABASE_URL = "jdbc:postgresql://motty.db.elephantsql.com:5432/snfeccez";
    //public final static String DATABASE_URL = "postgres://snfeccez:qGE4bx2Qwc1dngF5lSK8o7FxHjeMUhJC@motty.db.elephantsql.com/snfeccez";
    public final static String user = "snfeccez";
    public final static String password = "qGE4bx2Qwc1dngF5lSK8o7FxHjeMUhJC";
    public final static String DATABASE_URL_TEST_ENV = "jdbc:postgresql://localhost:5432/cartest";
    public final static String user_test = "postgres";
    public final static String password_test = "123456";

    public static Connection connect() {
        try {
            Class.forName(JDBC_DRIVER);
            connection = DriverManager.getConnection(DATABASE_URL, user, password);
            statement = connection.createStatement();
        } catch(ClassNotFoundException erroClass) {
            Logger.sendError("Driver was not found: "+ erroClass);
        } catch (Exception exception) {
            Logger.sendError("Error in method connect:"+exception.getMessage());
        }
        return connection;
    }

    public static Connection connect_test_env() {
        try {
            Class.forName(JDBC_DRIVER);
            connection = DriverManager.getConnection(DATABASE_URL_TEST_ENV, user_test, password_test);
            statement = connection.createStatement();
        } catch(ClassNotFoundException erroClass) {
            Logger.sendError("Driver was not found: "+ erroClass);
        } catch (Exception exception) {
            Logger.sendError("Error in method connect_test_env:"+exception.getMessage());
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
