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
public class DownloadReportAsPDF extends PageObjectModelResources {

    private static String downloadPath = FileManager.getDownloadPath();
    private int sleepTime;

    @BeforeClass
    public void setUp() {
        setUpWithConfigFile();
        setUpUser(User.UserType.SAU);
        sleepTime = testConfig().getSleepTime();
        testConfig().getTestRail().setCaseID(82777);
        testConfig().getTestRail().setTester("Alya");
        setUpScript();
    }

    @Test
    public void downloadReport() throws InterruptedException {
        int rowindex = 1;

        testDriver().get(testConfig().getBaseURL());
        Thread.sleep(sleepTime*2);
        getLogin().loginToWave(testUser().getUsername(), testUser().getPassword());
        Thread.sleep(sleepTime);
        getNavBar().reportsButton().click();
        getReports().publishedOnCheckBox().click();
        Thread.sleep(sleepTime/2);
        getPreconditions().getReportPreconditions().ensureReportsAtLeast(1);
        Thread.sleep(sleepTime/2);
        getReports().selectReport(rowindex).click();
        Thread.sleep(sleepTime/2);

        String viewReportID = getReportsViewReport().reportID().getText();
        String fileName = downloadPath + "interview_report_" + viewReportID + ".pdf";
        System.out.println("FilePath: " + fileName);
        deleteFile(fileName);

        getReportsViewReport().downloadAsPDFButton().click();
        Thread.sleep(sleepTime);

        AssertUber.assertTrue(isFileDownloaded(fileName), "Failed to download Expected document");

        testConfig().getTestRail().addResults(TestRail.TestCaseResult.PASSED, "Test passed");
    }

    public boolean isFileDownloaded(String fileName) {
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




