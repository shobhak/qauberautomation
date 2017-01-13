package com.qauber.sanity;

import com.qauber.assertutil.AssertUber;
import com.qauber.pagesresource.FileManager;
import com.qauber.pagesresource.PageObjectModelResources;
import com.qauber.pagesresource.TestRail;
import com.qauber.pagesresource.User;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;

/**
 * Created by Alya on 12/20/2016.
 */
public class ExportReportsListAsPDF extends PageObjectModelResources{

    private static String downloadPath = FileManager.getDownloadPath();
    private int sleepTime;

    @BeforeClass
    public void setUp() {
        setUpWithConfigFile();
        setUpUser(User.UserType.SAU);
        sleepTime = testConfig().getSleepTime();
        testConfig().getTestRail().setCaseID(82779);
        testConfig().getTestRail().setTester("Alya");
        setUpScript();
    }

    @Test
    public void ExportReportsList() throws InterruptedException {
        testDriver().get(testConfig().getBaseURL());
        Thread.sleep(sleepTime*2);
        getLogin().loginToWave(testUser().getUsername(), testUser().getPassword());
        Thread.sleep(sleepTime);
        getReports().publishedOnCheckBox().click();
        getPreconditions().getReportPreconditions().ensureReportsAtLeast(1);
        Thread.sleep(sleepTime/2);

        String fileName = downloadPath + "search_result.pdf";
        deleteFile(fileName);

        getReports().exportReportsListButton().click();
        Thread.sleep(sleepTime/2);

        AssertUber.assertTrue(isFileExported(fileName), "File wasn't downloaded");

        testConfig().getTestRail().addResults(TestRail.TestCaseResult.PASSED, "Test passed");
    }

    public boolean isFileExported(String fileName) {
        File file = new File(fileName);
        return file.isFile();
    }

    public void deleteFile(String fileName){
        File file = new File(fileName);
        file.delete();
    }

    @AfterClass
    public void breakDown() {
        breakDownHelper();
    }
}
