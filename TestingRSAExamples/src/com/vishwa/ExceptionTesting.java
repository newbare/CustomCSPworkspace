package com.vishwa;

import java.util.Date;

public class ExceptionTesting {
	
	public static void main(String[]args)
	{
		try{
			Date now = new Date();
			System.out.println(now);
			int y=Integer.parseInt("hh");
			
			int x=1/0;
			
			System.out.println(x+y);
		}
		catch(Exception e)
		{
			System.out.println(e);
			System.out.println(e.getMessage());
			System.out.println(e.getLocalizedMessage());
			System.out.println(e.getCause());
			e.printStackTrace();
		}
	}

}
