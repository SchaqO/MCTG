package com.company.db;

import java.sql.SQLException;

public class TransactionDB extends AbstractDBTable {
    public TransactionDB() {
        this.table = "package";
    }
        public String getFirstItem(){
            this.sql = "SELECT TOP 1 * FROM "+this.table + ";";
            try {
                this.statement = connection.prepareStatement(this.sql);
            } catch (SQLException e) {
                e.printStackTrace();
            }

            this.execute();

            //returns DB object to java object

            String id = null;
            try {
                id = this.result.getString("id");
                this.result.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }


            return id;
        }

    }

