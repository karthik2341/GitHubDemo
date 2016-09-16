package com.pricingcommon;

import java.util.Random;

public class ProjectCommonMethods {
	 public String returnRandomAlphabets(){
		 String aToZ="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		 Random r = new Random();
		 StringBuilder res=new StringBuilder();
		 for (int i = 0; i < 3; i++) {
		       int randIndex=r.nextInt(aToZ.length()); 
		       res.append(aToZ.charAt(randIndex));            
		 }
		 return res.toString();
	 }
	 public String returnSixRandomAlphabets(){
		 String aToZ="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		 Random r = new Random();
		 StringBuilder res=new StringBuilder();
		 for (int i = 0; i < 6; i++) {
		       int randIndex=r.nextInt(aToZ.length()); 
		       res.append(aToZ.charAt(randIndex));            
		 }
		 return res.toString();
	 }

}
