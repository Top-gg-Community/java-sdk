package org.discordbots.api.client;

import com.google.gson.Gson;
import okhttp3.OkHttpClient;
import org.discordbots.api.client.entity.*;
import org.discordbots.api.client.impl.DiscordBotListAPIImpl;

import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletionStage;

public interface DiscordBotListAPI {

    CompletionStage<Void> setStats(int shardId, int shardTotal, int serverCount);
    CompletionStage<Void> setStats(List<Integer> shardServerCounts);
    CompletionStage<Void> setStats(int serverCount);

    CompletionStage<BotStats> getStats(String botId);

    @Deprecated
    CompletionStage<List<SimpleUser>> getVoters(String botId);
    CompletionStage<Boolean> hasVoted(String userId);

    CompletionStage<BotResult> getBots(Map<String, String> search, int limit, int offset);
    CompletionStage<BotResult> getBots(Map<String, String> search, int limit, int offset, String sort);
    CompletionStage<BotResult> getBots(Map<String, String> search, int limit, int offset, String sort, List<String> fields);
    CompletionStage<Bot> getBot(String botId);

    CompletionStage<User> getUser(String userId);

    class Builder {

        // Required
        private String botId = null;
        private String token = null;

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
            if(token == null)
                throw new IllegalArgumentException("The provided token cannot be null!");

            if(botId == null)
                throw new IllegalArgumentException("The provided bot ID cannot be null!");

            return new DiscordBotListAPIImpl(token, botId, gson, httpClient);
        }

    }

}
