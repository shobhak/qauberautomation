import java.util.*;
import org.apache.log4j.*;
import org.apache.commons.io.FileUtils;

public class newlogMsg2file {
	static Logger log =  Logger.getLogger(newlogMsg2file.class);

	public static void main(String[]args){
		PropertyConfigurator.configure("log4j.properties");
		log.info("This is the information ");
	    runMethod();
	    log.debug("This is the additional info");
	}

	 public static void runMethod() {
		log.info("This info message is from the run method");
	 
	 }
	 }
