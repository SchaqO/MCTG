package com.test;

import com.company.model.Deck;
import com.company.model.Stack;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import com.company.model.User;

@DisplayName("UserTest")
public class UserTest {

    User user;

    @BeforeEach
    void beforeEach(){
        user = User.builder()
                .userToken("1")
                .username("username")
                .password("testpw")
                .elo(100)
                .coins(20)
                .build();
    }


    @Test
    @DisplayName("testUsername")
    void testUsername(){
        assertEquals("username", user.getUsername());
    }

    @Test
    @DisplayName("testPassword")
    void testPassword(){
        assertEquals("testpw", user.getPassword());
    }

    @Test
    @DisplayName("testElo")
    void testElo(){
        assertEquals(100, user.getElo());
    }

    @Test
    @DisplayName("testCoins")
    void testCoins(){
        assertEquals(20, user.getCoins());
    }

    @Test
    @DisplayName("testToken")
    void testToken(){
        assertEquals("1", user.getUserToken());
    }
}
