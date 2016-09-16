package com.pricingcommon;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.testng.TestNG;
import org.testng.xml.XmlSuite;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Attr;





public class BatchTestingClass {
	public static String filePath = "C:\\Users\\lchalla\\Desktop\\BatchExecution.xls";
	public static String sheetName="Batch";
	
	
	public static void main(String[] args) throws Exception{
		
		methodOne("Pricing","1","Windows 7","Chrome","C:\\Users\\lchalla\\Desktop","Pricing");
		/*
		Map<String,String> knownGoodMap1 = new LinkedHashMap<String,String>();
		FileInputStream file = new FileInputStream(filePath);
		HSSFWorkbook workbook = new HSSFWorkbook(file);
		HSSFSheet sheet = workbook.getSheet(sheetName);		
		int rowCount = sheet.getLastRowNum() - sheet.getFirstRowNum();
		int i = 2;
		while(i<2){
			HSSFRow row = sheet.getRow(i);
			int m = i + 1;
			HSSFRow row1 = sheet.getRow(m);
			int j = 0;
			while (j < row.getLastCellNum()) {                
                HSSFCell cell = sheet.getRow(i).getCell(j);
                cell.setCellType(1);
                HSSFCell cell1 = sheet.getRow(m).getCell(j);
                cell1.setCellType(1);
                knownGoodMap1.put(row.getCell(j).getStringCellValue(), row1.getCell(j).getStringCellValue());
                ++j;
            }
            ++i;
			
		}
		for (Map.Entry thisEntry : knownGoodMap1.entrySet()) {
            
            
            
            System.out.println("Key " + thisEntry.getKey() + " Value " + thisEntry.getValue() );
            
        }
		*/
		
		
	}
	
	public static void methodOne(String projectName,String count2,String testEnv,String browser,String path,String moduleName) throws ParserConfigurationException, TransformerException{
		String[] classesName = {"com.pricingtestcasessprint01.CustomerCreation01","com.pricingtestcasessprint01.LpgSetup02","com.pricingtestcasessprint01.PccaSetup03","com.pricingtestcasessprint01.GpoSetup04","com.pricingtestcasessprint01.ContractSetup05"}; 
		String xmlFilePath = path + "\\" +moduleName + ".xml";
		System.out.println(xmlFilePath);
		DocumentBuilderFactory documentFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder documentBuilder = documentFactory.newDocumentBuilder();
		System.setProperty("javax.xml.transform.TransformerFactory","com.sun.org.apache.xalan.internal.xsltc.trax.TransformerFactoryImpl");
		//root elements
		  Document document = documentBuilder.newDocument();
		  Element root = document.createElement("suite");
		  document.appendChild(root);
		  Attr attr1 = document.createAttribute("name");
          attr1.setValue(projectName);
          root.setAttributeNode(attr1);
          Attr attr2 = document.createAttribute("thread-count");
          attr2.setValue(count2);
          root.setAttributeNode(attr2);
          
          //First Parameter
          Element parameter = document.createElement("parameter");
          root.appendChild(parameter);
          Attr attr3 = document.createAttribute("name");
          attr3.setValue("prjName");
          parameter.setAttributeNode(attr3);
          Attr attr4 = document.createAttribute("value");
          attr4.setValue(projectName);
          parameter.setAttributeNode(attr4);         
          
          //Second Parameter          
          Element parameter2 = document.createElement("parameter");
          root.appendChild(parameter2);
          Attr attr5 = document.createAttribute("name");
          attr5.setValue("testEnvironment");
          parameter2.setAttributeNode(attr5);
          Attr attr6 = document.createAttribute("value");
          attr6.setValue(testEnv);
          parameter2.setAttributeNode(attr6);
          
          //Third Parameter
          Element parameter3 = document.createElement("parameter");
          root.appendChild(parameter3);
          Attr attr7 = document.createAttribute("name");
          attr7.setValue("testBrowser");
          parameter3.setAttributeNode(attr7);
          Attr attr8 = document.createAttribute("value");
          attr8.setValue(browser);
          parameter3.setAttributeNode(attr8);
          
          //Write the Test Tag
          Element test = document.createElement("test");
          root.appendChild(test);
          Attr test1 = document.createAttribute("name");
          test1.setValue("Test");
          test.setAttributeNode(test1);
          
          //Write the Classes Tag
          Element classes = document.createElement("classes");
          test.appendChild(classes);
          for(int i = 0;i<classesName.length-1;i++){
        	  Element class1 = document.createElement("class");
        	  classes.appendChild(class1);
        	  Attr classtobe = document.createAttribute("name");
        	  classtobe.setValue(classesName[i]);
        	  class1.setAttributeNode(classtobe);
          }
          
         

  		
          TransformerFactory transformerFactory = TransformerFactory.newInstance();
          Transformer transformer = transformerFactory.newTransformer();
          DOMSource source = new DOMSource(document);
          StreamResult result = new StreamResult(new File(xmlFilePath));
          transformer.transform(source, result);
	}

}
