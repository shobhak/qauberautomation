package FITWave;

//Create organization. Modify number of users for subscription. Pay with Paypal. Verify successful payment.

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.openqa.selenium.interactions.Actions;

public class CreateOrganizationWithSubscription {
    ChromeDriver driver = new ChromeDriver();

    @AfterMethod
    public void ShutDown() {

        //clearing cache
        driver.manage().deleteAllCookies();

        //closing Browser
        driver.quit();
    }

@Test
    public void CreateOrganizationWIthSubscription() throws InterruptedException {

        //Navigate to login page
        driver.get("http://testwave.qabidder.net/#/page/login");
        Thread.sleep(7000);

        //Login
        driver.findElement(By.id("exampleInputEmail1")).sendKeys("arkadiy.plekhanov+33@gmail.com");
        driver.findElement(By.id("exampleInputPassword1")).sendKeys("qwerty123");
        driver.findElementByXPath("//button[@type='submit']").click();
        Thread.sleep(8000);

        //Navigating to "Entities" page
        driver.findElement(By.xpath("//span[contains(.,'Entities')]")).click();
        Thread.sleep(3000);

        //Opening [Add Organization] form.
        driver.findElement(By.xpath("//button[@ng-click='openAddOrgForm()']")).click();
        Thread.sleep(8000);

        //Enter text into Organization Name field.
        Faker faker = new Faker();
        driver.findElement(By.xpath("//input[@orgname='orgname']")).sendKeys(faker.company().name());

        //Enter numbers into phone # field.
        driver.findElement(By.xpath("//input[@ng-model='$ctrl.org.phone']")).sendKeys(faker.phoneNumber().cellPhone());

        //Enter E-Mail into Email field.
        driver.findElement(By.xpath("//input[@name='email']")).sendKeys("nospam@gmail.com");

        //Enter Zip code into Zip Code field.
        driver.findElement(By.xpath("//input[@name='zip']")).sendKeys(faker.address().zipCode());

        //Enter address into address field.
        driver.findElement(By.xpath("//input[@name='address1']")).sendKeys(faker.address().streetAddress());

        //Enter city name into city field.
        driver.findElement(By.xpath("//input[@name='city']")).sendKeys(faker.address().cityName());

        //Enter country name
        driver.findElement(By.xpath("//input[@name='country']")).sendKeys("USA");
        Thread.sleep(6000);

        //Enter state name
        driver.findElement(By.xpath("//option[@value='CA']")).click();
        Thread.sleep(7000);

        //Navigate to the next page
        driver.findElement(By.xpath("//button[@ng-click='$ctrl.nextStep()']")).click();
        Thread.sleep(6000);

        //Navigate to the next page
        driver.findElement(By.xpath("//button[@ng-click='$ctrl.nextStep()']")).click();
        Thread.sleep(6000);

        //Navigate to the next page
        driver.findElement(By.xpath("//button[@ng-click='$ctrl.nextStep()']")).click();
        Thread.sleep(6000);

        //Change subscription package to 22 using Action Class
        Actions action = new Actions(driver);
        WebElement subscription = driver.findElement(By.xpath("//div[@class='slider-handle min-slider-handle round']"));
        action.dragAndDropBy(subscription, 74, 0).perform();

        //Verifying if the slider's value is set to 22.
        if (driver.findElement(By.xpath("//div[@aria-valuenow='22']")).isDisplayed()) {
            System.out.println("Subscription quantity Set to 22");  }
        else {System.out.println( "Subscription quantity change failed"); }

        //Navigate to Paypal payment page
        driver.findElement(By.xpath("//button[@ng-click='$ctrl.nextStep()']")).click();
        Thread.sleep(4000);

        //Navigate to "Pay with existing Paypal account" page.
        driver.findElement(By.xpath("//input[@id='loadLogin']")).click();
        Thread.sleep(4000);

        //Enter registered account data.
        driver.findElement(By.xpath("//input[@id='login_email']")).sendKeys("arkadiy.plekhanov-buyer@gmail.com");
        driver.findElement(By.xpath("//input[@id='login_password']")).sendKeys("qwerty123");
        driver.findElement(By.xpath("//input[@id='submitLogin']")).click();
        Thread.sleep(8000);

        //Accept Paypal terms.
        driver.findElement(By.xpath("//input[@id='continue']")).click();
        Thread.sleep(3000);

        //Verify "Payment successful" page is loaded.
        driver.findElement(By.xpath("//div[contains(.,'Payment successful.')]")).isDisplayed();
    }
}

