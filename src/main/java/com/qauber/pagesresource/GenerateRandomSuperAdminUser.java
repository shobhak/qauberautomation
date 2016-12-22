package com.qauber.pagesresource;

import com.github.javafaker.Faker;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Created by erikfriedlander on 12/19/16.
 */
public class GenerateRandomSuperAdminUser extends PageObjectModelResources {

    public GenerateRandomSuperAdminUser() {
    }

    WebDriver driver;
    Mailinator mailinator;
    Faker faker;
    int sleepTime;

    public void setUp() {
        driver = new ChromeDriver();
        mailinator = new Mailinator(driver);
        faker = new Faker();
        sleepTime = 5000;
        setUpScript(driver);
//        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
//        driver.manage().window().maximize();
    }

    public User generateRandomSuperAdminUser(String serverURL) throws InterruptedException {
        setUp();

        driver.get(serverURL);
        Thread.sleep(sleepTime);
        User newUser = new User();

        //Go to Registration Page
//        driver.findElement(By.xpath("//div[2]/a")).click();
        getLogin().registerButton().click();
        Thread.sleep(sleepTime);

        //Registration Page 1
        //set random name, username (email address! using Mailinator), password,
        String firstName = faker.name().firstName();
        String lastName = faker.name().lastName();
        String fullName = firstName+" "+lastName;
        String userName = firstName+lastName+"@mailinator.com";
        userName = userName.toLowerCase();

        String password = faker.internet().password(6, 20, true, false);


        getRegistrationPage1().registerUser1(fullName, userName, password);
        Thread.sleep(sleepTime);
        //////////////////////

        //Registration Page 2 - fill required fields with random data
        getRegistrationPage2().setRandomDataInFields();
        getRegistrationPage2().finishRegistrationButton().click();

        //Sleep, then activate email from mailinator
        Thread.sleep(60000); //was 120000

        driver.get(mailinator.getFirstLinkInFirstEmailInAccount(userName)); //get first link in first email from Mailinator, then click it


        //Sleep, then log in
        Thread.sleep(sleepTime*3);

//        driver.get(serverURL);
//        getLogin().loginToWave(userName, password);

        newUser.setUsername(userName);
        newUser.setPassword(password);
        newUser.setUserType(User.UserType.SAU);

        //
        breakDown();

        return newUser;
    }

    public void breakDown() throws InterruptedException {
        Thread.sleep(15000);
        breakDownHelper(driver);
        Thread.sleep(15000);
    }
}
