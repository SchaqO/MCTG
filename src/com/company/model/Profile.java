package com.company.model;

import com.google.gson.annotations.SerializedName;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
@Data
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
    @SerializedName("Bio")
    @Builder.Default
    private String description = "FM";

    @Getter
    @SerializedName("Image")
    @Builder.Default
    private String image = "::-M";
}
