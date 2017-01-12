package com.qauber.assertutil;

import com.qauber.pagesresource.ConfigHelper;
import com.qauber.pagesresource.ConfigOOP;
import com.qauber.pagesresource.TestRail;
import org.testng.Assert;

/**
 * Created by Alya on 1/11/2017.
 */
public class AssertUber {
    private static ConfigOOP config = ConfigHelper.getConfigFile();

    public static void assertTrue(boolean conditions, String message){
        try {
            Assert.assertTrue(conditions, message);
        } catch (AssertionError e) {
            config.getTestRail().addResults(TestRail.TestCaseResult.FAILED, message);
            throw e;
        }
    }
}
