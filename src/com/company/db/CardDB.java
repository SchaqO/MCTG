package com.company.db;

import com.company.db.repository.DbTable;
import com.company.model.Deck;
import com.company.model.Stack;
import com.company.model.card.AbstractCard;
import com.company.model.card.MonsterCard;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CardDB extends AbstractDBTable implements DbTable<AbstractCard> {

    public CardDB(){
        this.table = "card";
    }

    public AbstractCard cardBuilder(ResultSet result){

        // if Monster und if Spell
        try {
            if(result.next()){
                return null;
            }



        } catch (SQLException e) {
            e.printStackTrace();
        }

        this.close();
        return null;
    }
    @Override
    public AbstractCard getItemByToken(String id) {
        this.sql = "SELECT * FROM "+this.table+ " WHERE \"id\" = ?;";
        try {
            this.statement = connection.prepareStatement(this.sql);
            this.statement.setString(1,id);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        this.execute();

        //returns DB object to java object
        return cardBuilder(this.result);
    }



    @Override
    public AbstractCard addItem(AbstractCard item){
        this.sql = "INSERT INTO "+ this.table + " (\"id\", \"cardid1\" , \"cardid2\" , \"cardid3\", \"cardid4\") VALUES(?,?,?,?,?,?)";
        try {
            this.statement = connection.prepareStatement(this.sql);
            //statement.setString(1,item.getUserToken());
            //statement.setString(2,item.getCardId1());
            //statement.setString(3,item.getCardId3());
            //statement.setString(4,item.getCardId4());

        } catch (SQLException e) {
            e.printStackTrace();
        }

        this.execute();
        this.close();

        return getItemByToken(item.getCardID());
    }



    @Override
    public AbstractCard update(AbstractCard item){
        return null;
    }
}
