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
        return driver.findElement(By.xpath("//button[text()='Add Entity']"));
    }

    // Web elements list for "Info" organization
    public List<WebElement> organizationList(){
        return driver.findElements(By.xpath("//td[@class='pl-lg']/a[@class='ng-binding']"));
    }

    // web element list for entities subscription
    public List<WebElement> entitySubscriptionUserList(){
        return driver.findElements(By.xpath("//*[contains(text(), 'Users used')]"));
    }

    // web element list for assign permissions button
    public List<WebElement> assignPermissionsButtonList(){
        return driver.findElements(By.xpath("//*[@title='Assign permissions']"));
    }

    // Web element list for edit button
    public List<WebElement> editOrganizationButtonList(){
        return driver.findElements(By.xpath("//*[@title='Edit']"));
    }

    // Web element list for finish create the entity
    public List<WebElement> finishCreateTheEntityButtonList(){
        return driver.findElements(By.xpath("//*[@title='Finish creating the entity']"));
    }

    // Web element list for deletion
    public List<WebElement> deleteOrganizationButtonList(){
        return driver.findElements(By.xpath("//*[@title='Delete']"));
    }

    // Web element for "Info" organization
    public WebElement organizationInfo(int rowindex){
        return organizationList().get(rowindex - 1);
    }

    // Web element for "Info" logo image
    public WebElement organizationLogo(int rowindex){
        element = driver.findElement(By.xpath("//tr[@class='ng-scope'][" + rowindex + "]/td[@class='pl-lg']/div/img"));
        return element;
    }

    // Web element for "Info" number of subscription users
    public WebElement organizationSubscriptionUsers(int rowindex){
        return entitySubscriptionUserList().get(rowindex - 1);
    }

    // Web element for "Action" assign permission
    public WebElement assignPermissionButton(int rowindex){
        return assignPermissionsButtonList().get(rowindex - 1);
    }

    // Web element for "Action" edit organization
    public WebElement editOrganizationButton(int rowindex){
        return editOrganizationButtonList().get(rowindex - 1);
    }


    // Web element for "Action" finish create an organization
    public WebElement finishCreateOrganizationButton(int rowindex){
        return finishCreateTheEntityButtonList().get(rowindex - 1);
    }

    // Web element for "Action" delete an organization
    public WebElement deleteOrganizationButton(int rowindex){
        return deleteOrganizationButtonList().get(rowindex - 1);
    }

    // find the matching web element from web elements list
    public int findEditOrganizationIndex(String orgname){
        List<WebElement> els = organizationList();
        int rowindex = 1;
        for (int i = 0; i < els.size(); i++){
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

    public WebElement AddDepartmentButton() {
        element = driver.findElement(By.xpath("//button[contains(@ng-show,'ctrl.userIsAble()')]"));
        return element;
    }

    public WebElement AddDepartmentField() {
        element = driver.findElement(By.xpath("//input[contains(@required,'required')]"));
        return element;
    }

    public WebElement CreatDepartmentButton() {
        element = driver.findElement(By.xpath("//button[contains(@ng-disabled,'error.required')]"));
        return element;
    }

    //On department
    //get web element list for department name
    public List<WebElement> departmentNameList(){
        return driver.findElements(By.xpath("//td[@class='pl-lg']/a[@class='ng-binding']"));
    }

    public WebElement departmentName(int index){
        return departmentNameList().get(index - 1);
    }

    //get web element list for department assign permissions buttons
    public List<WebElement> departmentAssignPermissionsButtonList(){
        return driver.findElements(By.xpath("//*[@title='Assign permissions']"));
    }

    public WebElement departmentAssignPermissionsButton(int index){
        return departmentAssignPermissionsButtonList().get(index - 1);
    }

    //get web element list for department edit buttons
    public List<WebElement> departmentEditButtonList(){
        return driver.findElements(By.xpath("//*[@title='Edit']"));
    }

    public WebElement departmentEditButton(int index){
        return departmentEditButtonList().get(index - 1);
    }

    //get web element list for department delete buttons
    public List<WebElement> departmentDeleteButtonList(){
        return driver.findElements(By.xpath("//*[@title='Delete']"));
    }

    public WebElement departmentDeleteButton(int index){
        return departmentDeleteButtonList().get(index - 1);
    }


    //On subdepartment

    //add subdepartment
    public WebElement addSubdepartmentButton(){
        return driver.findElement(By.xpath("//*[text()='Add Department']"));
    }

    public WebElement addSubdepartmentField() {
        return driver.findElement(By.xpath("//input[contains(@required,'required')]"));
    }

    public WebElement creatSubepartmentButton() {
        return driver.findElement(By.xpath("//button[contains(@ng-disabled,'error.required')]"));
    }
    //get web element list for subdepartment name
    public List<WebElement> subdepartmentNameList(){
        return driver.findElements(By.xpath("//td[@class='pl-lg']/a[@class='ng-binding']"));
    }

    public WebElement subdepartmentName(int index){
        return subdepartmentNameList().get(index - 1);
    }

    //get web element list for subdepartment assign permissions buttons
    public List<WebElement> subdepartmentAssignPermissionsButtonList(){
        return driver.findElements(By.xpath("//*[@title='Assign permissions']"));
    }

    public WebElement subdepartmentAssignPermissionsButton(int index){
        return subdepartmentAssignPermissionsButtonList().get(index - 1);
    }

    //get web element list for subdepartment edit buttons
    public List<WebElement> subdepartmentEditButtonList(){
        return driver.findElements(By.xpath("//*[@title='Edit']"));
    }

    public WebElement subdepartmentEditButton(int index){
        return subdepartmentEditButtonList().get(index - 1);
    }

    //get web element list for subdepartment delete buttons
    public List<WebElement> subdepartmentDeleteButtonList(){
        return driver.findElements(By.xpath("//*[@title='Delete']"));
    }

    public WebElement subdepartmentDeleteButton(int index){
        return subdepartmentDeleteButtonList().get(index - 1);
    }

    public List<WebElement> entityRows() {
        return driver.findElements(By.xpath("//tbody/tr[@class='ng-scope']"));
    }



}


