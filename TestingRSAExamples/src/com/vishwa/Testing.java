package com.vishwa;

import java.math.BigDecimal;
import java.text.DecimalFormat;

public class Testing {

	public static void main(String[] args) {
		
		
		 double d = 940938.2;
	     DecimalFormat f = new DecimalFormat("#.00");
	     System.out.println(f.format(d));
	     System.out.println(new Double(String.format("%.2f", d)));
	     System.out.println(Double.valueOf(String.format("%.2f", d)));
	     System.out.println(Long.valueOf(0));

	}

}
