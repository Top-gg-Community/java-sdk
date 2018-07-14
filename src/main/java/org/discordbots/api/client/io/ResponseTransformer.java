package org.discordbots.api.client.io;

import okhttp3.Response;

public interface ResponseTransformer<E> {

    E transform(Response response) throws Exception;

}
