package com.qauber.pagesresource;

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
        this.tester = tester;
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

    public void addResults(TestCaseResult status, String comments) { //TODO: This method really should be another class, that will come later. Maybe this will call TestRailAPIClientExtension.
        //TODO: implement addResults functionality...
        //maybe read comments from log?
        System.out.println("==============================================================================");
        System.out.println("Run ID: "+runID);
        System.out.println("Test Case ID: "+caseID);
        System.out.println("Result: "+status.toString()+", statusID = "+statusID);
        System.out.println("Comments: "+comments);
        System.out.println("Tester: "+tester);
        System.out.println("================= TestRail(addResults(TestCaseResult status, String comments))");

    }
}

