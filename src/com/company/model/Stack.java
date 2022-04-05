package com.company.model;

import com.google.gson.annotations.SerializedName;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

@Builder(toBuilder = true)
public class Stack {
    @Getter
    @Setter
    @SerializedName("userToken")
    private String userToken;

    @Getter
    @Setter
    @Builder.Default
    @SerializedName("stack")
    private ArrayList<String> cardIdList = new ArrayList<>();
}

