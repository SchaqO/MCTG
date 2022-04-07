package com.company;

import com.company.database.DatabaseConnection;
import com.company.db.PackageDB;
import com.company.db.UserDB;
import com.company.model.Packages;
import com.company.model.User;
import com.company.model.card.AbstractCard;
import com.company.model.card.MonsterCard;
import com.company.server.Request;
import com.company.server.ServerPort;
import com.company.util.HashGenerator;

import java.io.IOException;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Random;

public class Main {

    public static void main(String[] args) throws SQLException {
    //Server startet hier
    Thread server = new Thread((Runnable) new ServerPort());
    server.start();



    }
}
