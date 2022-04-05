package com.test;

import com.company.db.UserDB;
import com.company.model.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserDBTest {


    UserDB userDB = new UserDB();

    private User initUser(){
        return User.builder()
                .userToken("Test-User")
                .username("Username")
                .password("password")
                .coins(1)
                .build();
    }

    @Test
    void update() {
        User user = initUser();
        assertNotNull(user);
        assertTrue(userDB.delete(user.getUserToken()));
        user = userDB.addItem(user);
        assertNotNull(user);
        user.setCoins(2);
        user = userDB.update(user);
        assertNotNull(user);
        assertFalse(user.getCoins() == 1);
        assertTrue(user.getCoins() == 2);
        assertTrue(userDB.delete(user.getUserToken()));
    }
    

    @Test
    void getItemByToken() {
        User user = initUser();
        assertNotNull(user);
        assertTrue(userDB.delete(user.getUserToken()));
        user = userDB.addItem(user);
        assertNotNull(user);
        user = userDB.getItemByToken(user.getUserToken());
        assertNotNull(user);
        assertTrue(userDB.delete(user.getUserToken()));
    }



    @Test
    void addItem() {
        User user = initUser();
        assertNotNull(user);
        assertTrue(userDB.delete(user.getUserToken()));
        user = userDB.addItem(user);
        assertNotNull(user);
        assertTrue(userDB.delete(user.getUserToken()));
    }
}