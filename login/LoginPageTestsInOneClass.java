package com.qauber.login;

        import com.github.javafaker.Faker;
        import org.openqa.selenium.By;
        import org.openqa.selenium.WebDriver;
        import org.openqa.selenium.chrome.ChromeDriver;
        import org.testng.Assert;
        import org.testng.annotations.AfterMethod;
        import org.testng.annotations.BeforeMethod;
        import org.testng.annotations.Test;
        import java.util.Random;
        import java.util.concurrent.TimeUnit;

//If Scripts Will be fail in your computer increase " Thread.sleep()"  !!!

public class LoginPageTestsInOneClass {
    public WebDriver driver;

    //Assignments
    Faker faker = new Faker();
    Random rand = new Random();
    String actualResult = "";
    //Assignment for random email
    public String email = randL(8) + "@mailinator.com";
    //Assignment for random password with lower and upper case
    public  String pw = randLU(9);
    //Assignment for wrongFormattedEmailAddress
    public  String wrongFormattedEmailAd = randLUNS(7);

    //setUp driver before every test
    @BeforeMethod
    public void setUp() {

        //Show the Path Your ChromeDriver!
        System.setProperty("webdriver.chrome.driver", "/home/automation/Desktop/drivers/chromedriver");

                //
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

        //Quits driver after every test
    }
    @AfterMethod
    public void tearDown(){
        // cleans all cookies and quits
        driver.manage().deleteAllCookies();
        driver.quit();
    }
    //Testing User Able to Register And login to his/her Account.
    @Test(priority = 1)
    public void registrationAndLoginWithValidCredentials() throws InterruptedException {

        String parentHandle = driver.getWindowHandle();
        // Navigate to URL

        driver.get("http://testwave.qabidder.net/#/page/login");
        Thread.sleep(6000);

        // Click "Register Now" Button
        driver.findElement(By.xpath("//a[@ui-sref='page.register-sa']")).click();
        Thread.sleep(5000);

        //To fill "Name"  field .
        driver.findElement(By.xpath("//input[@autocomplete='off']")).sendKeys(faker.name().fullName());

        //Add "Email"
        email = rand.nextInt(1000) + email;
        driver.findElement(By.xpath("//input[@name='account_email']")).sendKeys(email);

        //Type "Password"
        driver.findElement(By.xpath("//input[@id='id-password']")).sendKeys(pw);

        //Type password in "Confirm password" field
        driver.findElement(By.xpath("//input[@name='account_password_confirm']")).sendKeys(pw);

        // Click "Continue registration"
        driver.findElement(By.xpath("//button[contains(.,'Continue registration')]")).click();
        Thread.sleep(3000);

        // Type "Organization Name"
        driver.findElement(By.xpath("//input[@ng-model='reg.company.name']")).sendKeys(faker.company().name());

        //Type "Address"
        driver.findElement(By.xpath("//input[@name='address1']")).sendKeys(faker.address().streetAddress());

        //Type "City"
        driver.findElement(By.xpath("//input[@name='city']")).sendKeys(faker.address().cityName());

        // Type "C" in "State" field
        driver.findElement(By.xpath("//select[contains(@name,'state')]")).sendKeys("CA");

        //Add "Zip code"
        driver.findElement(By.xpath("//input[contains(@name,'zip')]")).sendKeys("12345");

        //Add "Phone"
        driver.findElement(By.xpath("//input[contains(@name,'phone')]")).sendKeys("1234567891");

        //Add "email"
        driver.findElement(By.xpath("//input[@name='email']")).sendKeys(email);
        Thread.sleep(3000);

        //Clicks "Finish Registration"
        driver.findElement(By.xpath("//button[contains(.,'Finish registration')]")).click();
        Thread.sleep(4000);

        //Goes on www.mailinator.com
        driver.get("https://www.mailinator.com");

        // Types Mailname in "Mail" field
        driver.findElement(By.xpath("//input[@id='inboxfield']")).sendKeys(email);

        //Clicks "Go" button
        driver.findElement(By.xpath("//button[@class='btn btn-dark']")).click();
        Thread.sleep(5000);

        //Clicks on activation letter
        driver.findElement(By.xpath("//div[contains(@style,'height:100%;')]")).click();
        Thread.sleep(3000);

        //Switchs frame
        driver.switchTo().frame("publicshowmaildivcontent");

        //Clicks on the link
        driver.findElement(By.xpath("//a[@rel='nofollow']")).click();
        Thread.sleep(10000);
        //changes window
        for (String winHandle : driver.getWindowHandles()) {
            driver.switchTo().window(winHandle);
        }
        driver.close();

        // change to your previous window
        driver.switchTo().window(parentHandle);

        //Come back on parentHandle window
        //Go on www.testwave.qabidder.net/#/page/login
        driver.get("http://testwave.qabidder.net/#/page/login");
        Thread.sleep(6000);

        //Add registered email for Email Field
        driver.findElement(By.xpath("//input[@id='exampleInputEmail1']")).sendKeys(email);

        //Add  registered "Password"
        driver.findElement(By.xpath("//input[@id='exampleInputPassword1']")).sendKeys(pw);

        // Click "Login"
        driver.findElement(By.xpath("//button[@class='btn btn-block btn-primary mt-lg']")).click();
        Thread.sleep(5000);
    }

