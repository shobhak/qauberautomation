package com.qauber.pagesresource;

/**
 * Created by erikfriedlander on 12/17/16.
 */
//Config object
public class ConfigOOP {


    //Configurations, feel free to change these
    private int RUNID = 528;
    private BrowserType browserType = BrowserType.CHROME;
    private UserType userType = UserType.SAU;
    private String BASEURL = "http://testwave.qabidder.net";
    private String LOGPATH = "/log/test.txt";

    //Talk to me before changing below code, or the internet will break 0_o - Erik
    //this may be an exaggeration

    //list of valid browsers
    public enum BrowserType {
        CHROME,
        SAFARI,
        FIREFOX,
        EDGE
    }

    //What browserType is configured?
    public BrowserType getBrowserType() {
        return browserType;
    }

    public void setBrowserType(BrowserType browserType) {
        this.browserType = browserType;
    }

    //list of valid user types
    public enum UserType {
        SAU,
        AU,
        RU
    }




    public int getRunID() {
        return RUNID;
    }

    public String getBaseURL() {
        return BASEURL;
    }

    public String getLogPath() {
        return LOGPATH;
    }
}