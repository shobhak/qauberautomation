package com.qauber.pagesresource.preconditions;

import com.github.javafaker.Faker;
import com.qauber.pages.*;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

/**
 * Created by erikfriedlander on 1/4/17.
 */
public class EntityPreconditions {
    private int sleepTime; //TODO: replace with sleepTime from config
    private WebDriver driver;
    private Faker faker;
    private NavBar navBar;
    private Entities entities;
    private EntitiesPermissionsDialog entitiesPermissionsDialog;


    public EntityPreconditions(WebDriver driver) {
        sleepTime = 5000; //TODO: replace with sleepTime from config
        this.driver = driver;
        faker = new Faker();
        navBar = new NavBar(driver);
        entities = new Entities(driver);
        entitiesPermissionsDialog = new EntitiesPermissionsDialog(driver);

    }

    //ensureEntitiesAtLeast(int num)
    public void ensureEntitiesAtLeast(int num) throws InterruptedException {
        //verify if the entities exist already
        //How many entities do we need to create?
        int numberToCreate;
        numberToCreate = verifyEntitiesAtLeast(num); // count the number of the entities
        System.out.println("Number to create: "+numberToCreate);
        createEntitites(numberToCreate); // add extra number of entities to the amount we need
    }

    //How many entities do we need to create?
    public int verifyEntitiesAtLeast(int desiredNumberOfEntities) throws InterruptedException { // returns number of entities
        int numberCounted = 0;
        List<WebElement> nameList;
        boolean nextButtonDisabled ;

        navBar.entitiesButton().click();
        Thread.sleep(sleepTime);

        do {
            nameList = entities.organizationList();
            nextButtonDisabled = entities.nextPageButtonDisabled(); //is user button still disabled?

            // how many entities are there on the page?
            //count rows of entities (entities of this page)
            for (WebElement element : nameList) {
                System.out.println(element.getText());
                if (desiredNumberOfEntities == numberCounted) {
                    return 0;
                }
                numberCounted = numberCounted+1;     //subtract from the number remaining
            }


            if (nextButtonDisabled) { //we're out of entities! can't count more
                System.out.println("Ran verifyEntitiesAtLeast("+desiredNumberOfEntities+")");
                System.out.println("verifyEntitiesAtLeast: numberRemaining:"+(desiredNumberOfEntities-numberCounted));
                return desiredNumberOfEntities-numberCounted;
            } else { //if next page button is enabled... click on it!
                entities.nextPageButton().click();
            }
        } while (nextButtonDisabled == false);   // count until number remaining = 0, or there are no entities left
        return desiredNumberOfEntities-numberCounted;
    }

    public void createEntitites(int numberToBeCreated) {
        System.out.println("createEntities: Let's pretend we created "+numberToBeCreated+" entities/");

    }
}