    // Verify unregistered users is not able to login
    @Test(priority = 2)
    public void loginWithUnRegisteredEmailAddressIAndWrongPassword()throws InterruptedException {

        //navigate to login page
        driver.get("http://testwave.qabidder.net/#/pagLoe/login");
        Thread.sleep(10000);

        //find Email address and put random email
        driver.findElement(By.xpath("//input[@id='exampleInputEmail1']")).sendKeys(faker.internet().emailAddress());

        //To Create random Password data
        String UnregisteredPassWord = randLU(7);

        // to put Unregistered Pasword
        driver.findElement(By.xpath("//input[@id='exampleInputPassword1']")).sendKeys(UnregisteredPassWord);

        //Click login button
        driver.findElement(By.xpath("//button[@class='btn btn-block btn-primary mt-lg']")).click();
        Thread.sleep(5000);

        // To check error message
        actualResult = driver.findElement(By.xpath("//div[@class='alert alert-danger text-center ng-binding']")).getText();
        Assert.assertEquals(actualResult,"Please make sure your email and password are correct.");
    }
    // to test with Registered Email and Unregistered Password
    @Test(priority = 3)
    public void loginWithRegisteredEmailAddressUnregisteredPassword()throws InterruptedException {

        // Go to login page
        driver.get("http://testwave.qabidder.net/#/page/login");
        Thread.sleep(6000);

        //Put  Registered Email
        driver.findElement(By.xpath("//input[@id='exampleInputEmail1']")).sendKeys(email);

        // create Random Password
        String invalidPasWord = randLU(9);

        //Fill password field
        driver.findElement(By.xpath("//input[@id='exampleInputPassword1']")).sendKeys(invalidPasWord);

        //Click login Button
        driver.findElement(By.xpath("//button[@class='btn btn-block btn-primary mt-lg']")).click();
        Thread.sleep(5000);

        // To check error message
        actualResult = driver.findElement(By.xpath("//div[@class='alert alert-danger text-center ng-binding']")).getText();

        Assert.assertEquals(actualResult,"Please make sure your email and password are correct.");
    }
    //Verify user not able login with registered email and password. Software displays error message.
    @Test(priority = 4)
    public void loginWithUnRegisteredEmailAddressAndRegisteredPassword()throws InterruptedException{

        // goes to login page
        driver.get("http://testwave.qabidder.net/#/page/login");
        Thread.sleep(6000);

        //puts fake internet password
        driver.findElement(By.xpath("//input[@id='exampleInputEmail1']")).sendKeys(faker.internet().emailAddress());

        //puts already registered password
        driver.findElement(By.xpath("//input[@id='exampleInputPassword1']")).sendKeys(pw);

        //Click login button
        driver.findElement(By.xpath("//button[@class='btn btn-block btn-primary mt-lg']")).click();
        Thread.sleep(6000);

        // To check error message
        actualResult = driver.findElement(By.xpath("//div[@class='alert alert-danger text-center ng-binding']")).getText();
        Assert.assertEquals(actualResult,"Please make sure your email and password are correct.");
    }
    @Test(priority = 5)
    public void loginPageEmailFieldWrongFormattedEmailAddress()throws  InterruptedException{

        // goes to login page
        driver.get("http://testwave.qabidder.net/#/page/login");
        Thread.sleep(6000);

        // puts wrong formatted email adress
        driver.findElement(By.xpath("//input[@id='exampleInputEmail1']")).sendKeys(wrongFormattedEmailAd);

        //puts Registered email addresss
        driver.findElement(By.xpath("//input[@id='exampleInputPassword1']")).sendKeys(pw);
        //Clicks login button
        driver.findElement(By.xpath("//button[@class='btn btn-block btn-primary mt-lg']")).click();
        Thread.sleep(6000);

        //checks error message
        actualResult = driver.findElement(By.xpath("//span[contains(.,'Please enter a valid email address')]")).getText();
        Assert.assertEquals(actualResult,"Please enter a valid email address");
    }
    //Testing Login With Valid Email Address and Empty Password Field
    @Test(priority = 6)
    public void loginValidEmailAdrAndEmptyPassW()throws InterruptedException{

        //Goes login page
        driver.get("http://testwave.qabidder.net/#/page/login");
        Thread.sleep(6000);

        // Email Field Inputs
        driver.findElement(By.xpath("//input[@id='exampleInputEmail1']")).sendKeys(faker.internet().emailAddress());

        //Clicking Login Button
        driver.findElement(By.xpath("//button[@class='btn btn-block btn-primary mt-lg']")).click();
        Thread.sleep(5000);

        //Assigning actualResult
        actualResult = driver.findElement(By.xpath("//span[contains(@ng-show,'password.$error.required')]")).getText();
        //Assertion actualResult with specified text
        Assert.assertEquals(actualResult,"This field is required");
    }
    //Testing Software displays error message for valid login input  and  empty email field.
    @Test(priority = 7)
    public void loginValidPassWordAndEmptyEmailAddress()throws InterruptedException{
        // Goes to login page
        driver.get("http://testwave.qabidder.net/#/page/login");
        Thread.sleep(6000);

        // password inputs
        driver.findElement(By.xpath("//input[@id='exampleInputPassword1']")).sendKeys(faker.internet().password());

        //Clicking LoginButton
        driver.findElement(By.xpath("//button[@class='btn btn-block btn-primary mt-lg']")).click();
        Thread.sleep(5000);

        //Assertion Actual result with expected;
        actualResult = driver.findElement(By.xpath("//span[contains(@ng-show,'email.$error.required')]")).getText();
        Assert.assertEquals(actualResult,"This field is required");
    }

