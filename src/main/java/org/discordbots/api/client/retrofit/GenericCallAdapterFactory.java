package org.discordbots.api.client.retrofit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import retrofit2.Call;
import retrofit2.CallAdapter;
import retrofit2.Retrofit;

import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

/*
 The entire point of this class is to automatically execute the requests when you call the methods.
  */
public class GenericCallAdapterFactory extends CallAdapter.Factory {

    private static final Logger logger = LoggerFactory.getLogger(GenericCallAdapterFactory.class);

    public static GenericCallAdapterFactory create() {
        return new GenericCallAdapterFactory();
    }

    @Override
    public CallAdapter<?, ?> get(Type returnType, Annotation[] annotations, Retrofit retrofit) {
        return new CallAdapter<Object, Object>() {
            @Override
            public Type responseType() {
                return returnType;
            }

            @Override
            public Object adapt(Call<Object> call) {
                try {
                    return call.execute().body();
                } catch (Exception e) {
                    logger.error("Error while executing request to " + call.request().url());
                    return null;
                }
            }
        };
    }

}
