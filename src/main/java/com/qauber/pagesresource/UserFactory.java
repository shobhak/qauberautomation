package com.qauber.pagesresource;

import com.qauber.pages.RegistrationPage1;
import com.qauber.pages.RegistrationPage2;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by erikfriedlander on 12/18/16.
 * UserFactory should contain code to (read from config or generate) and return valid users.
 *
 */
public class UserFactory {

    //Constructor
    public UserFactory() {

    }

    //getUser takes a userType and returns a user with the following approach:
    //1. Read user info from config
    //2. If config not found, generate user with defaults
    //TODO: change user generate to actually activate a user through the website.
    public User getUser(User.UserType userType) {

        User user;

        //Read user data from file?
        try {
            user = getUserLoginFileData(userType); //set user from file

        } catch (NullPointerException e) { //If file not found, create a new user of that type
            user = generateUser(userType); //GENERATE USER

            //TODO: improve file not found handling
            System.out.println("User Config File not found: generating config files and new user");
            System.out.println("see ~/QAUberTestConfig/ for config files");

            setUserLoginFileData(user);
            //throw new FileNotFoundException();
        }

        return user;

   }



   private User generateUser(User.UserType userType) {

       User user = new User();
       GenerateRandomSuperAdminUser randomSuperAdminUserGenerator = new GenerateRandomSuperAdminUser();

       if (userType == userType.SAU) {
           try { //attempt to make a new SAU
               System.out.println("Attempting to generate new super admin user. Please be patient, this may take up to 5 minutes.");
               user = randomSuperAdminUserGenerator.generateRandomSuperAdminUser("http://testwave.qabidder.net");
           } catch (InterruptedException e) { //if failed, set default config
               user.setUsername("SAU@mailinator.com");
               user.setPassword("12345678");
           }
       }
       else if (userType == userType.AU) {
           user.setUsername("AU@mailinator.com");
           user.setPassword("12345678");
       }
       else { //userType is RU
           user.setUsername("RU@mailinator.com");
           user.setPassword("12345678");
       }
       user.setUserType(userType); //write user to disk

       return user;

   }


    public User getUserLoginFileData(User.UserType userType) {

        //TODO: handle exception (File Read Failed, empty string, etc)

//        List<String> lines = FileManager.getFile("validlogins/sau.txt");

        String fileName = getFileName(userType);

        User user = new User();

        List<String> lines = null;
        try {
            lines = FileManager.getFile(fileName);
        } catch (IOException e) {
//            e.printStackTrace();
            System.out.println("IOException: Probably file "+fileName+" not found");
        }
        user.setUsername(lines.get(0));
        user.setPassword(lines.get(1));
        user.setUserType(userType);

        return user;

    }

//    public User getUserLoginFileData() throws IOException {
//        return getUserLoginFileData(User.UserType.SAU);
//    }

    public void setUserLoginFileData(User user) {
        //TODO: make this do something
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append(user.getUsername()); //Add username
        stringBuilder.append(System.getProperty("line.separator")); //add system-portable line separator

        stringBuilder.append(user.getPassword()); //Add username
        stringBuilder.append(System.getProperty("line.separator")); //add system-portable line separator

        stringBuilder.append(user.getUserType());
        stringBuilder.append(System.getProperty("line.separator")); //add system-portable line separator

        String data = stringBuilder.toString(); //turn this into a string!

        try {
            FileManager.setFile(getFileName(user.getUserType()), data);
        } catch (IOException e) {
            e.printStackTrace();
            //TODO: if we can't write the file, do something more exciting
        }
    }

    private String getFileName(User.UserType userType) {
        String fileName;
        if (userType == userType.SAU) {
            fileName = "sau.txt";
        }
        else if (userType == userType.AU) {
            fileName = "au.txt";
        }
        else { //userType RU
            fileName = "ru.txt";
        }
        fileName = System.getProperty("user.home") + File.separator + "QAUberTestConfig" + File.separator + fileName;
        System.out.println(fileName);

        return fileName;
    }

    private boolean registerAndActivateSAU(User user) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        Mailinator mailinator = new Mailinator(driver);
        RegistrationPage1 registrationPage1 = new RegistrationPage1(driver);
        RegistrationPage2 registrationPage2 = new RegistrationPage2(driver);


        if (user.getUserType() == user.userType.AU) {
            registrationPage1.registerUser1(user.getName(), user.getUsername(), user.getPassword());
//            registrationPage2.
            return true;
        }

        else return false;
    }

    public void wipeLocalUserConfig() { //delete local user configuration files, but not directory

        for (User.UserType userType: User.UserType.values()) {
            System.out.println("Deleting: "+getFileName(userType).toString());
            File file = new File(getFileName(userType));
            file.delete();
        }
    }

    public void wipeLocalUserConfig(User.UserType userType) {
        System.out.println("Deleting: "+getFileName(userType).toString());
        File file = new File(getFileName(userType));
        file.delete();
    }

}
