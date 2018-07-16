package org.discordbots.api.client.io;

import com.google.gson.Gson;
import okhttp3.Response;

import java.io.IOException;

public class DefaultResponseTransformer<E> implements ResponseTransformer<E> {

    private final Class<E> aClass;
    private final Gson gson;

    public DefaultResponseTransformer(Class<E> aClass, Gson gson) {
        this.aClass = aClass;
        this.gson = gson;
    }

    @Override
    public E transform(Response response) throws IOException {
        String body = response.body().string();
        return gson.fromJson(body, aClass);
    }

}
