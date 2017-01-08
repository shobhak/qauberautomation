package com.qauber.pagesresource.preconditions;

import com.github.javafaker.Faker;
import com.qauber.pages.*;
import org.openqa.selenium.WebDriver;

/**
 * Created by Alya on 1/4/2017.
 */

// to be continued

public class EntitiesNamesPreconditions {
    private int sleepTime;
    private WebDriver driver;
    private Faker faker;
    private NavBar navBar;
    private Entities entities;
    private EntitiesPermissionsDialog entitiesPermissionsDialog;

    public EntitiesNamesPreconditions(WebDriver driver) {

        sleepTime = 7000;
        this.driver = driver;
        faker = new Faker();
        navBar = new NavBar(driver);
        entities = new Entities(driver);
        entitiesPermissionsDialog = new EntitiesPermissionsDialog(driver);
    }

    public void ensureEntityNameExists(String entityName) throws InterruptedException {
        navigateToEntityPage();
        if (!isEntityNameInSystem(entityName)) {
            addEntity(entityName);
        }

        for (int i = 0; i < entities.organizationList().size(); i++) {
            if (entities.organizationList().get(i).getText().equals(entityName)) {
                System.out.println("The entity name is in the list");
                break;
            } else {
                if (i == (entities.organizationList().size() - 1)) {
                    addEntity(entityName);
                }
            }
        }
    }

    public boolean isEntityNameInSystem(String entityName) {
        return true;
    }

    public void addEntity(String entityName) {

    }

    public void navigateToEntityPage() {
        navBar.entitiesButton();
    }

    public void ensureDepartmentNameExists() throws InterruptedException {

    }

    public void ensuresubDepartmentNameExists() throws InterruptedException {

    }
}
