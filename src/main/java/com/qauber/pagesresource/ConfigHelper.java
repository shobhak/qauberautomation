package com.qauber.pagesresource;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/**
 * Created by erikfriedlander on 1/5/17.
 */
public class ConfigHelper {
    public static ConfigOOP getConfigFile() { //returns the config object - TODO: move this to another class...
        ConfigOOP configObj = null;
        try {
            configObj = FileManager.getConfigObject(FileManager.getConfigFileName(), ConfigOOP.class);
            System.out.println(configObj.getBaseURL());
        } catch (IOException e) { //If config not found, do something
            System.out.println("Config not found, creating ~/QAUberTestConfig/config.txt");
            List<String> comments = Arrays.asList("Default config file", "Browser name needs to be capitalized. Options - CHROME, FIREFOX, SAFARI, EDGE", "BaseURL should be in form of http://www.website.com", "We go");
            FileManager.writeConfigObject(new ConfigOOP(), FileManager.getConfigFileName(), comments);
        } catch (Exception e) { //if config invalid, do something else - TODO: generate config?
            System.out.println("Invalid config or other exception, recreating ~/QAUberTestConfig/config.txt");
            List<String> comments = Arrays.asList("INVALID CONFIG FOUND, overwriting with defaults.", "Default config file", "Browser name needs to be capitalized. Options - CHROME, FIREFOX, SAFARI, EDGE", "It's off to work", "We go");
            FileManager.writeConfigObject(new ConfigOOP(), FileManager.getConfigFileName(), comments);
        }
        return configObj;
    }
}
