package com.pompricing100;

import java.util.HashMap;
import java.util.LinkedHashMap;

import com.gargoylesoftware.htmlunit.javascript.host.Map;
import com.pricingcommon.ExcelReader;


public class Sample {
	
	public static void main(String [] args){
		ExcelReader er = new ExcelReader();
		String path = System.getProperty("user.dir") + "\\TestData\\Customer_Creation.xls";
		System.out.println(path );
		LinkedHashMap<String,String> hm = (LinkedHashMap<String, String>) er.getKnownGoodMap(path, "Customer_Creation", 1);
		System.out.println(hm.get("Payment Terms"));
	}

}
