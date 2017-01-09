package com.qauber.sanity;

import com.qauber.pagesresource.PageObjectModelResources;
import com.qauber.pagesresource.TestRail;
import com.qauber.pagesresource.User;
import org.apache.commons.lang3.StringUtils;
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
        setUpUser(User.UserType.SAU);
        //testConfig().getTestRail().setCaseID();
        //testConfig().getTestRail().setTester("Alya");
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
        getReports().publishedOnCheckBox().click();
        Thread.sleep(2000);
        getReports().selectReport(rowindex).click();
        Thread.sleep(2000);

        //TO DO assertions for dob, raceHeightWeight, hairColorHairLengthHairStyle, complexionTeethHandPreference
        String suspectName = getReportsViewReport().suspectName().getText();
        String suspectType = getReportsViewReport().suspectType().getText();
        String dob = getReportsViewReport().dob().getTagName();
        String nickname = getReportsViewReport().nickName().getText();
        String raceHeightWeight = getReportsViewReport().raceHeightWeight().getText();
        String hairColorHairLengthHairStyle = getReportsViewReport().hairColorHairLengthHairStyle().getText();
        String sexBuildEyeColor = getReportsViewReport().sexBuildEyeColor().getText();
        String complexionTeethHandPreference = getReportsViewReport().complexionTeethHandPreference().getText();

        getReportsViewReport().useAsTemplateButton().click();
        Thread.sleep(2000);
        getAddReportOrganization().clickOrganization1();
        Thread.sleep(3000);
        getAddReportNavigation().subjectInformationTab().click();

        /*suspectName = firstName+middleName+lastName, suspectType = suspectTypeString, nickname = nickName,
        sexBuildEyeColor = sex+build+eyeColor*/
        String caseID = getAddReportSubjectInformationPage().caseIdField().getAttribute("value");
        String firstName = getAddReportSubjectInformationPage().firstName().getAttribute("value");
        String middleName = getAddReportSubjectInformationPage().middleName().getAttribute("value");
        String lastName = getAddReportSubjectInformationPage().lastName().getAttribute("value");
        String suspectTypeString = getAddReportSubjectInformationPage().subjectType().getAttribute("value");
        String nickName = getAddReportSubjectInformationPage().nickName().getAttribute("value");
        String sexString = getAddReportSubjectInformationPage().sex().getAttribute("value");
        String buildString = getAddReportSubjectInformationPage().build().getAttribute("value");
        String eyeColorString = getAddReportSubjectInformationPage().eyeColor().getAttribute("value");

        Assert.assertEquals(caseID, "");

        if (StringUtils.isBlank(middleName)) {
            Assert.assertEquals(suspectName, firstName + " " + lastName);
        } else {
            Assert.assertEquals(suspectName, firstName + " " + middleName + " " + lastName);
        }

        Assert.assertEquals(suspectType, suspectTypeString);

        Assert.assertEquals(nickname, nickName);

        String sex = StringUtils.isBlank(sexString) ? "" : sexString + " ";
        String build = StringUtils.isBlank(buildString) ? " " : " " + buildString + " ";
        String eyeColor = StringUtils.isBlank(eyeColorString) ? "" : " " + eyeColorString;

        Assert.assertEquals(sexBuildEyeColor, sex + "/" + build + "/" + eyeColor);
        //testConfig().getTestRail().addResults(TestRail.TestCaseResult.PASSED, "Test passed");
    }
    @AfterClass
    public void breakDown() {
        breakDownHelper();
    }
}



