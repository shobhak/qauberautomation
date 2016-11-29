package com.qauber.testrail;

import com.gurock.testrail.APIClient;
import com.gurock.testrail.APIException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by erikfriedlander on 11/22/16.
 */
public class APIClientExtension extends APIClient {

    //APIClientExtension has one constructor
    public APIClientExtension(String base_url) {
        super(base_url);
    }

    //getTest - pass the test case number (without the letter)
    //Returns a JSONObject
    public JSONObject getTest(int testcase) {
        JSONObject c = null;
        try {
            c = (JSONObject) this.sendGet("get_test/" + testcase);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (APIException e) {
            e.printStackTrace();
        }

        return c;

//        if (c == null) {
//            //System.out.println(String.format("null object of type: %s", JSONArray.class));
//            return JSONObject.class;
//        } else {
//            return c;
//        }
    }

    //getTests - pass the test run number (without the letter), returns a JSONArray
    //returns a JSONArray
    //Example:
    //JSONArray results = (JSONArray) client.getTests(528);

    public JSONArray getTests(int testrun) {
        JSONArray c = null;
        try {
            c = (JSONArray) this.sendGet("get_tests/" + testrun);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (APIException e) {
            e.printStackTrace();
        }

        return c;

//        if (c == null) {
//            //System.out.println(String.format("null object of type: %s", JSONArray.class));
//            return JSONArray.class;
//        } else {
//            return c;
//        }

    }

    //addResult  - adds a new test result, comment or assigns a test
    //accepts parameters listed
    //statusid is as following: 1 - passed, 2 - blocked,
    //3 - untested (not allowed when adding a result)
    //4 - Retest
    //5 - Failed
    //
    //Example of use:
    //JSONObject resultsObject = (JSONObject) client.addResult(528, 69234, 4, "API is testing Comments", "API is testing custom_testerresult");
    //
    //sample data which works on WAVE:
    //        runid = 528;
    //        testid = 69234;
    //        statusid = 4;
    //        String comment = "This comment is not being used yet";
    //
    //see http://docs.gurock.com/testrail-api2/reference-results for more
    //
    //change statusid to string at some point? add nice pass/fail/retest/etc handling... if statusid = "1" or (not case sensitive) "Pass" data.put("status_id", 1), if (2), if (...), else throw (something)
    //CHANGE OBJECT TYPE to 'JSONObject' in the rest of the code you little JSON - look up 'type signature' for a nice way to do this

    public JSONObject addResult(int runid, int caseid, int statusid, String comment, String custom_testerresult) throws IllegalStateException {

        JSONObject c = null;

        Map data = new HashMap();
        data.put("run_id", runid);
        data.put("caseid", caseid);
        data.put("status_id", statusid);
        data.put("comment", comment);
        data.put("custom_testerresult", custom_testerresult);

        System.out.println(data);

        // Nice to have, with some safety
//        Object returnedValue = this.sendPost("add_result_for_case/"+runid+"/"+caseid+"", data);
//        if(returnedValue instanceof JSONObject) {
//            // do something nice
//            c = (JSONObject) returnedValue;
//        } else {
//            // do something not nice,
//            // i.e throw an exception becasue you realize that
//            // this is not an object of type JSONObject.
//        }

        //
        try {
            c = (JSONObject) this.sendPost("add_result_for_case/"+runid+"/"+caseid+"", data);
        } catch (IOException e) {
            e.printStackTrace();
            //throw new IllegalStateException("") - handle IO
        } catch (APIException e) {
            //add code to retry? for/loop outside the try w/ counter, nested try/catch (bad),
            //throw new IllegalStateException("") - handle APIException
            e.printStackTrace();
        }
        if (c == null) {
            //System.out.println(String.format("null object of type: %s", JSONArray.class));
            throw new IllegalStateException("c == null in JSONObject");
//                return JSONObject.class;
        } else {
            System.out.println(c);
            return c;
        }
    }
}