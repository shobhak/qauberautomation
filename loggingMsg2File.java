//import java.util.*;
//import org.apache.commons.io.FileUtils;
//import org.apache.log4j.*;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;


/* This class is written to verify the logging functionality using the log4j package
 * from apache to print the log messages to a file. Using this a tester can print out messages from running a test case
 *  to  a file.
 * tester- Shobha Vaidyanathan 
 * 
 * *
	/*levels for the logging message
	 * * Debug
	 * Info
	 * Warn
	 * Error
	 * Fatal
	 * VM Argument -Dlog4j.debug = true
	 */
	
public class loggingMsg2File {
	//declaring a static variable
	private static final Logger log = LogManager.getLogger(loggingMsg2File.class.getName());	
	
	public static void main(String[]args){
		BasicConfigurator.configure();
		PropertyConfigurator.configure(log4j.properties);
		log.info("This is the information ");
	    runMethod();
	    log.debug("This is the additional info");
	}//main
	 
	public static void runMethod(){
		log.info("This is from run method");
		
	}//runMethod
	}//loggingFile.





