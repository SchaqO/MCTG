package com.company.model.card;

import com.google.gson.annotations.SerializedName;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public abstract class AbstractCard {

    @Getter
    @SerializedName("Id")
    private String cardID;
    @Getter
    @SerializedName("Name")
    private CardName cardName;
    @Getter
    @SerializedName("Damage")
    private int cardDmg;
    @Getter
    @SerializedName("Element")
    @Builder.Default
    private CardElement cardElement = CardElement.NORMAL;

    @Getter
    private CardType cardtype;

    public AbstractCard(String cardID, CardName cardName, int cardDmg, CardElement cardElement){
        this.cardID = cardID;
        this.cardName = cardName;
        this.cardDmg = cardDmg;
        this.cardElement = cardElement;
    }

}