    // Testing Software doesn't log out user when he click  " Go Back" button
    @Test(priority = 8 )
    public void verifyGoingBackDoesNotLogYouOut() throws InterruptedException {

        //open log in page
        driver.get("http://testwave.qabidder.net/#/page/login");

        //wait to load
        Thread.sleep(3000);

        //clear email field
        driver.findElement(By.name("account_email")).clear();

        //enter email
        driver.findElement(By.name("account_email")).sendKeys(email);

        //clear password field
        driver.findElement(By.name("account_password")).clear();

        //enter password
        driver.findElement(By.name("account_password")).sendKeys(pw);

        //click log in
        driver.findElement(By.xpath("//button[contains(text(),'Login')]")).click();

        //wait to load
        Thread.sleep(3000);

        //clicking navigate back
        driver.navigate().back();

        //wait to back up
        Thread.sleep(3000);

        //clicking navigate forward
        driver.navigate().forward();

        //checking for the h3 "Reports"
        boolean reports = driver.findElement(By.xpath("//*[contains(text(),'Reports')]")).isDisplayed();

        Assert.assertEquals(reports, true);
    }





    //TOOLS LIBRARY

    //  random string with Lower, Upper, Numbers, Special characters

    public String randLUNS(int size) {
        StringBuilder ret = new StringBuilder();
        Random r = new Random();

        for (int i = 0; i < size; i++) {
            ret.append((char) (33 + r.nextInt(94)));
        }
        return ret.toString();
    }

    //random string with Lower, Upper
    public String randLU(int size) {
        StringBuilder ret = new StringBuilder();
        Random r = new Random();
        int rand;

        for (int i = 0; i < size; i++) {
            rand = 97 + r.nextInt(26);
            if (r.nextBoolean()) {
                rand -= 32;
            }
            ret.append((char) rand);
        }
        return ret.toString();
    }

    //random string with Lower
    public String randL(int size) {
        StringBuilder ret = new StringBuilder();
        Random r = new Random();
        int rand;

        for (int i = 0; i < size; i++) {
            rand = 97 + r.nextInt(26);
            ret.append((char) rand);
        }
        return ret.toString();
    }

    //random string with Numbers
    public String randN(int size) {
        StringBuilder ret = new StringBuilder();
        Random r = new Random();

        for (int i = 0; i < size; i++) {
            ret.append(r.nextInt(10));
        }
        return ret.toString();
    }


}
