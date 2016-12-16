package com.qauber.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by Alya on 12/15/2016.
 */
public class AddReportEnvironment {

    WebDriver driver;
    WebElement element;

    public WebElement gangNameCheckBox() {
        element = driver.findElement(By.xpath("html/body/div[2]/section/div/div/div/form/div/div[6]/fieldset/div[1]/div[1]/div/div/span/label/span"));
        return element;
    }

    public WebElement gangNamefield() {
        element = driver.findElement(By.name("gang-name"));
        return element;
    }

    public WebElement howLongField() {
        element = driver.findElement(By.name("howLong"));
        return element;
    }

    public WebElement sexCrimesCheckBox() {
        element = driver.findElement(By.xpath("//input[text()='Sex Crimes']"));
        return element;
    }

    public WebElement robberyCheckBox() {
        element = driver.findElement(By.xpath("//input[text()='Robbery']"));
        return element;
    }

    public WebElement narcoCheckbox() {
        element = driver.findElement(By.xpath("//input[text()='Narco']"));
        return element;
    }

    public WebElement viceIntelCheckbox() {
        element = driver.findElement(By.xpath("//input[text()='Vice Intel']"));
        return element;
    }

    public WebElement selfAdmissionCheckbox() {
        element = driver.findElement(By.xpath("//input[text()='Self Admission']"));
        return element;
    }

    public WebElement FrequentingGangAreaCheckbox() {
        element = driver.findElement(By.xpath("//input[text()='Frequenting Gang Area']"));
        return element;
    }

    public WebElement displayingGangSignsCheckbox() {
        element = driver.findElement(By.xpath("//input[text()='Displaying Gang Signs']"));
        return element;
    }

    public WebElement reliableInformantCheckbox() {
        element = driver.findElement(By.xpath("//input[text()='Reliable Informant']"));
        return element;
    }

    public WebElement getTatoosCheckbox() {
        element = driver.findElement(By.xpath("//input[text()='Gang Tatoos']"));
        return element;
    }

    public WebElement gangClothingCheckbox() {
        element = driver.findElement(By.xpath("//input[text()='Gang Clothing']"));
        return element;
    }

    public WebElement affiliatingWithGangMembersCheckbox() {
        element = driver.findElement(By.xpath("//input[text()='Affiliating With Gang Members']"));
        return element;
    }

    public WebElement participatingInGangCrimeCheckbox() {
        element = driver.findElement(By.xpath("//input[text()='Participating In Gang Crime']"));
        return element;
    }

    public WebElement gangRegistrantCheckbox() {
        element = driver.findElement(By.xpath("//input[text()='Gang Registrant']"));
        return element;
    }

    public WebElement otherInformationField() {
        element = driver.findElement(By.xpath("html/body/div[2]/section/div/div/div/form/div/div[6]/fieldset/div[3]/div/div/div/input"));
        return element;
    }

    public WebElement onProbationCheckbox() {
        element = driver.findElement(By.xpath("//input[text()='On Probation']"));
        return element;
    }

    public WebElement probationOfficerField() {
        element = driver.findElement(By.xpath("html/body/div[2]/section/div/div/div/form/div/div[6]/fieldset/div[4]/div[2]/div/div/input"));
        return element;
    }

    public WebElement probationOfficerPhoneField() {
        element = driver.findElement(By.xpath("html/body/div[2]/section/div/div/div/form/div/div[6]/fieldset/div[4]/div[3]/div/div/input"));
        return element;
    }

    public WebElement onParoleCheckbox() {
        element = driver.findElement(By.xpath("//input[text()='On Parole']"));
        return element;
    }

    public WebElement beatField() {
        element = driver.findElement(By.xpath("html/body/div[2]/section/div/div/div/form/div/div[6]/fieldset/div[6]/div[1]/div/div/input"));
        return element;
    }

    public WebElement officerNameField() {
        element = driver.findElement(By.xpath("html/body/div[2]/section/div/div/div/form/div/div[6]/fieldset/div[6]/div[2]/div[2]/input"));
        return element;
    }

    public WebElement officerIdField() {
        element = driver.findElement(By.xpath("html/body/div[2]/section/div/div/div/form/div/div[6]/fieldset/div[6]/div[3]/div[2]/input"));
        return element;
    }

    public WebElement stopLocationField() {
        element = driver.findElement(By.xpath("html/body/div[2]/section/div/div/div/form/div/div[6]/fieldset/div[7]/div/div/div/input"));
        return element;
    }

    public WebElement previousButton() {
        element = driver.findElement(By.xpath("html/body/div[2]/section/div/div/div/form/div/div[6]/ul/li[1]/a/span"));
        return element;
    }

    public WebElement nextButton() {
        element = driver.findElement(By.xpath("//*[@class=\"next\"]/a"));
        return element;
    }

    //Constructor
    public AddReportEnvironment(WebDriver driver) {

        this.driver = driver;
    }
}
