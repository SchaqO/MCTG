package com.company.db;

import com.company.db.repository.DbTable;
import com.company.model.Trade;
import com.company.model.User;
import com.company.model.card.CardType;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TradeDB extends AbstractDBTable implements DbTable<Trade> {

    public TradeDB(){
        this.table = "trade";
    }

    //builds a class/object from the database and returns it back
    public Trade tradeBuilder(ResultSet result){

        try {
            if(result.next()){
                return Trade.builder()
                        .userToken(result.getString("userToken"))
                        .cardId(result.getString(result.getString("cardId")))
                        .minPower(Integer.parseInt(result.getString("minPower")))
                        .cardType(CardType.valueOf(result.getString(result.getString("cardType"))))
                        .build();
            }



        } catch (SQLException e) {
            e.printStackTrace();
        }

        this.close();
        return null;
    }


    @Override
    public Trade getItemByToken(String id) {
        this.sql = "SELECT * FROM "+this.table+ " WHERE \"id\" = ?;";
        try {
            this.statement = connection.prepareStatement(this.sql);
            this.statement.setString(1,id);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        this.execute();

        //returns DB object to java object
        return tradeBuilder(this.result);
    }



    @Override
    public Trade addItem(Trade item){
        this.sql = "INSERT INTO "+ this.table + " (\"userToken\" , \"card\" , \"minpower\", \"cardtype\") VALUES(?,?,?,?,?,?)";
        try {
            this.statement = connection.prepareStatement(this.sql);
            statement.setString(1,item.getUserToken());
            statement.setString(2,item.getCardId());
            statement.setString(3,item.getMinPower()+"");
            statement.setString(4,item.getCardType()+"");

        } catch (SQLException e) {
            e.printStackTrace();
        }

        this.execute();
        this.close();

        return getItemByToken(item.getUserToken());
    }
    @Override
    public Trade update(Trade item){
        return null;
    }
}
