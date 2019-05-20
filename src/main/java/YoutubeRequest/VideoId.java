package YoutubeRequest;

public class VideoId {
    private String kind;
    private String videoId;

    public String getKind() {
        return kind;
    }

    public String getVideoId() {
        return videoId;
    }

    @Override
    public String toString() {
        return "id:\n" +
                "\tkind: " + kind +'\n' +
                "\tvideoId: " + videoId;
    }
}
