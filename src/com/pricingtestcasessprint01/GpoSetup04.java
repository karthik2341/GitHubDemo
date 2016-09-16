package com.pricingtestcasessprint01;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Properties;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.pompricing100.PricingCustomerInformation;
import com.pompricing100.PricingGpoSetup04;
import com.pompricing100.PricingLoginPage;
import com.pompricing100.PricingMenu;
import com.pricingcommon.ExcelReader;
import com.pricingcommon.HTMLReport;

import com.pricingcommon.ReadObject;
import com.pricingcommon.WebControls;

public class GpoSetup04 {
	
	@Parameters({"prjName","testEnvironment","testBrowser"})
	@BeforeClass
	public void oneTimeSetup(String prjName,String testEnvironment,String testBrowser) throws Exception{
		String tcName   = this.getClass().getSimpleName();
		String userName = System.getProperty("user.name");
		Calendar cal = Calendar.getInstance(); 	     
	    SimpleDateFormat formatter1 = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss"); 	    
	    String date = formatter1.format(cal.getTime());						
		String envPath = System.getenv("Automation_Path");			
		HTMLReport hm1 = new HTMLReport(prjName,testEnvironment,testBrowser,tcName,userName,date,envPath);	
		hm1.htmlBuilder();		
		ReadObject rc = new ReadObject();
		Properties p = rc.getObjectRepository();
		WebControls wc = new WebControls();
		wc.startSelenium("URL Should be opened",p,testBrowser);		
	}
	@Test
	public void gpoSetup() throws Exception{
	try {
		//Classes Creation		
		WebControls wc = new WebControls();
		PricingLoginPage pl = new PricingLoginPage();	
		PricingMenu pm = new PricingMenu();
		ExcelReader er = new ExcelReader();		
		PricingCustomerInformation pci = new PricingCustomerInformation();		
		PricingGpoSetup04 pgpo = new PricingGpoSetup04();
		HTMLReport hr = new HTMLReport();
		//Login Into The Application
		hr.writeStepInformation("Step 1 : Login Into the application");
		pl.login();
		//verify title
		hr.writeStepInformation("Step 2 : Navigate to GPO Master Maintenance from the menu bar");
		wc.verifyHomePageTitle("Verify the home Page Title","xpath",pm.HOME_HOME_BTN_XPATH,"xpath",pm.HOME_TITLE_XPATH, "JD Edwards EnterpriseOne");
	    //Click Navigator Button			
		wc.webActions("Click on Navigator Button","click","xpath",pm.HOME_NAVIGATOR_BTN_XPATH, "Navigator", "", "");
		//Click on CAMS Button.
		wc.webActions("Click on CAMS Button","click", "xpath", pm.HOME_CAMS_BTN, "CAMS Button", "", "");
		//Click on Contracts Administration tasks.
		wc.webActions("Click on Contracts Administration Button","click", "xpath", pm.HOME_CONTRACTS_ADMIN_BTN, "Contracts Administration Button", "", "");
		//Click on GPO Master Maintenance.
		wc.webActions("Click on GPO Master Maintenance","click", "xpath", pm.HOME_GPO_MASTER_MAINT_BTN, "GPO Master Maintenance", "", "");
		//Wait for three Seconds.
		wc.setTimeOut(3);
		//Switch the frame
		wc.switchToSpecifiedFrame("xpath",pci.PCI_SWITCH_FRAME_XPATH);
		//Get the GPO ID after Creation Process.
		hr.writeStepInformation("Step 3 : Enter the Alpha Name and Payables Y/N/M to create the GPO");
		String GPOID = pgpo.createGPO("TestKart001", "Y");
		//Store the GPO ID in the Master Spread Sheet.
		er.setCellData(System.getProperty("user.dir") + "\\TestData\\MasterSpreadSheet.xls", "Global", "cGPONumber", 2, GPOID);
		//Enter the GPO Start Date and End Date.
		hr.writeStepInformation("Step 4 : Enter the GPO start Date and End Date from the Master Spread Sheet");
		pgpo.setGPODates(er.getCellData(System.getProperty("user.dir") + "\\TestData\\MasterSpreadSheet.xls", "Global", "cGPOStartDate", 2), er.getCellData(System.getProperty("user.dir") + "\\TestData\\MasterSpreadSheet.xls", "Global", "cGPOEndDate", 2), "TestKart001", "Y");		

    }
catch(Exception e){
	e.printStackTrace();
}
}
	@AfterClass
	public void oneTearDown() throws Exception 
	{
		HTMLReport hm1 = new HTMLReport();
		String tcName   = this.getClass().getSimpleName();
		hm1.writeToHTMLAfterClass(tcName);
		WebControls wc = new WebControls();
		wc.stopSelenium();		
	}
}

