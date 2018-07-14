package org.discordbots.api.client.io;

import com.google.gson.Gson;
import okhttp3.Response;

import java.io.IOException;

public class DefaultResponseTransformer<E> implements ResponseTransformer<E> {

    private final Class<E> clazz;
    private final Gson gson;

    public DefaultResponseTransformer(Class<E> clazz, Gson gson) {
        this.clazz = clazz;
        this.gson = new Gson();
    }

    @Override
    public E transform(Response response) throws IOException {
        String body = response.body().string();
        return gson.fromJson(body, clazz);
    }

}
