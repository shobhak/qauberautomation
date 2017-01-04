package com.qauber.samplecode;

import com.qauber.pagesresource.PageObjectModelResources;
import com.qauber.pagesresource.User;
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
public class SimpleSampleEnsurePreconditions extends PageObjectModelResources {

    int sleepTime;

    @BeforeClass
    public void setUp() {
        //Initial setup
        setUpWithConfigFile(); //Read config file from disk, create if not present
        setUpUser(User.UserType.SAU); //Pass in user

        //Misc configuration
        sleepTime = testConfig().getSleepTime(); //set sleepTime locally - easier than writing testConfig().getSleepTime() everywhere

        //Create driver & page objects, finish setup
        setUpScript();
    }

    @Test
    public void ensureUsersAtLeastPreconditionTest() throws InterruptedException {
        testDriver().get(testConfig().getBaseURL());
        Thread.sleep(sleepTime);

        //Log in...
        getLogin().loginToWave(testUser().getUsername(), testUser().getPassword());
        Thread.sleep(sleepTime);

        ///////ENSURE PRECONDITION: AT LEAST n USERS
        getPreconditions().getUsersPreconditions().ensureUsersAtLeast(30);

    }

    @AfterClass
    public void breakDown() {
        breakDownHelper();
    }
}
