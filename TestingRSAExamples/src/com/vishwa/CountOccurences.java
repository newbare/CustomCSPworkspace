package com.vishwa;

import java.util.HashMap;
import java.util.Map;

public class CountOccurences {

	 static int arr[] = {10, 3 , 5, 10,3,5,10, 7};
	 static HashMap<Integer, Integer> h  = new HashMap<Integer, Integer>();
	 static void printoccurences(int a[])
	 {
	  for(int i=0; i<a.length; i++)
	  {
	   Integer  c =   h.get(a[i]);
	   if(h.get(a[i]) == null)
	   {
	    h.put(a[i], 1);
	   }
	   
	   else
	   {
	    h.put(a[i], ++c);
	   }
	   
	  }
	  
	  for(Map.Entry m: h.entrySet())
	  {
	   System.out.println("occurence of " + m.getKey() + 
	                    " is " + m.getValue());
	  }
	  
	 }
	 
	 public static void main(String[] args) {
	  
	  printoccurences(arr);
	 }
}