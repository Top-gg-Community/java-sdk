package org.discordbots.api.client.retrofit;

import retrofit2.Call;
import retrofit2.CallAdapter;
import retrofit2.Retrofit;

import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

/*
 The entire point of this class is to automatically execute the requests when you call the methods.
  */
public class GenericCallAdapterFactory extends CallAdapter.Factory {

    public static GenericCallAdapterFactory create() {
        return new GenericCallAdapterFactory();
    }

    @Override
    public CallAdapter<?, ?> get(Type returnType, Annotation[] annotations, Retrofit retrofit) {
        if (returnType instanceof okhttp3.Call) {
            return null;
        }

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
                    e.printStackTrace();
                    return null;
                }
            }
        };
    }

}
