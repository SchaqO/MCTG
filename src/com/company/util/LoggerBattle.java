package com.company.util;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

//Externer Text File für den Battle Log
public class LoggerBattle {

    private static LoggerBattle instance;
    private Logger battleLog;

    static {
        instance = new LoggerBattle();
    }

    public LoggerBattle(){
        FileHandler battleHistory = null;

        try {
            battleHistory = new FileHandler("./extra/battle.log", true);
            SimpleFormatter formatter = new SimpleFormatter();
            battleHistory.setFormatter(formatter);
        } catch (IOException e) {
            e.printStackTrace();
        }
        battleLog = Logger.getLogger(LoggerBattle.class.getName());
        battleLog.addHandler(battleHistory);
    }

    public void logMsg(String msg) {
        battleLog.log(Level.INFO, msg);
    }

    public static LoggerBattle getInstance(){
        if(instance == null) {
            instance = new LoggerBattle();
        }
        return instance;
    }





}
