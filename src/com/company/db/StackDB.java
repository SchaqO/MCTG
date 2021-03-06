package com.company.db;

import com.company.db.repository.DbTable;
import com.company.model.Stack;
import com.company.model.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class StackDB extends AbstractDBTable implements DbTable<Stack> {

    public StackDB(){
        this.table = "stack";
    }

    //builds a class/object from the database and returns it back
    public Stack stackBuilder(ResultSet result){

        try {
            if(result.next()){
                return Stack.builder()
                        .userToken(result.getString("userToken"))
                        .build();
            }



        } catch (SQLException e) {
            e.printStackTrace();
        }

        this.close();
        return null;
    }
    @Override
    public Stack getItemByToken(String userToken) {
        this.sql = "SELECT * FROM \"player\" WHERE \"userToken\" = ?;";
        try {
            this.statement = connection.prepareStatement(this.sql);
            this.statement.setString(1,userToken);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        this.execute();

        //returns DB object to java object
        return stackBuilder(this.result);
    }
    @Override
    public Stack addItem(Stack item){
        this.sql = "INSERT INTO "+ this.table + " (\"userToken\", \"username\" , \"password\" , coins, elo, status) VALUES(?,?,?,?,?,?)";
        try {
            this.statement = connection.prepareStatement(this.sql);
            statement.setString(1,item.getUserToken());
            statement.setString(1,item.getUserToken());



        } catch (SQLException e) {
            e.printStackTrace();
        }

        this.execute();
        this.close();

        return getItemByToken(item.getUserToken());
    }

    public boolean deleteCardFromStack(String userToken,String cardId){
        this.sql = "DELETE FROM "+this.table+" WHERE \"userToken\" = ? AND \"cardId\" = ?;";


        try {
            this.statement = connection.prepareStatement(this.sql);
            statement.setString(1,userToken);
            statement.setString(2,cardId);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        this.execute();
        this.close();

        return true;
    }

    public boolean addCardToStack(String userToken, String cardId){
        this.sql = "INSERT INTO "+ this.table + " (\"userToken\", \"cardId\") VALUES(?,?)";
        try {
            this.statement = connection.prepareStatement(this.sql);
            statement.setString(1,userToken);
            statement.setString(2,cardId);

        } catch (SQLException e) {
            e.printStackTrace();
        }

        this.execute();
        this.close();

        return true;
    }

    public Stack getAllCardsFromUser(String userid){
        UserDB userdb = new UserDB();
        ArrayList<String> cardList = new ArrayList<>();
        if(userdb.getItemByToken(userid) == null){
            return null;
        }

        this.sql = "SELECT * FROM "+this.table+" WHERE \"userToken\" = ?;";
        try {
            this.statement = connection.prepareStatement(this.sql);
            this.statement.setString(1,userid);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        this.execute();


            try {
                while (this.result.next()){
                    cardList.add(this.result.getString("cardId"));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }


            if(cardList.size() == 0){
                return null;
            }
        return Stack.builder()
                .userToken(userid)
                .cardIdList(cardList)
                .build();
    }


    @Override
    public Stack update(Stack item){
        return null;
    }
}

