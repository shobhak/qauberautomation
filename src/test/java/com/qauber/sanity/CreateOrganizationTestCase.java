package com.qauber.sanity;

import com.github.javafaker.Faker;
import com.qauber.config.Config;
import com.qauber.pagesresource.PageObjectModelResources;
import com.qauber.pagesresource.User;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * Created by lenochka on 22.12.2016.
 */
public class CreateOrganizationTestCase extends PageObjectModelResources {

    WebDriver driver;
    String paypalEmailAccount = "jing_qauber_test01@test.com";
    String paypalPassword = "portnovschool";

    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
        setUpWithUser(User.UserType.SAU, driver); //pass userType and browser. see ~/QAUberTestConfig
        //setUpWithUser creates TestCaseUser, access with testUser()
    }


    @Test
    public void createOrganizationTestCase() throws InterruptedException {
        driver.manage().window().maximize();
        driver.get(Config.getBaseURL());

        Faker faker = new Faker();

        getLogin().loginToWave(testUser().getUsername(), testUser().getPassword());
        Thread.sleep(3000);

        getNavBar().clickEntities();
        Thread.sleep(3000);

        getEntities().addOrganizationButton().click();
        Thread.sleep(3000);

        getCreateOrganization().entityNameField().sendKeys(faker.name().username());
        Thread.sleep(3000);


        getCreateOrganization().entityPhoneField().sendKeys(faker.phoneNumber().cellPhone());
        Thread.sleep(3000);

        getCreateOrganization().entityEmailField().sendKeys(faker.internet().emailAddress());
        Thread.sleep(3000);

        //getCreateOrganization().entityCountryDropDown().sendKeys("Austria");
        Thread.sleep(3000);

        getCreateOrganization().entityCountryDropDown("Austria").click();
        Thread.sleep(3000);

        getCreateOrganization().entityAddress1().sendKeys(faker.address().streetAddress());
        Thread.sleep(3000);

        getCreateOrganization().entityAddress2().sendKeys(faker.address().streetAddress());
        Thread.sleep(3000);

        getCreateOrganization().entityCity().sendKeys(faker.address().city());
        Thread.sleep(3000);

        getCreateOrganization().entityState().sendKeys(faker.address().state());
        Thread.sleep(3000);

        getCreateOrganization().entityPostalCode().sendKeys(faker.address().zipCode());
        Thread.sleep(3000);

        getCreateOrganization().entityNextButtone().click();
        Thread.sleep(3000);

        getCreateOrganization().inviteRegularUserEmailField().sendKeys(faker.internet().emailAddress());
        Thread.sleep(3000);

        getCreateOrganization().inviteRegularUserNextButton().click();
        Thread.sleep(3000);

        getCreateOrganization().inviteRegularUserDoneButton().click();
        Thread.sleep(7000);

        getCreateOrganization().inviteAdminUserEmailField().sendKeys(faker.internet().emailAddress());
        Thread.sleep(3000);

        getCreateOrganization().inviteAdminUserNextButton().click();
        Thread.sleep(3000);

        getCreateOrganization().inviteAdminUserDoneButton().click();
        Thread.sleep(7000);

        getCreateOrganization().finishButton().click();
        Thread.sleep(3000);

        getCreateOrganization().payWithMyPayPal().click();
        Thread.sleep(3000);

        getCreateOrganization().loginField().sendKeys(paypalEmailAccount);
        Thread.sleep(8000);

        getCreateOrganization().passwordField().sendKeys(paypalPassword);
        Thread.sleep(8000);

        getCreateOrganization().logInButton().click();
        Thread.sleep(8000);

        getCreateOrganization().agreeAndContinueButton().click();
        Thread.sleep(8000);
    }


    @AfterClass
    public void breakDown(){
        breakDownHelper(driver);
    }
}