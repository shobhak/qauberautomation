package com.qauber.sanity;

import com.qauber.config.Config;
import com.qauber.pagesresource.PageObjectModelResources;
import com.qauber.pagesresource.User;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * Created by San Jose on 12/22/16.
 */
public class Create_Department_SAU extends PageObjectModelResources {

    WebDriver driver;
    int sleepTime;

    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
        sleepTime = 5000;
        setUpWithUser(User.UserType.SAU, driver); //pass userType and browser. see ~/QAUberTestConfig
        //setUpWithUser creates TestCaseUser, access with getTestCaseUser()
    }

    @Test
    public void createDepartmentSAU() throws InterruptedException {
        driver.get(Config.getBaseURL());
        Thread.sleep(sleepTime*2);

        getLogin().loginToWave(getTestCaseUser().getUsername(), getTestCaseUser().getPassword());
        Thread.sleep(sleepTime*2);

        //Code ↑ replaces commented code ↡

//        driver.get("http://testwave.qabidder.net/#/page/login");
//        Thread.sleep(10000);
//        WebElement searchField = driver.findElement(By.xpath("//*[@id=\"exampleInputEmail1\"]"));
//        searchField.clear();
//        searchField.sendKeys("ramazan@bigmir.net");
//        WebElement Password = driver.findElement(By.xpath("//*[@id=\"exampleInputPassword1\"]"));
//        Password.sendKeys("password");
//        WebElement Login = driver.findElement(By.xpath("//button[contains(@type,'submit')]"));
//        Login.click();
//        Thread.sleep(10000);


    //Following code: getNavBar -
        getNavBar().entitiesButton().click();
        Thread.sleep(sleepTime);
//        WebElement Entities = driver.findElement(By.xpath("//span[contains(.,'Entities')]"));
//        Entities.click();

        getEntities().addOrganizationButton().click();
        Thread.sleep(sleepTime);
//        WebElement Addsubdep = driver.findElement(By.xpath("html/body/div[2]/section/div/div/div/div/table/tbody/tr[2]/td[1]/a"));
//        Addsubdep.click();


      //Note that 'Add Department' works for both references...
        getEntities().addOrganizationButton().click();
        Thread.sleep(sleepTime);
//        WebElement Addsubdep1 = driver.findElement(By.xpath("html/body/div[2]/section/div/div/div/div/table/tbody/tr[2]/td[1]/a"));
//        Addsubdep1.click();

        //TODO: Rewrite the following code to use the Pages from our Page Object Model.

//        WebElement AddButDep1 = driver.findElement(By.xpath("//button[contains(@ng-show,'ctrl.userIsAble()')]"));
//        AddButDep1.click();
//        WebElement NameSubDep = driver.findElement(By.xpath("//input[contains(@required,'required')]"));
//        NameSubDep.sendKeys("Second_44 Department");
//        WebElement Create = driver.findElement(By.xpath("//button[contains(@ng-disabled,'error.required')]"));
//        Create.click();
//
//        Thread.sleep(5000);
//        String createdDepartmentName = driver.findElement(By.linkText("Second_44 Department")).getText();
//        Assert.assertEquals(createdDepartmentName, departmentName);
//


    }

    @AfterClass
    public void breakDown(){
        breakDownHelper(driver);
    }
    //        driver.quit();
}
