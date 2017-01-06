package com.qauber.sanity;

import com.qauber.pagesresource.PageObjectModelResources;
import com.qauber.pagesresource.User;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * Created by Alya on 12/20/2016.
 */

public class UseReportAsTemplate extends PageObjectModelResources {

    @BeforeClass
    public void setUp() {
        setUpWithConfigFile();
        setUpUser(User.UserType.SAU);
        setUpScript();
    }

    @Test
    public void reportsUseReportAsTemplate() throws InterruptedException {
        int rowindex = 1;

        testDriver().get(testConfig().getBaseURL());
        Thread.sleep(10000);
        getLogin().loginToWave(testUser().getUsername(), testUser().getPassword());
        Thread.sleep(5000);
        getNavBar().reportsButton().click();
        Thread.sleep(2000);
        getReports().clickPublishedOnCheckbox();
        Thread.sleep(2000);
        getReports().selectReport(rowindex).click();
        Thread.sleep(2000);

        String suspectName = getReportsViewReport().suspectName().getText();

        getReportsViewReport().useAsTemplateButton().click();
        Thread.sleep(5000);

        getAddReportNavigation().subjectInformationTab().click();

        String firstName = getAddReportSubjectInformationPage().firstName().getAttribute("value");
        String lastName = getAddReportSubjectInformationPage().lastName().getAttribute("value");

        Assert.assertEquals(suspectName, firstName + " " + lastName);
    }
    @AfterClass
    public void breakDown() {
        breakDownHelper();
    }
}



