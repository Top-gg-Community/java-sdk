package org.discordbots.api.client.entity;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;

@Getter
public class User extends SimpleUser {

    @SerializedName("defAvatar")
    private String defaultAvatar;

    private boolean admin, mod, webMod;
    private boolean artist, certifiedDev, supporter;

    private Social social;

}
