package com.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@DisplayName("CardElement")
public class CardElementTest {

    @org.junit.jupiter.api.Test
    @DisplayName("CardElement")
    void listElements() {
        com.company.model.card.CardElement cardElement = com.company.model.card.CardElement.FIRE;
        com.company.model.card.CardElement cardElement2 = com.company.model.card.CardElement.WATER;
        com.company.model.card.CardElement cardElement3 = com.company.model.card.CardElement.NORMAL;


        Assertions.assertEquals(com.company.model.card.CardElement.FIRE, cardElement);
        Assertions.assertEquals(com.company.model.card.CardElement.WATER, cardElement2);
        Assertions.assertEquals(com.company.model.card.CardElement.NORMAL, cardElement3);



    }
}
