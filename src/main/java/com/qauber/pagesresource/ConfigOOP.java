package com.qauber.pagesresource;

/**
 * Created by erikfriedlander on 12/17/16.
 */
//Config object
public class ConfigOOP {


    private TestRail testRail;
    private BrowserType browserType;

    private String baseURL;
    private String logPath;
    private int sleepTime;

    public ConfigOOP(){ //Default config
        browserType = BrowserType.CHROME;
        baseURL = "http://testwave.qabidder.net";
        logPath = "log/defaultlog.txt";
        testRail = new TestRail();
        testRail.setTester("Default Tester");
        sleepTime = 5000; //TODO: add config for this
    }

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

    public void setBrowserType(BrowserType browserType) { //make sure to return the driver (getDriver) if you use this!
        this.browserType = browserType;
    }

    public String getBaseURL() {
        return baseURL;
    }

    public void setBaseURL(String baseURL) {
        this.baseURL = baseURL;
    }

    public String getLogPath() {
        return logPath;
    }

    public int getSleepTime() {
        return sleepTime;
    }

    public void setSleepTime(int sleepTime) {
        this.sleepTime = sleepTime;
    }

    public TestRail getTestRail() {
        return testRail;
    }

    public void setTestRail(TestRail testRail) {
        this.testRail = testRail;
    }

    public void setLogPath(String logPath) {
        this.logPath = logPath;
    }
}