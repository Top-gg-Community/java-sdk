package org.discordbots.api.client.entity;

import lombok.Getter;

@Getter
public class SimpleUser {

    private String id;
    private String username;
    private String discriminator;

    private String avatar;
}
