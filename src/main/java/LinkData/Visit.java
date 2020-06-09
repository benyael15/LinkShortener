package LinkData;

import Enums.Application;
import eu.bitwalker.useragentutils.Browser;
import eu.bitwalker.useragentutils.OperatingSystem;

public class Visit {
    private String LinkID;
    private OperatingSystem operationSystem;
    private Browser browserType;
    private Application applicationType;

    public Visit(String linkID, OperatingSystem operationSystem, Browser browserType, Application applicationType) {
        LinkID = linkID;
        this.operationSystem = operationSystem;
        this.browserType = browserType;
        this.applicationType = applicationType;
    }

    public String getLinkID() {
        return LinkID;
    }

    public void setLinkID(String linkID) {
        LinkID = linkID;
    }

    public OperatingSystem getOperationSystem() {
        return operationSystem;
    }

    public void setOperationSystem(OperatingSystem operationSystem) {
        this.operationSystem = operationSystem;
    }

    public Browser getBrowserType() {
        return browserType;
    }

    public void setBrowserType(Browser browserType) {
        this.browserType = browserType;
    }

    public Application getApplicationType() {
        return applicationType;
    }

    public void setApplicationType(Application applicationType) {
        this.applicationType = applicationType;
    }
}
