package com.company.db;

import com.company.db.repository.DbTable;
import com.company.model.Packages;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PackageDB extends AbstractDBTable implements DbTable<Packages> {


    public PackageDB(){
        this.table = "package";
    }

    public Packages packageBuilder(ResultSet result){

        try {
            if(result.next()){
                return Packages.builder()
                        .id(result.getString("id"))
                        .cardId1(result.getString("cardId1"))
                        .cardId2(result.getString("cardId2"))
                        .cardId3(result.getString("cardId3"))
                        .cardId4(result.getString("cardId4"))
                        .cardId5(result.getString("cardId5"))
                        .build();
            }



        } catch (SQLException e) {
            e.printStackTrace();
        }

        this.close();
        return null;
    }
    @Override
    public Packages getItemByToken(String id) {
        this.sql = "SELECT * FROM "+this.table+ " WHERE \"id\" = ?;";
        try {
            this.statement = connection.prepareStatement(this.sql);
            this.statement.setString(1,id);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        this.execute();

        //returns DB object to java object
        return packageBuilder(this.result);
    }


    @Override
    public Packages addItem(Packages item){
        this.sql = "INSERT INTO "+ this.table + " (\"id\", \"cardid1\" , \"cardid2\" , \"cardid3\", \"cardid4\", \"cardid5\") VALUES(?,?,?,?,?,?)";
        try {
            this.statement = connection.prepareStatement(this.sql);
            statement.setString(1,item.getId());
            statement.setString(2,item.getCardId1());
            statement.setString(3,item.getCardId2());
            statement.setString(4,item.getCardId3());
            statement.setString(5,item.getCardId4());
            statement.setString(6,item.getCardId5());


        } catch (SQLException e) {
            e.printStackTrace();
        }

        this.execute();
        this.close();

        return getItemByToken(item.getId());
    }




    @Override
    public Packages update(Packages item){
        return null;
    }


    public boolean deleteItemByToken(String id) {
        this.sql = "DELETE * FROM "+this.table+ " WHERE \"id\" = ?;";
        try {
            this.statement = connection.prepareStatement(this.sql);
            this.statement.setString(1,id);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        this.execute();

        //returns DB object to java object
        return true;
    }


    public Boolean deleteItemById(String id) {
        this.sql = "DELETE FROM "+this.table+ " WHERE \"id\" = ?;";
        try {
            this.statement = connection.prepareStatement(this.sql);
            this.statement.setString(1,id);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        this.execute();

        //returns DB object to java object
        return true;
    }
}

