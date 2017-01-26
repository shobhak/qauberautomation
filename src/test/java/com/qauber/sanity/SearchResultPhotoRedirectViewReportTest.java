package com.qauber.sanity;

import com.qauber.pagesresource.PageObjectModelResources;
import com.qauber.pagesresource.TestRail;
import com.qauber.pagesresource.User;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * Created by jingx on 12/22/2016.
 * TODO: add to TestRail
 * TODO: preconditions / check if row exists before comparing ID
 */
public class SearchResultPhotoRedirectViewReportTest extends PageObjectModelResources {

    private int sleepTime;
    @BeforeClass
    public void setUp() {
        setUpWithConfigFile();

        testConfig().getTestRail().setCaseID(82807);    //add TC number from the TestRail
        testConfig().getTestRail().setTester("Jing");       //add user name
        sleepTime = testConfig().getSleepTime();
        
        setUpUser(User.UserType.SAU);
        setUpScript();
    }

    @Test
    public void searchResultPhotoRedirectViewReport() throws InterruptedException {
        String getreportidfromview;
        String getreportidfromphoto;
        int rowindex = 1;
        getDriver().get(testConfig().getBaseURL());
        Thread.sleep(sleepTime*2);

        getLogin().loginToWave(testUser().getUsername(), testUser().getPassword());
        Thread.sleep(sleepTime);

        getNavBar().reportsButton().click();
        Thread.sleep(sleepTime);

        getReports().clickPublishedOnCheckbox();
        Thread.sleep(sleepTime/2);

        getReports().selectReport(rowindex).click();
        Thread.sleep(sleepTime/2);

        getreportidfromview = getReportsViewReport().reportID().getText();
        System.out.println("The report ID from clicking view button: " + getreportidfromview);
        Thread.sleep(sleepTime/2);

        getNavBar().reportsButton().click();
        Thread.sleep(sleepTime);

        getReports().clickPublishedOnCheckbox();
        Thread.sleep(sleepTime/2);

        getReports().searchResultPhoto(rowindex).click();
        Thread.sleep(sleepTime/2);

        getreportidfromphoto = getReportsViewReport().reportID().getText();
        System.out.println("The report ID from clicking view button: " + getreportidfromphoto);
        Thread.sleep(sleepTime/2);

        try {
            Assert.assertEquals(getreportidfromphoto,getreportidfromview);
        } catch (AssertionError e) {
            testConfig().getTestRail().addResults(TestRail.TestCaseResult.FAILED, "The report ID not matched: " + e.getLocalizedMessage() );
            throw e;
        }
        testConfig().getTestRail().addResults(TestRail.TestCaseResult.PASSED, "Test Passed.");
        Thread.sleep(sleepTime*2);


    }


    @AfterClass
    public void breakDown(){
        breakDownHelper();
    }
}
