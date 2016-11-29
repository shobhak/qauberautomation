import com.qauber.testrail.APIClientExtension;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

/**
 * Created by erikfriedlander on 11/22/16.
 */
public class SampleTestRailAPIUsage {

    public static void main (String[] args) {

        //Log in

//        APIClientExtension client = new APIClientExtension("https://bidqa.testrail.net/");
//        client.setUser("Testers@qauber.com");
//        client.setPassword("qauber2016!");
        APIClientExtension testrailClient = Config.testRailLogin(); //Log in to TestRail
        int runid = Config.getRunID();
        int testid = 69234;

        //Initialization
        JSONArray resultsArray;
        JSONObject resultsObject;

        resultsArray = testrailClient.getTests(runid);
        System.out.println(resultsArray);

        resultsObject = testrailClient.getTest(testid);
        System.out.println(resultsObject);

        try {
            resultsObject = testrailClient.addResult(Config.getRunID(), testid, 4, "Testing Turkey Day", "API is testing custom_testerresult");
        } catch (IllegalStateException e) {
            e.printStackTrace();
        }

    }
}
