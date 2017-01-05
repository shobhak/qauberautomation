package com.qauber.pagesresource;

import com.qauber.pagesresource.preconditions.ReportPreconditions;
import com.qauber.pagesresource.preconditions.UsersPreconditionsSampleRunAsSeparateUser;
import com.qauber.pagesresource.preconditions.UsersPreconditions;
import org.openqa.selenium.WebDriver;

/**
 * Created by erikfriedlander on 1/4/17.
 */
public class PreconditionsResources {
    UsersPreconditions usersPreconditions;
    UsersPreconditionsSampleRunAsSeparateUser samplePreconditionsAsSeparateUser;
    ReportPreconditions reportPreconditions;

    public PreconditionsResources(WebDriver driver) {
        usersPreconditions = new UsersPreconditions(driver);
        reportPreconditions = new ReportPreconditions(driver);
        samplePreconditionsAsSeparateUser = new UsersPreconditionsSampleRunAsSeparateUser();
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
}
