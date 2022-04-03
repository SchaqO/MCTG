package com.company;

import com.company.database.DatabaseConnection;
import com.company.db.PackageDB;
import com.company.model.Packages;
import com.company.model.User;
import com.company.model.card.AbstractCard;
import com.company.model.card.MonsterCard;
import com.company.server.ServerPort;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws SQLException {
        //1.
    Thread server = new Thread((Runnable) new ServerPort());
    server.start();




    }
}
