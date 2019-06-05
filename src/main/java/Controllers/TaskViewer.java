package Controllers;

import YoutubeInformation.YoutubeChannelInformation;
import YoutubeRequest.Response;
import com.google.gson.Gson;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.util.Date;
import java.util.List;

public class TaskViewer {
    private static final String ApiKey="AIzaSyAINCiahYJ9DOkX5heKnPYtJyoVm8oqdPc";
    private ObservableList<YoutubeChannelInformation> channelInformations = FXCollections.emptyObservableList();
    private final TableView<YoutubeChannelInformation> tableView = new TableView<>();

    public void ShowForm(Stage ownerStage, List<String> channelsIDs, boolean fieldComment){
        createTable();
        if(fieldComment)
            addCommentColumn();
        try {
            getChannelsInformation();
        } catch (Exception e) {
            e.printStackTrace();
        }
        //channelInformations.addAll(channelsIDs);
        tableView.setItems(channelInformations);

        StackPane root = new StackPane();
        root.getChildren().add(tableView);
        Stage secondaryStage = new Stage();
        secondaryStage.initOwner(ownerStage);
        secondaryStage.setTitle("Information");
        Scene scene = new Scene(root,450, 450);
        secondaryStage.setScene(scene);
        secondaryStage.show();
    }

    private  void createTable(){
        TableColumn<YoutubeChannelInformation, String> channelId = new TableColumn<>("ID каналу");
        channelId.setCellValueFactory(new PropertyValueFactory<YoutubeChannelInformation, String>("channelId"));

        TableColumn<YoutubeChannelInformation, Date> channnelDateCreated = new TableColumn<>("Дата створення");
        channnelDateCreated.setCellValueFactory(new PropertyValueFactory<YoutubeChannelInformation, Date>("dateCreated"));

        TableColumn<YoutubeChannelInformation, Date> channnelSubscirebrsCount = new TableColumn<>("Кількість підписників");
        channnelSubscirebrsCount.setCellValueFactory(new PropertyValueFactory<YoutubeChannelInformation, Date>("subscribersCount"));

        TableColumn<YoutubeChannelInformation, Date> channnelVideosCount = new TableColumn<>("Кількість відео");
        channnelVideosCount.setCellValueFactory(new PropertyValueFactory<YoutubeChannelInformation, Date>("videosCount"));

        TableColumn<YoutubeChannelInformation, Date> channnelViewsCount = new TableColumn<>("Кількість переглядів");
        channnelViewsCount.setCellValueFactory(new PropertyValueFactory<YoutubeChannelInformation, Date>("viewCount"));

        tableView.getColumns().addAll(channelId, channnelDateCreated, channnelSubscirebrsCount, channnelVideosCount, channnelViewsCount);
    }

    private void addCommentColumn(){
        TableColumn<YoutubeChannelInformation, Date> channnelCommentsCount = new TableColumn<>("Кількість коментарів");
        channnelCommentsCount.setCellValueFactory(new PropertyValueFactory<YoutubeChannelInformation, Date>("viewCount"));
        tableView.getColumns().add(channnelCommentsCount);
    }

    private void getChannelsInformation() throws Exception{
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

    private void convertResponseClass(Response r){
        YoutubeChannelInformation channelInformation = new YoutubeChannelInformation();
    }
}
