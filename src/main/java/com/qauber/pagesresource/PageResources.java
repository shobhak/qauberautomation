package com.qauber.pagesresource;

import com.qauber.pages.*;
import org.openqa.selenium.WebDriver;

/**
 * Created by erikfriedlander on 1/7/17.
 *
 * You should only get PageResources through PageResourcesFactory.
 * PageResources page = PageResourcesFactory.getPageResources(WebDriver driver)
 *
 */
public class PageResources {

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
    private Entities entities;
    private EntitiesPermissionsDialog entitiesPermissionsDialog;
    private EntitiesDepartmentSetting entitiesDepartmentSetting;
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

    public PageResources(WebDriver driver) {

        //Set page references
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
        entitiesDepartmentSetting = new EntitiesDepartmentSetting(driver);
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

        companyCreationSAU = new CompanyCreationSAU(driver);
    }

    //Getters

    @Deprecated //TODO: move into helper method
    public CompanyCreationSAU getCompanyCreationSAU() {
        return companyCreationSAU;
    }

    public LoginPage getLogin() {
        return login;
    }

    public RegistrationPage1 getRegistrationPage1() {
        return registrationPage1;
    }

    public RegistrationPage2 getRegistrationPage2() {
        return registrationPage2;
    }

    public Header getHeader() {
        return header;
    }

    public NavBar getNavBar() {
        return navBar;
    }

    public ProfilePanel getProfilePanel() {
        return profilePanel;
    }

    public EditProfile getEditProfile() {
        return editProfile;
    }

    public SubscriptionSettings getSubscriptionSettings() {
        return subscriptionSettings;
    }

    public Entities getEntities() {
        return entities;
    }

    public EntitiesPermissionsDialog getEntitiesPermissionsDialog() {
        return entitiesPermissionsDialog;
    }

    public EntitiesDepartmentSetting getEntitiesDepartmentSetting() { return entitiesDepartmentSetting; }

    public Users getUsers() {
        return users;
    }

    public UsersPermissionsDialog getUsersPermissionsDialog() {
        return usersPermissionsDialog;
    }

    public EditOrganizationPage getEditOrganizationPage() {
        return editOrganizationPage;
    }

    public Reports getReports() {
        return reports;
    }

    public ReportsViewReport getReportsViewReport() {
        return reportsViewReport;
    }

    public AddReportEnvironment getAddReportEnvironment() {
        return addReportEnvironment;
    }

    public AddReportIdentificationInformation getAddReportIdentificationInformation() {
        return addReportIdentificationInformation;
    }

    public AddReportIdentifiersPage getAddReportIdentifiersPage() {
        return addReportIdentifiersPage;
    }

    public AddReportNavigation getAddReportNavigation() {
        return addReportNavigation;
    }

    public AddReportPhoto getAddReportPhoto() {
        return addReportPhoto;
    }

    public AddReportsOrganization getAddReportOrganization() {
        return addReportOrganization;
    }

    public AddReportSubjectInformationPage getAddReportSubjectInformationPage() {
        return addReportSubjectInformationPage;
    }

    public AddReportVehicle getAddReportVehicle() {
        return addReportVehicle;
    }

    public AddReportPreview getAddReportPreview() {
        return addReportPreview;
    }

    public CreateSubsciption getCreateSubsciption() {
        return createSubsciption;
    }

    public CreateOrganization getCreateOrganization() {
        return createOrganization;
    }
}
