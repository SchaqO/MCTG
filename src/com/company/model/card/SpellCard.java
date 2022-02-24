package com.company.model.card;

import com.company.model.card.CardElement;
import com.company.model.card.CardName;
import com.company.model.card.CardType;

public class  SpellCard extends AbstractCard {

    CardType cardType;


    public SpellCard(String cardID, CardName cardName, int cardDmg, CardElement cardElement) {
        super(cardID, cardName, cardDmg, cardElement);
        this.cardType = CardType.SPELL;
    }
}
