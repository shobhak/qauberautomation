package com.qauber.pagesresource;

import com.qauber.pagesresource.helper.SearchHelper;
import org.openqa.selenium.WebDriver;

/**
 * Created by erikfriedlander on 1/20/17.
 */
public class HelperResources {
    WebDriver driver;
    SearchHelper searchHelper;
    //EntityHelper entityHelper;

    public HelperResources(WebDriver driver) {
        this.driver = driver;
        searchHelper = new SearchHelper(driver);
        //entityHelper = new EntityHelper(driver);
    }

    public SearchHelper getSearchHelper() {
        return searchHelper;
    }
}
