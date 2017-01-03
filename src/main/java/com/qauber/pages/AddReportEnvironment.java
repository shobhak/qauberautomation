package com.qauber.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by Alya on 12/15/2016.
 */
public class AddReportEnvironment {

    //WebDriver driver;
    //WebElement element;

    private WebDriver driver;

    //Constructor
    public AddReportEnvironment(WebDriver driver) {

        this.driver = driver;
    }

    /*public WebElement gangNameCheckBox() {
        element = driver.findElement(By.xpath("html/body/div[2]/section/div/div/div/form/div/div[6]/fieldset/div[1]/div[1]/div/div/span/label/span"));
        return element;
    }*/

    public WebElement gangNameCheckBox() {
        return driver.findElement(By.xpath("html/body/div[2]/section/div/div/div/form/div/div[6]/fieldset/div[1]/div[1]/div/div/span/label/span"));
    }

    public WebElement gangNameField() {
        return driver.findElement(By.name("gang-name"));
    }

    public WebElement howLongField() {
        return driver.findElement(By.name("howLong"));
    }

    public WebElement sexCrimesCheckBox() {
        return driver.findElement(By.xpath("//input[@ng-model=\"wizard.report.sexCrimes\"]"));
    }

    public WebElement robberyCheckBox() {
        return driver.findElement(By.xpath("//input[@ng-model=\"wizard.report.robbery\"]"));
    }

    public WebElement narcoCheckbox() {
        return driver.findElement(By.xpath("//input[@ng-model=\"wizard.report.narco\"]"));
    }

    public WebElement viceIntelCheckbox() {
        return driver.findElement(By.xpath("//input[@ng-model=\"wizard.report.viceIntel\"]"));
    }

    public WebElement selfAdmissionCheckbox() {
        return driver.findElement(By.xpath("//input[@ng-model=\"wizard.report.selfAdmission\"]"));
    }

    public WebElement frequentingGangAreaCheckbox() {
        return driver.findElement(By.xpath("//input[@ng-model=\"wizard.report.frequentingGangArea\"]"));
    }

    public WebElement displayingGangSignsCheckbox() {
        return driver.findElement(By.xpath("//input[@ng-model=\"wizard.report.displayingGangSigns\"]"));
    }

    public WebElement byReliableInformantCheckbox() {
        return driver.findElement(By.xpath("//input[@ng-model=\"wizard.report.byReliableInformant\"]"));
    }

    public WebElement gangTattoosCheckbox() {
        return driver.findElement(By.xpath("//input[@ng-model=\"wizard.report.gangTattoos\"]"));
    }

    public WebElement gangClothingCheckbox() {
        return driver.findElement(By.xpath("//input[@ng-model=\"wizard.report.gangClothing\"]"));
    }

    public WebElement affiliatingWithGangMembersCheckbox() {
        return driver.findElement(By.xpath("//input[@ng-model=\"wizard.report.affiliatingWithGangMembers\"]"));
    }

    public WebElement participatingInGangCrimeCheckbox() {
        return driver.findElement(By.xpath("//input[@ng-model=\"wizard.report.participatingInGangCrime\"]"));
    }

    public WebElement gangRegistrantCheckbox() {
        return driver.findElement(By.xpath("//input[@ng-model=\"wizard.report.gangRegistrant\"]"));
    }

    public WebElement onProbationCheckbox() {
        return driver.findElement(By.xpath("//input[@ng-model=\"wizard.report.onProbation\"]"));
    }

    public WebElement probationOfficerField() {
        return driver.findElement(By.xpath("//input[@ng-model=\"wizard.report.probationOfficer\"]"));
    }

    public WebElement probationOfficerPhoneField() {
        return driver.findElement(By.xpath("//input[@name='probationOfficerPhone']"));
    }

    public WebElement onParoleCheckbox() {
        return driver.findElement(By.xpath("//input[@ng-model=\"wizard.report.onParole\"]"));
    }

    public WebElement paroleOfficerField() {
        return driver.findElement(By.xpath("//input[@ng-model=\"wizard.report.paroleOfficer\"]"));
    }

    public WebElement paroleOfficerPhoneField() {
        return driver.findElement(By.xpath("//input[@ng-model=\"wizard.report.paroleOfficerPhone\"]"));
    }

    public WebElement beatField() {
        return driver.findElement(By.xpath("//input[@ng-model=\"wizard.report.beat\"]"));
    }

    public WebElement officerNameField() {
        return driver.findElement(By.xpath("//input[@name='officerName']"));
    }

    public WebElement officerIdField() {
        return driver.findElement(By.xpath("//input[@name='officerID']"));
    }

    public WebElement reasonForStopField(){
        return driver.findElement(By.xpath("//input[@type='text'][@placeholder='Reason For Stop']"));
    }

    public WebElement stopLocationField() {
        return driver.findElement(By.xpath("//input[@ng-model=\"wizard.report.locationOfStop\"]"));
    }

    public WebElement dispositionField(){
        return driver.findElement(By.xpath("//input[@ng-model='wizard.report.dispositionOfStop']"));
    }

    public WebElement otherInformationCommentsFieldArea() {
        return driver.findElement(By.xpath("//div[@class=\"controls\"]/textarea"));
    }

    public WebElement previousButton() {
        return driver.findElement(By.xpath("html/body/div[2]/section/div/div/div/form/div/div[6]/ul/li[1]/a/span"));
    }

    public WebElement nextButton() {
        return driver.findElement(By.xpath("html/body/div[2]/section/div/div/div/form/div/div[6]/ul/li[2]/a"));
    }
}
