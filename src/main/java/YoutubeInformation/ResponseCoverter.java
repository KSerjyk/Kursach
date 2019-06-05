package YoutubeInformation;

import YoutubeRequest.Response;
import YoutubeRequest.ResponseItem;

public class ResponseCoverter {
    public static YoutubeChannelInformation FromResponseClassToObject(Response response){
        YoutubeChannelInformation channelInformation = new YoutubeChannelInformation();
        for (ResponseItem item:
             response.getItems()) {
        }
        return  channelInformation;
    }
}
