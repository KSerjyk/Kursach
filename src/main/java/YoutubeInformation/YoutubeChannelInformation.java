package YoutubeInformation;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class YoutubeChannelInformation {
    private String channelId;
    private Date dateCreated;
    private Long subscribersCount;
    private Integer videosCount;
    private Long viewCount;
    private Long commentCount;

    public String getChannelId() {
        return channelId;
    }

    public void setChannelId(String channelId) {
        this.channelId = channelId;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(String dateCreated) {
        try {
            this.dateCreated = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss").parse(dateCreated);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public Long getSubscribersCount() {
        return subscribersCount;
    }

    public void setSubscribersCount(Long subscribersCount) {
        this.subscribersCount = subscribersCount;
    }

    public Integer getVideosCount() {
        return videosCount;
    }

    public void setVideosCount(Integer videosCount) {
        this.videosCount = videosCount;
    }

    public Long getViewCount() {
        return viewCount;
    }

    public void setViewCount(Long viewCount) {
        this.viewCount = viewCount;
    }

    public Long getCommentCount() {
        return commentCount;
    }

    public void setCommentCount(Long commentCount) {
        this.commentCount = commentCount;
    }
}
