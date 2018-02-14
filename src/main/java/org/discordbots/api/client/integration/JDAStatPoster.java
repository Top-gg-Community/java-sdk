package org.discordbots.api.client.integration;

import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.events.guild.GuildJoinEvent;
import net.dv8tion.jda.core.events.guild.GuildLeaveEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;
import org.discordbots.api.client.DiscordBotListAPI;

import java.time.OffsetDateTime;
import java.time.temporal.ChronoUnit;

public class JDAStatPoster extends ListenerAdapter {

    private DiscordBotListAPI api;

    public JDAStatPoster(DiscordBotListAPI api) {
        this.api = api;
    }

    @Override
    public void onGuildJoin(GuildJoinEvent event) {
        OffsetDateTime joinDate = event.getGuild().getSelfMember().getJoinDate();
        OffsetDateTime current = OffsetDateTime.now();

        long difference = joinDate.until(current, ChronoUnit.MINUTES);

        if(difference < 20)
            updateStats(event.getJDA());
    }

    @Override
    public void onGuildLeave(GuildLeaveEvent event) {
        updateStats(event.getJDA());
    }

    private void updateStats(JDA jda) {
        String selfId = jda.getSelfUser().getId();
        int serverCount = jda.getGuilds().size();
        api.setStats(selfId, serverCount);
    }

}
