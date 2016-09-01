package com.pricingcommon;

import java.io.IOException;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;



public class WebControls extends Driver {
	HTMLReport hm = new HTMLReport();	
	
	
	public void webActions(String operation,String locType,String locValue,String eleName,String valToEnter,String valToSelect) throws Exception{
		String callerClassName = new Exception().getStackTrace()[1].getClassName();
		String arr[] = callerClassName.split("\\.");			
		switch(operation.toUpperCase()){
		
		case("CLICK"):
			try{			
			driver.findElement(this.getObject(locType, locValue)).click();
			//hm.writeToHTMWithScreenShotWithFailure("Button/link/Image "+eleName+" has to be clicked.", "Unable to click on Button/link/Image" + eleName , "Fail",arr[1]);
			hm.writeToHTML("Button/link/Image '"+eleName+" 'has to be clicked.", "Clicked on Button/link/Image '" + eleName + "'", "Pass");
			}
			catch(Exception e){
		    hm.writeToHTMWithScreenShotWithFailure("Button/link/Image "+eleName+" has to be clicked.", "Unable to click on Button/link/Image" + eleName , "Fail",arr[1]);
			//hm.writeToHTMWithScreenShot("Button/link/Image "+eleName+" has to be clicked.", "Unable to click on Button/link/Image" + eleName , "Fail",arr[1]);				
			}
			break;
		
		case("SETTEXT"):
			try{
			driver.findElement(this.getObject(locType, locValue)).clear();
			//setTimeOut(2);
			driver.findElement(this.getObject(locType, locValue)).sendKeys(valToEnter);
			String getValue = driver.findElement(this.getObject(locType, locValue)).getAttribute("value");
			if(getValue.equalsIgnoreCase(valToEnter)){
			hm.writeToHTML("Text "+valToEnter+" has to be entered", "Text Entered is " + getValue , "Pass");			
			}
			else{
			hm.writeToHTMWithScreenShotWithFailure("Text "+valToEnter+" has to be entered", "Text was not entered", "Fail",arr[1]);
			}
			}
			catch(Exception e){
			hm.writeToHTMWithScreenShotWithFailure("Text "+valToEnter+" has to be entered", "Text was not entered", "Fail",arr[1]);
			//hm.writeToHTMWithScreenShot("Text "+valToEnter+" has to be entered", "Text was not entered", "Fail",arr[1]);				
			}
		    break;
		case("ENTER"):
			driver.findElement(this.getObject(locType, locValue)).sendKeys(Keys.ENTER);
		    break;
		
		
		case("SELECTBYTEXT"):
			try{
				Select drpDown = new Select(driver.findElement(this.getObject(locType,locValue)));
				drpDown.selectByVisibleText(valToSelect);
				hm.writeToHTML("Selected Value "+ "'" +valToSelect+ "'" +" has to be selected", "Selected Value is " + "'" +valToSelect+ "'","Pass");
			}
		   catch(Exception e){
			   hm.writeToHTMWithScreenShotWithFailure("Selected Value "+ "'" +valToSelect+ "'" +" has to be selected", "Was Not able to select the given value","Fail",arr[1]);
		   }
		break;
		}
		
		
	}
	
	public void findElementUsingIndexOfFrame(String operation,String locType,String locValue,String valToEnter,String eleName) throws Exception{
		String callerClassName = new Exception().getStackTrace()[1].getClassName();
		String arr[] = callerClassName.split("\\.");	
		int size = driver.findElements(By.tagName("iframe")).size();
		for(int i=0; i<=size; i++){
			driver.switchTo().frame(i);
			int total=driver.findElements(this.getObject(locType, locValue)).size();
			
			if(total==1 && operation.equalsIgnoreCase("CLICK")){
				try{
				driver.findElement(this.getObject(locType,locValue)).click();
				hm.writeToHTML("Button/link/Image '"+eleName+" 'has to be clicked.", "Clicked on Button/link/Image '" + eleName + "'", "Pass");
				break;
			}
				catch(Exception e){
					hm.writeToHTMWithScreenShotWithFailure("Button/link/Image '"+eleName+" 'has to be clicked.", "Unable to click on the button/link/Image", "Fail",arr[1]);
					break;
				}
			}
			else if(total==1 && operation.equalsIgnoreCase("SETTEXT")){
				try{
					driver.findElement(this.getObject(locType,locValue)).clear();
					driver.findElement(this.getObject(locType,locValue)).sendKeys(valToEnter);
					String getValue = driver.findElement(this.getObject(locType, locValue)).getAttribute("value");
					if(getValue.equalsIgnoreCase(valToEnter)){
					hm.writeToHTML("Text "+valToEnter+" has to be entered", "Text Entered is " + getValue , "Pass");
					break;
					}
				}
				catch(Exception e){
					hm.writeToHTMWithScreenShotWithFailure("Text "+valToEnter+" has to be entered", "Text was not entered", "Fail",arr[1]);
					break;
				}
			
			}
		}
		    
	}
	
