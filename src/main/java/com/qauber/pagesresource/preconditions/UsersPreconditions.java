package com.qauber.pagesresource.preconditions;

import com.github.javafaker.Faker;
import com.qauber.pages.NavBar;
import com.qauber.pages.Users;
import com.qauber.pages.UsersPermissionsDialog;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

/**
 * Created by erikfriedlander on 1/4/17.
 */
public class UsersPreconditions {
    private int sleepTime; //TODO: replace with sleepTime from config

    private WebDriver driver;
    private Faker faker;
    private NavBar navBar;
    private Users users;
    private UsersPermissionsDialog usersPermissionsDialog;


    public UsersPreconditions(WebDriver driver) {
        sleepTime = 7000; //TODO: replace with sleepTime from config
        this.driver = driver;
        faker = new Faker();
        navBar = new NavBar(driver);
        users = new Users(driver);
        usersPermissionsDialog = new UsersPermissionsDialog(driver);

    }

    /** ensureUsersAtLeast(int num)
     * Get 'number of users we need to create'
     * If numberOfUsersNeeded > 0, create those users
     */
    public void ensureUsersAtLeast(int num) throws InterruptedException { //Ensure at least num users. If not existing, invite the number of users without activating.
        int numberOfUsersNeeded = verifyUsersAtLeast(num);
        System.out.println("Number of users we need to create: "+numberOfUsersNeeded);
        if (numberOfUsersNeeded > 0) {
            createUsersWithoutActivating(numberOfUsersNeeded);
        }
    }


    /** verifyUsersAtLeast(int num)
     * count users, decrementing numberRemaining
     * if numberRemaining = 0, return 0
     * if out of users to count, return numberRemaining
     * we check if we're out of users to count by...
     * 1. clicking next button (click may do nothing if we're on lat page)
     * 2. comparing 'old' rows with 'new' rows
     */
    public int verifyUsersAtLeast(int num) throws InterruptedException { //returns # of users needed
        int numberRemaining = num;
        boolean nextButtonEnabled;
        List<WebElement> rows;
        navBar.clickUsers();

        rows = users.userNameRows(); // get initial rows
        if (rows.size() == 0) { return num; } //if there are no users, we need to make all of them

        //////////LOOP TIME
        do { //see if next page button exists { //while more rows to check (we check if there are 10 rows)
            rows = users.userNameRows(); //get new rows
            nextButtonEnabled = users.nextPageButtonEnabled(); //is user button still enabled?

            for (WebElement userRow : rows) { //iterate through rows
                System.out.println(userRow.getText()); //print name in each row (debugging code)
                numberRemaining--; //decrement number of users remaining
            }

            if (numberRemaining <= 0) { return 0; } //if we've found enough users, return 0

            //click 'next page' if 'next page button' is enabled
            if (nextButtonEnabled) {
                //Scroll to bottom of page before clicking - for users with low-res comps
                ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", users.nextPageButton());
                Thread.sleep(sleepTime/10);
                users.nextPageButton().click();
            }
            Thread.sleep(sleepTime);

        } while (nextButtonEnabled); //is the next page button still enabled? see method for more

        return numberRemaining;
    }


    public void createUsersWithoutActivating(int usersNeeded) throws InterruptedException {
        String emailAddress;


        while (usersNeeded > 0) {
            emailAddress = ("testuser"+faker.name().firstName()+faker.name().lastName()).toLowerCase()+"@mailinator.com"; //create email address

            users.inviteUserWithoutActivation(emailAddress);

            Thread.sleep(sleepTime);

            usersNeeded--; //decrement users
        }
    }


}