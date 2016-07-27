package mypackage;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;


public interface Variables_ {
	Random rand = new Random();
	int n = rand.nextInt(1000) + 5;

	            // Step1.Open http://testwave.qabidder.net/#/page/login
				String baseUrl = "http://testwave.qabidder.net/#/page/login";
				
				// Date format for Folder
				DateFormat df = new SimpleDateFormat("MM.dd.yyyy");
				Date today = Calendar.getInstance().getTime();
				String reportDate = df.format(today);
				//System.out.println("Report Date: " + reportDate);
				
				// Date format for File
				DateFormat df2 = new SimpleDateFormat("MM_dd_yyyy_HH_mm_ss");
				Date today2 = Calendar.getInstance().getTime();
				String reportDate2 = df2.format(today2);
				//System.out.println("Report Date: " + reportDate2);

				
}
