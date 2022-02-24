package com.company.model.card;

import com.company.model.card.CardElement;
import com.company.model.card.CardName;
import com.company.model.card.CardType;

public class MonsterCard extends AbstractCard {

    CardType cardType;


    public MonsterCard(String cardID, CardName cardName, int cardDmg, CardElement cardElement) {
        super(cardID, cardName, cardDmg, cardElement);
        this.cardType = CardType.MONSTER;
    }
}
