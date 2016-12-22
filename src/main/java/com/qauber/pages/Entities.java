package com.qauber.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

/**
 * Created by erikfriedlander on 12/16/16.
 */
public class Entities {

    WebDriver driver;
    WebElement element;
    List<WebElement> elements;


    public Entities(WebDriver driver) {
        this.driver = driver;
    }

    //Create all web elements in Entities page

    // Web element for "Add organization"
    public WebElement addOrganizationButton(){
        element = driver.findElement(By.xpath("//button[text()='Add Entity']"));
        return element;
    }

    // Web elements list for "Info" organization
    public List<WebElement> organizationList(){
        elements = driver.findElements(By.xpath("//td[@class='pl-lg']/a[@class='ng-binding']"));
        return elements;
    }


    // Web element for "Info" organization
    public WebElement organizationInfo(int rowindex){
        element = driver.findElement(By.xpath("//tr[@class='ng-scope'][" + rowindex + "]/td[@class='pl-lg']/a"));
        return element;
    }

    // Web element for "Info" logo image
    public WebElement organizationLogo(int rowindex){
        element = driver.findElement(By.xpath("//tr[@class='ng-scope'][" + rowindex + "]/td[@class='pl-lg']/div/img"));
        return element;
    }

    // Web element for "Action" assign permission
    public WebElement assignPermissionButton(int rowindex){
        element = driver.findElement(By.xpath("//tr[@class='ng-scope'][" + rowindex + "]/td[@class='text-center']/button[@title='Assign permissions']"));
        return element;
    }

    // Web element for "Action" edit organization
    public WebElement editOrganizationButton(int rowindex){
        element = driver.findElement(By.xpath("//tr[@class='ng-scope'][" + rowindex + "]/td[@class='text-center']/button[@title='Edit']"));
        return element;
    }

    //Orange second button
    public WebElement orangeLastEditButton(){
        return driver.findElement(By.xpath("(.//button[3])[last()]"));

        //return driver.findElement(By.xpath("(.//button[@title='Finish creating the organization'])[last()]"));
    }

    // Web element for "Action" finish create an organization
    public WebElement finishCreateOrganizationButton(int rowindex){
        element = driver.findElement(By.xpath("//tr[@class='ng-scope'][" + rowindex + "]/td[@class='text-center']/button[@title='Finish creating the entity']"));
        return element;
    }

    // Web element for "Action" delete an organization
    public WebElement deleteOrganizationButton(int rowindex){
        element = driver.findElement(By.xpath("//tr[@class='ng-scope'][" + rowindex + "]/td[@class='text-center']/button[@title='Delete']"));
        return element;
    }

    // find the matching web element from web elements list
    public int findEditOrganizationIndex(String orgname){
        List<WebElement> els = organizationList();
        int rowindex = 1;
        for (int i = 0; i < this.elements.size(); i++){
            if (els.get(i).getText().equals(orgname)){
                break;
            } else {
                rowindex++;
            }
        }
        if (rowindex == els.size()+1){
            System.out.println("The organization is not on the list");
        }
        return rowindex;
    }


}
