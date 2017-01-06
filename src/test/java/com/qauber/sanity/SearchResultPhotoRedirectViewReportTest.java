package com.qauber.sanity;

import com.qauber.config.Config;
import com.qauber.pagesresource.PageObjectModelResources;
import com.qauber.pagesresource.User;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * Created by jingx on 12/22/2016.
 */
public class SearchResultPhotoRedirectViewReportTest extends PageObjectModelResources {
    WebDriver driver;

    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
        setUpWithUser(User.UserType.RU, driver); //pass userType and browser. see ~/QAUberTestConfig
        //setUpWithUser creates TestCaseUser, access with testUser()
    }

    @Test
    public void searchResultPhotoRedirectViewReport() throws InterruptedException {
        String getreportidfromview;
        String getreportidfromphoto;
        int rowindex = 3;
        driver.get(Config.getBaseURL());
        Thread.sleep(10000);

        getLogin().loginToWave(testUser().getUsername(), testUser().getPassword());
        Thread.sleep(5000);

        getNavBar().reportsButton().click();
        Thread.sleep(5000);

        getReports().clickPublishedOnCheckbox();
        Thread.sleep(2000);

        getReports().selectReport(rowindex).click();
        Thread.sleep(2000);

        getreportidfromview = getReportsViewReport().reportID().getText();
        System.out.println("The report ID from clicking view button: " + getreportidfromview);
        Thread.sleep(2000);

        getNavBar().reportsButton().click();
        Thread.sleep(5000);

        getReports().clickPublishedOnCheckbox();
        Thread.sleep(2000);

        getReports().searchResultPhoto(rowindex).click();
        Thread.sleep(2000);

        getreportidfromphoto = getReportsViewReport().reportID().getText();
        System.out.println("The report ID from clicking view button: " + getreportidfromphoto);
        Thread.sleep(2000);

        Assert.assertEquals(getreportidfromphoto,getreportidfromview);


    }


    @AfterClass
    public void breakDown(){
        breakDownHelper(driver);
    }
}
