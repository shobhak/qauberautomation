import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

/**
 * Created by San Jose on 12/13/2016.
 */
public class Create_Department_SAU {

    String departmentName = "Second_1 Department";



    @Test
    public void SAU() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("http://testwave.qabidder.net/#/page/login");

        Thread.sleep(5000);
        WebElement searchField = driver.findElement(By.xpath("//*[@id=\"exampleInputEmail1\"]"));
        searchField.clear();
        searchField.sendKeys("ramazan@bigmir.net");

        WebElement Password = driver.findElement(By.xpath("//*[@id=\"exampleInputPassword1\"]"));
        Password.sendKeys("password");
        Thread.sleep(5000);
        WebElement Login = driver.findElement(By.xpath("//button[contains(@type,'submit')]"));
        Login.click();

        Thread.sleep(5000);
        WebElement Entities = driver.findElement(By.xpath("//span[contains(.,'Entities')]"));
        Entities.click();

        Thread.sleep(5000);
        WebElement organization = driver.findElement(By.xpath("html/body/div[2]/section/div/div/div/div/table/tbody/tr[2]/td[1]/a"));
        organization.click();
        Thread.sleep(10000);
        WebElement Add = driver.findElement(By.xpath("//button[contains(@ng-show,'ctrl.userIsAble()')]"));
        Add.click();

        WebElement NameDep=driver.findElement(By.xpath("//input[contains(@required,'required')]"));
        NameDep.sendKeys("Second_1 Department");
        WebElement Create=driver.findElement(By.xpath("//button[contains(@ng-disabled,'error.required')]"));
        Create.click();

        Thread.sleep(5000);
        String createdDepartmentName = driver.findElement(By.linkText("Second_1 Department")).getText();
        Assert.assertEquals(createdDepartmentName, departmentName);


        driver.quit();


    }
}
