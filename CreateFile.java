package qauber.com.testwave;

import java.io.*;

public class CreateFile {
	public static void main(String[]args){
	
File f = new File("C:\\Users\\shobha\\Desktop");{
 try{
    if(f.mkdir()) { 
        System.out.println("Directory Created");
    }//if 
    else {
        System.out.println("Directory is not created");
    }//else
 }//try
 catch(Exception e){
    e.printStackTrace();
}//catch
 
}
	}
}//CreateFile


