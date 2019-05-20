package YoutubeRequest;

public class PageInfo {
    Integer totalResults;
    Integer resultsPerPage;

    @Override
    public String toString() {
        return "pageInfo:\n" +
                "\ttotalResults: " + totalResults + '\n' +
                "\tresultsPerPage: " + resultsPerPage;
    }
}
