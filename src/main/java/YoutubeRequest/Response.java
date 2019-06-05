package YoutubeRequest;

public class Response {
    private String nextPageToken;
    private PageInfo pageInfo;
    private ResponseItem[] items;

    public String getNextPageToken() {
        return nextPageToken;
    }

    public PageInfo getPageInfo() {
        return pageInfo;
    }

    public ResponseItem[] getItems() {
        return items;
    }

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
