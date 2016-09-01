package com.pricingtestcasessprint01;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.LinkedHashMap;
import java.util.Properties;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.pompricing100.PricingCustomerInformation;
import com.pompricing100.PricingLocalGroupMaintenance;
import com.pompricing100.PricingMenu;
import com.pompricing100.PricingLoginPage;
import com.pricingcommon.ExcelReader;
import com.pricingcommon.HTMLReport;
import com.pricingcommon.ProjectCommonMethods;
import com.pricingcommon.ReadObject;
import com.pricingcommon.WebControls;


public class LpgSetup02 {
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
		wc.startSelenium(p,testBrowser);		
	}
	
	@Test
	public void lpgSetup02() throws Exception {
		
		try{
			//Classes Creation		
			WebControls wc = new WebControls();
			PricingLoginPage pl = new PricingLoginPage();	
			PricingMenu pm = new PricingMenu();
			ExcelReader er = new ExcelReader();		
			PricingCustomerInformation pci = new PricingCustomerInformation();
			ProjectCommonMethods pcm = new ProjectCommonMethods();
			PricingLocalGroupMaintenance plgm = new PricingLocalGroupMaintenance();
			
			
			
			//Login Into The Application
			pl.login();
			//verify title
			wc.verifyHomePageTitle("xpath",pm.HOME_HOME_BTN_XPATH,"xpath",pm.HOME_TITLE_XPATH, "JD Edwards EnterpriseOne");
		    //Click Navigator Button			
			wc.webActions("click","xpath",pm.HOME_NAVIGATOR_BTN_XPATH, "Navigator", "", "");
			//Click Contracts,Pricing and Rebates Button
			wc.webActions("click","xpath",pm.HOME_CONTRACTS_PRICING_REBATES_BTN, "Contracts Pricing and Rebates", "", "");
			//Click On Pricing Menu Button
			wc.webActions("click","xpath",pm.HOME_PRICING_MENU_BTN, "Pricing", "", "");
			//Click On Local Group Maintenance Button
			wc.webActions("click","xpath",pm.HOME_LOCAL_GROUPS_MAINTENANCE_BTN, "Local Group Maintenance", "", "");
			// Wait for 3 seconds
			wc.setTimeOut(3);
			//Switch the frame
			wc.switchToSpecifiedFrame("xpath",pci.PCI_SWITCH_FRAME_XPATH);
			//Click on Add Button
			wc.webActions("click","xpath",plgm.LOCALPRICE_ADD_BTN_XPATH, "Add Button", "", "");
			// Wait for 5 seconds
			wc.setTimeOut(5);
			//Get the Bill-To Number
			String billToNumber = er.getCellData(System.getProperty("user.dir") + "\\TestData\\MasterSpreadSheet.xls", "Global", "cBillToCustomer", 2).toString();
			//Get the Randomly Generated Group ID
			String grpID = pcm.returnRandomAlphabets();
			//Set the grpID in the Master Spread Sheet.
			er.setCellData(System.getProperty("user.dir") + "\\TestData\\MasterSpreadSheet.xls", "Global", "cGroupID", 1, grpID);
			//Add GroupID for LPG
			plgm.addDataForLocalGroups(grpID,"Test For Price Hierarchy","e1tst01","Y");
			//Get the LPG ID.
			plgm.getLPGID(grpID);
			//Add the Price Rule Group
			plgm.addPriceRuleGrup(billToNumber,er.getCellData(System.getProperty("user.dir") + "\\TestData\\MasterSpreadSheet.xls", "Global", "cLPGEndDate", 2));
			//Get the LPG ID.
			plgm.getLPGID(grpID);
			//Verify that the customer got added.
			wc.returnTextFromElement("xpath", plgm.LOCALPRICE_CUSTOMER_NBR_TXTBOX_XPATH);
			
			
			
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
