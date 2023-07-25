package org.discordbots.api.client.io;

import okhttp3.Response;

public class EmptyResponseTransformer implements ResponseTransformer<Void> {
    @Override
    public Void transform(Response response) {
        return null;
    }
}
