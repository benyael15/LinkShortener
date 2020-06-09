package Server;

import Utilities.RandomString;
import eu.bitwalker.useragentutils.UserAgent;


public class UrlRequestHandler extends AbstractRequestHandler{

    public static int keyLength = 8;


    public static String handleNewReq(String clientUrl, UserAgent userAgent){
        // check if url is alreay a short key in the system
        if(!linkCache.checkIfUrlExist(clientUrl)){
            return generateNewUrl(clientUrl);
        }else{
            return visitOldUrl(linkCache.getKeyByUrl(clientUrl), userAgent);
        }
    }

    private static String generateNewUrl(String clientUrl){
        // generate a new key
        String urlKey = RandomString.getAlphaNumericString(keyLength);

        // check id used before
        while(linkCache.checkIfUrlExist(urlKey)){
            urlKey = RandomString.getAlphaNumericString(keyLength);
        }

        // create new short utl
        linkCache.addNewUrl(urlKey, clientUrl);
        return urlKey;
    }

}
