package com.qauber.pagesresource.preconditions;

import com.github.javafaker.Faker;
import com.qauber.pages.*;
import org.openqa.selenium.WebDriver;

/**
 * Created by Alya on 1/4/2017.
 */

// TO DO: ensure name exist for department and subDepartment

public class EntitiesNamesPreconditions {
    private int sleepTime;
    private WebDriver driver;
    private Faker faker;
    private NavBar navBar;
    private Entities entities;
    private EntitiesPermissionsDialog entitiesPermissionsDialog;
    private CreateOrganization createOrganization;
    private String paypalEmailAccount = ""; //enter your data
    private String paypalPassword = ""; //enter your data

    public EntitiesNamesPreconditions(WebDriver driver) {

        sleepTime = 7000;
        this.driver = driver;
        faker = new Faker();
        navBar = new NavBar(driver);
        entities = new Entities(driver);
        entitiesPermissionsDialog = new EntitiesPermissionsDialog(driver);
        createOrganization = new CreateOrganization(driver);
    }

    public void ensureEntityNameExists(String entityName) throws InterruptedException {
        if (!isEntityNameInSystem(entityName)) {
            addEntity(entityName);
        }
    }

    public boolean isEntityNameInSystem(String entityName) {
        for (int i = 0; i < entities.organizationList().size(); i++) {
            if (entities.organizationList().get(i).getText().equals(entityName)) {
                return true;
            }
        }
        return false;
    }

    public void addEntity(String entityName) throws InterruptedException {
        navBar.entitiesButton().click();
        Thread.sleep(2000);
        entities.addOrganizationButton().click();
        Thread.sleep(2000);
        createOrganization.entityNameField().sendKeys(entityName);
        Thread.sleep(2000);
        createOrganization.entityCountryDropDown("Austria").click();
        Thread.sleep(2000);
        createOrganization.entityAddress1().sendKeys(faker.address().streetAddress());
        Thread.sleep(2000);
        createOrganization.entityCity().sendKeys(faker.address().city());
        Thread.sleep(2000);
        createOrganization.entityState().sendKeys(faker.address().state());
        Thread.sleep(2000);
        createOrganization.entityPostalCode().sendKeys(faker.address().zipCode());
        Thread.sleep(2000);
        createOrganization.entityNextButtone().click();
        Thread.sleep(2000);
        createOrganization.inviteRegularUserNextButton().click();
        Thread.sleep(3000);
        createOrganization.inviteAdminUserNextButton().click();
        Thread.sleep(2000);
        createOrganization.finishButton().click();
        Thread.sleep(2000);
        createOrganization.payWithMyPayPal().click();
        Thread.sleep(2000);
        createOrganization.loginField().sendKeys(paypalEmailAccount);
        Thread.sleep(8000);
        createOrganization.passwordField().sendKeys(paypalPassword);
        Thread.sleep(8000);
        createOrganization.logInButton().click();
        Thread.sleep(8000);
        createOrganization.agreeAndContinueButton().click();
        Thread.sleep(8000);
    }

    public void ensureDepartmentNameExists() throws InterruptedException {

    }

    public void ensureSubDepartmentNameExists() throws InterruptedException {

    }
}
