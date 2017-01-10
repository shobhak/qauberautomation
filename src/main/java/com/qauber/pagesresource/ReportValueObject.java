package com.qauber.pagesresource;

import com.github.javafaker.Faker;
import com.qauber.common.value.BuildValue;
import com.qauber.common.value.EyeColorValue;
import com.qauber.common.value.SexValue;
import com.qauber.common.value.SuspectTypeValue;

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
    private SuspectTypeValue suspectType;
    private String dateOfBirth;
    private String nickName;
    private String race;
    private String height;
    private String weight;
    private String hairColor;
    private String hairLength;
    private String hairStyle;
    private SexValue sex;
    private BuildValue build;
    private EyeColorValue eyeColor;
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

    //ID information
    private String primaryLanguage;
    private String streetAddress;
    private String city;
    private String country;
    private String stateDropBox;
    private String state;
    private String zip;
    private String telephone;
    private String email;
    private String socialSecurity;
    private String occupation;
    private String driverLicense;
    private String driverLicenseState;
    private String otherId;
    private String otherIdCountry;
    private String otherIdStateDropBox;
    private String otherIdState;
    private String otherIdType;
    private String schoolName;
    private String schoolAddress;
    private String schoolCity;
    private String schoolState;
    private String schoolZip;
    private String schoolTelephone;
    private String parentName;
    private String parentAddress;
    private String parentCity;
    private String parentState;
    private String parentZip;
    private String parentTelephone;
    private String employerName;
    private String employerAddress;
    private String employerCity;
    private String employerState;
    private String employerZip;
    private String employerTelephone;

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

    //vehicle
    private String pedestrianCheckBox;
    private String passengerCheckBox;
    private String driverCheckBox;
    private String vehicleLicense;
    private String vehicleMake;
    private String vehicleModel;
    private String vehicleBodystyle;
    private String vehicleColor;
    private String vehicleYear;
    private String vehicleOddities;

    //preview
    private String caseID;

    //Constructor
    public ReportValueObject(){
        faker = new Faker();

        firstName = faker.name().firstName();
        middleName = faker.name().lastName();
        lastName = faker.name().lastName();
        nickName = faker.lorem().word();
        suspectType = SuspectTypeValue.getRandomValue();
        sex = SexValue.getRandomValue();
        build = BuildValue.getRandomValue();
        eyeColor = EyeColorValue.getRandomValue();

        tattoos = faker.lorem().word();
        scars = faker.lorem().word();
        needleMarks = faker.lorem().word();
        tracks = faker.lorem().word();
        glasses = faker.lorem().word();
        mustache = faker.lorem().word();
        beard = faker.lorem().word();

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

        primaryLanguage = faker.lorem().word();
        streetAddress = faker.address().streetAddress();
        city = faker.address().city();
        state = faker.lorem().word();
        zip = faker.address().zipCode();
        telephone = faker.phoneNumber().cellPhone();
        email = faker.internet().emailAddress();
        socialSecurity = faker.number().digits(9); //faker.idNumber().ssnValid();
        occupation = faker.lorem().word();
        driverLicense = faker.idNumber().valid();
        otherId = faker.idNumber().valid();
        otherIdState = faker.lorem().word();
        otherIdType = faker.lorem().word();
        schoolName = faker.lorem().word();
        schoolAddress = faker.address().streetAddress();
        schoolCity = faker.address().city();
        schoolZip = faker.address().zipCode();
        schoolTelephone = faker.phoneNumber().cellPhone();
        parentName = faker.name().fullName();
        parentAddress = faker.address().streetAddress();
        parentCity = faker.address().city();
        parentZip = faker.address().zipCode();
        parentTelephone = faker.phoneNumber().cellPhone();
        employerName = faker.name().fullName();
        employerAddress = faker.address().streetAddress();
        employerCity = faker.address().city();
        employerZip = faker.address().zipCode();
        employerTelephone = faker.phoneNumber().cellPhone();

        vehicleLicense = faker.idNumber().valid();
        vehicleMake = faker.lorem().word();
        vehicleModel = faker.lorem().word();
        vehicleBodystyle = faker.lorem().word();
        vehicleColor = faker.color().name();
        vehicleYear = faker.number().digits(4);
        vehicleOddities = faker.lorem().word();

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
    public SuspectTypeValue getSuspectType() {
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

    public String getHairColor() {
        return hairColor;
    }

    public String getHairLength() {
        return hairLength;
    }

    public String getHairStyle() {
        return hairStyle;
    }

    public SexValue getSex() {
        return sex;
    }

    public BuildValue getBuild() {
        return build;
    }

    public EyeColorValue getEyeColor() {
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

    public String getPrimaryLanguage() {
        return primaryLanguage;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public String getCity() {
        return city;
    }

    public String getCountry() {
        return country;
    }

    public String getStateDropBox() {
        return stateDropBox;
    }

    public String getState() {
        return state;
    }

    public String getZip() {
        return zip;
    }

    public String getTelephone() {
        return telephone;
    }

    public String getEmail() {
        return email;
    }

    public String getSocialSecurity() {
        return socialSecurity;
    }

    public String getOccupation() {
        return occupation;
    }

    public String getDriverLicense() {
        return driverLicense;
    }

    public String getDriverLicenseState() {
        return driverLicenseState;
    }

    public String getOtherIdStateDropBox() {
        return otherIdStateDropBox;
    }

    public String getOtherId() {
        return otherId;
    }

    public String getOtherIdCountry() {
        return otherIdCountry;
    }

    public String getOtherIdState() {
        return otherIdState;
    }

    public String getOtherIdType() {
        return otherIdType;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public String getSchoolAddress() {
        return schoolAddress;
    }

    public String getSchoolCity() {
        return schoolCity;
    }

    public String getSchoolState() {
        return schoolState;
    }

    public String getSchoolZip() {
        return schoolZip;
    }

    public String getSchoolTelephone() {
        return schoolTelephone;
    }

    public String getParentName() {
        return parentName;
    }

    public String getParentAddress() {
        return parentAddress;
    }

    public String getParentCity() {
        return parentCity;
    }

    public String getParentState() {
        return parentState;
    }

    public String getParentZip() {
        return parentZip;
    }

    public String getParentTelephone() {
        return parentTelephone;
    }

    public String getEmployerName() {
        return employerName;
    }

    public String getEmployerAddress() {
        return employerAddress;
    }

    public String getEmployerCity() {
        return employerCity;
    }

    public String getEmployerState() {
        return employerState;
    }

    public String getEmployerZip() {
        return employerZip;
    }

    public String getEmployerTelephone() {
        return employerTelephone;
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

    public String getPedestrianCheckBox() {
        return pedestrianCheckBox;
    }

    public String getPassengerCheckBox() {
        return passengerCheckBox;
    }

    public String getDriverCheckBox() {
        return driverCheckBox;
    }

    public String getVehicleLicense() {
        return vehicleLicense;
    }

    public String getVehicleMake() {
        return vehicleMake;
    }

    public String getVehicleModel() {
        return vehicleModel;
    }

    public String getVehicleBodystyle() {
        return vehicleBodystyle;
    }

    public String getVehicleColor() {
        return vehicleColor;
    }

    public String getVehicleYear() {
        return vehicleYear;
    }

    public String getVehicleOddities() {
        return vehicleOddities;
    }
}

