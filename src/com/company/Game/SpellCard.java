package com.company.Game;

public class SpellCard {

    private String cardID;
    private CardName cardName;
    private int cardDmg;
    private CardElement cardElement;
    private CardType cardType;

    public CardType getCardType(){
        return cardType;
    }

    public SpellCard(String cardID, CardName cardName, int cardDmg, CardElement cardElement, CardType cardType){
        this.cardID = cardID;
        this.cardName = cardName;
        this.cardDmg = cardDmg;
        this.cardElement = cardElement;
        this.cardType = cardType;
    }

    public SpellCard(){
        this.cardType = CardType.SPELL;
    }
}
