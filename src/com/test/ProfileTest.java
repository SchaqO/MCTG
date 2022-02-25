package com.test;

import com.company.model.Profile;
import com.company.model.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("ProfileTest")
public class ProfileTest {

    Profile profile;

    @BeforeEach
    void beforeEach(){
        profile = Profile.builder()
                .userToken("9000")
                .name("name")
                .description("A little test")
                .image("D:")
                .build();
    }

    @Test
    @DisplayName("testUserToken")
    void testUserToken(){
        assertEquals("9000", profile.getUserToken());
    }

    @Test
    @DisplayName("testName")
    void testName(){
        assertEquals("name", profile.getName());
    }

    @Test
    @DisplayName("testDescription")
    void testDescription(){
        assertEquals("A little test", profile.getDescription());
    }

    @Test
    @DisplayName("testImage")
    void testImage(){
        assertEquals("D:", profile.getImage());
    }
}
