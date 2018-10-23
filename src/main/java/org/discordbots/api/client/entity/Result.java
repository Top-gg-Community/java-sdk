package org.discordbots.api.client.entity;

import lombok.Getter;

import java.util.List;

@Getter
public class Result<T> {

    private List<T> results;
    private int limit;
    private int offset;
    private int count;
    private int total;

}
