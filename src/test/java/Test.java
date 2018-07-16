import org.discordbots.api.client.DiscordBotListAPI;

public class Test {

    public static void main(String[] args) throws Exception {

        var api = new DiscordBotListAPI.Builder()
                .token("eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpZCI6IjIzNDM4ODUzNjM4MjU4Njg4MyIsImJvdCI6dHJ1ZSwiaWF0IjoxNTE3NjkyMTc4fQ.RZCV-AiGO0qS6B4vn9WiPYPC8LVh_s_Z-iy6xgZEH3U")
                .botId("234388536382586883")
                .build();

        api.setStats(4_000).whenComplete((v, e) -> {
            System.out.println("done");
            if(e != null)
                e.printStackTrace();

        });

    }

}
