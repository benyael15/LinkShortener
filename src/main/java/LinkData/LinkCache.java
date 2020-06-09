package LinkData;

import java.util.*;

public class LinkCache {

    private static LinkCache cacheInstance;

    private Map<String, List<Visit>> historyVisits;
    private Map<String, String> shortUrlMap;

    private LinkCache() {
        historyVisits = new HashMap<>();
        shortUrlMap = new HashMap<>();
    }

    public static LinkCache getCacheInstance(){
        if(cacheInstance == null){
            cacheInstance = new LinkCache();
        }
        return cacheInstance;
    }

    public void addNewVisit(Visit visit){
        if(this.historyVisits.get(visit.getLinkID()) == null){
            List<Visit> newArrayList = new ArrayList();
            this.historyVisits.put(visit.getLinkID(), newArrayList);
        }
        this.historyVisits.get(visit.getLinkID()).add(visit);
    }

    public void addNewUrl(String shortKey, String originalUrl){
        if(this.shortUrlMap.get(shortKey) == null){
            this.shortUrlMap.put(shortKey, originalUrl);
        }
    }

    public String getKeyByUrl(String clientUrl){
        final String[] finalkey = {null};
        this.shortUrlMap.forEach((key, val) -> {
            if(val.equals(clientUrl)){
                finalkey[0] = key;
            }
        });
        return finalkey[0];
    }

    public String getOriginalUrl(String shortKey){
        if(this.shortUrlMap.keySet().contains(
                String.valueOf(shortKey))){
            return this.shortUrlMap.get(shortKey);
        }
        return null;
    }

    public boolean checkIfUrlExist(String originalUrl){
        return this.shortUrlMap.values().contains(originalUrl) || this.shortUrlMap.keySet().contains(originalUrl);
    }
}
