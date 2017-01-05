package com.qauber.pagesresource.preconditions;

import com.github.javafaker.Faker;
import com.qauber.pagesresource.ConfigOOP;
import com.qauber.pagesresource.PageObjectModelResources;
import com.qauber.pagesresource.User;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import java.util.List;

public class UsersPreconditionsSampleRunAsSeparateUser extends PageObjectModelResources {

    int sleepTime;
    Faker faker;

    public UsersPreconditionsSampleRunAsSeparateUser() {

    }

    public void setUp() {
        //Initial setup
        setUpWithConfigFile(); //Read config file from disk, create if not present
        setUpUser(User.UserType.SAU); //Pass in user
        testConfig().setBrowserType(ConfigOOP.BrowserType.CHROME);
        faker = new Faker();

        //Misc configuration
        sleepTime = testConfig().getSleepTime(); //set sleepTime locally - easier than writing testConfig().getSleepTime() everywhere

        //Create driver & page objects, finish setup
        setUpScript();
    }

    /** ensureUsersAtLeast(int num)
     * Get 'number of users we need to create'
     * If numberOfUsersNeeded > 0, create those users
     */
    public void ensureUsersAtLeast(int num) throws InterruptedException { //Ensure at least num users. If not existing, invite the number of users without activating.

        setUp();

        try { //TRY WITH RESOURCES - when try completes, 'finally' will run: even if 'try'  throws an exception

            testDriver().get(testConfig().getBaseURL());
            Thread.sleep(sleepTime);

            getLogin().loginToWave(testUser().getUsername(), testUser().getPassword());
            Thread.sleep(sleepTime);

            int numberOfUsersNeeded = verifyUsersAtLeast(num);
            System.out.println("Number of users we need to create: "+numberOfUsersNeeded);
            if (numberOfUsersNeeded > 0) { createUsersWithoutActivating(numberOfUsersNeeded); }

            Thread.sleep(15000); //so we can see what happened
        } finally { breakDown(); } //breakdown

    }

    public void breakDown() {
        breakDownHelper();
    }

    /** verifyUsersAtLeast(int num)
     * count users, decrementing numberRemaining
     * if numberRemaining = 0, return 0
     * if out of users to count, return numberRemaining
     * we check if we're out of users to count by...
     * 1. is numberRemaining > 0?
     * 2. is next button clickable?
     * 3. if so, click and keep going
     */

    public int verifyUsersAtLeast(int num) throws InterruptedException { //returns # of users needed
        int numberRemaining = num;
        boolean nextButtonEnabled;
        List<WebElement> rows;
        getNavBar().clickUsers();

        rows = getUsers().userNameRows(); // get initial rows
        if (rows.size() == 0) { return num; } //if there are no users, we need to make all of them

        //////////LOOP TIME
        do { //see if next page button exists { //while more rows to check (we check if there are 10 rows)
            rows = getUsers().userNameRows(); //get new rows
            nextButtonEnabled = getUsers().nextPageButtonEnabled(); //is user button still enabled?

            for (WebElement userRow : rows) { //iterate through rows
                System.out.println(userRow.getText()); //print name in each row (debugging code)
                numberRemaining--; //decrement number of users remaining
            }

            if (numberRemaining <= 0) { return 0; } //if we've found enough users, return 0

            //click 'next page' if 'next page button' is enabled
            if (nextButtonEnabled) {
                //Scroll to bottom of page before clicking - for users with low-res comps
                ((JavascriptExecutor)getDriver()).executeScript("arguments[0].scrollIntoView(true);", getUsers().nextPageButton());
                Thread.sleep(sleepTime/10);
                getUsers().nextPageButton().click();
            }
            Thread.sleep(sleepTime);

        } while (nextButtonEnabled); //is the next page button still enabled? see method for more

        return numberRemaining;
    }


    public void createUsersWithoutActivating(int usersNeeded) throws InterruptedException {
        String emailAddress;


        while (usersNeeded > 0) {
            emailAddress = ("testuser"+faker.name().firstName()+faker.name().lastName()).toLowerCase()+"@mailinator.com"; //create email address

            getUsers().inviteUserWithoutActivation(emailAddress);

            Thread.sleep(sleepTime);

            usersNeeded--; //decrement users
        }

    }



}
