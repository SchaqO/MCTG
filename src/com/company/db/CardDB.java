package com.company.db;

import com.company.db.repository.DbTable;
import com.company.model.Deck;
import com.company.model.Stack;
import com.company.model.card.*;

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
                if(CardType.valueOf(result.getString("cardtype")).equals(CardType.MONSTER)){
                    return new MonsterCard(
                            result.getString("id"),
                            CardName.valueOf(result.getString("cardname")),
                            Integer.valueOf(result.getString("carddmg")),
                            CardElement.valueOf(result.getString("cardelement"))
                    );
                }else return new SpellCard(
                            result.getString("id"),
                            CardName.valueOf(result.getString("cardname")),
                            Integer.valueOf(result.getString("carddmg")),
                            CardElement.valueOf(result.getString("cardelement"))
                    );
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
        this.sql = "INSERT INTO "+ this.table + " (\"id\", \"cardname\" , \"carddmg\" , \"cardelement\", \"cardtype\") VALUES(?,?,?,?,?)";
        try {
            this.statement = connection.prepareStatement(this.sql);
            statement.setString(1,item.getCardID());
            statement.setString(2,"" + item.getCardName());
            statement.setString(3,"" + item.getCardDmg());
            statement.setString(4,"" + item.getCardElement());
            statement.setString(5,"" + item.getCardtype());

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
