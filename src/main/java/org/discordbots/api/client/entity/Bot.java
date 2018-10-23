package org.discordbots.api.client.entity;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;

import java.time.OffsetDateTime;
import java.util.List;

@Getter
public class Bot {

    private String id;
    @SerializedName("clientid")
    private String clientId;
    private String username;
    private String discriminator;

    private String avatar;
    @SerializedName("defAvatar")
    private String defaultAvatar;

    private String prefix;
    private String invite;
    private String website;
    private String vanity;
    private String support;
    private List<String> tags;

    @SerializedName("longdesc")
    private String longDescription;
    @SerializedName("shortdesc")
    private String shortDescription;
    @SerializedName("betadesc")
    private String betaDescription;

    @SerializedName("certifiedBot")
    private boolean certified;

    @SerializedName("date") // rename so that the naming actually makes sense
    private OffsetDateTime approvalTime;

    @SerializedName("server_count")
    private long serverCount;

    private List<String> guilds;
    private List<Integer> shards;
    private int monthlyPoints;
    private int points;

    private boolean legacy;
}
