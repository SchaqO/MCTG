package com.company.model;


import com.google.gson.annotations.SerializedName;
import lombok.Builder;

@Builder (toBuilder = true)
public class User {

    @SerializedName("userToken")
    private String userToken;
    @SerializedName("Username")
    private String username;
    @SerializedName("Password")
    private String password;
    @SerializedName("Coins")
    @Builder.Default
    private int coins = 20;
    @SerializedName("Elo")
    @Builder.Default
    private int elo = 100;
    @SerializedName("Status")
    @Builder.Default
    private boolean status = false;
}
