package org.discordbots.api.client.entity;

import com.google.gson.annotations.SerializedName;

public class VotingMultplier {

    @SerializedName("is_weekend")
    private boolean weekend;



    public boolean isWeekend() {
        return weekend;
    }

}
