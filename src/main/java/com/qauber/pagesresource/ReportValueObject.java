package com.qauber.pagesresource;

import com.github.javafaker.Faker;

/**
 * Created by Alya on 12/22/2016.
 */

// to be continued

public class ReportValueObject{
    private Faker faker;

    //subject information
    private String firstName;
    private String lastName;
    private String middleName;
    private String suspectType;
    private String dateOfBirth;
    private String nickName;
    private String race;
    private String height;
    private String weight;
    private String haircolor;
    private String hairLength;
    private String hairStyle;
    private String sex;
    private String build;
    private String eyeColor;
    private String complexion;
    private String teeth;
    private String handPreference;

    // identifiers
    private String tattoosCheckBox;
    private String scarsCheckBox;
    private String needleMarksCheckBox;
    private String tracksCheckBox;
    private String glassesCheckBox;
    private String mustacheCheckBox;
    private String beardCheckBox;
    private String tattoos;
    private String scars;
    private String needleMarks;
    private String tracks;
    private String glasses;
    private String mustache;
    private String beard;

    // environment
    private String gangNameCheckBox;
    private String gangName;
    private String howLong;
    private String sexCrimes;
    private String robbery;
    private String narco;
    private String viceIntel;
    private String selfAdmission;
    private String frequentingGangArea;
    private String displayingGangSigns;
    private String byReliableInformant;
    private String gangTattoos;
    private String gangClothing;
    private String affiliatingWithGangMembers;
    private String participatingInGangCrime;
    private String gangRegistrant;
    private String onProbation;
    private String probationOfficer;
    private String probationOfficerPhone;
    private String onParole;
    private String paroleOfficer;
    private String paroleOfficerPhone;
    private String beat;
    private String officerName;
    private String officerId;
    private String reasonForStop;
    private String stopLocation;
    private String disposition;
    private String otherInformationComments;

    private String caseID;

    //Constructor
    public ReportValueObject(){
        faker = new Faker();

        firstName = faker.name().firstName();
        middleName = faker.name().lastName();
        lastName = faker.name().lastName();
        nickName = faker.lorem().word();

        gangName = faker.lorem().word();
        howLong = faker.number().digit();
        probationOfficer = faker.name().name();
        probationOfficerPhone = faker.phoneNumber().cellPhone();
        paroleOfficer = faker.name().name();
        paroleOfficerPhone = faker.phoneNumber().cellPhone();
        beat = faker.lorem().word();
        officerName = faker.name().name();
        officerId = faker.idNumber().valid();
        reasonForStop = faker.lorem().word();
        disposition = faker.lorem().word();
        otherInformationComments = faker.lorem().word();
        stopLocation = faker.address().city();

        tattoos = faker.lorem().word();
        scars = faker.lorem().word();
        needleMarks = faker.lorem().word();
        tracks = faker.lorem().word();
        glasses = faker.lorem().word();
        mustache = faker.lorem().word();
        beard = faker.lorem().word();

        caseID = faker.number().digit();
    }

    public String getFirstName() {
        return firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public String getLastName() {
        return lastName;
    }
    public String getSuspectType() {
        return suspectType;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public String getNickName() {
        return nickName;
    }

    public String getRace() {
        return race;
    }

    public String getHeight() {
        return height;
    }

    public String getWeight() {
        return weight;
    }

    public String getHaircolor() {
        return haircolor;
    }

    public String getHairLength() {
        return hairLength;
    }

    public String getHairStyle() {
        return hairStyle;
    }

    public String getSex() {
        return sex;
    }

    public String getBuild() {
        return build;
    }

    public String getEyeColor() {
        return eyeColor;
    }

    public String getComplexion() {
        return complexion;
    }

    public String getTeeth() {
        return teeth;
    }

    public String getHandPreference() {
        return handPreference;
    }

    public String getTattoosCheckBox() {
        return tattoosCheckBox;
    }

    public String getScarsCheckBox() {
        return scarsCheckBox;
    }

    public String getNeedleMarksCheckBox() {
        return needleMarksCheckBox;
    }

    public String getTracksCheckBox() {
        return tracksCheckBox;
    }

    public String getGlassesCheckBox() {
        return glassesCheckBox;
    }

    public String getMustacheCheckBox() {
        return mustacheCheckBox;
    }

    public String getBeardCheckBox() {
        return beardCheckBox;
    }

    public String getTattoos() {
        return tattoos;
    }

    public String getScars() {
        return scars;
    }

    public String getNeedleMarks() {
        return needleMarks;
    }

    public String getTracks() {
        return tracks;
    }

    public String getGlasses() {
        return glasses;
    }

    public String getMustache() {
        return mustache;
    }

    public String getBeard() {
        return beard;
    }

    public String getGangNameCheckBox() { return getGangNameCheckBox(); }

    public String getGangName() { return gangName; }

    public String getHowLong() {return howLong; }

    public String getSexCrimes() {
        return sexCrimes;
    }

    public String getRobbery() {
        return robbery;
    }

    public String getNarco() {
        return narco;
    }

    public String getViceIntel() {
        return viceIntel;
    }

    public String getSelfAdmission() {
        return selfAdmission;
    }

    public String getFrequentingGangArea() {
        return frequentingGangArea;
    }

    public String getDisplayingGangSigns() {
        return displayingGangSigns;
    }

    public String getByReliableInformant() {
        return byReliableInformant;
    }

    public String getGangTattoos() {
        return gangTattoos;
    }

    public String getGangClothing() {
        return gangClothing;
    }

    public String getAffiliatingWithGangMembers() {
        return affiliatingWithGangMembers;
    }

    public String getParticipatingInGangCrime() {
        return participatingInGangCrime;
    }

    public String getGangRegistrant() {
        return gangRegistrant;
    }

    public String getOnProbation() {
        return onProbation;
    }

    public String getProbationOfficer() {
        return probationOfficer;
    }

    public String getProbationOfficerPhone() {
        return probationOfficerPhone;
    }

    public String getOnParole() {
        return onParole;
    }

    public String getParoleOfficer() {
        return paroleOfficer;
    }

    public String getParoleOfficerPhone() {
        return paroleOfficerPhone;
    }

    public String getBeat() {
        return beat;
    }

    public String getOfficerName() {
        return officerName;
    }

    public String getOfficerId() {
        return officerId;
    }

    public String getReasonForStop() {
        return reasonForStop;
    }

    public String getStopLocation() { return stopLocation; }

    public String getDisposition() {
        return disposition;
    }

    public String getOtherInformationComments() {
        return otherInformationComments;
    }

    public String getCaseID() { return caseID; }
}
