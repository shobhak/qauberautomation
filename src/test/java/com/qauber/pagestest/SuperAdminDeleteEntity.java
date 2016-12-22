package com.qauber.pagestest;

import com.qauber.config.Config;
import com.qauber.pagesresource.PageObjectModelResources;
import com.qauber.pagesresource.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * Created by jingx on 12/22/2016.
 */
public class SuperAdminDeleteEntity extends PageObjectModelResources {
    WebDriver driver;

    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
        setUpWithUser(User.UserType.SAU, driver);
    }

    @Test
    public void superAdminDeleteEntity() throws InterruptedException {
        int rowindex;
        String orgname = "org002";

        driver.get(Config.getBaseURL());
        Thread.sleep(10000);

        getLogin().loginToWave(getTestCaseUser().getUsername(), getTestCaseUser().getPassword());
        Thread.sleep(5000);

        getNavBar().entitiesButton().click();
        Thread.sleep(5000);

        // find the organization row index
        rowindex = getEntities().findEditOrganizationIndex(orgname);
        Thread.sleep(2000);


        // click the organization delete button;
        getEntities().deleteOrganizationButton(rowindex).click();
        Thread.sleep(2000);

        // click the cancel button
        driver.findElement(By.xpath("//button[text()='Cancel']")).click();
        Thread.sleep(2000);

        // click the organization delete button;
        getEntities().deleteOrganizationButton(rowindex).click();
        Thread.sleep(2000);

        // click the delete button
        driver.findElement(By.xpath("//button[text()='Delete']")).click();
        Thread.sleep(2000);

    }

    @AfterClass
    public void breakDown(){
        breakDownHelper(driver);
    }
}
