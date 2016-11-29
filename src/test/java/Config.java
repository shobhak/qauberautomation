import com.qauber.testrail.APIClientExtension;

/**
 * Created by erikfriedlander on 11/29/16.
 */
public class Config {

    private final static int RUNID = 528;

    public static int getRunID() {
        return RUNID;
    }

    public static APIClientExtension testRailLogin() { //passes back a logged in client
        APIClientExtension client = new APIClientExtension("https://bidqa.testrail.net/");
        client.setUser("Testers@qauber.com");
        client.setPassword("qauber2016!");

        return client;
    }

}
