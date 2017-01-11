package com.qauber.pagesresource;

import com.qauber.testrail.APIClientExtension;

import java.util.Map;

/**
 * Created by erikfriedlander on 12/24/16.
 * http://docs.gurock.com/testrail-api2/reference-results#add_result
 */
public class TestRail {
    private int runID;
    private int caseID;
    private TestCaseResult status;
    private int statusID;
    private String comments;
    private String tester;
    private String testRailURL;
    private APIClientExtension client;
//    private int elapsed;


    public enum TestCaseResult {
        PASSED,
        BLOCKED,
        RETEST,
        FAILED
    }

    public TestRail() {
        this(528);
    }

    public TestRail(int runID) {
        this.runID = runID;
        this.tester = "Who didn't fill out this field?";
        this.client = testRailLogin();
    }

    public int getRunID() {
        return runID;
    }

    public void setRunID(int runID) {
        this.runID = runID;
    }

    public int getCaseID() {
        return caseID;
    }

    public void setCaseID(int caseID) {
        this.caseID = caseID;
    }

    public String getTester() {
        return tester;
    }

    public void setTester(String tester) {
        this.tester = "Tester is "+tester+": running on computer "+getComputerName(); //TODO: we should load computerName from config file
    }

    private TestCaseResult getStatus() {
        return status;
    }

    private void setStatus(TestCaseResult status) {
        this.status = status;
        if (status == TestCaseResult.PASSED) { statusID = 1; }
        else if (status == TestCaseResult.BLOCKED) { statusID = 2; }
        else if (status == TestCaseResult.RETEST) { statusID = 4; }
        else { statusID = 5; } // (status == TestCaseResult.FAILED)
    }

    private int getStatusID() {
        return statusID;
    }

    public String getTestRailURL() {
        return testRailURL;
    }

    protected void setTestRailURL(String testRailURL) {
        this.testRailURL = testRailURL;
    }

    //=======================
    //TODO: This method really should be another class, but out of time and have to push this out.
    //For now, this will create a local APIClientExtension... this should be in PageObjectModelResources or something of the sort.
    //=======================
    public void addResults(TestCaseResult status, String comments) {
        //TODO: read comments from log?
        setStatus(status);
        client.addResult(getRunID(), getCaseID(), getStatusID(), comments, getTester());

        System.out.println("==============================================================================");
        System.out.println("Run ID: "+runID);
        System.out.println("Test Case ID: "+caseID);
        System.out.println("Result: "+status.toString()+", statusID = "+statusID);
        System.out.println("Comments: "+comments);
        System.out.println("Tester: "+tester);
        System.out.println("================= TestRail(addResults(TestCaseResult status, String comments))");
    }

    public static APIClientExtension testRailLogin() { //passes back a logged in client
        APIClientExtension client = new APIClientExtension("https://bidqa.testrail.net"); //TODO: not hardcode these
        client.setUser("Testers@qauber.com");
        client.setPassword("qauber2016!");
        return client;
    }

    private String getComputerName() //Denis liked this - http://stackoverflow.com/questions/7883542/getting-the-computer-name-in-java
    {
        Map<String, String> env = System.getenv();
        if (env.containsKey("COMPUTERNAME"))
            return env.get("COMPUTERNAME");
        else if (env.containsKey("HOSTNAME"))
            return env.get("HOSTNAME");
        else
            return "Unknown Computer";
    }
}

