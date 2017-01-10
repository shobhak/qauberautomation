package com.qauber.sanity;

import com.qauber.pagesresource.PageObjectModelResources;
import com.qauber.pagesresource.User;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * Created by jingx on 12/22/2016.
 */
public class SearchResultPhotoRedirectViewReportTest extends PageObjectModelResources {

    @BeforeClass
    public void setUp() {
        setUpWithConfigFile();

        testConfig().getTestRail().setCaseID(00000);    //add TC number from the TestRail
        testConfig().getTestRail().setTester("");       //add user name

        setUpUser(User.UserType.SAU);
        setUpScript();
    }

    @Test
    public void searchResultPhotoRedirectViewReport() throws InterruptedException {
        String getreportidfromview;
        String getreportidfromphoto;
        int rowindex = 3;
        getDriver().get(testConfig().getBaseURL());
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
        breakDownHelper();
    }
}
