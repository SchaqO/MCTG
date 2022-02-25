package com.company.model;

import com.google.gson.annotations.SerializedName;
import lombok.Builder;
import lombok.Getter;

@Builder(toBuilder = true)
public class Holder {

    @Getter
    @SerializedName("cardHolderID")
    private String cardHolderID;

    @Getter
    @SerializedName("cardID")
    private String cardID;

    @Getter
    @SerializedName("holderID")
    private String holderID;

    @Getter
    @SerializedName("number")
    private double number;

    @Getter
    @SerializedName("locked")
    private boolean locked;
}