	public void clickWebTableBasedOnUniqueCellText(String locType,String locValue,String expText,String operation,String eleName,String valToEnter,String valToSelect) throws Exception{
		
		WebElement myTable = driver.findElement(this.getObject(locType, locValue));
		List<WebElement> rows_table = myTable.findElements(By.tagName("tr"));
		int rows_count = rows_table.size();
		for (int row=0; row<rows_count; row++){
			List<WebElement> Columns_row = rows_table.get(row).findElements(By.tagName("td"));
			 int columns_count = Columns_row.size();
			 for (int column=0; column<columns_count; column++){
				    //To retrieve text from that specific cell.
				    String actCeltext = Columns_row.get(column).getText();
				    if(expText.equals(actCeltext)){
				    	try{
				    		locValue = locValue + "/tr[" + row + "]" + "/td[" + column + "]";
				    		webActions(operation,locType,locValue,eleName,valToEnter,valToSelect);
				    	   
				    	}
				    	catch(Exception e){
				    		System.out.println(e);
				    		
				    	}
				    }

			 }
		}
		
	}
	//Verifying title of page
	
	public void verifyHomePageTitle(String locType,String locValue,String titType,String titValue,String expText) throws Exception{
		String callerClassName = new Exception().getStackTrace()[1].getClassName();
		String arr[] = callerClassName.split("\\.");
		WebDriverWait myWaitVar = new WebDriverWait(driver,10);
		try{
			myWaitVar.until(ExpectedConditions.visibilityOfElementLocated(this.getObject(locType, locValue)));
			String title = driver.findElement(this.getObject(titType, titValue)).getText().trim();
			if(title.contains(expText)){
				hm.writeToHTML(expText,title,"Pass");
			}
				else{
				 hm.writeToHTMWithScreenShot(expText, title,"Fail",arr[1]);
				}
			
		}
		catch(TimeoutException toe){
			System.out.println(toe);
		}
		
	}
	public String returnTextFromElement(String locType,String locValue) throws Exception{
		String getText="";
		String callerClassName = new Exception().getStackTrace()[1].getClassName();
		String arr[] = callerClassName.split("\\.");
		getText = driver.findElement(this.getObject(locType, locValue)).getText();
		if(getText!=""){
			hm.writeToHTML("Expected Text Should Not be Empty","Actual Text is " + getText, "Pass");			
		}
		else{
			hm.writeToHTMWithScreenShotWithFailure("Expected Text Should Not be Empty", "Expected Text is empty","Fail",arr[1]);
		}
		
		
		return getText;
	}
	
	
	public String returnTextFromValueAttribute(String locType,String locValue,String expectedText) throws Exception{
		String getText="";
		String callerClassName = new Exception().getStackTrace()[1].getClassName();
		String arr[] = callerClassName.split("\\.");	
		try{
		
		getText = driver.findElement(this.getObject(locType, locValue)).getAttribute("value").toString();
		if(getText!=""){
			hm.writeToHTML(expectedText, expectedText + " is " + getText, "Pass");			
		}
		else{
			hm.writeToHTMWithScreenShotWithFailure(expectedText, expectedText +" Not Found","Fail",arr[1]);
		}
		
		}
		catch(Exception e){
			hm.writeToHTMWithScreenShotWithFailure(expectedText, expectedText +" Not Found","Fail",arr[1]);
			
		}
		return getText;
	}
	
	public void switchToSpecifiedFrame(String locType,String locValue) throws Exception{
		driver.switchTo().frame(driver.findElement(this.getObject(locType, locValue)));		
	}
	
	public void switchToParentFrame() throws Exception{
		driver.switchTo().defaultContent();
	}
	private By getObject(String locType,String locValue) throws Exception{
		//Find by xpath
		if(locType.equalsIgnoreCase("XPATH")){
			
			return By.xpath(locValue);
		}
		//find by class
		else if(locType.equalsIgnoreCase("CLASSNAME")){
			
			return By.className(locValue);
			
		}
		//find by name
		else if(locType.equalsIgnoreCase("NAME")){
			
			return By.name(locValue);
			
		}
		//Find by css
		else if(locType.equalsIgnoreCase("CSS")){
			
			return By.cssSelector(locValue);
			
		}
		//find by link
		else if(locType.equalsIgnoreCase("LINK")){
			
			return By.linkText(locValue);
			
		}
		//find by partial link
		else if(locType.equalsIgnoreCase("PARTIALLINK")){
			
			return By.partialLinkText(locValue);
			
		}else
		{
			throw new Exception("Wrong object type");
		}
	}
	
	public void setTimeOut(int seconds){
		try {		    
		    TimeUnit.SECONDS.sleep(seconds);	    
		  
		} catch (InterruptedException e) {
		    System.out.println(e);
		}
	}
	 
	 public void stopSelenium(){		 
		 driver.quit();
	 }

}
