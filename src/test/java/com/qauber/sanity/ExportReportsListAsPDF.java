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
 * TODO: add TestRail integration
 * TODO: precondition? check for condition before download?
 * (note from Erik) If you face saving-file challenges in the future, look at this:
 * http://ardesco.lazerycode.com/index.php/2012/07/how-to-download-files-with-selenium-and-why-you-shouldnt/
 */
public class ExportReportsListAsPDF extends PageObjectModelResources{

    int sleepTime;
    private static String downloadPath = FileManager.getDownloadPath();

    @BeforeClass
    public void setUp() {
        setUpWithConfigFile();
        setUpUser(User.UserType.SAU);
        sleepTime = testConfig().getSleepTime();
        setUpScript();
    }

    @Test
    public void ExportReportsList() throws InterruptedException {
        testDriver().get(testConfig().getBaseURL());
        Thread.sleep(sleepTime*2);
        getLogin().loginToWave(testUser().getUsername(), testUser().getPassword());
        Thread.sleep(sleepTime);
        getReports().publishedOnCheckBox().click();
        Thread.sleep(sleepTime/2);

        String fileName = downloadPath + "/search_result.pdf";
        deleteFile(fileName);

        getReports().exportReportsListButton().click();
        Thread.sleep(sleepTime/2);

        Assert.assertTrue(isFileExported(fileName), "Failed to export Expected document");
        Thread.sleep(sleepTime);
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
