package mypackage;


import java.io.File;
import java.io.IOException;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WaveFit_Registration {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver" , "C:/Users/Divya/Drivers/chromedriver_win32/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		//Step1.Open http://qabidder.net/fits-alfa/#/page/login
		
        String baseUrl = "http://qabidder.net/fits-alfa/#/page/login";
        String expectedTitle = "FITS - FITS Web Application";
        Thread.sleep(3000);
        String actualTitle = "";

        // launch Firefox and direct it to the Base URL
        driver.get(baseUrl);

        // get the actual value of the title
        actualTitle = driver.getTitle();

        /*
         * compare the actual title of the page witht the expected one and print
         * the result as "Passed" or "Failed"
         */
        if (actualTitle.contentEquals(expectedTitle)){
            System.out.println("Test Passed!");
        } else {
            System.out.println("Test Failed");
        }
       
        //Step2.Click on Register button
        driver.manage().window().maximize();
        Thread.sleep(3000);
        driver.findElement(By.xpath("/html/body/div[2]/div/div/div[1]/div[2]/a")).click();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
       
        // WebDriverWait wait = new WebDriverWait(driver,60);
        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("page.register-sa")));
        
        //Step3.Enter Name in Register page
         WebElement Name = driver.findElement(By.xpath("html/body/div[2]/div/div/div[1]/div/div[2]/form/div[1]/input"));
         Name.clear();
         Name.sendKeys("Komal_Sharma");
       
         
         //Step4.Enter Email in Register page
         Random rand = new Random();
         int  n = rand.nextInt(1000) + 5;
        
         WebElement Email = driver.findElement(By.xpath("html/body/div[2]/div/div/div[1]/div/div[2]/form/div[2]/input"));
         Email.clear();
         //Email.sendKeys("divyaSharma10"+ n);
         Email.sendKeys("dsharma1410" +n+"@gmail.com");
         System.out.println("Passed");
         
        
         
         //Step5. Enter Password in Register Page
         WebElement Password = driver.findElement(By.id("id-password"));
         Password.clear();
         Password.sendKeys("Abcdefgh1");
         System.out.println("Password Passed");
         
         //Step6. Reenter password in Register Page
         WebElement RePassword = driver.findElement(By.name("account_password_confirm"));
         RePassword.clear();
         RePassword.sendKeys("Abcdefgh1");
         System.out.println("RePassword Passed");
         
         //Step7. Click on Continue registration
         driver.manage().window().maximize();
         Thread.sleep(2000);
         driver.findElement(By.xpath("/html/body/div[2]/div/div/div[1]/div/div[2]/form/button")).click();
         driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
         
        
        //Step8. Enter Organization Name     	
        driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[2]/div[1]/div[1]/div/div/input")).sendKeys("Bare_Company");
        System.out.println("Company Name passed");
         
        //Step9. Enter Zip Code
        driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[2]/div[2]/div[1]/div[1]/div/input")).sendKeys("95051");
        System.out.println("Zip Code successfully enter");
         
        //Step10. Enter Address(1)
        driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[2]/div[2]/div[1]/div[2]/div/input")).sendKeys("3560 poinciana drive");
        System.out.println("Address 1 Successfully Enter");
        
        //Step11. Enter Address(2)
        driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[2]/div[2]/div[1]/div[3]/div/input")).sendKeys("3570 flora vista");
        System.out.println("Address 2 Add Successfully");
        
        //Step12. Enter City
        driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[2]/div[2]/div[1]/div[4]/div/input")).sendKeys("Santa clara");
        System.out.println("Successfully added City" ); 
        
        //Step13. Enter Phone Number
        driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[2]/div[1]/div[2]/div/div/input")).sendKeys("408-234-5432");
        System.out.println("Phone Number Successfully Enter");
        
        //Step14. Enter Email address
        driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[2]/div[1]/div[3]/div/div/input")).sendKeys("dsharma1410@gmail.com");
        System.out.println("Email Address eneter successfully");
        
        //Step15. Add Note to Notes
        driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[2]/div[2]/div[2]/div/div/textarea")).sendKeys("A journey of a thousand miles begins with a single step");
        System.out.println("Notes successfully added");
        
        //Step16. Click on Finish Registration
        driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[3]/button")).click();
        System.out.println("User Successfully register");
        Thread.sleep(3000);
        
        
        //Step17. Take a screenshot of the result
        File scr = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        try {
         FileUtils.copyFile(scr, new File("C:/Users/Divya/Desktop/Automation_Screenshot" +n+".jpg"));
        } catch (IOException e) {
         e.printStackTrace();
        }
        
        String registration= driver.findElement(By.xpath("/html/body/div[2]/div/div/ul/li[3]/a")).getText();
        if(registration == "Login");
        { 
       	 System.out.println("Test Passed");
        
   	 }
        
        
        
	}
	


	}


