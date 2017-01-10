package com.qauber.pagesresource;

import com.qauber.pages.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.util.concurrent.TimeUnit;


//Created by erikfriedlander on 12/17/16.

public class PageObjectModelResources {

    private WebDriver driver;
    private ConfigOOP config;
    private User testCaseUser;
    private UserFactory userFactory;
    private PageResources pages;

    //Preconditions
    private PreconditionsResources preconditionsResources;

    //Constructor
    public PageObjectModelResources() {
        setUpWithConfigFile();
    }

    /*
        Read ConfigOOP object from config file in ~/QAUberTestConfig. If config file not found or invalid, create a new one using defaults in ConfigOOP constructor.

         */
    protected void setUpWithConfigFile() {
        this.config = ConfigHelper.getConfigFile();
    }

    public void setUpUser(User.UserType userType) {
        userFactory = new UserFactory();
        testCaseUser = userFactory.getUser(userType);
    }

    @Deprecated
    public void setUpWithUser(User.UserType userType, WebDriver webDriver) {
        //get user information
        userFactory = new UserFactory();
        testCaseUser = userFactory.getUser(userType);
        System.out.println(testCaseUser.getUsername());
        System.out.println(testCaseUser.getPassword());

        setUpScript(webDriver);
    }

    private WebDriver chooseDriver(ConfigOOP.BrowserType browserType) {
        if (browserType == ConfigOOP.BrowserType.CHROME) {
            return new ChromeDriver();
        } else if (browserType == ConfigOOP.BrowserType.SAFARI) {
            return new SafariDriver();
        } else if (browserType == ConfigOOP.BrowserType.FIREFOX) {
            return new FirefoxDriver();
        } else {
            return new EdgeDriver(); //(browserType == BrowserType.EDGE)
        }
    }

    @Deprecated
    public void setUpWithConfig(ConfigOOP config) {
        //get user information
        testCaseUser = new User(config);
        System.out.println(testCaseUser.getUsername());
        System.out.println(testCaseUser.getPassword());
        setUpScript(chooseDriver(config)); //call setUpScript with WebDriver from config

    }

    public void setUpScript() {
        setUpScript(testConfig());
    }

    private void setUpScript(ConfigOOP config) {
        driver = chooseDriver(config.getBrowserType());
        //implicit wait
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //maximize window for our viewing pleasure
        driver.manage().window().maximize();

        try {
            Thread.sleep(3000); //TODO: is this necessary?
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        ////////////////// Done managing WebDriver
        setUpScript(driver);
    }

    @Deprecated //we don't want to pass in driver anymore
    public void setUpScript(WebDriver driver) {
        // Choose web browser/driver from Config

        //implicit wait
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //maximize window for our viewing pleasure
        driver.manage().window().maximize();

        ////////////////// Done managing WebDriver

        //Get page resources
        pages = PageResourcesFactory.getPageResources(driver);

        //Preconditions
        preconditionsResources = new PreconditionsResources(driver);

    }

    public void breakDownHelper() {
        driver.manage().deleteAllCookies();
        driver.quit();
    }

    @Deprecated
    public void breakDownHelper(WebDriver driver) {
        driver.manage().deleteAllCookies();
        driver.quit();
    }


    private WebDriver chooseDriver(ConfigOOP argConfig) { // Choose web browser/driver from Config
        if (argConfig.getBrowserType() == ConfigOOP.BrowserType.FIREFOX) {
            return new FirefoxDriver();
        }
        else if (argConfig.getBrowserType() == ConfigOOP.BrowserType.EDGE) {
            return new EdgeDriver();
        }
        else if (argConfig.getBrowserType() == ConfigOOP.BrowserType.SAFARI) {
            return new SafariDriver();
        } else {
            return new ChromeDriver(); //don't touch my enum
        }
    }

    ///////GET ALL TEST CASE RESOURCES
    protected WebDriver getDriver() { //visible from subclasses, not public OR private
        return driver;
    }


    //We should eventually replace below with .

    protected LoginPage getLogin() { return pages.getLogin(); }

    protected Header getHeader() { return pages.getHeader(); }

    protected RegistrationPage1 getRegistrationPage1() { return pages.getRegistrationPage1(); }
    protected RegistrationPage2 getRegistrationPage2() { return pages.getRegistrationPage2(); }

    protected NavBar getNavBar() { return pages.getNavBar(); }

    protected ProfilePanel getProfilePanel() { return pages.getProfilePanel(); }

    protected EditProfile getEditProfile() { return pages.getEditProfile(); }

    protected SubscriptionSettings getSubscriptionSettings() {return pages.getSubscriptionSettings();}

    protected Entities getEntities() {return pages.getEntities();}

    protected EntitiesPermissionsDialog getEntitiesPermissionsDialog() {return pages.getEntitiesPermissionsDialog();}

    protected Users getUsers() {return pages.getUsers();}

    protected UsersPermissionsDialog getUsersPermissionsDialog() {return pages.getUsersPermissionsDialog();}

    protected EditOrganizationPage getOrganization() {return pages.getEditOrganizationPage();}

    protected CreateOrganization getCreateOrganization() { return pages.getCreateOrganization();}

    protected Reports getReports() {
        return pages.getReports();
    }

    protected ReportsViewReport getReportsViewReport() {return pages.getReportsViewReport(); }

    protected AddReportEnvironment getAddReportEnvironment() {
        return pages.getAddReportEnvironment();
    }

    protected AddReportIdentificationInformation getAddReportIdentificationInformation() {
        return pages.getAddReportIdentificationInformation();
    }

    protected AddReportIdentifiersPage getAddReportIdentifiersPage() {
        return pages.getAddReportIdentifiersPage();
    }

    protected AddReportNavigation getAddReportNavigation() {
        return pages.getAddReportNavigation();
    }

    protected AddReportPhoto getAddReportPhoto() {
        return pages.getAddReportPhoto();
    }

    protected AddReportsOrganization getAddReportOrganization() {
        return pages.getAddReportOrganization();
    }

    protected AddReportSubjectInformationPage getAddReportSubjectInformationPage() {
        return pages.getAddReportSubjectInformationPage();
    }

    protected AddReportVehicle getAddReportVehicle() {
        return pages.getAddReportVehicle();
    }

    protected AddReportPreview getAddReportPreview() { return pages.getAddReportPreview(); }

    protected  CreateSubsciption getCreateSubsciption() {return pages.getCreateSubsciption();}

    @Deprecated //TODO: move into helper method
    protected CompanyCreationSAU getCompanyCreationSAU(){ return pages.getCompanyCreationSAU(); }

    //Users preconditions
    protected PreconditionsResources getPreconditions() { return preconditionsResources; }

    //Test Resources - testDriver, testUser, testConfig //TODO: rename? (getTestConfig, etc....) probably not
    protected WebDriver testDriver() {
        return driver;
    }
    protected ConfigOOP testConfig () { return config; }
    protected User testUser() {
        return testCaseUser;
    }
}
