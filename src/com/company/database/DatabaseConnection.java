package com.company.database;

/*
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.SQLException;

public class DatabaseConnection {

    Connection c = null;
    Statement stmt = null;
        try {
        Class.forName("org.postgresql.Driver");
        c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "Shakoshako11");
        System.out.println("Opened database succesfully");

        stmt = c.createStatement();
        String sql = "CREATE TABLE COMPANY " +
                "(ID INT PRIMARY KEY     NOT NULL," +
                " NAME           TEXT    NOT NULL, " +
                " AGE            INT     NOT NULL, " +
                " ADDRESS        CHAR(50), " +
                " SALARY         REAL)";
        stmt.executeUpdate(sql);
        stmt.close();
        c.close();
    } catch (Exception e ) {
        e.printStackTrace();
        System.err.println(e.getClass().getName()+": "+e.getMessage());
        System.exit(0);
    }
        System.out.println("Table created successfully");

}
*/