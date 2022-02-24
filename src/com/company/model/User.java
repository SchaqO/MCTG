package com.company.model;


import com.google.gson.annotations.SerializedName;
import lombok.Builder;
import lombok.Getter;

@Builder (toBuilder = true)
public class User {
    @Getter
    @SerializedName("userToken")
    private String userToken;
    @Getter
    @SerializedName("Username")
    private String username;
    @Getter
    @SerializedName("Password")
    private String password;
    @Getter
    @SerializedName("Coins")
    @Builder.Default
    private int coins = 20;
    @Getter
    @SerializedName("Elo")
    @Builder.Default
    private int elo = 100;
    @Getter
    @SerializedName("Status")
    @Builder.Default
    private boolean status = false;
}
