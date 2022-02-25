package com.company.model;

import com.company.model.card.AbstractCard;
import com.company.model.card.CardType;
import com.google.gson.annotations.SerializedName;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder (toBuilder = true)
public class Trade {

    @Setter
    @Getter
    @SerializedName("userToken")
    private String userToken;

    @Setter
    @Getter
    @SerializedName("cardId")
    private String cardId;

    @Setter
    @Getter
    @SerializedName("minPower")
    private double minPower;

    @Setter
    @Getter
    @SerializedName("cardType")
    private CardType cardType;

}
