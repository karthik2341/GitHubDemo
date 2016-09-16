package com.pricingtestcasessprint01;


	

	import org.testng.annotations.Test;
	import java.text.SimpleDateFormat;
	import java.util.Calendar;
	import java.util.Properties;
	import org.testng.annotations.AfterClass;
	import org.testng.annotations.BeforeClass;
	import org.testng.annotations.Parameters;
	import com.pompricing100.PricingCustomerInformation;
	import com.pompricing100.PricingEnquiry;
	import com.pompricing100.PricingLoginPage;
	import com.pompricing100.PricingMenu;
	import com.pricingcommon.ExcelReader;
	import com.pricingcommon.HTMLReport;
	import com.pricingcommon.ReadObject;
	import com.pricingcommon.WebControls;

	public class PricingLevel010 {
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
		public void pricinglevel010() throws Exception{
			try{
			//Classes Creation		
			WebControls wc = new WebControls();
			PricingLoginPage pl = new PricingLoginPage();	
			PricingMenu pm = new PricingMenu();
			ExcelReader er = new ExcelReader();
			PricingCustomerInformation pci = new PricingCustomerInformation();
			PricingEnquiry pe = new PricingEnquiry();
			HTMLReport hr = new HTMLReport();
			//Store the filepath of the MasterSpread Sheet.
			String filePath =System.getProperty("user.dir") + "\\TestData\\MasterSpreadSheet.xls";
			//Login Into The Application
			hr.writeStepInformation("Step 1 : Login into the application");
			pl.login();
			//verify title
			hr.writeStepInformation("Step 2 : Navigate to Pricing Rules Maintenance");
			wc.verifyHomePageTitle("Verify Home Page Title","xpath",pm.HOME_HOME_BTN_XPATH,"xpath",pm.HOME_TITLE_XPATH, "JD Edwards EnterpriseOne");
			//Click Navigator Button
			wc.webActions("Click on Navigator Button","click","xpath",pm.HOME_NAVIGATOR_BTN_XPATH, "Navigator", "", "");
			//Click on Contracts,Pricing and Rebates.
			wc.webActions("Click on Contracts Pricing and Rebates","click", "xpath", pm.HOME_CONTRACTS_PRICING_REBATES_BTN, "Contracts Pricing and Rebates", "", "");
			// Click on Pricing Menu		
			wc.webActions("Click on Pricing Menu","click", "xpath",pm.HOME_PRICING_MENU_BTN, "Pricing Menu", "", "");
			//Click on Price Rules Maintenance.
			wc.setTimeOut(3);
			wc.webActions("Click on Pricing Rules Maintenance","click", "xpath",pm.HOME_PRICINGRULESMAINTENANCE, "Pricing Rules Maintenance", "", "");
			//Switch to a different frame
			wc.switchToSpecifiedFrame("xpath",pci.PCI_SWITCH_FRAME_XPATH);
			//Navigate to Price Rules Enquiry
			pe.pricingRules_Enquiry();
			//Select the User Defined Code
			hr.writeStepInformation("Step 3 : Select the Price Level Code");
			pe.pricingRules_SelectUserDefinedCode("010");
			//Switch to the parent frame.
			wc.switchToParentFrame();
			//Switch to the specified frame
			wc.switchToSpecifiedFrame("xpath",pci.PCI_SWITCH_FRAME_XPATH);
			//Get the Batch Number
			hr.writeStepInformation("Step 4 : Get the Batch Number");
			String batchNumber=wc.returnTextFromValueAttribute("Get the Batch Number", "xpath", pe.PR_BATCHNUM, "Batch Number is populated");
			//Set up the price Level Dates
			hr.writeStepInformation("Step 5 : Enter the Effective Date,Termination Date,Item Number,Rule Type and Percentage Information in the Price Rule Setup Screen");
			pe.setValues_PriceRuleImportMaintenance(er.getCellData(filePath, "Global", "cRulesEffDate", 5), er.getCellData(filePath, "Global", "cRulesTermDate", 5), er.getCellData(filePath, "Global", "cItemNumber", 2),"F","125.0000",er.getCellData(filePath,"Global","cProdCat",2),"","","10");
			System.out.println(er.getCellData(filePath,"Global","cProdCat",2));
			//Set up the batch for the price Rule		
			pe.PR_WorkWithPriceRuleBatches(batchNumber);
			//Verify the batch Number is populated Correctly
			hr.writeStepInformation("Step 6 : Verify that the Batch Number is populated correctly");
			pe.verify_getBatchNumber(batchNumber);
			//navigate to the parent frame
			wc.switchToParentFrame();
			//Navigate to Pricing Rules Enquiry.
			//Click Navigator Button
			hr.writeStepInformation("Step 7 : Navigate to Pricing Enquiry Screen");
			wc.webActions("Click on Navigator Button","click","xpath",pm.HOME_NAVIGATOR_BTN_XPATH, "Navigator", "", "");
			//Click on Contracts,Pricing and Rebates.
			wc.webActions("Click on Contracts Pricing and Rebates","click", "xpath", pm.HOME_CONTRACTS_PRICING_REBATES_BTN, "Contracts Pricing and Rebates", "", "");
			// Click on Pricing Menu
			wc.webActions("Click on Pricing Menu","click", "xpath",pm.HOME_PRICING_MENU_BTN, "Pricing Menu", "", "");
			//Click on Pricing Enquiry Button.
			wc.setTimeOut(3);
			wc.webActions("Click on Pricing Inquiry Screen","click", "xpath",pm.HOME_PRICINGRULESINQUIRY, "Pricing Inquiry", "", "");
			//Switch to Specified frame.
			wc.switchToSpecifiedFrame("xpath",pci.PCI_SWITCH_FRAME_XPATH);
			//Get the Price Rule from the Pricing Inquiry Screen
			hr.writeStepInformation("Step 8 : Enter the Bill-To and Item Number Information in the Pricing Inquiry Screen");
			pe.PI_getPrice(er.getCellData(filePath, "Global", "cBillToCustomer", 2),er.getCellData(filePath, "Global", "cItemNumber", 2),er.getCellData(filePath, "Global", "cRulesEffDate", 5));
			//Verify the Price Rule
			hr.writeStepInformation("Step 9 : Verify the Price Rule is populated or not");
			pe.verify_PriceRule("10");
			
			
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



