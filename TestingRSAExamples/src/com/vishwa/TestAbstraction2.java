package com.vishwa;

abstract class Bike{  
	   Bike(){System.out.println("bike is created");}  
	   abstract void run();  
	   //abstract void run1();  
	   void display(){
		   System.out.println("super");
	   };
	   void changeGear(){System.out.println("gear changed");}  
	 }  
	  
	 class Honda extends Bike{  
	 void run(){System.out.println("running safely..");} 
	 void display()
	 {
		 System.out.println("display()");
	 }
	 }  
	 class TestAbstraction2{  
	 public static void main(String args[]){  
		 Honda obj = new Honda();  
	  obj.run();  
	  obj.display();
	  obj.changeGear();  
	 }  
	}