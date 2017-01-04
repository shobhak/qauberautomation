package com.qauber.sanity;

import com.qauber.pagesresource.PageObjectModelResources;
import com.qauber.pagesresource.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;
import java.util.List;

/**
 * Created by Alya on 12/20/2016.
 */
public class ExportReportsListAsPDF extends PageObjectModelResources{

    private static String downloadPath = "C:/Users/Alya/Downloads";

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

        List<WebElement> searchResults = getDriver().findElements(By.cssSelector(".btn.btn-info.btn-sm.ng-scope"));
        //while (searchResults
        Thread.sleep(1000);
        System.out.println(searchResults.size());
        //WebElement searchResults = exportReportsList.get(exportReportsList.size());

        //String fileName = downloadPath + "/search_results" + .pdf";

        //WebElement exportReportsListButton = searchResults;
        //deleteFile(fileName);

        getReports().exportReportsListButton().click();

        //Assert.assertTrue(isFileExported(fileName), "Failed to export Expected document");
        Thread.sleep(5000);
    }

    /*public boolean isFileExported(String fileName) {
        File file = new File(fileName);
        return file.isFile();
    }

    public void deleteFile(String fileName){
        File file = new File(fileName);
        file.delete();
    }*/
    @AfterClass
    public void breakDown() {
        breakDownHelper();
    }
}
