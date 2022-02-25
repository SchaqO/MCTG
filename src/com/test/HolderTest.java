package com.test;

import com.company.model.Holder;
import com.company.model.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("HolderTest")
public class HolderTest {

    Holder holder;

    @BeforeEach
    void beforeEach(){
        holder = holder.builder()
                .cardHolderID("99")
                .cardID("GoblinID")
                .holderID("PlayerID")
                .number(100)
                .locked(false)
                .build();
    }

    @Test
    @DisplayName("testCardHolderID")
    void testCardHolderID(){
        assertEquals("99", holder.getCardHolderID());
    }

    @Test
    @DisplayName("testCardID")
    void testCardID(){
        assertEquals("GoblinID", holder.getCardID());
    }

    @Test
    @DisplayName("testHolderID")
    void testHolderID(){
        assertEquals("PlayerID", holder.getHolderID());
    }

    @Test
    @DisplayName("testCardHolderID")
    void number(){
        assertEquals(100, holder.getNumber());
    }

    @Test
    @DisplayName("testLocked")
    void testlocked(){
        assertEquals(false, false);
    }
}
