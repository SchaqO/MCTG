package com.test;

import com.company.model.card.CardType;
import org.junit.jupiter.api.DisplayName;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("CheckCardType")
public class CardTypeTest {

    @org.junit.jupiter.api.Test
    @DisplayName("CardElement")
    void cardTypeCheck() {
        CardType cardType = CardType.MONSTER;
        CardType cardType2 = CardType.SPELL;

        assertEquals(CardType.SPELL, cardType2);
        assertEquals(CardType.MONSTER, cardType);
    }

}
