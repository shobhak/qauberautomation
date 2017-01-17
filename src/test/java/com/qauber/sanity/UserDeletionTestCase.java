package com.qauber.sanity;

import com.qauber.pagesresource.PageObjectModelResources;
import com.qauber.pagesresource.TestRail;
import com.qauber.pagesresource.User;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * Created by lenochka on 27.12.2016.
 * TODO: add asserts!
 * TODO: add to TestRail
 * TODO: (low priority) modify to create new user(s), then delete them :-)
 */
public class UserDeletionTestCase extends PageObjectModelResources {

    private int sleepTime;

    @BeforeClass
    public void setUp() throws InterruptedException {
        setUpWithConfigFile();
        setUpUser(User.UserType.SAU);

     testConfig().getTestRail().setCaseID(80078);
     testConfig().getTestRail().setTester("ElenaB");

        sleepTime = testConfig().getSleepTime();
        setUpScript();

       // testDriver().get(testConfig().getBaseURL());
//        Thread.sleep(sleepTime);
//
//        getLogin().loginToWave(testUser().getUsername(), testUser().getPassword());
//        Thread.sleep(sleepTime);
    }


    @Test
    public void userDeletion() throws InterruptedException {
        testDriver().get(testConfig().getBaseURL());
        Thread.sleep(sleepTime);

        getLogin().loginToWave(testUser().getUsername(), testUser().getPassword());
        Thread.sleep(sleepTime);

        //preconditions
        getPreconditions().getUsersPreconditions().ensureUsersAtLeast(10);

        getNavBar().clickUsers();
        Thread.sleep(sleepTime);

        //Get email address for row 10
        String emailAddressForRow10;
        emailAddressForRow10 = getUsers().userNameRows().get(9).getText();

        //Delete user in row 9:
        getUsers().deleteButtonByIndex(8).click(); //Click delete button (open delete dialog)
        Thread.sleep(sleepTime);

        //Click 'Confirm delete' button
        getUsers().deleteConfirmationButton().click();
        Thread.sleep(sleepTime);

        //Get email address for in row 9
        String emailAddressForRow9;
        emailAddressForRow9 = getUsers().userNameRows().get(8).getText();

        //Does the old email address in row 9 match the new address in row 10?
        //(Did row 10 move 'up' by 1?)
        try {
            //check whether user #10 become user #9
            Assert.assertEquals(emailAddressForRow9,emailAddressForRow10);
            //Change assertion and see what happens.
        } catch (AssertionError e) { //IF TEXT IS WRONG, 'CATCH' ASSERTION ERROR AND REPORT RESULTS!
            testConfig().getTestRail().addResults(TestRail.TestCaseResult.FAILED, "Are you sure you want to delete the user? is incorrect: "+e.getLocalizedMessage());
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