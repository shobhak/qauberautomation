package com.qauber.config;

//import com.qauber.testrail.APIClientExtension;
import org.apache.logging.log4j.LogManager;

/**
 * Created by erikfriedlander on 11/29/16.
 */
public class Config {

    private final static int RUNID = 528;
    private final static String BASEURL = "http://testwave.qabidder.net";
    private final static String LOG = "/log/test.txt";
    private final static String BROWSER = "Chrome";

    public static int getRunID() {
        return RUNID;
    }

    public static String getBaseURL() { return BASEURL; }

    public static String getBrowser() {
        return BROWSER;
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
