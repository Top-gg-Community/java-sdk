package org.discordbots.api.client.entity;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;

@Getter
public class Vote {

    @SerializedName("bot")
    private String botId;
    @SerializedName("user")
    private String userId;

    private String type;

    private String query;

    @SerializedName("isWeekend")
    private boolean weekend;

}
