package com.company.db;

import com.company.db.repository.DbTable;
import com.company.model.Packages;
import com.company.model.Stack;
import com.company.model.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PackageDB extends AbstractDBTable implements DbTable<Packages> {

    private final static int packagePrice = 5;

    public PackageDB(){
        this.table = "package";
    }

    public Packages packageBuilder(ResultSet result){

        ArrayList<String> currentPackage = new ArrayList<>();


        try {
            if(result.next()){
                for(int i = 1; i < 5; i++){
                    currentPackage.add(result.getString("cardid" + i));
                }
                return Packages.builder()
                        .id(result.getString("id"))
                        .cardIdPackage(currentPackage)
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
        this.sql = "SELECT * FROM \"package\" WHERE \"id\" = ?;";
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
            statement.setString(2,item.getCardIdPackage().get(0));
            statement.setString(3,item.getCardIdPackage().get(1));
            statement.setString(4,item.getCardIdPackage().get(2));
            statement.setString(5,item.getCardIdPackage().get(3));
            statement.setString(6,item.getCardIdPackage().get(4));

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


    public ArrayList<Packages> getAllPackages() {

        ArrayList<Packages> list = new ArrayList<>();

        this.sql = "SELECT * FROM \"package\";";
        try {
            this.statement = connection.prepareStatement(this.sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        this.execute();

            try {
                while (this.result.next()){
                    //System.out.println(result.getString("id"));
                    list.add(this.getItemByToken(result.getString("id")));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }


        return list;
    }




/*
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

 */

    public boolean sellPackage(String userID,String packageID){
        Packages packages = this.getItemByToken(packageID);
        UserDB userDB = new UserDB();
        User currentUser = userDB.getItemByToken(userID);


        if(packages == null){
            return false;
        }
        if(currentUser == null){
            return false;
        }
        if(currentUser.getCoins() < 5){
            return false;
        }

        currentUser.setCoins(currentUser.getCoins()-5);
        userDB.update(currentUser);
        addCardsToUser(packages.getCardIdPackage(),userID);
        this.deleteItemById(packages.getId());
        return true;
    }


    public void addCardsToUser(ArrayList<String> cardsID, String userID){
        StackDB stackDB  = new StackDB();
        for (int i = 0; i < cardsID.size(); i++){
            stackDB.addCardToStack(userID, cardsID.get(i));
        }
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

