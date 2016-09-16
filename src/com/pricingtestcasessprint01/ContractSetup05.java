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

import com.pompricing100.PricingContractSetup;
import com.pompricing100.PricingCustomerInformation;
import com.pompricing100.PricingLoginPage;
import com.pompricing100.PricingMenu;
import com.pompricing100.PricingPCCAMaintenance;
import com.pricingcommon.ExcelReader;
import com.pricingcommon.HTMLReport;
import com.pricingcommon.ProjectCommonMethods;
import com.pricingcommon.ReadObject;
import com.pricingcommon.WebControls;

public class ContractSetup05 {
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
    public void contractSetup05() throws Exception{
    	try{
    		//Classes Creation		
			WebControls wc = new WebControls();
			PricingLoginPage pl = new PricingLoginPage();	
			PricingMenu pm = new PricingMenu();
			ProjectCommonMethods pcm = new ProjectCommonMethods();
			PricingContractSetup pcs = new PricingContractSetup();
			ExcelReader er = new ExcelReader();		
			PricingCustomerInformation pci = new PricingCustomerInformation();	
			HTMLReport hr = new HTMLReport();
			
			//Store the filepath of the MasterSpread Sheet.
			String filePath =System.getProperty("user.dir") + "\\TestData\\MasterSpreadSheet.xls";
			//Login Into The Application
			hr.writeStepInformation("Step 1 : Login into Application");
			pl.login();
			//verify title
			hr.writeStepInformation("Step 2 : Navigate to Contracts Header Maintenance from the menu bar");			
			wc.verifyHomePageTitle("Verify home page title","xpath",pm.HOME_HOME_BTN_XPATH,"xpath",pm.HOME_TITLE_XPATH, "JD Edwards EnterpriseOne");
			//Click Navigator Button
			wc.webActions("Click on Navigator Button","click","xpath",pm.HOME_NAVIGATOR_BTN_XPATH, "Navigator", "", "");
			//Click on CAMS Button
			wc.webActions("Click on CAMS Button","click", "xpath", pm.HOME_CAMS_BTN, "CAMS Button", "", "");
			//Click on Contracts Administration Button.
			wc.webActions("Click on Contracts Administration Task","click", "xpath", pm.HOME_CONTRACTS_ADMIN_BTN, "Contracts Administration Task", "", "");
			//Click on Contracts Header Maintenance.
			wc.webActions("Click on Contracts Header Maintenance","click", "xpath", pm.HOME_CONTRACTS_HEADER_MAINT, "Contracts Header Maintenance", "", "");
			//Wait for three Seconds.
			wc.setTimeOut(3);
			//Switch the frame
			wc.switchToSpecifiedFrame("xpath",pci.PCI_SWITCH_FRAME_XPATH);
			//Click on Add Button.
			wc.webActions("Click on Add Button","click", "xpath", pm.HOME_ADD, "Add Button", "", "");
			//Get a six alphabet random string.
			String randAlpha = pcm.returnSixRandomAlphabets();
			//Enter Data to setup GPO Contract 
			hr.writeStepInformation("Step 3 : Enter Document Number,Manufacturer Number,Contract ID,Contract Name,GPO,Initial Recieved Date,Start Date,End Date Information");
			pcs.setupGPOContract("TestKart001",er.getCellData(filePath, "Global", "cMFGNumber", 2),randAlpha,"Price Level","GPO",er.getCellData(filePath, "Global", "cGPONumber", 2), er.getCellData(filePath, "Global", "cGpoMfgStartDate", 2), er.getCellData(filePath, "Global", "cGpoMfgStartDate", 2),er.getCellData(filePath, "Global", "cGpoMfgEndDate", 2));
			//Enter Tier1
			hr.writeStepInformation("Step 4 : Enter Tier1 field and Click on Save Field for GPO");
			wc.webActions("Enter the Text in Tier1 Field","settext", "xpath", pcs.CONTRACT_HEADER_MAINT_TIER1, "Tier1", "Tier 1", "");
			//Press Enter in Tier 1 Field
			wc.webActions("","enter", "xpath", pcs.CONTRACT_HEADER_MAINT_TIER1, "", "", "");
			//Wait for three seconds
			wc.setTimeOut(3);
			//click on Save Button
			wc.webActions("Click on Save Button","click", "xpath", pcs.CONTRACT_HEADER_MAINT_SAVE_BTN, "Save", "", "");
			//Wait for five seconds
			wc.setTimeOut(5);
			//Get the McKesson Contract ID
			hr.writeStepInformation("Step 5 : Get the McKesson GPO Contract ID");
			String mckContractIDGPO = wc.returnTextFromValueAttribute("Get the McKesson GPO Contract ID","xpath", pcs.CONTRACT_ITEM_MCKESSON_CONTRACTID, "McKesson Contract ID is ");
			//Set the McKesson COntract ID in the Master Spread Sheet.
			er.setCellData(filePath, "Global", "cMckGPOContractID", 2, mckContractIDGPO);
			//Enter the Item Number
			hr.writeStepInformation("Step 6 : Enter the Item Number Field");
			wc.webActions("Enter the Item Number","settext", "xpath", pcs.CONTRACT_ITEM_MAINT_ITEMNUMBER, "Item Number", er.getCellData(filePath, "Global", "cItemNumber", 2), "");
			//Press Enter in the Item Number Field.
			wc.webActions("","enter", "xpath", pcs.CONTRACT_ITEM_MAINT_ITEMNUMBER, "", "", "");
			wc.setTimeOut(6);
			//Get the Acquisition Cost
			String acqiCost = wc.returnTextFromValueAttribute("Get the Aquisition Cost","xpath",pcs.CONTRACT_ITEM_MAINT_PRICE, "Aquisition Cost");
			//Covert the Acquisition Cost from String to Double.
			double dacqiCost = Double.parseDouble(acqiCost);
			//Set the acqiCost in the Master Spread Sheet.
			er.setCellData(filePath, "Global", "cAcquisitionCost", 2, acqiCost);
			//Calculate the Contract Cost
			double dContCost = dacqiCost - 1;
			//Convert sContCost to String again
			String sContCost = Double.toString(dContCost);
			//Set the sContCost in the Master Spread Sheet.
			er.setCellData(filePath,"Global", "cCostReduction",2, sContCost);
			//Set the Priority UOM in the Master Spread Sheet.
			er.setCellData(filePath,"Global", "cPriUom",2,"EA");
			//Enter the Contract Cost and Aquisition Cost
			hr.writeStepInformation("Step 7 : Enter the Supplier *UM,Mck * UM,Supplier Contract Cost and Acquisition Cost");
			pcs.addItemNumberRecord("EA", "EA", dContCost, dacqiCost);
			//Enter the mckesson Contract ID
			pcs.customerEligibilityScreen(mckContractIDGPO);
			//Click on Add Button
			wc.webActions("Click on Add Button","click", "xpath", pcs.CONTRACT_SETUP_ADD_BUTTON, "Add", "", "");
			//Wait for seven Seconds.
			wc.setTimeOut(7);
			//Add Ship to
			pcs.addShipTo(randAlpha, er.getCellData(filePath, "Global", "cBillToCustomer", 2));
			//Verify whether the row got added or not
			wc.returnTextFromElement("Verify Record is added","xpath", pcs.CONTRACT_ITEM_VERIFY_REORD);
			//Click on Cancel Button
			wc.webActions("Click on Close Button","click", "xpath", "//*[@id='hc_Close']", "Close Button", "", "");
			//Wait for 3 seconds
			wc.setTimeOut(3);
			//Click on Cancel Button
			wc.webActions("Click on Close Button","click", "xpath", "//*[@id='hc_Close']", "Close Button", "", "");
			wc.setTimeOut(7);
			
			//Set up LOC Contract
			wc.switchToParentFrame();
			hr.writeStepInformation("Step 8 : Navigate to Contracts Header Maintenance from the menu bar");	
			//Click Navigator Button
			wc.webActions("Click on Navigator Button","click","xpath",pm.HOME_NAVIGATOR_BTN_XPATH, "Navigator", "", "");
			//Click on CAMS Button
			wc.webActions("Click on CAMS Button","click", "xpath", pm.HOME_CAMS_BTN, "CAMS Button", "", "");
			//Click on Contracts Administration Button.
			wc.webActions("Click on Contracts Administration Task","click", "xpath", pm.HOME_CONTRACTS_ADMIN_BTN, "Contracts Administration Task", "", "");
			//Click on Contracts Header Maintenance.
			wc.webActions("Click on Contracts Header Maintenance","click", "xpath", pm.HOME_CONTRACTS_HEADER_MAINT, "Contracts Header Maintenance", "", "");
			//Wait for three Seconds.
			wc.setTimeOut(3);
			//Switch the frame
			wc.switchToSpecifiedFrame("xpath",pci.PCI_SWITCH_FRAME_XPATH);
			//Click on Add Button.
			wc.webActions("Click on Add Button","click", "xpath", pm.HOME_ADD, "Add Button", "", "");
			//Get a six alphabet random string.
			wc.setTimeOut(3);			
			//Get a six alphabet random string.
			String randAlpha2 = pcm.returnSixRandomAlphabets();
			//Enter Data to setup LOC Contract 
			hr.writeStepInformation("Step 9 : Enter Document Number,Manufacturer Number,Contract ID,Contract Name,GPO,Initial Recieved Date,Start Date,End Date Information for LOC Contract");
			pcs.setupGPOContract("TestKart001",er.getCellData(filePath, "Global", "cMFGNumber", 2),randAlpha2,"Price Level", "LOC",er.getCellData(filePath, "Global", "cLPGID", 2), er.getCellData(filePath, "Global", "cLPGEffDate", 2), er.getCellData(filePath, "Global", "cLPGEffDate", 2),er.getCellData(filePath, "Global", "cLPGEndDate", 2));
			//Enter Tier1
			hr.writeStepInformation("Step 10 : Enter Tier1 field and Click on Save Field for LOC");
			wc.webActions("Enter Text in Tier 1 Field","settext", "xpath", pcs.CONTRACT_HEADER_MAINT_TIER1, "Tier1", "TEST FOR HIER 0910", "");
			//Press Enter in Tier 1 Field
			wc.webActions("","enter", "xpath", pcs.CONTRACT_HEADER_MAINT_TIER1, "", "", "");
			//Wait for three seconds
			wc.setTimeOut(3);
			//click on Save Button
			wc.webActions("Click Save","click", "xpath", pcs.CONTRACT_HEADER_MAINT_SAVE_BTN, "Save", "", "");
			//Wait for five seconds
			wc.setTimeOut(5);
			//Get the McKesson Contract ID
			hr.writeStepInformation("Step 11 : Get the McKesson LOC Contract ID");
			String mckContractIDLOC = wc.returnTextFromValueAttribute("Get the McKesson Contract ID","xpath", pcs.CONTRACT_ITEM_MCKESSON_CONTRACTID, "McKesson Contract ID is ");
			//Set the McKesson COntract ID in the Master Spread Sheet.
			er.setCellData(filePath, "Global", "cMcKLocalContractID", 2, mckContractIDLOC);
			//Enter the Item Number
			hr.writeStepInformation("Step 12 : Enter the Item Number Field");
			wc.webActions("Enter the Item Number","settext", "xpath", pcs.CONTRACT_ITEM_MAINT_ITEMNUMBER, "Item Number", er.getCellData(filePath, "Global", "cItemNumber", 2), "");
			//Press Enter in the Item Number Field.
			wc.webActions("","enter", "xpath", pcs.CONTRACT_ITEM_MAINT_ITEMNUMBER, "", "", "");
			wc.setTimeOut(6);
			//Get the Acquisition Cost
			String acqiCostLoc = wc.returnTextFromValueAttribute("Get the Aquisition Cost","xpath",pcs.CONTRACT_ITEM_MAINT_PRICE, "Aquisition Cost");
			//Covert the Acquisition Cost from String to Double.
			double dacqiCostLoc = Double.parseDouble(acqiCost);
			//Set the acqiCost in the Master Spread Sheet.
			er.setCellData(filePath, "Global", "cAcquisitionCost", 2, acqiCostLoc);
			//Calculate the Contract Cost
			double dContCostLoc = dacqiCostLoc - 1;
			//Convert sContCost to String again
			String sContCostLoc = Double.toString(dContCostLoc);
			//Set the sContCost in the Master Spread Sheet.
			er.setCellData(filePath,"Global", "cCostReduction",2, sContCostLoc);
			//Set the Priority UOM in the Master Spread Sheet.
			er.setCellData(filePath,"Global", "cPriUom",2,"EA");
			//Enter the Contract Cost and Aquisition Cost
			hr.writeStepInformation("Step 13 : Enter the Supplier *UM,Mck * UM,Supplier Contract Cost and Acquisition Cost");
			pcs.addItemNumberRecord("EA", "EA", dContCostLoc, dacqiCostLoc);
			//Enter the mckesson Contract ID
			pcs.customerEligibilityScreen(mckContractIDLOC);
			//Click on Add Button
			wc.webActions("Click Add Button","click", "xpath", pcs.CONTRACT_SETUP_ADD_BUTTON, "Add", "", "");
			//Wait for seven Seconds.
			wc.setTimeOut(7);
			//Add Ship to
			pcs.addShipTo(randAlpha, er.getCellData(filePath, "Global", "cBillToCustomer", 2));
			//Verify whether the row got added or not
			wc.returnTextFromElement("Verify Row is added","xpath", pcs.CONTRACT_ITEM_VERIFY_REORD);    		
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
