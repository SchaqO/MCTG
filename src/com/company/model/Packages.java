package com.company.model;

import lombok.Getter;
import lombok.Setter;
import lombok.Builder;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

@Builder(toBuilder = true)
public class Packages {
    @Getter
    @SerializedName("id")
    private String id;

    @Getter
    @Setter
    @SerializedName("cardPackage")
    private ArrayList<String> cardPackage;


    @Getter
    @Builder.Default
    @SerializedName("price")
    private int price = 5;
}
