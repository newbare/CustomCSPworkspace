package com.vishwa;

import java.io.FileWriter;
import java.io.IOException;

public class GenerateCsv
{
   public static void main(String [] args)
   {
	   generateCsvFile("D:\\test.csv"); 
   }
   
   private static void generateCsvFile(String sFileName)
   {
	try
	{
	    FileWriter writer = new FileWriter(sFileName);
		 
	    writer.append("DisplayName");
	    writer.append(',');
	    writer.append("Age");
	    writer.append('\n');

	    writer.append("MKYONG");
	    writer.append(',');
	    writer.append("26");
        writer.append('\n');
			
	    writer.append("YOUR NAME");
	    writer.append(',');
	    writer.append("29");
	    writer.append('\n');
			
	    //generate whatever data you want
			
	    writer.flush();
	    writer.close();
	    System.out.println("Done!!!");
	}
	catch(IOException e)
	{
	     e.printStackTrace();
	} 
    }
}