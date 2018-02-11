package org.discordbots.api.client;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import org.discordbots.api.client.entity.*;
import org.discordbots.api.client.retrofit.GenericCallAdapterFactory;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface DiscordBotListAPI {

    String BASE_URL = "https://discordbots.org/api/";

    @GET("bots/{id}")
    Bot getBot(
            @Path("id") String id
    );

    @GET("bots")
    Result<Bot> getBots(
            @Query("limit") int limit,
            @Query("offset") int offset
    );

    @GET("bots")
    Result<Bot> getBots(
            @Query("search") String search,
            @Query("sort") String sort,
            @Query("limit") int limit,
            @Query("offset") int offset
    );

    default Result<Bot> getBots(Map<String, String> searchValues, String sort, int limit, int offset) {
        StringBuilder search = new StringBuilder();
        searchValues.forEach((String key, String value) -> {
            search.append(key);
            search.append(" ");
            search.append(value);
            search.append(" ");
        });
        return getBots(search.toString(), sort, limit, offset);
    }

    @GET("bots/{id}/stats")
    BotStats getBotStats(
            @Path("id") String botId
    );

    @GET("bots/{id}/votes")
    SimpleUser getVoters(
            @Path("id") String botId
    );

    @GET("bots/{id}/votes")
    SimpleUser getVoters(
            @Path("id") String botId,
            @Query("days") int days
    );

    @GET("bots/{id}/votes?onlyids=true")
    List<String> getVoterIds(
            @Path("id") String botId
    );

    @GET("bots/{id}/votes?onlyids=true")
    List<String> getVoterIds(
            @Path("id") String botId,
            @Query("days") int days
    );

    @GET("users/{id}")
    User getUser(
            @Path("id") String userId
    );

    // Uses Void instead of void because Retrofit doesn't like void
    @POST("bots/{id}/stats")
    Void setStats(
            @Path("id") String botId,
            @Body Map<String, Object> body
    );

    default void setStats(String botId, int serverCount) {
        Map<String, Object> body = new HashMap<>();
        body.put("server_count", serverCount);

        setStats(botId, body);
    }

    default void setStats(String botId, int serverCount, int shardId, int shardCount) {
        Map<String, Object> body = new HashMap<>();
        body.put("server_count", serverCount);
        body.put("shard_id", shardId);
        body.put("shard_count", shardCount);

        setStats(botId, body);
    }

    default void setStats(String botId, List<Integer> shardServerCounts) {
        Map<String, Object> body = new HashMap<>();
        body.put("shards", shardServerCounts);

        setStats(botId, body);
    }


    class Builder {

        private String token = null;

        public Builder token(String token) {
            this.token = token;
            return this;
        }

        public DiscordBotListAPI build() {
            OkHttpClient.Builder httpClient = new OkHttpClient.Builder();

            // Adds the auth header + content type to all requests
            httpClient.addInterceptor((Interceptor.Chain chain) -> {
                Request request = chain.request().newBuilder()
                                                 .addHeader("Authorization", token)
                                                 .addHeader("Content-Type", "application/json")
                                                 .build();
                return chain.proceed(request);
            });

            Retrofit retrofit = new Retrofit.Builder().baseUrl(BASE_URL)
                                                      .addCallAdapterFactory(GenericCallAdapterFactory.create())
                                                      .addConverterFactory(GsonConverterFactory.create())
                                                      .client(httpClient.build())
                                                      .build();

            return retrofit.create(DiscordBotListAPI.class);
        }

    }

}
