import com.github.javafaker.Faker;
import com.qauber.config.Config;
import com.qauber.testrail.APIClientExtension;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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

public class SampleTestRailAPITestCaseLog4J2 {

    private static final Logger logger = LogManager.getLogger(SampleTestRailAPITestCaseLog4J2.class);

    //declare object to be shared between methods
    APIClientExtension testrailClient;
    int runid;

    @BeforeClass
    public void setUp() {

        logger.info("setUp");
        testrailClient = Config.testRailLogin();
        runid = Config.getRunID(); //Test Run ID (TestRail - Test Runs & Results - Automation)
        logger.info("setUp done");
    }

    @Test
    public void TestError() throws InterruptedException {
        int caseid = 69246; //Case ID from TestRail - Test Suites & Cases

        logger.info("starting Test \"Invalid login with email field filled and no password and clicking login\"");
        //Create ChromeDriver to drive the browser
        ChromeDriver driver = new ChromeDriver();

        //initialization for test
        JSONObject resultsObject;


        // maximize browser
        driver.manage().window().maximize();

        // Open URL
        driver.get("http://testwave.qabidder.net/#/page/login");
        // wait time
        Thread.sleep(3000);


        Faker faker = new Faker();
        logger.info("faker faker faker faker");

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

        logger.info("ok, let's assert - test if login attempt with empty email field fails and displays validation");

        try {
            Assert.assertEquals(actual, expect);
        } catch (AssertionError e) { //on fail, run this
            try {
                logger.info("Assertion Failed: ", e);
                testrailClient.addResult(runid, caseid, 5, e.getLocalizedMessage(), "Tester's Computer");
                throw e; //Throwing AssertionError
            } catch (IllegalStateException g) {
                logger.error("IllegalStateException ", g);
            }
        } catch (Exception e) {
            logger.error("General Exception in assertEquals", e);
            e.printStackTrace();

        }

        //If Assert passes, send this to TestRail
        logger.info("assert successful, let's upload to testrail");
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
