package com.qauber.sanity;

import com.qauber.assertutil.AssertUber;
import com.qauber.pagesresource.PageObjectModelResources;
import com.qauber.pagesresource.TestRail;
import com.qauber.pagesresource.User;
import org.apache.commons.lang3.StringUtils;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * Created by Alya on 12/20/2016.
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
        getPreconditions().getReportPreconditions().ensureReportsAtLeast(1);
        Thread.sleep(sleepTime/2);
        getReports().selectReport(rowindex).click();
        Thread.sleep(sleepTime/2);

        String suspectName = getReportsViewReport().suspectName().getText();
        String suspectType = getReportsViewReport().suspectType().getText();
        String dob = getReportsViewReport().dob().getText();
        String nickname = getReportsViewReport().nickName().getText();
        String raceHeightWeight = getReportsViewReport().raceHeightWeight().getText();
        String hairColorHairLengthHairStyle = getReportsViewReport().hairColorHairLengthHairStyle().getText();
        String sexBuildEyeColor = getReportsViewReport().sexBuildEyeColor().getText();
        String complexionTeethHandPreference = getReportsViewReport().complexionTeethHandPreference().getText();

        getReportsViewReport().useAsTemplateButton().click();
        Thread.sleep(sleepTime/2);
        getAddReportOrganization().clickOrganization1();
        Thread.sleep(sleepTime/2);
        getAddReportNavigation().subjectInformationTab().click();

        /*suspectName = firstName+middleName+lastName, suspectType = suspectTypeString, nickname = nickName,
        sexBuildEyeColor = sexString+buildString+eyeColorString,
        hairColorHairLengthHairStyle = hairColorString+hairLengthString+hairTypeString,
        complexionTeethHandPreference = complexionString+teethString+handPreferenceString,
        raceHeightWeight = raceString+heightString+weightString
        dob = doB*/
        String caseID = getAddReportSubjectInformationPage().caseIdField().getAttribute("value");
        String firstName = getAddReportSubjectInformationPage().firstName().getAttribute("value");
        String middleName = getAddReportSubjectInformationPage().middleName().getAttribute("value");
        String lastName = getAddReportSubjectInformationPage().lastName().getAttribute("value");
        String suspectTypeString = getAddReportSubjectInformationPage().subjectType().getAttribute("value");
        String doB = getAddReportSubjectInformationPage().dateOfBirth().getAttribute("value");
        String nickName = getAddReportSubjectInformationPage().nickName().getAttribute("value");
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

        if (StringUtils.isBlank(middleName)) {
            AssertUber.assertEquals(suspectName, firstName + " " + lastName, "Suspect name is different) ");
        } else {
            AssertUber.assertEquals(suspectName, firstName + " " + middleName + " " + lastName, "Suspect name is different");
        }

        AssertUber.assertEquals(suspectType, suspectTypeString, "Suspect type is different");

        AssertUber.assertEquals(dob,doB, "Date of birth is different");

        AssertUber.assertEquals(nickname, nickName, "NickName is different");

        String race = StringUtils.isBlank(raceString) ? "" : raceString + " ";
        String height = StringUtils.isBlank(heightString) ? " " : " " + heightString + " ";
        String weight = StringUtils.isBlank(weightString) ? "" : " " + weightString;

        AssertUber.assertEquals(raceHeightWeight, race + "/" + height + "/" + weight, "Race, height, weight are different");

        String hairColor = StringUtils.isBlank(hairColorString) ? "" : hairColorString + " ";
        String hairLength = StringUtils.isBlank(hairLengthString) ? " " : " " + hairLengthString + " ";
        String hairStyle = StringUtils.isBlank(hairStyleString) ? "" : " " + hairStyleString;

        AssertUber.assertEquals(hairColorHairLengthHairStyle, hairColor +"/" + hairLength + "/" + hairStyle, "Hair color, length, style are different");

        String sex = StringUtils.isBlank(sexString) ? "" : sexString + " ";
        String build = StringUtils.isBlank(buildString) ? " " : " " + buildString + " ";
        String eyeColor = StringUtils.isBlank(eyeColorString) ? "" : " " + eyeColorString;

        AssertUber.assertEquals(sexBuildEyeColor, sex + "/" + build + "/" + eyeColor, "Sex, build, eyeColor are different");

        String complexion = StringUtils.isBlank(complexionString) ? "" : complexionString + " ";
        String teeth = StringUtils.isBlank(teethString) ? " " : " " + teethString + " ";
        String handPreference = StringUtils.isBlank(handPreferenceString) ? "" : " " + handPreferenceString;

        AssertUber.assertEquals(complexionTeethHandPreference, complexion + "/" + teeth + "/" + handPreference, "Complexion, teeth, handPreference are different");

        testConfig().getTestRail().addResults(TestRail.TestCaseResult.PASSED, "Test passed");
    }

    @AfterClass
    public void breakDown() {
        breakDownHelper();
    }
}



