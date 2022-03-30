package com.company.model.card;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;

public abstract class AbstractCard {

    @Getter
    @SerializedName("cardID")
    private String cardID;
    @Getter
    @SerializedName("cardName")
    private CardName cardName;
    @Getter
    @SerializedName("cardDMG")
    private int cardDmg;
    @Getter
    @SerializedName("cardElement")
    private CardElement cardElement;

    @Getter
    private CardType cardtype;

    public AbstractCard(String cardID, CardName cardName, int cardDmg, CardElement cardElement){
        this.cardID = cardID;
        this.cardName = cardName;
        this.cardDmg = cardDmg;
        this.cardElement = cardElement;
    }

}
