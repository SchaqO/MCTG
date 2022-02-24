package com.company.db;

import com.company.db.repository.DbTable;
import com.company.model.User;

public class UserDB implements DbTable<User> {

    @Override
    public User getItemByToken(String userToken) {
        return null;
    }
    @Override
    public User addItem(User item){
        return null;
    }

    @Override
    public User update(User item){
        return null;
    }
}
