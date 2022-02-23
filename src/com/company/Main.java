package com.company;

import com.company.database.DatabaseConnection;
import com.company.server.ServerPort;

import java.io.IOException;
import java.sql.SQLException;

public class Main {

    public static void main(String[] args) throws SQLException {

        /*
        ServerPort server = new ServerPort(new game());
        try {
            server.start();
        } catch (IOException e) {
            e.printStackTrace();
        }*/
        DatabaseConnection con = DatabaseConnection.getInstance();
        Thread server = new Thread((Runnable) new ServerPort());
        server.start();

    }
}
