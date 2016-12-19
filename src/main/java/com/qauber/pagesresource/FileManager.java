package com.qauber.pagesresource;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.List;

/**
 * Created by erikfriedlander on 12/17/16.
 * Static class to read and write files.
 */
public class FileManager {


    //TODO: Move path in from UserFactory? Next two lines are probably outdated, check and delete.
    //relative path starts at test/resources
    //etc. file in test/resources/validlogins is "validlogins/sau.txt"

//    public static List<String> getFile(String fileName) throws IOException {
//        InputStream inputStream = ClassLoader.getSystemResourceAsStream(fileName);
//        List<String> lines = null;
//        try {
//            lines = IOUtils.readLines(inputStream, "UTF-8");
//            inputStream.close(); //close file
//        } catch (NullPointerException e) {
//            throw new FileNotFoundException("Null Pointer, File " + fileName + " Not Found");
//        } catch (IOException e) {
//            throw new IOException("Unable to read file " + fileName + " : Insufficient privileges");
//        }
//
//        return lines;
//
////        for (String line : lines) {
////            System.out.println(line);
////        }
//
//    }

    public static List<String> getFile(String fileName) throws IOException {
        File file = new File(fileName);
        List<String> data = FileUtils.readLines(file, Charset.defaultCharset());
        return data;
    }

    public static void setFile(String fileName, String data) throws IOException { //CURRENT BEHAVIOR IS OVERWRITE: TO CHANGE, ADD 'true' to FileWriter:
        // FileWriter fileWriter = new FileWriter(fileName, true));

        //Create file path
        File file = new File(fileName);
        FileUtils.writeStringToFile(file, data, Charset.defaultCharset());
//
//  try { //Try should close file at end.
////            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
//            PrintWriter printWriter = new PrintWriter(fileName, "UTF-8");
//            printWriter.println(data);
//            System.out.println("FileName: "+fileName);
//            System.out.println("File Data: "+data);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

    }

}
