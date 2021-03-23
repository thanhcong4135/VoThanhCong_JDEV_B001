package com.green.cinemamanagement.dbhelper.connector;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnector {
    private static final String DB_DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String DB_CONNECTION =
            "jdbc:mysql://localhost/CINEMADB?user=vtcong&password=Vothanhcong070299";

    public DBConnector(){

    }



    public Connection getDBConnection() {
        Connection connection = null;

        try {
            Class.forName(DB_DRIVER);

            connection = DriverManager.getConnection(DB_CONNECTION);

        } catch (ClassNotFoundException exception) {
            System.out.println("Could not load db driver");
        } catch (SQLException exception) {
            System.out.println("Make connection ex: " + exception.getMessage());
        }

        System.out.println("get db connection success");

        return connection;
    }

}
