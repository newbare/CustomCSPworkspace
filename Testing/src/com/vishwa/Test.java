package com.vishwa;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test {

	public static void main(String[] args) {
		
		String s1="00.00.112";
        String s2="00.00.103";
        double f=00.00;
        String s3="00.00.99";
        //int aa=Integer.parseInt(s3);
        //System.out.println(aa);
        String []ss={"00.23.11","00.22.11","00.00.113","00.00.99"};
        List<String> list=Arrays.asList(ss);
        for(int i=0;i<list.size()-1;i++)
        {
        	boolean aa=list.get(i).equals(list.get(i+1));
        	if(aa)
        	{
        		System.out.println("Version is listed in descending order");
        	}
        	else
        		System.out.println("Version is listed not in descending order");
        }
        
        int n1=s1.compareTo(s2);
        System.out.println(n1);
        if(n1>0)
        	System.out.println(true);
        else
        	System.out.println(false);
        
        

	}

}
