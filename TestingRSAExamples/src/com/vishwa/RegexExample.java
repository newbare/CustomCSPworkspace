package com.vishwa;

import java.util.Scanner;

public class RegexExample {

	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter any String:::");
		String str=sc.nextLine();
		String regex="[0-9]+[-a-z0-9A-Z_\\s]{3,15}";
		System.out.println("true or false ? "+str.matches(regex));

	}

}
