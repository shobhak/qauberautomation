package com.qauber.pagesresource;

import org.openqa.selenium.WebDriver;

import java.util.HashMap;

/**
 * Created by erikfriedlander on 1/7/17.
 */
public class PageResourcesFactory {

    static HashMap pageResourcesHashMap = new HashMap();

    public static PageResources getPageResources(WebDriver driver) {
        if (pageResourcesHashMap.containsKey(driver)) {
            return (PageResources) pageResourcesHashMap.get(driver);
        } else {
            pageResourcesHashMap.put(driver, new PageResources(driver));
            return (PageResources) pageResourcesHashMap.get(driver);
        }
    }
}
