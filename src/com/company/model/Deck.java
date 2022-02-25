package com.company.model;

import com.company.model.card.AbstractCard;
import com.google.gson.annotations.SerializedName;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Builder(toBuilder = true)
public class Deck {
    @Getter
    @Setter
    @SerializedName("userToken")
    String userToken;

    @Getter
    @Setter
    @SerializedName("cardId1")
    private String cardId1;

    @Getter
    @Setter
    @SerializedName("cardId2")
    private String cardId2;

    @Getter
    @Setter
    @SerializedName("cardId3")
    private String cardId3;

    @Getter
    @Setter
    @SerializedName("cardId4")
    private String cardId4;

}
