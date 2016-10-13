package FirstRun;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

//TC: Verify "Add report" link is functional https://bidqa.testrail.net/index.php?/cases/view/11862
public class C11862 {

    ChromeDriver driver = new ChromeDriver();

    @AfterMethod
    public void ShutDown() {

        //clearing cache
        driver.manage().deleteAllCookies();

        //closing Browser
        driver.quit();
    }

    @Test
    public void VerifyAddReportPage() throws InterruptedException {

        //Navigate to login page
        driver.get("http://testwave.qabidder.net/#/page/login");
        Thread.sleep(3000);

        //Login
        driver.findElement(By.id("exampleInputEmail1")).sendKeys("arkadiy.plekhanov@yahoo.com");
        driver.findElement(By.id("exampleInputPassword1")).sendKeys("qwerty123");
        driver.findElementByXPath("//button[@type='submit']").click();
        Thread.sleep(3000);

        //Navigating to "Add Reports" page
        driver.findElementByXPath("//span[contains(.,'Add Report')]").click();
        Thread.sleep(2000);

        //Verifying if "Reports" page opens.
        if (driver.findElement(By.xpath("//h3[contains(.,'Creating Report')]")).isDisplayed()) {
            System.out.println("Passed");  }
        else {System.out.println( "Failed"); }
    }
}
