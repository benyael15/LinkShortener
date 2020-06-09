package Server;

import LinkData.LinkCache;
import eu.bitwalker.useragentutils.UserAgent;

public class StaticticRequestHandler extends AbstractRequestHandler{
    public static String handleStatisticReq(String clientUrl, UserAgent userAgent){
        // check if url is alreay a short key in the system
        if(linkCache.checkIfUrlExist(clientUrl)){
            return visitOldUrl(linkCache.getKeyByUrl(clientUrl), userAgent);
        }
        return "";
    }
}
