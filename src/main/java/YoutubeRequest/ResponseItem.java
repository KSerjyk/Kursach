package YoutubeRequest;

public class ResponseItem {
    private VideoId id;
    private ChannelStatistic statistics;
    private Snippet snippet;

    @Override
    public String toString() {
        return id + "\n" + statistics + '\n' + snippet;
    }
}
