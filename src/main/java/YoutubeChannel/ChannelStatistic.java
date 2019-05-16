package YoutubeChannel;

public class ChannelStatistic {
    private Long viewCount;
    private Long commentCount;
    private Long subscriberCount;
    private boolean hiddenSubscriberCount;
    private Long videoCount;

    public Long getViewCount() {
        return viewCount;
    }

    public Long getCommentCount() {
        return commentCount;
    }

    public Long getSubscriberCount() {
        return subscriberCount;
    }

    public boolean isHiddenSubscriberCount() {
        return hiddenSubscriberCount;
    }

    public Long getVideoCount() {
        return videoCount;
    }

    @Override
    public String toString() {
        return "Statistic:\n" +
                "\tviewCount: " + viewCount + '\n' +
                "\tcommentCount: " + commentCount + '\n' +
                "\tsubscriberCount: " + subscriberCount + '\n' +
                "\thiddenSubscriberCount: " + hiddenSubscriberCount + '\n' +
                "\tvideoCount: " + videoCount;
    }
}
