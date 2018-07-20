package org.discordbots.api.client.entity;

import com.google.gson.annotations.SerializedName;

public class User extends SimpleUser {

    private String id;
    private String username;
    private String discriminator;

    private String avatar;
    @SerializedName("defAvatar")
    private String defaultAvatar;

    private boolean admin, mod, webMod;
    private boolean artist, certifiedDev, supporter;

    private Social social;



    public String getDefaultAvatar() {
        return defaultAvatar;
    }

    public boolean isAdmin() {
        return admin;
    }

    public boolean isMod() {
        return mod;
    }

    public boolean isWebMod() {
        return webMod;
    }

    public boolean isArtist() {
        return artist;
    }

    public boolean isCertifiedDev() {
        return certifiedDev;
    }

    public boolean isSupporter() {
        return supporter;
    }

    public Social getSocial() {
        return social;
    }

}
