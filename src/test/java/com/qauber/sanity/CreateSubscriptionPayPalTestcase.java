package com.qauber.sanity;

import com.qauber.pagesresource.PageObjectModelResources;
import com.qauber.pagesresource.User;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * Created by (someone) on 12/22/16. //TODO: who made this? I think it is Lenochka?
 * //TODO: Asserts
 * //TODO: Test Rail integration
 * TODO: move out PayPal into helper (talk to Jing first)
 */
public class CreateSubscriptionPayPalTestcase extends PageObjectModelResources {

    private int sleepTime;

    @BeforeClass
    public void setUp() {
        //Initial setup
        setUpWithConfigFile(); //Read config file from disk, create if not present
        setUpUser(User.UserType.SAU); //Pass in user

        //TestRail Configuration
//        testConfig().getTestRail().setCaseID(79853); //TestRail case ID
//        testConfig().getTestRail().setTester("Erik's Script"); //put your name :-)

        //Misc configuration
        sleepTime = testConfig().getSleepTime(); //set sleepTime locally - easier than writing testConfig().getSleepTime() everywhere

        //Create driver & page objects, finish setup
        setUpScript();
    }

    @Test
    public void simpleSampleTestCase() throws InterruptedException {
        testDriver().get(testConfig().getBaseURL());
        Thread.sleep(sleepTime*2);

        getLogin().loginToWave(testUser().getUsername(), testUser().getPassword());
        Thread.sleep(sleepTime*2);

        getNavBar().entitiesButton().click();
        Thread.sleep(sleepTime*3/2);

        getEntities().finishCreateOrganizationButton(3).click();
        Thread.sleep(sleepTime);

        getCreateSubsciption().finishButton().click();
        Thread.sleep(sleepTime*2);

        String currentURL = testDriver().getCurrentUrl();

        System.out.println(currentURL);
        Thread.sleep(sleepTime*2);

        getCreateSubsciption().payWithMyPayPal().click();
        Thread.sleep(sleepTime*3/5);

        getCreateSubsciption().loginField().sendKeys("jing_qauber_test01@test.com");
        Thread.sleep(sleepTime*3/5);

        getCreateSubsciption().passwordField().sendKeys("portnovschool");
        Thread.sleep(sleepTime*3/5);

        getCreateSubsciption().logInButton().click();
        Thread.sleep(sleepTime);

        getCreateSubsciption().agreeAndContinueButton().click();
        Thread.sleep(sleepTime);
    }

    @AfterClass
    public void breakDown(){
        breakDownHelper();
    }
}
