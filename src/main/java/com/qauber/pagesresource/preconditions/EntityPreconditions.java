package com.qauber.pagesresource.preconditions;

import com.github.javafaker.Faker;
import com.qauber.pages.*;
import com.qauber.pagesresource.PageObjectModelResources;
import com.qauber.pagesresource.PageResources;
import com.qauber.pagesresource.PageResourcesFactory;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

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
    private PageResources page;
    private String paypalEmailAccount = "jing_qauber_test01@test.com";
    private String paypalPassword = "portnovschool";

    public EntityPreconditions(WebDriver driver) {
        sleepTime = 5000; //TODO: replace with sleepTime from config
        this.driver = driver;
        faker = new Faker();
        page = PageResourcesFactory.getPageResources(driver);
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

    public void ensureOrganizationSubscribed(int tableRow) throws InterruptedException {
        
        if(page.getEntities().finishCreateOrganizationButtonList(tableRow).size() != 0) {

            page.getEntities().finishCreateOrganizationButton(tableRow).click();
            //page.getSubscriptionSettings().slider(17);
            page.getCreateSubsciption().sliderDragTo(11);
        
            page.getCreateSubsciption().finishButton().click();
            Thread.sleep(sleepTime);
            if (page.getCreateSubsciption().payWithMyPayPal() != null) {
                page.getCreateSubsciption().payWithMyPayPal().click();
                Thread.sleep(sleepTime);
            }
            page.getCreateSubsciption().loginField().sendKeys(paypalEmailAccount); //private for this class
            page.getCreateSubsciption().passwordField().sendKeys(paypalPassword);
            page.getCreateSubsciption().logInButton().click();
            Thread.sleep(sleepTime);
            page.getCreateOrganization().agreeAndContinueButton().click();
            Thread.sleep(sleepTime/3);

            page.getCreateSubsciption().textPaymentSuccessful().isDisplayed();
            Thread.sleep(sleepTime);
        }
        else System.out.println("Organization subscribed!!");

    }
}