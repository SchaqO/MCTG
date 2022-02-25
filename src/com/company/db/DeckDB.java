package com.company.db;

import com.company.db.repository.DbTable;
import com.company.model.Deck;
import com.company.model.Profile;
import com.company.model.Stack;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DeckDB extends AbstractDBTable implements DbTable<Deck> {
    public DeckDB(){
        this.table = "deck";
    }

    public Deck deckBuilder(ResultSet result){

        try {
            if(result.next()){
                return Deck.builder()
                        .userToken(result.getString("userToken"))
                        .cardId1(result.getString("cardId1"))
                        .cardId2(result.getString("cardId2"))
                        .cardId3(result.getString("cardId3"))
                        .cardId4(result.getString("cardId4"))
                        .build();
            }



        } catch (SQLException e) {
            e.printStackTrace();
        }

        this.close();
        return null;
    }
    @Override
    public Deck getItemByToken(String userToken) {
        this.sql = "SELECT * FROM "+this.table+ " WHERE \"userToken\" = ?;";
        try {
            this.statement = connection.prepareStatement(this.sql);
            this.statement.setString(1,userToken);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        this.execute();

        //returns DB object to java object
        return deckBuilder(this.result);
    }



    @Override
    public Deck addItem(Deck item){
        this.sql = "INSERT INTO "+ this.table + " (\"userToken\", \"cardid1\" , \"cardid2\" , \"cardid3\", \"cardid4\") VALUES(?,?,?,?,?,?)";
        try {
            this.statement = connection.prepareStatement(this.sql);
            statement.setString(1,item.getUserToken());
            statement.setString(2,item.getCardId1());
            statement.setString(3,item.getCardId3());
            statement.setString(4,item.getCardId4());

        } catch (SQLException e) {
            e.printStackTrace();
        }

        this.execute();
        this.close();

        return getItemByToken(item.getUserToken());
    }



    @Override
    public Deck update(Deck item){
        return null;
    }
}
