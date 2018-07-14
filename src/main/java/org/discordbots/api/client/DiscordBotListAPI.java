package org.discordbots.api.client;

import com.google.gson.Gson;
import okhttp3.OkHttpClient;
import org.discordbots.api.client.entity.*;
import org.discordbots.api.client.impl.DiscordBotListAPIImpl;

import java.util.List;
import java.util.Map;
import java.util.concurrent.Future;

public interface DiscordBotListAPI {

    Future<Void> setStats(int shardId, int shardTotal, int serverCount);
    Future<Void> setStats(List<Integer> shardServerCounts);
    Future<Void> setStats(int serverCount);

    Future<BotStats> getStats(String botId);

    Future<SimpleUser[]> getVoters(String botId);
    Future<Boolean> hasVoted(String userId);

    Future<BotResult> getBots(Map<String, Object> search, String sort, int limit, int offset, List<String> fields);
    Future<Bot> getBot(String botId);

    Future<User> getUser(String userId);

    class Builder {

        // Required
        private String botId;
        private String token;

        // Optional
        private OkHttpClient httpClient = new OkHttpClient();
        private Gson gson = new Gson();

        public Builder token(String token) {
            this.token = token;
            return this;
        }

        public Builder botId(String botId) {
            this.botId = botId;
            return this;
        }

        public Builder httpClient(OkHttpClient httpClient) {
            this.httpClient = httpClient;
            return this;
        }

        public Builder gson(Gson gson) {
            this.gson = gson;
            return this;
        }

        public DiscordBotListAPI build() {
            return new DiscordBotListAPIImpl(token, botId, gson, httpClient);
        }

    }

}
