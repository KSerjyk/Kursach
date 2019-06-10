import Controllers.SaveLoadCache;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    private static final String ApiKey="AIzaSyAINCiahYJ9DOkX5heKnPYtJyoVm8oqdPc";
    public static void main(String[] args) throws Exception{
        //channel request
       /* String url="https://www.googleapis.com/youtube/v3/channels";
        HttpResponse<String> response = Unirest.get(url)
                .queryString("key", ApiKey)
                .queryString("part", "snippet, statistics")
                .queryString("id","UCf31Gf5nCU8J6eUlr7QSU0w")
                .asString();
        //System.out.println(response.getBody());
        Response response1 = new Gson().fromJson(response.getBody(), Response.class);
        System.out.println(response1);*/
        //videos search
       /*String url="https://www.googleapis.com/youtube/v3/search";
        HttpResponse<String> response =Unirest.get(url)
                .queryString("part", "snippet")
                .queryString("key", ApiKey)
                .queryString("channelId", "UCf31Gf5nCU8J6eUlr7QSU0w")
                .queryString("pageToken", "")
                .queryString("maxResults",50)
                .queryString("order", "date")
                .asString();
        //System.out.println(response.getBody());
        Response response1 = new Gson().fromJson(response.getBody(), Response.class);
        System.out.println(response1);*/
        // get videos comments
        //String url="https://www.googleapis.com/youtube/v3/videos";
       /* HttpResponse<String> response = Unirest.get(url)
                .queryString("key", ApiKey)
                .queryString("part", "statistics")
                .queryString("id", "")
                .asString();
          System.out.println(response.getBody());*/
        SaveLoadCache.LoadSaveSettingsConfig(false);
        Runtime.getRuntime().addShutdownHook(new Thread() {
            public void run() {
                SaveLoadCache.LoadSaveSettingsConfig(true);
            }
        });
       launch(args);
    }


    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("/MainMenuFXML.fxml"));
        primaryStage.setTitle("Youtube Analitics");
        primaryStage.setScene(new Scene(root, 400, 400));
        primaryStage.setResizable(false);
        primaryStage.show();
    }
}
