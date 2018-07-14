package org.discordbots.api.client.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.google.gson.annotations.SerializedName;

@JsonIgnoreProperties
public class User extends SimpleUser {

    @SerializedName("defAvatar")
    private String defaultAvatar;

    private Social social;

    private boolean admin, mod, webMod;
    private boolean artist, certifiedDev, supporter;


    public String getDefaultAvatar() { return defaultAvatar; }

    public Social getSocial() { return social; }

    public boolean isAdmin() { return admin; }
    public boolean isMod() { return mod; }
    public boolean isWebMod() { return webMod; }

    public boolean isArtist() { return artist; }
    public boolean isCertifiedDev() { return certifiedDev; }
    public boolean isSupporter() { return supporter; }


    private class Social {
        String youtube, reddit, twitter, instagram, github;
    }

}
