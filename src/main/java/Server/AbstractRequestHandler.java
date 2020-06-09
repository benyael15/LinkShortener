package Server;

import Enums.Application;
import LinkData.LinkCache;
import LinkData.Visit;
import eu.bitwalker.useragentutils.UserAgent;

public abstract  class AbstractRequestHandler {
    public static LinkCache linkCache;

    public static void setUp(){
        linkCache = LinkCache.getCacheInstance();
    }

    public static String visitOldUrl(String clientUrl, UserAgent userAgent){
        // add a visit
        System.out.println("userAgent ---- " +userAgent.toString());

        Visit visit = new Visit(clientUrl, userAgent.getOperatingSystem() , userAgent.getBrowser(),
                Application.Mobile);
        linkCache.addNewVisit(visit);

        // return the original url
        return linkCache.getOriginalUrl(clientUrl);
    }
}
