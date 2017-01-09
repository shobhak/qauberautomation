package com.qauber.sanity;

import com.qauber.pagesresource.FileManager;
import com.qauber.pagesresource.PageObjectModelResources;
import com.qauber.pagesresource.User;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.io.File;

/**
 * Created by Alya on 12/20/2016.
 */
public class DownloadReportAsPDF extends PageObjectModelResources {

    private static String downloadPath = FileManager.getDownloadPath();

    @BeforeClass
    public void setUp() {
        setUpWithConfigFile();
        setUpUser(User.UserType.SAU);
        setUpScript();
    }

    @Test
    public void downloadReport() throws InterruptedException {
        int rowindex = 1;

        testDriver().get(testConfig().getBaseURL());
        Thread.sleep(10000);
        getLogin().loginToWave(testUser().getUsername(), testUser().getPassword());
        Thread.sleep(5000);
        getNavBar().reportsButton().click();
        getReports().publishedOnCheckBox().click();
        Thread.sleep(2000);
        getReports().selectReport(rowindex).click();
        Thread.sleep(2000);

        String viewReportID = getReportsViewReport().reportID().getText();
        String fileName = downloadPath + "/interview_report_" + viewReportID + ".pdf";
        deleteFile(fileName);

        getReportsViewReport().downloadAsPDFButton().click();
        Thread.sleep(5000);

        Assert.assertTrue(isFileDownloaded(fileName), "Failed to download Expected document");
        Thread.sleep(5000);
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




