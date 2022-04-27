package org.discordbots.api.client;

import org.discordbots.api.client.entity.*;
import org.discordbots.api.client.impl.DiscordBotListAPIImpl;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.CompletionStage;

public interface DiscordBotListAPI {

    CompletionStage<Void> setStats(int shardId, int shardTotal, int serverCount);
    CompletionStage<Void> setStats(List<Integer> shardServerCounts);

    /**
     * Sets the server count for your bot to display publicly.
     * Provide a gap between calls or your API usage may be restricted
     * @param serverCount the amount of servers your bot is in
     */
    CompletionStage<Void> setStats(int serverCount);

    CompletionStage<BotStats> getStats();

    /**
     * If you have more than 1000 votes every month, <b>do not use this method</b>
     * @return a list of users who have voted for the bot in the past 24 hours.
     */
    CompletionStage<List<SimpleUser>> getVoters();

    /**
     * checks if a user has voted for the bot in the past 24 hours
     * @param userId the user to see if they have voted
     * @return whether the user has voted
     */
    CompletionStage<Boolean> hasVoted(String userId);

    CompletionStage<BotResult> getBots(Map<String, String> search, int limit, int offset);
    CompletionStage<BotResult> getBots(Map<String, String> search, int limit, int offset, String sort);
    CompletionStage<BotResult> getBots(Map<String, String> search, int limit, int offset, String sort, List<String> fields);

    /**
     * https://discordbots.org/api/docs#bots
     * @return a {@link Bot} object about the current bot
     */
    CompletionStage<Bot> getBot();

    /**
     * Returns information on the bot with the given ID.
     * @return a {@link Bot} object about the given <code>botId</code>
     */
    CompletionStage<Bot> getBot(String botId);

    CompletionStage<User> getUser(String userId);

    /**
     * @return the current voting multiplier.
     * Determines if it is the weekend or not.
     */
    CompletionStage<VotingMultiplier> getVotingMultiplier();

    class Builder {

        // Required
        private String botId = null;
        private String token = null;

        public Builder token(String token) {
            this.token = token;
            return this;
        }

        public Builder botId(String botId) {
            this.botId = botId;
            return this;
        }

        public DiscordBotListAPI build() {
            Objects.requireNonNull(token, "The provided token cannot be null!");
            Objects.requireNonNull(botId, "The provided bot ID cannot be null!");

            return new DiscordBotListAPIImpl(token, botId);
        }

    }

}
