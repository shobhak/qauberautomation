package com.qauber.config;

import com.qauber.testrail.APIClientExtension;
import org.apache.logging.log4j.LogManager;

/**
 * Created by erikfriedlander on 11/29/16.
 */
public class Config {

    private final static int RUNID = 528;
    private final static String BASEURL = "http://testwave.qabidder.net";
    private final static String LOG = "/log/test.txt";

    public static int getRunID() {
        return RUNID;
    }

    public static String getBaseURL() { return BASEURL; }

    public static APIClientExtension testRailLogin() { //passes back a logged in client
        APIClientExtension client = new APIClientExtension("https://bidqa.testrail.net/");
        client.setUser("Testers@qauber.com");
        client.setPassword("qauber2016!");

        return client;
    }

    public static String setLogFile(String CustomLog) {
        System.setProperty("logFilename", CustomLog);

        org.apache.logging.log4j.core.LoggerContext ctx =
                (org.apache.logging.log4j.core.LoggerContext) LogManager.getContext(false);
        ctx.reconfigure();

        return CustomLog;
    }

    public static String setLogFile() {
        setLogFile(LOG);
        return LOG;
    }

    public static String getLogFile() {
        return LOG;
    }

}
