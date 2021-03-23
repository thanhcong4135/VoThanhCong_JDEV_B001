package com.green.cinemamanagement.dbhelper.daos;

import com.green.cinemamanagement.dbhelper.connector.DBConnector;
import com.green.cinemamanagement.models.User;

import java.sql.*;
import java.util.ArrayList;

public class DBManager {
    private static final String QUERY_USER = "SELECT * FROM USERACCOUNT";
    private static final String DROP_TBL_USER = "DROP TABLE IF EXISTS USER";
    private static final String CREATE_TBL_USER =
            "CREATE TABLE USERACCOUNT ( ID INT NOT NULL AUTO_INCREMENT," +
                    " EMAIL VARCHAR(64), PASSWORD VARCHAR(2048), " +
                    "PRIMARY KEY (ID))";
    private static final String INSERT_TBL_VALUE = "INSERT INTO USERACCOUNT (`EMAIL`, `PASSWORD`) " +
            "VALUES (?, ?)";
    private static final String UPDATE_TBL_VALUE = "UPDATE USERACCOUNT SET EMAIL = ?, PASSWORD = ? " +
            "WHERE (ID = ?)";
    private static final String DELETE_TBL_VALUE = "DELETE FROM USERACCOUNT WHERE ID = ?";

    public DBManager(){

    }

    public int createTable(Connection connection) {
        int result = 0;
        Statement statement = null;

        try {
            statement = connection.createStatement();
            statement.executeUpdate(DROP_TBL_USER);
            statement.executeUpdate(CREATE_TBL_USER);

            System.out.println("Table User Account created");
        } catch (SQLException exception) {
            result = -1;
            System.out.println("Create table exception: " + exception.getMessage());
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException exception) {
                    exception.printStackTrace();
                }
            }
        }

        return  result;
    }

    public ArrayList<User> getAllUser(Connection connection) {
        ArrayList<User> users = new ArrayList<>();
        Statement statement = null;

        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(QUERY_USER);

            while (resultSet.next()) {
                User user = new User();
                user.setID(resultSet.getInt(1));
                user.setEmail(resultSet.getString(2));
                user.setPassWord(resultSet.getString(3));
                users.add(user);
            }

            System.out.println("Table UserAccount created");
        } catch (SQLException exception) {
            System.out.println("Create table exception: " + exception.getMessage());
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException exception) {
                    exception.printStackTrace();
                }
            }
        }
        return users;
    }

    public int addNewUser(Connection connection, User user) {
        int autoIncKeyFromFunc = -1;
        PreparedStatement preparedStatement = null;

        try {
            preparedStatement = connection.prepareStatement(INSERT_TBL_VALUE);
            preparedStatement.setString(1, user.getEmail());
            preparedStatement.setString(2, user.getPassWord());
            preparedStatement.executeUpdate();


            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT LAST_INSERT_ID()");

            if (rs.next()) {
                autoIncKeyFromFunc = rs.getInt(1);
            } else {
                // throw an exception from here
            }

        } catch (SQLException exception) {
            System.out.println("insert exception: " + exception.getMessage());
            System.out.println("insert note");
        } finally {
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException exception) {
                    exception.printStackTrace();
                }
            }
        }
        return autoIncKeyFromFunc;
    }

    public int updateUser(Connection connection, User user) {
        int result = 0;
        PreparedStatement preparedStatement = null;

        try {
            preparedStatement = connection.prepareStatement(UPDATE_TBL_VALUE);
            preparedStatement.setString(1, user.getEmail());
            preparedStatement.setString(2, user.getPassWord());
            preparedStatement.setInt(3, user.getID());
            preparedStatement.executeUpdate();
        } catch (SQLException exception) {
            result = -1;
            System.out.println("update exception: " + exception.getMessage());
            System.out.println("update user");
        } finally {
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException exception) {
                    exception.printStackTrace();
                }
            }

            return result;
        }
    }

    public int deleteUser(Connection connection, int userID) {
        int result = 0;
        PreparedStatement preparedStatement = null;

        try {
            preparedStatement = connection.prepareStatement(DELETE_TBL_VALUE);
            preparedStatement.setString(1, String.valueOf(userID));
            preparedStatement.executeUpdate();
        } catch (SQLException exception) {
            result = -1;
            System.out.println("insert exception: " + exception.getMessage());
            System.out.println("delete user");
        } finally {
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException exception) {
                    exception.printStackTrace();
                }
            }

            return result;
        }
    }



}
