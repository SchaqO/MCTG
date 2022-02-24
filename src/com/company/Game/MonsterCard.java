package com.company.Game;

public class MonsterCard {

    private String cardID;
    private CardName cardName;
    private int cardDmg;
    private CardElement cardElement;
    private CardType cardType;

    public CardType getCardType(){
        return cardType;
    }

    public MonsterCard(String cardID, CardName cardName, int cardDmg, CardElement cardElement, CardType cardType){
        this.cardID = cardID;
        this.cardName = cardName;
        this.cardDmg = cardDmg;
        this.cardElement = cardElement;
        this.cardType = cardType;
    }

    public MonsterCard(){
        this.cardType = CardType.MONSTER;
    }
}
