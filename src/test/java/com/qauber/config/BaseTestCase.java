package com.qauber.config;

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
public class BaseTestCase {

    private WebDriver driver;

//First page
    private LoginPage login;

//Pages/elements accessible from all pages
    private Header header;
    private NavBar navBar;
    private ProfilePanel profilePanel;
    private EditProfile editProfile;

//Navbar pages
    //    private Users users;
    private Entities entities;
    private Reports reports;

//Add reports pages
    private AddReportEnvironment addReportEnvironment;
    private AddReportIdentificationInformation addReportIdentificationInformation;
    private AddReportIdentifiersPage addReportIdentifiersPage;
    private AddReportNavigation addReportNavigation;
    private AddReportPhoto addReportPhoto;
    private AddReportsOrganization addReportOrganization;
    private AddReportSubjectInformationPage addReportSubjectInformationPage;
    private AddReportVehicle addReportVehicle;

    public void setUpWithConfig(ConfigOOP config) {


        // Choose web browser/driver from Config
        driver = chooseDriver(config);

        //implicit wait
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //maximize window for our viewing pleasure
        driver.manage().window().maximize();

        ////////////////// Done managing WebDriver

        //Set page references
        login = new LoginPage(driver);
        header = new Header(driver);
        navBar = new NavBar(driver);
        profilePanel = new ProfilePanel(driver);

        entities = new Entities(driver);
        reports = new Reports(driver);

        addReportEnvironment = new AddReportEnvironment(driver);
        addReportIdentificationInformation = new AddReportIdentificationInformation(driver);
        addReportIdentifiersPage = new AddReportIdentifiersPage(driver);
        addReportNavigation = new AddReportNavigation(driver);
        addReportPhoto = new AddReportPhoto(driver);
        addReportOrganization = new AddReportsOrganization(driver);
        addReportSubjectInformationPage = new AddReportSubjectInformationPage(driver);
        addReportVehicle = new AddReportVehicle(driver);

    }

    public void breakDownHelper() {
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

    protected WebDriver getDriver() { //visible from subclasses, not public OR private
        return driver;
    }

    protected LoginPage getLogin() {
        return login;
    }

    protected Header getHeader() {
        return header;
    }

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

    protected Reports getReports() {
        return reports;
    }

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

    public AddReportsOrganization getAddReportOrganization() {
        return addReportOrganization;
    }

    protected AddReportSubjectInformationPage getAddReportSubjectInformationPage() {
        return addReportSubjectInformationPage;
    }

    protected AddReportVehicle getAddReportVehicle() {
        return addReportVehicle;
    }
}
