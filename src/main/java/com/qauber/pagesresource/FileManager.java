package com.qauber.pagesresource;

import com.google.common.collect.Lists;
import org.apache.commons.io.FileUtils;
import org.yaml.snakeyaml.Yaml;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.InvalidPropertiesFormatException;
import java.util.List;

/**
 * Created by erikfriedlander on 12/17/16.
 * Static class to read and write files.
 * MAKE SURE ANY FILE READ/WRITE ADDS getBasePath() to filename!
 */
public class FileManager {


    //TODO: Move path in from UserFactory? Next two lines are probably outdated, check and delete.
    //relative path starts at test/resources
    //etc. file in test/resources/validlogins is "validlogins/sau.txt"

    public static String getBasePath() {
        return System.getProperty("user.home") + File.separator + "QAUberTestConfig" + File.separator;
    }

    public static String getDownloadPath() {//if no dialog box asking for "open" or "save"
        return System.getProperty("user.home") + File.separator + "Downloads" + File.separator;
    }

    public static List<String> getFileAsStringList(String fileName) throws IOException { //gets file at getBasePath as List<String>
        return FileUtils.readLines(new File(getBasePath()+fileName), Charset.defaultCharset());
    }

    public static String getFileAsString(String fileName) throws IOException { //gets file at getBasePath as String
        return FileUtils.readFileToString(new File(getBasePath()+fileName), Charset.defaultCharset());
    }

    public static void setFile(String fileName, String data) throws IOException { //sets file at getBasePath
        //CURRENT BEHAVIOR IS OVERWRITE: TO CHANGE, ADD 'true' to FileWriter:
        FileUtils.writeStringToFile(new File(getBasePath()+fileName), data, Charset.defaultCharset());
    }


    protected static String getUserFileName(User.UserType userType) {
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
        //fileName = getBasePath() + fileName;
        System.out.println(fileName);

        return fileName;
    }

    protected static String getFileName(String desiredLogFileNameTestIDMaybe) { //TODO: pass in logger? Is this code even used?
        String fileName = desiredLogFileNameTestIDMaybe + ".log";
        System.out.println("Log file: "+fileName);
        return fileName;
    }

    public static String getConfigFileName() {
        return "config.txt";
    }

    protected static List<String> getConfigFile() throws IOException { //TODO: pass in logger? Is this code even used?
        String fileName = getConfigFileName();
        System.out.println("Config: "+fileName);
        return getFileAsStringList(fileName);
    }

    public static <T> T getConfigObject(String fileName, Class<T> type) throws IOException { //pass in fileName and class
        //Instantiate SnakeYAML
        Yaml yaml = new Yaml();

        //Read config file into Config OOP
        try {
            return yaml.loadAs(FileManager.getFileAsString(fileName), type);
        } catch (IOException e) { //could not read file / file not found
            e.printStackTrace();
        } catch (Exception e) { //invalid property in config
            throw new InvalidPropertiesFormatException(e.getLocalizedMessage());
        }
        return (T) yaml; //this line should never run
    }

    public static void writeConfigObject(Object objectToWrite, String fileName, List<String> comments) { //at least describe what the config file is for
        Yaml yaml = new Yaml();

        //Write (dump) object to SnakeYAML
        String output = yaml.dumpAsMap(objectToWrite);
        System.out.println(output);

        /* Write to output file */
        //THIS SHOULD ONLY LET YOU WRITE TO FILES IN BASEPATH!
        try {
            BufferedWriter out = new BufferedWriter(new FileWriter(FileManager.getBasePath()+fileName, false)); //overwrite existing configg
            for (String s : comments) {
                out.write("#" + s);
                out.write(System.lineSeparator());
            }
            out.write(output);
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void writeConfigObject(Object objectToWrite, String fileName, String comment) { //at least describe what the config file is for
        writeConfigObject(objectToWrite, fileName, Lists.newArrayList(comment));
    }
}
