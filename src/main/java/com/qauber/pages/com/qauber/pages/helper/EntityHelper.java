package com.qauber.pages.com.qauber.pages.helper;

import com.github.javafaker.Faker;
import com.qauber.pages.Entities;
import com.qauber.pages.NavBar;
import com.qauber.pagesresource.*;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by lenochka on 06.01.2017.
 */
public class EntityHelper {

    private WebDriver driver;
    private WebElement element;
    private Faker faker;
//    private NavBar navBar;
//    private Entities entities;
    private PayPalCredentials payPalCredentials;
    private PageResources pageResources;

    public EntityHelper(WebDriver driver) {

        faker = new Faker();
        pageResources = PageResourcesFactory.getPageResources(driver); //creating an object for the class
        payPalCredentials = new PayPalCredentials(driver); // an object for PayPal
    }


    public void createEntities(int numberToBeCreated) throws InterruptedException {
//        ((JavascriptExecutor) driver).executeScript("javascript:window.scrollBy(0,-400)");
        int sleepTime;
        sleepTime = 3000;


        for (int count = 0; count < numberToBeCreated; count++) {

            pageResources.getNavBar().clickEntities();
            Thread.sleep(sleepTime);

            pageResources.getEntities().addOrganizationButton().click();
            Thread.sleep(sleepTime);

            pageResources.getCreateOrganization().entityNameField().sendKeys(faker.name().username());
            Thread.sleep(sleepTime);

            pageResources.getCreateOrganization().entityPhoneField().sendKeys(faker.phoneNumber().cellPhone());
            Thread.sleep(sleepTime);

            pageResources.getCreateOrganization().entityEmailField().sendKeys(faker.name().username() +"@mailinator.com");
            Thread.sleep(sleepTime);
            pageResources.getCreateOrganization().entityCountryDropDown("Austria").click();
            Thread.sleep(sleepTime);

            pageResources.getCreateOrganization().entityAddress1().sendKeys(faker.address().streetAddress());
            Thread.sleep(sleepTime);

            pageResources.getCreateOrganization().entityAddress2().sendKeys(faker.address().streetAddress());
            Thread.sleep(sleepTime);

            pageResources.getCreateOrganization().entityCity().sendKeys(faker.address().city());
            Thread.sleep(sleepTime);

            pageResources.getCreateOrganization().entityState().sendKeys(faker.address().state());
            Thread.sleep(sleepTime);

            pageResources.getCreateOrganization().entityPostalCode().sendKeys(faker.address().zipCode());
            Thread.sleep(sleepTime);

            pageResources.getCreateOrganization().entityNextButtone().click();
            Thread.sleep(sleepTime);

            pageResources.getCreateOrganization().inviteRegularUserEmailField().sendKeys(faker.name().username() + "@mailinator.com");
            Thread.sleep(sleepTime);

            pageResources.getCreateOrganization().inviteRegularUserNextButton().click();
            Thread.sleep(sleepTime);

            pageResources.getCreateOrganization().inviteRegularUserDoneButton().click();
            Thread.sleep(sleepTime*2);

            pageResources.getCreateOrganization().inviteAdminUserEmailField().sendKeys(faker.name().username() +"@mailinator.com");
            Thread.sleep(sleepTime);

            pageResources.getCreateOrganization().inviteAdminUserNextButton().click();
            Thread.sleep(sleepTime);

            pageResources.getCreateOrganization().inviteAdminUserDoneButton().click();
            Thread.sleep(sleepTime*2);

            pageResources.getCreateOrganization().finishButton().click();
            Thread.sleep(sleepTime*2);

            payPalCredentials.payWithPayPal();
            System.out.println(payPalCredentials);
            Thread.sleep(sleepTime*2);

            System.out.println("Created entity " + count);
        }
    }

}