package com.qauber.pagesresource;

import com.qauber.pages.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;


//Created by erikfriedlander on 12/17/16.

public class PageObjectModelResources {

    private WebDriver driver;
    private ConfigOOP config;
    private User testCaseUser;
    private UserFactory userFactory;

    //Pages before login
    private CompanyCreationSAU companyCreationSAU;
    private LoginPage login;
    private RegistrationPage1 registrationPage1;
    private RegistrationPage2 registrationPage2;

    //Pages/elements accessible from all pages
    private Header header;
    private NavBar navBar;
    private ProfilePanel profilePanel;
    private EditProfile editProfile;
    private SubscriptionSettings subscriptionSettings;

    //Navbar pages
    //    private Users users;
    private Entities entities;
    private EntitiesPermissionsDialog entitiesPermissionsDialog;
    private Users users;
    private UsersPermissionsDialog usersPermissionsDialog;
    private EditOrganizationPage editOrganizationPage;
    private Reports reports;
    private ReportsViewReport reportsViewReport;

    //Add reports pages
    private AddReportEnvironment addReportEnvironment;
    private AddReportIdentificationInformation addReportIdentificationInformation;
    private AddReportIdentifiersPage addReportIdentifiersPage;
    private AddReportNavigation addReportNavigation;
    private AddReportPhoto addReportPhoto;
    private AddReportsOrganization addReportOrganization;
    private AddReportSubjectInformationPage addReportSubjectInformationPage;
    private AddReportVehicle addReportVehicle;
    private AddReportPreview addReportPreview;
    private CreateSubsciption createSubsciption;
    private CreateOrganization createOrganization;

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
        this.config = new ConfigOOP();
        try {
            config = FileManager.getConfigObject(FileManager.getConfigFileName(), ConfigOOP.class);
            System.out.println(config.getBaseURL());
        } catch (IOException e) { //If config not found, do something
            System.out.println("Config not found, creating ~/QAUberTestConfig/config.txt");
            List<String> comments = Arrays.asList("Default config file", "Browser name needs to be capitalized. Options - CHROME, FIREFOX, SAFARI, EDGE", "BaseURL should be in form of http://www.website.com", "We go");
            FileManager.writeConfigObject(new ConfigOOP(), FileManager.getConfigFileName(), comments);
        } catch (Exception e) { //if config invalid, do something else - TODO: generate config?
            System.out.println("Invalid config or other exception, recreating ~/QAUberTestConfig/config.txt");
            List<String> comments = Arrays.asList("INVALID CONFIG FOUND, overwriting with defaults.", "Default config file", "Browser name needs to be capitalized. Options - CHROME, FIREFOX, SAFARI, EDGE", "It's off to work", "We go");
            FileManager.writeConfigObject(new ConfigOOP(), FileManager.getConfigFileName(), comments);
        }
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

    public void setUpScript(ConfigOOP config) {
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

        //Set page references
        companyCreationSAU = new CompanyCreationSAU(driver);
        login = new LoginPage(driver);
        registrationPage1 = new RegistrationPage1(driver);
        registrationPage2 = new RegistrationPage2(driver);
        header = new Header(driver);
        navBar = new NavBar(driver);
        profilePanel = new ProfilePanel(driver);
        editProfile = new EditProfile(driver);
        subscriptionSettings = new SubscriptionSettings(driver);

        entities = new Entities(driver);
        entitiesPermissionsDialog = new EntitiesPermissionsDialog(driver);
        users = new Users(driver);
        usersPermissionsDialog = new UsersPermissionsDialog(driver);
        editOrganizationPage = new EditOrganizationPage(driver);
        createOrganization = new CreateOrganization(driver);

        reports = new Reports(driver);
        reportsViewReport = new ReportsViewReport(driver);

        addReportEnvironment = new AddReportEnvironment(driver);
        addReportIdentificationInformation = new AddReportIdentificationInformation(driver);
        addReportIdentifiersPage = new AddReportIdentifiersPage(driver);
        addReportNavigation = new AddReportNavigation(driver);
        addReportPhoto = new AddReportPhoto(driver);
        addReportOrganization = new AddReportsOrganization(driver);
        addReportSubjectInformationPage = new AddReportSubjectInformationPage(driver);
        addReportVehicle = new AddReportVehicle(driver);
        addReportPreview = new AddReportPreview(driver);
        createSubsciption = new CreateSubsciption(driver);
        createOrganization = new CreateOrganization(driver);

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

    //get Page Object Model Resources

    protected WebDriver getDriver() { //visible from subclasses, not public OR private
        return driver;
    }

    protected CompanyCreationSAU getCompanyCreationSAU(){ return companyCreationSAU;}

    protected LoginPage getLogin() {
        return login;
    }



    protected Header getHeader() { return header; }

    protected RegistrationPage1 getRegistrationPage1() { return registrationPage1; }
    protected RegistrationPage2 getRegistrationPage2() { return registrationPage2; }

    protected NavBar getNavBar() {
        return navBar;
    }

    protected ProfilePanel getProfilePanel() {
        return profilePanel;
    }

    protected EditProfile getEditProfile() {
        return editProfile;
    }

    protected SubscriptionSettings getSubscriptionSettings() {return subscriptionSettings;}

    protected Entities getEntities() {return entities;}

    protected EntitiesPermissionsDialog getEntitiesPermissionsDialog() {return entitiesPermissionsDialog;}

    protected Users getUsers() {return users;}

    protected UsersPermissionsDialog getUsersPermissionsDialog() {return usersPermissionsDialog;}

    protected EditOrganizationPage getOrganization() {return  editOrganizationPage;}

    protected CreateOrganization getCreateOrganization() { return createOrganization;}

    protected Reports getReports() {
        return reports;
    }

    protected ReportsViewReport getReportsViewReport() {return reportsViewReport; }

    protected AddReportEnvironment getAddReportEnvironment() {
        return addReportEnvironment;
    }

    protected AddReportIdentificationInformation getAddReportIdentificationInformation() {
        return addReportIdentificationInformation;
    }

    protected AddReportIdentifiersPage getAddReportIdentifiersPage() {
        return addReportIdentifiersPage;
    }

    protected AddReportNavigation getAddReportNavigation() {
        return addReportNavigation;
    }

    protected AddReportPhoto getAddReportPhoto() {
        return addReportPhoto;
    }

    protected AddReportsOrganization getAddReportOrganization() {
        return addReportOrganization;
    }

    protected AddReportSubjectInformationPage getAddReportSubjectInformationPage() {
        return addReportSubjectInformationPage;
    }

    protected AddReportVehicle getAddReportVehicle() {
        return addReportVehicle;
    }

    protected AddReportPreview getAddReportPreview() { return addReportPreview; }

    protected  CreateSubsciption getCreateSubsciption() {return createSubsciption;}

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
