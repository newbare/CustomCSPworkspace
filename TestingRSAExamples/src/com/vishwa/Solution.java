package com.vishwa;

import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        
        Scanner sc=new Scanner(System.in);
        String A=sc.next();
        String B=sc.next();
        /* Enter your code here. Print output to STDOUT. */
        int len=A.length()+B.length();
          System.out.println(len);
        int com=A.compareTo(B);
        if(com>=1)
            {
            System.out.println("Yes");
        }
           else
           System.out.println("No");
        String sub=A.substring(1);
        String sub2=B.substring(1);
        char c =(A.charAt(0));
        char c2 =(B.charAt(0));
        String s=String.valueOf(c);
        String s2=String.valueOf(c2);
        System.out.println(s.toUpperCase()+sub+" "+s2.toUpperCase()+sub2);
            //String aa=
      
   
    }
}

