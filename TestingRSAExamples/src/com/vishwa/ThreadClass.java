package com.vishwa;

public class ThreadClass extends Thread {
	
	static Boolean flag=null;
	public static void main(String[] args)
	{
		
		call();
		System.out.println(flag);
		
	}
	public static void call()
	{
		
		ThreadClass t1=new ThreadClass();
		if(getCount(6)){
		t1.start();
		}
		else
			flag=false;
		
	}
	static boolean getCount(int count)
	{
		boolean flag=false;
		if(count>5)
			flag=true;
		else
			flag=false;
		return flag;
	}
	public void run() 
	{
	       for(int i=0;i<3;i++)
	       {
	    	   System.out.println(i);
	       }
	        try{
	            Thread.sleep(300);
	        } catch(Exception e){

	        }

	} 

}
