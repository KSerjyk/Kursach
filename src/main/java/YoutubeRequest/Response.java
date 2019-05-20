package YoutubeRequest;

public class Response {
    private String nextPageToken;
    private PageInfo pageInfo;
    private ResponseItem[] items;

    @Override
    public String toString() {
        String str = "nextPageToken: " + nextPageToken + '\n' + pageInfo +'\n';
        for (ResponseItem item:
             items) {
            str += item + "\n";
        }
        return str;
    }
}
