package org.discordbots.api.client.entity;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;

import java.util.Collections;
import java.util.List;

public class BotStats {

    @SerializedName("server_count")
    @Getter
    private int serverCount;
    private List<Integer> shards;

    public List<Integer> getShards() { return Collections.unmodifiableList(shards); }
}
