package YoutubeInformation;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class YoutubeChannelInformation {
    private String channelId;
    private String name;
    private Date dateCreated;
    private Long subscribersCount;
    private Long videosCount;
    private Long viewCount;
    private Long commentCount;
    private boolean getComments;

    public boolean isGetComments() {
        return getComments;
    }

    public void setGetComments(boolean getComments) {
        this.getComments = getComments;
    }

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
            this.dateCreated = new SimpleDateFormat("yyyy-MM-dd'T'hh:mm:ss.'000Z'").parse(dateCreated);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getSubscribersCount() {
        return subscribersCount;
    }

    public void setSubscribersCount(Long subscribersCount) {
        this.subscribersCount = subscribersCount;
    }

    public Long getVideosCount() {
        return videosCount;
    }

    public void setVideosCount(Long videosCount) {
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
