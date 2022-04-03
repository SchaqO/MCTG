package com.company.db;

import com.company.model.Battle;
import com.company.model.User;

import java.sql.ResultSet;

public class BattleDB extends AbstractDBTable {


    public BattleDB() {
        this.table = "battle";
    }

    public Battle battleBuild(ResultSet result) {
        User user = null;
        return null;
    }

}
