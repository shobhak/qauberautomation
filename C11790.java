package FirstRun;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

//TC: Verify the hamburger icon is functional https://bidqa.testrail.net/index.php?/cases/view/11790

public class C11790 {

    ChromeDriver driver = new ChromeDriver();

    @AfterMethod
    public void ShutDown() {

        //clearing cache
        driver.manage().deleteAllCookies();

        //closing Browser
        driver.quit();
    }

    @Test
public void HamburgerIcon() throws InterruptedException {

    //navigate to login page.
    driver.get("http://testwave.qabidder.net/#/page/login");
    Thread.sleep(4000);

    //login
    driver.findElement(By.id("exampleInputEmail1")).sendKeys("arkadiy.plekhanov@yahoo.com");
    driver.findElement(By.id("exampleInputPassword1")).sendKeys("qwerty123");
    driver.findElementByXPath("//button[@type='submit']").click();
    Thread.sleep(5000);

    //Clicking on element
    driver.findElementByXPath("//a[@class='hidden-xs']").click();
    Thread.sleep(5000);

    //Verifying element is functional and side menu is minimized.
    driver.findElementByXPath(("//body[@class='layout-fixed aside-collapsed']")).isDisplayed();
    }
}
