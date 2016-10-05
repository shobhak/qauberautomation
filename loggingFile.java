import java.util.*;
import org.apache.log4j.*;

/* This class is written to verify the logging functionality using the log4j package
 * from apache. Using this a tester can print out messages from running a test case
 * either to a console or database or an email or a file.The intent being that at the 
 * end of each session console messages will disappear and in the process a tester
 * may miss valuable information for future usage.
 * tester- Shobha Vaidyanathan 
 * 
 * */


public class loggingFile {
	/*created a class here */
	/*levels for the logging message
	 * * Debug
	 * Info
	 * Warn
	 * Error
	 * Fatal
	 * @paramargs
	 */
	
	//declaring a static variable
	static Logger log = Logger.getLogger(loggingFile.class);	
	
	public static void main (String[]args){
		
		BasicConfigurator.configure();
		Properties log4jprop = new Properties();
		log4jprop.setProperty("log4j.rootlogger", "DEBUG,CA");//CA means console appender.
		log4jprop.setProperty("log4j.appender.CA", "org.apache.log4j.ConsoleAppender");
		log4jprop.setProperty("log4j.appender.CA.layout","org.apache.log4j.PatternLayout");
		log4jprop.setProperty("log4j.appender.CA.layout.ConversionPattern", "%d{yyyy-MM-dd}-- %-10p %c -%m%n");
		PropertyConfigurator.configure(log4jprop);
		log.info("This is the information ");
	    runMethod();
	    log.debug("This is the additional info");
	}//main
	public static void runMethod(){
		log.info("This is from run method");
		
	}//runMethod
	}//loggingFile.


