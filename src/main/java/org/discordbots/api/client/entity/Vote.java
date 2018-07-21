package org.discordbots.api.client.entity;

import com.google.gson.annotations.SerializedName;

public class Vote {

    @SerializedName("bot")
    private String botId;
    @SerializedName("user")
    private String userId;

    private String type;

    private String query;

    @SerializedName("isWeekend")
    private boolean weekend;



    public String getBotId() {
        return botId;
    }

    public String getUserId() {
        return userId;
    }

    public String getType() {
        return type;
    }

    public String getQuery() {
        return query;
    }

    public boolean isWeekend() {
        return weekend;
    }

}
