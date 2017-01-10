package com.qauber.pagesresource;

import org.openqa.selenium.WebDriver;

import java.util.HashMap;

/**
 * Created by erikfriedlander on 1/7/17.
 * PageResourcesFactory returns one instance of PageResources FOR EACH DRIVER.
 * More resource-efficient then each helper/precondition/etc making new instances of Page objects.
 *
 * Only get PageResources through PageResourcesFactory.
 * PageResources page = PageResourcesFactory.getPageResources(WebDriver driver)
 */
public class PageResourcesFactory {

    static HashMap pageResourcesHashMap = new HashMap();

    public static PageResources getPageResources(WebDriver driver) {
        if (pageResourcesHashMap.containsKey(driver)) { //If there is already a PageResources with this driver...
            return (PageResources) pageResourcesHashMap.get(driver); //return that resource
        } else {
            pageResourcesHashMap.put(driver, new PageResources(driver)); //Otherwise, we make a new one...
            return (PageResources) pageResourcesHashMap.get(driver); //and return it!
        }
    }
}
