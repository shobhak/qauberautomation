import com.github.javafaker.Faker;
import com.qauber.config.Config;
import com.qauber.testrail.APIClientExtension;
import org.json.simple.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**Invalid login with email field filled and no password and clicking login
     * Created by sandhu on 11/7/16.
     *
     */
    public class SampleTestRailAPITestCase {

    //declare object to be shared between methods
    APIClientExtension testrailClient;
    int runid = Config.getRunID(); //Test Run ID (TestRail - Test Runs & Results - Automation)

    @BeforeClass
    public void setUp() {

        testrailClient = Config.testRailLogin();

    }

    @Test
    public void TestError() throws InterruptedException {

        //Create ChromeDriver to drive the browser
        ChromeDriver driver = new ChromeDriver();

        //initialization for test
        JSONObject resultsObject;
        int caseid = 69246; //Case ID from TestRail - Test Suites & Cases

        // maximize browser
        driver.manage().window().maximize();

        // Open URL
        driver.get("http://testwave.qabidder.net/#/page/login");
        // wait time
        Thread.sleep(3000);


        Faker faker = new Faker();

        //Find enter email and enter it using faker
        driver.findElement(By.xpath(".//*[@id='exampleInputEmail1']")).sendKeys(faker.internet().emailAddress());
        // Click on login button

        driver.findElement(By.xpath("//button[contains(.,'Login')]")).click();


        // This will capture error messages
        Thread.sleep(3000); //added by Erik
        String actual = driver.findElement(By.xpath("//span[@class='text-danger']")).getText();
        //wait time
        Thread.sleep(3000);
        // Store message in variable
        String expect = "This field is required";

        //  uncomment following line to check for Assert failure...
        actual = "THIS IS NOT THE STRING YOU'RE LOOKING FOR";

        try {
            Assert.assertEquals(actual, expect);
        } catch (AssertionError e) { //on fail, run this
            try {
                testrailClient.addResult(runid, caseid, 5, e.getLocalizedMessage(), "Tester's Computer");
                throw e; //Throwing AssertionError
            } catch (IllegalStateException g) {
                g.printStackTrace();
            }
        } catch (Exception e) {
            System.out.println("General Exception in assertEquals");
            e.printStackTrace();

        }

        //If Assert passes, send this to TestRail
        testrailClient.addResult(runid, caseid, 1, "Actual value = expected value", "Tester's Computer");

        Thread.sleep(3000);

        // Delete cookies
        driver.manage().deleteAllCookies();
        //Close browser
        driver.close();
        // Quit Browser
        driver.quit();
    }

//    @AfterClass
//            public void breakDown() {
//
//    }
}
