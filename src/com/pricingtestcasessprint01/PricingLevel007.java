package com.pricingtestcasessprint01;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Properties;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.pompricing100.PricingContractHeader;
import com.pompricing100.PricingCustomerInformation;
import com.pompricing100.PricingEnquiry;
import com.pompricing100.PricingLoginPage;
import com.pompricing100.PricingMenu;
import com.pricingcommon.ExcelReader;
import com.pricingcommon.HTMLReport;
import com.pricingcommon.ReadObject;
import com.pricingcommon.WebControls;

public class PricingLevel007 {
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
		wc.startSelenium("URL Should be openend",p,testBrowser);		
	}
	@Test
	public void pricinglevel006() throws Exception{
		try{
			//Classes Creation		
			WebControls wc = new WebControls();
			PricingLoginPage pl = new PricingLoginPage();	
			PricingMenu pm = new PricingMenu();
			ExcelReader er = new ExcelReader();
			PricingCustomerInformation pci = new PricingCustomerInformation();
			PricingEnquiry pe = new PricingEnquiry();
			HTMLReport hr = new HTMLReport();
			PricingContractHeader pch = new PricingContractHeader();
			//Store the filepath of the MasterSpread Sheet.
			String filePath =System.getProperty("user.dir") + "\\TestData\\MasterSpreadSheet.xls";
			//Login Into The Application
			hr.writeStepInformation("Step 1 : Login into the application");
			pl.login();
			//verify title
			hr.writeStepInformation("Step 2 : Navigate to Contracts Administration Tasks from the menu bar");
			wc.verifyHomePageTitle("Verify Home Page Title","xpath",pm.HOME_HOME_BTN_XPATH,"xpath",pm.HOME_TITLE_XPATH, "JD Edwards EnterpriseOne");
			//Click Navigator Button
			wc.webActions("Click on Navigator Button","click","xpath",pm.HOME_NAVIGATOR_BTN_XPATH, "Navigator", "", "");
			//Click CAMS Button
			wc.webActions("Click on CAMS Button", "click", "xpath", pm.HOME_CAMS_BTN, "CAMS", "", "");
			//Click on Contracts Administration task
			wc.webActions("Click on Contract Administration Tasks", "click", "xpath", pm.HOME_CONTRACTS_ADMIN_BTN, "Contracts Administration Tasks", "", "");
			//Click on Contracts Administration task
			wc.webActions("Click on Contract Maintenance", "click", "xpath", pm.HOME_CONTRACTS_HEADER_MAINT, "Contracts Mainetenance", "", "");
			//Switch to a different frame
			wc.switchToSpecifiedFrame("xpath",pci.PCI_SWITCH_FRAME_XPATH);			
			//Remove the McKesson Contract ID from the GPO.
			wc.setTimeOut(5);
			hr.writeStepInformation("Step 3 : Remove the GPO McKesson Contract ID from the GPO");
			pch.workWithContractHeaders(er.getCellData(filePath, "Global", "cMckGPOContractID", 2));
			//Work with Contract Items
			pch.workWithContractItems();
			//Enter The document Control Number and item End Date
			hr.writeStepInformation("Step 4 : Enter the GPO Document Control Number and Item End Date");
			pch.contractItemMaintenance("TestKart001", er.getCellData(filePath, "Global", "cRulesTermDate", 3));
			//Click on Close Button
			wc.webActions("Click On Close Button", "click", "xpath", "//*[@id='hc_Close']", "Close Button", "", "");
			//Wait for three seconds
			wc.setTimeOut(3);
			//Click on Close Button
			wc.webActions("Click On Close Button", "click", "xpath", "//*[@id='hc_Close']", "Close Button", "", "");
			//Wait for three seconds
			wc.setTimeOut(3);
			//Switch to the Parent Frame.
			wc.switchToParentFrame();
			//Verify the home page title
			hr.writeStepInformation("Step 5 : Navigate to Contracts Administration Tasks from the menu bar");
			wc.verifyHomePageTitle("Verify Home Page Title","xpath",pm.HOME_HOME_BTN_XPATH,"xpath",pm.HOME_TITLE_XPATH, "JD Edwards EnterpriseOne");
			//Click Navigator Button
			wc.webActions("Click on Navigator Button","click","xpath",pm.HOME_NAVIGATOR_BTN_XPATH, "Navigator", "", "");
			//Click CAMS Button
			wc.webActions("Click on CAMS Button", "click", "xpath", pm.HOME_CAMS_BTN, "CAMS", "", "");
			//Click on Contracts Administration task
			wc.webActions("Click on Contract Administration Tasks", "click", "xpath", pm.HOME_CONTRACTS_ADMIN_BTN, "Contracts Administration Tasks", "", "");
			//Click on Contracts Administration task
			wc.webActions("Click on Contract Maintenance", "click", "xpath", pm.HOME_CONTRACTS_HEADER_MAINT, "Contracts Mainetenance", "", "");
			//Switch to a different frame
			wc.switchToSpecifiedFrame("xpath",pci.PCI_SWITCH_FRAME_XPATH);
			//Remove the McKesson Contract ID from the GPO.
			hr.writeStepInformation("Step 6 : Remove the LOC McKesson Contract ID from the LOC Contract");
			pch.workWithContractHeaders(er.getCellData(filePath, "Global", "cMcKLocalContractID", 2));
			//Work with Contract Items
			pch.workWithContractItems();
			//Enter The document Control Number and item End Date
			hr.writeStepInformation("Step 7 : Enter the LOC Document Control Number and Item End Date");
			pch.contractItemMaintenance("TestKart001", er.getCellData(filePath, "Global", "cRulesTermDate", 3));
			//Check Price Level 007 is populated or not.
			wc.switchToParentFrame();
			//Switch to Pricing Rules Setup.
			hr.writeStepInformation("Step 8 : Navigate to Pricing Rules Maintenance");
			wc.verifyHomePageTitle("Verify Home Page Title","xpath",pm.HOME_HOME_BTN_XPATH,"xpath",pm.HOME_TITLE_XPATH, "JD Edwards EnterpriseOne");
			//Click Navigator Button
			wc.webActions("Click on Navigator Button","click","xpath",pm.HOME_NAVIGATOR_BTN_XPATH, "Navigator", "", "");
			//Click on Contracts,Pricing and Rebates.
			wc.webActions("Click on Contracts Pricing and Rebates","click", "xpath", pm.HOME_CONTRACTS_PRICING_REBATES_BTN, "Contracts Pricing and Rebates", "", "");
			// Click on Pricing Menu		
			wc.setTimeOut(3);
			wc.webActions("Click on Pricing Menu","click", "xpath",pm.HOME_PRICING_MENU_BTN, "Pricing Menu", "", "");
			//Click on Price Rules Maintenance.
			wc.setTimeOut(3);
			wc.webActions("Click on Pricing Rules Maintenance","click", "xpath",pm.HOME_PRICINGRULESMAINTENANCE, "Pricing Rules Maintenance", "", "");
			//Switch to a different frame
			wc.switchToSpecifiedFrame("xpath",pci.PCI_SWITCH_FRAME_XPATH);
			//Navigate to Price Rules Enquiry
			pe.pricingRules_Enquiry();
			//Select the User Defined Code
			hr.writeStepInformation("Step 9 : Select the Price Level Code");
			pe.pricingRules_SelectUserDefinedCode("007");
			//Switch to the parent frame.
			wc.switchToParentFrame();
			//Switch to the specified frame
			wc.switchToSpecifiedFrame("xpath",pci.PCI_SWITCH_FRAME_XPATH);
			//Get the Batch Number
			hr.writeStepInformation("Step 10 : Get the Batch Number");
			String batchNumber=wc.returnTextFromValueAttribute("Get the Batch Number", "xpath", pe.PR_BATCHNUM, "Batch Number is populated");
			//Set up the price Level Dates
			hr.writeStepInformation("Step 11 : Enter the Effective Date,Termination Date,Item Number,Rule Type and Percentage Information in the Price Rule Setup Screen");
			pe.setValues_PriceRuleImportMaintenance(er.getCellData(filePath, "Global", "cRulesEffDate", 4), er.getCellData(filePath, "Global", "cRulesTermDate", 4), er.getCellData(filePath, "Global", "cItemNumber", 2),"C","12.0000","","","","7");
			//Set up the batch for the price Rule		
			pe.PR_WorkWithPriceRuleBatches(batchNumber);
			//Verify the batch Number is populated Correctly
			hr.writeStepInformation("Step 12 : Verify that the Batch Number is populated correctly");
			pe.verify_getBatchNumber(batchNumber);
			//navigate to the parent frame
			wc.switchToParentFrame();
			//Navigate to Pricing Rules Enquiry.
			//Click Navigator Button
			hr.writeStepInformation("Step 13 : Navigate to Pricing Enquiry Screen");
			wc.webActions("Click on Navigator Button","click","xpath",pm.HOME_NAVIGATOR_BTN_XPATH, "Navigator", "", "");
			//Click on Contracts,Pricing and Rebates.
			wc.webActions("Click on Contracts Pricing and Rebates","click", "xpath", pm.HOME_CONTRACTS_PRICING_REBATES_BTN, "Contracts Pricing and Rebates", "", "");
			// Click on Pricing Menu
			wc.setTimeOut(3);
			wc.webActions("Click on Pricing Menu","click", "xpath",pm.HOME_PRICING_MENU_BTN, "Pricing Menu", "", "");
			//Click on Pricing Enquiry Button.
			wc.setTimeOut(3);
			wc.webActions("Click on Pricing Inquiry Screen","click", "xpath",pm.HOME_PRICINGRULESINQUIRY, "Pricing Inquiry", "", "");
			//Switch to Specified frame.
			wc.switchToSpecifiedFrame("xpath",pci.PCI_SWITCH_FRAME_XPATH);
			//Get the Price Rule from the Pricing Inquiry Screen
			hr.writeStepInformation("Step 14 : Enter the Bill-To and Item Number Information in the Pricing Inquiry Screen");
			pe.PI_getPrice(er.getCellData(filePath, "Global", "cBillToCustomer", 2),er.getCellData(filePath, "Global", "cItemNumber", 2),er.getCellData(filePath, "Global", "cRulesEffDate", 4));
			//Verify the Price Rule
			hr.writeStepInformation("Step 15 : Verify the Price Rule is populated or not");
			pe.verify_PriceRule("7");		
			
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