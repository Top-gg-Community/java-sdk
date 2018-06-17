package org.discordbots.api.client.entity;

import java.util.StringJoiner;

public class SimpleUser extends Entity {

    private String id;
    private String discriminator;
    private String username;
    private String avatar;


    public String getDiscriminator() {
        return discriminator;
    }
    public String getId() { return id; }
    public String getUsername() { return username; }
    public String getAvatar() { return avatar; }
    public boolean matchesUserID(String id){
        return this.id.equalsIgnoreCase(id);
    }
    public boolean matchesUserName(String name, String discriminator){
        return ((name + "#" + discriminator).equalsIgnoreCase(getUsername() + "#" + getDiscriminator()));
    }

}
