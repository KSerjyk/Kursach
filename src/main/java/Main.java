import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;

public class Main {
    public static final String ApiKey="AIzaSyAINCiahYJ9DOkX5heKnPYtJyoVm8oqdPc";
    public static void main(String[] args) throws Exception{
        String url="https://www.googleapis.com/youtube/v3/search";
        HttpResponse<String> response = Unirest.get(url)
                .queryString("key", ApiKey)
                .queryString("part", "snippet")
                .queryString("maxResults",1)
                .queryString("q","UCf31Gf5nCU8J6eUlr7QSU0w")
                .asString();
        System.out.println(response.getBody());
    }
}
