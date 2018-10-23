package org.discordbots.api.client.entity;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;

@Getter
public class VotingMultiplier {

    @SerializedName("is_weekend")
    private boolean weekend;

}
