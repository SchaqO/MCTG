package com.company.model.card;

public abstract class AbstractCard {

    private String cardID;
    private CardName cardName;
    private int cardDmg;
    private CardElement cardElement;

    public AbstractCard(String cardID, CardName cardName, int cardDmg, CardElement cardElement){
        this.cardID = cardID;
        this.cardName = cardName;
        this.cardDmg = cardDmg;
        this.cardElement = cardElement;
    }

}
