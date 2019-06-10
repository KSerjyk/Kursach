package YoutubeRequest;

public class ResponseForSearch {
    private String nextPageToken;
    private PageInfo pageInfo;
    private ResponseItemSearch[] items;

    public String getNextPageToken() {
        return nextPageToken;
    }

    public PageInfo getPageInfo() {
        return pageInfo;
    }

    public ResponseItemSearch[] getItems() {
        return items;
    }

    @Override
    public String toString() {
        String str = "nextPageToken: " + nextPageToken + '\n' + pageInfo +'\n';
        for (ResponseItemSearch item:
             items) {
            str += item + "\n";
        }
        return str;
    }
}
