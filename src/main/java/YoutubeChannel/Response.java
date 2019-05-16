package YoutubeChannel;

public class Response {
    private ResponseItem[] items;

    @Override
    public String toString() {
        String str = "";
        for (ResponseItem item:
             items) {
            str += item + "\n";
        }
        return str;
    }
}
