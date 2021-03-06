package com.company.db;

import com.company.db.repository.DbTable;
import com.company.model.User;
import com.company.util.HashGenerator;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.LinkedHashMap;

public class UserDB extends AbstractDBTable implements DbTable<User> {

    public UserDB(){
        this.table = "\"player\"";
    }

    //builds a class/object from the database and returns it back
    public User userBuilder(ResultSet result){

        try {
            if(result.next()){
               return User.builder()
                        .userToken(result.getString("userToken"))
                        .username(result.getString("username"))
                        .password(result.getString("password"))
                        .coins(Integer.parseInt(result.getString("coins")))
                        .elo(Integer.parseInt(result.getString("elo")))
                        .status(Boolean.parseBoolean(result.getString("status")))
                        .build();
            }



        } catch (SQLException e) {
            e.printStackTrace();
        }

        this.close();
        return null;
    }
    @Override
    public User getItemByToken(String userToken) {
        this.sql = "SELECT * FROM "+this.table+" WHERE \"userToken\" = ?;";
        try {
            this.statement = connection.prepareStatement(this.sql);
            this.statement.setString(1,userToken);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        this.execute();

        //returns DB object to java object
        return userBuilder(this.result);
    }


    public User getItemByUsername(String username) {
        this.sql = "SELECT * FROM "+this.table+" WHERE \"username\" = ? ;";
        try {
            this.statement = connection.prepareStatement(this.sql);
            this.statement.setString(1,username);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        this.execute();

        //returns DB object to java object
        return userBuilder(this.result);
    }


    @Override
    public User addItem(User item){
        HashGenerator hashGenerator = new HashGenerator();
        this.sql = "INSERT INTO \"player\" (\"userToken\", \"username\" , \"password\" , coins, elo, status) VALUES(?,?,?,?,?,?)";
        try {
            this.statement = connection.prepareStatement(this.sql);
            statement.setString(1,item.getUserToken());
            statement.setString(2,item.getUsername());
            statement.setString(3, hashGenerator.hashMe(item.getPassword()));
            statement.setString(4,item.getCoins()+"");
            statement.setString(5,item.getElo()+"");
            statement.setString(6,item.isStatus()+"");

        } catch (SQLException e) {
            e.printStackTrace();
        }

        this.execute();
        this.close();

        return getItemByToken(item.getUserToken());
    }
    @Override
    public User update(User item){

        this.sql = "UPDATE " + this.table +
                " SET " +
                "\"userToken\" = ? ," +
                "\"username\" = ? ," +
                "\"password\" = ? ," +
                "\"coins\" = ? ," +
                "\"elo\" = ? ," +
                "\"status\" = ? " +
                "WHERE \"userToken\" = ?;";

        try {
            this.statement = connection.prepareStatement(this.sql);
            statement.setString(1,item.getUserToken());
            statement.setString(2,item.getUsername());
            statement.setString(3,item.getPassword());
            statement.setString(4,item.getCoins()+"");
            statement.setString(5,item.getElo()+"");
            statement.setString(6,item.isStatus()+"");
            statement.setString(7,item.getUserToken());

        } catch (SQLException e) {
            e.printStackTrace();
        }

        this.execute();
        this.close();

        return getItemByToken(item.getUserToken());
    }


    public boolean delete(String itemID) {

        this.sql = "DELETE FROM "+this.table+" WHERE \"userToken\" = ?;";


        try {
            this.statement = connection.prepareStatement(this.sql);
            statement.setString(1,itemID);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        this.execute();
        this.close();

        return true;
    }

    public boolean checkPw(String input, String hashString){
        return hashString.equals(new HashGenerator().hashMe(input));
    }

    /*
    public String scoreBoard(String user){

        this.sql = "SELECT * FROM " + this.table + "WHERE \"userToken\" = ? ORDER BY elo DESC;";

        try {
            this.statement = connection.prepareStatement(this.sql);
            statement.setString(1, user);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        String scoreString = this.statement.toString();
        this.execute();
        this.close();

        return scoreString;
    }
    */

}
