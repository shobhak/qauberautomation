package com.qauber.samplecode;

import com.qauber.pagesresource.PageObjectModelResources;
import com.qauber.pagesresource.TestRail;
import com.qauber.pagesresource.User;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * Created by erikfriedlander on 12/24/16.
 * === This test case demonstrates the use of a Config object with a configuration text file and TestRail integration.
 * === It reports to TestRail whether the test passes or fails, with useful results - see try/catch at Assert.
 *
 * TEST RAIL CASE: https://bidqa.testrail.net/index.php?/cases/view/79853
 * TEST RAIL RESULTS: https://bidqa.testrail.net/index.php?/cases/results/79853
 *
 * We test if 'Add Entity' button text on top of Entity page is correct.
 *
 * Setup:
 * 1. reads test config from config.txt
 * 2. gets a 'test user'
 *** 3. sets test case ID & 'tester name' for TestRail integration through config
 * 4. makes local sleepTime
 * 5. finishes setup (creates driver & POM objects)
 *
 * ===========
 * Test:
 * Assert if text matches.
 **** IF FAIL: Catch failed assertion (AssertionError) and report results:
 * testConfig().getTestRail().addResults(TestRail.TestCaseResult.FAILED, "(useful failed test results comment");
 * and throw back AssertionError to TestNG.
 **** IF SUCCEED: Assertion succeeds
 * testConfig().getTestRail().addResults(TestRail.TestCaseResult.PASS, "(some comments here");
 *
 * AddResults will eventually upload the results to TestRail.
 */
public class SimpleSampleConfigOOPTestCase extends PageObjectModelResources {

    int sleepTime;

    @BeforeClass
    public void setUp() {
        //Initial setup
        setUpWithConfigFile(); //Read config file from disk, create if not present
        setUpUser(User.UserType.SAU); //Pass in user

        //TestRail Configuration
        testConfig().getTestRail().setCaseID(79853); //sample TestRail case ID, TODO: will update with 'real' test case ID later, and add link to TestRail in comments
        testConfig().getTestRail().setTester("Erik's Computer"); //put your name :-)

        //Misc configuration
        sleepTime = testConfig().getSleepTime(); //set sleepTime locally - easier than writing testConfig().getSleepTime() everywhere

        //Create driver & page objects, finish setup
        setUpScript();
    }

    @Test
    public void EntityPageVerifyAddEntityButtonText() throws InterruptedException {
        testDriver().get(testConfig().getBaseURL());
        Thread.sleep(sleepTime);

        getLogin().loginToWave(testUser().getUsername(), testUser().getPassword());
        Thread.sleep(sleepTime);

        getNavBar().clickEntities();
        Thread.sleep(sleepTime);

        System.out.println(getEntities().addOrganizationButton().getText());

        try {
            Assert.assertEquals(getEntities().addOrganizationButton().getText(), "Add Entity"); //ASSERT IF TEXT IS CORRECT
            //Change assertion and see what happens.
        } catch (AssertionError e) { //IF TEXT IS WRONG, 'CATCH' ASSERTION ERROR AND REPORT RESULTS!
            testConfig().getTestRail().addResults(TestRail.TestCaseResult.FAILED, "\"Add Entity\" button text at top of Add Organization page is incorrect: "+e.getLocalizedMessage());
            throw e; //Throw failed assertion back to TestRail.
            //Try commenting out 'throw e' with a failed assertion, and see what happens :-)
        }

        testConfig().getTestRail().addResults(TestRail.TestCaseResult.PASSED, "Test passed"); //upload

        Thread.sleep(15000); //so we can see what happened
    }

    @AfterClass
    public void breakDown() {
        breakDownHelper();
    }
}
