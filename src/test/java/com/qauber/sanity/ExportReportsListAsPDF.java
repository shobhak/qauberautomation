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
public class ExportReportsListAsPDF extends PageObjectModelResources{

    private static String downloadPath = FileManager.getDownloadPath();

    @BeforeClass
    public void setUp() {
        setUpWithConfigFile();
        setUpUser(User.UserType.SAU);
        setUpScript();
    }

    @Test
    public void ExportReportsList() throws InterruptedException {
        testDriver().get(testConfig().getBaseURL());
        Thread.sleep(10000);
        getLogin().loginToWave(testUser().getUsername(), testUser().getPassword());
        Thread.sleep(5000);
        getReports().clickPublishedOnCheckbox();
        Thread.sleep(2000);

        String fileName = downloadPath + "/search_result.pdf";
        deleteFile(fileName);

        getReports().exportReportsListButton().click();
        Thread.sleep(2000);

        Assert.assertTrue(isFileExported(fileName), "Failed to export Expected document");
        Thread.sleep(5000);
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
