package com.qauber.pagesresource.helper;

import com.github.javafaker.Faker;
import com.qauber.pages.Reports;
import org.openqa.selenium.WebDriver;
import java.util.Locale;

/**
 * Created by MadMax on 1/7/2017.
 *
 * Helper for existing search results.
 * It's take random value from the first page report results and return as a String.
 * Precondition: user should have at list 10 reports in the report results.
 *               all reports should contain value what you are looking for.
 *
 * For the fast report creation use ReportPreconditions Class.
 */
public class SearchHelper {

    private WebDriver driver;
    private Reports reports;
    private Faker faker;

    public SearchHelper(WebDriver driver)
    {
        this.driver = driver;
        reports = new Reports(driver);
        faker = new Faker(new Locale("en-US"));
    }

    //Return random existing Case ID from first page search results.
    public String randomCaseID()
    {
        return reports.caseIdResult(faker.number().numberBetween(1,10)).getText();
    }

    //Return random existing ReportResult(Example: 321. Virginia Botsford (R/P)) from first page search results.
    public String randomReportResult()
    {
        return reports.searchReportResultID(faker.number().numberBetween(1,10)).getText();
    }

    //Return random existing text for search by "Contain Text" field from first page search results.
    public String randomContainText()
    {
        String[] random = randomReportResult().split(" ");
        return random[1].substring(0,faker.number().numberBetween(1,random[1].length()));
    }

    //Return random existing first name from first page search results.
    public String randomFirstName()
    {
        String[] random = randomReportResult().split(" ");
        return random[1];
    }

    //Return random existing last name from first page search results.
    public String randomLastName()
    {
        String[] random = randomReportResult().split(" ");
        return random[2];
    }

    //Return random existing suspect type from first page search results.
    public String randomSuspectType()
    {
        String[] random = randomReportResult().split(" ");
        return random[3].substring(1,random[3].length()-1);
    }

    //Return random existing pagination from first page search results.
    public String randomPagination()
    {
        return reports.paginationSum().get(faker.number().numberBetween(1,reports.paginationSum().size())).getText();
    }

    //Return random existing Date in full format (Example: January 01 2017) from first page search results.
    public String randomDate()
    {
        String date = reports.searchReportResultPublishedDate(faker.number().numberBetween(1,10)).getText();
        return randomMonth(date) +" "+ randomDay(date) +" "+ randomYear(date);
    }

    private String randomDay(String fullDate)
    {
        String[] date = fullDate.split(" ");
        date[1] = date[1].replace(",","");
        if(date[1].length()==1)
            date[1] = "0"+date[1];
        return date[1];
    }

    //Return random existing day of month from first page search results.
    public String randomDay()
    {
        String[] date = randomDate().split(" ");
        return date[1];
    }

    private String randomMonth(String fullDate)
    {
        String[] date = fullDate.split(" ");
        String month = date[0];
        if (month.equals("Jan")) return "January";
        if (month.equals("Feb")) return "February";
        if (month.equals("Mar")) return "March";
        if (month.equals("Apr")) return "April";
        if (month.equals("May")) return "May";
        if (month.equals("Jun")) return "June";
        if (month.equals("Jul")) return "July";
        if (month.equals("Aug")) return "August";
        if (month.equals("Sep")) return "September";
        if (month.equals("Oct")) return "October";
        if (month.equals("Nov")) return "November";
        else return "December";
    }

    //Return random existing month from first page search results.
    public String randomMonth()
    {
        String[] date = randomDate().split(" ");
        return date[0];
    }

    private String randomYear(String fullDate)
    {
        String[] date = fullDate.split(" ");
        return date[2];
    }

    //Return random existing year from first page search results.
    public String randomYear()
    {
        String[] date = randomDate().split(" ");
        return date[2];
    }

}
