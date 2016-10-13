package FITWave;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

//Register a new account with organization. Verify E-mail sent.

public class VerifyRegistrationEmailSent {

    //Initializing Chrome
    ChromeDriver driver = new ChromeDriver();

    //Initializing Faker
    Faker faker = new Faker();

    @AfterMethod
    public void ShutDown() {

        //clearing cache
        driver.manage().deleteAllCookies();

        //closing Browser
        driver.quit();
    }

    @Test
    public void CreateUserWithEmail() throws InterruptedException {

        //Navigate to login page.
        driver.get("http://testwave.qabidder.net/#/page/login");
        Thread.sleep(5000);

        //Navigating to "Registration" page.
        driver.findElement(By.xpath("//a[contains(.,'Register Now')]")).click();
        Thread.sleep(3000);
        //Filling forms with valid data.
        driver.findElement(By.xpath("//input[@name='account_name']")).sendKeys(faker.name().fullName());
        String email = faker.internet().emailAddress();
        driver.findElement(By.xpath("//input[@name='account_email']")).sendKeys(email);
        String password = faker.internet().password(6, 10);
        driver.findElement(By.xpath("//input[@id='id-password']")).sendKeys(password);
        driver.findElement(By.xpath("//input[@name='account_password_confirm']")).sendKeys(password);

        //Navigating to "Company Registration" page.
        driver.findElement(By.xpath("//button[contains(.,'Continue registration')]")).click();
        Thread.sleep(7000);

        //Filling forms with valid data.
        driver.findElement(By.xpath("//input[@ng-model='reg.company.name']")).sendKeys(faker.company().name());
        driver.findElement(By.xpath("//input[@ng-model='reg.company.zip']")).sendKeys(faker.address().zipCode());
        driver.findElement(By.xpath("//input[@ng-model='reg.company.address1']")).sendKeys(faker.address().streetAddress());
        driver.findElement(By.xpath("//input[@ng-model='reg.company.city']")).sendKeys(faker.address().cityName());
        driver.findElement(By.xpath("//input[@ng-model='reg.company.phone']")).sendKeys(faker.phoneNumber().cellPhone());
        driver.findElement(By.xpath("//input[@ng-model='reg.company.email']")).sendKeys(email);
        driver.findElement(By.xpath("//textarea[@ng-model='reg.company.notes']")).sendKeys(faker.shakespeare().kingRichardIIIQuote());
        driver.findElement(By.xpath("//button[contains(.,'Finish registration')]")).click();
        Thread.sleep(7000);

        //Verifying if "Activation E-Mail sent" page opens.
        driver.findElement(By.xpath("//p[contains(.,'Activation E-Mail sent.')]")).isDisplayed();
    }
}
