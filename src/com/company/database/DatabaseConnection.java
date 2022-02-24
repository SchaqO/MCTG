package com.company.database;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {



    private static final String USER = "postgres";
    private static final String PASS = "postgres";
    private static final String DB_URL = "jdbc:postgresql://localhost:5432/postgres";

    private static DatabaseConnection instance = null;
    protected Connection connection = null;

    public DatabaseConnection(){
        try {
            Class.forName("org.postgresql.Driver");
        } catch (Exception e) {
            e.printStackTrace();
        }
        start();
    }

    public void start() {
        try {
            connection = DriverManager.getConnection(DB_URL, USER, PASS);
            System.out.println("CONNECTED - SUCCESS");
        } catch (SQLException e) {
            System.out.println("CONNECTED - FAILED");
        }
    }


    public Connection getConnection() {
        return connection;
    }

    public static DatabaseConnection getInstance() {
        if(DatabaseConnection.instance == null) {
            DatabaseConnection.instance = new DatabaseConnection();
        }
        return DatabaseConnection.instance;
    }

    static {
        DatabaseConnection.instance = new DatabaseConnection();
    }


}
