package org.discordbots.api.client.entity;

import com.google.gson.annotations.SerializedName;

import java.util.Collections;
import java.util.List;

public class Bot extends Entity {

    private String id;
    @SerializedName("client_id")
    private String clientId;
    private String username;
    private String discriminator;

    private String avatar;
    @SerializedName("defAvatar")
    private String defaultAvatar;

    @SerializedName("longdesc")
    private String longDescription;
    @SerializedName("shortdesc")
    private String shortDescription;
    @SerializedName("betadesc")
    private String betaDescription;

    @SerializedName("server_count")
    private int serverCount;
    private List<Integer> shards;

    private int points;

    @SerializedName("support")
    private String supportInvite;

    private String vanity;

    private String prefix;

    @SerializedName("lib")
    private String library;

    private List<String> tags;

    private boolean certifiedBot;
    private boolean legacy;



    public String getId() { return id; }
    public String getClientId() { return clientId; }
    public String getUsername() { return username; }
    public String getDiscriminator() { return discriminator; }

    public String getAvatar() { return avatar; }
    public String getDefaultAvatar() { return defaultAvatar; }

    public String getShortDescription() { return shortDescription; }
    public String getLongDescription() { return longDescription; }
    public String getBetaDescription() { return betaDescription; }

    public int getServerCount() { return serverCount; }
    public List<Integer> getShards() { return Collections.unmodifiableList(shards); }

    public String getVanity() { return vanity; }
    public String getPrefix() { return prefix; }
    public int getPoints() { return points; }
    public String getSupportInvite() { return supportInvite; }
    public String getLibrary() { return library; }
    public List<String> getTags() { return Collections.unmodifiableList(tags); }

    public boolean isCertifiedBot() { return certifiedBot; }

    public boolean isLegacy() { return legacy; }

}
