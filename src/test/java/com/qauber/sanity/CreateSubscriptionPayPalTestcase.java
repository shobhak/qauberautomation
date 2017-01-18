package com.qauber.sanity;

import com.qauber.pagesresource.PageObjectModelResources;
import com.qauber.pagesresource.PayPalCredentials;
import com.qauber.pagesresource.TestRail;
import com.qauber.pagesresource.User;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * Created by lenochka on 12/22/16. //TODO: who made this? I think it is Lenochka? (yes)
 * //TODO: Asserts - done
 * //TODO: Test Rail integration - done
 * TODO: move out PayPal into helper (talk to Jing first) - done
 */
public class CreateSubscriptionPayPalTestcase extends PageObjectModelResources {

    private int sleepTime;

    @BeforeClass
    public void setUp() {
        //Initial setup
        setUpWithConfigFile(); //Read config file from disk, create if not present
        setUpUser(User.UserType.SAU); //Pass in user

        //TestRail Configuration
       testConfig().getTestRail().setCaseID(82798); //TestRail case ID
       testConfig().getTestRail().setTester("ElenaB"); //put your name :-)

        //Misc configuration
        sleepTime = testConfig().getSleepTime(); //set sleepTime locally - easier than writing testConfig().getSleepTime() everywhere

        //Create driver & page objects, finish setup
        setUpScript();
    }

    @Test
    public void simpleSampleTestCase() throws InterruptedException {
        PayPalCredentials payPalCredentials = new PayPalCredentials(testDriver());
        int rowIndex = 3;

        testDriver().get(testConfig().getBaseURL());
        Thread.sleep(sleepTime*2);

        getLogin().loginToWave(testUser().getUsername(), testUser().getPassword());
        Thread.sleep(sleepTime*2);

        getNavBar().entitiesButton().click();
        Thread.sleep(sleepTime*3/2);

        getEntities().finishCreateOrganizationButton(rowIndex).click();
        Thread.sleep(sleepTime);

        getCreateSubsciption().finishButton().click();
        Thread.sleep(sleepTime*2);

        String currentURL = testDriver().getCurrentUrl();

        System.out.println(currentURL);
        Thread.sleep(sleepTime*2);


        payPalCredentials.payWithPayPal();
        System.out.println(payPalCredentials);
        Thread.sleep(sleepTime*2);

        getEntities().editOrganizationButton(rowIndex).click();


        try {
            String editOrgButton = "Edit";

            String actualResult = getEntities().editOrganizationButton(rowIndex).getAttribute("title");
            System.out.println(actualResult);
            //getEntities().editOrganizationButton().getAttribute("")
            Assert.assertEquals(editOrgButton,actualResult);
        }

        catch (AssertionError e) {
            testConfig().getTestRail().addResults(TestRail.TestCaseResult.FAILED, "Subscription is not created"+e.getLocalizedMessage());
            throw e;
        }

        testConfig().getTestRail().addResults(TestRail.TestCaseResult.PASSED, "Test passed");

    }

    @AfterClass
    public void breakDown(){
        breakDownHelper();
    }
}
