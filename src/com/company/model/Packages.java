package com.company.model;

import lombok.Getter;
import lombok.Setter;
import lombok.Builder;
import com.google.gson.annotations.SerializedName;

@Builder(toBuilder = true)
public class Packages {
    @Getter
    @SerializedName("id")
    private String id;

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

    @Getter
    @Setter
    @SerializedName("cardId5")
    private String cardId5;
}
