package com.pricingcommon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.testng.TestNG;
import org.testng.xml.XmlClass;
import org.testng.xml.XmlSuite;
import org.testng.xml.XmlTest;

import com.google.common.collect.Multimap;
import com.google.common.collect.TreeMultimap;





public class BatchExecution {
	public static String[] str;
	public static void main(String[] args){
		XmlSuite suite = new XmlSuite();
		suite.setName("TmpSuite");
		suite.setVerbose(1);
	
		HashMap<String,String> hm = new HashMap<String,String>();
		hm.put("testCase1", "com.pricingtestcasessprint01.CustomerCreation01");
		hm.put("testCase2", "com.pricingtestcasessprint01.LpgSetup02");
		hm.put("testCase3", "com.pricingtestcasessprint01.PccaSetup03");
		 Multimap<String,String> multimap = TreeMultimap.create();
		
		 for(Map.Entry<String, String> entry: hm.entrySet() ) {
	         multimap.put( entry.getKey(), entry.getValue() );
	    }
		 String[] spliKeys = Arrays.toString( multimap.keys().toArray()).split(",");
		 for(int i = 0;i<=spliKeys.length-1;i++){
			 System.out.println(spliKeys[i]);
			 
		 }
        System.out.println(Arrays.toString( multimap.keys().toArray()));
		 System.out.println(Arrays.toString( multimap.values().toArray()));
			
		
		XmlTest test = new XmlTest(suite);
		test.setName("TmpTest");
		test.setPreserveOrder("true");
		
		
		
		XmlClass publicTestClass = new XmlClass(com.pricingtestcasessprint01.CustomerCreation01.class);
		publicTestClass.setName("com.pricingtestcasessprint01.LpgSetup02");
		publicTestClass.setName("com.pricingtestcasessprint01.PccaSetup03");
		
		
		List<XmlClass> classes = new ArrayList<XmlClass>();
		HashMap<String,String> m1 = new HashMap<String,String>();
	    m1.put("prjName","Pricing");
	    m1.put("testEnvironment", "Windows 7");
	    m1.put("testBrowser", "chrome");
		classes.add(publicTestClass);
		test.setParameters(m1);
		test.setXmlClasses(classes);
		
		TestNG tng = new TestNG();
		List<XmlSuite> suites = new ArrayList<XmlSuite>();
		suites.add(suite);
		tng.setXmlSuites(suites);
		tng.run();
		/*
		classes.add(new XmlClass("com.pricingtestcasessprint01.CustomerCreation01"));
		test.setXmlClasses(classes) ;

		 
		List<XmlSuite> suites = new ArrayList<XmlSuite>();
		suites.add(suite);
		TestNG tng = new TestNG();
		tng.setXmlSuites(suites);
		tng.run();
        */
		 
		
	}

}
