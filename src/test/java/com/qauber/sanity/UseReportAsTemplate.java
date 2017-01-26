package com.qauber.sanity;

import com.qauber.assertutil.AssertUber;
import com.qauber.pagesresource.PageObjectModelResources;
import com.qauber.pagesresource.TestRail;
import com.qauber.pagesresource.User;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * Created by Alya on 12/20/2016.
 *
 * Template displays data from Subject Information page of the report, except case id, age, primary language,
 * street address, country, city, state, zip, telephone, email, driver, passenger, pedestrian
 */

public class UseReportAsTemplate extends PageObjectModelResources {

    private int sleepTime;

    @BeforeClass
    public void setUp() {
        setUpWithConfigFile();
        setUpUser(User.UserType.SAU);
        sleepTime = testConfig().getSleepTime();
        testConfig().getTestRail().setCaseID(82780);
        testConfig().getTestRail().setTester("Alya");
        setUpScript();
    }

    @Test
    public void reportsUseReportAsTemplate() throws InterruptedException {
        int rowindex = 1;

        testDriver().get(testConfig().getBaseURL());
        Thread.sleep(sleepTime*2);
        getLogin().loginToWave(testUser().getUsername(), testUser().getPassword());
        Thread.sleep(sleepTime);
        getNavBar().reportsButton().click();
        getReports().publishedOnCheckBox().click();
        Thread.sleep(sleepTime/2);
        getPreconditions().getReportPreconditions().ensurePublishedReportsAtLeast(1);
        Thread.sleep(sleepTime/2);
        getReports().selectReport(rowindex).click();
        Thread.sleep(sleepTime/2);

        // Reports: View page

        String suspectType = getReportsViewReport().suspectType().getText();
        String lastName = getReportsViewReport().lastName().getText();
        String firstName = getReportsViewReport().firstName().getText();
        String middleName = getReportsViewReport().middleName().getText();
        String nickname = getReportsViewReport().nickName().getText();
        String dob = getReportsViewReport().dob().getText();
        String sex = getReportsViewReport().sex().getText();
        String race = getReportsViewReport().race().getText();
        String height = getReportsViewReport().height().getText();
        String weight = getReportsViewReport().weight().getText();
        String build = getReportsViewReport().build().getText();
        String hairColor = getReportsViewReport().hairColor().getText();
        String hairLength = getReportsViewReport().hairLength().getText();
        String hairStyle = getReportsViewReport().hairStyle().getText();
        String eyeColor = getReportsViewReport().eyeColor().getText();
        String complexion = getReportsViewReport().complexion().getText();
        String teeth = getReportsViewReport().teeth().getText();
        String handPreference = getReportsViewReport().handPreference().getText();

        getReportsViewReport().useAsTemplateButton().click();
        Thread.sleep(sleepTime/2);
        getAddReportOrganization().clickOrganization1();
        Thread.sleep(sleepTime/2);
        getAddReportNavigation().subjectInformationTab().click();

        // Add Report: Subject information

        String caseID = getAddReportSubjectInformationPage().caseIdField().getAttribute("value");
        String firstNameString = getAddReportSubjectInformationPage().firstName().getAttribute("value");
        String middleNameString = getAddReportSubjectInformationPage().middleName().getAttribute("value");
        String lastNameString = getAddReportSubjectInformationPage().lastName().getAttribute("value");
        String suspectTypeString = getAddReportSubjectInformationPage().subjectType().getAttribute("value");
        String nickNameString = getAddReportSubjectInformationPage().nickName().getAttribute("value");
        String dobString = getAddReportSubjectInformationPage().dateOfBirth().getAttribute("value");
        String raceString = getAddReportSubjectInformationPage().race().getAttribute("value");
        String heightString = getAddReportSubjectInformationPage().height().getAttribute("value");
        String weightString = getAddReportSubjectInformationPage().weight().getAttribute("value");
        String hairColorString = getAddReportSubjectInformationPage().hairColor().getAttribute("value");
        String hairLengthString = getAddReportSubjectInformationPage().hairLength().getAttribute("value");
        String hairStyleString = getAddReportSubjectInformationPage().hairStyle().getAttribute("value");
        String sexString = getAddReportSubjectInformationPage().sex().getAttribute("value");
        String buildString = getAddReportSubjectInformationPage().build().getAttribute("value");
        String eyeColorString = getAddReportSubjectInformationPage().eyeColor().getAttribute("value");
        String complexionString = getAddReportSubjectInformationPage().complexion().getAttribute("value");
        String teethString = getAddReportSubjectInformationPage().teeth().getAttribute("value");
        String handPreferenceString = getAddReportSubjectInformationPage().handPreference().getAttribute("value");

        AssertUber.assertEquals(caseID, "", "Case ID is displayed");
        AssertUber.assertEquals(suspectType, suspectTypeString, "Suspect type is different");
        AssertUber.assertEquals(lastName, lastNameString, "Last name is different");
        AssertUber.assertEquals(firstName, firstNameString, "First name is different");
        AssertUber.assertEquals(middleName, middleNameString, "Middle name is different");
        AssertUber.assertEquals(nickname, nickNameString, "Nick name is different");
        AssertUber.assertEquals(dob,dobString, "Date of birth is different");
        AssertUber.assertEquals(race, raceString, "Race is different");
        AssertUber.assertEquals(height, heightString, "Height is different");
        AssertUber.assertEquals(weight, weightString, "Weight is different");
        AssertUber.assertEquals(hairColor, hairColorString, "Hair color is different");
        AssertUber.assertEquals(hairLength, hairLengthString, "Hair length is different");
        AssertUber.assertEquals(hairStyle, hairStyleString, "Hair style is different");
        AssertUber.assertEquals(sex, sexString, "Sex is different");
        AssertUber.assertEquals(build, buildString, "Build is different");
        AssertUber.assertEquals(eyeColor, eyeColorString, "Eye color is different");
        AssertUber.assertEquals(complexion, complexionString, "Complexion is different");
        AssertUber.assertEquals(teeth, teethString, "Teeth is different");
        AssertUber.assertEquals(handPreference, handPreferenceString, "Hand preference is different");

        testConfig().getTestRail().addResults(TestRail.TestCaseResult.PASSED, "Test passed");
    }

    @AfterClass
    public void breakDown() {
        breakDownHelper();
    }
}



