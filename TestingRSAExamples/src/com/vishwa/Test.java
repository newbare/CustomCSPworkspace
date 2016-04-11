package com.vishwa;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Properties;

public class Test {

	public static void main(String[] args) throws IOException {
		String keys [] =
	        {
	        "java.vendor", "java.vendor.url",
	        "java.version", "java.class.version",
	        "os.name", "os.arch", "os.version",
	        "file.separator", "path.separator",
	        "line.separator", "browser",
	        "browser.vendor", "browser.version"
	        };
	  /*  for (int i = 0; i < keys.length; i++)
	        {
	        try 
	        {
	        String key = keys[i];
	        String value = System.getProperty (key);
	        String textArea = "Key :" + key + ": = :" + value + ":\n";
	         System.out.println(textArea);
	        }
	        catch (SecurityException see) { ; }
	        }*/
	    
	    Properties props = System.getProperties();
	    Enumeration e = props.propertyNames();
	    while (e.hasMoreElements())
	        {
	    	String  key = (String) e.nextElement();
	    	String  value = props.getProperty (key);
	    	 String textArea = "Key :" + key + ": = :" + value + ":\n";
	         System.out.println(textArea);
	        }
		
		/*ArrayList<String> output = new ArrayList<String>();
				//Process p = Runtime.getRuntime().exec("reg query \"HKLM\\Software\\Microsoft\\Internet Explorer\" /v Version");
				Process p = Runtime.getRuntime().exec("reg query \"HKLM\\Software\\Mozilla\\Mozilla Firefox\" /v Version");
				BufferedReader stdInput = new BufferedReader(new InputStreamReader(p.getInputStream()),8*1024);
				BufferedReader stdError = new BufferedReader(new InputStreamReader(p.getErrorStream()));
				String s = null;
				System.out.println("Here is the standard output of the command:\n");
				while ((s = stdInput.readLine()) != null)
				output.add(s);

				String internet_explorer_value = (output.get(2));
				String version = internet_explorer_value.trim().split("   ")[2];
				System.out.println(version);*/
	}

}
