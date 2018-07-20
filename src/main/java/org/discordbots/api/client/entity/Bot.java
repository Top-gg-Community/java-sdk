package org.discordbots.api.client.entity;

import com.google.gson.annotations.SerializedName;

import java.time.OffsetDateTime;
import java.util.List;

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



    public String getId() {
        return id;
    }

    public String getClientId() {
        return clientId;
    }

    public String getUsername() {
        return username;
    }

    public String getDiscriminator() {
        return discriminator;
    }

    public String getAvatar() {
        return avatar;
    }

    public String getDefaultAvatar() {
        return defaultAvatar;
    }

    public String getPrefix() {
        return prefix;
    }

    public String getInvite() {
        return invite;
    }

    public String getWebsite() {
        return website;
    }

    public String getVanity() {
        return vanity;
    }

    public String getSupport() {
        return support;
    }

    public List<String> getTags() {
        return tags;
    }

    public String getLongDescription() {
        return longDescription;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public String getBetaDescription() {
        return betaDescription;
    }

    public boolean isCertified() {
        return certified;
    }

    public OffsetDateTime getApprovalTime() {
        return approvalTime;
    }

    public long getServerCount() {
        return serverCount;
    }

    public List<String> getGuilds() {
        return guilds;
    }

    public List<Integer> getShards() {
        return shards;
    }

    public int getMonthlyPoints() {
        return monthlyPoints;
    }

    public int getPoints() {
        return points;
    }

    public boolean isLegacy() {
        return legacy;
    }

}
