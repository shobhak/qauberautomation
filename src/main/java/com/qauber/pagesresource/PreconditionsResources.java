package com.qauber.pagesresource;

import com.qauber.pagesresource.preconditions.*;
import org.openqa.selenium.WebDriver;

/**
 * Created by erikfriedlander on 1/4/17.
 */
public class PreconditionsResources {
    private UsersPreconditions usersPreconditions;
    private UsersPreconditionsSampleRunAsSeparateUser samplePreconditionsAsSeparateUser;
    private ReportPreconditions reportPreconditions;
    private EntitiesNamesPreconditions entitiesNamesPreconditions;
    private SearchHelper searchHelper;
    private PermissionsPreconditions permissionsPreconditions;



    public PreconditionsResources(WebDriver driver) {
        usersPreconditions = new UsersPreconditions(driver);
        reportPreconditions = new ReportPreconditions(driver);
        samplePreconditionsAsSeparateUser = new UsersPreconditionsSampleRunAsSeparateUser();
        entitiesNamesPreconditions = new EntitiesNamesPreconditions(driver);
        searchHelper = new SearchHelper(driver);
        permissionsPreconditions = new PermissionsPreconditions();
    }

    public UsersPreconditions getUsersPreconditions() {
        return usersPreconditions;
    }

    public ReportPreconditions getReportPreconditions(){

        return reportPreconditions;
    }

    public UsersPreconditionsSampleRunAsSeparateUser getSamplePreconditionsAsSeparateUser() {
        return samplePreconditionsAsSeparateUser;
    }

    public SearchHelper getSearchHelper()
    {
        return searchHelper;
    }

    public EntitiesNamesPreconditions getEntitiesNamesPreconditions() {
        return entitiesNamesPreconditions;
    }

    public PermissionsPreconditions getPermissionsPreconditions() {
        return permissionsPreconditions;
    }
}
