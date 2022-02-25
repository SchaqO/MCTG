package com.company.db;

import com.company.database.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public abstract class AbstractDBTable {
    protected Connection connection = DatabaseConnection.getInstance().getConnection();
    protected PreparedStatement statement;
    protected ResultSet result;
    public String sql;
    public String table;

    public void execute(){

        try {
            if(this.statement.execute()){
                this.result = this.statement.executeQuery();

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void close(){

        try {

                if(this.statement != null){
                    this.statement.close();
                }
                if(this.result != null){
                    this.result.close();
                }

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
