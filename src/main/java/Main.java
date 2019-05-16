import YoutubeChannel.ChannelStatistic;
import YoutubeChannel.Response;
import com.google.gson.Gson;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;

public class Main {
    private static final String ApiKey="AIzaSyAINCiahYJ9DOkX5heKnPYtJyoVm8oqdPc";
    public static void main(String[] args) throws Exception{
        String url="https://www.googleapis.com/youtube/v3/channels";
        HttpResponse<String> response = Unirest.get(url)
                .queryString("key", ApiKey)
                .queryString("part", "snippet, statistics")
                .queryString("id","UCf31Gf5nCU8J6eUlr7QSU0w")
                .asString();
        //System.out.println(response.getBody());
        Response response1 = new Gson().fromJson(response.getBody(), Response.class);
        System.out.println(response1);
    }
}
