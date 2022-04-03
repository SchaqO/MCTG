package com.company.db;


import com.company.model.Holder;
import com.company.model.card.AbstractCard;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class HolderDB extends AbstractDBTable {

    protected String[] parameter;

    public HolderDB(){
        this.table = "cardHolder";
    }

    public Holder cardHolder(ResultSet result) throws SQLException {

        if (result.next()) {
            Holder holder = Holder.builder()
                    .cardHolderID(this.result.getString("cardHolderId"))
                    .cardID(this.result.getString("cardid"))
                    .number(Double.parseDouble(this.result.getString("number")))
                    .holderID("holderid")
                    .locked(Boolean.parseBoolean(this.result.getString("locked")))
                    .build();

                    return holder;
        }

        return null;
    }

    public ArrayList<AbstractCard> loadCardsFromId(String holderID) {
        this.parameter = new String[] {holderID};
        ArrayList<AbstractCard> cards = new ArrayList<>();

        this.sql = "SELECT * FROM \"cardHolder\" WHERE holderid = ? ;";

        try {
            this.statement = connection.prepareStatement(this.sql);
            statement.setString(1, String.valueOf(this.parameter));
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return cards;

    }







}
