package YoutubeRequest;

public class Snippet {
    String title;
    String description;
    String customUrl;
    String publishedAt;

    @Override
    public String toString() {
        return "snippet:\n"+
                "\ttitle: " + title + '\n' +
                "\tdescription: " + description + '\n' +
                "\tcustomUrl: " + customUrl + '\n' +
                "\tpublishedAt: " + publishedAt;
    }
}
