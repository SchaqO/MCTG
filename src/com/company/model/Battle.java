package com.company.model;

import com.company.model.User;
import com.google.gson.annotations.SerializedName;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Builder (toBuilder = true)
@Data
public class Battle {


    @Getter
    @Setter
    @SerializedName("player1")
    private User player1;

    @Getter
    @Setter
    @Builder.Default
    @SerializedName("player2")
    private User player2 = null;

    @Getter
    @Setter
    @Builder.Default
    @SerializedName("round")
    int round = 0;

    @Getter
    @Setter
    @Builder.Default
    @SerializedName("winner")
    private User winner = null;

}
