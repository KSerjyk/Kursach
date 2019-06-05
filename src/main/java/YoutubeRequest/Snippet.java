package YoutubeRequest;

public class Snippet {
    public String title;
    public String description;
    public String customUrl;
    public String publishedAt;

    @Override
    public String toString() {
        return "snippet:\n"+
                "\ttitle: " + title + '\n' +
                "\tdescription: " + description + '\n' +
                "\tcustomUrl: " + customUrl + '\n' +
                "\tpublishedAt: " + publishedAt;
    }
}
