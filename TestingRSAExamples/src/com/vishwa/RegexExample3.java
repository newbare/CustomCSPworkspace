package com.vishwa;
import java.util.regex.*;  
class RegexExample3{  
	static String str="mmmm";
	public static void main(String args[]){  
		System.out.println(Pattern.matches("[amn]", "amn"));//false (not a or m or n)   
		System.out.println(str.matches("[amn]{1,10}"));
		System.out.println(Pattern.matches("[amn]", "n"));//true (among a or m or n)  
		System.out.println(Pattern.matches("[amn]", "ammmna"));//false (m and a comes more than once) 
		long l=1;
		Long l1=new Long(1);
		System.out.println(l==l1);
		
		Integer inte=new Integer(1);
		System.out.println(inte.intValue()==(int)l);
		Integer xys=new Integer(1);
		
		System.out.println(xys.equals(inte));
	}}