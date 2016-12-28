package com.qauber.pagesresource;

import com.github.javafaker.Faker;

/**
 * Created by Alya on 12/22/2016.
 */

// to be continued

public class ReportValueObject{

    private Faker faker;
    private String gangName;
    private String firstName;
    private String lastName;
    private String stopLocation;
    private String caseID;

    //Constructor
    public ReportValueObject(){
        faker = new Faker();
        firstName = faker.name().firstName();
        lastName = faker.name().lastName();
        gangName = faker.lorem().word();
        stopLocation = faker.address().city();
        caseID = faker.number().digit();
    }

    public String getGangName() {
        return gangName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getStopLocation() { return stopLocation; }

    public String getCaseID() { return caseID; }
}
