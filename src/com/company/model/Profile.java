package com.company.model;

import com.google.gson.annotations.SerializedName;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder(toBuilder = true)
public class Profile {

    @Getter
    @Setter
    @SerializedName("userToken")
    private String userToken;

    @Getter
    @SerializedName("Name")
    private String name;

    @Getter
    @SerializedName("Description")
    @Builder.Default
    private String description = "about me: i like tennis";

    @Getter
    @SerializedName("Image")
    @Builder.Default
    private String image = "D:";
}
