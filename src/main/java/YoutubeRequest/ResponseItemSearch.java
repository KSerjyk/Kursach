package YoutubeRequest;

public class ResponseItemSearch {
    public VideoId id;
    private ChannelStatistic statistics;
    private Snippet snippet;
   /* public VideoId getId() {
        return id;
    }*/

    public ChannelStatistic getStatistics() {
        return statistics;
    }

    public Snippet getSnippet() {
        return snippet;
    }

    @Override
    public String toString() {
        return id + "\n" + statistics + '\n' + snippet;
    }
}
