package com.company.db;

import com.company.db.repository.DbTable;
import com.company.model.Profile;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ProfileDB extends AbstractDBTable implements DbTable<Profile> {


    public ProfileDB(){
        this.table = "profile";
    }

    public Profile profileBuilder(ResultSet result){

        try {
            if(result.next()){
                return Profile.builder()
                        .userToken(result.getString("userToken"))
                        .description(result.getString("description"))
                        .image(result.getString("image"))
                        .name(result.getString("name"))
                        .build();
            }



        } catch (SQLException e) {
            e.printStackTrace();
        }

        this.close();
        return null;
    }
    @Override
    public Profile getItemByToken(String userToken) {
        this.sql = "SELECT * FROM "+this.table+ " WHERE \"userToken\" = ?;";
        try {
            this.statement = connection.prepareStatement(this.sql);
            this.statement.setString(1,userToken);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        this.execute();

        //returns DB object to java object
        return profileBuilder(this.result);
    }



    @Override
    public Profile addItem(Profile item){
        this.sql = "INSERT INTO "+ this.table + " (\"userToken\", \"name\" , \"description\" , image) VALUES(?,?,?,?)";
        try {
            this.statement = connection.prepareStatement(this.sql);
            statement.setString(1,item.getUserToken());
            statement.setString(2,item.getName());
            statement.setString(3,item.getDescription());
            statement.setString(4,item.getImage()+"");

        } catch (SQLException e) {
            e.printStackTrace();
        }

        this.execute();
        this.close();

        return getItemByToken(item.getUserToken());
    }



    @Override
    public Profile update(Profile item){
        return null;
    }

}
