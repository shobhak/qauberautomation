package qauber.com.testwave;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

/*This class creates a file with a timestamp including the current month,
 *  day and year 
 * 
 */
public class CreateFile {
	public static void main(String[]args){
	
		String fileName = new SimpleDateFormat("MMddyyyyhhmm'.txt'").format(new Date());
	     
		 new File(fileName).mkdir();

	}//main
}//CreateFile


