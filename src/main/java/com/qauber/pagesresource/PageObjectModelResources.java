package com.qauber.pagesresource;

import com.qauber.pages.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.util.concurrent.TimeUnit;

/**
 * Created by erikfriedlander on 12/17/16.
 */
public class PageObjectModelResources {

    private WebDriver driver;
    private User testCaseUser;
    private UserFactory userFactory;

//Pages before login
    private LoginPage login;
    private RegistrationPage1 registrationPage1;
    private RegistrationPage2 registrationPage2;

//Pages/elements accessible from all pages
    private Header header;
    private NavBar navBar;
    private ProfilePanel profilePanel;
    private EditProfile editProfile;

//Navbar pages
    //    private Users users;
    private Entities entities;
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
    private CreateSubsciption createSubsciption;


//

    public void setUpWithUser(User.UserType userType, WebDriver webDriver) {
        //get user information
        userFactory = new UserFactory();
        testCaseUser = userFactory.getUser(userType);
        System.out.println(testCaseUser.getUsername());
        System.out.println(testCaseUser.getPassword());

        setUpScript(webDriver);
    }

    public void setUpWithConfig(ConfigOOP config) {
        //get user information
        testCaseUser = new User(config);
        System.out.println(testCaseUser.getUsername());
        System.out.println(testCaseUser.getPassword());
        setUpScript(chooseDriver(config)); //call setUpScript with WebDriver from config

    }

    public void setUpScript(WebDriver driver) {
        // Choose web browser/driver from Config

        //implicit wait
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //maximize window for our viewing pleasure
        driver.manage().window().maximize();

        ////////////////// Done managing WebDriver

        //Set page references
        login = new LoginPage(driver);
        registrationPage1 = new RegistrationPage1(driver);
        registrationPage2 = new RegistrationPage2(driver);
        header = new Header(driver);
        navBar = new NavBar(driver);
        profilePanel = new ProfilePanel(driver);
        editProfile = new EditProfile(driver);

        entities = new Entities(driver);
        editOrganizationPage = new EditOrganizationPage(driver);
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
        createSubsciption = new CreateSubsciption(driver);

    }

    public void breakDownHelper() {
        driver.manage().deleteAllCookies();
        driver.quit();
    }

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

    protected Entities getEntities() {
        return entities;
    }

    protected EditOrganizationPage getOrganization() {return  editOrganizationPage;}

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

    protected  CreateSubsciption getCreateSubsciption() {return createSubsciption;}


    //

    //TODO: implement chooseUser (this will affect config.user) - may have been done already with User and UserFactory
    protected User getTestCaseUser() {
        return testCaseUser;
    }
}
