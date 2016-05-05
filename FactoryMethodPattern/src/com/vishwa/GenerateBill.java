package com.vishwa;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class GenerateBill {
	
	public static void main(String...args) throws IOException
	{
		GetPlanFactory getPlanFactory=new GetPlanFactory();
		System.out.println("Enter the name of the Plan for which bill will be generated:");
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String planName=br.readLine(); 
		System.out.println("Enter the number of units for which bill will be generated");
		int units=Integer.parseInt(br.readLine());
		Plan plan=getPlanFactory.getPlanType(planName);
		System.out.println("Bill amount for the "+planName+" of "+units+" units is:::");
		plan.getRate();
		plan.calculate(units);
		
	}

}
