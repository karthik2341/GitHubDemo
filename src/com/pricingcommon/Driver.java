package com.pricingcommon;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;


public class Driver {
	public static WebDriver driver=null;
	//
	 public  WebDriver startSelenium(String verification,Properties p,String browser) throws IOException{
		 String value =p.getProperty("value");		 
		 String callerClassName = new Exception().getStackTrace()[1].getClassName();
		 String arr[] = callerClassName.split("\\.");	
		 //System.out.println(arr[1]);
		 
		 if(browser.equalsIgnoreCase("chrome")){
			 try{
				 
			System.out.println(System.getProperty("user.dir"));
			 System.setProperty("webdriver.chrome.driver", "C:\\Users\\lchalla\\eclipse_workspace\\Pricing\\Resources\\chromedriver.exe");
			 driver = new ChromeDriver();			 
			 driver.get(value);			
			 HTMLReport hm = new HTMLReport();			
			 hm.writeToHTMWithScreenShot(verification,"Expected URL is " +value,"Actual URL is " + value,"Pass",arr[1]);
			 //hm.writeToHTML("Expected URL is " +value,"Actual URL is " + value,"Pass");
			 driver.manage().window().maximize();	
			 }
			 catch(Exception e){
				 HTMLReport hm = new HTMLReport();
				 hm.writeToHTML(verification,"Expected URL is " +value,"Actual URL is " + value,"Fail");
			 }
		 }
		 else if(browser.equalsIgnoreCase("firefox")){
			 driver = new FirefoxDriver();
			 driver.get(value);
			 driver.manage().window().maximize();			 
		 }
		 else if(browser.equalsIgnoreCase("internet explorer")){
			// DesiredCapabilities cap = new DesiredCapabilities();
			 //cap.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);			 
			 System.setProperty("webdriver.ie.driver", System.getProperty("user.dir"+ "\\Resources\\IEDriverServer.exe"));
			 driver = new InternetExplorerDriver();
			 driver.get(value);
			 driver.manage().window().maximize();			 
		 }
		 return driver;
	 }

}
