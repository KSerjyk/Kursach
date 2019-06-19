package Controllers;

import YoutubeInformation.YoutubeChannelInformation;
import YoutubeRequest.*;
import com.google.gson.Gson;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

class TaskViewer {
    private static final String ApiKey = "AIzaSyBz_prV0e25vifnJpImJhULCkRBDn1V3HU";
    private ObservableList<YoutubeChannelInformation> channelInformations = FXCollections.observableArrayList();
    public TableView<YoutubeChannelInformation> tableView = new TableView<>();
    private List<String> channelsIDs;
    private boolean fieldComment;
    private SettingsConfig settingsConfig = SettingsConfig.getInstance();

    public TaskViewer(List<String> channelsIDs, boolean fieldComment) {
        this.channelsIDs = channelsIDs;
        this.fieldComment = fieldComment;
    }

    public void ShowForm() {
        createTable();
        if (fieldComment)
            addCommentColumn();
        try {
            getChannelsInformation(channelsIDs, fieldComment);
        } catch (Exception e) {
            e.printStackTrace();
        }
        tableView.setItems(channelInformations);
    }

    private void createTable() {
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

        TableColumn<YoutubeChannelInformation, Date> channnelName = new TableColumn<>("Ім'я");
        channnelName.setCellValueFactory(new PropertyValueFactory<YoutubeChannelInformation, Date>("name"));

        tableView.getColumns().addAll(channelId, channnelName, channnelDateCreated, channnelSubscirebrsCount, channnelVideosCount, channnelViewsCount);
    }

    private void addCommentColumn() {
        TableColumn<YoutubeChannelInformation, Date> channnelCommentsCount = new TableColumn<>("Кількість коментарів");
        channnelCommentsCount.setCellValueFactory(new PropertyValueFactory<YoutubeChannelInformation, Date>("commentCount"));
        tableView.getColumns().add(channnelCommentsCount);
    }

    private void getChannelsInformation(List<String> channelIds, boolean comments) throws Exception {
        String url = "https://www.googleapis.com/youtube/v3/channels";
        for (String id :
                channelIds) {
            if (settingsConfig.isSaveCache()) {
                if (new File(settingsConfig.getPath() + '\\' + id + ".txt").exists()) {
                    String json = SaveLoadCache.loadCache(settingsConfig.getPath() + '\\' + id + ".txt");
                    YoutubeChannelInformation information = new Gson().fromJson(json, YoutubeChannelInformation.class);
                    channelInformations.add(information);
                    if (comments)
                        if (!information.isGetComments())
                            getChannelVideos(information.getChannelId());
                }
                else{
                    HttpResponse<String> response = Unirest.get(url)
                            .queryString("key", ApiKey)
                            .queryString("part", "snippet, statistics")
                            .queryString("id", id)
                            .asString();
                    Response response1 = new Gson().fromJson(response.getBody(), Response.class);
                    convertResponseClass(response1);
                    if (comments) {
                        getChannelVideos(id);
                    }
                }
            } else {
                HttpResponse<String> response = Unirest.get(url)
                        .queryString("key", ApiKey)
                        .queryString("part", "snippet, statistics")
                        .queryString("id", id)
                        .asString();
                Response response1 = new Gson().fromJson(response.getBody(), Response.class);
                convertResponseClass(response1);
                if (comments) {
                    getChannelVideos(id);
                }
            }
        }
    }

    private void getChannelVideos(String channelId) throws UnirestException {
        ResponseForSearch response1;
        String pageToken = "";
        List<String> videoIds = new ArrayList<>();
        do {
            String url = "https://www.googleapis.com/youtube/v3/search";
            HttpResponse<String> response = Unirest.get(url)
                    .queryString("part", "snippet")
                    .queryString("key", ApiKey)
                    .queryString("channelId", channelId)
                    .queryString("pageToken", pageToken)
                    .queryString("maxResults", 50)
                    .queryString("order", "date")
                    .asString();
            response1 = new Gson().fromJson(response.getBody(), ResponseForSearch.class);
            //System.out.println(response1);
            try {
                for (ResponseItemSearch item :
                        response1.getItems()) {
                    if (item != null)
                        videoIds.add(item.id.getVideoId());
                    else {
                        System.out.println("ItemIsNull");
                    }
                }
            } catch (Exception e) {
            }
            pageToken = response1.getNextPageToken();
        } while (response1.getItems().length != 0);
        YoutubeChannelInformation information = channelInformations.get(channelInformations.size() - 1);
        information.setCommentCount(getCommentCount(videoIds));
        information.setGetComments(true);
        if (settingsConfig.isSaveCache())
            SaveLoadCache.saveCache(settingsConfig.getPath() + '\\' + information.getChannelId() + ".txt", new Gson().toJson(information));
    }

    private void convertResponseClass(Response r) {
        YoutubeChannelInformation channelInformation = new YoutubeChannelInformation();
        channelInformation.setChannelId(r.getItems()[0].id);
        channelInformation.setDateCreated(r.getItems()[0].getSnippet().publishedAt);
        channelInformation.setSubscribersCount(r.getItems()[0].getStatistics().getSubscriberCount());
        channelInformation.setVideosCount(r.getItems()[0].getStatistics().getVideoCount());
        channelInformation.setViewCount(r.getItems()[0].getStatistics().getViewCount());
        channelInformation.setName(r.getItems()[0].getSnippet().title);
        channelInformations.add(channelInformation);
        if (SettingsConfig.getInstance().isSaveCache()) {
            SaveLoadCache.saveCache(SettingsConfig.getInstance().getPath() + '\\' + channelInformation.getChannelId() + ".txt", new Gson().toJson(channelInformation));
        }
    }

    private Long getCommentCount(List<String> videoIds) throws UnirestException {
        String url = "https://www.googleapis.com/youtube/v3/videos";
        Long comments = 0L;
        for (String videoId :
                videoIds) {
            HttpResponse<String> response = Unirest.get(url)
                    .queryString("key", ApiKey)
                    .queryString("part", "statistics")
                    .queryString("id", videoId)
                    .asString();
            Response r = new Gson().fromJson(response.getBody(), Response.class);
            try {
                comments += r.getItems()[0].getStatistics().getCommentCount();
                System.out.println(r.getItems()[0].getStatistics().getCommentCount());
            } catch (Exception e) {
                //System.out.println(e.getMessage());
            }
        }
        System.out.println("Total comments: " + comments);
        return comments;
    }
}
